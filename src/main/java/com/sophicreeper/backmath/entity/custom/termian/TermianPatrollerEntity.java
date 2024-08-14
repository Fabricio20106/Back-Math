package com.sophicreeper.backmath.entity.custom.termian;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.goal.termian.TermianPatrolGoal;
import com.sophicreeper.backmath.misc.BMSounds;
import com.sophicreeper.backmath.util.BMUtils;
import com.sophicreeper.backmath.util.tag.BMEntityTypeTags;
import net.minecraft.entity.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.*;

import javax.annotation.Nullable;
import java.util.Random;

import static net.minecraft.entity.monster.MonsterEntity.isDarkEnoughToSpawn;

public abstract class TermianPatrollerEntity extends CreatureEntity {
    private static final DataParameter<String> CAPE_TEXTURE = EntityDataManager.defineId(TermianPatrollerEntity.class, DataSerializers.STRING);
    private static final DataParameter<Boolean> CAPE_VISIBILITY = EntityDataManager.defineId(TermianPatrollerEntity.class, DataSerializers.BOOLEAN);
    private BlockPos patrolTarget;
    private boolean patrolLeader;
    private boolean patrolling;
    public double prevChasingPosX;
    public double prevChasingPosY;
    public double prevChasingPosZ;
    public double chasingPosX;
    public double chasingPosY;
    public double chasingPosZ;
    public float prevCameraYaw;
    public float cameraYaw;

