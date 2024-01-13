package com.sophicreeper.backmath.world;

import com.google.common.collect.ImmutableList;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.world.feature.AljanDungeonFeature;
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

public class BMFeatures {
    // Trees
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> GUARANA_OAK = register("guarana_oak",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.getBackFieldTreeLog()),
                    new SimpleBlockStateProvider(States.GUARANA_OAK_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .setIgnoreVines().build()));

    public static final ConfiguredFeature<?, ?> GUARANA_OAKS = register("guarana_oaks",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(GUARANA_OAK.withChance(0.2F), GUARANA_OAK.withChance(0.1F)), GUARANA_OAK))
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MANGO_OAK = register("mango_oak",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.getBackFieldTreeLog()),
                    new SimpleBlockStateProvider(States.MANGO_OAK_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .setIgnoreVines().build()));

    public static final ConfiguredFeature<?, ?> MANGO_OAKS = register("mango_oaks",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(MANGO_OAK.withChance(0.2F), MANGO_OAK.withChance(0.1F)), MANGO_OAK))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LEMON_OAK = register("lemon_oak",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.getBackFieldTreeLog()),
                    new SimpleBlockStateProvider(States.LEMON_OAK_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .setIgnoreVines().build()));

    public static final ConfiguredFeature<?, ?> LEMON_OAKS = register("lemon_oaks",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(LEMON_OAK.withChance(0.2F), LEMON_OAK.withChance(0.1F)), LEMON_OAK))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.05F, 1))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PINEAPPLE_OAK = register("pineapple_oak",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.getBackFieldTreeLog()),
                    new SimpleBlockStateProvider(BMBlocks.PINEAPPLE_OAK_LEAVES.get().getDefaultState()),
                    new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .setIgnoreVines().build()));

    public static final ConfiguredFeature<?, ?> PINEAPPLE_OAKS = register("pineapple_oaks",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(PINEAPPLE_OAK.withChance(0.2F), PINEAPPLE_OAK.withChance(0.1F)), PINEAPPLE_OAK))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.05F, 1))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ORANGE_OAK = register("orange_oak",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.getBackFieldTreeLog()),
                    new SimpleBlockStateProvider(BMBlocks.ORANGE_OAK_LEAVES.get().getDefaultState()),
                    new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .setIgnoreVines().build()));

    public static final ConfiguredFeature<?, ?> ORANGE_OAKS = register("orange_oaks",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(ORANGE_OAK.withChance(0.2F), ORANGE_OAK.withChance(0.1F)), ORANGE_OAK))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.05F, 1))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BANANA_JUNGLE = register("banana_jungle",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.JUNGLE_LOG.getDefaultState()),
                    new SimpleBlockStateProvider(BMBlocks.BANANA_JUNGLE_LEAVES.get().getDefaultState()),
                    new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
                    new StraightTrunkPlacer(6, 3, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .setIgnoreVines().build()));

    public static final ConfiguredFeature<?, ?> BANANA_JUNGLES = register("banana_jungles",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BANANA_JUNGLE.withChance(0.2F), BANANA_JUNGLE.withChance(0.1F)), BANANA_JUNGLE))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CRYSTALLINE_BIRCH = register("crystalline_birch",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.CRYSTALLINE_BIRCH_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(BMBlocks.CRYSTALLINE_BIRCH_LEAVES.get().getDefaultState()),
                    new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .setIgnoreVines().build()));

    public static final ConfiguredFeature<?, ?> CRYSTALLINE_BIRCHES = register("crystalline_birches",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(CRYSTALLINE_BIRCH.withChance(0.2F), CRYSTALLINE_BIRCH.withChance(0.1F)), CRYSTALLINE_BIRCH))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> OAK = register("vanilla_oak",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
                    new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
                    new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .setIgnoreVines().build()));

    public static final ConfiguredFeature<?, ?> OAKS = register("vanilla_oaks",
            Feature.RANDOM_SELECTOR.withConfiguration(
                    new MultipleRandomFeatureConfig(ImmutableList.of(OAK.withChance(0.2F), OAK.withChance(0.1F)), OAK))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> GRAPE_VINE = register("grape_vine",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.SPRUCE_LOG),
                    new SimpleBlockStateProvider(States.GRAPE_VINE_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
                    new StraightTrunkPlacer(5, 2, 6),
                    new TwoLayerFeature(1, 0, 1)))
                    .build()));

    public static final ConfiguredFeature<?, ?> GRAPE_VINES = register("grape_vines",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(GRAPE_VINE.withChance(0.2F), GRAPE_VINE.withChance(0.1F)), GRAPE_VINE))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.0f, 0))));

    // Back Math 1.6.0: Aljame Birch trees
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ALJAME_BIRCH = register("aljame_birch",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.BIRCH_LOG),
                    new SimpleBlockStateProvider(States.ALJAME_BIRCH_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .setIgnoreVines().build()));

    public static final ConfiguredFeature<?, ?> ALJAME_BIRCHES = register("aljame_birches",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(ALJAME_BIRCH.withChance(0.2F), ALJAME_BIRCH.withChance(0.1F)), ALJAME_BIRCH))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.0f, 0))));

    public static final ConfiguredFeature<?, ?> HILLARY_LAKE = register("hillary_lake", Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(States.HILLARY))
            .withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(8))));

    // Flowers
    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> BACK_FIELD_FLOWERS_IL = ImmutableList.of(
            () -> Feature.RANDOM_PATCH.withConfiguration(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(States.FRIED_EGG_FLOWER), new SimpleBlockPlacer()).tries(64).func_227317_b_().build()),
            () -> Feature.RANDOM_PATCH.withConfiguration(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.RED_YELLOW_FLOWER.get().getDefaultState()), new SimpleBlockPlacer()).tries(64).func_227317_b_().build())
    );

    public static final ConfiguredFeature<?, ?> BACK_FIELD_FLOWER_PATCH = register("backmath_flower_patch", Feature.SIMPLE_RANDOM_SELECTOR.withConfiguration(
            new SingleRandomFeature(BACK_FIELD_FLOWERS_IL)).func_242730_a(FeatureSpread.func_242253_a(-3, 4)).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(5));

    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> TURTLE_FRIED_EGG_FLOWER_PATCH_IL = ImmutableList.of(() -> Feature.RANDOM_PATCH.withConfiguration(
            new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(States.TURTLE_FRIED_EGG_FLOWER), new SimpleBlockPlacer()).tries(64).func_227317_b_().build()));

    public static final ConfiguredFeature<?, ?> TURTLE_FRIED_EGG_FLOWER_PATCH = register("backmath_beach_flower_patch", Feature.SIMPLE_RANDOM_SELECTOR.withConfiguration(new
            SingleRandomFeature(TURTLE_FRIED_EGG_FLOWER_PATCH_IL)).func_242730_a(FeatureSpread.func_242253_a(-3, 4)).withPlacement(Features.Placements.
            VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(5));

   // TODO: BACK MATH 1.7.0: ALJAMIC WARS WORLD GENERATION BELOW

    // Vegetation Patches
    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> ALJAN_WOODS_FLOWER_PATCH_IL = ImmutableList.of(() -> Feature.RANDOM_PATCH.withConfiguration(
            new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.ALJAN_TULIP.get().getDefaultState()), new SimpleBlockPlacer()).tries(64).func_227317_b_().build()));

    public static final ConfiguredFeature<?, ?> ALJAN_WOODS_FLOWER_PATCH = register("aljan_woods_flower_patch", Feature.SIMPLE_RANDOM_SELECTOR.withConfiguration(
            new SingleRandomFeature(ALJAN_WOODS_FLOWER_PATCH_IL)).func_242730_a(FeatureSpread.func_242253_a(-3, 4)).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(5));

    public static final ConfiguredFeature<?, ?> ALJAN_WOODS_FLOWER_PATCH_SINGLE = register("aljan_woods_flower_patch_single", Feature.FLOWER.withConfiguration(
            Configs.ALJAN_FLOWERS_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
            .func_242731_b(5));

    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> CAPPED_HILLS_FLOWER_PATCH_IL = ImmutableList.of(() -> Feature.RANDOM_PATCH.withConfiguration(
            new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.POISON_ROSE.get().getDefaultState()), new SimpleBlockPlacer()).tries(64).func_227317_b_().build()));

    public static final ConfiguredFeature<?, ?> CAPPED_HILLS_FLOWER_PATCH = register("capped_hills_flower_patch", Feature.SIMPLE_RANDOM_SELECTOR.withConfiguration(
            new SingleRandomFeature(CAPPED_HILLS_FLOWER_PATCH_IL)).func_242730_a(FeatureSpread.func_242253_a(-3, 4)).withPlacement(Features.Placements.VEGETATION_PLACEMENT)
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(5));

    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> INSOMNIAN_WOODS_FLOWER_PATCH_IL = ImmutableList.of(() -> Feature.RANDOM_PATCH.withConfiguration(
            new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.GRASS.getDefaultState()), new SimpleBlockPlacer()).tries(64).func_227317_b_().build()), () -> Feature.RANDOM_PATCH.withConfiguration(
                    new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.INSOMNIAN_TULIP.get().getDefaultState()), new SimpleBlockPlacer()).tries(64).func_227317_b_().build()));

    public static final ConfiguredFeature<?, ?> INSOMNIAN_WOODS_FLOWER_PATCH = register("insomnian_flower_patch", Feature.SIMPLE_RANDOM_SELECTOR.withConfiguration(
            new SingleRandomFeature(INSOMNIAN_WOODS_FLOWER_PATCH_IL)).func_242730_a(FeatureSpread.func_242253_a(-3, 4))
            .withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(5));

    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> AMARACAMEL_STICKS_WCW_PATCH_IL = ImmutableList.of(() -> Feature.RANDOM_PATCH.withConfiguration(
            new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.WILD_CARAMELED_WHEAT.get().getDefaultState()), new SimpleBlockPlacer()).tries(64).func_227317_b_().build()));

    public static final ConfiguredFeature<?, ?> AMARACAMEL_STICKS_WCW_PATCH = register("wild_carameled_wheat_patch", Feature.SIMPLE_RANDOM_SELECTOR.withConfiguration(
            new SingleRandomFeature(AMARACAMEL_STICKS_WCW_PATCH_IL)).func_242730_a(FeatureSpread.func_242253_a(-3, 4))
            .withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(5));

    // Underground Block Blobs
    public static final ConfiguredFeature<?, ?> SLEEPINGSTONE_BLOB = register("sleepingstone_blob", Feature.ORE.withConfiguration(
            new OreFeatureConfig(BMOreGeneration.BASE_STONE_ALJAN, BMBlocks.SLEEPINGSTONE.get().getDefaultState(), 33)).range(80).square().func_242731_b(10));

    public static final ConfiguredFeature<?, ?> ALJAMIC_DIRT_BLOB = register("aljamic_dirt_blob", Feature.ORE.withConfiguration(
            new OreFeatureConfig(BMOreGeneration.BASE_STONE_ALJAN, BMBlocks.ALJAMIC_DIRT.get().getDefaultState(), 33)).range(256).square().func_242731_b(10));

    public static final ConfiguredFeature<?, ?> INSOGRAVEL_BLOB = register("insogravel_blob", Feature.ORE.withConfiguration(
            new OreFeatureConfig(BMOreGeneration.BASE_STONE_ALJAN, BMBlocks.INSOGRAVEL.get().getDefaultState(), 33)).range(256).square().func_242731_b(8));

    // Lakes
    public static final ConfiguredFeature<?, ?> SLEEPISHWATER_LAKE = register("sleepishwater_lake", Feature.LAKE.withConfiguration(
            new BlockStateFeatureConfig(BMBlocks.SLEEPISHWATER.get().getDefaultState())).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(8))));

    // Trees
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ALJANWOOD = register("aljanwood",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.ALJANWOOD_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(BMBlocks.ALJANWOOD_LEAVES.get().getDefaultState()),
                    new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .setIgnoreVines().build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_ALJANWOOD = register("fancy_aljanwood",
            Feature.TREE.withConfiguration(new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.ALJANWOOD_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(BMBlocks.ALJANWOOD_LEAVES.get().getDefaultState()),
                    new FancyFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))
                    .setIgnoreVines().func_236702_a_(Heightmap.Type.MOTION_BLOCKING).build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ALJANCAP = register("aljancap",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.ALJANCAP_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(BMBlocks.ALJANCAP_LEAVES.get().getDefaultState()),
                    new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
                    new StraightTrunkPlacer(6, 3, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .setIgnoreVines().build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_ALJANCAP = register("fancy_aljancap",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.ALJANCAP_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(BMBlocks.ALJANCAP_LEAVES.get().getDefaultState()),
                    new FancyFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(4), 4),
                    new FancyTrunkPlacer(6, 11, 0),
                    new TwoLayerFeature(0, 0, 0, OptionalInt.of(4))))
                    .setIgnoreVines().func_236702_a_(Heightmap.Type.MOTION_BLOCKING).build()));

    public static final ConfiguredFeature<?, ?> AMARACAP = register("amaracap",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.ALJANCAP_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(BMBlocks.AMARACAP_LEAVES.get().getDefaultState()),
                    new BlobFoliagePlacer(FeatureSpread.func_242252_a(3), FeatureSpread.func_242252_a(0), 3),
                    new StraightTrunkPlacer(5, 3, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .setMaxWaterDepth(1).setDecorators(ImmutableList.of(LeaveVineTreeDecorator.field_236871_b_)).build())
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));

    // Mushroom patches. They aren't actually being generated because they can't be placed on grass block at plain sunlight.
    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> ALJANSHROOM_PATCH_LIST = ImmutableList.of(() -> Feature.RANDOM_PATCH.withConfiguration(
            new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.ALJANSHROOM.get().getDefaultState()), new SimpleBlockPlacer()).tries(64).func_227317_b_().build()));

    public static final ConfiguredFeature<?, ?> ALJANSHROOM_PATCH = register("patch_aljanshroom", Feature.SIMPLE_RANDOM_SELECTOR.withConfiguration(
                    new SingleRandomFeature(ALJANSHROOM_PATCH_LIST)).func_242730_a(FeatureSpread.func_242253_a(-3, 4))
            .withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(5));

    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> SLEEPSHROOM_PATCH_LIST = ImmutableList.of(() -> Feature.RANDOM_PATCH.withConfiguration(
            new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.SLEEPSHROOM.get().getDefaultState()), new SimpleBlockPlacer()).tries(64).func_227317_b_().build()));

    public static final ConfiguredFeature<?, ?> SLEEPSHROOM_PATCH = register("patch_sleepshroom", Feature.SIMPLE_RANDOM_SELECTOR.withConfiguration(
                    new SingleRandomFeature(SLEEPSHROOM_PATCH_LIST)).func_242730_a(FeatureSpread.func_242253_a(-3, 4))
            .withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(5));

    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> SLEEPYSHROOM_PATCH_LIST = ImmutableList.of(() -> Feature.RANDOM_PATCH.withConfiguration(
            new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.SLEEPYSHROOM.get().getDefaultState()), new SimpleBlockPlacer()).tries(64).func_227317_b_().build()));

    public static final ConfiguredFeature<?, ?> SLEEPYSHROOM_PATCH = register("patch_sleepyshroom", Feature.SIMPLE_RANDOM_SELECTOR.withConfiguration(
                    new SingleRandomFeature(SLEEPYSHROOM_PATCH_LIST)).func_242730_a(FeatureSpread.func_242253_a(-3, 4))
            .withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(5));

    // Ocean block patches (like clay), and they're actually called "disks".
    public static final ConfiguredFeature<?, ?> INSOGRAVEL_DISK = register("disk_insogravel", Feature.DISK.withConfiguration(new SphereReplaceConfig(BMBlocks.INSOGRAVEL.get().getDefaultState(),
            FeatureSpread.func_242253_a(2, 1), 1, ImmutableList.of(BMBlocks.ALJAMIC_DIRT.get().getDefaultState(), BMBlocks.INSOGRAVEL.get().getDefaultState())))
            .withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT));

    // Used in world generation to make trees generate randomly, and not in every 4-chunk borders.
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> INSOMNIAN = register("insomnian",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.INSOMNIAN_LOG),
                    new SimpleBlockStateProvider(States.INSOMNIAN_LEAVES),
                    new DarkOakFoliagePlacer(FeatureSpread.func_242252_a(0), FeatureSpread.func_242252_a(0)),
                    new DarkOakTrunkPlacer(6, 2, 1),
                    new ThreeLayerFeature(1, 1, 0, 1, 2, OptionalInt.empty())))
                    .setMaxWaterDepth(Integer.MAX_VALUE).func_236702_a_(Heightmap.Type.MOTION_BLOCKING).setIgnoreVines().build()));

    public static final ConfiguredFeature<?, ?> ALJANWOODS = register("aljanwoods", Feature.RANDOM_SELECTOR.withConfiguration(
            new MultipleRandomFeatureConfig(ImmutableList.of(FANCY_ALJANWOOD.withChance(0.2F), ALJANWOOD.withChance(0.1F)), ALJANWOOD))
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> ALJANCAPS = register("aljancaps", Feature.RANDOM_SELECTOR.withConfiguration(
            new MultipleRandomFeatureConfig(ImmutableList.of(FANCY_ALJANCAP.withChance(0.2F), ALJANCAP.withChance(0.1F)), ALJANCAP))
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> INSOMNIANS = register("insomnians", Feature.RANDOM_SELECTOR.withConfiguration(
            new MultipleRandomFeatureConfig(ImmutableList.of(INSOMNIAN.withChance(0.2F), INSOMNIAN.withChance(0.1F)), INSOMNIAN))
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

    // TODO: BACK MATH 1.7.0: ALJAMIC WARS CONTENTS ENDS HERE

    // TODO: BACK MATH 1.8.0: BOUNTIFULLY EXPANSIVE CONTENT STARTS HERE

    // Trees
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MANGAED_MANGO_OAK = register("mangaed_mango_oak",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.getBackFieldTreeLog()),
                    new SimpleBlockStateProvider(BMBlocks.MANGAED_MANGO_OAK_LEAVES.get().getDefaultState()),
                    new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .setIgnoreVines().build()));

    public static final ConfiguredFeature<?, ?> MANGAED_MANGO_OAKS = register("mangaed_mango_oaks", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            MANGAED_MANGO_OAK.withChance(0.2F), MANGAED_MANGO_OAK.withChance(0.1F)), MANGAED_MANGO_OAK)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(
                    Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.05F, 1))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> GUAVA_TREE = register("guava_tree", Feature.TREE.withConfiguration(new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(
            BMBlocks.GUAVA_LOG.get().getDefaultState()), new SimpleBlockStateProvider(BMBlocks.GUAVA_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2),
            FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(3, 5, 1), new TwoLayerFeature(1, 0,
            1)).setIgnoreVines().build()));

    public static final ConfiguredFeature<?, ?> GUAVA_TREES = register("guava_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(GUAVA_TREE
            .withChance(0.2f), GUAVA_TREE.withChance(0.1f)), GUAVA_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
                    new AtSurfaceWithExtraConfig(2, 0.05f, 1))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CORK_OAK = register("cork_oak",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.CORK_OAK_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(BMBlocks.CORK_OAK_LEAVES.get().getDefaultState()),
                    new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .setIgnoreVines().build()));

    public static final ConfiguredFeature<?, ?> ALJAMIC_SAND_DISK = register("disk_aljamic_sand", Feature.DISK.withConfiguration(new SphereReplaceConfig(BMBlocks.ALJAMIC_SAND.get().getDefaultState(),
            FeatureSpread.func_242253_a(2, 1), 1, ImmutableList.of(BMBlocks.ALJAMIC_DIRT.get().getDefaultState(), BMBlocks.ALJAMIC_SAND.get().getDefaultState())))
            .withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT));

    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> ALJAN_WOODS_WAO_PATCH_IL = ImmutableList.of(() -> Feature.RANDOM_PATCH.withConfiguration(
            new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.WILD_ALJAMIC_ONIONS.get().getDefaultState()), new SimpleBlockPlacer()).tries(64).func_227317_b_().build()));

    public static final ConfiguredFeature<?, ?> ALJAN_WOODS_WAO_PATCH = register("wild_aljamic_onions_patch", Feature.SIMPLE_RANDOM_SELECTOR.withConfiguration(
                    new SingleRandomFeature(ALJAN_WOODS_WAO_PATCH_IL)).func_242730_a(FeatureSpread.func_242253_a(-3, 4))
            .withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(5));

    public static final ConfiguredFeature<?, ?> ALJANWOODS_ORCHARD = register("aljanwoods_orchard", Feature.RANDOM_SELECTOR.withConfiguration(
                    new MultipleRandomFeatureConfig(ImmutableList.of(FANCY_ALJANWOOD.withChance(0.2F), ALJANWOOD.withChance(0.1F)), ALJANWOOD))
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 0))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_GOLDENWOOD = register("fancy_goldenwood",
            Feature.TREE.withConfiguration(new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.GOLDENWOOD_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(BMBlocks.GOLDENWOOD_LEAVES.get().getDefaultState()),
                    new FancyFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))
                    .setIgnoreVines().func_236702_a_(Heightmap.Type.MOTION_BLOCKING).build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_ENCHANTED_GOLDENWOOD = register("fancy_enchanted_goldenwood",
            Feature.TREE.withConfiguration(new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.GOLDENWOOD_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(BMBlocks.ENCHANTED_GOLDENWOOD_LEAVES.get().getDefaultState()),
                    new FancyFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))
                    .setIgnoreVines().func_236702_a_(Heightmap.Type.MOTION_BLOCKING).build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> JABUTICABA_TREE = register("jabuticaba_tree", Feature.TREE.withConfiguration(new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(
            BMBlocks.JABUTICABA_LOG.get().getDefaultState()), new SimpleBlockStateProvider(BMBlocks.JABUTICABA_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2),
            FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(10, 5, 10), new TwoLayerFeature(1, 0,
            1)).setIgnoreVines().build()));

    public static final ConfiguredFeature<?, ?> JABUTICABA_TREES = register("jabuticaba_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(JABUTICABA_TREE
            .withChance(0.2f), JABUTICABA_TREE.withChance(0.1f)), JABUTICABA_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(2, 0.05f, 1))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> AVONDALIC_WILLOW = register("avondalic_willow", Feature.TREE.withConfiguration(
            new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BMBlocks.AVONDALIC_WILLOW_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(BMBlocks.AVONDALIC_WILLOW_LEAVES.get().getDefaultState()),
                    new SpruceFoliagePlacer(
                            FeatureSpread.func_242253_a(2, 1),
                            FeatureSpread.func_242253_a(0, 2),
                            FeatureSpread.func_242253_a(1, 1)),
                    new StraightTrunkPlacer(5, 2, 1),
                    new TwoLayerFeature(2, 0, 2)).setIgnoreVines().build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MEGA_AVONDALIC_WILLOW = register("mega_avondalic_willow", Feature.TREE.withConfiguration(
            new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BMBlocks.AVONDALIC_WILLOW_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(BMBlocks.AVONDALIC_WILLOW_LEAVES.get().getDefaultState()),
                    new MegaPineFoliagePlacer(
                            FeatureSpread.func_242252_a(0),
                            FeatureSpread.func_242252_a(0),
                            FeatureSpread.func_242253_a(3, 4)),
                    new GiantTrunkPlacer(6, 2, 14),
                    new TwoLayerFeature(1, 1, 2)).build()));

    public static final ConfiguredFeature<?, ?> AVONDALIC_WILLOWS = register("avondalic_willows", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
                    MEGA_AVONDALIC_WILLOW.withChance(0.85641026f), AVONDALIC_WILLOW.withChance(0.99f)), AVONDALIC_WILLOW)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
            .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.1f, 1))));

    public static final ConfiguredFeature<?, ?> AVONDALIC_BUSH = register("avondalic_bush", Feature.TREE.withConfiguration(
            new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BMBlocks.AVONDALIC_WILLOW_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(BMBlocks.AVONDALIC_WILLOW_LEAVES.get().getDefaultState()),
                    new BushFoliagePlacer(
                            FeatureSpread.func_242252_a(2),
                            FeatureSpread.func_242252_a(1), 2),
                    new StraightTrunkPlacer(1, 0, 0),
                    new TwoLayerFeature(0, 0, 0))
                    .func_236702_a_(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES).build()));

    public static final ConfiguredFeature<?, ?> AVONDALIC_BUSHES = register("avondalic_bushes", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(
            ImmutableList.of(AVONDALIC_BUSH.withChance(0.2f), AVONDALIC_WILLOW.withChance(0.05f), Features.PATCH_GRASS_PLAIN.withChance(0.3f)), AVONDALIC_BUSH)).withPlacement(Features.Placements
            .HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(50, 0.1f, 1))));

    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> ENDER_DRAGON_FRIED_EGG_FLOWER_PATCH_IL = ImmutableList.of(() -> Feature.RANDOM_PATCH.withConfiguration(
            new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BMBlocks.ENDER_DRAGON_FRIED_EGG_FLOWER.get().getDefaultState()), new SimpleBlockPlacer()).tries(64)
                    .func_227317_b_().build()));

    public static final ConfiguredFeature<?, ?> ENDER_DRAGON_FRIED_EGG_FLOWER_PATCH = register("backmath_the_end_flower_patch", Feature.SIMPLE_RANDOM_SELECTOR.withConfiguration(new
            SingleRandomFeature(ENDER_DRAGON_FRIED_EGG_FLOWER_PATCH_IL)).func_242730_a(FeatureSpread.func_242253_a(-3, 4)).withPlacement(Features.Placements.
            VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(5));

    public static final ConfiguredFeature<?, ?> ALJANCAP_LEAF_PILE = register("aljancap_leaf_pile", Feature.BLOCK_PILE.withConfiguration(
            new BlockStateProvidingFeatureConfig(new WeightedBlockStateProvider().addWeightedBlockstate(BMBlocks.ALJANCAP_LEAVES.get().getDefaultState(), 19))));

    public static final ConfiguredFeature<?, ?> ALJAN_DUNGEON = register("aljan_dungeon", new AljanDungeonFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).range(256).square()
            .func_242731_b(8));

    // TODO: BACK MATH 1.8.0: BOUNTIFULLY EXPANSIVE CONTENT ENDS HERE

    public static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, BackMath.resourceLoc(name), configuredFeature);
    }

    public static final class States {
        public static final BlockState HILLARY = BMBlocks.HILLARY.get().getDefaultState();
        public static final BlockState FRIED_EGG_FLOWER = BMBlocks.FRIED_EGG_FLOWER.get().getDefaultState();
        public static final BlockState TURTLE_FRIED_EGG_FLOWER = BMBlocks.TURTLE_FRIED_EGG_FLOWER.get().getDefaultState();
        public static final BlockState BIRCH_LOG = Blocks.BIRCH_LOG.getDefaultState();
        public static final BlockState SPRUCE_LOG = Blocks.SPRUCE_LOG.getDefaultState();
        public static final BlockState INSOMNIAN_LOG = BMBlocks.INSOMNIAN_LOG.get().getDefaultState();
        public static final BlockState GUARANA_OAK_LEAVES = BMBlocks.GUARANA_OAK_LEAVES.get().getDefaultState();
        public static final BlockState MANGO_OAK_LEAVES = BMBlocks.MANGO_OAK_LEAVES.get().getDefaultState();
        public static final BlockState GRAPE_VINE_LEAVES = BMBlocks.GRAPE_VINE_LEAVES.get().getDefaultState();
        public static final BlockState LEMON_OAK_LEAVES = BMBlocks.LEMON_OAK_LEAVES.get().getDefaultState();
        public static final BlockState ALJAME_BIRCH_LEAVES = BMBlocks.ALJAME_BIRCH_LEAVES.get().getDefaultState();
        public static final BlockState INSOMNIAN_LEAVES = BMBlocks.INSOMNIAN_LEAVES.get().getDefaultState();

        public static BlockState getBackFieldTreeLog() {
            return Blocks.OAK_LOG.getDefaultState();
        }
    }

    public static final class Configs {
        public static final BlockClusterFeatureConfig ALJAN_FLOWERS_CONFIG = new BlockClusterFeatureConfig.Builder(new WeightedBlockStateProvider().addWeightedBlockstate(BMBlocks.ALJAN_TULIP.get().getDefaultState(), 2), SimpleBlockPlacer.PLACER)
                .tries(64).build();
    }
}
