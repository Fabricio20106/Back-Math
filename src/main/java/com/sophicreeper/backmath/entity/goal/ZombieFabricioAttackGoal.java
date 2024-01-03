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

    public void startExecuting() {
        super.startExecuting();
        this.raisedArmTicks = 0;
    }

    public void resetTask() {
        super.resetTask();
        this.zombie.setAggroed(false);
    }

    public void tick() {
        super.tick();
        ++this.raisedArmTicks;
        this.zombie.setAggroed(this.raisedArmTicks >= 5 && this.func_234041_j_() < this.func_234042_k_() / 2);
    }
}
