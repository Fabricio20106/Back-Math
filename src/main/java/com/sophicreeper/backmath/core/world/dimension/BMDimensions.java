package com.sophicreeper.backmath.core.world.dimension;

import com.sophicreeper.backmath.core.client.BackMath;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

public class BMDimensions {
    public static final ResourceKey<Level> THE_ALJAN = ResourceKey.create(Registries.DIMENSION, BackMath.resourceLoc("the_aljan"));

    public static void init() {}
}
