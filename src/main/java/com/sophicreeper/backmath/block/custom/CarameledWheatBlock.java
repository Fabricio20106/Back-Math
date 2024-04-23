package com.sophicreeper.backmath.block.custom;

import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class CarameledWheatBlock extends CropsBlock {
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0, 0, 0, 16, 2, 16),
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(0, 0, 0, 16, 6, 16),
            Block.box(0, 0, 0, 16, 8, 16),
            Block.box(0, 0, 0, 16, 10, 16),
            Block.box(0, 0, 0, 16, 12, 16),
            Block.box(0, 0, 0, 16, 14, 16),
            Block.box(0, 0, 0, 16, 16, 16)};

    public CarameledWheatBlock(Properties properties) {
        super(properties);
    }

    protected boolean mayPlaceOn(BlockState state, IBlockReader reader, BlockPos pos) {
        return state.is(BMTags.Blocks.ALJAN_CROP_PLANTABLE_ON);
    }

    protected IItemProvider getBaseSeedId() {
        return AxolotlTest.CARAMELED_WHEAT_SEEDS.get();
    }

    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
    }
}
