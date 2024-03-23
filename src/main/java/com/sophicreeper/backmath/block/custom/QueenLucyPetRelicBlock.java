package com.sophicreeper.backmath.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class QueenLucyPetRelicBlock extends Block {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public QueenLucyPetRelicBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case SOUTH:
                return qlpRelicSouth();
            case EAST:
                return qlpRelicEast();
            case WEST:
                return qlpRelicWest();
            case NORTH:
            default:
                return qlpRelicNorth();
        }
    }

    public VoxelShape qlpRelicNorth() {
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

    public VoxelShape qlpRelicSouth() {
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

    public VoxelShape qlpRelicEast() {
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

    public VoxelShape qlpRelicWest() {
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

    @Override
    public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
        if (state.get(WATERLOGGED)) world.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        return super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite()).with(WATERLOGGED, context.getWorld().getFluidState(context.getPos()).getFluid() == Fluids.WATER);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.toRotation(state.get(FACING)));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }
}
