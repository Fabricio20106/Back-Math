package com.sophicreeper.backmath.world.carver;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.world.biome.BMBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Objects;

import static com.sophicreeper.backmath.world.structure.BMStructureGeneration.ALJAN_BIOMES_NO_OCEANS;

public class BMCarverGeneration {
    public static void generateCarvers(final BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder settings = event.getGeneration();

        if (BMConfigs.COMMON_CONFIGS.enableAljanCarverGeneration.get()) {
            for (Biome biome : ALJAN_BIOMES_NO_OCEANS) {
                if (Objects.equals(biome.getRegistryName(), event.getName()) && BMConfigs.COMMON_CONFIGS.enableAljanCavesAndRavines.get()){
                    settings.withCarver(GenerationStage.Carving.AIR, BMConfiguredCarvers.ALJAN_CAVE);
                    settings.withCarver(GenerationStage.Carving.AIR, BMConfiguredCarvers.ALJAN_RAVINE);
                }

                if (Objects.equals(BMBiomes.SLEEPISH_OCEAN.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.DEEP_SLEEPISH_OCEAN.get().getRegistryName(), event.getName()) && BMConfigs.COMMON_CONFIGS.enableUnderwaterAljanCaves.get()) {
                    settings.withCarver(GenerationStage.Carving.LIQUID, BMConfiguredCarvers.ALJAN_UNDERWATER_CAVE);
                }
            }
        }
    }
}
