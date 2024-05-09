package com.sophicreeper.backmath.world.biome;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.misc.BMSounds;
import com.sophicreeper.backmath.world.BMConfiguredFeatures;
import com.sophicreeper.backmath.world.biome.custom.BMDefaultBiomeFeatures;
import com.sophicreeper.backmath.world.surface.BMSurfaceBuilders;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BMBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, BackMath.MOD_ID);

    // Overworld Biomes
    public static final RegistryObject<Biome> BACK_FIELD = BIOMES.register("back_field", BMBiomes::backField);
    public static final RegistryObject<Biome> ORIGINAL_BACK_FIELDS = BIOMES.register("original_back_fields", BMBiomes::originalBackFields);
    public static final RegistryObject<Biome> MODIFIED_BACK_FIELDS = BIOMES.register("modified_back_fields", BMBiomes::modifiedBackFields);
    public static final RegistryObject<Biome> ANGELIC_WOODS = BIOMES.register("angelic_woods", BMBiomes::angelicWoods);

    // Aljan Biomes
    public static final RegistryObject<Biome> ALJAN_WOODS = BIOMES.register("aljan_woods", BMBiomes::aljanWoods);
    public static final RegistryObject<Biome> CAPPED_HILLS = BIOMES.register("capped_hills", BMBiomes::cappedHills);
    public static final RegistryObject<Biome> INSOMNIAN_WOODS = BIOMES.register("insomnian_woods", BMBiomes::insomnianWoods);
    public static final RegistryObject<Biome> SLEEPISH_OCEAN = BIOMES.register("sleepish_ocean", BMBiomes::sleepishOcean);
    public static final RegistryObject<Biome> DEEP_SLEEPISH_OCEAN = BIOMES.register("deep_sleepish_ocean", BMBiomes::deepSleepishOcean);
    public static final RegistryObject<Biome> DEEPER_SLEEPISH_OCEAN = BIOMES.register("deeper_sleepish_ocean", BMBiomes::deeperSleepishOcean);
    public static final RegistryObject<Biome> AMARACAMEL_STICKS = BIOMES.register("amaracamel_sticks", BMBiomes::amaracamelSticks);
    public static final RegistryObject<Biome> ALJAMIC_HIGHLANDS = BIOMES.register("aljamic_highlands", BMBiomes::aljamicHighlands);
    public static final RegistryObject<Biome> ALJAMIC_ORCHARD = BIOMES.register("aljamic_orchard", BMBiomes::aljamicOrchard);
    public static final RegistryObject<Biome> AVONDALIC_GROVE = BIOMES.register("avondalic_grove", BMBiomes::avondalicGrove);

    // This is the actual original back fields, the Back Field.
    private static Biome backField() {
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);

        // Structures Generation
        DefaultBiomeFeatures.addDefaultOverworldLandStructures(settings);
        settings.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
        settings.addStructureStart(StructureFeatures.VILLAGE_PLAINS);

        DefaultBiomeFeatures.addDefaultCarvers(settings);
        DefaultBiomeFeatures.addDefaultLakes(settings);
        DefaultBiomeFeatures.addDefaultMonsterRoom(settings);

        // Underground Ores & Disks
        DefaultBiomeFeatures.addDefaultUndergroundVariety(settings);
        DefaultBiomeFeatures.addDefaultOres(settings);
        DefaultBiomeFeatures.addDefaultSoftDisks(settings);

        // Passive and hostile mob spawns
        DefaultBiomeFeatures.commonSpawns(spawns);
        DefaultBiomeFeatures.farmAnimals(spawns);
        BMDefaultBiomeFeatures.backFieldHostiles(spawns);

        // Vegetal Decoration
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.BACK_FIELD_FLOWER_PATCH);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.GUARANA_OAK_TREES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.MANGO_OAK_TREES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.OAK_TREES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.HILLARY_LAKE);

        DefaultBiomeFeatures.addForestGrass(settings);
        DefaultBiomeFeatures.addDefaultExtraVegetation(settings);
        DefaultBiomeFeatures.addDefaultSprings(settings);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.1F).scale(0.2F).temperature(0.7F).downfall(0.8F).specialEffects(new BiomeAmbience.Builder().waterColor(0x3F76E4)
                .waterFogColor(0x3F76E4).fogColor(0xB9D1FF).skyColor(0x82A8FF).grassColorOverride(0x79C05A).backgroundMusic(BackgroundMusicTracks.createGameMusic(BMSounds.MUSIC_OVERWORLD_BACK_FIELDS))
                .ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawns.build()).generationSettings(settings.build()).build();
    }

    private static Biome originalBackFields() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().setPlayerCanSpawn();

        // Adds the default features of a back field.
        BMDefaultBiomeFeatures.addBackFieldFeatures(settings, spawns);

        // Add twice the amount of back field flower generation for this biome.
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.BACK_FIELD_FLOWER_PATCH);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.BACK_FIELD_FLOWER_PATCH);

        BMDefaultBiomeFeatures.addOriginalBackFieldTrees(settings);
        DefaultBiomeFeatures.addDefaultOres(settings);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.1F).scale(0.2F).temperature(0.7F).downfall(0.8F).specialEffects(new BiomeAmbience.Builder().waterColor(0x3F76E4)
                .waterFogColor(0x3F76E4).fogColor(0xB9D1FF).skyColor(0x82A8FF).backgroundMusic(BackgroundMusicTracks.createGameMusic(BMSounds.MUSIC_OVERWORLD_BACK_FIELDS)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS)
                .grassColorOverride(0x79C05A).build()).mobSpawnSettings(spawns.build()).generationSettings(settings.build()).build();
    }

    private static Biome modifiedBackFields() {
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);

        BMDefaultBiomeFeatures.addBackFieldFeatures(settings, spawns);
        BMDefaultBiomeFeatures.addModifiedBackFieldTrees(settings);
        DefaultBiomeFeatures.addDefaultOres(settings);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(1.5F).scale(0.025F).temperature(0.7F).downfall(0.8F).specialEffects(new BiomeAmbience.Builder().waterColor(0x3F76E4)
                .waterFogColor(0x3F76E4).fogColor(0xB9D1FF).skyColor(0x82A8FF).backgroundMusic(BackgroundMusicTracks.createGameMusic(BMSounds.MUSIC_OVERWORLD_BACK_FIELDS)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS)
                .grassColorOverride(0x79C05A).build()).mobSpawnSettings(spawns.build()).generationSettings(settings.build()).build();
    }

    private static Biome angelicWoods() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().setPlayerCanSpawn();

        DefaultBiomeFeatures.addDefaultOverworldLandStructures(settings);
        settings.addStructureStart(StructureFeatures.RUINED_PORTAL_MOUNTAIN);
        settings.addStructureStart(StructureFeatures.OCEAN_RUIN_COLD);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_DEEP);

        DefaultBiomeFeatures.addDefaultCarvers(settings);
        DefaultBiomeFeatures.addDefaultOres(settings);
        DefaultBiomeFeatures.addDefaultSoftDisks(settings);
        DefaultBiomeFeatures.addPlainGrass(settings);
        DefaultBiomeFeatures.addDefaultGrass(settings);
        DefaultBiomeFeatures.commonSpawns(spawns);

        DefaultBiomeFeatures.addDefaultSprings(settings);
        DefaultBiomeFeatures.addDefaultExtraVegetation(settings);
        DefaultBiomeFeatures.addDefaultMonsterRoom(settings);
        DefaultBiomeFeatures.addDefaultLakes(settings);
        DefaultBiomeFeatures.addDefaultUndergroundVariety(settings);
        DefaultBiomeFeatures.addSurfaceFreezing(settings);
        DefaultBiomeFeatures.addDefaultSeagrass(settings);
        DefaultBiomeFeatures.addColdOceanExtraVegetation(settings);

        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.CRYSTALLINE_BIRCH_TREES);

        spawns.addSpawn(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(EntityType.SQUID, 3, 1, 4));
        spawns.addSpawn(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(EntityType.DOLPHIN, 1, 1, 2));
        spawns.addSpawn(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(EntityType.COD, 15, 3, 6));
        spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.DROWNED, 100, 1, 1));

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(-1.8F).scale(2).temperature(0.7F).downfall(0.8F).specialEffects(new BiomeAmbience.Builder().waterColor(0x77BAE8)
                .waterFogColor(0x77BAE8).fogColor(0xB9D1FF).foliageColorOverride(0xFFEC4F).skyColor(0x82A8FF).backgroundMusic(BackgroundMusicTracks.createGameMusic(BMSounds.MUSIC_OVERWORLD_ANGELIC_WOODS))
                .ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).grassColorOverride(0xD4EAEA).build()).mobSpawnSettings(spawns.build()).generationSettings(settings.build()).build();
    }

    // Aljan Biomes
    private static Biome sleepishOcean() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder();

        BMDefaultBiomeFeatures.addAljanUndergroundVariety(settings);
        settings.addFeature(GenerationStage.Decoration.LAKES, BMConfiguredFeatures.SLEEPISHWATER_LAKE);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.AVONDALIC_BUSHES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJAN_WOODS_FLOWER_PATCH);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.SLEEPSHROOM_PATCH);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_NORMAL);
        settings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMConfiguredFeatures.INSOGRAVEL_DISK);
        settings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMConfiguredFeatures.ALJAMIC_SAND_DISK);
        DefaultBiomeFeatures.addForestGrass(settings);
        DefaultBiomeFeatures.addDefaultSeagrass(settings);
        DefaultBiomeFeatures.addColdOceanExtraVegetation(settings);
        DefaultBiomeFeatures.addSurfaceFreezing(settings);
        BMDefaultBiomeFeatures.aljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.OCEAN).depth(-1).scale(0.1F).temperature(0.5F).downfall(0.5F).specialEffects((new BiomeAmbience.Builder()).waterColor(0x280C40)
                .waterFogColor(0x1D082E).fogColor(0xB9D1FF).skyColor(0xD4EAEA).foliageColorOverride(0xD73fC1).grassColorOverride(0xCC3DB4).backgroundMusic(BackgroundMusicTracks.createGameMusic(BMSounds.MUSIC_ALJAN)).build())
                .mobSpawnSettings(spawns.build()).generationSettings(settings.build()).build();
    }

    private static Biome deepSleepishOcean() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder();

        BMDefaultBiomeFeatures.addAljanUndergroundVariety(settings);
        settings.addFeature(GenerationStage.Decoration.LAKES, BMConfiguredFeatures.SLEEPISHWATER_LAKE);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJAN_WOODS_FLOWER_PATCH);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.SLEEPSHROOM_PATCH);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.AVONDALIC_BUSHES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_DEEP);
        settings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMConfiguredFeatures.INSOGRAVEL_DISK);
        settings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMConfiguredFeatures.ALJAMIC_SAND_DISK);
        DefaultBiomeFeatures.addForestGrass(settings);
        DefaultBiomeFeatures.addDefaultSeagrass(settings);
        DefaultBiomeFeatures.addColdOceanExtraVegetation(settings);
        DefaultBiomeFeatures.addSurfaceFreezing(settings);
        BMDefaultBiomeFeatures.aljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.OCEAN).depth(-1.8F).scale(0.1F).temperature(0.5F).downfall(0.5F).specialEffects(new BiomeAmbience.Builder().waterColor(0x280C40)
                .waterFogColor(0x1D082E).fogColor(0xB9D1FF).skyColor(0xD4EAEA).foliageColorOverride(0x68135C).grassColorOverride(0x9C3A8B).backgroundMusic(BackgroundMusicTracks.createGameMusic(BMSounds.MUSIC_ALJAN)).build())
                .mobSpawnSettings(spawns.build()).generationSettings(settings.build()).build();
    }

    private static Biome deeperSleepishOcean() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder();

        BMDefaultBiomeFeatures.addAljanUndergroundVariety(settings);
        settings.addFeature(GenerationStage.Decoration.LAKES, BMConfiguredFeatures.SLEEPISHWATER_LAKE);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJAN_WOODS_FLOWER_PATCH);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.SLEEPSHROOM_PATCH);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.AVONDALIC_BUSHES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_DEEP);
        settings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMConfiguredFeatures.INSOGRAVEL_DISK);
        settings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMConfiguredFeatures.ALJAMIC_SAND_DISK);
        DefaultBiomeFeatures.addForestGrass(settings);
        DefaultBiomeFeatures.addDefaultSeagrass(settings);
        DefaultBiomeFeatures.addColdOceanExtraVegetation(settings);
        DefaultBiomeFeatures.addSurfaceFreezing(settings);
        BMDefaultBiomeFeatures.aljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.OCEAN).depth(-2.4F).scale(0.1F).temperature(0.5F).downfall(0.5F).specialEffects(new BiomeAmbience.Builder().waterColor(0x280C40)
                .waterFogColor(0x1D082E).fogColor(0xB9D1FF).skyColor(0xD4EAEA).foliageColorOverride(0x4E1045).grassColorOverride(0x1D082E).backgroundMusic(BackgroundMusicTracks.createGameMusic(BMSounds.MUSIC_ALJAN)).build())
                .mobSpawnSettings(spawns.build()).generationSettings(settings.build()).build();
    }

    private static Biome aljanWoods() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().setPlayerCanSpawn();

        DefaultBiomeFeatures.addForestGrass(settings);
        BMDefaultBiomeFeatures.addAljanUndergroundVariety(settings);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJANWOOD_TREES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJAN_WOODS_FLOWER_PATCH);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJAN_WOODS_FLOWER_PATCH_SINGLE);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJANSHROOM_PATCH);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.WILD_ALJAMIC_ONIONS_PATCH);
        settings.addFeature(GenerationStage.Decoration.LAKES, BMConfiguredFeatures.SLEEPISHWATER_LAKE);
        BMDefaultBiomeFeatures.aljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.2F).scale(0.5F).temperature(0.5F).downfall(0.8F).specialEffects(new BiomeAmbience.Builder().waterColor(0x280C40)
                .waterFogColor(0x1D082E).fogColor(0xB9D1FF).skyColor(0xD4EAEA).foliageColorOverride(0xFFFFFF).grassColorOverride(0xD4EAEA).backgroundMusic(BackgroundMusicTracks.createGameMusic(BMSounds.MUSIC_ALJAN)).build())
                .mobSpawnSettings(spawns.build()).generationSettings(settings.build()).build();
    }

    private static Biome cappedHills() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().setPlayerCanSpawn();

        DefaultBiomeFeatures.addForestGrass(settings);
        BMDefaultBiomeFeatures.addAljanUndergroundVariety(settings);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJANCAP_TREES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.CAPPED_HILLS_FLOWER_PATCH);
        settings.addFeature(GenerationStage.Decoration.LAKES, BMConfiguredFeatures.SLEEPISHWATER_LAKE);
        BMDefaultBiomeFeatures.aljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.2F).scale(0.5F).temperature(0.5F).downfall(0.8F).specialEffects(new BiomeAmbience.Builder().waterColor(0x280C40)
                .waterFogColor(0x1D082E).fogColor(0xB9D1FF).skyColor(0xD4EAEA).foliageColorOverride(0x538989).grassColorOverride(0x68A4A4).backgroundMusic(BackgroundMusicTracks.createGameMusic(BMSounds.MUSIC_ALJAN)).build())
                .mobSpawnSettings(spawns.build()).generationSettings(settings.build()).build();
    }

    private static Biome insomnianWoods() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().setPlayerCanSpawn();

        DefaultBiomeFeatures.addForestGrass(settings);
        BMDefaultBiomeFeatures.addAljanUndergroundVariety(settings);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.INSOMNIAN_TREES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.INSOMNIAN_WOODS_FLOWER_PATCH);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.SLEEPYSHROOM_PATCH);
        settings.addFeature(GenerationStage.Decoration.LAKES, BMConfiguredFeatures.SLEEPISHWATER_LAKE);
        BMDefaultBiomeFeatures.aljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.1F).scale(0.5F).temperature(0.4F).downfall(0.5F).specialEffects(new BiomeAmbience.Builder().waterColor(0x280C40)
                .waterFogColor(0x1D082E).fogColor(0xB9D1FF).skyColor(0xD4EAEA).foliageColorOverride(0xF0B87A).grassColorOverride(0x526B9E).backgroundMusic(BackgroundMusicTracks.createGameMusic(BMSounds.MUSIC_ALJAN)).build())
                .mobSpawnSettings(spawns.build()).generationSettings(settings.build()).build();
    }

    private static Biome amaracamelSticks() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().setPlayerCanSpawn();

        DefaultBiomeFeatures.addForestGrass(settings);
        BMDefaultBiomeFeatures.addAljanUndergroundVariety(settings);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.AMARACAP_TREE);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJANSHROOM_PATCH);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.WILD_CARAMELED_WHEAT_PATCH);
        settings.addFeature(GenerationStage.Decoration.LAKES, BMConfiguredFeatures.SLEEPISHWATER_LAKE);

        BMDefaultBiomeFeatures.aljanMobs(spawns);
        if (BMConfigs.COMMON_CONFIGS.amaracamelerSpawn.get()) spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(BMEntities.AMARACAMELER.get(), 50, 1, 2));

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.SWAMP).depth(0.1F).scale(0.5F).temperature(0.4F).downfall(0.5F).specialEffects(new BiomeAmbience.Builder().waterColor(0x280C40)
                .waterFogColor(0x1D082E).fogColor(0xB9D1FF).skyColor(0xD4EAEA).foliageColorOverride(0xF0B87A).grassColorOverride(0xFCB76B).backgroundMusic(BackgroundMusicTracks.createGameMusic(BMSounds.MUSIC_ALJAN)).build())
                .mobSpawnSettings(spawns.build()).generationSettings(settings.build()).build();
    }

    private static Biome aljamicHighlands() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().setPlayerCanSpawn();

        DefaultBiomeFeatures.addForestGrass(settings);
        DefaultBiomeFeatures.addSurfaceFreezing(settings);
        BMDefaultBiomeFeatures.addAljanUndergroundVariety(settings);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJANWOOD_TREES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJAN_WOODS_FLOWER_PATCH);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJANSHROOM_PATCH);
        settings.addFeature(GenerationStage.Decoration.LAKES, BMConfiguredFeatures.SLEEPISHWATER_LAKE);
        BMDefaultBiomeFeatures.aljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.SNOW).biomeCategory(Biome.Category.FOREST).depth(1.5F).scale(0.025F).temperature(-0.3F).downfall(0.8F).specialEffects(new BiomeAmbience.Builder()
                .waterColor(0x280C40).waterFogColor(0x1D082E).fogColor(0xB9D1ff).skyColor(0xD4EAEA).foliageColorOverride(0xFFFFFF).grassColorOverride(0xD4EAEA).backgroundMusic(BackgroundMusicTracks.createGameMusic(BMSounds.MUSIC_ALJAN))
                .build()).mobSpawnSettings(spawns.build()).generationSettings(settings.build()).build();
    }

    private static Biome aljamicOrchard() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().setPlayerCanSpawn();

        BMDefaultBiomeFeatures.addAljanUndergroundVariety(settings);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJANSHROOM_PATCH);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJAMIC_ORCHARD_TREES);
        settings.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, BMConfiguredFeatures.ALJANCAP_LEAF_PILE);
        settings.addFeature(GenerationStage.Decoration.LAKES, BMConfiguredFeatures.SLEEPISHWATER_LAKE);
        BMDefaultBiomeFeatures.aljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.1F).scale(0.5F).temperature(0.6F).downfall(0.9F).specialEffects(new BiomeAmbience.Builder().waterColor(0x280C40)
                .waterFogColor(0x1D082E).fogColor(0xB9D1FF).skyColor(0xD4EAEA).foliageColorOverride(0x7ABDBD).grassColorOverride(0x78BFBF).backgroundMusic(BackgroundMusicTracks.createGameMusic(BMSounds.MUSIC_ALJAN)).build())
                .mobSpawnSettings(spawns.build()).generationSettings(settings.build()).build();
    }

    private static Biome avondalicGrove() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(BMSurfaceBuilders.AVONDALIC);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().setPlayerCanSpawn();

        DefaultBiomeFeatures.addForestGrass(settings);
        BMDefaultBiomeFeatures.addAljanUndergroundVariety(settings);
        settings.addFeature(GenerationStage.Decoration.LAKES, BMConfiguredFeatures.SLEEPISHWATER_LAKE);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.AVONDALIC_WILLOW_TREES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.AVONDALIC_WILLOW_TREES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.AVONDALIC_WILLOW_TREES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.AVONDALIC_WILLOW_TREES);
        settings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.AVONDALIC_WILLOW_TREES);
        BMDefaultBiomeFeatures.aljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.1F).scale(0.5F).temperature(0.6F).downfall(0.9F).specialEffects(new BiomeAmbience.Builder().waterColor(0x280C40)
                .waterFogColor(0x1D082E).fogColor(0xB9D1FF).skyColor(0xD4EAEA).foliageColorOverride(0xD73FC1).grassColorOverride(0xCC3DB4).backgroundMusic(BackgroundMusicTracks.createGameMusic(BMSounds.MUSIC_ALJAN)).build())
                .mobSpawnSettings(spawns.build()).generationSettings(settings.build()).build();
    }
}
