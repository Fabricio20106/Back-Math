package com.sophicreeper.backmath.entity.goal;

import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.item.custom.weapon.BMCrossbowItem;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ICrossbowUser;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.RangedInteger;

import java.util.EnumSet;

public class BMRangedCrossbowAttackGoal<T extends CreatureEntity & IRangedAttackMob & ICrossbowUser> extends Goal {
    public static final RangedInteger PATHFINDING_DELAY_RANGE = new RangedInteger(20, 40);
    private final T shooter;
    private CrossbowState crossbowState = CrossbowState.UNCHARGED;
    private final double speed;
    private final float attackRadiusSqr;
    private int seeTime;
    private int attackDelay;
    private int updatePackDelay;

    public BMRangedCrossbowAttackGoal(T shooter, double speed, float attackRadiusSquared) {
        this.shooter = shooter;
        this.speed = speed;
        this.attackRadiusSqr = attackRadiusSquared * attackRadiusSquared;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    public boolean canUse() {
        return this.isValidTarget() && this.isHoldingCrossbow();
    }

    private boolean isHoldingCrossbow() {
        return this.shooter.isHolding(item -> item instanceof BMCrossbowItem);
    }

    public boolean canContinueToUse() {
        return this.isValidTarget() && (this.canUse() || !this.shooter.getNavigation().isDone()) && this.isHoldingCrossbow();
    }

    private boolean isValidTarget() {
        return this.shooter.getTarget() != null && this.shooter.getTarget().isAlive();
    }

    public void stop() {
        super.stop();
        this.shooter.setAggressive(false);
        this.shooter.setTarget(null);
        this.seeTime = 0;
        if (this.shooter.isUsingItem()) {
            this.shooter.stopUsingItem();
            this.shooter.setChargingCrossbow(false);
            BMCrossbowItem.setCharged(this.shooter.getUseItem(), false);
        }
    }

   // Keep ticking a continuous task that has already been started.
    public void tick() {
        LivingEntity target = this.shooter.getTarget();
        if (target != null) {
            boolean canMobSeeOther = this.shooter.getSensing().canSee(target);
            boolean posSeeTime = this.seeTime > 0;
            if (canMobSeeOther != posSeeTime) {
                this.seeTime = 0;
            }

            if (canMobSeeOther) {
                ++this.seeTime;
            } else {
                --this.seeTime;
            }

            double mobDistanceSqr = this.shooter.distanceToSqr(target);
            boolean flag = (mobDistanceSqr > (double) this.attackRadiusSqr || this.seeTime < 5) && this.attackDelay == 0;
            if (flag) {
                --this.updatePackDelay;
                if (this.updatePackDelay <= 0) {
                    this.shooter.getNavigation().moveTo(target, this.isCrossbowUncharged() ? this.speed : this.speed * 0.5d);
                    this.updatePackDelay = PATHFINDING_DELAY_RANGE.randomValue(this.shooter.getRandom());
                }
            } else {
                this.updatePackDelay = 0;
                this.shooter.getNavigation().stop();
            }

            this.shooter.getLookControl().setLookAt(target, 30, 30);
            if (this.crossbowState == CrossbowState.UNCHARGED) {
                if (!flag) {
                    this.shooter.startUsingItem(ProjectileHelper.getWeaponHoldingHand(this.shooter, AxolotlTest.ANGELIC_CROSSBOW.get()));
                    this.crossbowState = CrossbowState.CHARGING;
                    this.shooter.setChargingCrossbow(true);
                }
            } else if (this.crossbowState == CrossbowState.CHARGING) {
                if (!this.shooter.isUsingItem()) {
                    this.crossbowState = CrossbowState.UNCHARGED;
                }

                int ticksUsingItem = this.shooter.getTicksUsingItem();
                ItemStack activeStack = this.shooter.getUseItem();
                if (ticksUsingItem >= CrossbowItem.getChargeDuration(activeStack)) {
                    this.shooter.releaseUsingItem();
                    this.crossbowState = CrossbowState.CHARGED;
                    this.attackDelay = 20 + this.shooter.getRandom().nextInt(20);
                    this.shooter.setChargingCrossbow(false);
                }
            } else if (this.crossbowState == CrossbowState.CHARGED) {
                --this.attackDelay;
                if (this.attackDelay == 0) {
                    this.crossbowState = CrossbowState.READY_TO_ATTACK;
                }
            } else if (this.crossbowState == CrossbowState.READY_TO_ATTACK && canMobSeeOther) {
                this.shooter.performRangedAttack(target, 1);
                ItemStack crossbowStack = this.shooter.getItemInHand(ProjectileHelper.getWeaponHoldingHand(this.shooter, AxolotlTest.ANGELIC_CROSSBOW.get()));
                BMCrossbowItem.setCharged(crossbowStack, false);
                this.crossbowState = CrossbowState.UNCHARGED;
            }
        }
    }

    private boolean isCrossbowUncharged() {
        return this.crossbowState == CrossbowState.UNCHARGED;
    }

    public enum CrossbowState {
        UNCHARGED,
        CHARGING,
        CHARGED,
        READY_TO_ATTACK
    }
}