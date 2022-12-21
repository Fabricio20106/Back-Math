package com.sophicreeper.backmath.core.world.gen;

import com.sophicreeper.backmath.core.config.BMConfigs;
import com.sophicreeper.backmath.core.world.BMFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class BMPlantFeatures {
    public static void generatePlantsAndTrees(final BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder settings = event.getGeneration();

        if (event.getCategory() == Biome.Category.TAIGA && BMConfigs.SERVER_CONFIGS.grapeVinesInTaigas.get()) {
            settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.GRAPE_VINES);
        }
        if (event.getCategory() == Biome.Category.JUNGLE && BMConfigs.SERVER_CONFIGS.bananaJunglesInJungles.get()) {
            settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.BANANA_JUNGLES);
        }
        if (event.getCategory() == Biome.Category.BEACH && BMConfigs.SERVER_CONFIGS.turtleFriedEggFlowersInBeaches.get()) {
            settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.BACKMATH_BEACH_FLOWER_PATCH);
        }
    }
}
