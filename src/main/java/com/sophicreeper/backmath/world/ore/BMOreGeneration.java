package com.sophicreeper.backmath.world.ore;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.util.BMTags;
import com.sophicreeper.backmath.world.biome.BMBiomes;
import com.sophicreeper.backmath.block.BMBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Objects;

import static net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER;
import static net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD;

public class BMOreGeneration {
    public static final RuleTest END_STONE_REPLACEABLES = new TagMatchRuleTest(Tags.Blocks.END_STONES);
    public static final RuleTest OBSIDIAN_REPLACEABLES = new TagMatchRuleTest(BMTags.Blocks.OBSIDIAN_REPLACEABLES);
    public static final RuleTest AIR_REPLACEABLES = new TagMatchRuleTest(BMTags.Blocks.AIR_REPLACEABLES);
    public static final RuleTest ALJANSTONE_REPLACEABLES = new BlockMatchRuleTest(BMBlocks.ALJANSTONE.get());
    public static final RuleTest SLEEPINGSTONE_REPLACEABLES = new BlockMatchRuleTest(BMBlocks.SLEEPINGSTONE.get());
    public static final RuleTest BASE_STONE_ALJAN = new TagMatchRuleTest(BMTags.Blocks.BASE_STONE_ALJAN);

    public static void generateOres(final BiomeLoadingEvent event) {
        if (!(event.getCategory().equals(Biome.Category.NETHER) || event.getCategory().equals(Biome.Category.THEEND)) && BMConfigs.COMMON_CONFIGS.devilOreGen.get()) {
            generateOre(event.getGeneration(), BASE_STONE_OVERWORLD, BMBlocks.DEVIL_ORE.get().getDefaultState(), 6, 10, 63, 20);
        }

        if (!(event.getCategory().equals(Biome.Category.NETHER) || event.getCategory().equals(Biome.Category.THEEND)) && BMConfigs.COMMON_CONFIGS.angelicOreGen.get()) {
            generateOre(event.getGeneration(), BASE_STONE_OVERWORLD, BMBlocks.ANGELIC_ORE.get().getDefaultState(), 6, 10, 63, 20);
        }

        if (Objects.equals(BMBiomes.ANGELIC_WOODS.get().getRegistryName(), event.getName()) && BMConfigs.COMMON_CONFIGS.abundantAngelicOreGen.get()) {
            generateOre(event.getGeneration(), BASE_STONE_OVERWORLD, BMBlocks.ANGELIC_ORE.get().getDefaultState(), 9, 10, 117, 30);
        }

        if (Objects.equals(BMBiomes.ANGELIC_WOODS.get().getRegistryName(), event.getName()) && BMConfigs.COMMON_CONFIGS.crystallineAngelicOreGen.get()) {
            generateOre(event.getGeneration(), BASE_STONE_OVERWORLD, BMBlocks.CRYSTALLINE_ANGELIC_ORE.get().getDefaultState(), 5, 70, 96, 6);
        }

        if (Objects.equals(BMBiomes.ANGELIC_WOODS.get().getRegistryName(), event.getName()) && BMConfigs.COMMON_CONFIGS.crystallineAngelicOreGen.get()) {
            generateOre(event.getGeneration(), AIR_REPLACEABLES, BMBlocks.CRYSTALLINE_ANGELIC_ORE.get().getDefaultState(), 5, 192, 255, 5);
        }

        if (event.getCategory().equals(Biome.Category.NETHER) && BMConfigs.COMMON_CONFIGS.netherDevilOreGen.get()) {
            generateOre(event.getGeneration(), BASE_STONE_NETHER, BMBlocks.NETHER_DEVIL_ORE.get().getDefaultState(), 6, 6, 117, 20);
        }

        // This is only going to generate if you change the config files for mid-term ore generation in the end.
        if (event.getCategory().equals(Biome.Category.THEEND) && BMConfigs.COMMON_CONFIGS.midTermOreGen.get()) {
            generateOre(event.getGeneration(), END_STONE_REPLACEABLES, BMBlocks.MID_TERM_ORE.get().getDefaultState(), 3, 6, 117, 4);
            generateOre(event.getGeneration(), OBSIDIAN_REPLACEABLES, BMBlocks.OBSIDIAN_MID_TERM_ORE.get().getDefaultState(), 3, 0, 72, 3);
        }
    }

