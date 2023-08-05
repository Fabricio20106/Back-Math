package com.sophicreeper.backmath.core.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class EDFEFlowerBlock extends FlowerBlock {
    public EDFEFlowerBlock(Properties properties) {
        super(MobEffects.LEVITATION, 10, properties);
    }

    protected boolean mayPlaceOn(BlockState state, BlockGetter world, BlockPos pos) {
        return super.mayPlaceOn(state, world, pos) || state.is(Blocks.END_STONE) || state.is(Blocks.END_STONE_BRICKS);
    }
}
