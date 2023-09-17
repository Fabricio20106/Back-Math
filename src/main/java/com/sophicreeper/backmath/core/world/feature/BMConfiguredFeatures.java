package com.sophicreeper.backmath.core.world.feature;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.world.feature.tree.BMTreeFeatures;
import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class BMConfiguredFeatures {
    public static final RuleTest STONE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    public static final RuleTest DEEPSLATE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    public static final RuleTest BASE_STONE_NETHER = new TagMatchTest(BlockTags.BASE_STONE_NETHER);

    public static final RuleTest END_ORE_REPLACEABLES = new BlockMatchTest(Blocks.END_STONE);
    public static final RuleTest OBSIDIAN_REPLACEABLES = new BlockMatchTest(Blocks.OBSIDIAN);
    public static final RuleTest AIR_REPLACEABLES = new BlockMatchTest(Blocks.AIR);
    public static final RuleTest ALJANSTONE_ORE_REPLACEABLES = new BlockMatchTest(BMBlocks.ALJANSTONE.get());
    public static final RuleTest SLEEPINGSTONE_ORE_REPLACEABLES = new BlockMatchTest(BMBlocks.SLEEPINGSTONE.get());

    public static final List<OreConfiguration.TargetBlockState> DEVIL_ORE_TARGET_LIST = List.of(
            OreConfiguration.target(STONE_ORE_REPLACEABLES, BMBlocks.DEVIL_ORE.get().defaultBlockState()),
            OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, BMBlocks.DEEPSLATE_DEVIL_ORE.get().defaultBlockState()),
            OreConfiguration.target(BASE_STONE_NETHER, BMBlocks.NETHER_DEVIL_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> ANGELIC_ORE_TARGET_LIST = List.of(
            OreConfiguration.target(STONE_ORE_REPLACEABLES, BMBlocks.ANGELIC_ORE.get().defaultBlockState()),
            OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, BMBlocks.DEEPSLATE_ANGELIC_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> CRYSTALLINE_ANGELIC_ORE_TARGET_LIST = List.of(
            OreConfiguration.target(STONE_ORE_REPLACEABLES, BMBlocks.CRYSTALLINE_ANGELIC_ORE.get().defaultBlockState()),
            OreConfiguration.target(AIR_REPLACEABLES, BMBlocks.CRYSTALLINE_ANGELIC_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> MID_TERM_ORE_TARGET_LIST = List.of(
            OreConfiguration.target(END_ORE_REPLACEABLES, BMBlocks.MID_TERM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OBSIDIAN_REPLACEABLES, BMBlocks.OBSIDIAN_MID_TERM_ORE.get().defaultBlockState()));

    // Aljan Ores
    public static final List<OreConfiguration.TargetBlockState> ALJAMEED_ORE_TARGET_LIST = List.of(
            OreConfiguration.target(ALJANSTONE_ORE_REPLACEABLES, BMBlocks.ALJAMEED_ORE.get().defaultBlockState()),
            OreConfiguration.target(SLEEPINGSTONE_ORE_REPLACEABLES, BMBlocks.SLEEPINGSTONE_ALJAMEED_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> ALJAMIC_COPPER_ORE_TARGET_LIST = List.of(
            OreConfiguration.target(ALJANSTONE_ORE_REPLACEABLES, BMBlocks.ALJAMIC_COPPER_ORE.get().defaultBlockState()),
            OreConfiguration.target(SLEEPINGSTONE_ORE_REPLACEABLES, BMBlocks.SLEEPINGSTONE_ALJAMIC_COPPER_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> ALJAMIC_TIN_ORE_TARGET_LIST = List.of(
            OreConfiguration.target(ALJANSTONE_ORE_REPLACEABLES, BMBlocks.ALJAMIC_TIN_ORE.get().defaultBlockState()),
            OreConfiguration.target(SLEEPINGSTONE_ORE_REPLACEABLES, BMBlocks.SLEEPINGSTONE_ALJAMIC_TIN_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> MOONERING_ORE_TARGET_LIST = List.of(
            OreConfiguration.target(ALJANSTONE_ORE_REPLACEABLES, BMBlocks.MOONERING_ORE.get().defaultBlockState()),
            OreConfiguration.target(SLEEPINGSTONE_ORE_REPLACEABLES, BMBlocks.SLEEPINGSTONE_MOONERING_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> JANTIC_ORE_TARGET_LIST = List.of(
            OreConfiguration.target(ALJANSTONE_ORE_REPLACEABLES, BMBlocks.JANTIC_ORE.get().defaultBlockState()),
            OreConfiguration.target(SLEEPINGSTONE_ORE_REPLACEABLES, BMBlocks.SLEEPINGSTONE_JANTIC_ORE.get().defaultBlockState()));

    // ------------------------------ RESOURCE KEYS ---------------------------------- //

    // Normal Back Math Ores
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEVIL_ORE_VEIN = registerKey("devil_ore_vein");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ANGELIC_ORE_VEIN = registerKey("angelic_ore_vein");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ABUNDANT_ANGELIC_ORE_VEIN = registerKey("abundant_angelic_ore_vein");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYSTALLINE_ANGELIC_ORE_VEIN = registerKey("crystalline_angelic_ore_vein");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MID_TERM_ORE_VEIN = registerKey("mid_term_ore_vein");

    // Aljan Ores
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALJAMEED_ORE_VEIN = registerKey("aljameed_ore_vein");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALJAMIC_COPPER_ORE_VEIN = registerKey("aljamic_copper_ore_vein");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALJAMIC_TIN_ORE_VEIN = registerKey("aljamic_tin_ore_vein");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MOONERING_ORE_VEIN = registerKey("moonering_ore_vein");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JANTIC_ORE_VEIN = registerKey("jantic_ore_vein");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIGHLANDS_JANTIC_ORE_VEIN = registerKey("highlands_jantic_ore_vein");

    // Trees
    public static final ResourceKey<ConfiguredFeature<?, ?>> GUARANA_OAK = registerKey("guarana_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MANGO_OAK = registerKey("mango_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALJAME_BIRCH = registerKey("aljame_birch");

    // Yes, "bootstap context".
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        // Ores
        register(context, DEVIL_ORE_VEIN, Feature.ORE, new OreConfiguration(DEVIL_ORE_TARGET_LIST, 6));
        register(context, ANGELIC_ORE_VEIN, Feature.ORE, new OreConfiguration(ANGELIC_ORE_TARGET_LIST, 6));
        register(context, ABUNDANT_ANGELIC_ORE_VEIN, Feature.ORE, new OreConfiguration(ANGELIC_ORE_TARGET_LIST, 9));
        register(context, CRYSTALLINE_ANGELIC_ORE_VEIN, Feature.ORE, new OreConfiguration(CRYSTALLINE_ANGELIC_ORE_TARGET_LIST, 6));
        register(context, MID_TERM_ORE_VEIN, Feature.ORE, new OreConfiguration(MID_TERM_ORE_TARGET_LIST, 6));

        // Aljan Ores
        register(context, ALJAMEED_ORE_VEIN, Feature.ORE, new OreConfiguration(ALJAMEED_ORE_TARGET_LIST, 20));
        register(context, ALJAMIC_COPPER_ORE_VEIN, Feature.ORE, new OreConfiguration(ALJAMIC_COPPER_ORE_TARGET_LIST, 12));
        register(context, ALJAMIC_TIN_ORE_VEIN, Feature.ORE, new OreConfiguration(ALJAMIC_TIN_ORE_TARGET_LIST, 12));
        register(context, MOONERING_ORE_VEIN, Feature.ORE, new OreConfiguration(MOONERING_ORE_TARGET_LIST, 8));
        register(context, JANTIC_ORE_VEIN, Feature.ORE, new OreConfiguration(JANTIC_ORE_TARGET_LIST, 6));
        register(context, HIGHLANDS_JANTIC_ORE_VEIN, Feature.ORE, new OreConfiguration(JANTIC_ORE_TARGET_LIST, 3));

        // Trees
        register(context, GUARANA_OAK, Feature.TREE, BMTreeFeatures.createGuaranaOakTree().build());
        register(context, MANGO_OAK, Feature.TREE, BMTreeFeatures.createMangoOakTree().build());
        register(context, ALJAME_BIRCH, Feature.TREE, BMTreeFeatures.createAljameBirchTree().build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, BackMath.resourceLoc(name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
