package com.sophicreeper.backmath.entity.goal.amaracameler;

import com.sophicreeper.backmath.entity.custom.aljan.AmaracamelerEntity;
import net.minecraft.entity.ai.goal.Goal;

import java.util.EnumSet;

public class ALFloatGoal extends Goal {
    private final AmaracamelerEntity amaracameler;

    public ALFloatGoal(AmaracamelerEntity amaracameler) {
        this.setFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
        this.amaracameler = amaracameler;
        amaracameler.getNavigation().setCanFloat(true);
    }

    // Returns whether execution should begin. You can also read and cache any state necessary for execution in this method as well.
    @Override
    public boolean canUse() {
        return (this.amaracameler.isInWall() || this.amaracameler.isInLava()) && this.amaracameler.getMoveControl() instanceof AmaracamelerMovementHelperController;
    }

    // Keep ticking a continuous task that has already been started.
    @Override
    public void tick() {
        if (this.amaracameler.getRandom().nextFloat() < 0.8F) {
            this.amaracameler.getJumpControl().jump();
        }

        ((AmaracamelerMovementHelperController) this.amaracameler.getMoveControl()).setSpeed(1.2D);
    }
}
