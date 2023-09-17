package com.sophicreeper.backmath.core.world.feature.tree;

import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class BMTreeFeatures {
    public static TreeConfiguration.TreeConfigurationBuilder createGuaranaOakTree() {
        return createStraightBlobTree(Blocks.OAK_LOG, BMBlocks.GUARANA_OAK_LEAVES.get(), 4, 2, 0, 2).ignoreVines();
    }

    public static TreeConfiguration.TreeConfigurationBuilder createMangoOakTree() {
        return createStraightBlobTree(Blocks.OAK_LOG, BMBlocks.MANGO_OAK_LEAVES.get(), 4, 2, 0, 2).ignoreVines();
    }

    public static TreeConfiguration.TreeConfigurationBuilder createAljameBirchTree() {
        return createStraightBlobTree(Blocks.BIRCH_LOG, BMBlocks.ALJAME_BIRCH_LEAVES.get(), 4, 2, 0, 2).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block log, Block leaves, int trunkHeight, int trunkHeightRandA, int trunkHeightRandB, int foliageRadius) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log),
                new StraightTrunkPlacer(trunkHeight, trunkHeightRandA, trunkHeightRandB),
                BlockStateProvider.simple(leaves),
                new BlobFoliagePlacer(ConstantInt.of(foliageRadius), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1));
    }
}
