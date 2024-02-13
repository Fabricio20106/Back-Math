package com.sophicreeper.backmath.world.biome;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.world.BMConfiguredFeatures;
import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.world.biome.custom.BMDefaultBiomeFeatures;
import com.sophicreeper.backmath.world.surface.BMSurfaceBuilders;
import net.minecraft.entity.EntityClassification;
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

    public static final RegistryObject<Biome> BACK_FIELD = BIOMES.register("back_field", BMBiomes::backField);
    public static final RegistryObject<Biome> ORIGINAL_BACK_FIELDS = BIOMES.register("original_back_fields", BMBiomes::originalBackFields);
    public static final RegistryObject<Biome> MODIFIED_BACK_FIELDS = BIOMES.register("modified_back_fields", BMBiomes::modifiedBackFields);
    public static final RegistryObject<Biome> ANGELIC_WOODS = BIOMES.register("angelic_woods", BMBiomes::angelicWoods);
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
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244178_j);

        // Structures Generation
        DefaultBiomeFeatures.withStrongholdAndMineshaft(settings);
        settings.withStructure(StructureFeatures.RUINED_PORTAL);
        settings.withStructure(StructureFeatures.VILLAGE_PLAINS);

        DefaultBiomeFeatures.withCavesAndCanyons(settings);
        DefaultBiomeFeatures.withLavaAndWaterLakes(settings);
        DefaultBiomeFeatures.withMonsterRoom(settings);

        // Underground Ores & Disks
        DefaultBiomeFeatures.withCommonOverworldBlocks(settings);
        DefaultBiomeFeatures.withOverworldOres(settings);
        DefaultBiomeFeatures.withDisks(settings);

        // Passive and hostile mob spawns
        DefaultBiomeFeatures.withBatsAndHostiles(spawns);
        DefaultBiomeFeatures.withPassiveMobs(spawns);
        BMDefaultBiomeFeatures.backFieldHostiles(spawns);

        // Vegetal Decoration
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.BACK_FIELD_FLOWER_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.GUARANA_OAKS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.MANGO_OAKS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.OAKS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.HILLARY_LAKE);

        DefaultBiomeFeatures.withForestGrass(settings);
        DefaultBiomeFeatures.withSugarCaneAndPumpkins(settings);
        DefaultBiomeFeatures.withLavaAndWaterSprings(settings);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(0.1F).scale(0.2F).temperature(0.7F).downfall(0.8F).setEffects(new
                BiomeAmbience.Builder().setWaterColor(0x3F76E4).setWaterFogColor(0x3F76E4).setFogColor(0xb9d1ff).withSkyColor(0x82a8ff).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE)
                .withGrassColor(0x79C05A).build()).withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome originalBackFields() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244178_j);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();

        // Adds the default features of a Back Field.
        BMDefaultBiomeFeatures.addBackFieldFeatures(settings, spawns);

        // Add twice the amount of Back Field flower generation for this biome.
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.BACK_FIELD_FLOWER_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.BACK_FIELD_FLOWER_PATCH);

        BMDefaultBiomeFeatures.addOriginalBackFieldTrees(settings);
        DefaultBiomeFeatures.withOverworldOres(settings);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(0.1F).scale(0.2F).temperature(0.7F).downfall(0.8F).setEffects(new
                        BiomeAmbience.Builder().setWaterColor(0x3F76E4).setWaterFogColor(0x3F76E4).setFogColor(0xb9d1ff).withSkyColor(0x82a8ff).setMoodSound(MoodSoundAmbience
                        .DEFAULT_CAVE).withGrassColor(0x79C05A).build()).withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome modifiedBackFields() {
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244178_j);

        BMDefaultBiomeFeatures.addBackFieldFeatures(settings, spawns);
        BMDefaultBiomeFeatures.addModifiedBackFieldTrees(settings);
        DefaultBiomeFeatures.withOverworldOres(settings);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(1.5f).scale(0.025f).temperature(0.7F).downfall(0.8F).setEffects(new
                BiomeAmbience.Builder().setWaterColor(0x3F76E4).setWaterFogColor(0x3F76E4).setFogColor(0xb9d1ff).withSkyColor(0x82a8ff).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE)
                .withGrassColor(0x79C05A).build()).withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome angelicWoods() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244178_j);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();

        DefaultBiomeFeatures.withStrongholdAndMineshaft(settings);
        settings.withStructure(StructureFeatures.RUINED_PORTAL_MOUNTAIN);

        DefaultBiomeFeatures.withCavesAndCanyons(settings);
        DefaultBiomeFeatures.withOverworldOres(settings);
        DefaultBiomeFeatures.withDisks(settings);
        DefaultBiomeFeatures.withNoiseTallGrass(settings);
        DefaultBiomeFeatures.withNormalGrassPatch(settings);
        DefaultBiomeFeatures.withBatsAndHostiles(spawns);

        DefaultBiomeFeatures.withLavaAndWaterSprings(settings);
        DefaultBiomeFeatures.withSugarCaneAndPumpkins(settings);
        DefaultBiomeFeatures.withMonsterRoom(settings);
        DefaultBiomeFeatures.withLavaAndWaterLakes(settings);
        DefaultBiomeFeatures.withCommonOverworldBlocks(settings);

        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.CRYSTALLINE_BIRCHES);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(1.5f).scale(0.025f).temperature(0.7F).downfall(0.8F).setEffects(
                new BiomeAmbience.Builder().setWaterColor(0x77BAE8).setWaterFogColor(0x77BAE8).setFogColor(0xb9d1ff).withFoliageColor(0xffec4f).withSkyColor(0x82a8ff).setMoodSound(MoodSoundAmbience.
                                DEFAULT_CAVE).withGrassColor(0xd4eaea).build()).withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome sleepishOcean() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder();

        BMDefaultBiomeFeatures.addAljanUndergroundVariety(settings);
        settings.withFeature(GenerationStage.Decoration.LAKES, BMConfiguredFeatures.SLEEPISHWATER_LAKE);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.AVONDALIC_BUSHES);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJAN_WOODS_FLOWER_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.SLEEPSHROOM_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_NORMAL);
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMConfiguredFeatures.INSOGRAVEL_DISK);
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMConfiguredFeatures.ALJAMIC_SAND_DISK);
        DefaultBiomeFeatures.withForestGrass(settings);
        DefaultBiomeFeatures.withSimpleSeagrass(settings);
        DefaultBiomeFeatures.withColdKelp(settings);
        DefaultBiomeFeatures.withFrozenTopLayer(settings);
        BMDefaultBiomeFeatures.aljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.OCEAN).depth(-1).scale(0.1F).temperature(0.5F).downfall(0.5F)
                .setEffects((new BiomeAmbience.Builder()).setWaterColor(0x280C40).setWaterFogColor(0x1D082E).setFogColor(0xB9D1FF).withSkyColor(0xD4EAEA)
                        .withFoliageColor(0xD73fC1).withGrassColor(0xCC3DB4).build()).withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome deepSleepishOcean() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder();

        BMDefaultBiomeFeatures.addAljanUndergroundVariety(settings);
        settings.withFeature(GenerationStage.Decoration.LAKES, BMConfiguredFeatures.SLEEPISHWATER_LAKE);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJAN_WOODS_FLOWER_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.SLEEPSHROOM_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.AVONDALIC_BUSHES);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_DEEP);
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMConfiguredFeatures.INSOGRAVEL_DISK);
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMConfiguredFeatures.ALJAMIC_SAND_DISK);
        DefaultBiomeFeatures.withForestGrass(settings);
        DefaultBiomeFeatures.withSimpleSeagrass(settings);
        DefaultBiomeFeatures.withColdKelp(settings);
        DefaultBiomeFeatures.withFrozenTopLayer(settings);
        BMDefaultBiomeFeatures.aljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.OCEAN).depth(-1.8F).scale(0.1F).temperature(0.5F).downfall(0.5F)
                .setEffects((new BiomeAmbience.Builder()).setWaterColor(0x280C40).setWaterFogColor(0x1D082E).setFogColor(0xb9d1ff).withSkyColor(0xd4eaea)
                        .withFoliageColor(0x68135c).withGrassColor(0x9c3a8b).build()).withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome deeperSleepishOcean() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder();

        BMDefaultBiomeFeatures.addAljanUndergroundVariety(settings);
        settings.withFeature(GenerationStage.Decoration.LAKES, BMConfiguredFeatures.SLEEPISHWATER_LAKE);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJAN_WOODS_FLOWER_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.SLEEPSHROOM_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.AVONDALIC_BUSHES);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_DEEP);
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMConfiguredFeatures.INSOGRAVEL_DISK);
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMConfiguredFeatures.ALJAMIC_SAND_DISK);
        DefaultBiomeFeatures.withForestGrass(settings);
        DefaultBiomeFeatures.withSimpleSeagrass(settings);
        DefaultBiomeFeatures.withColdKelp(settings);
        DefaultBiomeFeatures.withFrozenTopLayer(settings);
        BMDefaultBiomeFeatures.aljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.OCEAN).depth(-2.4F).scale(0.1F).temperature(0.5F).downfall(0.5F)
                .setEffects((new BiomeAmbience.Builder()).setWaterColor(0x280C40).setWaterFogColor(0x1D082E).setFogColor(0xb9d1ff).withSkyColor(0xd4eaea)
                        .withFoliageColor(0x4e1045).withGrassColor(0x1d082e).build()).withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome aljanWoods() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();

        DefaultBiomeFeatures.withForestGrass(settings);
        BMDefaultBiomeFeatures.addAljanUndergroundVariety(settings);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJANWOODS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJAN_WOODS_FLOWER_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJAN_WOODS_FLOWER_PATCH_SINGLE);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJANSHROOM_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJAN_WOODS_WAO_PATCH);
        settings.withFeature(GenerationStage.Decoration.LAKES, BMConfiguredFeatures.SLEEPISHWATER_LAKE);
        BMDefaultBiomeFeatures.aljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(0.2f).scale(0.5f).temperature(0.5F).downfall(0.8F).setEffects(
                        new BiomeAmbience.Builder().setWaterColor(0x280C40).setWaterFogColor(0x1D082E).setFogColor(0xB9D1FF).withSkyColor(0xD4EAEA).withFoliageColor(0xFFFFFF).withGrassColor(0xD4EAEA).build())
                .withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome cappedHills() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();

        DefaultBiomeFeatures.withForestGrass(settings);
        BMDefaultBiomeFeatures.addAljanUndergroundVariety(settings);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJANCAPS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.CAPPED_HILLS_FLOWER_PATCH);
        settings.withFeature(GenerationStage.Decoration.LAKES, BMConfiguredFeatures.SLEEPISHWATER_LAKE);
        BMDefaultBiomeFeatures.aljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(0.2f).scale(0.5f).temperature(0.5F).downfall(0.8F).setEffects(
                        new BiomeAmbience.Builder().setWaterColor(0x280C40).setWaterFogColor(0x1D082E).setFogColor(0xB9D1FF).withSkyColor(0xD4EAEA).withFoliageColor(0x538989).withGrassColor(0x68A4A4).build())
                .withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome insomnianWoods() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();

        DefaultBiomeFeatures.withForestGrass(settings);
        BMDefaultBiomeFeatures.addAljanUndergroundVariety(settings);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.INSOMNIANS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.INSOMNIAN_WOODS_FLOWER_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.SLEEPYSHROOM_PATCH);
        settings.withFeature(GenerationStage.Decoration.LAKES, BMConfiguredFeatures.SLEEPISHWATER_LAKE);
        BMDefaultBiomeFeatures.aljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(0.1f).scale(0.5f).temperature(0.4F).downfall(0.5F).setEffects(
                new BiomeAmbience.Builder().setWaterColor(0x280C40).setWaterFogColor(0x1D082E).setFogColor(0xB9D1FF).withSkyColor(0xD4EAEA).withFoliageColor(0xF0B87A).withGrassColor(0x526B9E).build())
                .withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome amaracamelSticks() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();

        DefaultBiomeFeatures.withForestGrass(settings);
        BMDefaultBiomeFeatures.addAljanUndergroundVariety(settings);
        if (BMConfigs.COMMON_CONFIGS.amaracamelerSpawn.get()) {
            spawns.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(BMEntities.AMARACAMELER.get(), 50, 1, 2));
        }
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.AMARACAP);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJANSHROOM_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.AMARACAMEL_STICKS_WCW_PATCH);
        settings.withFeature(GenerationStage.Decoration.LAKES, BMConfiguredFeatures.SLEEPISHWATER_LAKE);
        BMDefaultBiomeFeatures.aljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.SWAMP).depth(0.1f).scale(0.5f).temperature(0.4f).downfall(0.5f).setEffects(
                new BiomeAmbience.Builder().setWaterColor(0x280C40).setWaterFogColor(0x1D082E).setFogColor(0xB9D1FF).withSkyColor(0xD4EAEA).withFoliageColor(0xF0B87A).withGrassColor(0xFCB76B).build())
                .withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome aljamicHighlands() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();

        DefaultBiomeFeatures.withForestGrass(settings);
        DefaultBiomeFeatures.withFrozenTopLayer(settings);
        BMDefaultBiomeFeatures.addAljanUndergroundVariety(settings);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJANWOODS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJAN_WOODS_FLOWER_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJANSHROOM_PATCH);
        settings.withFeature(GenerationStage.Decoration.LAKES, BMConfiguredFeatures.SLEEPISHWATER_LAKE);
        BMDefaultBiomeFeatures.aljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.SNOW).category(Biome.Category.FOREST).depth(1.5f).scale(0.025f).temperature(-0.3F).downfall(0.8F).setEffects(
                        new BiomeAmbience.Builder().setWaterColor(0x280C40).setWaterFogColor(0x1D082E).setFogColor(0xB9D1ff).withSkyColor(0xD4EAEA).withFoliageColor(0xFFFFFF).withGrassColor(0xD4EAEA).build())
                .withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome aljamicOrchard() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();

        BMDefaultBiomeFeatures.addAljanUndergroundVariety(settings);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJANSHROOM_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.ALJANWOODS_ORCHARD);
        settings.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, BMConfiguredFeatures.ALJANCAP_LEAF_PILE);
        settings.withFeature(GenerationStage.Decoration.LAKES, BMConfiguredFeatures.SLEEPISHWATER_LAKE);
        BMDefaultBiomeFeatures.aljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(0.1f).scale(0.5f).temperature(0.6f).downfall(0.9f).setEffects(
                new BiomeAmbience.Builder().setWaterColor(0x280C40).setWaterFogColor(0x1D082E).setFogColor(0xB9D1FF).withSkyColor(0xD4EAEA).withFoliageColor(0x7ABDBD).withGrassColor(0x78BFBF).build())
                .withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome avondalicGrove() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(BMSurfaceBuilders.AVONDALIC);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();

        DefaultBiomeFeatures.withForestGrass(settings);
        BMDefaultBiomeFeatures.addAljanUndergroundVariety(settings);
        settings.withFeature(GenerationStage.Decoration.LAKES, BMConfiguredFeatures.SLEEPISHWATER_LAKE);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.AVONDALIC_WILLOWS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.AVONDALIC_WILLOWS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.AVONDALIC_WILLOWS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.AVONDALIC_WILLOWS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMConfiguredFeatures.AVONDALIC_WILLOWS);
        BMDefaultBiomeFeatures.aljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(0.1f).scale(0.5f).temperature(0.6f).downfall(0.9f).setEffects(
                        new BiomeAmbience.Builder().setWaterColor(0x280C40).setWaterFogColor(0x1D082E).setFogColor(0xB9D1FF).withSkyColor(0xD4EAEA).withFoliageColor(0xD73FC1).withGrassColor(0xCC3DB4).build())
                .withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }
}
