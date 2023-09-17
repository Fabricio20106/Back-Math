package com.sophicreeper.backmath.core.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class QueenLucyPetRelicBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public QueenLucyPetRelicBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).lightLevel(state -> 5));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case SOUTH -> qspRelicSouth();
            case EAST -> qspRelicEast();
            case WEST -> qspRelicWest();
            default -> qspRelicNorth();
        };
    }

    public VoxelShape qspRelicNorth() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.create(0.125, 0, 0.125, 0.875, 0.0625, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.5, 0.0625, 0.4375, 0.625, 0.4375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.375, 0.0625, 0.4375, 0.5, 0.4375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.375, 0.4375, 0.4375, 0.625, 0.8125, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.3125, 0.4375, 0.4375, 0.375, 0.8125, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.625, 0.4375, 0.4375, 0.6875, 0.8125, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.375, 0.8125, 0.375, 0.625, 1.0625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 1.0625, 0.4375, 0.5625, 1.1875, 0.4375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 1.0625, 0.5625, 0.5625, 1.1875, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 1.0625, 0.4375, 0.4375, 1.1875, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.5625, 1.0625, 0.4375, 0.5625, 1.1875, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.0625, 0.4375, 0.5625, 0.5, 0.8125, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.5, 0.4375, 0.5625, 0.9375, 0.8125, 0.5625), BooleanOp.OR);
        return shape;
    }

    public VoxelShape qspRelicSouth() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.create(0.125, 0, 0.125, 0.875, 0.0625, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.375, 0.0625, 0.4375, 0.5, 0.4375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.5, 0.0625, 0.4375, 0.625, 0.4375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.375, 0.4375, 0.4375, 0.625, 0.8125, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.625, 0.4375, 0.4375, 0.6875, 0.8125, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.3125, 0.4375, 0.4375, 0.375, 0.8125, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.375, 0.8125, 0.375, 0.625, 1.0625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 1.0625, 0.5625, 0.5625, 1.1875, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 1.0625, 0.4375, 0.5625, 1.1875, 0.4375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.5625, 1.0625, 0.4375, 0.5625, 1.1875, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 1.0625, 0.4375, 0.4375, 1.1875, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.5, 0.4375, 0.4375, 0.9375, 0.8125, 0.4375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.0625, 0.4375, 0.4375, 0.5, 0.8125, 0.4375), BooleanOp.OR);
        return shape;
    }

    public VoxelShape qspRelicEast() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.create(0.125, 0, 0.125, 0.875, 0.0625, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 0.0625, 0.5, 0.5625, 0.4375, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 0.0625, 0.375, 0.5625, 0.4375, 0.5), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 0.4375, 0.375, 0.5625, 0.8125, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 0.4375, 0.3125, 0.5625, 0.8125, 0.375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 0.4375, 0.625, 0.5625, 0.8125, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.375, 0.8125, 0.375, 0.625, 1.0625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.5625, 1.0625, 0.4375, 0.5625, 1.1875, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 1.0625, 0.4375, 0.4375, 1.1875, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 1.0625, 0.4375, 0.5625, 1.1875, 0.4375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 1.0625, 0.5625, 0.5625, 1.1875, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 0.4375, 0.0625, 0.4375, 0.8125, 0.5), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 0.4375, 0.5, 0.4375, 0.8125, 0.9375), BooleanOp.OR);
        return shape;
    }

    public VoxelShape qspRelicWest() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.create(0.125, 0, 0.125, 0.875, 0.0625, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 0.0625, 0.375, 0.5625, 0.4375, 0.5), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 0.0625, 0.5, 0.5625, 0.4375, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 0.4375, 0.375, 0.5625, 0.8125, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 0.4375, 0.625, 0.5625, 0.8125, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 0.4375, 0.3125, 0.5625, 0.8125, 0.375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.375, 0.8125, 0.375, 0.625, 1.0625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 1.0625, 0.4375, 0.4375, 1.1875, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.5625, 1.0625, 0.4375, 0.5625, 1.1875, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 1.0625, 0.5625, 0.5625, 1.1875, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.4375, 1.0625, 0.4375, 0.5625, 1.1875, 0.4375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.5625, 0.4375, 0.5, 0.5625, 0.8125, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.5625, 0.4375, 0.0625, 0.5625, 0.8125, 0.5), BooleanOp.OR);
        return shape;
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
