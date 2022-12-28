package com.sophicreeper.backmath.core.world.level.block;

import net.minecraft.block.*;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.lighting.LightEngine;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class SpreadableSnowyAljanDirtBlock extends SnowyDirtBlock {
    public SpreadableSnowyAljanDirtBlock(AbstractBlock.Properties builder) {
        super(builder);
    }

    private static boolean isSnowyConditions(BlockState state, IWorldReader worldReader, BlockPos pos) {
        BlockPos abovePos = pos.up();
        BlockState aboveState = worldReader.getBlockState(abovePos);
        if (aboveState.isIn(Blocks.SNOW) && aboveState.get(SnowBlock.LAYERS) == 1) {
            return true;
        } else if (aboveState.getFluidState().getLevel() == 8) {
            return false;
        } else {
            int i = LightEngine.func_215613_a(worldReader, state, pos, aboveState, abovePos, Direction.UP, aboveState.getOpacity(worldReader, abovePos));
            return i < worldReader.getMaxLightLevel();
        }
    }

    private static boolean isSnowyAndNotUnderwater(BlockState state, IWorldReader worldReader, BlockPos pos) {
        BlockPos abovePos = pos.up();
        return isSnowyConditions(state, worldReader, pos) && !worldReader.getFluidState(abovePos).isTagged(FluidTags.WATER);
    }

    /**
     * Performs a random tick on a block.
     */
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!isSnowyConditions(state, world, pos)) {
            if (!world.isAreaLoaded(pos, 3)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            world.setBlockState(pos, BMBlocks.ALJAMIC_DIRT.get().getDefaultState());
        } else {
            if (world.getLight(pos.up()) >= 9) {
                BlockState state1 = this.getDefaultState();

                for(int i = 0; i < 4; ++i) {
                    BlockPos pos1 = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                    if (world.getBlockState(pos1).isIn(BMBlocks.ALJAMIC_DIRT.get()) && isSnowyAndNotUnderwater(state1, world, pos1)) {
                        world.setBlockState(pos1, state1.with(SNOWY, world.getBlockState(pos1.up()).isIn(Blocks.SNOW)));
                    }
                }
            }

        }
    }
}
