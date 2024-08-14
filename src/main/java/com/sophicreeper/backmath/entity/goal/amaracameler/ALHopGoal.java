package com.sophicreeper.backmath.entity.goal.amaracameler;

import com.sophicreeper.backmath.entity.custom.aljan.AmaracamelerEntity;
import net.minecraft.entity.ai.goal.Goal;

import java.util.EnumSet;

public class ALHopGoal extends Goal {
    private final AmaracamelerEntity amaracameler;

    public ALHopGoal(AmaracamelerEntity amaracameler) {
        this.setFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
        this.amaracameler = amaracameler;
    }

    // Returns whether execution should begin. You can also read and cache any state necessary for execution in this method as well.
    @Override
    public boolean canUse() {
        return !this.amaracameler.isPassenger();
    }

    // Keep ticking a continuous task that has already been started.
    @Override
    public void tick() {
        ((AmaracamelerMovementHelperController) this.amaracameler.getMoveControl()).setSpeed(1);
    }
}
