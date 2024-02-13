package com.sophicreeper.backmath.world.structure;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.world.BMConfiguredFeatures;
import com.sophicreeper.backmath.world.biome.BMBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import static com.sophicreeper.backmath.world.biome.BMBiomes.*;

public class BMStructureGeneration {
    public static Biome[] ALJAN_BIOMES = new Biome[] {ALJAN_WOODS.get(), CAPPED_HILLS.get(), INSOMNIAN_WOODS.get(), AMARACAMEL_STICKS.get(), ALJAMIC_HIGHLANDS.get(), AVONDALIC_GROVE.get(), ALJAMIC_ORCHARD.get(),
            SLEEPISH_OCEAN.get(), DEEP_SLEEPISH_OCEAN.get(), DEEPER_SLEEPISH_OCEAN.get()};
    public static Biome[] ALJAN_BIOMES_NO_OCEANS = new Biome[] {ALJAN_WOODS.get(), CAPPED_HILLS.get(), INSOMNIAN_WOODS.get(), AMARACAMEL_STICKS.get(), ALJAMIC_HIGHLANDS.get(), AVONDALIC_GROVE.get(), ALJAMIC_ORCHARD.get()};

    public static void generateStructures(final BiomeLoadingEvent event) {
        List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

        if (Objects.equals(BMBiomes.ORIGINAL_BACK_FIELDS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.MODIFIED_BACK_FIELDS.get().getRegistryName(), event.getName())) {
            if (BMConfigs.COMMON_CONFIGS.sophieTowerGeneration.get()) structures.add(() -> BMStructures.SOPHIE_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
            if (BMConfigs.COMMON_CONFIGS.angerDungeonsInBackFields.get()) event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, BMConfiguredFeatures.ANGER_DUNGEON);
        }

        for (Biome biome : ALJAN_BIOMES) {
            if (!(Objects.equals(biome.getRegistryName(), event.getName())) && event.getCategory() != Biome.Category.NETHER && event.getCategory() != Biome.Category.THEEND) {
                if (BMConfigs.COMMON_CONFIGS.fabricioHideoutDungeonGeneration.get()) structures.add(() -> BMStructures.FABRICIO_HIDEOUT_DUNGEON.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
            }

            if (Objects.equals(biome.getRegistryName(), event.getName()) && BMConfigs.COMMON_CONFIGS.aljanDungeonsInAljan.get()) {
                event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, BMConfiguredFeatures.ALJAN_DUNGEON);
            }
        }
    }
}
