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
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random rand, boolean hasBeehive) {
        if (rand.nextInt(10) == 0) {
            return BMConfiguredFeatures.FANCY_ALJANCAP_TREE;
        } else {
            return BMConfiguredFeatures.ALJANCAP_TREE;
        }
    }
}
