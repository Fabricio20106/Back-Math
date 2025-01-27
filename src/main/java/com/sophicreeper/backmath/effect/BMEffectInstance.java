package com.sophicreeper.backmath.effect;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class BMEffectInstance extends EffectInstance {
    private final Supplier<Effect> effectSupplier;

    public BMEffectInstance(Supplier<Effect> effect, int duration) {
        super(null, duration);
        this.effectSupplier = effect;
    }

    @Override
    @Nonnull
    public Effect getEffect() {
        return this.effectSupplier.get();
    }
}
