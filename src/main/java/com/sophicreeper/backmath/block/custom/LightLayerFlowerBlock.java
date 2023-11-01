package com.sophicreeper.backmath.block.custom;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.potion.Effects;

public class LightLayerFlowerBlock extends FlowerBlock {
    public LightLayerFlowerBlock(Properties properties) {
        super(Effects.GLOWING, 10, properties);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
