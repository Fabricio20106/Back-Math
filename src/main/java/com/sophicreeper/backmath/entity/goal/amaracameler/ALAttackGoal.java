package com.sophicreeper.backmath.entity.goal.amaracameler;

import com.sophicreeper.backmath.entity.custom.aljan.AmaracamelerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;

import java.util.EnumSet;

public class ALAttackGoal extends Goal {
    private final AmaracamelerEntity amaracameler;
    private int growTieredTimer;

    public ALAttackGoal(AmaracamelerEntity amaracameler) {
        this.setFlags(EnumSet.of(Flag.LOOK));
        this.amaracameler = amaracameler;
    }

    /// Returns whether execution should begin. You can also read and cache any state necessary for execution in this method as well.
    @Override
    public boolean canUse() {
        LivingEntity target = this.amaracameler.getTarget();
        if (target == null || !target.isAlive()) {
            return false;
        } else {
            return (!(target instanceof PlayerEntity) || !((PlayerEntity) target).abilities.invulnerable) && this.amaracameler.getMoveControl() instanceof AmaracamelerMovementController;
        }
    }

    /// Execute a one shot task or start executing a continuous task.
    @Override
    public void start() {
        this.growTieredTimer = 300;
        super.start();
    }

    /// Returns whether an in-progress {@link Goal} should continue executing.
    @Override
    public boolean canContinueToUse() {
        LivingEntity target = this.amaracameler.getTarget();
        if (target == null || !target.isAlive() || (target instanceof PlayerEntity && ((PlayerEntity) target).abilities.invulnerable)) {
            return false;
        } else {
            return --this.growTieredTimer > 0;
        }
    }

    /// Keep ticking a continuous task that has already been started.
    @Override
    public void tick() {
        if (this.amaracameler.getTarget() != null) this.amaracameler.lookAt(this.amaracameler.getTarget(), 10, 10);
        ((AmaracamelerMovementController) this.amaracameler.getMoveControl()).setDirection(this.amaracameler.yRot, this.amaracameler.canDamageEntity());
    }
}
