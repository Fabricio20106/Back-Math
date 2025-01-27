package com.sophicreeper.backmath.entity.goal;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.monster.MonsterEntity;

public class ZombieAttackGoal extends MeleeAttackGoal {
    private final MonsterEntity mob;
    private int raisedArmTicks;

    public ZombieAttackGoal(MonsterEntity mob, double speed, boolean useLongMemory) {
        super(mob, speed, useLongMemory);
        this.mob = mob;
    }

    public void start() {
        super.start();
        this.raisedArmTicks = 0;
    }

    public void stop() {
        super.stop();
        this.mob.setAggressive(false);
    }

    public void tick() {
        super.tick();
        ++this.raisedArmTicks;
        this.mob.setAggressive(this.raisedArmTicks >= 5 && this.getTicksUntilNextAttack() < this.getAttackInterval() / 2);
    }
}
