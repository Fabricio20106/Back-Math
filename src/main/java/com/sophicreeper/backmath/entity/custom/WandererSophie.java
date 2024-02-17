package com.sophicreeper.backmath.entity.custom;

import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.misc.BMSounds;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.*;

import javax.annotation.Nullable;
import java.util.Random;

public class WandererSophie extends CreatureEntity implements ISophieFriendlies {
    private static final DataParameter<Integer> VARIANT = EntityDataManager.createKey(WandererSophie.class, DataSerializers.VARINT);
    public double prevChasingPosX;
    public double prevChasingPosY;
    public double prevChasingPosZ;
    public double chasingPosX;
    public double chasingPosY;
    public double chasingPosZ;
    public float prevCameraYaw;
    public float cameraYaw;

    public WandererSophie(EntityType<WandererSophie> type, World world) {
        super(type, world);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(VARIANT, 0);
    }

    @Override
    public void tick() {
        super.tick();
        this.updateCape();
        this.updateEffectHelmet(this, BMTags.Items.PROVIDES_WATER_BREATHING, Effects.WATER_BREATHING);
        this.updateEffectHelmet(this, BMTags.Items.PROVIDES_RESISTANCE, Effects.RESISTANCE);
    }

    public void livingTick() {
        this.updateArmSwingProgress();

        this.prevCameraYaw = this.cameraYaw;

        float f;
        if (this.onGround && !this.getShouldBeDead() && !this.isSwimming()) {
            f = Math.min(0.1F, MathHelper.sqrt(horizontalMag(this.getMotion())));
        } else {
            f = 0;
        }
        this.cameraYaw += (f - this.cameraYaw) * 0.4F;

        if (this.world.getDifficulty() == Difficulty.PEACEFUL && this.world.getGameRules().getBoolean(GameRules.NATURAL_REGENERATION)) {
            if (this.getHealth() < this.getMaxHealth() && this.ticksExisted % 20 == 0) {
                this.heal(1);
            }
        }
        super.livingTick();
    }

    public double getYOffset() {
        return -0.35D;
    }

    public void writeAdditional(CompoundNBT tag) {
        super.writeAdditional(tag);
        tag.putInt("Variant", this.getVariant());
        // tag.putBoolean("CustomNameVisible", true);
    }

    public void readAdditional(CompoundNBT tag) {
        super.readAdditional(tag);
        this.setVariant(tag.getInt("Variant"));
        // this.setCustomNameVisible(tag.getBoolean("CustomNameVisible"));
    }

    public int getVariant() {
        return MathHelper.clamp(this.dataManager.get(VARIANT), 0, 11);
    }

    public void setVariant(int variant) {
        this.dataManager.set(VARIANT, variant);
    }

