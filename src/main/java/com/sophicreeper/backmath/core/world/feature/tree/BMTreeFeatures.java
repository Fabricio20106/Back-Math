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

    public static TreeConfiguration.TreeConfigurationBuilder createMangaedMangoOakTree() {
        return createStraightBlobTree(Blocks.OAK_LOG, BMBlocks.MANGAED_MANGO_OAK_LEAVES.get(), 4, 2, 0, 2).ignoreVines();
    }

    public static TreeConfiguration.TreeConfigurationBuilder createGrapeVineOakTree() {
        return createStraightBlobTree(Blocks.SPRUCE_LOG, BMBlocks.GRAPE_VINE_LEAVES.get(), 4, 2, 0, 2).ignoreVines();
    }

    public static TreeConfiguration.TreeConfigurationBuilder createLemonOakTree() {
        return createStraightBlobTree(Blocks.OAK_LOG, BMBlocks.LEMON_OAK_LEAVES.get(), 4, 2, 0, 2).ignoreVines();
    }

    public static TreeConfiguration.TreeConfigurationBuilder createPineappleOakTree() {
        return createStraightBlobTree(Blocks.OAK_LOG, BMBlocks.PINEAPPLE_OAK_LEAVES.get(), 4, 2, 0, 2).ignoreVines();
    }

    public static TreeConfiguration.TreeConfigurationBuilder createOrangeOakTree() {
        return createStraightBlobTree(Blocks.OAK_LOG, BMBlocks.ORANGE_OAK_LEAVES.get(), 4, 2, 0, 2).ignoreVines();
    }

    public static TreeConfiguration.TreeConfigurationBuilder createBananaJungleTree() {
        return createStraightBlobTree(Blocks.JUNGLE_LOG, BMBlocks.BANANA_JUNGLE_LEAVES.get(), 6, 3, 0, 2).ignoreVines();
    }

    public static TreeConfiguration.TreeConfigurationBuilder createGuavaTree() {
        return createStraightBlobTree(BMBlocks.GUAVA_LOG.get(), BMBlocks.GUAVA_LEAVES.get(), 3, 5, 1, 2).ignoreVines();
    }

    public static TreeConfiguration.TreeConfigurationBuilder createJabuticabeira() {
        return createStraightBlobTree(BMBlocks.JABUTICABA_LOG.get(), BMBlocks.JABUTICABA_LEAVES.get(), 10, 5, 10, 2).ignoreVines();
    }

    public static TreeConfiguration.TreeConfigurationBuilder createCrystallineBirchTree() {
        return createStraightBlobTree(BMBlocks.CRYSTALLINE_BIRCH_LOG.get(), BMBlocks.CRYSTALLINE_BIRCH_LEAVES.get(), 4, 2, 0, 2).ignoreVines();
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
