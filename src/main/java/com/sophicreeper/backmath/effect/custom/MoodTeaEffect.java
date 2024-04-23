package com.sophicreeper.backmath.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class MoodTeaEffect extends Effect {
    public MoodTeaEffect() {
        super(EffectType.BENEFICIAL, 0xCEE09F);
    }

    @Override
    public void applyEffectTick(LivingEntity livEntity, int amplifier) {
        livEntity.getActiveEffects().removeIf(effectInstance -> !effectInstance.getEffect().isBeneficial());
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 10 == 0;
    }
}
