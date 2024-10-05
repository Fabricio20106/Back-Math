package com.sophicreeper.backmath.world.biome.custom;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.util.BMUtils;
import com.sophicreeper.backmath.world.BMConfiguredFeatures;
import com.sophicreeper.backmath.entity.BMEntities;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class BMDefaultBiomeFeatures {
    public static void addOriginalBackFieldTrees(BiomeGenerationSettings.Builder settings) {
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.GUARANA_OAK_TREES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.MANGO_OAK_TREES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJAME_BIRCH_TREES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.OAK_TREES);
    }

    public static void addModifiedBackFieldTrees(BiomeGenerationSettings.Builder settings) {
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.LEMON_OAKS_TREES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.PINEAPPLE_OAK_TREES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ORANGE_OAK_TREES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.GUAVA_TREES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.JABUTICABA_TREES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJAME_BIRCH_TREES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.OAK_TREES);
    }

    public static void backFieldPassives(MobSpawnInfo.Builder spawns) {
        if (BMConfigs.COMMON_CONFIGS.wandererSophieSpawn.get()) spawns.addSpawn(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(BMEntities.WANDERER_SOPHIE.get(), 8, 4, 4));
        if (BMConfigs.COMMON_CONFIGS.archerLuciaSpawn.get()) spawns.addSpawn(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(BMEntities.ARCHER_LUCIA.get(), 8, 4, 4));
        if (BMConfigs.COMMON_CONFIGS.karateLuciaSpawn.get()) spawns.addSpawn(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(BMEntities.KARATE_LUCIA.get(), 8, 1, 6));
        if (BMConfigs.COMMON_CONFIGS.shyFabricioSpawn.get()) spawns.addSpawn(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(BMEntities.SHY_FABRICIO.get(), 6, 1, 3));
    }

    public static void backFieldHostiles(MobSpawnInfo.Builder spawns) {
        if (BMConfigs.COMMON_CONFIGS.angrySophieSpawn.get()) spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(BMEntities.ANGRY_SOPHIE.get(), 100, 4, 4));
        if (BMConfigs.COMMON_CONFIGS.insomniaSophieSpawn.get()) spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(BMEntities.INSOMNIA_SOPHIE.get(), 25, 4, 4));
        if (BMConfigs.COMMON_CONFIGS.archerInsomniaSophieSpawn.get()) spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(BMEntities.ARCHER_INSOMNIA_SOPHIE.get(), 15, 4, 5));
    }

    public static void addBackFieldFeatures(BiomeGenerationSettings.Builder settings, MobSpawnInfo.Builder spawns) {
        DefaultBiomeFeatures.addDefaultOverworldLandStructures(settings);
        settings.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
        settings.addStructureStart(StructureFeatures.VILLAGE_PLAINS);

        settings.addFeature(GenerationStage.Decoration.LAKES, BMConfiguredFeatures.HILLARY_LAKE);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.BACK_FIELD_FLOWER_PATCH);
        settings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMConfiguredFeatures.TABU_BLOB);
        DefaultBiomeFeatures.addDefaultCarvers(settings);
        DefaultBiomeFeatures.addDefaultLakes(settings);
        DefaultBiomeFeatures.addDefaultMonsterRoom(settings);
        DefaultBiomeFeatures.addForestGrass(settings);
        DefaultBiomeFeatures.addDefaultExtraVegetation(settings);
        DefaultBiomeFeatures.addDefaultSprings(settings);

        DefaultBiomeFeatures.addDefaultUndergroundVariety(settings);
        DefaultBiomeFeatures.addDefaultOres(settings);
        DefaultBiomeFeatures.addDefaultSoftDisks(settings);

        DefaultBiomeFeatures.commonSpawns(spawns);
        DefaultBiomeFeatures.farmAnimals(spawns);
        backFieldPassives(spawns);
        backFieldHostiles(spawns);
    }

    public static void addAljanUndergroundVariety(BiomeGenerationSettings.Builder settings) {
        settings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMConfiguredFeatures.SLEEPINGSTONE_BLOB);
        settings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMConfiguredFeatures.ALJAMIC_DIRT_BLOB);
        settings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMConfiguredFeatures.INSOGRAVEL_BLOB);
    }

    public static void aljanHostiles(MobSpawnInfo.Builder spawns) {
        if (BMConfigs.COMMON_CONFIGS.insomniaZombieSpawn.get()) spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(BMEntities.INSOMNIA_ZOMBIE.get(), 25, 4, 5));
        if (BMConfigs.COMMON_CONFIGS.zombieFabricioSpawn.get()) spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(BMEntities.ZOMBIE_FABRICIO.get(), 5, 1, 2));
        if (BMConfigs.COMMON_CONFIGS.aljamicBonesSpawn.get()) spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(BMEntities.ALJAMIC_BONES.get(), 35, 1, 5));
        if (BMConfigs.COMMON_CONFIGS.sleepishSkeletonSpawn.get()) spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(BMEntities.SLEEPISH_SKELETON.get(), 5, 1, 2));
    }

    public static void aljanPassives(MobSpawnInfo.Builder spawns) {
        if (BMConfigs.COMMON_CONFIGS.malaikaSpawn.get() && !BMUtils.aljanPackEnabled()) spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(BMEntities.MALAIKA.get(), 12, 2, 5));
    }

    public static void aljanMobs(MobSpawnInfo.Builder spawns) {
        aljanHostiles(spawns);
        aljanPassives(spawns);
    }
}
