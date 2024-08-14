package com.sophicreeper.backmath.effect.custom;

import com.sophicreeper.backmath.util.BMDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class PatienceTeaEffect  extends Effect {
    public PatienceTeaEffect() {
        super(EffectType.HARMFUL, 0x1DC2D1);
    }

    @Override
    public void applyEffectTick(LivingEntity livEntity, int amplifier) {
        // Player was poisoned by Player's tea
        livEntity.hurt(BMDamageSources.PATIENCE_TEA, (float) (6 << amplifier));
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        // Perform effect with 1 second of delay.
        return duration % 10 == 0;
    }
}