    public static void generateAljanstoneOres(final BiomeLoadingEvent event) {
        if (Objects.equals(BMBiomes.ALJAN_WOODS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.CAPPED_HILLS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.INSOMNIAN_WOODS.get().getRegistryName(),
                event.getName()) || Objects.equals(BMBiomes.SLEEPISH_OCEAN.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.DEEP_SLEEPISH_OCEAN.get().getRegistryName(), event.getName())
                || Objects.equals(BMBiomes.AMARACAMEL_STICKS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.ALJAMIC_HIGHLANDS.get().getRegistryName(), event.getName())
                || Objects.equals(BMBiomes.ALJAMIC_ORCHARD.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.AVONDALIC_GROVE.get().getRegistryName(), event.getName()) &&
                BMConfigs.COMMON_CONFIGS.aljameedOreGen.get()) {
            generateOre(event.getGeneration(), ALJANSTONE_REPLACEABLES, BMBlocks.ALJAMEED_ORE.get().getDefaultState(), 9, 10, 63, 20);
        }

        if (Objects.equals(BMBiomes.ALJAN_WOODS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.CAPPED_HILLS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.INSOMNIAN_WOODS.get().getRegistryName(),
                event.getName()) || Objects.equals(BMBiomes.SLEEPISH_OCEAN.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.DEEP_SLEEPISH_OCEAN.get().getRegistryName(), event.getName())
                || Objects.equals(BMBiomes.AMARACAMEL_STICKS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.ALJAMIC_HIGHLANDS.get().getRegistryName(), event.getName())
                || Objects.equals(BMBiomes.ALJAMIC_ORCHARD.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.AVONDALIC_GROVE.get().getRegistryName(), event.getName()) &&
                BMConfigs.COMMON_CONFIGS.mooneringOreGen.get()) {
            generateOre(event.getGeneration(), ALJANSTONE_REPLACEABLES, BMBlocks.MOONERING_ORE.get().getDefaultState(), 8, 1, 16, 8);
        }

        if (Objects.equals(BMBiomes.ALJAN_WOODS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.CAPPED_HILLS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.INSOMNIAN_WOODS.get().getRegistryName(),
                event.getName()) || Objects.equals(BMBiomes.SLEEPISH_OCEAN.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.DEEP_SLEEPISH_OCEAN.get().getRegistryName(), event.getName())
                || Objects.equals(BMBiomes.AMARACAMEL_STICKS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.ALJAMIC_HIGHLANDS.get().getRegistryName(), event.getName())
                || Objects.equals(BMBiomes.AVONDALIC_GROVE.get().getRegistryName(), event.getName()) && BMConfigs.COMMON_CONFIGS.janticOreGen.get()) {
            generateOre(event.getGeneration(), ALJANSTONE_REPLACEABLES, BMBlocks.JANTIC_ORE.get().getDefaultState(), 7, 1, 28, 12);
        }

        if (Objects.equals(BMBiomes.ALJAN_WOODS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.CAPPED_HILLS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.INSOMNIAN_WOODS.get().getRegistryName(),
                event.getName()) || Objects.equals(BMBiomes.SLEEPISH_OCEAN.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.DEEP_SLEEPISH_OCEAN.get().getRegistryName(), event.getName())
                || Objects.equals(BMBiomes.AMARACAMEL_STICKS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.ALJAMIC_HIGHLANDS.get().getRegistryName(), event.getName())
                || Objects.equals(BMBiomes.AVONDALIC_GROVE.get().getRegistryName(), event.getName()) && BMConfigs.COMMON_CONFIGS.aljamicCopperGen.get()) {
            generateOre(event.getGeneration(), ALJANSTONE_REPLACEABLES, BMBlocks.ALJAMIC_COPPER_ORE.get().getDefaultState(), 7, 36, 132, 12);
        }

        if (Objects.equals(BMBiomes.ALJAN_WOODS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.CAPPED_HILLS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.INSOMNIAN_WOODS.get().getRegistryName(),
                event.getName()) || Objects.equals(BMBiomes.SLEEPISH_OCEAN.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.DEEP_SLEEPISH_OCEAN.get().getRegistryName(), event.getName())
                || Objects.equals(BMBiomes.AMARACAMEL_STICKS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.ALJAMIC_HIGHLANDS.get().getRegistryName(), event.getName())
                || Objects.equals(BMBiomes.AVONDALIC_GROVE.get().getRegistryName(), event.getName()) && BMConfigs.COMMON_CONFIGS.aljamicTinGen.get()) {
            generateOre(event.getGeneration(), ALJANSTONE_REPLACEABLES, BMBlocks.ALJAMIC_TIN_ORE.get().getDefaultState(), 7, 36, 132, 12);
        }

        if (Objects.equals(BMBiomes.ALJAMIC_HIGHLANDS.get().getRegistryName(), event.getName()) || BMConfigs.COMMON_CONFIGS.aljamicHighlandsAbundantJanticOreGen.get()) {
            generateOre(event.getGeneration(), ALJANSTONE_REPLACEABLES, BMBlocks.JANTIC_ORE.get().getDefaultState(), 5, 70, 96, 3);
        }
    }

