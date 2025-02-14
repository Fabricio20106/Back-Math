package com.sophicreeper.backmath.entity.goal;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class ExtendedMeleeAttackGoal extends MeleeAttackGoal {
    public ExtendedMeleeAttackGoal(CreatureEntity entity, double speedModifier, boolean followIfNotVisible) {
        super(entity, speedModifier, followIfNotVisible);
    }

    @Override
    protected int getAttackInterval() {
        return 10;
    }

    @Override
    protected double getAttackReachSqr(LivingEntity target) {
        return 5 * target.getBbWidth();
    }
}
