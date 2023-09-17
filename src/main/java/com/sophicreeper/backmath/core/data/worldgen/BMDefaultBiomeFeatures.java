package com.sophicreeper.backmath.core.data.worldgen;

import com.sophicreeper.backmath.core.world.feature.BMPlacedFeatures;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class BMDefaultBiomeFeatures {
    public static void withOriginalBackFieldTrees(BiomeGenerationSettings.Builder settings) {
        settings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BMPlacedFeatures.PLACED_ALJAME_BIRCH);
        settings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BMPlacedFeatures.PLACED_GUARANA_OAK);
        settings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BMPlacedFeatures.PLACED_MANGO_OAK);
        //settings.addFeature()(GenerationStep.Decoration.VEGETAL_DECORATION, BMFeatures.MANGAED_MANGO_OAKS);
        settings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_BIRCH_AND_OAK);
    }

    /*public static void withModifiedBackFieldTrees(BiomeGenerationSettings.Builder settings) {
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.ALJAME_BIRCHES);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.LEMON_OAKS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.PINEAPPLE_OAKS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.ORANGE_OAKS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.GUAVA_TREES);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.JABUTICABA_TREES);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.OAKS);
    }

    public static void withFriendlyBMMobs(MobSpawnInfo.Builder spawns) {
        if (BMConfigs.SERVER_CONFIGS.wandererSophieSpawn.get()) {
            spawns.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(BMEntities.WANDERER_SOPHIE.get(), 8, 4, 4));
        }
        if (BMConfigs.SERVER_CONFIGS.shyFabricioSpawn.get()) {
            spawns.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(BMEntities.SHY_FABRICIO.get(), 6, 1, 3));
        }
        if (BMConfigs.SERVER_CONFIGS.archerLuciaSpawn.get()) {
            spawns.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(BMEntities.ARCHER_LUCIA.get(), 8, 4, 4));
        }
        if (BMConfigs.SERVER_CONFIGS.karateLuciaSpawn.get()) {
            spawns.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(BMEntities.KARATE_LUCIA.get(), 8, 1, 6));
        }
    }

    public static void withBackFieldMobs(MobSpawnInfo.Builder spawns) {
        if (BMConfigs.SERVER_CONFIGS.wandererSophieSpawn.get()) {
            spawns.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(BMEntities.WANDERER_SOPHIE.get(), 8, 4, 4));
        }
        if (BMConfigs.SERVER_CONFIGS.shyFabricioSpawn.get()) {
            spawns.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(BMEntities.SHY_FABRICIO.get(), 6, 1, 3));
        }
        if (BMConfigs.SERVER_CONFIGS.archerLuciaSpawn.get()) {
            spawns.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(BMEntities.ARCHER_LUCIA.get(), 8, 4, 4));
        }
        if (BMConfigs.SERVER_CONFIGS.angrySophieSpawn.get()) {
            spawns.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(BMEntities.ANGRY_SOPHIE.get(), 100, 4, 4));
        }
    }*/

    public static void withGeneralBackFieldThings(BiomeGenerationSettings.Builder settings, MobSpawnSettings.Builder spawns) {
        // settings.addFeature(GenerationStep.Decoration.LAKES, BMFeatures.HILLARY_LAKE);
        // settings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BMFeatures.BACK_FIELD_FLOWER_PATCH);
        BiomeDefaultFeatures.addDefaultCarversAndLakes(settings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(settings);
        BiomeDefaultFeatures.addForestGrass(settings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(settings);
        BiomeDefaultFeatures.addDefaultSprings(settings);
        BiomeDefaultFeatures.addSurfaceFreezing(settings);

        // Underground Ores / Disks
        BiomeDefaultFeatures.addDefaultUndergroundVariety(settings);
        BiomeDefaultFeatures.addDefaultOres(settings);
        BiomeDefaultFeatures.addDefaultSoftDisks(settings);
        BiomeDefaultFeatures.addDefaultCrystalFormations(settings);

        // Passive and hostile mob spawns
        BiomeDefaultFeatures.commonSpawns(spawns);
        BiomeDefaultFeatures.farmAnimals(spawns);
        // withFriendlyBMMobs(spawns);
        // withHostileBMMobs(spawns);
    }

    /*public static void withCommonUndergroundAljanBlocks(BiomeGenerationSettings.Builder settings) {
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMFeatures.SLEEPINGSTONE_BLOB);
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMFeatures.ALJAMIC_DIRT_BLOB);
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMFeatures.INSOGRAVEL_BLOB);
    }

    public static void withHostileBMMobs(MobSpawnInfo.Builder spawns) {
        if (BMConfigs.SERVER_CONFIGS.angrySophieSpawn.get()) {
            spawns.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(BMEntities.ANGRY_SOPHIE.get(), 100, 4, 4));
        }
        if (BMConfigs.SERVER_CONFIGS.insomniaSophieSpawn.get()) {
            spawns.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(BMEntities.INSOMNIA_SOPHIE.get(), 25, 4, 4));
        }
        if (BMConfigs.SERVER_CONFIGS.archerInsomniaSophieSpawn.get()) {
            spawns.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(BMEntities.ARCHER_INSOMNIA_SOPHIE.get(), 15, 4, 5));
        }
    }

    public static void withAljanHostileMobs(MobSpawnInfo.Builder spawns) {
        if (BMConfigs.SERVER_CONFIGS.insomniaZombieSpawn.get()) {
            spawns.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(BMEntities.INSOMNIA_ZOMBIE.get(), 25, 4, 5));
        }
        if (BMConfigs.SERVER_CONFIGS.zombieFabricioSpawn.get()) {
            spawns.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(BMEntities.ZOMBIE_FABRICIO.get(), 5, 1, 2));
        }
        if (BMConfigs.SERVER_CONFIGS.aljamicBonesSpawn.get()) {
            spawns.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(BMEntities.ALJAMIC_BONES.get(), 35, 1, 5));
        }
        if (BMConfigs.SERVER_CONFIGS.sleepishSkeletonSpawn.get()) {
            spawns.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(BMEntities.SLEEPISH_SKELETON.get(), 5, 1, 2));
        }
    }

    public static void withAljanPassiveMobs(MobSpawnInfo.Builder spawns) {
        if (BMConfigs.SERVER_CONFIGS.malaikaSpawn.get()) {
            spawns.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(BMEntities.MALAIKA.get(), 12, 2, 5));
        }
    }

    public static void withAljanMobs(MobSpawnInfo.Builder spawns) {
        withAljanHostileMobs(spawns);
        withAljanPassiveMobs(spawns);
    }*/
}
