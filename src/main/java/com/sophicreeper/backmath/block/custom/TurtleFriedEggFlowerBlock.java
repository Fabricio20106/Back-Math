package com.sophicreeper.backmath.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.potion.Effects;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class TurtleFriedEggFlowerBlock extends FlowerBlock {
    public TurtleFriedEggFlowerBlock(Properties properties) {
        super(Effects.WATER_BREATHING, 12, properties);
    }

    protected boolean isValidGround(BlockState state, IBlockReader world, BlockPos pos) {
        return super.isValidGround(state, world, pos) || state.isIn(BlockTags.SAND);
    }
}
