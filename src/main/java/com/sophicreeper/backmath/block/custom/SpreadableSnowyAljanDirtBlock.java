package com.sophicreeper.backmath.block.custom;

import com.sophicreeper.backmath.block.BMBlocks;
import net.minecraft.block.*;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.lighting.LightEngine;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class SpreadableSnowyAljanDirtBlock extends SnowyDirtBlock {
    public SpreadableSnowyAljanDirtBlock(Properties properties) {
        super(properties);
    }

    private static boolean isSnowyConditions(BlockState state, IWorldReader world, BlockPos pos) {
        BlockPos abovePos = pos.above();
        BlockState aboveState = world.getBlockState(abovePos);
        if (aboveState.is(Blocks.SNOW) && aboveState.getValue(SnowBlock.LAYERS) == 1) {
            return true;
        } else if (aboveState.getFluidState().getAmount() == 8) {
            return false;
        } else {
            int lightBlockInto = LightEngine.getLightBlockInto(world, state, pos, aboveState, abovePos, Direction.UP, aboveState.getLightBlock(world, abovePos));
            return lightBlockInto < world.getMaxLightLevel();
        }
    }

    private static boolean isSnowyAndNotUnderwater(BlockState state, IWorldReader world, BlockPos pos) {
        BlockPos abovePos = pos.above();
        return isSnowyConditions(state, world, pos) && !world.getFluidState(abovePos).is(FluidTags.WATER);
    }

    // Performs a random tick on a block.
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!isSnowyConditions(state, world, pos)) {
            if (!world.isAreaLoaded(pos, 3)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading.
            world.setBlockAndUpdate(pos, BMBlocks.ALJAMIC_DIRT.get().defaultBlockState());
        } else {
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
