package com.sophicreeper.backmath.world.plant;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.world.BMFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class BMPlantGeneration {
    public static void generatePlantsAndTrees(final BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder settings = event.getGeneration();

        if (event.getCategory() == Biome.Category.TAIGA && BMConfigs.COMMON_CONFIGS.grapeVinesInTaigas.get()) {
            settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.GRAPE_VINES);
        }
        if (event.getCategory() == Biome.Category.JUNGLE && BMConfigs.COMMON_CONFIGS.bananaJunglesInJungles.get()) {
            settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.BANANA_JUNGLES);
        }
        if (event.getCategory() == Biome.Category.BEACH && BMConfigs.COMMON_CONFIGS.turtleFriedEggFlowersInBeaches.get()) {
            settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.TURTLE_FRIED_EGG_FLOWER_PATCH);
        }
        if (event.getCategory() == Biome.Category.THEEND && BMConfigs.COMMON_CONFIGS.enderDragonFriedEggFlowersInTheEnd.get()) {
            settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.ENDER_DRAGON_FRIED_EGG_FLOWER_PATCH);
        }
/*
        // Aljan Features
        if (Objects.equals(BMBiomes.ALJAN_WOODS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.CAPPED_HILLS.get().getRegistryName(), event.getName()) || Objects.equals(
                BMBiomes.INSOMNIAN_WOODS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.AMARACAMEL_STICKS.get().getRegistryName(), event.getName()) || Objects.equals(
                        BMBiomes.ALJAMIC_HIGHLANDS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.ALJAMIC_ORCHARD.get().getRegistryName(), event.getName()) || Objects.equals(
                                BMBiomes.AVONDALIC_GROVE.get().getRegistryName(), event.getName()) && rand.nextInt(32) == 0) {
            settings.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, BMFeatures.ALJANSTONE_BOULDER);
        }

        if (Objects.equals(BMBiomes.SLEEPISH_OCEAN.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.DEEP_SLEEPISH_OCEAN.get().getRegistryName(), event.getName())
                && rand.nextInt(32) == 0) {
            settings.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, BMFeatures.SLEEPINGSTONE_BOULDER);
        }
        */
    }
}
