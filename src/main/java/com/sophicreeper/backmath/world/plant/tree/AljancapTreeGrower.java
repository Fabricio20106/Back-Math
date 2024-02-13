package com.sophicreeper.backmath.world.plant.tree;

import com.sophicreeper.backmath.world.BMConfiguredFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class AljancapTreeGrower extends Tree {
    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random random, boolean largeHive) {
        if (random.nextInt(10) == 0) {
            return BMConfiguredFeatures.FANCY_ALJANCAP;
        } else {
            return BMConfiguredFeatures.ALJANCAP;
        }
    }
}
