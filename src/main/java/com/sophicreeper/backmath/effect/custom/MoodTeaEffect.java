package com.sophicreeper.backmath.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class MoodTeaEffect extends Effect {
    public MoodTeaEffect() {
        super(EffectType.BENEFICIAL, 0xCEE09F);
    }

    @Override
    public void performEffect(LivingEntity livEntity, int amplifier) {
        livEntity.getActivePotionEffects().removeIf(effectInstance -> !effectInstance.getPotion().isBeneficial());
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return duration % 10 == 0;
    }
}
