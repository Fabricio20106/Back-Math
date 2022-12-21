package com.sophicreeper.backmath.core.world.level.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BMFallingBlock extends FallingBlock {
    private final int dustColor;

    public BMFallingBlock(int particleColor, Properties properties) {
        super(properties);
        this.dustColor = particleColor;
    }

    @OnlyIn(Dist.CLIENT)
    public int getDustColor(BlockState state, IBlockReader reader, BlockPos pos) {
        return this.dustColor;
    }
}
