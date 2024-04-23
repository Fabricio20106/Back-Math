package com.sophicreeper.backmath.world.feature;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.world.feature.custom.AljanDungeonFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BMFeature {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, BackMath.MOD_ID);

    public static final RegistryObject<Feature<NoFeatureConfig>> ALJAN_DUNGEON = FEATURES.register("aljan_dungeon", () -> new AljanDungeonFeature(NoFeatureConfig.CODEC));
}
