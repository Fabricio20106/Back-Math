package com.sophicreeper.backmath.world.surface;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.block.BMBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class BMSurfaceBuilders {
    public static final BlockState ALJAMIC_GRASS = BMBlocks.ALJAMIC_GRASS_BLOCK.get().getDefaultState();
    public static final BlockState AVONDALIC_NYLIUM = BMBlocks.AVONDALIC_NYLIUM.get().getDefaultState();
    public static final BlockState ALJAMIC_DIRT = BMBlocks.ALJAMIC_DIRT.get().getDefaultState();

    public static final SurfaceBuilderConfig ALJAMIC_GRASS_CONFIG = new SurfaceBuilderConfig(ALJAMIC_GRASS, ALJAMIC_DIRT, ALJAMIC_DIRT);
    public static final SurfaceBuilderConfig AVONDALIC_NYLIUM_CONFIG = new SurfaceBuilderConfig(AVONDALIC_NYLIUM, ALJAMIC_DIRT, ALJAMIC_DIRT);

    public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> ALJAN = register("the_aljan", SurfaceBuilder.DEFAULT.func_242929_a(ALJAMIC_GRASS_CONFIG));
    public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> AVONDALIC = register("avondalic_grove", SurfaceBuilder.DEFAULT.func_242929_a(AVONDALIC_NYLIUM_CONFIG));

    private static <SC extends ISurfaceBuilderConfig> ConfiguredSurfaceBuilder<SC> register(String name, ConfiguredSurfaceBuilder<SC> configuredSurfaceBuilder) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, BackMath.resourceLoc(name), configuredSurfaceBuilder);
    }

    public static void init() {}
}
