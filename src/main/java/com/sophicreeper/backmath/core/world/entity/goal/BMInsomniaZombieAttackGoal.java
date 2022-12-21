package com.sophicreeper.backmath.core.world.entity.goal;

import com.sophicreeper.backmath.core.world.entity.monster.aljan.InsomniaZombie;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class BMInsomniaZombieAttackGoal extends MeleeAttackGoal {
    private final InsomniaZombie zombie;
    private int raiseArmTicks;

    public BMInsomniaZombieAttackGoal(InsomniaZombie insomniaZombie, double p_i46803_2_, boolean p_i46803_4_) {
        super(insomniaZombie, p_i46803_2_, p_i46803_4_);
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
