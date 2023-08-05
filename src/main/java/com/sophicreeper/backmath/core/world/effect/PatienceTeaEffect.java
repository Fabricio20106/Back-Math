package com.sophicreeper.backmath.core.world.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class PatienceTeaEffect  extends MobEffect {
    public PatienceTeaEffect() {
        super(MobEffectCategory.HARMFUL, 0x1dc2d1);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        // Player was poisoned by Player's tea
        // entity.hurt(BMDamageSources.PATIENCE_TEA, (float) (6 << amplifier));
        // entity.attackEntityFrom(BMDamageSources.PATIENCE_TEA, )
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 10 == 0; // perform effect with 1s of delay
    }
}
