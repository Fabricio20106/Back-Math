package com.sophicreeper.backmath.core.data.worldgen;

public class BMDefaultBiomeFeatures {
    /*public static void withOriginalBackFieldTrees(BiomeGenerationSettings.Builder settings) {
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.ALJAME_BIRCHES);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.GUARANA_OAKS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.MANGO_OAKS);
        //settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.MANGAED_MANGO_OAKS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.OAKS);
    }

    public static void withModifiedBackFieldTrees(BiomeGenerationSettings.Builder settings) {
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
    }

    public static void withGeneralBackFieldThings(BiomeGenerationSettings.Builder settings, MobSpawnInfo.Builder spawns) {
        // Structures
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

        // Underground Ores / Disks
        DefaultBiomeFeatures.withCommonOverworldBlocks(settings);
        DefaultBiomeFeatures.withOverworldOres(settings);
        DefaultBiomeFeatures.withDisks(settings);

        // Passive and hostile mob spawns
        DefaultBiomeFeatures.withBatsAndHostiles(spawns);
        DefaultBiomeFeatures.withPassiveMobs(spawns);
        withFriendlyBMMobs(spawns);
        withHostileBMMobs(spawns);
    }

    public static void withCommonUndergroundAljanBlocks(BiomeGenerationSettings.Builder settings) {
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
