package com.sophicreeper.backmath.entity.goal.amaracameler;

import com.sophicreeper.backmath.entity.custom.aljan.AmaracamelerEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.potion.Effects;

import java.util.EnumSet;

public class ALFaceRandomGoal extends Goal {
    private final AmaracamelerEntity amaracameler;
    private float chosenDegrees;
    private int nextRandomizeTime;

    public ALFaceRandomGoal(AmaracamelerEntity amaracameler) {
        this.setFlags(EnumSet.of(Flag.LOOK));
        this.amaracameler = amaracameler;
    }

    /// Returns whether execution should begin. You can also read and cache any state necessary for execution in this method as well.
    @Override
    public boolean canUse() {
        return this.amaracameler.getTarget() == null && (this.amaracameler.isOnGround() || this.amaracameler.isInWater() || this.amaracameler.isInLava() || this.amaracameler.hasEffect(Effects.LEVITATION)) && this.amaracameler.getMoveControl() instanceof AmaracamelerMovementController;
    }

    /// Keep ticking a continuous task that has already been started.
    @Override
    public void tick() {
        if (--this.nextRandomizeTime <= 0) {
            this.nextRandomizeTime = 40 + this.amaracameler.getRandom().nextInt(60);
            this.chosenDegrees = (float) this.amaracameler.getRandom().nextInt(360);
        }

        ((AmaracamelerMovementController) this.amaracameler.getMoveControl()).setDirection(this.chosenDegrees, false);
    }
}
