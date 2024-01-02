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
        this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    public boolean shouldExecute() {
        return this.isValidTarget() && this.isHoldingCrossbow();
    }

    private boolean isHoldingCrossbow() {
        return this.shooter.func_233634_a_(item -> item instanceof BMCrossbowItem);
    }

    public boolean shouldContinueExecuting() {
        return this.isValidTarget() && (this.shouldExecute() || !this.shooter.getNavigator().noPath()) && this.isHoldingCrossbow();
    }

    private boolean isValidTarget() {
        return this.shooter.getAttackTarget() != null && this.shooter.getAttackTarget().isAlive();
    }

    public void resetTask() {
        super.resetTask();
        this.shooter.setAggroed(false);
        this.shooter.setAttackTarget(null);
        this.seeTime = 0;
        if (this.shooter.isHandActive()) {
            this.shooter.resetActiveHand();
            this.shooter.setCharging(false);
            BMCrossbowItem.setCharged(this.shooter.getActiveItemStack(), false);
        }
    }

   // Keep ticking a continuous task that has already been started.
    public void tick() {
        LivingEntity target = this.shooter.getAttackTarget();
        if (target != null) {
            boolean canMobSeeOther = this.shooter.getEntitySenses().canSee(target);
            boolean posSeeTime = this.seeTime > 0;
            if (canMobSeeOther != posSeeTime) {
                this.seeTime = 0;
            }

            if (canMobSeeOther) {
                ++this.seeTime;
            } else {
                --this.seeTime;
            }

            double mobDistanceSqr = this.shooter.getDistanceSq(target);
            boolean flag = (mobDistanceSqr > (double) this.attackRadiusSqr || this.seeTime < 5) && this.attackDelay == 0;
            if (flag) {
                --this.updatePackDelay;
                if (this.updatePackDelay <= 0) {
                    this.shooter.getNavigator().tryMoveToEntityLiving(target, this.isCrossbowUncharged() ? this.speed : this.speed * 0.5d);
                    this.updatePackDelay = PATHFINDING_DELAY_RANGE.getRandomWithinRange(this.shooter.getRNG());
                }
            } else {
                this.updatePackDelay = 0;
                this.shooter.getNavigator().clearPath();
            }

            this.shooter.getLookController().setLookPositionWithEntity(target, 30, 30);
            if (this.crossbowState == CrossbowState.UNCHARGED) {
                if (!flag) {
                    this.shooter.setActiveHand(ProjectileHelper.getHandWith(this.shooter, AxolotlTest.ANGELIC_CROSSBOW.get()));
                    this.crossbowState = CrossbowState.CHARGING;
                    this.shooter.setCharging(true);
                }
            } else if (this.crossbowState == CrossbowState.CHARGING) {
                if (!this.shooter.isHandActive()) {
                    this.crossbowState = CrossbowState.UNCHARGED;
                }

                int i = this.shooter.getItemInUseMaxCount();
                ItemStack activeStack = this.shooter.getActiveItemStack();
                if (i >= CrossbowItem.getChargeTime(activeStack)) {
                    this.shooter.stopActiveHand();
                    this.crossbowState = CrossbowState.CHARGED;
                    this.attackDelay = 20 + this.shooter.getRNG().nextInt(20);
                    this.shooter.setCharging(false);
                }
            } else if (this.crossbowState == CrossbowState.CHARGED) {
                --this.attackDelay;
                if (this.attackDelay == 0) {
                    this.crossbowState = CrossbowState.READY_TO_ATTACK;
                }
            } else if (this.crossbowState == CrossbowState.READY_TO_ATTACK && canMobSeeOther) {
                this.shooter.attackEntityWithRangedAttack(target, 1);
                ItemStack crossbowStack = this.shooter.getHeldItem(ProjectileHelper.getHandWith(this.shooter, AxolotlTest.ANGELIC_CROSSBOW.get()));
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