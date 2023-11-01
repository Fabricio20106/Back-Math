package com.sophicreeper.backmath.block.custom;

import com.sophicreeper.backmath.block.BMBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public abstract class AbstractWildCropBlock extends BushBlock {
    public AbstractWildCropBlock(Properties properties) {
        super(properties);
    }

    protected boolean isValidGround(BlockState state, IBlockReader reader, BlockPos pos) {
        return state.isIn(BMBlocks.ALJAMIC_GRASS_BLOCK.get()) || state.isIn(BMBlocks.ALJAMIC_DIRT.get()) || state.isIn(BMBlocks.ALJAMIC_FARMLAND.get()) || state.isIn(BMBlocks.AVONDALIC_NYLIUM.get());
    }

    public abstract IItemProvider getSeedItem();

    @Override
    public ItemStack getItem(IBlockReader reader, BlockPos pos, BlockState state) {
        return new ItemStack(this.getSeedItem());
    }
}
