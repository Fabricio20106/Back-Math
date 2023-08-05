package com.sophicreeper.backmath.core.world.level.block;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;

public class LightLayerFlowerBlock extends FlowerBlock {
    public LightLayerFlowerBlock(Properties properties) {
        super(MobEffects.GLOWING, 10, properties);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}
