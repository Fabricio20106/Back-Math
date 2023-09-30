package com.sophicreeper.backmath.core.world.level.biome;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.config.BMConfigs;
import com.sophicreeper.backmath.core.data.worldgen.BMDefaultBiomeFeatures;
import com.sophicreeper.backmath.core.world.BMFeatures;
import com.sophicreeper.backmath.core.world.entity.BMEntities;
import com.sophicreeper.backmath.core.world.surfacebuilders.BMSurfaceBuilders;
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

    // This is the actual original back fields, the back Field.
    private static Biome backField() {
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244178_j);

        // Structures
        DefaultBiomeFeatures.withStrongholdAndMineshaft(settings);
        settings.withStructure(StructureFeatures.RUINED_PORTAL);
        settings.withStructure(StructureFeatures.VILLAGE_PLAINS);

        DefaultBiomeFeatures.withCavesAndCanyons(settings);
        DefaultBiomeFeatures.withLavaAndWaterLakes(settings);
        DefaultBiomeFeatures.withMonsterRoom(settings);

        // Underground Ores / Disks
        DefaultBiomeFeatures.withCommonOverworldBlocks(settings);
        DefaultBiomeFeatures.withOverworldOres(settings);
        DefaultBiomeFeatures.withDisks(settings);

        // Passive and hostile mob spawns
        DefaultBiomeFeatures.withBatsAndHostiles(spawns);
        DefaultBiomeFeatures.withPassiveMobs(spawns);
        BMDefaultBiomeFeatures.withBackFieldMobs(spawns);

        // Vegetal Decoration
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.BACK_FIELD_FLOWER_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.GUARANA_OAKS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.MANGO_OAKS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.OAKS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.HILLARY_LAKE);

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

        // to create a regular back fields to then add new things to it
        BMDefaultBiomeFeatures.withGeneralBackFieldThings(settings, spawns);

        // 2x more flower patches and with the original back fields trees
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.BACK_FIELD_FLOWER_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.BACK_FIELD_FLOWER_PATCH);
        BMDefaultBiomeFeatures.withOriginalBackFieldTrees(settings);
        DefaultBiomeFeatures.withOverworldOres(settings);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(0.1F).scale(0.2F).temperature(0.7F).downfall(0.8F).setEffects(new
                        BiomeAmbience.Builder().setWaterColor(0x3F76E4).setWaterFogColor(0x3F76E4).setFogColor(0xb9d1ff).withSkyColor(0x82a8ff).setMoodSound(MoodSoundAmbience
                        .DEFAULT_CAVE).withGrassColor(0x79C05A).build()).withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome modifiedBackFields() {
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244178_j);

        BMDefaultBiomeFeatures.withGeneralBackFieldThings(settings, spawns);
        BMDefaultBiomeFeatures.withModifiedBackFieldTrees(settings);
        DefaultBiomeFeatures.withOverworldOres(settings);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(1.5f).scale(0.025f).temperature(0.7F).downfall(0.8F).setEffects(new
                BiomeAmbience.Builder().setWaterColor(0x3F76E4).setWaterFogColor(0x3F76E4).setFogColor(0xb9d1ff).withSkyColor(0x82a8ff).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE)
                .withGrassColor(0x79C05A).build()).withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome angelicWoods() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244178_j);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();

        DefaultBiomeFeatures.withCavesAndCanyons(settings);
        DefaultBiomeFeatures.withOverworldOres(settings);
        DefaultBiomeFeatures.withDisks(settings);
        DefaultBiomeFeatures.withNoiseTallGrass(settings);
        DefaultBiomeFeatures.withNormalGrassPatch(settings);
        DefaultBiomeFeatures.withBatsAndHostiles(spawns);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.CRYSTALLINE_BIRCHES);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(1.5f).scale(0.025f).temperature(0.7F).downfall(0.8F).setEffects(
                new BiomeAmbience.Builder().setWaterColor(0x77BAE8).setWaterFogColor(0x77BAE8).setFogColor(0xb9d1ff).withFoliageColor(0xffec4f).withSkyColor(0x82a8ff).setMoodSound(MoodSoundAmbience.
                                DEFAULT_CAVE).withGrassColor(0xd4eaea).build()).withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome sleepishOcean() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder();

        BMDefaultBiomeFeatures.withCommonUndergroundAljanBlocks(settings);
        settings.withFeature(GenerationStage.Decoration.LAKES, BMFeatures.SLEEPISHWATER_LAKE);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.AVONDALIC_BUSHES);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.ALJAN_WOODS_FLOWER_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.SLEEPSHROOM_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_NORMAL);
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMFeatures.INSOGRAVEL_DISK);
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMFeatures.INSOGRAVEL_DISK);
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMFeatures.ALJAMIC_SAND_DISK);
        DefaultBiomeFeatures.withForestGrass(settings);
        DefaultBiomeFeatures.withSimpleSeagrass(settings);
        DefaultBiomeFeatures.withColdKelp(settings);
        DefaultBiomeFeatures.withFrozenTopLayer(settings);
        BMDefaultBiomeFeatures.withAljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.OCEAN).depth(-1.0F).scale(0.1F).temperature(0.5F).downfall(0.5F)
                .setEffects((new BiomeAmbience.Builder()).setWaterColor(0x280c40).setWaterFogColor(0x1d082e).setFogColor(0xb9d1ff).withSkyColor(0xd4eaea)
                        .withFoliageColor(0xd73fc1).withGrassColor(0xcc3db4).build()).withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome deepSleepishOcean() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder();

        BMDefaultBiomeFeatures.withCommonUndergroundAljanBlocks(settings);
        settings.withFeature(GenerationStage.Decoration.LAKES, BMFeatures.SLEEPISHWATER_LAKE);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.ALJAN_WOODS_FLOWER_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.SLEEPSHROOM_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.AVONDALIC_BUSHES);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_DEEP);
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMFeatures.INSOGRAVEL_DISK);
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMFeatures.INSOGRAVEL_DISK);
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMFeatures.ALJAMIC_SAND_DISK);
        DefaultBiomeFeatures.withForestGrass(settings);
        DefaultBiomeFeatures.withSimpleSeagrass(settings);
        DefaultBiomeFeatures.withColdKelp(settings);
        DefaultBiomeFeatures.withFrozenTopLayer(settings);
        BMDefaultBiomeFeatures.withAljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.OCEAN).depth(-1.8F).scale(0.1F).temperature(0.5F).downfall(0.5F)
                .setEffects((new BiomeAmbience.Builder()).setWaterColor(0x280c40).setWaterFogColor(0x1d082e).setFogColor(0xb9d1ff).withSkyColor(0xd4eaea)
                        .withFoliageColor(0x68135c).withGrassColor(0x9c3a8b).build()).withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome deeperSleepishOcean() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder();

        BMDefaultBiomeFeatures.withCommonUndergroundAljanBlocks(settings);
        settings.withFeature(GenerationStage.Decoration.LAKES, BMFeatures.SLEEPISHWATER_LAKE);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.ALJAN_WOODS_FLOWER_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.SLEEPSHROOM_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.AVONDALIC_BUSHES);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_DEEP);
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMFeatures.INSOGRAVEL_DISK);
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMFeatures.INSOGRAVEL_DISK);
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BMFeatures.ALJAMIC_SAND_DISK);
        DefaultBiomeFeatures.withForestGrass(settings);
        DefaultBiomeFeatures.withSimpleSeagrass(settings);
        DefaultBiomeFeatures.withColdKelp(settings);
        DefaultBiomeFeatures.withFrozenTopLayer(settings);
        BMDefaultBiomeFeatures.withAljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.OCEAN).depth(-2.4F).scale(0.1F).temperature(0.5F).downfall(0.5F)
                .setEffects((new BiomeAmbience.Builder()).setWaterColor(0x280c40).setWaterFogColor(0x1d082e).setFogColor(0xb9d1ff).withSkyColor(0xd4eaea)
                        .withFoliageColor(0x4e1045).withGrassColor(0x1d082e).build()).withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome aljanWoods() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();

        DefaultBiomeFeatures.withForestGrass(settings);
        BMDefaultBiomeFeatures.withCommonUndergroundAljanBlocks(settings);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.ALJANWOODS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.ALJAN_WOODS_FLOWER_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.ALJAN_WOODS_FLOWER_PATCH_SINGLE);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.ALJANSHROOM_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.ALJAN_WOODS_WAO_PATCH);
        settings.withFeature(GenerationStage.Decoration.LAKES, BMFeatures.SLEEPISHWATER_LAKE);
        BMDefaultBiomeFeatures.withAljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(0.2f).scale(0.5f).temperature(0.5F).downfall(0.8F).setEffects(
                        new BiomeAmbience.Builder().setWaterColor(0x280c40).setWaterFogColor(0x1d082e).setFogColor(0xb9d1ff).withSkyColor(0xd4eaea).withFoliageColor(0xffffff).withGrassColor(0xd4eaea).build())
                .withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome cappedHills() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();

        DefaultBiomeFeatures.withForestGrass(settings);
        BMDefaultBiomeFeatures.withCommonUndergroundAljanBlocks(settings);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.ALJANCAPS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.CAPPED_HILLS_FLOWER_PATCH);
        settings.withFeature(GenerationStage.Decoration.LAKES, BMFeatures.SLEEPISHWATER_LAKE);
        BMDefaultBiomeFeatures.withAljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(0.2f).scale(0.5f).temperature(0.5F).downfall(0.8F).setEffects(
                        new BiomeAmbience.Builder().setWaterColor(0x280c40).setWaterFogColor(0x1d082e).setFogColor(0xb9d1ff).withSkyColor(0xd4eaea).withFoliageColor(0x538989).withGrassColor(0x68a4a4).build())
                .withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome insomnianWoods() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();

        DefaultBiomeFeatures.withForestGrass(settings);
        BMDefaultBiomeFeatures.withCommonUndergroundAljanBlocks(settings);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.INSOMNIANS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.INSOMNIAN_WOODS_FLOWER_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.SLEEPYSHROOM_PATCH);
        settings.withFeature(GenerationStage.Decoration.LAKES, BMFeatures.SLEEPISHWATER_LAKE);
        BMDefaultBiomeFeatures.withAljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(0.1f).scale(0.5f).temperature(0.4F).downfall(0.5F).setEffects(
                new BiomeAmbience.Builder().setWaterColor(0x280c40).setWaterFogColor(0x1d082e).setFogColor(0xb9d1ff).withSkyColor(0xd4eaea).withFoliageColor(0xf0b87a).withGrassColor(0x526b9e).build())
                .withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome amaracamelSticks() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();

        DefaultBiomeFeatures.withForestGrass(settings);
        BMDefaultBiomeFeatures.withCommonUndergroundAljanBlocks(settings);
        if (BMConfigs.SERVER_CONFIGS.amaracamelerSpawn.get()) {
            spawns.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(BMEntities.AMARACAMELER.get(), 50, 1, 2));
        }
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.AMARACAP);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.ALJANSHROOM_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.AMARACAMEL_STICKS_WCW_PATCH);
        settings.withFeature(GenerationStage.Decoration.LAKES, BMFeatures.SLEEPISHWATER_LAKE);
        BMDefaultBiomeFeatures.withAljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.SWAMP).depth(0.1f).scale(0.5f).temperature(0.4f).downfall(0.5f).setEffects(
                new BiomeAmbience.Builder().setWaterColor(0x280c40).setWaterFogColor(0x1d082e).setFogColor(0xB9D1FF).withSkyColor(0xD4EAEA).withFoliageColor(0xf0b87a).withGrassColor(0xFCB76B).build())
                .withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome aljamicHighlands() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();

        DefaultBiomeFeatures.withForestGrass(settings);
        DefaultBiomeFeatures.withFrozenTopLayer(settings);
        BMDefaultBiomeFeatures.withCommonUndergroundAljanBlocks(settings);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.ALJANWOODS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.ALJAN_WOODS_FLOWER_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.ALJANSHROOM_PATCH);
        settings.withFeature(GenerationStage.Decoration.LAKES, BMFeatures.SLEEPISHWATER_LAKE);
        BMDefaultBiomeFeatures.withAljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.SNOW).category(Biome.Category.FOREST).depth(1.5f).scale(0.025f).temperature(-0.3F).downfall(0.8F).setEffects(
                        new BiomeAmbience.Builder().setWaterColor(0x280c40).setWaterFogColor(0x1d082e).setFogColor(0xb9d1ff).withSkyColor(0xd4eaea).withFoliageColor(0xffffff).withGrassColor(0xd4eaea).build())
                .withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome aljamicOrchard() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(BMSurfaceBuilders.ALJAN);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();

        BMDefaultBiomeFeatures.withCommonUndergroundAljanBlocks(settings);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.ALJANSHROOM_PATCH);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.ALJANWOODS_ORCHARD);
        settings.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, BMFeatures.ALJANCAP_LEAF_PILE);
        settings.withFeature(GenerationStage.Decoration.LAKES, BMFeatures.SLEEPISHWATER_LAKE);
        BMDefaultBiomeFeatures.withAljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(0.1f).scale(0.5f).temperature(0.6f).downfall(0.9f).setEffects(
                new BiomeAmbience.Builder().setWaterColor(0x280c40).setWaterFogColor(0x1d082e).setFogColor(0xb9d1ff).withSkyColor(0xd4eaea).withFoliageColor(0x7abdbd).withGrassColor(0x78bfbf).build())
                .withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }

    private static Biome avondalicGrove() {
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(BMSurfaceBuilders.AVONDALIC);
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();

        DefaultBiomeFeatures.withForestGrass(settings);
        BMDefaultBiomeFeatures.withCommonUndergroundAljanBlocks(settings);
        settings.withFeature(GenerationStage.Decoration.LAKES, BMFeatures.SLEEPISHWATER_LAKE);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.AVONDALIC_WILLOWS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.AVONDALIC_WILLOWS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.AVONDALIC_WILLOWS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.AVONDALIC_WILLOWS);
        settings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BMFeatures.AVONDALIC_WILLOWS);
        BMDefaultBiomeFeatures.withAljanMobs(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(0.1f).scale(0.5f).temperature(0.6f).downfall(0.9f).setEffects(
                        new BiomeAmbience.Builder().setWaterColor(0x280c40).setWaterFogColor(0x1d082e).setFogColor(0xb9d1ff).withSkyColor(0xd4eaea).withFoliageColor(0xd73fc1).withGrassColor(0xcc3db4).build())
                .withMobSpawnSettings(spawns.copy()).withGenerationSettings(settings.build()).build();
    }
}
