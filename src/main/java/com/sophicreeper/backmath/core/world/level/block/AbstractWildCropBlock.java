package com.sophicreeper.backmath.core.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;

public abstract class AbstractWildCropBlock extends BushBlock {
    public AbstractWildCropBlock(Properties properties) {
        super(properties);
    }

    protected boolean mayPlaceOn(BlockState state, BlockGetter reader, BlockPos pos) {
        return state.is(BMBlocks.ALJAMIC_GRASS_BLOCK.get()) || state.is(BMBlocks.ALJAMIC_DIRT.get()) || state.is(BMBlocks.ALJAMIC_FARMLAND.get()) || state.is(BMBlocks.AVONDALIC_NYLIUM.get());
    }

    public abstract ItemLike getSeedItem();

    @Override
    public ItemStack getCloneItemStack(BlockGetter reader, BlockPos pos, BlockState state) {
        return new ItemStack(this.getSeedItem());
    }
}
