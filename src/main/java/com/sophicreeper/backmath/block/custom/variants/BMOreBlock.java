package com.sophicreeper.backmath.block.custom.variants;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;

public class BMOreBlock extends OreBlock {
    private final int minXP;
    private final int maxXP;

    public BMOreBlock(int minXP, int maxXP, Properties properties) {
        super(properties);
        this.minXP = minXP;
        this.maxXP = maxXP;
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silkTouch) {
        return silkTouch == 0 ? MathHelper.nextInt(RANDOM, this.minXP, this.maxXP) : 0;
    }
}
