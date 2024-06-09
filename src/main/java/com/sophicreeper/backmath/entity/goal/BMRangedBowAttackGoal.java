package com.sophicreeper.backmath.entity.goal;

import com.sophicreeper.backmath.entity.custom.termian.TermianPatrollerEntity;
import com.sophicreeper.backmath.item.custom.weapon.BMBowItem;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.projectile.ProjectileHelper;

import java.util.EnumSet;

public class BMRangedBowAttackGoal<T extends TermianPatrollerEntity & IRangedAttackMob> extends Goal {
    private final T shooter;
    private final double moveSpeedAmplifier;
    private int attackCooldown;
    private final float maxAttackDistance;
    private int attackTime = -1;
    private int seeTime;
    private boolean strafingClockwise;
    private boolean strafingBackwards;
    private int strafingTime = -1;

    public BMRangedBowAttackGoal(T mob, double moveSpeedAmplifier, int attackCooldown, float maxAttackDistance) {
        this.shooter = mob;
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
        return this.shooter.getTarget() != null && this.isHoldingBow();
    }

    protected boolean isHoldingBow() {
        return this.shooter.isHolding(item -> item.is(BMTags.Items.BOWS));
    }

    // Returns whether an in-progress EntityAIBase should continue executing.
    public boolean canContinueToUse() {
        return this.canUse() || !this.shooter.getNavigation().isDone() && this.isHoldingBow();
    }

    // Execute a one shot task or start executing a continuous task.
    public void start() {
        super.start();
        this.shooter.setAggressive(true);
    }

    // Reset the task's internal state. Called when this task is interrupted by another one.
    public void stop() {
        super.stop();
        this.shooter.setAggressive(false);
        this.seeTime = 0;
        this.attackTime = -1;
        this.shooter.stopUsingItem();
    }

    // Keep ticking a continuous task that has already been started.
    public void tick() {
        LivingEntity target = this.shooter.getTarget();
        if (target != null) {
            double mobDistanceSqr = this.shooter.distanceToSqr(target.getX(), target.getY(), target.getZ());
            boolean canSeeOther = this.shooter.getSensing().canSee(target);
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
                this.shooter.getNavigation().stop();
                ++this.strafingTime;
            } else {
                this.shooter.getNavigation().moveTo(target, this.moveSpeedAmplifier);
                this.strafingTime = -1;
            }

            if (this.strafingTime >= 20) {
                if ((double) this.shooter.getRandom().nextFloat() < 0.3D) {
                    this.strafingClockwise = !this.strafingClockwise;
                }

                if ((double) this.shooter.getRandom().nextFloat() < 0.3D) {
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

                this.shooter.getMoveControl().strafe(this.strafingBackwards ? -0.5F : 0.5F, this.strafingClockwise ? 0.5F : -0.5F);
                this.shooter.lookAt(target, 30, 30);
            } else {
                this.shooter.getLookControl().setLookAt(target, 30, 30);
            }

            if (this.shooter.isUsingItem()) {
                if (!canSeeOther && this.seeTime < -60) {
                    this.shooter.stopUsingItem();
                } else if (canSeeOther) {
                    int countForItemInUse = this.shooter.getTicksUsingItem();
                    if (countForItemInUse >= 20) {
                        this.shooter.stopUsingItem();
                        this.shooter.getLookControl().setLookAt(target, 10, 70);
                        this.shooter.performRangedAttack(target, BMBowItem.getArrowVelocity(countForItemInUse));
                        this.attackTime = this.attackCooldown;
                    }
                }
            } else if (--this.attackTime <= 0 && this.seeTime >= -60) {
                this.shooter.startUsingItem(ProjectileHelper.getWeaponHoldingHand(this.shooter, item -> item.is(BMTags.Items.BOWS)));
            }
        }
    }
}
