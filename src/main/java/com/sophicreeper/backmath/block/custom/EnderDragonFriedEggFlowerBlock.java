package com.sophicreeper.backmath.block.custom;

import com.sophicreeper.backmath.util.tag.BMBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.potion.Effect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class EnderDragonFriedEggFlowerBlock extends FlowerBlock {
    public EnderDragonFriedEggFlowerBlock(Effect effect, int duration, Properties properties) {
        super(effect, duration, properties);
    }

    protected boolean mayPlaceOn(BlockState state, IBlockReader world, BlockPos pos) {
        return state.is(BMBlockTags.ENDER_DRAGON_FRIED_EGG_FLOWER_PLANTABLE_ON);
    }
}
