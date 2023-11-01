package com.sophicreeper.backmath.entity.custom;

import com.sophicreeper.backmath.item.AxolotlTest;
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
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.*;

import javax.annotation.Nullable;

public class WandererSophie extends CreatureEntity {
    private static final DataParameter<Integer> VARIANT = EntityDataManager.createKey(WandererSophie.class, DataSerializers.VARINT);

    public WandererSophie(EntityType<WandererSophie> type, World world) {
        super(type, world);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(VARIANT, 0);
    }

    public void livingTick() {
        this.updateArmSwingProgress();

        if (this.world.getDifficulty() == Difficulty.PEACEFUL && this.world.getGameRules().getBoolean(GameRules.NATURAL_REGENERATION)) {
            if (this.getHealth() < this.getMaxHealth() && this.ticksExisted % 20 == 0) {
                this.heal(1.0F);
            }
        }
        super.livingTick();
    }

    public double getYOffset() {
        return -0.35D;
    }

    public void writeAdditional(CompoundNBT compoundNBT) {
        super.writeAdditional(compoundNBT);
        compoundNBT.putInt("Variant", this.getVariant());
    }

    public void readAdditional(CompoundNBT compoundNBT) {
        super.readAdditional(compoundNBT);
        this.setVariant(compoundNBT.getInt("Variant"));
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
        } else return entity instanceof ArcherLucia || entity instanceof WandererSophie || entity instanceof KarateLucia || entity instanceof InsomniaSophie;
        //this.getTeam() == null && entity.getTeam() == null;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.1D, Ingredient.fromItems(AxolotlTest.MILKLLARY_CAKE.get()), false));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
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
        // Old wanderer Sophie health was 70.0D.
        // Old new wanderer Sophie health was 35.0d.
        return CreatureEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 0.25F)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 12.0D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23F);
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
        }
    }

    /**
     * If this mob can be leashed to
     * @return If this mob can be leashed to
     */
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
}