    public TermianPatrollerEntity(EntityType<? extends CreatureEntity> mob, World world) {
        super(mob, world);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CAPE_TEXTURE, BackMath.backMath("cape/cherry_blossom").toString());
        this.entityData.define(CAPE_VISIBILITY, true);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new TermianPatrolGoal<>(this, 0.7D, 0.595D));
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT tag) {
        super.addAdditionalSaveData(tag);
        if (this.patrolTarget != null) tag.put("patrol_target", NBTUtil.writeBlockPos(this.patrolTarget));
        tag.putBoolean("patrol_leader", this.patrolLeader);
        tag.putBoolean("is_patrolling", this.patrolling);
        if (this.getType().is(BMEntityTypeTags.ELIGIBLE_TO_CAPES)) {
            CompoundNBT capeTag = new CompoundNBT();
            capeTag.putString("texture", this.entityData.get(CAPE_TEXTURE));
            capeTag.putBoolean("visible", this.entityData.get(CAPE_VISIBILITY));
            tag.put("cape", capeTag);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("patrol_target")) this.patrolTarget = NBTUtil.readBlockPos(tag.getCompound("patrol_target"));
        this.patrolLeader = tag.getBoolean("patrol_leader");
        this.patrolling = tag.getBoolean("is_patrolling");
        if (this.getType().is(BMEntityTypeTags.ELIGIBLE_TO_CAPES)) {
            this.entityData.set(CAPE_TEXTURE, tag.getCompound("cape").getString("texture"));
            this.entityData.set(CAPE_VISIBILITY, tag.getCompound("cape").getBoolean("visible"));
        }
    }

    @Override
    public void tick() {
        super.tick();
        this.updateCape();
    }

    @Override
    public void aiStep() {
        this.prevCameraYaw = this.cameraYaw;
        float f;
        if (this.onGround && !this.isDeadOrDying() && !this.isSwimming()) {
            f = Math.min(0.1F, MathHelper.sqrt(getHorizontalDistanceSqr(this.getDeltaMovement())));
        } else {
            f = 0;
        }
        this.cameraYaw += (f - this.cameraYaw) * 0.4F;
        super.aiStep();
    }

    @Override
    public void rideTick() {
        super.rideTick();
        if (this.getVehicle() instanceof CreatureEntity) {
            CreatureEntity entity = (CreatureEntity) this.getVehicle();
            this.yBodyRot = entity.yBodyRot;
            this.prevCameraYaw = this.cameraYaw;
            this.cameraYaw = 0;
        }
    }

    @Override
    public double getMyRidingOffset() {
        return -0.35D;
    }

    @Override
    protected float getStandingEyeHeight(Pose pose, EntitySize size) {
        return 1.62F;
    }

    public boolean canBePatrolLeader() {
        return true;
    }

    @Nullable
    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityData, @Nullable CompoundNBT dataTag) {
        if (reason != SpawnReason.PATROL && reason != SpawnReason.EVENT && reason != SpawnReason.STRUCTURE && this.random.nextFloat() < 0.06F && this.canBePatrolLeader()) this.patrolLeader = true;

        if (this.isPatrolLeader()) {
            this.setItemSlot(EquipmentSlotType.HEAD, BMUtils.getTermianBannerInstance());
            this.setDropChance(EquipmentSlotType.HEAD, 2);
        }
        if (reason == SpawnReason.PATROL) this.patrolling = true;

        // Capes
        this.setCapeVisibility(this.random.nextInt(16) != 0);
        BMUtils.setRandomCape(this, this.random);

        return super.finalizeSpawn(world, difficulty, reason, entityData, dataTag);
    }

    public static boolean checkTermianPatrolSpawnRules(EntityType<? extends TermianPatrollerEntity> patroller, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
        return world.getBrightness(LightType.BLOCK, pos) <= 8 && checkAnyLightMonsterSpawnRules(patroller, world, reason, pos, rand);
    }

    private static boolean checkAnyLightMonsterSpawnRules(EntityType<? extends CreatureEntity> mob, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
        return world.getDifficulty() != Difficulty.PEACEFUL && checkMobSpawnRules(mob, world, reason, pos, rand);
    }

    public static boolean checkMonsterSpawnRules(EntityType<? extends CreatureEntity> mob, IServerWorld world, SpawnReason reason, BlockPos pos, Random rand) {
        return world.getDifficulty() != Difficulty.PEACEFUL && isDarkEnoughToSpawn(world, pos, rand) && checkMobSpawnRules(mob, world, reason, pos, rand);
    }

    public boolean removeWhenFarAway(double distance) {
        return !this.patrolling;
    }

    @Override
    protected SoundEvent getSwimSound() {
        return BMSounds.ENTITY_TERMIAN_SWIM;
    }

    @Override
    protected SoundEvent getSwimSplashSound() {
        return BMSounds.ENTITY_TERMIAN_SPLASH;
    }

    @Override
    protected SoundEvent getSwimHighSpeedSplashSound() {
        return BMSounds.ENTITY_TERMIAN_SPLASH_HIGH_SPEED;
    }

    public void setPatrolTarget(BlockPos pos) {
        this.patrolTarget = pos;
        this.patrolling = true;
    }

    public BlockPos getPatrolTarget() {
        return this.patrolTarget;
    }

    public boolean hasPatrolTarget() {
        return this.patrolTarget != null;
    }

    public void setPatrolLeader(boolean leader) {
        this.patrolLeader = leader;
        this.patrolling = true;
    }

    public boolean isPatrolLeader() {
        return this.patrolLeader;
    }

    public boolean canJoinPatrol() {
        return true;
    }

    public void findPatrolTarget() {
        this.patrolTarget = this.blockPosition().offset(-500 + this.random.nextInt(1000), 0, -500 + this.random.nextInt(1000));
        this.patrolling = true;
    }

    public boolean isPatrolling() {
        return this.patrolling;
    }

    public void setPatrolling(boolean patrolling) {
        this.patrolling = patrolling;
    }

    public String getCapeTexture() {
        return this.entityData.get(CAPE_TEXTURE);
    }

    public void setCapeTexture(String capeTexture) {
        this.entityData.set(CAPE_TEXTURE, capeTexture);
    }

    public boolean getCapeVisibility() {
        return this.entityData.get(CAPE_VISIBILITY);
    }

    public void setCapeVisibility(boolean visible) {
        this.entityData.set(CAPE_VISIBILITY, visible);
    }

    private void updateCape() {
        this.prevChasingPosX = this.chasingPosX;
        this.prevChasingPosY = this.chasingPosY;
        this.prevChasingPosZ = this.chasingPosZ;
        double d0 = this.getX() - this.chasingPosX;
        double d1 = this.getY() - this.chasingPosY;
        double d2 = this.getZ() - this.chasingPosZ;

        if (d0 > 10) {
            this.chasingPosX = this.getX();
            this.prevChasingPosX = this.chasingPosX;
        }

        if (d2 > 10) {
            this.chasingPosZ = this.getZ();
            this.prevChasingPosZ = this.chasingPosZ;
        }

        if (d1 > 10) {
            this.chasingPosY = this.getY();
            this.prevChasingPosY = this.chasingPosY;
        }

        if (d0 < -10) {
            this.chasingPosX = this.getX();
            this.prevChasingPosX = this.chasingPosX;
        }

        if (d2 < -10) {
            this.chasingPosZ = this.getZ();
            this.prevChasingPosZ = this.chasingPosZ;
        }

        if (d1 < -10) {
            this.chasingPosY = this.getY();
            this.prevChasingPosY = this.chasingPosY;
        }

        this.chasingPosX += d0 * 0.25D;
        this.chasingPosZ += d2 * 0.25D;
        this.chasingPosY += d1 * 0.25D;
    }
}
