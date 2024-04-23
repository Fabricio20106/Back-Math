package com.sophicreeper.backmath.world.dimension;

import com.sophicreeper.backmath.BackMath;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class BMDimensions {
    public static final RegistryKey<World> THE_ALJAN = RegistryKey.create(Registry.DIMENSION_REGISTRY, BackMath.resourceLoc("the_aljan"));

    public static void init() {}
}
