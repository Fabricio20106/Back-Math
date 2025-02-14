package com.sophicreeper.backmath.entity.goal;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.world.GameRules;

public class ResetAngerGoal<T extends MobEntity> extends Goal {
    private final T mob;
    private int lastHurtByTimestamp;

    public ResetAngerGoal(T mob) {
        this.mob = mob;
    }

    @Override
    public boolean canUse() {
        return this.mob.level.getGameRules().getBoolean(GameRules.RULE_UNIVERSAL_ANGER) && this.wasHurtByEntity();
    }

    private boolean wasHurtByEntity() {
        return this.mob.getLastHurtByMob() != null && this.mob.getLastHurtByMobTimestamp() > this.lastHurtByTimestamp;
    }

    @Override
    public void start() {
        this.lastHurtByTimestamp = this.mob.getLastHurtByMobTimestamp();
        this.mob.setLastHurtByMob(null);
        this.mob.setTarget(null);
        super.start();
    }
}
