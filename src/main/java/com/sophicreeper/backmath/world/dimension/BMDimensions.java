package com.sophicreeper.backmath.world.dimension;

import com.sophicreeper.backmath.BackMath;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

public class BMDimensions {
    public static final RegistryKey<World> THE_ALJAN = RegistryKey.create(Registry.DIMENSION_REGISTRY, BackMath.backMath("the_aljan"));
    public static final RegistryKey<Dimension> THE_ALJAN_DIM = RegistryKey.create(Registry.LEVEL_STEM_REGISTRY, BackMath.backMath("the_aljan"));
    public static final RegistryKey<DimensionType> THE_ALJAN_TYPE = RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, BackMath.backMath("the_aljan"));

    public static void init() {}
}
