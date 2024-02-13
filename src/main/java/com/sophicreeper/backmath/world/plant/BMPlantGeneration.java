package com.sophicreeper.backmath.world.plant;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.world.BMConfiguredFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class BMPlantGeneration {
    public static void generatePlantsAndTrees(final BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder settings = event.getGeneration();

        if (event.getCategory() == Biome.Category.TAIGA && BMConfigs.COMMON_CONFIGS.grapeVinesInTaigas.get()) {
            settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.GRAPE_VINES);
        }
        if (event.getCategory() == Biome.Category.JUNGLE && BMConfigs.COMMON_CONFIGS.bananaJunglesInJungles.get()) {
            settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.BANANA_JUNGLES);
        }
        if (event.getCategory() == Biome.Category.BEACH && BMConfigs.COMMON_CONFIGS.turtleFriedEggFlowersInBeaches.get()) {
            settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.TURTLE_FRIED_EGG_FLOWER_PATCH);
        }
        if (event.getCategory() == Biome.Category.THEEND && BMConfigs.COMMON_CONFIGS.enderDragonFriedEggFlowersInTheEnd.get()) {
            settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ENDER_DRAGON_FRIED_EGG_FLOWER_PATCH);
        }
    }
}
