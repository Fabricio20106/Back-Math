package com.sophicreeper.backmath.core.world.entity.tameable;

import com.google.common.collect.Sets;
import com.sophicreeper.backmath.core.world.entity.BMEntities;
import com.sophicreeper.backmath.core.world.entity.monster.*;
import com.sophicreeper.backmath.core.world.entity.monster.aljan.*;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.ForgeEventFactory;

import javax.annotation.Nullable;
import java.util.Set;
import java.util.function.Predicate;

public class QueenSophiePet extends TameableEntity {
    private static final DataParameter<Integer> VARIANT = EntityDataManager.createKey(QueenSophiePet.class, DataSerializers.VARINT);
    public static final Predicate<LivingEntity> TARGETS = (p_213440_0_) -> {
        EntityType<?> type = p_213440_0_.getType();
        return type == BMEntities.ANGRY_SOPHIE.get() || type == BMEntities.SHY_FABRICIO.get();
    };
    private static final Set<Item> TAME_ITEMS = Sets.newHashSet(AxolotlTest.GUARANA.get(), AxolotlTest.MANGO.get(), AxolotlTest.GRAPES.get(), AxolotlTest.LEMON.get(), AxolotlTest.PINEAPPLE.get(), AxolotlTest.ORANGE.get(), AxolotlTest.BANANA.get(), AxolotlTest.GUAVA.get(), AxolotlTest.JABUTICABA.get(), AxolotlTest.ALJAMIC_BERRY.get());
    public static final Item DEADLY_ITEM = AxolotlTest.ALJAME.get();

    public QueenSophiePet(EntityType<QueenSophiePet> type, World worldIn) {
        super(type, worldIn);
        this.moveController = new FlyingMovementController(this, 10, false);
        this.setPathPriority(PathNodeType.DANGER_FIRE, -1.0F);
        this.setPathPriority(PathNodeType.DAMAGE_FIRE, -1.0F);
        this.setPathPriority(PathNodeType.COCOA, -1.0F);
        this.setTamed(false);
    }

    public boolean isChild() {
        return false;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new SitGoal(this));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.2d, Ingredient.fromStacks(new ItemStack(AxolotlTest.GUARANA.get()), new ItemStack(Items.CAKE)), false));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 2.1f, true));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.2f, 10.0f, 2.0f, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomFlyingGoal(this, 1.0d));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.addGoal(6, new LookAtGoal(this, QueenSophie.class, 8.0f));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AngrySophie.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, InsomniaSophie.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ArcherInsomniaSophie.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, WarriorSophie.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ArcherLucia.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Janticle.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombieEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, InsomniaZombie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombieFabricio.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AljamicBones.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SleepishSkeleton.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Amaracameler.class, true));
        this.targetSelector.addGoal(3, new NonTamedTargetGoal<>(this, ZombieEntity.class, false, TARGETS));
        super.registerGoals();
    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.setVariant(this.rand.nextInt(18));
        if (spawnDataIn == null) {
            spawnDataIn = new AgeableEntity.AgeableData(false);
        }

        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    public boolean onLivingFall(float distance, float damageMultiplier) {
        return false;
    }

    protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {}

    public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
        ItemStack heldItem = player.getHeldItem(hand);
        if (!this.isTamed() && TAME_ITEMS.contains(heldItem.getItem())) {
            if (!player.abilities.isCreativeMode) {
                heldItem.shrink(1);
            }

            if (!this.world.isRemote) {
                if (this.rand.nextInt(10) == 0 && !ForgeEventFactory.onAnimalTame(this, player)) {
                    this.setTamedBy(player);
                    this.world.setEntityState(this, (byte)7);
                } else {
                    this.world.setEntityState(this, (byte)6);
                }
            }

            return ActionResultType.func_233537_a_(this.world.isRemote);
        } else if (heldItem.getItem() == DEADLY_ITEM) {
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
            }

            return ActionResultType.func_233537_a_(this.world.isRemote);
        } else {
            return super.func_230254_b_(player, hand);
        }
    }

    protected PathNavigator createNavigator(World worldIn) {
        FlyingPathNavigator flyingPathNavigator = new FlyingPathNavigator(this, worldIn);
        flyingPathNavigator.setCanOpenDoors(true);
        flyingPathNavigator.setCanSwim(true);
        flyingPathNavigator.setCanEnterDoors(true);
        return flyingPathNavigator;
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.81f;
    }

    public boolean canMateWith(AnimalEntity otherQSP) {
        return false;
    }

    public static AttributeModifierMap.MutableAttribute createQueenSophiePetAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3f)
                .createMutableAttribute(Attributes.MAX_HEALTH, 350.0f)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 17.0d)
                .createMutableAttribute(Attributes.FLYING_SPEED, 0.4f);
    }

    @Nullable
    @Override
    public QueenSophiePet func_241840_a(ServerWorld world, AgeableEntity ageableEntity) {
        return null;
    }

    public int getVariant() {
        return MathHelper.clamp(this.dataManager.get(VARIANT), 0, 17);
    }

    public void setVariant(int variantIn) {
        this.dataManager.set(VARIANT, variantIn);
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(VARIANT, 0);
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("Variant", this.getVariant());
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setVariant(compound.getInt("Variant"));
    }

    public boolean isFlying() {
        return !this.onGround;
    }
}
