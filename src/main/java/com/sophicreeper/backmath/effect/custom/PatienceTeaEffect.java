package com.sophicreeper.backmath.effect.custom;

import com.sophicreeper.backmath.entity.BMDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class PatienceTeaEffect  extends Effect {
    public PatienceTeaEffect() {
        super(EffectType.HARMFUL, 0x1DC2D1);
    }

    @Override
    public void performEffect(LivingEntity livEntity, int amplifier) {
        // Player was poisoned by Player's tea
        livEntity.attackEntityFrom(BMDamageSources.PATIENCE_TEA, (float) (6 << amplifier));
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return duration % 10 == 0; // perform effect with 1s of delay
    }
}
