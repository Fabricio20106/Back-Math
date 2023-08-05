package com.sophicreeper.backmath.core.world.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class MoodTeaEffect extends MobEffect {
    public MoodTeaEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xcee09f);
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
