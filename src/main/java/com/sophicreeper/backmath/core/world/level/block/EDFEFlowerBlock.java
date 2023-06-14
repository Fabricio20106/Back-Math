package com.sophicreeper.backmath.core.world.level.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class EDFEFlowerBlock extends FlowerBlock {
    public EDFEFlowerBlock(Properties properties) {
        super(Effects.LEVITATION, 10, properties);
    }

    protected boolean isValidGround(BlockState state, IBlockReader world, BlockPos pos) {
        return super.isValidGround(state, world, pos) || state.isIn(Blocks.END_STONE) || state.isIn(Blocks.END_STONE_BRICKS);
    }
}
