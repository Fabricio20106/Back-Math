package com.sophicreeper.backmath.world.plant.tree;

import com.sophicreeper.backmath.world.BMFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class AljanwoodTreeGrower extends Tree {
    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive) {
        if (randomIn.nextInt(10) == 0) {
            return BMFeatures.FANCY_ALJANWOOD;
        } else {
            return BMFeatures.ALJANWOOD;
        }
    }
}
