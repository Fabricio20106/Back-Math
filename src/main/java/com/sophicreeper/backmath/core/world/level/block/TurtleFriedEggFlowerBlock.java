package com.sophicreeper.backmath.core.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class TurtleFriedEggFlowerBlock extends FlowerBlock {
    public TurtleFriedEggFlowerBlock(Properties properties) {
        super(MobEffects.WATER_BREATHING, 12, properties);
    }

    protected boolean mayPlaceOn(BlockState state, BlockGetter world, BlockPos pos) {
        return super.mayPlaceOn(state, world, pos) || state.is(BlockTags.SAND);
    }
}
