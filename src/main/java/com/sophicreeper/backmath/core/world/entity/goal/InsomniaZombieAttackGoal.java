package com.sophicreeper.backmath.core.world.entity.goal;

import com.sophicreeper.backmath.core.world.entity.monster.aljan.InsomniaZombie;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class InsomniaZombieAttackGoal extends MeleeAttackGoal {
    private final InsomniaZombie zombie;
    private int raiseArmTicks;

    public InsomniaZombieAttackGoal(InsomniaZombie insomniaZombie, double speed, boolean useLongMemory) {
        super(insomniaZombie, speed, useLongMemory);
        this.zombie = insomniaZombie;
    }

    public void startExecuting() {
        super.startExecuting();
        this.raiseArmTicks = 0;
    }

    public void resetTask() {
        super.resetTask();
        this.zombie.setAggroed(false);
    }

    public void tick() {
        super.tick();
        ++this.raiseArmTicks;
        this.zombie.setAggroed(this.raiseArmTicks >= 5 && this.func_234041_j_() < this.func_234042_k_() / 2);
    }
}
