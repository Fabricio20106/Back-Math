package com.sophicreeper.backmath.core.world.level.biome;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.data.worldgen.BMBiomeDefaultFeatures;
import com.sophicreeper.backmath.core.world.feature.BMPlacedFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.Musics;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class BMBiomes {
    public static final ResourceKey<Biome> ORIGINAL_BACK_FIELDS = registerKey("original_back_fields");
    public static final ResourceKey<Biome> MODIFIED_BACK_FIELDS = registerKey("modified_back_fields");
    public static final ResourceKey<Biome> ANGELIC_WOODS = registerKey("angelic_woods");

    public static void boostrap(BootstapContext<Biome> context) {
        context.register(ORIGINAL_BACK_FIELDS, originalBackFields(context));
        context.register(MODIFIED_BACK_FIELDS, modifiedBackFields(context));
        context.register(ANGELIC_WOODS, angelicWoods(context));
    }

    public static Biome originalBackFields(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawns = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        // Adds the basic Back Fields features to add new things down the line.
        BMBiomeDefaultFeatures.addDefaultBackFieldsFeatures(settings, spawns);

        // 2x more flower patches and with the original back fields trees
        // settings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BMPlacedFeatures.PLACED_BACK_FIELD_FLOWERS);
        // settings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BMPlacedFeatures.PLACED_BACK_FIELD_FLOWERS);
        BMBiomeDefaultFeatures.addOriginalBackFieldsTrees(settings);

        return new Biome.BiomeBuilder().hasPrecipitation(true).downfall(0.8f).temperature(0.7f).generationSettings(settings.build()).mobSpawnSettings(
                spawns.build()).specialEffects(new BiomeSpecialEffects.Builder().waterColor(0x3F76E4).waterFogColor(0x3F76E4).skyColor(0x82A8FF)
                .grassColorOverride(0x79C05A).fogColor(0xB9D1FF).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(Musics.GAME).build())
                .build();
    }

    public static Biome modifiedBackFields(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawns = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BMBiomeDefaultFeatures.addDefaultBackFieldsFeatures(settings, spawns);
        BMBiomeDefaultFeatures.addModifiedBackFieldTrees(settings);

        return new Biome.BiomeBuilder().hasPrecipitation(true).downfall(0.8f).temperature(0.7f).generationSettings(settings.build()).mobSpawnSettings(
                        spawns.build()).specialEffects(new BiomeSpecialEffects.Builder().waterColor(0x3F76E4).waterFogColor(0x3F76E4).skyColor(0x82A8FF)
                        .grassColorOverride(0x79C05A).fogColor(0xB9D1FF).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(Musics.GAME).build())
                .build();
    }

    public static Biome angelicWoods(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawns = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BMBiomeDefaultFeatures.addBasicBiomeFeatures(settings, spawns);
        BiomeDefaultFeatures.addPlainGrass(settings);
        BiomeDefaultFeatures.addForestGrass(settings);
        settings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BMPlacedFeatures.PLACED_CRYSTALLINE_BIRCH);

        return new Biome.BiomeBuilder().hasPrecipitation(true).downfall(0.8f).temperature(0.7f).generationSettings(settings.build()).mobSpawnSettings(
                        spawns.build()).specialEffects(new BiomeSpecialEffects.Builder().waterColor(0x77BAE8).waterFogColor(0x77BAE8).skyColor(0x82A8FF)
                        .grassColorOverride(0xD4EAEA).foliageColorOverride(0xFFEC4F).fogColor(0xB9D1FF).ambientMoodSound(
                                AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(Musics.GAME).build()).build();
    }

    public static ResourceKey<Biome> registerKey(String name) {
        return ResourceKey.create(Registries.BIOME, BackMath.resourceLoc(name));
    }

    // This is the actual original back fields, the back Field.
    /*private static Biome backField() {
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
    }*/
}
