package com.sophicreeper.backmath.core.world.gen.carver;

import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import com.sophicreeper.backmath.core.world.level.material.BMFluids;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.world.gen.carver.CaveWorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class AljanCaveCarver extends CaveWorldCarver {
    public AljanCaveCarver(Codec<ProbabilityConfig> codec) {
        super(codec, 256);
        this.carvableBlocks = ImmutableSet.of(BMBlocks.ALJAMIC_DIRT.get(), BMBlocks.ALJAMIC_GRASS_BLOCK.get(), BMBlocks.ALJANSTONE.get(), BMBlocks.SLEEPINGSTONE.get(), BMBlocks.INSOGRAVEL.get(), Blocks.GRASS_BLOCK);
        this.carvableFluids = ImmutableSet.of(Fluids.WATER, BMFluids.SLEEPISHWATER.get());
    }
}
