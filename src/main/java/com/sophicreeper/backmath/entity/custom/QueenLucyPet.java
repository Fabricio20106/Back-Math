package com.sophicreeper.backmath.entity.custom;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.misc.BMSounds;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.AbstractIllagerEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.*;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.ForgeEventFactory;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class QueenLucyPet extends TameableEntity {
    private static final DataParameter<Integer> VARIANT = EntityDataManager.createKey(QueenLucyPet.class, DataSerializers.VARINT);
    public static final Predicate<LivingEntity> TARGETS = (livEntity) -> {
        EntityType<?> type = livEntity.getType();
        return type == BMEntities.ANGRY_SOPHIE.get() || type == BMEntities.SHY_FABRICIO.get();
    };

    public QueenLucyPet(EntityType<QueenLucyPet> type, World world) {
        super(type, world);
        this.moveController = new FlyingMovementController(this, 10, false);
        this.setPathPriority(PathNodeType.DANGER_FIRE, -1);
        this.setPathPriority(PathNodeType.DAMAGE_FIRE, -1);
        this.setPathPriority(PathNodeType.COCOA, -1);
        this.setTamed(false);
    }

    public boolean isChild() {
        return false;
    }

    public void livingTick() {
        this.updateArmSwingProgress();
        if (this.world.getDifficulty() == Difficulty.PEACEFUL && this.world.getGameRules().getBoolean(GameRules.NATURAL_REGENERATION)) {
            if (this.getHealth() < this.getMaxHealth() && this.ticksExisted % 20 == 0) {
                this.heal(1);
            }
        }
        super.livingTick();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new SitGoal(this));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.2d, Ingredient.fromTag(BMTags.Items.QUEEN_LUCY_PET_TEMPT_ITEMS), false));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 2.1f, true));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.2f, 10, 2, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomFlyingGoal(this, 1));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8));
        this.goalSelector.addGoal(6, new LookAtGoal(this, QueenLucy.class, 8));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, LivingEntity.class ,10, false, false, (livEntity) -> livEntity.getType().isContained(BMTags.EntityTypes.QUEEN_LUCY_PET_TARGETS)));
        this.targetSelector.addGoal(3, new NonTamedTargetGoal<>(this, LivingEntity.class, false, TARGETS));
        super.registerGoals();
    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason spawnReason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        this.setVariant(this.rand.nextInt(18));
        if (spawnData == null) {
            spawnData = new AgeableEntity.AgeableData(false);
        }

        return super.onInitialSpawn(world, difficulty, spawnReason, spawnData, dataTag);
    }

    public void updateRidden() {
        super.updateRidden();
        if (this.getRidingEntity() instanceof CreatureEntity) {
            CreatureEntity entity = (CreatureEntity) this.getRidingEntity();
            this.renderYawOffset = entity.renderYawOffset;
        }
    }

    public boolean onLivingFall(float distance, float damageMultiplier) {
        return false;
    }

    protected void updateFallState(double y, boolean isOnGround, BlockState state, BlockPos pos) {}

    public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
        ItemStack heldItem = player.getHeldItem(hand);
        if (!this.isTamed() && heldItem.getItem().isIn(BMTags.Items.QUEEN_LUCY_PET_TAME_ITEMS)) {
            if (!player.abilities.isCreativeMode) {
                heldItem.shrink(1);
            }

            if (!this.world.isRemote) {
                if (this.rand.nextInt(10) == 0 && !ForgeEventFactory.onAnimalTame(this, player)) {
                    this.setTamedBy(player);
                    this.world.setEntityState(this, (byte) 7);
                } else {
                    this.world.setEntityState(this, (byte) 6);
                }
            }

            return ActionResultType.func_233537_a_(this.world.isRemote);
        } else if (heldItem.getItem().isIn(BMTags.Items.QUEEN_LUCY_PET_DEADLY_ITEMS)) {
            if (!player.abilities.isCreativeMode) {
                heldItem.shrink(1);
            }

            this.addPotionEffect(new EffectInstance(Effects.POISON, 900));
            if (player.isCreative() || !this.isInvulnerable()) {
                this.attackEntityFrom(DamageSource.causePlayerDamage(player), Float.MAX_VALUE);
            }

            return ActionResultType.func_233537_a_(this.world.isRemote);
        } else if (!this.isFlying() && this.isTamed() && this.isOwner(player)) {
            if (!this.world.isRemote) {
                this.func_233687_w_(!this.isSitting());
                displaySittingMessage(player, this.isSitting());
            }

            return ActionResultType.func_233537_a_(this.world.isRemote);
        } else {
            return super.func_230254_b_(player, hand);
        }
    }

    public void displaySittingMessage(PlayerEntity player, boolean isSitting) {
        if (isSitting && player instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
            serverPlayer.func_241151_a_(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".queen_lucy_pet.sit_down", this.getName()), ChatType.GAME_INFO, Util.DUMMY_UUID);
        } else if (!isSitting && player instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
            serverPlayer.func_241151_a_(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".queen_lucy_pet.stand_up", this.getName()), ChatType.GAME_INFO, Util.DUMMY_UUID);
        }
    }

    protected PathNavigator createNavigator(World world) {
        FlyingPathNavigator flyingPathNavigator = new FlyingPathNavigator(this, world);
        flyingPathNavigator.setCanOpenDoors(true);
        flyingPathNavigator.setCanSwim(true);
        flyingPathNavigator.setCanEnterDoors(true);
        return flyingPathNavigator;
    }

    @Override
    protected float getStandingEyeHeight(Pose pose, EntitySize size) {
        return 0.81f;
    }

    public boolean canMateWith(AnimalEntity otherQLP) {
        return false;
    }

    public static AttributeModifierMap.MutableAttribute createQueenLucyPetAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3f)
                .createMutableAttribute(Attributes.MAX_HEALTH, 350)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 17)
                .createMutableAttribute(Attributes.FLYING_SPEED, 0.4f);
    }

    @Nullable
    @Override
    public QueenLucyPet func_241840_a(ServerWorld world, AgeableEntity ageableEntity) {
        return null;
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

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AxolotlTest.QUEEN_SOPHIE_SUMMONER_STAFF.get());
    }

    public int getVariant() {
        return MathHelper.clamp(this.dataManager.get(VARIANT), 0, 17);
    }

    public void setVariant(int variant) {
        this.dataManager.set(VARIANT, variant);
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(VARIANT, 0);
    }

    public void writeAdditional(CompoundNBT tag) {
        super.writeAdditional(tag);
        tag.putInt("Variant", this.getVariant());
    }

    public void readAdditional(CompoundNBT tag) {
        super.readAdditional(tag);
        this.setVariant(tag.getInt("Variant"));
    }

    public boolean isFlying() {
        return !this.onGround;
    }
}
