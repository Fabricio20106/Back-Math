package com.sophicreeper.backmath.world.biome.custom;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.world.BMFeatures;
import com.sophicreeper.backmath.entity.BMEntities;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class BMDefaultBiomeFeatures {
    public static void addOriginalBackFieldTrees(BiomeGenerationSettings.Builder settings) {
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.ALJAME_BIRCHES);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.GUARANA_OAKS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.MANGO_OAKS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.OAKS);
    }

    public static void addModifiedBackFieldTrees(BiomeGenerationSettings.Builder settings) {
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.ALJAME_BIRCHES);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.LEMON_OAKS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.PINEAPPLE_OAKS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.ORANGE_OAKS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.GUAVA_TREES);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.JABUTICABA_TREES);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.OAKS);
    }

    public static void backFieldPassives(MobSpawnInfo.Builder spawns) {
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

    public static void backFieldHostiles(MobSpawnInfo.Builder spawns) {
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

    public static void addBackFieldFeatures(BiomeGenerationSettings.Builder settings, MobSpawnInfo.Builder spawns) {
        DefaultBiomeFeatures.withStrongholdAndMineshaft(settings);
        settings.withStructure(StructureFeatures.RUINED_PORTAL);
        settings.withStructure(StructureFeatures.VILLAGE_PLAINS);

        settings.withFeature(GenerationStage.Decoration.LAKES, BMFeatures.HILLARY_LAKE);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.BACK_FIELD_FLOWER_PATCH);
        DefaultBiomeFeatures.withCavesAndCanyons(settings);
        DefaultBiomeFeatures.withLavaAndWaterLakes(settings);
        DefaultBiomeFeatures.withMonsterRoom(settings);
        DefaultBiomeFeatures.withForestGrass(settings);
        DefaultBiomeFeatures.withSugarCaneAndPumpkins(settings);
        DefaultBiomeFeatures.withLavaAndWaterSprings(settings);

        DefaultBiomeFeatures.withCommonOverworldBlocks(settings);
        DefaultBiomeFeatures.withOverworldOres(settings);
        DefaultBiomeFeatures.withDisks(settings);

        DefaultBiomeFeatures.withBatsAndHostiles(spawns);
        DefaultBiomeFeatures.withPassiveMobs(spawns);
        backFieldPassives(spawns);
        backFieldHostiles(spawns);
    }

    public static void addAljanUndergroundVariety(BiomeGenerationSettings.Builder settings) {
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMFeatures.SLEEPINGSTONE_BLOB);
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMFeatures.ALJAMIC_DIRT_BLOB);
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMFeatures.INSOGRAVEL_BLOB);
    }

    public static void aljanHostiles(MobSpawnInfo.Builder spawns) {
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

    public static void aljanPassives(MobSpawnInfo.Builder spawns) {
        if (BMConfigs.SERVER_CONFIGS.malaikaSpawn.get()) {
            spawns.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(BMEntities.MALAIKA.get(), 12, 2, 5));
        }
    }

    public static void aljanMobs(MobSpawnInfo.Builder spawns) {
        aljanHostiles(spawns);
        aljanPassives(spawns);
    }
}
