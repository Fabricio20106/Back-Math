package com.sophicreeper.backmath.core.world.level.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class QueenSophiePetRelicBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public QueenSophiePetRelicBlock() {
        super(AbstractBlock.Properties.from(Blocks.GOLD_BLOCK).harvestLevel(2).setLightLevel(state -> 5));
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case SOUTH:
                return qspRelicSouth();
            case EAST:
                return qspRelicEast();
            case WEST:
                return qspRelicWest();
            default:
                return qspRelicNorth();
        }
    }

    public VoxelShape qspRelicNorth() {
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.125, 0, 0.125, 0.875, 0.0625, 0.875), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.5, 0.0625, 0.4375, 0.625, 0.4375, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.375, 0.0625, 0.4375, 0.5, 0.4375, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.375, 0.4375, 0.4375, 0.625, 0.8125, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.3125, 0.4375, 0.4375, 0.375, 0.8125, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.625, 0.4375, 0.4375, 0.6875, 0.8125, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.375, 0.8125, 0.375, 0.625, 1.0625, 0.625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 1.0625, 0.4375, 0.5625, 1.1875, 0.4375), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 1.0625, 0.5625, 0.5625, 1.1875, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 1.0625, 0.4375, 0.4375, 1.1875, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.5625, 1.0625, 0.4375, 0.5625, 1.1875, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.0625, 0.4375, 0.5625, 0.5, 0.8125, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.5, 0.4375, 0.5625, 0.9375, 0.8125, 0.5625), IBooleanFunction.OR);
        return shape;
    }

    public VoxelShape qspRelicSouth() {
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.125, 0, 0.125, 0.875, 0.0625, 0.875), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.375, 0.0625, 0.4375, 0.5, 0.4375, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.5, 0.0625, 0.4375, 0.625, 0.4375, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.375, 0.4375, 0.4375, 0.625, 0.8125, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.625, 0.4375, 0.4375, 0.6875, 0.8125, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.3125, 0.4375, 0.4375, 0.375, 0.8125, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.375, 0.8125, 0.375, 0.625, 1.0625, 0.625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 1.0625, 0.5625, 0.5625, 1.1875, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 1.0625, 0.4375, 0.5625, 1.1875, 0.4375), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.5625, 1.0625, 0.4375, 0.5625, 1.1875, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 1.0625, 0.4375, 0.4375, 1.1875, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.5, 0.4375, 0.4375, 0.9375, 0.8125, 0.4375), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.0625, 0.4375, 0.4375, 0.5, 0.8125, 0.4375), IBooleanFunction.OR);
        return shape;
    }

    public VoxelShape qspRelicEast() {
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.125, 0, 0.125, 0.875, 0.0625, 0.875), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 0.0625, 0.5, 0.5625, 0.4375, 0.625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 0.0625, 0.375, 0.5625, 0.4375, 0.5), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 0.4375, 0.375, 0.5625, 0.8125, 0.625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 0.4375, 0.3125, 0.5625, 0.8125, 0.375), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 0.4375, 0.625, 0.5625, 0.8125, 0.6875), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.375, 0.8125, 0.375, 0.625, 1.0625, 0.625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.5625, 1.0625, 0.4375, 0.5625, 1.1875, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 1.0625, 0.4375, 0.4375, 1.1875, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 1.0625, 0.4375, 0.5625, 1.1875, 0.4375), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 1.0625, 0.5625, 0.5625, 1.1875, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 0.4375, 0.0625, 0.4375, 0.8125, 0.5), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 0.4375, 0.5, 0.4375, 0.8125, 0.9375), IBooleanFunction.OR);
        return shape;
    }

    public VoxelShape qspRelicWest() {
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.125, 0, 0.125, 0.875, 0.0625, 0.875), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 0.0625, 0.375, 0.5625, 0.4375, 0.5), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 0.0625, 0.5, 0.5625, 0.4375, 0.625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 0.4375, 0.375, 0.5625, 0.8125, 0.625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 0.4375, 0.625, 0.5625, 0.8125, 0.6875), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 0.4375, 0.3125, 0.5625, 0.8125, 0.375), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.375, 0.8125, 0.375, 0.625, 1.0625, 0.625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 1.0625, 0.4375, 0.4375, 1.1875, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.5625, 1.0625, 0.4375, 0.5625, 1.1875, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 1.0625, 0.5625, 0.5625, 1.1875, 0.5625), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.4375, 1.0625, 0.4375, 0.5625, 1.1875, 0.4375), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.5625, 0.4375, 0.5, 0.5625, 0.8125, 0.9375), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.5625, 0.4375, 0.0625, 0.5625, 0.8125, 0.5), IBooleanFunction.OR);
        return shape;
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
