package com.sophicreeper.backmath.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
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

import java.util.stream.Stream;

public class ToyBlock extends HorizontalBlock implements IWaterLoggable {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    private final Type type;

    public ToyBlock(Type type) {
        super(AbstractBlock.Properties.create(Material.WOOL).hardnessAndResistance(0.5F).sound(SoundType.CLOTH).notSolid());
        this.type = type;
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        Type type = this.type;
        if (state.get(FACING) == Direction.EAST && type == Type.ALICE_OR_ALAN || state.get(FACING) == Direction.WEST && type == Type.ALICE_OR_ALAN) {
            return ToyShapes.SHAPE_ALAN_OR_ALICE_EW;
        } else if (state.get(FACING) == Direction.NORTH && type == Type.ALICE_OR_ALAN || state.get(FACING) == Direction.SOUTH && type == Type.ALICE_OR_ALAN) {
            return ToyShapes.SHAPE_ALAN_OR_ALICE_NS;
        }

        else if (state.get(FACING) == Direction.NORTH && type == Type.MALENA) {
            return ToyShapes.SHAPE_MALENA_NORTH;
        } else if (state.get(FACING) == Direction.SOUTH && type == Type.MALENA) {
            return ToyShapes.SHAPE_MALENA_SOUTH;
        } else if (state.get(FACING) == Direction.EAST && type == Type.MALENA) {
            return ToyShapes.SHAPE_MALENA_EAST;
        } else if (state.get(FACING) == Direction.WEST && type == Type.MALENA) {
            return ToyShapes.SHAPE_MALENA_WEST;
        }

        else if (state.get(FACING) == Direction.EAST && type == Type.TYLER || state.get(FACING) == Direction.WEST && type == Type.TYLER) {
            return ToyShapes.SHAPE_TYLER_EW;
        } else if (state.get(FACING) == Direction.NORTH && type == Type.TYLER || state.get(FACING) == Direction.SOUTH && type == Type.TYLER) {
            return ToyShapes.SHAPE_TYLER_NS;
        }

        return ToyShapes.DEFAULT_SHAPE;
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

    public static class ToyShapes {
        public static final VoxelShape SHAPE_ALAN_OR_ALICE_NS = Stream.of(
                Block.makeCuboidShape(6, 6, 6, 10, 9, 10),
                Block.makeCuboidShape(9, 2, 7, 10, 6, 9),
                Block.makeCuboidShape(6, 2, 7, 7, 6, 9),
                Block.makeCuboidShape(7, 3, 7, 9, 6, 9),
                Block.makeCuboidShape(7, 0, 7, 9, 3, 9)
        ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

        public static final VoxelShape SHAPE_ALAN_OR_ALICE_EW = Stream.of(
                Block.makeCuboidShape(6, 6, 6, 10, 9, 10),
                Block.makeCuboidShape(7, 2, 6, 9, 6, 7),
                Block.makeCuboidShape(7, 2, 9, 9, 6, 10),
                Block.makeCuboidShape(7, 3, 7, 9, 6, 9),
                Block.makeCuboidShape(7, 0, 7, 9, 3, 9)
        ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

        public static final VoxelShape SHAPE_TYLER_NS = Stream.of(
                Block.makeCuboidShape(6, 8, 6, 10, 12, 10),
                Block.makeCuboidShape(4, 6, 7, 12, 8, 9),
                Block.makeCuboidShape(6, 0, 7, 10, 6, 9)
        ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

        public static final VoxelShape SHAPE_TYLER_EW = Stream.of(
                Block.makeCuboidShape(6, 8, 6, 10, 12, 10),
                Block.makeCuboidShape(7, 6, 4, 9, 8, 12),
                Block.makeCuboidShape(7, 0, 6, 9, 6, 10)
        ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

        public static final VoxelShape SHAPE_MALENA_NORTH = Stream.of(
                Block.makeCuboidShape(6, 12, 6, 10, 13, 10),
                Block.makeCuboidShape(5, 11, 5, 11, 12, 11),
                Block.makeCuboidShape(6, 8, 6, 10, 11, 10),
                Block.makeCuboidShape(4, 6, 7, 10, 8, 9),
                Block.makeCuboidShape(6, 0, 7, 10, 6, 9)
        ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

        public static final VoxelShape SHAPE_MALENA_SOUTH = Stream.of(
                Block.makeCuboidShape(6, 12, 6, 10, 13, 10),
                Block.makeCuboidShape(5, 11, 5, 11, 12, 11),
                Block.makeCuboidShape(6, 8, 6, 10, 11, 10),
                Block.makeCuboidShape(6, 6, 7, 12, 8, 9),
                Block.makeCuboidShape(6, 0, 7, 10, 6, 9)
        ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

        public static final VoxelShape SHAPE_MALENA_EAST = Stream.of(
                Block.makeCuboidShape(6, 12, 6, 10, 13, 10),
                Block.makeCuboidShape(5, 11, 5, 11, 12, 11),
                Block.makeCuboidShape(6, 8, 6, 10, 11, 10),
                Block.makeCuboidShape(7, 6, 4, 9, 8, 10),
                Block.makeCuboidShape(7, 0, 6, 9, 6, 10)
        ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

        public static final VoxelShape SHAPE_MALENA_WEST = Stream.of(
                Block.makeCuboidShape(6, 12, 6, 10, 13, 10),
                Block.makeCuboidShape(5, 11, 5, 11, 12, 11),
                Block.makeCuboidShape(6, 8, 6, 10, 11, 10),
                Block.makeCuboidShape(7, 6, 6, 9, 8, 12),
                Block.makeCuboidShape(7, 0, 6, 9, 6, 10)
        ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

        public static final VoxelShape DEFAULT_SHAPE = Block.makeCuboidShape(6, 0, 6, 10, 9, 10);
    }

    public enum Type {
        ALICE_OR_ALAN,
        INNOVATOR,
        TYLER,
        MALENA,
        LEANDRO,
        TEENAGER_ALICE
    }
}
