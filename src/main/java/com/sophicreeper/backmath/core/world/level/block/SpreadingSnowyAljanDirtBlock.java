package com.sophicreeper.backmath.core.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.SnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LightEngine;

public class SpreadingSnowyAljanDirtBlock extends SnowyDirtBlock {
    public SpreadingSnowyAljanDirtBlock(Properties builder) {
        super(builder);
    }

    private static boolean isSnowyConditions(BlockState state, LevelReader worldReader, BlockPos pos) {
        BlockPos abovePos = pos.above();
        BlockState aboveState = worldReader.getBlockState(abovePos);
        if (aboveState.is(Blocks.SNOW) && aboveState.getValue(SnowLayerBlock.LAYERS) == 1) {
            return true;
        } else if (aboveState.getFluidState().getAmount() == 8) {
            return false;
        } else {
            int i = LightEngine.getLightBlockInto(worldReader, state, pos, aboveState, abovePos, Direction.UP, aboveState.getLightBlock(worldReader, abovePos));
            return i < worldReader.getMaxLightLevel();
        }
    }

    private static boolean isSnowyAndNotUnderwater(BlockState state, LevelReader worldReader, BlockPos pos) {
        BlockPos abovePos = pos.above();
        return isSnowyConditions(state, worldReader, pos) && !worldReader.getFluidState(abovePos).is(FluidTags.WATER);
    }

    /**
     * Performs a random tick on a block.
     */
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (!isSnowyConditions(state, world, pos)) {
            if (!world.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            world.setBlockAndUpdate(pos, BMBlocks.ALJAMIC_DIRT.get().defaultBlockState());
        } else {
            if (!world.isAreaLoaded(pos, 3)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            if (world.getMaxLocalRawBrightness(pos.above()) >= 9) {
                BlockState state1 = this.defaultBlockState();

                for(int i = 0; i < 4; ++i) {
                    BlockPos pos1 = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                    if (world.getBlockState(pos1).is(BMBlocks.ALJAMIC_DIRT.get()) && isSnowyAndNotUnderwater(state1, world, pos1)) {
                        world.setBlockAndUpdate(pos1, state1.setValue(SNOWY, world.getBlockState(pos1.above()).is(Blocks.SNOW)));
                    }
                }
            }

        }
    }
}
