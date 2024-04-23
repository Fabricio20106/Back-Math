package com.sophicreeper.backmath.block.custom;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.potion.Effect;

public class InsomnianTulipBlock extends FlowerBlock {
    public InsomnianTulipBlock(Effect effect, int duration, Properties properties) {
        super(effect, duration, properties);
    }

    @Override
    public BlockRenderType getRenderShape(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
