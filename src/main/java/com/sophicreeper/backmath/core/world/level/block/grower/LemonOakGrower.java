package com.sophicreeper.backmath.core.world.level.block.grower;

import com.sophicreeper.backmath.core.world.feature.BMConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class LemonOakGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource rand, boolean beehive) {
        return BMConfiguredFeatures.LEMON_OAK;
    }
}
