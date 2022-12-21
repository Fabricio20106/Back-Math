package com.sophicreeper.backmath.core.world.gen.carver;

import com.sophicreeper.backmath.core.world.level.biome.BMBiomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Objects;

public class BMCarverGeneration {
    public static void generateCarvers(final BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder settings = event.getGeneration();

        if (Objects.equals(BMBiomes.ALJAN_WOODS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.CAPPED_HILLS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.INSOMNIAN_WOODS.get().getRegistryName(),
                event.getName()) || Objects.equals(BMBiomes.AMARACAMEL_STICKS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.ALJAMIC_HIGHLANDS.get().getRegistryName(), event.getName())) {
            settings.withCarver(GenerationStage.Carving.AIR, BMConfiguredCarvers.ALJAN_CAVE);
            settings.withCarver(GenerationStage.Carving.AIR, BMConfiguredCarvers.ALJAN_CANYON);
        }
        if (Objects.equals(BMBiomes.SLEEPISH_OCEAN.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.DEEP_SLEEPISH_OCEAN.get().getRegistryName(), event.getName())) {
            settings.withCarver(GenerationStage.Carving.LIQUID, BMConfiguredCarvers.UNDERWATER_ALJAN_CAVE);
        }
    }
}
