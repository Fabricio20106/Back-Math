package com.sophicreeper.backmath.entity.goal;

import com.sophicreeper.backmath.entity.custom.ZombieFabricio;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class ZombieFabricioAttackGoal extends MeleeAttackGoal {
    private final ZombieFabricio zombie;
    private int raisedArmTicks;

    public ZombieFabricioAttackGoal(ZombieFabricio zombie, double speed, boolean useLongMemory) {
        super(zombie, speed, useLongMemory);
        this.zombie = zombie;
    }

    public void start() {
        super.start();
        this.raisedArmTicks = 0;
    }

    public void stop() {
        super.stop();
        this.zombie.setAggressive(false);
    }

    public void tick() {
        super.tick();
        ++this.raisedArmTicks;
        this.zombie.setAggressive(this.raisedArmTicks >= 5 && this.getTicksUntilNextAttack() < this.getAttackInterval() / 2);
    }
}
