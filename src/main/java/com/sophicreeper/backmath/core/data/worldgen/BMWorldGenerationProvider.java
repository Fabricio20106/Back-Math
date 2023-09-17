package com.sophicreeper.backmath.core.data.worldgen;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.world.BMBiomeModifiers;
import com.sophicreeper.backmath.core.world.feature.BMConfiguredFeatures;
import com.sophicreeper.backmath.core.world.feature.BMPlacedFeatures;
import com.sophicreeper.backmath.core.world.level.biome.BMBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class BMWorldGenerationProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, BMConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, BMPlacedFeatures::bootstrap)
            .add(Registries.BIOME, BMBiomes::boostrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, BMBiomeModifiers::bootstrap);

    public BMWorldGenerationProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> providerLookup) {
        super(output, providerLookup, BUILDER, Set.of(BackMath.MOD_ID));
    }
}
