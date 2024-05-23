package com.sophicreeper.backmath.entity.goal;

import com.sophicreeper.backmath.entity.custom.termian.TermianPatrollerEntity;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.item.custom.weapon.BMBowItem;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.BowItem;

import java.util.EnumSet;

public class BMRangedBowAttackGoal<T extends TermianPatrollerEntity & IRangedAttackMob> extends Goal {
    private final T entity;
    private final double moveSpeedAmplifier;
    private int attackCooldown;
    private final float maxAttackDistance;
    private int attackTime = -1;
    private int seeTime;
    private boolean strafingClockwise;
    private boolean strafingBackwards;
    private int strafingTime = -1;

    public BMRangedBowAttackGoal(T mob, double moveSpeedAmplifier, int attackCooldown, float maxAttackDistance) {
        this.entity = mob;
        this.moveSpeedAmplifier = moveSpeedAmplifier;
        this.attackCooldown = attackCooldown;
        this.maxAttackDistance = maxAttackDistance * maxAttackDistance;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    public void setAttackCooldown(int attackCooldown) {
        this.attackCooldown = attackCooldown;
    }

    // Returns whether execution should begin. You can also read and cache any state necessary for execution in this method as well.
    public boolean canUse() {
        return this.entity.getTarget() != null && this.isHoldingBow();
    }

    protected boolean isHoldingBow() {
        return this.entity.isHolding(item -> item instanceof BowItem);
    }

    // Returns whether an in-progress EntityAIBase should continue executing.
    public boolean canContinueToUse() {
        return this.canUse() || !this.entity.getNavigation().isDone() && this.isHoldingBow();
    }

    // Execute a one shot task or start executing a continuous task.
    public void start() {
        super.start();
        this.entity.setAggressive(true);
    }

    // Reset the task's internal state. Called when this task is interrupted by another one.
    public void stop() {
        super.stop();
        this.entity.setAggressive(false);
        this.seeTime = 0;
        this.attackTime = -1;
        this.entity.stopUsingItem();
    }

    // Keep ticking a continuous task that has already been started.
    public void tick() {
        LivingEntity livEntity = this.entity.getTarget();
        if (livEntity != null) {
            double mobDistanceSqr = this.entity.distanceToSqr(livEntity.getX(), livEntity.getY(), livEntity.getZ());
            boolean canSeeOther = this.entity.getSensing().canSee(livEntity);
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
                this.entity.getNavigation().stop();
                ++this.strafingTime;
            } else {
                this.entity.getNavigation().moveTo(livEntity, this.moveSpeedAmplifier);
                this.strafingTime = -1;
            }

            if (this.strafingTime >= 20) {
                if ((double) this.entity.getRandom().nextFloat() < 0.3D) {
                    this.strafingClockwise = !this.strafingClockwise;
                }

                if ((double) this.entity.getRandom().nextFloat() < 0.3D) {
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

                this.entity.getMoveControl().strafe(this.strafingBackwards ? -0.5F : 0.5F, this.strafingClockwise ? 0.5F : -0.5F);
                this.entity.lookAt(livEntity, 30, 30);
            } else {
                this.entity.getLookControl().setLookAt(livEntity, 30, 30);
            }

            if (this.entity.isUsingItem()) {
                if (!canSeeOther && this.seeTime < -60) {
                    this.entity.stopUsingItem();
                } else if (canSeeOther) {
                    int countForItemInUse = this.entity.getTicksUsingItem();
                    if (countForItemInUse >= 20) {
                        this.entity.stopUsingItem();
                        this.entity.performRangedAttack(livEntity, BMBowItem.getArrowVelocity(countForItemInUse));
                        this.attackTime = this.attackCooldown;
                    }
                }
            } else if (--this.attackTime <= 0 && this.seeTime >= -60) {
                this.entity.startUsingItem(ProjectileHelper.getWeaponHoldingHand(this.entity, AxolotlTest.ANGELIC_BOW.get()));
            }
        }
    }
}
