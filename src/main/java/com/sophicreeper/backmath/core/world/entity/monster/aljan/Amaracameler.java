package com.sophicreeper.backmath.core.world.entity.monster.aljan;

import com.sophicreeper.backmath.core.config.BMConfigs;
import com.sophicreeper.backmath.core.world.entity.creature.ShyFabricio;
import com.sophicreeper.backmath.core.world.entity.creature.aljan.Malaika;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import com.sophicreeper.backmath.core.world.level.biome.BMBiomes;
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
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Random;

public class Amaracameler extends MobEntity implements IMob {
    private static final DataParameter<Integer> AMARACAMELER_SIZE = EntityDataManager.createKey(Amaracameler.class, DataSerializers.VARINT);
    public float squishAmount;
    public float squishFactor;
    public float prevSquishFactor;
    private boolean wasOnGround;

    public Amaracameler(EntityType<Amaracameler> entity, World world) {
        super(entity, world);
        this.moveController = new Amaracameler.MoveHelperController(this);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new Amaracameler.FloatGoal(this));
        this.goalSelector.addGoal(2, new Amaracameler.AttackGoal(this));
        this.goalSelector.addGoal(3, new Amaracameler.FaceRandomGoal(this));
        this.goalSelector.addGoal(5, new Amaracameler.HopGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, (p_213811_1_) -> Math.abs(p_213811_1_.getPosY() - this.getPosY()) <= 4.0D));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Malaika.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Malaika.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ShyFabricio.class, 10, true, false, (p_213811_1_) -> Math.abs(p_213811_1_.getPosY() - this.getPosY()) <= 4.0D));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(AMARACAMELER_SIZE, 1);
    }

    protected void setSlimeSize(int size, boolean resetHealth) {
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

    /**
     * Returns the size of the amaracameler.
     */
    public int getSlimeSize() {
        return this.dataManager.get(AMARACAMELER_SIZE);
    }

    public void writeAdditional(CompoundNBT compoundNBT) {
        super.writeAdditional(compoundNBT);
        compoundNBT.putInt("Size", this.getSlimeSize() - 1);
        compoundNBT.putBoolean("wasOnGround", this.wasOnGround);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditional(CompoundNBT compoundNBT) {
        int sizeNBT = compoundNBT.getInt("Size");
        if (sizeNBT < 0) {
            sizeNBT = 0;
        }

        this.setSlimeSize(sizeNBT + 1, false);
        super.readAdditional(compoundNBT);
        this.wasOnGround = compoundNBT.getBoolean("wasOnGround");
    }

    public boolean isSmallSlime() {
        return this.getSlimeSize() <= 1;
    }

    protected IParticleData getSquishParticle() {
        return new ItemParticleData(ParticleTypes.ITEM, new ItemStack(AxolotlTest.STICKY_AMARACAMEL_BLOCK.get()));
    }

    protected boolean isDespawnPeaceful() {
        return this.getSlimeSize() > 0;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void tick() {
        this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
        this.prevSquishFactor = this.squishFactor;
        super.tick();
        if (this.onGround && !this.wasOnGround) {
            int i = this.getSlimeSize();

            if (spawnCustomParticles()) i = 0; // Don't spawn particles if it's handled by the implementation itself
            for(int j = 0; j < i * 8; ++j) {
                float f = this.rand.nextFloat() * ((float)Math.PI * 2F);
                float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
                float f2 = MathHelper.sin(f) * (float)i * 0.5F * f1;
                float f3 = MathHelper.cos(f) * (float)i * 0.5F * f1;
                this.world.addParticle(this.getSquishParticle(), this.getPosX() + (double)f2, this.getPosY(), this.getPosZ() + (double)f3, 0.0D, 0.0D, 0.0D);
            }

            this.playSound(this.getSquishSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            this.squishAmount = -0.5F;
        } else if (!this.onGround && this.wasOnGround) {
            this.squishAmount = 1.0F;
        }

        this.wasOnGround = this.onGround;
        this.alterSquishAmount();
    }

    protected void alterSquishAmount() {
        this.squishAmount *= 0.6F;
    }

    /**
     * Gets the amount of time the amaracameler needs to wait between jumps.
     */
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
        int i = this.getSlimeSize();
        if (!this.world.isRemote && i > 1 && this.getShouldBeDead() && !this.removed) {
            ITextComponent component = this.getCustomName();
            boolean flag = this.isAIDisabled();
            float f = (float)i / 4.0F;
            int j = i / 2;
            int k = 2 + this.rand.nextInt(3);

            for(int l = 0; l < k; ++l) {
                float f1 = ((float)(l % 2) - 0.5F) * f;
                float f2 = ((float)(l / 2) - 0.5F) * f;
                Amaracameler amaracameler = this.getType().create(this.world);
                if (this.isNoDespawnRequired()) {
                    amaracameler.enablePersistence();
                }

                amaracameler.setCustomName(component);
                amaracameler.setNoAI(flag);
                amaracameler.setInvulnerable(this.isInvulnerable());
                amaracameler.setSlimeSize(j, true);
                amaracameler.setLocationAndAngles(this.getPosX() + (double)f1, this.getPosY() + 0.5D, this.getPosZ() + (double)f2, this.rand.nextFloat() * 360.0F, 0.0F);
                this.world.addEntity(amaracameler);
            }
        }

        super.remove(keepData);
    }

    /**
     * Applies a velocity to the entities, to push them away from eachother.
     */
    public void applyEntityCollision(Entity entity) {
        super.applyEntityCollision(entity);
        if (entity instanceof IronGolemEntity && this.canDamagePlayer()) {
            this.dealDamage((LivingEntity)entity);
        }
    }

    /**
     * Called by a player entity when they collide with an entity
     */
    public void onCollideWithPlayer(PlayerEntity player) {
        if (this.canDamagePlayer()) {
            this.dealDamage(player);
        }
    }

    protected void dealDamage(LivingEntity livingEntity) {
        if (this.isAlive()) {
            int i = this.getSlimeSize();
            if (this.getDistanceSq(livingEntity) < 0.6D * (double)i * 0.6D * (double)i && this.canEntityBeSeen(livingEntity) && livingEntity.attackEntityFrom(DamageSource.causeMobDamage(this), this.func_225512_er_())) {
                this.playSound(SoundEvents.ENTITY_SLIME_ATTACK, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
                this.applyEnchantments(this, livingEntity);
            }
        }
    }

    protected float getStandingEyeHeight(Pose pose, EntitySize size) {
        return 0.625F * size.height;
    }

    /**
     * Indicates weather the amaracameler is able to damage the player (based upon the amaracameler's size)
     */
    protected boolean canDamagePlayer() {
        return !this.isSmallSlime() && this.isServerWorld();
    }

    protected float func_225512_er_() {
        return (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return this.isSmallSlime() ? SoundEvents.ENTITY_SLIME_HURT_SMALL : SoundEvents.ENTITY_SLIME_HURT;
    }

    protected SoundEvent getDeathSound() {
        return this.isSmallSlime() ? SoundEvents.ENTITY_SLIME_DEATH_SMALL : SoundEvents.ENTITY_SLIME_DEATH;
    }

    protected SoundEvent getSquishSound() {
        return this.isSmallSlime() ? SoundEvents.ENTITY_SLIME_SQUISH_SMALL : SoundEvents.ENTITY_SLIME_SQUISH;
    }

    protected ResourceLocation getLootTable() {
        return this.getSlimeSize() == 1 ? this.getType().getLootTable() : LootTables.EMPTY;
    }

    public static boolean canSpawnAmaracamelerOn(EntityType<Amaracameler> entityType, IWorld world, SpawnReason spawnReason, BlockPos pos, Random rand) {
        if (world.getDifficulty() != Difficulty.PEACEFUL) {
            if (Objects.equals(world.getBiome(pos), BMBiomes.AMARACAMEL_STICKS.get()) && world.getLight(pos) <= rand.nextInt(8) && BMConfigs.SERVER_CONFIGS.amaracamelerSpawn.get()) {
                return canSpawnOn(entityType, world, spawnReason, pos, rand);
            }

            if (!(world instanceof ISeedReader)) {
                return false;
            }
        }

        return false;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume() {
        return 0.4F * (float)this.getSlimeSize();
    }

    /**
     * The speed it takes to move the livingEntity's rotationPitch through the faceEntity method. This is only currently
     * use in wolves.
     */
    public int getVerticalFaceSpeed() {
        return 0;
    }

    /**
     * Returns true if the amaracameler makes a sound when it jumps (based upon the amaracameler's size)
     */
    protected boolean makesSoundOnJump() {
        return this.getSlimeSize() > 0;
    }

    /**
     * Causes this entity to do an upwards motion (jumping).
     */
    protected void jump() {
        Vector3d vector3D = this.getMotion();
        this.setMotion(vector3D.x, this.getJumpUpwardsMotion(), vector3D.z);
        this.isAirBorne = true;
    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason spawnReason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        int i = this.rand.nextInt(3);
        if (i < 2 && this.rand.nextFloat() < 0.5F * difficulty.getClampedAdditionalDifficulty()) {
            ++i;
        }

        int j = 1 << i;
        this.setSlimeSize(j, true);
        return super.onInitialSpawn(world, difficulty, spawnReason, spawnData, dataTag);
    }

    private float func_234304_m_() {
        float f = this.isSmallSlime() ? 1.4F : 0.8F;
        return ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * f;
    }

    protected SoundEvent getJumpSound() {
        return this.isSmallSlime() ? SoundEvents.ENTITY_SLIME_JUMP_SMALL : SoundEvents.ENTITY_SLIME_JUMP;
    }

    public EntitySize getSize(Pose pose) {
        return super.getSize(pose).scale(0.255F * (float)this.getSlimeSize());
    }

    /**
     * Called when the amaracameler spawns particles on landing, see onUpdate.
     * Return true to prevent the spawning of the default particles.
     */
    protected boolean spawnCustomParticles() {
        return false;
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(AxolotlTest.AMARACAMELER_SPAWN_EGG.get());
    }

    static class AttackGoal extends Goal {
        private final Amaracameler amaracameler;
        private int growTieredTimer;

        public AttackGoal(Amaracameler amaracameler) {
            this.amaracameler = amaracameler;
            this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            LivingEntity livingEntity = this.amaracameler.getAttackTarget();
            if (livingEntity == null) {
                return false;
            } else if (!livingEntity.isAlive()) {
                return false;
            } else {
                return (!(livingEntity instanceof PlayerEntity) || !((PlayerEntity) livingEntity).abilities.disableDamage) && this.amaracameler.getMoveHelper() instanceof Amaracameler.MoveHelperController;
            }
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            this.growTieredTimer = 300;
            super.startExecuting();
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting() {
            LivingEntity livingEntity = this.amaracameler.getAttackTarget();
            if (livingEntity == null) {
                return false;
            } else if (!livingEntity.isAlive()) {
                return false;
            } else if (livingEntity instanceof PlayerEntity && ((PlayerEntity) livingEntity).abilities.disableDamage) {
                return false;
            } else {
                return --this.growTieredTimer > 0;
            }
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            this.amaracameler.faceEntity(this.amaracameler.getAttackTarget(), 10.0F, 10.0F);
            ((Amaracameler.MoveHelperController) this.amaracameler.getMoveHelper()).setDirection(this.amaracameler.rotationYaw, this.amaracameler.canDamagePlayer());
        }
    }

    static class FaceRandomGoal extends Goal {
        private final Amaracameler amaracameler;
        private float chosenDegrees;
        private int nextRandomizeTime;

        public FaceRandomGoal(Amaracameler amaracameler) {
            this.amaracameler = amaracameler;
            this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            return this.amaracameler.getAttackTarget() == null && (this.amaracameler.onGround || this.amaracameler.isInWater() || this.amaracameler.isInLava() || this.amaracameler.isPotionActive(Effects.LEVITATION)) && this.amaracameler.getMoveHelper() instanceof Amaracameler.MoveHelperController;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            if (--this.nextRandomizeTime <= 0) {
                this.nextRandomizeTime = 40 + this.amaracameler.getRNG().nextInt(60);
                this.chosenDegrees = (float)this.amaracameler.getRNG().nextInt(360);
            }

            ((Amaracameler.MoveHelperController) this.amaracameler.getMoveHelper()).setDirection(this.chosenDegrees, false);
        }
    }

    static class FloatGoal extends Goal {
        private final Amaracameler amaracameler;

        public FloatGoal(Amaracameler amaracameler) {
            this.amaracameler = amaracameler;
            this.setMutexFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
            amaracameler.getNavigator().setCanSwim(true);
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            return (this.amaracameler.isInWater() || this.amaracameler.isInLava()) && this.amaracameler.getMoveHelper() instanceof Amaracameler.MoveHelperController;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            if (this.amaracameler.getRNG().nextFloat() < 0.8F) {
                this.amaracameler.getJumpController().setJumping();
            }

            ((Amaracameler.MoveHelperController) this.amaracameler.getMoveHelper()).setSpeed(1.2D);
        }
    }

    static class HopGoal extends Goal {
        private final Amaracameler amaracameler;

        public HopGoal(Amaracameler amaracameler) {
            this.amaracameler = amaracameler;
            this.setMutexFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            return !this.amaracameler.isPassenger();
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            ((Amaracameler.MoveHelperController) this.amaracameler.getMoveHelper()).setSpeed(1.0D);
        }
    }

    static class MoveHelperController extends MovementController {
        private float yRot;
        private int jumpDelay;
        private final Amaracameler amaracameler;
        private boolean isAggressive;

        public MoveHelperController(Amaracameler amaracameler) {
            super(amaracameler);
            this.amaracameler = amaracameler;
            this.yRot = 180.0F * amaracameler.rotationYaw / (float)Math.PI;
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
            this.mob.rotationYaw = this.limitAngle(this.mob.rotationYaw, this.yRot, 90.0F);
            this.mob.rotationYawHead = this.mob.rotationYaw;
            this.mob.renderYawOffset = this.mob.rotationYaw;
            if (this.action != MovementController.Action.MOVE_TO) {
                this.mob.setMoveForward(0.0F);
            } else {
                this.action = MovementController.Action.WAIT;
                if (this.mob.isOnGround()) {
                    this.mob.setAIMoveSpeed((float)(this.speed * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
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
                        this.amaracameler.moveStrafing = 0.0F;
                        this.amaracameler.moveForward = 0.0F;
                        this.mob.setAIMoveSpeed(0.0F);
                    }
                } else {
                    this.mob.setAIMoveSpeed((float)(this.speed * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                }

            }
        }
    }
}
