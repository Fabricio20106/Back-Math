package com.sophicreeper.backmath.world.structure;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.world.biome.BMBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class BMStructureGeneration {
    public static void generateStructures(final BiomeLoadingEvent event) {
        List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

        if (Objects.equals(BMBiomes.ORIGINAL_BACK_FIELDS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.MODIFIED_BACK_FIELDS.get().getRegistryName(), event.getName()) && BMConfigs.SERVER_CONFIGS.sophieTowerGeneration.get()) {
            structures.add(() -> BMStructures.SOPHIE_TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }

        if (!(Objects.equals(BMBiomes.ALJAN_WOODS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.CAPPED_HILLS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.INSOMNIAN_WOODS.get().getRegistryName(),
                event.getName()) || Objects.equals(BMBiomes.SLEEPISH_OCEAN.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.DEEP_SLEEPISH_OCEAN.get().getRegistryName(), event.getName())
                || Objects.equals(BMBiomes.AMARACAMEL_STICKS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.ALJAMIC_HIGHLANDS.get().getRegistryName(), event.getName())
                || Objects.equals(BMBiomes.AVONDALIC_GROVE.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.ALJAMIC_ORCHARD.get().getRegistryName(), event.getName()))) {
            if (!(event.getCategory() == Biome.Category.NETHER || event.getCategory() == Biome.Category.THEEND) && BMConfigs.SERVER_CONFIGS.fabricioHideoutDungeonGeneration.get()) {
                structures.add(() -> BMStructures.FABRICIO_HIDEOUT_DUNGEON.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
            }
        }
    }
}