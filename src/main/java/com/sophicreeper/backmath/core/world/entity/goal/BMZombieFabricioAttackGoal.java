package com.sophicreeper.backmath.core.world.entity.goal;

import com.sophicreeper.backmath.core.world.entity.monster.aljan.ZombieFabricio;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class BMZombieFabricioAttackGoal extends MeleeAttackGoal {
    private final ZombieFabricio zombie;
    private int raiseArmTicks;

    public BMZombieFabricioAttackGoal(ZombieFabricio zombieFabricio, double p_i46803_2_, boolean p_i46803_4_) {
        super(zombieFabricio, p_i46803_2_, p_i46803_4_);
        this.zombie = zombieFabricio;
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
