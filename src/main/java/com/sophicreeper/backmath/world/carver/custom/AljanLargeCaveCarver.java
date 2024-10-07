package com.sophicreeper.backmath.world.carver.custom;

import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.ProbabilityConfig;

import java.util.Random;

public class AljanLargeCaveCarver extends AljanCaveCarver {
    public AljanLargeCaveCarver(Codec<ProbabilityConfig> codec) {
        super(codec);
    }

    @Override
    protected float getThickness(Random rand) {
        return super.getThickness(rand) + 8;
    }

    @Override
    protected double getYScale() {
        return 3;
    }

    @Override
    protected int getCaveBound() {
        return 30;
    }
}
