package com.sophicreeper.backmath.block.custom;

import com.sophicreeper.backmath.util.BMTags;
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
        return state.isIn(BMTags.Blocks.WILD_CROPS_PLANTABLE_ON);
    }

    public abstract IItemProvider getSeedItem();

    @Override
    public ItemStack getItem(IBlockReader reader, BlockPos pos, BlockState state) {
        return new ItemStack(this.getSeedItem());
    }
}
