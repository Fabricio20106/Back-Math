package com.sophicreeper.backmath.core.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class ToyBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    private final ToyType type;

    public ToyBlock(ToyType type) {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).strength(0.5f).sound(SoundType.WOOL).noOcclusion());
        this.type = type;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        ToyType type = this.type;
        if (state.getValue(FACING) == Direction.EAST && type == ToyType.ALICE_OR_ALAN || state.getValue(FACING) == Direction.WEST && type == ToyType.ALICE_OR_ALAN) {
            return ToyShapes.SHAPE_ALAN_OR_ALICE_EW;
        } else if (state.getValue(FACING) == Direction.NORTH && type == ToyType.ALICE_OR_ALAN || state.getValue(FACING) == Direction.SOUTH && type == ToyType.ALICE_OR_ALAN) {
            return ToyShapes.SHAPE_ALAN_OR_ALICE_NS;
        }

        else if (state.getValue(FACING) == Direction.NORTH && type == ToyType.MALENA) {
            return ToyShapes.SHAPE_MALENA_NORTH;
        } else if (state.getValue(FACING) == Direction.SOUTH && type == ToyType.MALENA) {
            return ToyShapes.SHAPE_MALENA_SOUTH;
        } else if (state.getValue(FACING) == Direction.EAST && type == ToyType.MALENA) {
            return ToyShapes.SHAPE_MALENA_EAST;
        } else if (state.getValue(FACING) == Direction.WEST && type == ToyType.MALENA) {
            return ToyShapes.SHAPE_MALENA_WEST;
        }

        else if (state.getValue(FACING) == Direction.EAST && type == ToyType.TYLER || state.getValue(FACING) == Direction.WEST && type == ToyType.TYLER) {
            return ToyShapes.SHAPE_TYLER_EW;
        } else if (state.getValue(FACING) == Direction.NORTH && type == ToyType.TYLER || state.getValue(FACING) == Direction.SOUTH && type == ToyType.TYLER) {
            return ToyShapes.SHAPE_TYLER_NS;
        }

        return ToyShapes.DEFAULT_SHAPE;
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public static class ToyShapes {
        public static final VoxelShape SHAPE_ALAN_OR_ALICE_NS = Stream.of(
                Block.box(6, 6, 6, 10, 9, 10),
                Block.box(9, 2, 7, 10, 6, 9),
                Block.box(6, 2, 7, 7, 6, 9),
                Block.box(7, 3, 7, 9, 6, 9),
                Block.box(7, 0, 7, 9, 3, 9)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        public static final VoxelShape SHAPE_ALAN_OR_ALICE_EW = Stream.of(
                Block.box(6, 6, 6, 10, 9, 10),
                Block.box(7, 2, 6, 9, 6, 7),
                Block.box(7, 2, 9, 9, 6, 10),
                Block.box(7, 3, 7, 9, 6, 9),
                Block.box(7, 0, 7, 9, 3, 9)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        public static final VoxelShape SHAPE_TYLER_NS = Stream.of(
                Block.box(6, 8, 6, 10, 12, 10),
                Block.box(4, 6, 7, 12, 8, 9),
                Block.box(6, 0, 7, 10, 6, 9)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        public static final VoxelShape SHAPE_TYLER_EW = Stream.of(
                Block.box(6, 8, 6, 10, 12, 10),
                Block.box(7, 6, 4, 9, 8, 12),
                Block.box(7, 0, 6, 9, 6, 10)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        public static final VoxelShape SHAPE_MALENA_NORTH = Stream.of(
                Block.box(6, 12, 6, 10, 13, 10),
                Block.box(5, 11, 5, 11, 12, 11),
                Block.box(6, 8, 6, 10, 11, 10),
                Block.box(4, 6, 7, 10, 8, 9),
                Block.box(6, 0, 7, 10, 6, 9)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        public static final VoxelShape SHAPE_MALENA_SOUTH = Stream.of(
                Block.box(6, 12, 6, 10, 13, 10),
                Block.box(5, 11, 5, 11, 12, 11),
                Block.box(6, 8, 6, 10, 11, 10),
                Block.box(6, 6, 7, 12, 8, 9),
                Block.box(6, 0, 7, 10, 6, 9)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        public static final VoxelShape SHAPE_MALENA_EAST = Stream.of(
                Block.box(6, 12, 6, 10, 13, 10),
                Block.box(5, 11, 5, 11, 12, 11),
                Block.box(6, 8, 6, 10, 11, 10),
                Block.box(7, 6, 4, 9, 8, 10),
                Block.box(7, 0, 6, 9, 6, 10)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        public static final VoxelShape SHAPE_MALENA_WEST = Stream.of(
                Block.box(6, 12, 6, 10, 13, 10),
                Block.box(5, 11, 5, 11, 12, 11),
                Block.box(6, 8, 6, 10, 11, 10),
                Block.box(7, 6, 6, 9, 8, 12),
                Block.box(7, 0, 6, 9, 6, 10)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        public static final VoxelShape DEFAULT_SHAPE = Block.box(6.0d, 0.0d, 6.0d, 10.0d, 9.0d, 10.0d);
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