    public boolean isOnSameTeam(Entity entity) {
        if (super.isOnSameTeam(entity)) {
            return true;
        } else return entity instanceof ISophieFriendlies;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new TemptGoal(this, 1.1D, Ingredient.fromTag(BMTags.Items.WANDERER_SOPHIE_TEMPT_ITEMS), false));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 6));
        this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
        this.applyEntityAI();
        super.registerGoals();
    }

    protected void applyEntityAI() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AngrySophie.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Janticle.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombieEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, InsomniaZombie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombieFabricio.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AljamicBones.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SleepishSkeleton.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Amaracameler.class, true));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.1D, false));
    }

    public static AttributeModifierMap.MutableAttribute createWandererSophieAttributes() {
        // Old wanderer Sophie health was 70.
        // Old new wanderer Sophie health was 35.
        return CreatureEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 20).createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 0.25F).createMutableAttribute(Attributes.FOLLOW_RANGE, 12)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25F);
    }

    protected float getStandingEyeHeight(Pose pose, EntitySize size) {
        return 1.62F;
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        spawnData = super.onInitialSpawn(world, difficulty, reason, spawnData, dataTag);
        this.setVariant(this.rand.nextInt(12));
        this.setEnchantmentBasedOnDifficulty(difficulty);
        this.setEquipmentBasedOnDifficulty(difficulty);
        return spawnData;
    }

    public void updateRidden() {
        super.updateRidden();
        if (this.getRidingEntity() instanceof CreatureEntity) {
            CreatureEntity entity = (CreatureEntity) this.getRidingEntity();
            this.renderYawOffset = entity.renderYawOffset;
            this.prevCameraYaw = this.cameraYaw;
            this.cameraYaw = 0;
        }
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        if (source == DamageSource.ON_FIRE) {
            return BMSounds.ENTITY_SOPHIE_HURT_ON_FIRE;
        } else if (source == DamageSource.DROWN) {
            return BMSounds.ENTITY_SOPHIE_HURT_DROWN;
        } else {
            return source == DamageSource.SWEET_BERRY_BUSH ? BMSounds.ENTITY_SOPHIE_HURT_BERRY_BUSH : BMSounds.ENTITY_SOPHIE_HURT;
        }
    }

    protected SoundEvent getDeathSound() {
        return BMSounds.ENTITY_SOPHIE_DEATH;
    }

    private void updateCape() {
        this.prevChasingPosX = this.chasingPosX;
        this.prevChasingPosY = this.chasingPosY;
        this.prevChasingPosZ = this.chasingPosZ;
        double d0 = this.getPosX() - this.chasingPosX;
        double d1 = this.getPosY() - this.chasingPosY;
        double d2 = this.getPosZ() - this.chasingPosZ;

        if (d0 > 10) {
            this.chasingPosX = this.getPosX();
            this.prevChasingPosX = this.chasingPosX;
        }

        if (d2 > 10) {
            this.chasingPosZ = this.getPosZ();
            this.prevChasingPosZ = this.chasingPosZ;
        }

        if (d1 > 10) {
            this.chasingPosY = this.getPosY();
            this.prevChasingPosY = this.chasingPosY;
        }

        if (d0 < -10) {
            this.chasingPosX = this.getPosX();
            this.prevChasingPosX = this.chasingPosX;
        }

        if (d2 < -10) {
            this.chasingPosZ = this.getPosZ();
            this.prevChasingPosZ = this.chasingPosZ;
        }

        if (d1 < -10) {
            this.chasingPosY = this.getPosY();
            this.prevChasingPosY = this.chasingPosY;
        }

        this.chasingPosX += d0 * 0.25D;
        this.chasingPosZ += d2 * 0.25D;
        this.chasingPosY += d1 * 0.25D;
    }

    // If this mob can be leashed.
    // Returns: If this mob can be leashed.
    // Old Back Math shenanigans.
    @Override
    public boolean canBeLeashedTo(PlayerEntity player) {
        return false;
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AxolotlTest.WANDERER_SOPHIE_SPAWN_EGG.get());
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (entity instanceof LivingEntity && !entity.isInvulnerableTo(DamageSource.IN_FIRE)) {
            ItemStack devilSword = new ItemStack(AxolotlTest.DEVIL_SWORD.get());
            if (this.getItemStackFromSlot(EquipmentSlotType.MAINHAND).equals(devilSword)) {
                LivingEntity livEntity = (LivingEntity) entity;
                livEntity.setFire(5);
            }
        }
        return super.attackEntityAsMob(entity);
    }

    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        super.setEquipmentBasedOnDifficulty(difficulty);
        int i = this.rand.nextInt(3);
        if (i == 0) {
            // Variant 1: Angelic Sword, Angelic Chestplate and Cat Tiara
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.ANGELIC_SWORD.get()));
            this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.CAT_TIARA.get()));
            this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.ANGELIC_CHESTPLATE.get()));
        } else if (i == 1) {
            // Variant 2: Devil Sword, Devil Chestplate and Tito
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.DEVIL_SWORD.get()));
            this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.DEVIL_CHESTPLATE.get()));
            this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(AxolotlTest.TITO.get()));
        } else {
            // Variant 3: Hardened Amaracamel Helmet, Hardened Amaracamel Chestplate and Butter Sword
            this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.HARDENED_AMARACAMEL_HELMET.get()));
            this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.HARDENED_AMARACAMEL_CHESTPLATE.get()));
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.BUTTER_SWORD.get()));
        }
    }

    public static boolean canSophieSpawnOn(EntityType<? extends CreatureEntity> termianFriendly, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
        return world.getBlockState(pos.down()).isIn(BMTags.Blocks.SOPHIES_SPAWNABLE_ON) && world.getLightSubtracted(pos, 0) > 8;
    }
}
