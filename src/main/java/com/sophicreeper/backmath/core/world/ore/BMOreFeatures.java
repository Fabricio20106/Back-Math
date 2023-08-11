package com.sophicreeper.backmath.core.world.ore;

import com.sophicreeper.backmath.core.tags.BMTags;
import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

import static net.minecraft.data.worldgen.features.FeatureUtils.createKey;
import static net.minecraft.data.worldgen.features.FeatureUtils.register;

public class BMOreFeatures {
    /*public static final RuleTest STONE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    public static final RuleTest DEEPSLATE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    public static final RuleTest BASE_STONE_NETHER = new TagMatchTest(BlockTags.BASE_STONE_NETHER);

    public static final RuleTest END_ORE_REPLACEABLES = new BlockMatchTest(Blocks.END_STONE);
    public static final RuleTest OBSIDIAN_REPLACEABLES = new BlockMatchTest(Blocks.OBSIDIAN);
    public static final RuleTest AIR_REPLACEABLES = new BlockMatchTest(Blocks.AIR);
    public static final RuleTest ALJANSTONE_ORE_REPLACEABLES = new BlockMatchTest(BMBlocks.ALJANSTONE.get());
    public static final RuleTest SLEEPINGSTONE_ORE_REPLACEABLES = new BlockMatchTest(BMBlocks.SLEEPINGSTONE.get());
    public static final RuleTest BASE_STONE_ALJAN = new TagMatchTest(BMTags.Blocks.BASE_STONE_ALJAN);

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
            OreConfiguration.target(STONE_ORE_REPLACEABLES, BMBlocks.MID_TERM_ORE.get().defaultBlockState()),
            OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, BMBlocks.OBSIDIAN_MID_TERM_ORE.get().defaultBlockState()));

    // ------------------------------ RESOURCE KEYS ---------------------------------- //

    public static final ResourceKey<ConfiguredFeature<?, ?>> DEVIL_ORE_VEIN = createKey("backmath:devil_ore_vein");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ANGELIC_ORE_VEIN = createKey("backmath:angelic_ore_vein");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYSTALLINE_ANGELIC_ORE_VEIN = createKey("backmath:crystalline_angelic_ore_vein");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MID_TERM_ORE_VEIN = createKey("backmath:mid_tern_ore_vein");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, DEVIL_ORE_VEIN, Feature.ORE, new OreConfiguration(DEVIL_ORE_TARGET_LIST, 6));
        register(context, ANGELIC_ORE_VEIN, Feature.ORE, new OreConfiguration(ANGELIC_ORE_TARGET_LIST, 6));
        register(context, CRYSTALLINE_ANGELIC_ORE_VEIN, Feature.ORE, new OreConfiguration(CRYSTALLINE_ANGELIC_ORE_TARGET_LIST, 6));
        register(context, MID_TERM_ORE_VEIN, Feature.ORE, new OreConfiguration(MID_TERM_ORE_TARGET_LIST, 6));
    }*/
}
