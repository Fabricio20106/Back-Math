package com.sophicreeper.backmath.world.carver.custom;

import com.mojang.serialization.Codec;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.carver.CaveWorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class AljanCaveCarver extends CaveWorldCarver {
    public AljanCaveCarver(Codec<ProbabilityConfig> codec) {
        super(codec, 256);
    }

    @Override
    public boolean canReplaceBlock(BlockState state) {
        return state.is(BMTags.Blocks.ALJAN_CARVER_REPLACEABLES);
    }

    @Override
    protected boolean hasWater(IChunk chunk, int chunkX, int chunkZ, int minX, int maxX, int minY, int maxY, int minZ, int maxZ) {
        BlockPos.Mutable mutablePos = new BlockPos.Mutable();

        for(int i = minX; i < maxX; ++i) {
            for(int j = minZ; j < maxZ; ++j) {
                for(int k = minY - 1; k <= maxY + 1; ++k) {
                    if (BMTags.Fluids.ALJAN_CARVER_REPLACEABLES.equals(chunk.getFluidState(mutablePos.set(i + chunkX * 16, k, j + chunkZ * 16)).getType())) {
                        return true;
                    }

                    if (k != maxY + 1 && !this.isOnEdge(minX, maxX, minZ, maxZ, i, j)) {
                        k = maxY;
                    }
                }
            }
        }

        return false;
    }

    private boolean isOnEdge(int minX, int maxX, int minZ, int maxZ, int x, int z) {
        return x == minX || x == maxX - 1 || z == minZ || z == maxZ - 1;
    }
}
