package com.sophicreeper.backmath.world;

import com.google.common.collect.ImmutableList;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.world.feature.custom.AljanDungeonFeature;
import com.sophicreeper.backmath.world.feature.custom.AngerDungeonFeature;
import com.sophicreeper.backmath.world.ore.BMOreGeneration;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.*;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.trunkplacer.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.GiantTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import java.util.OptionalInt;
import java.util.function.Supplier;

public class BMConfiguredFeatures {
    // Trees
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> GUARANA_OAK_TREE = register("guarana_oak_tree",
            Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(getBackFieldTreeLog()),
                    new SimpleBlockStateProvider(BMBlocks.GUARANA_OAK_LEAVES.get().defaultBlockState()),
                    new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .ignoreVines().build()));

    public static final ConfiguredFeature<?, ?> GUARANA_OAK_TREES = register("guarana_oak_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(GUARANA_OAK_TREE.weighted(0.2F),
                    GUARANA_OAK_TREE.weighted(0.1F)), GUARANA_OAK_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(
                            new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MANGO_OAK_TREE = register("mango_oak_tree",
            Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(getBackFieldTreeLog()),
                    new SimpleBlockStateProvider(BMBlocks.MANGO_OAK_LEAVES.get().defaultBlockState()),
                    new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .ignoreVines().build()));

    public static final ConfiguredFeature<?, ?> MANGO_OAK_TREES = register("mango_oak_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(MANGO_OAK_TREE.weighted(0.2F),
                    MANGO_OAK_TREE.weighted(0.1F)), MANGO_OAK_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(
                            new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LEMON_OAK_TREE = register("lemon_oak_tree",
            Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(getBackFieldTreeLog()),
                    new SimpleBlockStateProvider(BMBlocks.LEMON_OAK_LEAVES.get().defaultBlockState()),
                    new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .ignoreVines().build()));

    public static final ConfiguredFeature<?, ?> LEMON_OAKS_TREES = register("lemon_oak_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(LEMON_OAK_TREE.weighted(0.2F),
                    LEMON_OAK_TREE.weighted(0.1F)), LEMON_OAK_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(
                            new AtSurfaceWithExtraConfig(2, 0.05F, 1))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PINEAPPLE_OAK_TREE = register("pineapple_oak_tree",
            Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(getBackFieldTreeLog()),
                    new SimpleBlockStateProvider(BMBlocks.PINEAPPLE_OAK_LEAVES.get().defaultBlockState()),
                    new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .ignoreVines().build()));

    public static final ConfiguredFeature<?, ?> PINEAPPLE_OAK_TREES = register("pineapple_oak_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(PINEAPPLE_OAK_TREE.weighted(0.2F),
                    PINEAPPLE_OAK_TREE.weighted(0.1F)), PINEAPPLE_OAK_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(
                            new AtSurfaceWithExtraConfig(2, 0.05F, 1))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ORANGE_OAK_TREE = register("orange_oak_tree",
            Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(getBackFieldTreeLog()),
                    new SimpleBlockStateProvider(BMBlocks.ORANGE_OAK_LEAVES.get().defaultBlockState()),
                    new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .ignoreVines().build()));

    public static final ConfiguredFeature<?, ?> ORANGE_OAK_TREES = register("orange_oak_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(ORANGE_OAK_TREE.weighted(0.2F),
                    ORANGE_OAK_TREE.weighted(0.1F)), ORANGE_OAK_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(
                            new AtSurfaceWithExtraConfig(2, 0.05F, 1))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BANANA_JUNGLE_TREE = register("banana_jungle_tree",
            Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(Blocks.JUNGLE_LOG.defaultBlockState()),
                    new SimpleBlockStateProvider(BMBlocks.BANANA_JUNGLE_LEAVES.get().defaultBlockState()),
                    new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
                    new StraightTrunkPlacer(6, 3, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .ignoreVines().build()));

    public static final ConfiguredFeature<?, ?> BANANA_JUNGLE_TREES = register("banana_jungle_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(BANANA_JUNGLE_TREE.weighted(0.2F),
                    BANANA_JUNGLE_TREE.weighted(0.1F)), BANANA_JUNGLE_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(
                            new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CRYSTALLINE_BIRCH_TREE = register("crystalline_birch_tree",
            Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BMBlocks.CRYSTALLINE_BIRCH_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(BMBlocks.CRYSTALLINE_BIRCH_LEAVES.get().defaultBlockState()),
                    new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
                    new StraightTrunkPlacer(6, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .ignoreVines().build()));

    public static final ConfiguredFeature<?, ?> CRYSTALLINE_BIRCH_TREES = register("crystalline_birch_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(CRYSTALLINE_BIRCH_TREE.weighted(
            0.2F), CRYSTALLINE_BIRCH_TREE.weighted(0.1F)), CRYSTALLINE_BIRCH_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(
                            new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> OAK_TREE = register("back_field_oak_tree",
            Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(Blocks.OAK_LOG.defaultBlockState()),
                    new SimpleBlockStateProvider(Blocks.OAK_LEAVES.defaultBlockState()),
                    new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .ignoreVines().build()));

    public static final ConfiguredFeature<?, ?> OAK_TREES = register("back_field_oak_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(OAK_TREE.weighted(0.2F),
                    Features.FANCY_OAK.weighted(0.1F)), OAK_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(
                            new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> GRAPE_VINE_TREE = register("grape_vine_tree",
            Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new SimpleBlockStateProvider(BMBlocks.GRAPE_VINE_LEAVES.get().defaultBlockState()),
                    new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
                    new StraightTrunkPlacer(5, 2, 6),
                    new TwoLayerFeature(1, 0, 1)))
                    .build()));

    public static final ConfiguredFeature<?, ?> GRAPE_VINE_TREES = register("grape_vine_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(GRAPE_VINE_TREE.weighted(0.2F),
                    GRAPE_VINE_TREE.weighted(0.1F)), GRAPE_VINE_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(
                            new AtSurfaceWithExtraConfig(1, 0, 0))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ALJAME_BIRCH_TREE = register("aljame_birch_tree",
            Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(Blocks.BIRCH_LOG.defaultBlockState()),
                    new SimpleBlockStateProvider(BMBlocks.ALJAME_BIRCH_LEAVES.get().defaultBlockState()),
                    new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
                    new StraightTrunkPlacer(5, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .ignoreVines().build()));

    public static final ConfiguredFeature<?, ?> ALJAME_BIRCH_TREES = register("aljame_birch_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(ALJAME_BIRCH_TREE.weighted(0.2F),
                    ALJAME_BIRCH_TREE.weighted(0.1F)), ALJAME_BIRCH_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(
                            new AtSurfaceWithExtraConfig(1, 0, 0))));

    public static final ConfiguredFeature<?, ?> HILLARY_LAKE = register("hillary_lake", Feature.LAKE.configured(new BlockStateFeatureConfig(BMBlocks.HILLARY.get().defaultBlockState())).decorated(Placement.WATER_LAKE.configured(new ChanceConfig(8))));

    // Flowers
    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> BACK_FIELD_FLOWERS_LIST = ImmutableList.of(
            () -> Feature.RANDOM_PATCH.configured(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.FRIED_EGG_FLOWER.get().defaultBlockState()), new SimpleBlockPlacer()).tries(64).noProjection().build()),
            () -> Feature.RANDOM_PATCH.configured(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.RED_YELLOW_ALLIUM.get().defaultBlockState()), new SimpleBlockPlacer()).tries(64).noProjection().build()));

    public static final ConfiguredFeature<?, ?> BACK_FIELD_FLOWER_PATCH = register("back_field_flower_patch", Feature.SIMPLE_RANDOM_SELECTOR.configured(new SingleRandomFeature(BACK_FIELD_FLOWERS_LIST)).count(
            FeatureSpread.of(-3, 4)).decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_SQUARE).count(5));

    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> TURTLE_FRIED_EGG_FLOWER_PATCH_LIST = ImmutableList.of(
            () -> Feature.RANDOM_PATCH.configured(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.TURTLE_FRIED_EGG_FLOWER.get().defaultBlockState()), new SimpleBlockPlacer()).tries(64).noProjection().build()));

    public static final ConfiguredFeature<?, ?> TURTLE_FRIED_EGG_FLOWER_PATCH = register("turtle_fried_egg_flower_patch", Feature.SIMPLE_RANDOM_SELECTOR.configured(new SingleRandomFeature(TURTLE_FRIED_EGG_FLOWER_PATCH_LIST))
            .count(FeatureSpread.of(-3, 4)).decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_SQUARE).count(5));

   // TODO: BACK MATH 1.7.0: ALJAMIC WARS WORLD GENERATION BELOW

    // Vegetation Patches
    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> ALJAN_WOODS_FLOWER_PATCH_LIST = ImmutableList.of(
            () -> Feature.RANDOM_PATCH.configured(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.ALJAN_TULIP.get().defaultBlockState()), new SimpleBlockPlacer()).tries(64).noProjection().build()));

    public static final ConfiguredFeature<?, ?> ALJAN_WOODS_FLOWER_PATCH = register("aljan_woods_flower_patch", Feature.SIMPLE_RANDOM_SELECTOR.configured(new SingleRandomFeature(ALJAN_WOODS_FLOWER_PATCH_LIST)).count(
            FeatureSpread.of(-3, 4)).decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_SQUARE).count(5));

    public static final ConfiguredFeature<?, ?> ALJAN_WOODS_FLOWER_PATCH_SINGLE = register("aljan_woods_flower_patch_single", Feature.FLOWER.configured(Configs.ALJAN_FLOWERS_CONFIG).decorated(
            Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_SQUARE).count(5));

    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> CAPPED_HILLS_FLOWER_PATCH_LIST = ImmutableList.of(
            () -> Feature.RANDOM_PATCH.configured(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.POISON_ROSE.get().defaultBlockState()), new SimpleBlockPlacer()).tries(64).noProjection().build()));

    public static final ConfiguredFeature<?, ?> CAPPED_HILLS_FLOWER_PATCH = register("capped_hills_flower_patch", Feature.SIMPLE_RANDOM_SELECTOR.configured(new SingleRandomFeature(CAPPED_HILLS_FLOWER_PATCH_LIST)).count(
            FeatureSpread.of(-3, 4)).decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_SQUARE).count(5));

    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> INSOMNIAN_WOODS_FLOWER_PATCH_LIST = ImmutableList.of(
            () -> Feature.RANDOM_PATCH.configured(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.GRASS.defaultBlockState()), new SimpleBlockPlacer()).tries(64).noProjection().build()),
            () -> Feature.RANDOM_PATCH.configured(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.INSOMNIAN_TULIP.get().defaultBlockState()), new SimpleBlockPlacer()).tries(64).noProjection().build()));

    public static final ConfiguredFeature<?, ?> INSOMNIAN_WOODS_FLOWER_PATCH = register("insomnian_flower_patch", Feature.SIMPLE_RANDOM_SELECTOR.configured(new SingleRandomFeature(INSOMNIAN_WOODS_FLOWER_PATCH_LIST))
            .count(FeatureSpread.of(-3, 4)).decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_SQUARE).count(5));

    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> AMARACAMEL_STICKS_PLANT_PATCH_LIST = ImmutableList.of(
            () -> Feature.RANDOM_PATCH.configured(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.WILD_CARAMELED_WHEAT.get().defaultBlockState()), new SimpleBlockPlacer()).tries(64).noProjection().build()));

    public static final ConfiguredFeature<?, ?> WILD_CARAMELED_WHEAT_PATCH = register("wild_carameled_wheat_patch", Feature.SIMPLE_RANDOM_SELECTOR.configured(new SingleRandomFeature(AMARACAMEL_STICKS_PLANT_PATCH_LIST))
            .count(FeatureSpread.of(-3, 4)).decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_SQUARE).count(5));

    // Underground Block Blobs
    public static final ConfiguredFeature<?, ?> SLEEPINGSTONE_BLOB = register("sleepingstone_blob", Feature.ORE.configured(new OreFeatureConfig(BMOreGeneration.BASE_STONE_ALJAN, BMBlocks.SLEEPINGSTONE.get().defaultBlockState(), 33))
            .range(80).squared().count(10));

    public static final ConfiguredFeature<?, ?> ALJAMIC_DIRT_BLOB = register("aljamic_dirt_blob", Feature.ORE.configured(new OreFeatureConfig(BMOreGeneration.BASE_STONE_ALJAN, BMBlocks.ALJAMIC_DIRT.get().defaultBlockState(), 33))
            .range(256).squared().count(10));

    public static final ConfiguredFeature<?, ?> INSOGRAVEL_BLOB = register("insogravel_blob", Feature.ORE.configured(new OreFeatureConfig(BMOreGeneration.BASE_STONE_ALJAN, BMBlocks.INSOGRAVEL.get().defaultBlockState(), 33))
            .range(256).squared().count(8));

    // Lakes
    public static final ConfiguredFeature<?, ?> SLEEPISHWATER_LAKE = register("sleepishwater_lake", Feature.LAKE.configured(new BlockStateFeatureConfig(BMBlocks.SLEEPISHWATER.get().defaultBlockState())).decorated(Placement.WATER_LAKE.configured(
            new ChanceConfig(8))));

    // Trees
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ALJANWOOD_TREE = register("aljanwood_tree",
            Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BMBlocks.ALJANWOOD_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(BMBlocks.ALJANWOOD_LEAVES.get().defaultBlockState()),
                    new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .ignoreVines().build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_ALJANWOOD_TREE = register("fancy_aljanwood_tree",
            Feature.TREE.configured(new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BMBlocks.ALJANWOOD_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(BMBlocks.ALJANWOOD_LEAVES.get().defaultBlockState()),
                    new FancyFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))
                    .ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ALJANCAP_TREE = register("aljancap_tree",
            Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BMBlocks.ALJANCAP_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(BMBlocks.ALJANCAP_LEAVES.get().defaultBlockState()),
                    new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
                    new StraightTrunkPlacer(6, 3, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .ignoreVines().build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_ALJANCAP_TREE = register("fancy_aljancap_tree",
            Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BMBlocks.ALJANCAP_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(BMBlocks.ALJANCAP_LEAVES.get().defaultBlockState()),
                    new FancyFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(4), 4),
                    new FancyTrunkPlacer(6, 11, 0),
                    new TwoLayerFeature(0, 0, 0, OptionalInt.of(4))))
                    .ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build()));

    public static final ConfiguredFeature<?, ?> AMARACAP_TREE = register("amaracap_tree",
            Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BMBlocks.ALJANCAP_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(BMBlocks.AMARACAP_LEAVES.get().defaultBlockState()),
                    new BlobFoliagePlacer(FeatureSpread.fixed(3), FeatureSpread.fixed(0), 3),
                    new StraightTrunkPlacer(5, 3, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .maxWaterDepth(1).decorators(ImmutableList.of(LeaveVineTreeDecorator.INSTANCE)).build())
                    .decorated(Features.Placements.HEIGHTMAP_SQUARE)
                    .decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));

    // UPDATE: They can generate now.
    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> ALJANSHROOM_PATCH_LIST = ImmutableList.of(
            () -> Feature.RANDOM_PATCH.configured(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.ALJANSHROOM.get().defaultBlockState()), new SimpleBlockPlacer()).tries(64).noProjection().build()));

    public static final ConfiguredFeature<?, ?> ALJANSHROOM_PATCH = register("aljanshroom_patch", Feature.SIMPLE_RANDOM_SELECTOR.configured(new SingleRandomFeature(ALJANSHROOM_PATCH_LIST)).count(
            FeatureSpread.of(-3, 4)).decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_SQUARE).count(5));

    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> SLEEPSHROOM_PATCH_LIST = ImmutableList.of(
            () -> Feature.RANDOM_PATCH.configured(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.SLEEPSHROOM.get().defaultBlockState()), new SimpleBlockPlacer()).tries(64).noProjection().build()));

    public static final ConfiguredFeature<?, ?> SLEEPSHROOM_PATCH = register("sleepshroom_patch", Feature.SIMPLE_RANDOM_SELECTOR.configured(new SingleRandomFeature(SLEEPSHROOM_PATCH_LIST)).count(
            FeatureSpread.of(-3, 4)).decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_SQUARE).count(5));

    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> SLEEPYSHROOM_PATCH_LIST = ImmutableList.of(
            () -> Feature.RANDOM_PATCH.configured(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.SLEEPYSHROOM.get().defaultBlockState()), new SimpleBlockPlacer()).tries(64).noProjection().build()));

    public static final ConfiguredFeature<?, ?> SLEEPYSHROOM_PATCH = register("sleepyshroom_patch", Feature.SIMPLE_RANDOM_SELECTOR.configured(new SingleRandomFeature(SLEEPYSHROOM_PATCH_LIST)).count(
            FeatureSpread.of(-3, 4)).decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_SQUARE).count(5));

    // Underwater Block Patches. These are called "disks" officially.
    public static final ConfiguredFeature<?, ?> INSOGRAVEL_DISK = register("insogravel_disk", Feature.DISK.configured(new SphereReplaceConfig(BMBlocks.INSOGRAVEL.get().defaultBlockState(), FeatureSpread.of(2, 1),
                    1, ImmutableList.of(BMBlocks.ALJAMIC_DIRT.get().defaultBlockState(), BMBlocks.INSOGRAVEL.get().defaultBlockState()))).decorated(Features.Placements.TOP_SOLID_HEIGHTMAP_SQUARE));

    // Used in world generation to make trees generate randomly, and not in every 4-chunk borders.
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> INSOMNIAN_TREE = register("insomnian_tree",
            Feature.TREE.configured(new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BMBlocks.INSOMNIAN_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(BMBlocks.INSOMNIAN_LEAVES.get().defaultBlockState()),
                    new DarkOakFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
                    new DarkOakTrunkPlacer(6, 2, 1),
                    new ThreeLayerFeature(1, 1, 0, 1, 2, OptionalInt.empty()))
                    .maxWaterDepth(Integer.MAX_VALUE).heightmap(Heightmap.Type.MOTION_BLOCKING).ignoreVines().build()));

    public static final ConfiguredFeature<?, ?> ALJANWOOD_TREES = register("aljanwood_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(FANCY_ALJANWOOD_TREE.weighted(0.2F),
                    ALJANWOOD_TREE.weighted(0.1F)), ALJANWOOD_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(
                            new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> ALJANCAP_TREES = register("aljancap_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(FANCY_ALJANCAP_TREE.weighted(0.2F),
                    ALJANCAP_TREE.weighted(0.1F)), ALJANCAP_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(
                            new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> INSOMNIAN_TREES = register("insomnian_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(INSOMNIAN_TREE.weighted(0.2F),
                    INSOMNIAN_TREE.weighted(0.1F)), INSOMNIAN_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(
                            new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

    // TODO: BACK MATH 1.7.0: ALJAMIC WARS CONTENTS ENDS HERE

    // TODO: BACK MATH 1.8.0: BOUNTIFULLY EXPANSIVE CONTENT STARTS HERE

    // Trees
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MANGAED_MANGO_OAK_TREE = register("mangaed_mango_oak_tree",
            Feature.TREE.configured(new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(getBackFieldTreeLog()),
                    new SimpleBlockStateProvider(BMBlocks.MANGAED_MANGO_OAK_LEAVES.get().defaultBlockState()),
                    new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))
                    .ignoreVines().build()));

    public static final ConfiguredFeature<?, ?> MANGAED_MANGO_OAK_TREES = register("mangaed_mango_oak_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(MANGAED_MANGO_OAK_TREE.weighted(
            0.2F), MANGAED_MANGO_OAK_TREE.weighted(0.1F)), MANGAED_MANGO_OAK_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(
                    new AtSurfaceWithExtraConfig(2, 0.05F, 1))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> GUAVA_TREE = register("guava_tree",
            Feature.TREE.configured(new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BMBlocks.GUAVA_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(BMBlocks.GUAVA_LEAVES.get().defaultBlockState()),
                    new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
                    new StraightTrunkPlacer(3, 5, 1),
                    new TwoLayerFeature(1, 0, 1))
                    .ignoreVines().build()));

    public static final ConfiguredFeature<?, ?> GUAVA_TREES = register("guava_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(GUAVA_TREE.weighted(0.2F),
            GUAVA_TREE.weighted(0.1F)), GUAVA_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(
                    new AtSurfaceWithExtraConfig(2, 0.05F, 1))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CORK_OAK_TREE = register("cork_oak_tree",
            Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BMBlocks.CORK_OAK_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(BMBlocks.CORK_OAK_LEAVES.get().defaultBlockState()),
                    new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .ignoreVines().build()));

    public static final ConfiguredFeature<?, ?> ALJAMIC_SAND_DISK = register("aljamic_sand_disk", Feature.DISK.configured(new SphereReplaceConfig(BMBlocks.ALJAMIC_SAND.get().defaultBlockState(),
                    FeatureSpread.of(2, 1), 1, ImmutableList.of(BMBlocks.ALJAMIC_DIRT.get().defaultBlockState(), BMBlocks.ALJAMIC_SAND.get().defaultBlockState())))
            .decorated(Features.Placements.TOP_SOLID_HEIGHTMAP_SQUARE));

    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> WILD_ALJAMIC_ONIONS_PATCH_LIST = ImmutableList.of(
            () -> Feature.RANDOM_PATCH.configured(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.WILD_ALJAMIC_ONIONS.get().defaultBlockState()), new SimpleBlockPlacer()).tries(64).noProjection().build()));

    public static final ConfiguredFeature<?, ?> WILD_ALJAMIC_ONIONS_PATCH = register("wild_aljamic_onions_patch", Feature.SIMPLE_RANDOM_SELECTOR.configured(new SingleRandomFeature(WILD_ALJAMIC_ONIONS_PATCH_LIST)).count(
            FeatureSpread.of(-3, 4)).decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_SQUARE).count(5));

    public static final ConfiguredFeature<?, ?> ALJAMIC_ORCHARD_TREES = register("aljamic_orchard_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(FANCY_ALJANWOOD_TREE.weighted(
            0.2F), ALJANWOOD_TREE.weighted(0.1F)), ALJANWOOD_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(
                    new AtSurfaceWithExtraConfig(1, 0.1F, 0))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_GOLDENWOOD_TREE = register("fancy_goldenwood_tree",
            Feature.TREE.configured(new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BMBlocks.GOLDENWOOD_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(BMBlocks.GOLDENWOOD_LEAVES.get().defaultBlockState()),
                    new FancyFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))
                    .ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_ENCHANTED_GOLDENWOOD_TREE = register("fancy_enchanted_goldenwood_tree",
            Feature.TREE.configured(new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BMBlocks.GOLDENWOOD_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(BMBlocks.ENCHANTED_GOLDENWOOD_LEAVES.get().defaultBlockState()),
                    new FancyFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))
                    .ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> JABUTICABA_TREE = register("jabuticaba_tree",
            Feature.TREE.configured(new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BMBlocks.JABUTICABA_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(BMBlocks.JABUTICABA_LEAVES.get().defaultBlockState()),
                    new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
                    new StraightTrunkPlacer(10, 5, 10),
                    new TwoLayerFeature(1, 0, 1))
                    .ignoreVines().build()));

    public static final ConfiguredFeature<?, ?> JABUTICABA_TREES = register("jabuticaba_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(JABUTICABA_TREE.weighted(0.2F),
            JABUTICABA_TREE.weighted(0.1F)), JABUTICABA_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(
                    new AtSurfaceWithExtraConfig(2, 0.05F, 1))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> AVONDALIC_WILLOW_TREE = register("avondalic_willow_tree",
            Feature.TREE.configured(new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BMBlocks.AVONDALIC_WILLOW_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(BMBlocks.AVONDALIC_WILLOW_LEAVES.get().defaultBlockState()),
                    new SpruceFoliagePlacer(FeatureSpread.of(2, 1), FeatureSpread.of(0, 2), FeatureSpread.of(1, 1)),
                    new StraightTrunkPlacer(5, 2, 1),
                    new TwoLayerFeature(2, 0, 2))
                    .ignoreVines().build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MEGA_AVONDALIC_WILLOW_TREE = register("mega_avondalic_willow_tree",
            Feature.TREE.configured(new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BMBlocks.AVONDALIC_WILLOW_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(BMBlocks.AVONDALIC_WILLOW_LEAVES.get().defaultBlockState()),
                    new MegaPineFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0), FeatureSpread.of(3, 4)),
                    new GiantTrunkPlacer(6, 2, 14),
                    new TwoLayerFeature(1, 1, 2))
                    .build()));

    public static final ConfiguredFeature<?, ?> AVONDALIC_WILLOW_TREES = register("avondalic_willow_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(MEGA_AVONDALIC_WILLOW_TREE.weighted(
            0.85641026F), AVONDALIC_WILLOW_TREE.weighted(0.99F)), AVONDALIC_WILLOW_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured( // 85.641026%
                    new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> AVONDALIC_BUSH = register("avondalic_bush",
            Feature.TREE.configured(new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BMBlocks.AVONDALIC_WILLOW_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(BMBlocks.AVONDALIC_WILLOW_LEAVES.get().defaultBlockState()),
                    new BushFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(1), 2),
                    new StraightTrunkPlacer(1, 0, 0),
                    new TwoLayerFeature(0, 0, 0))
                    .heightmap(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES).build()));

    public static final ConfiguredFeature<?, ?> AVONDALIC_BUSHES = register("avondalic_bushes", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(AVONDALIC_BUSH.weighted(0.2F),
            AVONDALIC_WILLOW_TREE.weighted(0.05F), Features.PATCH_GRASS_PLAIN.weighted(0.3f)), AVONDALIC_BUSH)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(
                    new AtSurfaceWithExtraConfig(50, 0.1F, 1))));

    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> ENDER_DRAGON_FRIED_EGG_FLOWER_PATCH_LIST = ImmutableList.of(
            () -> Feature.RANDOM_PATCH.configured(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.ENDER_DRAGON_FRIED_EGG_FLOWER.get().defaultBlockState()), new SimpleBlockPlacer()).tries(64).noProjection()
                    .build()));

    public static final ConfiguredFeature<?, ?> ENDER_DRAGON_FRIED_EGG_FLOWER_PATCH = register("ender_dragon_fried_egg_flower_patch", Feature.SIMPLE_RANDOM_SELECTOR.configured(new SingleRandomFeature(
            ENDER_DRAGON_FRIED_EGG_FLOWER_PATCH_LIST)).count(FeatureSpread.of(-3, 4)).decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_SQUARE)
            .count(5));

    public static final ConfiguredFeature<?, ?> ALJANCAP_LEAF_PILE = register("aljancap_leaf_pile", Feature.BLOCK_PILE.configured(new BlockStateProvidingFeatureConfig(new WeightedBlockStateProvider().add(
            BMBlocks.ALJANCAP_LEAVES.get().defaultBlockState(), 19))));

    // Dungeons
    public static final ConfiguredFeature<?, ?> ALJAN_DUNGEON = register("aljan_dungeon", new AljanDungeonFeature(NoFeatureConfig.CODEC).configured(IFeatureConfig.NONE).range(256).squared()
            .count(8));

    public static final ConfiguredFeature<?, ?> ANGER_DUNGEON = register("anger_dungeon", new AngerDungeonFeature(NoFeatureConfig.CODEC).configured(IFeatureConfig.NONE).range(256).squared()
            .count(8));

    public static final ConfiguredFeature<?, ?> TABU_BLOB = register("tabu_blob", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BMBlocks.TABU.get().defaultBlockState(), 23))
            .range(80).squared().count(10));

    // TODO: BACK MATH 1.8.0: BOUNTIFULLY EXPANSIVE CONTENT ENDS HERE

    public static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, BackMath.backMath(name), configuredFeature);
    }

    public static BlockState getBackFieldTreeLog() {
        return Blocks.OAK_LOG.defaultBlockState();
    }

    public static final class Configs {
        public static final BlockClusterFeatureConfig ALJAN_FLOWERS_CONFIG = new BlockClusterFeatureConfig.Builder(new WeightedBlockStateProvider().add(BMBlocks.ALJAN_TULIP.get().defaultBlockState(), 2), SimpleBlockPlacer.INSTANCE)
                .tries(64).build();
    }
}