    public static void generateSleepingstoneOres(final BiomeLoadingEvent event) {
        if (Objects.equals(BMBiomes.ALJAN_WOODS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.CAPPED_HILLS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.INSOMNIAN_WOODS.get().getRegistryName(),
                event.getName()) || Objects.equals(BMBiomes.SLEEPISH_OCEAN.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.DEEP_SLEEPISH_OCEAN.get().getRegistryName(), event.getName())
                || Objects.equals(BMBiomes.AMARACAMEL_STICKS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.ALJAMIC_HIGHLANDS.get().getRegistryName(), event.getName())
                || Objects.equals(BMBiomes.AVONDALIC_GROVE.get().getRegistryName(), event.getName()) && BMConfigs.COMMON_CONFIGS.aljameedOreGen.get()) {
            generateOre(event.getGeneration(), SLEEPINGSTONE_REPLACEABLES, BMBlocks.SLEEPINGSTONE_ALJAMEED_ORE.get().getDefaultState(), 9, 10, 63, 20);
        }

        if (Objects.equals(BMBiomes.ALJAN_WOODS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.CAPPED_HILLS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.INSOMNIAN_WOODS.get().getRegistryName(),
                event.getName()) || Objects.equals(BMBiomes.SLEEPISH_OCEAN.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.DEEP_SLEEPISH_OCEAN.get().getRegistryName(), event.getName())
                || Objects.equals(BMBiomes.AMARACAMEL_STICKS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.ALJAMIC_HIGHLANDS.get().getRegistryName(), event.getName())
                || Objects.equals(BMBiomes.AVONDALIC_GROVE.get().getRegistryName(), event.getName()) && BMConfigs.COMMON_CONFIGS.mooneringOreGen.get()) {
            generateOre(event.getGeneration(), SLEEPINGSTONE_REPLACEABLES, BMBlocks.SLEEPINGSTONE_MOONERING_ORE.get().getDefaultState(), 8, 1, 16, 8);
        }

        if (Objects.equals(BMBiomes.ALJAN_WOODS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.CAPPED_HILLS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.INSOMNIAN_WOODS.get().getRegistryName(),
                event.getName()) || Objects.equals(BMBiomes.SLEEPISH_OCEAN.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.DEEP_SLEEPISH_OCEAN.get().getRegistryName(), event.getName())
                || Objects.equals(BMBiomes.AMARACAMEL_STICKS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.ALJAMIC_HIGHLANDS.get().getRegistryName(), event.getName())
                || Objects.equals(BMBiomes.AVONDALIC_GROVE.get().getRegistryName(), event.getName()) && BMConfigs.COMMON_CONFIGS.janticOreGen.get()) {
            generateOre(event.getGeneration(), SLEEPINGSTONE_REPLACEABLES, BMBlocks.SLEEPINGSTONE_JANTIC_ORE.get().getDefaultState(), 7, 1, 28, 12);
        }

        if (Objects.equals(BMBiomes.ALJAN_WOODS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.CAPPED_HILLS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.INSOMNIAN_WOODS.get().getRegistryName(),
                event.getName()) || Objects.equals(BMBiomes.SLEEPISH_OCEAN.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.DEEP_SLEEPISH_OCEAN.get().getRegistryName(), event.getName())
                || Objects.equals(BMBiomes.AMARACAMEL_STICKS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.ALJAMIC_HIGHLANDS.get().getRegistryName(), event.getName())
                || Objects.equals(BMBiomes.AVONDALIC_GROVE.get().getRegistryName(), event.getName()) && BMConfigs.COMMON_CONFIGS.aljamicCopperGen.get()) {
            generateOre(event.getGeneration(), SLEEPINGSTONE_REPLACEABLES, BMBlocks.SLEEPINGSTONE_ALJAMIC_COPPER_ORE.get().getDefaultState(), 7, 36, 132, 12);
        }

        if (Objects.equals(BMBiomes.ALJAN_WOODS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.CAPPED_HILLS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.INSOMNIAN_WOODS.get().getRegistryName(),
                event.getName()) || Objects.equals(BMBiomes.SLEEPISH_OCEAN.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.DEEP_SLEEPISH_OCEAN.get().getRegistryName(), event.getName())
                || Objects.equals(BMBiomes.AMARACAMEL_STICKS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.ALJAMIC_HIGHLANDS.get().getRegistryName(), event.getName())
                || Objects.equals(BMBiomes.AVONDALIC_GROVE.get().getRegistryName(), event.getName()) && BMConfigs.COMMON_CONFIGS.aljamicTinGen.get()) {
            generateOre(event.getGeneration(), SLEEPINGSTONE_REPLACEABLES, BMBlocks.SLEEPINGSTONE_ALJAMIC_TIN_ORE.get().getDefaultState(), 7, 36, 132, 12);
        }

        if (Objects.equals(BMBiomes.ALJAMIC_HIGHLANDS.get().getRegistryName(), event.getName()) || BMConfigs.COMMON_CONFIGS.aljamicHighlandsAbundantJanticOreGen.get()) {
            generateOre(event.getGeneration(), SLEEPINGSTONE_REPLACEABLES, BMBlocks.SLEEPINGSTONE_JANTIC_ORE.get().getDefaultState(), 5, 70, 96, 3);
        }
    }

    public static void generateOre(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state, int veinSize, int minHeight, int maxHeight, int amount) {
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(fillerType, state, veinSize)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
                .square().func_242731_b(amount));
    }
}
