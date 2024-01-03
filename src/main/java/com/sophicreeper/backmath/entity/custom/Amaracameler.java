package com.sophicreeper.backmath.entity.custom;

import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.misc.BMSounds;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class Amaracameler extends MobEntity implements IMob {
    private static final DataParameter<Integer> AMARACAMELER_SIZE = EntityDataManager.createKey(Amaracameler.class, DataSerializers.VARINT);
    public float squishAmount;
    public float squishFactor;
    public float prevSquishFactor;
    private boolean wasOnGround;

    public Amaracameler(EntityType<Amaracameler> entity, World world) {
        super(entity, world);
        this.moveController = new MoveHelperController(this);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new Amaracameler.FloatGoal(this));
        this.goalSelector.addGoal(2, new Amaracameler.AttackGoal(this));
        this.goalSelector.addGoal(3, new Amaracameler.FaceRandomGoal(this));
        this.goalSelector.addGoal(5, new Amaracameler.HopGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, (livEntity) -> Math.abs(livEntity.getPosY() - this.getPosY()) <= 4));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Malaika.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Malaika.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ShyFabricio.class, 10, true, false, (livEntity) -> Math.abs(livEntity.getPosY() - this.getPosY()) <= 4));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(AMARACAMELER_SIZE, 1);
    }

    protected void setAmaracamelerSize(int size, boolean resetHealth) {
        this.dataManager.set(AMARACAMELER_SIZE, size);
        this.recenterBoundingBox();
        this.recalculateSize();
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(size * size);
        this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.2F + 0.1F * (float) size);
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(size);
        if (resetHealth) {
            this.setHealth(this.getMaxHealth());
        }

        this.experienceValue = size;
    }

    // Returns the size of the amaracameler.
    public int getAmaracamelerSize() {
        return this.dataManager.get(AMARACAMELER_SIZE);
    }

    public void writeAdditional(CompoundNBT compoundNBT) {
        super.writeAdditional(compoundNBT);
        compoundNBT.putInt("Size", this.getAmaracamelerSize() - 1);
        compoundNBT.putBoolean("wasOnGround", this.wasOnGround);
    }

    // (abstract) Protected helper method to read subclass entity data from NBT.
    public void readAdditional(CompoundNBT compoundNBT) {
        int sizeNBT = compoundNBT.getInt("Size");
        if (sizeNBT < 0) {
            sizeNBT = 0;
        }

        this.setAmaracamelerSize(sizeNBT + 1, false);
        super.readAdditional(compoundNBT);
        this.wasOnGround = compoundNBT.getBoolean("wasOnGround");
    }

    public boolean isSmallAmaracameler() {
        return this.getAmaracamelerSize() <= 1;
    }

    protected IParticleData getSquishParticle() {
        return new ItemParticleData(ParticleTypes.ITEM, new ItemStack(AxolotlTest.STICKY_AMARACAMEL_BLOCK.get()));
    }

    protected boolean isDespawnPeaceful() {
        return this.getAmaracamelerSize() > 0;
    }

    // Called to update the entity's position/logic.
    public void tick() {
        this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
        this.prevSquishFactor = this.squishFactor;
        super.tick();
        if (this.onGround && !this.wasOnGround) {
            int amaracamelerSize = this.getAmaracamelerSize();

            if (spawnCustomParticles()) amaracamelerSize = 0; // Don't spawn particles if it's handled by the implementation itself.
            for(int j = 0; j < amaracamelerSize * 8; ++j) {
                float f = this.rand.nextFloat() * ((float) Math.PI * 2F);
                float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
                float f2 = MathHelper.sin(f) * (float) amaracamelerSize * 0.5F * f1;
                float f3 = MathHelper.cos(f) * (float) amaracamelerSize * 0.5F * f1;
                this.world.addParticle(this.getSquishParticle(), this.getPosX() + (double) f2, this.getPosY(), this.getPosZ() + (double) f3, 0, 0, 0);
            }

            this.playSound(this.getSquishSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1) / 0.8F);
            this.squishAmount = -0.5F;
        } else if (!this.onGround && this.wasOnGround) {
            this.squishAmount = 1;
        }

        this.wasOnGround = this.onGround;
        this.alterSquishAmount();
    }

    protected void alterSquishAmount() {
        this.squishAmount *= 0.6F;
    }

    // Gets the amount of time the amaracameler needs to wait between jumps.
    protected int getJumpDelay() {
        return this.rand.nextInt(20) + 10;
    }

    public void recalculateSize() {
        double d0 = this.getPosX();
        double d1 = this.getPosY();
        double d2 = this.getPosZ();
        super.recalculateSize();
        this.setPosition(d0, d1, d2);
    }

    public void notifyDataManagerChange(DataParameter<?> key) {
        if (AMARACAMELER_SIZE.equals(key)) {
            this.recalculateSize();
            this.rotationYaw = this.rotationYawHead;
            this.renderYawOffset = this.rotationYawHead;
            if (this.isInWater() && this.rand.nextInt(20) == 0) {
                this.doWaterSplashEffect();
            }
        }

        super.notifyDataManagerChange(key);
    }

    public EntityType<? extends Amaracameler> getType() {
        return (EntityType<? extends Amaracameler>) super.getType();
    }

    @Override
    public void remove(boolean keepData) {
        int slimeSize = this.getAmaracamelerSize();
        if (!this.world.isRemote && slimeSize > 1 && this.getShouldBeDead() && !this.removed) {
            ITextComponent amaracamelerName = this.getCustomName();
            boolean flag = this.isAIDisabled();
            float amaracamelerSizeFourth = (float) slimeSize / 4;
            int amaracamelerSizeHalved = slimeSize / 2;
            int k = 2 + this.rand.nextInt(3);

            for(int l = 0; l < k; ++l) {
                float f1 = ((float) (l % 2) - 0.5F) * amaracamelerSizeFourth;
                float f2 = ((float) (l / 2) - 0.5F) * amaracamelerSizeFourth;
                Amaracameler amaracameler = this.getType().create(this.world);
                if (this.isNoDespawnRequired()) {
                    amaracameler.enablePersistence();
                }

                amaracameler.setCustomName(amaracamelerName);
                amaracameler.setNoAI(flag);
                amaracameler.setInvulnerable(this.isInvulnerable());
                amaracameler.setAmaracamelerSize(amaracamelerSizeHalved, true);
                amaracameler.setLocationAndAngles(this.getPosX() + (double) f1, this.getPosY() + 0.5D, this.getPosZ() + (double) f2, this.rand.nextFloat() * 360, 0);
                this.world.addEntity(amaracameler);
            }
        }

        super.remove(keepData);
    }

    // Applies a velocity to the entities, to push them away from each other.
    public void applyEntityCollision(Entity entity) {
        super.applyEntityCollision(entity);
        if (entity instanceof IronGolemEntity && this.canDamagePlayer()) {
            this.dealDamage((LivingEntity)entity);
        }
    }

    // Called by a player entity when they collide with an entity.
    public void onCollideWithPlayer(PlayerEntity player) {
        if (this.canDamagePlayer()) {
            this.dealDamage(player);
        }
    }

    protected void dealDamage(LivingEntity livEntity) {
        if (this.isAlive()) {
            int amaracamelerSize = this.getAmaracamelerSize();
            if (this.getDistanceSq(livEntity) < 0.6D * (double) amaracamelerSize * 0.6D * (double) amaracamelerSize && this.canEntityBeSeen(livEntity) && livEntity.attackEntityFrom(DamageSource.causeMobDamage(this), this.func_225512_er_())) {
                this.playSound(BMSounds.ENTITY_AMARACAMELER_ATTACK, 1, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1);
                this.applyEnchantments(this, livEntity);
            }
        }
    }

    protected float getStandingEyeHeight(Pose pose, EntitySize size) {
        return 0.625F * size.height;
    }

    // Indicates weather the amaracameler is able to damage the player (based upon the amaracameler's size).
    protected boolean canDamagePlayer() {
        return !this.isSmallAmaracameler() && this.isServerWorld();
    }

    protected float func_225512_er_() {
        return (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return this.isSmallAmaracameler() ? BMSounds.ENTITY_AMARACAMELER_HURT_SMALL : BMSounds.ENTITY_AMARACAMELER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return this.isSmallAmaracameler() ? BMSounds.ENTITY_AMARACAMELER_DEATH_SMALL : BMSounds.ENTITY_AMARACAMELER_DEATH;
    }

    protected SoundEvent getSquishSound() {
        return this.isSmallAmaracameler() ? BMSounds.ENTITY_AMARACAMELER_SQUISH_SMALL : BMSounds.ENTITY_AMARACAMELER_SQUISH;
    }

    protected ResourceLocation getLootTable() {
        return this.getAmaracamelerSize() == 1 ? this.getType().getLootTable() : LootTables.EMPTY;
    }

    // Returns the volume for the sounds this mob makes.
    protected float getSoundVolume() {
        return 0.4F * (float) this.getAmaracamelerSize();
    }

    // The speed it takes to move the livingEntity's rotationPitch through the faceEntity method. This is only currently use in wolves.
    public int getVerticalFaceSpeed() {
        return 0;
    }

    // Returns true if the amaracameler makes a sound when it jumps (based upon the amaracameler's size).
    protected boolean makesSoundOnJump() {
        return this.getAmaracamelerSize() > 0;
    }

    // Causes this entity to do an upwards motion (jumping).
    protected void jump() {
        Vector3d vec3D = this.getMotion();
        this.setMotion(vec3D.x, this.getJumpUpwardsMotion(), vec3D.z);
        this.isAirBorne = true;
    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason spawnReason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        int randInt = this.rand.nextInt(3);
        if (randInt < 2 && this.rand.nextFloat() < 0.5F * difficulty.getClampedAdditionalDifficulty()) {
            ++randInt;
        }

        int j = 1 << randInt;
        this.setAmaracamelerSize(j, true);
        return super.onInitialSpawn(world, difficulty, spawnReason, spawnData, dataTag);
    }

    private float func_234304_m_() {
        float amaracamelerSize = this.isSmallAmaracameler() ? 1.4F : 0.8F;
        return ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1) * amaracamelerSize;
    }

    protected SoundEvent getJumpSound() {
        return this.isSmallAmaracameler() ? BMSounds.ENTITY_AMARACAMELER_JUMP_SMALL : BMSounds.ENTITY_AMARACAMELER_JUMP;
    }

    public EntitySize getSize(Pose pose) {
        return super.getSize(pose).scale(0.255F * (float)this.getAmaracamelerSize());
    }

    // Called when the amaracameler spawns particles on landing, see onUpdate.
    // Return true to prevent the spawning of the default particles.
    protected boolean spawnCustomParticles() {
        return false;
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AxolotlTest.AMARACAMELER_SPAWN_EGG.get());
    }

    public static class AttackGoal extends Goal {
        private final Amaracameler amaracameler;
        private int growTieredTimer;

        public AttackGoal(Amaracameler amaracameler) {
            this.amaracameler = amaracameler;
            this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK));
        }

        // Returns whether execution should begin. You can also read and cache any state necessary for execution in this method as well.
        public boolean shouldExecute() {
            LivingEntity target = this.amaracameler.getAttackTarget();
            if (target == null) {
                return false;
            } else if (!target.isAlive()) {
                return false;
            } else {
                return (!(target instanceof PlayerEntity) || !((PlayerEntity) target).abilities.disableDamage) && this.amaracameler.getMoveHelper() instanceof Amaracameler.MoveHelperController;
            }
        }

        // Execute a one shot task or start executing a continuous task.
        public void startExecuting() {
            this.growTieredTimer = 300;
            super.startExecuting();
        }

        // Returns whether an in-progress EntityAIBase should continue executing.
        public boolean shouldContinueExecuting() {
            LivingEntity target = this.amaracameler.getAttackTarget();
            if (target == null) {
                return false;
            } else if (!target.isAlive()) {
                return false;
            } else if (target instanceof PlayerEntity && ((PlayerEntity) target).abilities.disableDamage) {
                return false;
            } else {
                return --this.growTieredTimer > 0;
            }
        }

        // Keep ticking a continuous task that has already been started.
        public void tick() {
            this.amaracameler.faceEntity(this.amaracameler.getAttackTarget(), 10, 10);
            ((MoveHelperController) this.amaracameler.getMoveHelper()).setDirection(this.amaracameler.rotationYaw, this.amaracameler.canDamagePlayer());
        }
    }

    public static class FaceRandomGoal extends Goal {
        private final Amaracameler amaracameler;
        private float chosenDegrees;
        private int nextRandomizeTime;

        public FaceRandomGoal(Amaracameler amaracameler) {
            this.amaracameler = amaracameler;
            this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK));
        }

        // Returns whether execution should begin. You can also read and cache any state necessary for execution in this method as well.
        public boolean shouldExecute() {
            return this.amaracameler.getAttackTarget() == null && (this.amaracameler.onGround || this.amaracameler.isInWater() || this.amaracameler.isInLava() || this.amaracameler.isPotionActive(Effects.LEVITATION)) && this.amaracameler.getMoveHelper() instanceof MoveHelperController;
        }

        // Keep ticking a continuous task that has already been started.
        public void tick() {
            if (--this.nextRandomizeTime <= 0) {
                this.nextRandomizeTime = 40 + this.amaracameler.getRNG().nextInt(60);
                this.chosenDegrees = (float)this.amaracameler.getRNG().nextInt(360);
            }

            ((MoveHelperController) this.amaracameler.getMoveHelper()).setDirection(this.chosenDegrees, false);
        }
    }

    public static class FloatGoal extends Goal {
        private final Amaracameler amaracameler;

        public FloatGoal(Amaracameler amaracameler) {
            this.amaracameler = amaracameler;
            this.setMutexFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
            amaracameler.getNavigator().setCanSwim(true);
        }

        // Returns whether execution should begin. You can also read and cache any state necessary for execution in this method as well.
        public boolean shouldExecute() {
            return (this.amaracameler.isInWater() || this.amaracameler.isInLava()) && this.amaracameler.getMoveHelper() instanceof MoveHelperController;
        }

        // Keep ticking a continuous task that has already been started.
        public void tick() {
            if (this.amaracameler.getRNG().nextFloat() < 0.8F) {
                this.amaracameler.getJumpController().setJumping();
            }

            ((MoveHelperController) this.amaracameler.getMoveHelper()).setSpeed(1.2D);
        }
    }

    public static class HopGoal extends Goal {
        private final Amaracameler amaracameler;

        public HopGoal(Amaracameler amaracameler) {
            this.amaracameler = amaracameler;
            this.setMutexFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
        }

        // Returns whether execution should begin. You can also read and cache any state necessary for execution in this method as well.
        public boolean shouldExecute() {
            return !this.amaracameler.isPassenger();
        }

        // Keep ticking a continuous task that has already been started.
        public void tick() {
            ((MoveHelperController) this.amaracameler.getMoveHelper()).setSpeed(1);
        }
    }

    public static class MoveHelperController extends MovementController {
        private float yRot;
        private int jumpDelay;
        private final Amaracameler amaracameler;
        private boolean isAggressive;

        public MoveHelperController(Amaracameler amaracameler) {
            super(amaracameler);
            this.amaracameler = amaracameler;
            this.yRot = 180 * amaracameler.rotationYaw / (float) Math.PI;
        }

        public void setDirection(float yRotation, boolean aggressive) {
            this.yRot = yRotation;
            this.isAggressive = aggressive;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
            this.action = MovementController.Action.MOVE_TO;
        }

        public void tick() {
            this.mob.rotationYaw = this.limitAngle(this.mob.rotationYaw, this.yRot, 90);
            this.mob.rotationYawHead = this.mob.rotationYaw;
            this.mob.renderYawOffset = this.mob.rotationYaw;
            if (this.action != MovementController.Action.MOVE_TO) {
                this.mob.setMoveForward(0);
            } else {
                this.action = MovementController.Action.WAIT;
                if (this.mob.isOnGround()) {
                    this.mob.setAIMoveSpeed((float) (this.speed * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                    if (this.jumpDelay-- <= 0) {
                        this.jumpDelay = this.amaracameler.getJumpDelay();
                        if (this.isAggressive) {
                            this.jumpDelay /= 3;
                        }

                        this.amaracameler.getJumpController().setJumping();
                        if (this.amaracameler.makesSoundOnJump()) {
                            this.amaracameler.playSound(this.amaracameler.getJumpSound(), this.amaracameler.getSoundVolume(), this.amaracameler.func_234304_m_());
                        }
                    } else {
                        this.amaracameler.moveStrafing = 0;
                        this.amaracameler.moveForward = 0;
                        this.mob.setAIMoveSpeed(0);
                    }
                } else {
                    this.mob.setAIMoveSpeed((float) (this.speed * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                }
            }
        }
    }
}
