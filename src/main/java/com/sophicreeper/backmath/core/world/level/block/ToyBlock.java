package com.sophicreeper.backmath.core.world.level.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class ToyBlock extends HorizontalBlock {
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    private final ToyType type;

    public ToyBlock(ToyType type) {
        super(AbstractBlock.Properties.create(Material.WOOL).hardnessAndResistance(0.5f).sound(SoundType.CLOTH).notSolid());
        this.type = type;
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        ToyType type = this.type;
        if (state.get(FACING) == Direction.EAST && type == ToyType.ALICE_OR_ALAN || state.get(FACING) == Direction.WEST && type == ToyType.ALICE_OR_ALAN) {
            return ToyShapes.SHAPE_ALAN_OR_ALICE_EW;
        } else if (state.get(FACING) == Direction.NORTH && type == ToyType.ALICE_OR_ALAN || state.get(FACING) == Direction.SOUTH && type == ToyType.ALICE_OR_ALAN) {
            return ToyShapes.SHAPE_ALAN_OR_ALICE_NS;
        }

        else if (state.get(FACING) == Direction.NORTH && type == ToyType.MALENA) {
            return ToyShapes.SHAPE_MALENA_NORTH;
        } else if (state.get(FACING) == Direction.SOUTH && type == ToyType.MALENA) {
            return ToyShapes.SHAPE_MALENA_SOUTH;
        } else if (state.get(FACING) == Direction.EAST && type == ToyType.MALENA) {
            return ToyShapes.SHAPE_MALENA_EAST;
        } else if (state.get(FACING) == Direction.WEST && type == ToyType.MALENA) {
            return ToyShapes.SHAPE_MALENA_WEST;
        }

        else if (state.get(FACING) == Direction.EAST && type == ToyType.TYLER || state.get(FACING) == Direction.WEST && type == ToyType.TYLER) {
            return ToyShapes.SHAPE_TYLER_EW;
        } else if (state.get(FACING) == Direction.NORTH && type == ToyType.TYLER || state.get(FACING) == Direction.SOUTH && type == ToyType.TYLER) {
            return ToyShapes.SHAPE_TYLER_NS;
        }

        //return super.getShape(state, worldIn, pos, context);
        return ToyShapes.DEFAULT_SHAPE;
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

        public static final VoxelShape DEFAULT_SHAPE = Block.makeCuboidShape(6.0d, 0.0d, 6.0d, 10.0d, 9.0d, 10.0d);
    }

    public enum ToyType {
        ALICE_OR_ALAN,
        INNOVATOR,
        TYLER,
        MALENA,
        LEANDRO,
        TEENAGER_ALICE
    }
}
