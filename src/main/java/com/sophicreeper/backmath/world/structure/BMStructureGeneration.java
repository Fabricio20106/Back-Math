package com.sophicreeper.backmath.world.structure;

import com.google.common.collect.Lists;
import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.world.BMConfiguredFeatures;
import com.sophicreeper.backmath.world.biome.BMBiomes;
import net.minecraft.util.ResourceLocation;
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
    public static final List<ResourceLocation> ALJAN_BIOMES = Lists.newArrayList(ALJAN_WOODS.get().getRegistryName(), CAPPED_HILLS.get().getRegistryName(), INSOMNIAN_WOODS.get().getRegistryName(), AMARACAMEL_STICKS.get().getRegistryName(),
            ALJAMIC_HIGHLANDS.get().getRegistryName(), AVONDALIC_GROVE.get().getRegistryName(), ALJAMIC_ORCHARD.get().getRegistryName(), SLEEPISH_OCEAN.get().getRegistryName(), DEEP_SLEEPISH_OCEAN.get().getRegistryName(),
            DEEPER_SLEEPISH_OCEAN.get().getRegistryName());
    public static final List<Biome> ALJAN_BIOMES_NO_OCEANS = Lists.newArrayList(ALJAN_WOODS.get(), CAPPED_HILLS.get(), INSOMNIAN_WOODS.get(), AMARACAMEL_STICKS.get(), ALJAMIC_HIGHLANDS.get(), AVONDALIC_GROVE.get(), ALJAMIC_ORCHARD.get());

    public static void generateStructures(final BiomeLoadingEvent event) {
        List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

        if (Objects.equals(BMBiomes.ORIGINAL_BACK_FIELDS.get().getRegistryName(), event.getName()) || Objects.equals(BMBiomes.MODIFIED_BACK_FIELDS.get().getRegistryName(), event.getName())) {
            if (BMConfigs.COMMON_CONFIGS.sophieTowerGeneration.get()) structures.add(() -> BMStructures.SOPHIE_TOWER.get().configured(IFeatureConfig.NONE));
            if (BMConfigs.COMMON_CONFIGS.angerDungeonsInBackFields.get()) event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, BMConfiguredFeatures.ANGER_DUNGEON);
        }

        if (event.getCategory() != Biome.Category.NETHER && event.getCategory() != Biome.Category.THEEND && BMConfigs.COMMON_CONFIGS.fabricioHideoutDungeonGeneration.get()) {
            structures.add(() -> BMStructures.FABRICIO_HIDEOUT_DUNGEON.get().configured(IFeatureConfig.NONE));
        }

        for (ResourceLocation location : ALJAN_BIOMES) {
            if (Objects.equals(location, event.getName()) && BMConfigs.COMMON_CONFIGS.aljanDungeonsInAljan.get()) {
                event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, BMConfiguredFeatures.ALJAN_DUNGEON);
            }
        }
    }
}
