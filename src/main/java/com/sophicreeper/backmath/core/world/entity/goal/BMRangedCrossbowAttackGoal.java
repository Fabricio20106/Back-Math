package com.sophicreeper.backmath.core.world.entity.goal;

import com.sophicreeper.backmath.core.world.item.AxolotlTest;
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
    public static final RangedInteger pathfinding_delay_range = new RangedInteger(20, 40);
    private final T mob;
    private BMRangedCrossbowAttackGoal.CrossbowState crossbowState = BMRangedCrossbowAttackGoal.CrossbowState.UNCHARGED;
    private final double speedModified;
    private final float attackRadiusSqr;
    private int seeTime;
    private int attackDelay;
    private int updatePackDelay;

    public BMRangedCrossbowAttackGoal(T mob, double speedModified, float attackRadiusSquared) {
        this.mob = mob;
        this.speedModified = speedModified;
        this.attackRadiusSqr = attackRadiusSquared * attackRadiusSquared;
        this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    public boolean shouldExecute() {
        return this.isValidTarget() && this.isHoldingCrossbow();
    }

    private boolean isHoldingCrossbow() {
        return this.mob.func_233634_a_(item -> item instanceof CrossbowItem);
    }

    public boolean shouldContinueExecuting() {
        return this.isValidTarget() && (this.shouldExecute() || !this.mob.getNavigator().noPath()) && this.isHoldingCrossbow();
    }

    private boolean isValidTarget() {
        return this.mob.getAttackTarget() != null && this.mob.getAttackTarget().isAlive();
    }

    public void resetTask() {
        super.resetTask();
        this.mob.setAggroed(false);
        this.mob.setAttackTarget(null);
        this.seeTime = 0;
        if (this.mob.isHandActive()) {
            this.mob.resetActiveHand();
            this.mob.setCharging(false);
            CrossbowItem.setCharged(this.mob.getActiveItemStack(), false);
        }

    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void tick() {
        LivingEntity livingEntity = this.mob.getAttackTarget();
        if (livingEntity != null) {
            boolean flag = this.mob.getEntitySenses().canSee(livingEntity);
            boolean flag1 = this.seeTime > 0;
            if (flag != flag1) {
                this.seeTime = 0;
            }

            if (flag) {
                ++this.seeTime;
            } else {
                --this.seeTime;
            }

            double d0 = this.mob.getDistanceSq(livingEntity);
            boolean flag2 = (d0 > (double) this.attackRadiusSqr || this.seeTime < 5) && this.attackDelay == 0;
            if (flag2) {
                --this.updatePackDelay;
                if (this.updatePackDelay <= 0) {
                    this.mob.getNavigator().tryMoveToEntityLiving(livingEntity, this.func_220747_j() ? this.speedModified : this.speedModified * 0.5D);
                    this.updatePackDelay = pathfinding_delay_range.getRandomWithinRange(this.mob.getRNG());
                }
            } else {
                this.updatePackDelay = 0;
                this.mob.getNavigator().clearPath();
            }

            this.mob.getLookController().setLookPositionWithEntity(livingEntity, 30.0F, 30.0F);
            if (this.crossbowState == BMRangedCrossbowAttackGoal.CrossbowState.UNCHARGED) {
                if (!flag2) {
                    this.mob.setActiveHand(ProjectileHelper.getHandWith(this.mob, AxolotlTest.ANGELIC_CROSSBOW.get()));
                    this.crossbowState = BMRangedCrossbowAttackGoal.CrossbowState.CHARGING;
                    this.mob.setCharging(true);
                }
            } else if (this.crossbowState == BMRangedCrossbowAttackGoal.CrossbowState.CHARGING) {
                if (!this.mob.isHandActive()) {
                    this.crossbowState = BMRangedCrossbowAttackGoal.CrossbowState.UNCHARGED;
                }

                int i = this.mob.getItemInUseMaxCount();
                ItemStack activeStack = this.mob.getActiveItemStack();
                if (i >= CrossbowItem.getChargeTime(activeStack)) {
                    this.mob.stopActiveHand();
                    this.crossbowState = BMRangedCrossbowAttackGoal.CrossbowState.CHARGED;
                    this.attackDelay = 20 + this.mob.getRNG().nextInt(20);
                    this.mob.setCharging(false);
                }
            } else if (this.crossbowState == BMRangedCrossbowAttackGoal.CrossbowState.CHARGED) {
                --this.attackDelay;
                if (this.attackDelay == 0) {
                    this.crossbowState = BMRangedCrossbowAttackGoal.CrossbowState.READY_TO_ATTACK;
                }
            } else if (this.crossbowState == BMRangedCrossbowAttackGoal.CrossbowState.READY_TO_ATTACK && flag) {
                this.mob.attackEntityWithRangedAttack(livingEntity, 1.0F);
                ItemStack projectileStack = this.mob.getHeldItem(ProjectileHelper.getHandWith(this.mob, AxolotlTest.ANGELIC_CROSSBOW.get()));
                CrossbowItem.setCharged(projectileStack, false);
                this.crossbowState = BMRangedCrossbowAttackGoal.CrossbowState.UNCHARGED;
            }

        }
    }

    private boolean func_220747_j() {
        return this.crossbowState == BMRangedCrossbowAttackGoal.CrossbowState.UNCHARGED;
    }

    enum CrossbowState {
        UNCHARGED,
        CHARGING,
        CHARGED,
        READY_TO_ATTACK
    }
}