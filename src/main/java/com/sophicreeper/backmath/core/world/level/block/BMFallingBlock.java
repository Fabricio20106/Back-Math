package com.sophicreeper.backmath.core.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BMFallingBlock extends FallingBlock {
    private final int dustColor;

    public BMFallingBlock(int particleColor, Properties properties) {
        super(properties);
        this.dustColor = particleColor;
    }

    @OnlyIn(Dist.CLIENT)
    public int getDustColor(BlockState state, BlockGetter reader, BlockPos pos) {
        return this.dustColor;
    }
}
