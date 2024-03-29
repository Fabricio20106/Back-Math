package com.sophicreeper.backmath.entity.goal;

import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.item.custom.weapon.BMBowItem;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.BowItem;

import java.util.EnumSet;

public class BMRangedBowAttackGoal<T extends MonsterEntity & IRangedAttackMob> extends Goal {
    private final T entity;
    private final double moveSpeedAmp;
    private int attackCooldown;
    private final float maxAttackDistance;
    private int attackTime = -1;
    private int seeTime;
    private boolean strafingClockwise;
    private boolean strafingBackwards;
    private int strafingTime = -1;

    public BMRangedBowAttackGoal(T mob, double moveSpeedAmplifier, int attackCooldown, float maxAttackDistance) {
        this.entity = mob;
        this.moveSpeedAmp = moveSpeedAmplifier;
        this.attackCooldown = attackCooldown;
        this.maxAttackDistance = maxAttackDistance * maxAttackDistance;
        this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    public void setAttackCooldown(int attackCooldown) {
        this.attackCooldown = attackCooldown;
    }

    // Returns whether execution should begin. You can also read and cache any state necessary for execution in this method as well.
    public boolean shouldExecute() {
        return this.entity.getAttackTarget() != null && this.isBowInMainhand();
    }

    protected boolean isBowInMainhand() {
        return this.entity.func_233634_a_(item -> item instanceof BowItem);
    }

    // Returns whether an in-progress EntityAIBase should continue executing.
    public boolean shouldContinueExecuting() {
        return this.shouldExecute() || !this.entity.getNavigator().noPath() && this.isBowInMainhand();
    }

    // Execute a one shot task or start executing a continuous task.
    public void startExecuting() {
        super.startExecuting();
        this.entity.setAggroed(true);
    }

    // Reset the task's internal state. Called when this task is interrupted by another one.
    public void resetTask() {
        super.resetTask();
        this.entity.setAggroed(false);
        this.seeTime = 0;
        this.attackTime = -1;
        this.entity.resetActiveHand();
    }

    // Keep ticking a continuous task that has already been started.
    public void tick() {
        LivingEntity livingEntity = this.entity.getAttackTarget();
        if (livingEntity != null) {
            double mobDistanceSqr = this.entity.getDistanceSq(livingEntity.getPosX(), livingEntity.getPosY(), livingEntity.getPosZ());
            boolean canSeeOther = this.entity.getEntitySenses().canSee(livingEntity);
            boolean seeTimeFlag = this.seeTime > 0;
            if (canSeeOther != seeTimeFlag) {
                this.seeTime = 0;
            }

            if (canSeeOther) {
                ++this.seeTime;
            } else {
                --this.seeTime;
            }

            if (!(mobDistanceSqr > (double) this.maxAttackDistance) && this.seeTime >= 20) {
                this.entity.getNavigator().clearPath();
                ++this.strafingTime;
            } else {
                this.entity.getNavigator().tryMoveToEntityLiving(livingEntity, this.moveSpeedAmp);
                this.strafingTime = -1;
            }

            if (this.strafingTime >= 20) {
                if ((double)this.entity.getRNG().nextFloat() < 0.3D) {
                    this.strafingClockwise = !this.strafingClockwise;
                }

                if ((double)this.entity.getRNG().nextFloat() < 0.3D) {
                    this.strafingBackwards = !this.strafingBackwards;
                }

                this.strafingTime = 0;
            }

            if (this.strafingTime > -1) {
                if (mobDistanceSqr > (double) (this.maxAttackDistance * 0.75F)) {
                    this.strafingBackwards = false;
                } else if (mobDistanceSqr < (double) (this.maxAttackDistance * 0.25F)) {
                    this.strafingBackwards = true;
                }

                this.entity.getMoveHelper().strafe(this.strafingBackwards ? -0.5F : 0.5F, this.strafingClockwise ? 0.5F : -0.5F);
                this.entity.faceEntity(livingEntity, 30, 30);
            } else {
                this.entity.getLookController().setLookPositionWithEntity(livingEntity, 30, 30);
            }

            if (this.entity.isHandActive()) {
                if (!canSeeOther && this.seeTime < -60) {
                    this.entity.resetActiveHand();
                } else if (canSeeOther) {
                    int countForItemInUse = this.entity.getItemInUseMaxCount();
                    if (countForItemInUse >= 20) {
                        this.entity.resetActiveHand();
                        this.entity.attackEntityWithRangedAttack(livingEntity, BMBowItem.getArrowVelocity(countForItemInUse));
                        this.attackTime = this.attackCooldown;
                    }
                }
            } else if (--this.attackTime <= 0 && this.seeTime >= -60) {
                this.entity.setActiveHand(ProjectileHelper.getHandWith(this.entity, AxolotlTest.ANGELIC_BOW.get()));
            }
        }
    }
}
