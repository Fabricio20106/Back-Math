package com.sophicreeper.backmath.core.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.stream.Stream;

import static net.minecraft.world.level.block.DoublePlantBlock.copyWaterloggedFrom;

public class QueenLucyRelicBlock extends HorizontalDirectionalBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static final VoxelShape SHAPE_FIRST_HALF_NS = Stream.of(
            Block.box(1, 0, 1, 15, 2, 15),
            Block.box(4, 2, 6, 8, 14, 10),
            Block.box(8, 2, 6, 12, 14, 10),
            Block.box(4, 14, 6, 12, 16, 10),
            Block.box(12, 14, 6, 15, 16, 10),
            Block.box(1, 14, 6, 4, 16, 10)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public VoxelShape shapeFirstHalfEW() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.create(0.0625, 0, 0.0625, 0.9375, 0.125, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.375, 0.125, 0.5, 0.625, 0.875, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.375, 0.125, 0.25, 0.625, 0.875, 0.5), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.375, 0.875, 0.25, 0.625, 1, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.375, 0.875, 0.0625, 0.625, 1, 0.25), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.375, 0.875, 0.75, 0.625, 1, 0.9375), BooleanOp.OR);

        return shape;
    }

    public static final VoxelShape SHAPE_SECOND_HALF_NS = Stream.of(
            Block.box(11, 18, 5, 11, 22, 11),
            Block.box(5, 18, 5, 5, 22, 11),
            Block.box(5, 18, 11, 11, 22, 11),
            Block.box(5, 18, 5, 11, 22, 5),
            Block.box(4, 10, 4, 12, 18, 12),
            Block.box(4, 0, 6, 12, 10, 10),
            Block.box(1, 0, 6, 4, 10, 10),
            Block.box(12, 0, 6, 15, 10, 10)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public VoxelShape shapeSecondHalfEW(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.create(0.375, 0, 0.0625, 0.625, 0.625, 0.25), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.375, 0, 0.75, 0.625, 0.625, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.375, 0, 0.25, 0.625, 0.625, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.25, 0.625, 0.25, 0.75, 1.125, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.3125, 1.125, 0.3125, 0.3125, 1.375, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.6875, 1.125, 0.3125, 0.6875, 1.375, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.3125, 1.125, 0.6875, 0.6875, 1.375, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.3125, 1.125, 0.3125, 0.6875, 1.375, 0.3125), BooleanOp.OR);

        return shape;
    }

    public QueenLucyRelicBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).lightLevel(state -> 10));
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        boolean facingNS = state.getValue(FACING) == Direction.NORTH || state.getValue(FACING) == Direction.SOUTH;
        boolean facingEW = state.getValue(FACING) == Direction.EAST || state.getValue(FACING) == Direction.WEST;
        boolean lowerHalf = state.getValue(HALF) == DoubleBlockHalf.LOWER;
        boolean upperHalf = state.getValue(HALF) == DoubleBlockHalf.UPPER;

        if (lowerHalf && facingNS) {
            return SHAPE_FIRST_HALF_NS;
        } else if (upperHalf && facingNS) {
            return SHAPE_SECOND_HALF_NS;
        } else if (lowerHalf && facingEW) {
            return shapeFirstHalfEW();
        } else if (upperHalf && facingEW) {
            return shapeSecondHalfEW();
        } else {
            return SHAPE_FIRST_HALF_NS;
        }
    }

    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        DoubleBlockHalf halfState = state.getValue(HALF);
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }

        if (facing.getAxis() != Direction.Axis.Y || halfState == DoubleBlockHalf.LOWER != (facing == Direction.UP) || facingState.is(this) && facingState.getValue(HALF) != halfState) {
            return halfState == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.canSurvive(world, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, world, currentPos, facingPos);
        } else {
            return Blocks.AIR.defaultBlockState();
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        Level world = context.getLevel();
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
        boolean isAtMaxHeight = pos.getY() < world.getMaxBuildHeight() - 1 && world.getBlockState(pos.above()).canBeReplaced(context);

        return isAtMaxHeight ? super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, fluidState.is(FluidTags.WATER) && fluidState.getAmount() == 8) :
                this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, fluidState.is(FluidTags.WATER) && fluidState.getAmount() == 8);
    }

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity livEntity, ItemStack stack) {
        BlockPos abovePos = pos.above();
        world.setBlock(abovePos, copyWaterloggedFrom(world, abovePos, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER).setValue(FACING, state.getValue(FACING))), 3);
    }

    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
            return super.canSurvive(state, world, pos);
        } else {
            BlockState belowState = world.getBlockState(pos.below());
            if (state.getBlock() != this)
                // Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
                return super.canSurvive(state, world, pos);
            return belowState.is(this) && belowState.getValue(HALF) == DoubleBlockHalf.LOWER && belowState.getValue(FACING) != this.defaultBlockState().getValue(FACING);
        }
    }

    // Called before the Block is set to air in the world. Called regardless of if the player's tool can actually collect this block.
    public void playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {
        if (!world.isClientSide) {
            if (player.isCreative()) {
                preventCreativeDropFromBottomPart(world, pos, state, player);
            } else {
                dropResources(state, world, pos, null, player, player.getMainHandItem());
            }
        }

        super.playerWillDestroy(world, pos, state, player);
    }

    // Spawns the block's drops in the world. By the time this is called the Block has possibly been set to air via Block.removedByPlayer.
    public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        super.playerDestroy(world, player, pos, Blocks.AIR.defaultBlockState(), blockEntity, stack);
    }

    protected static void preventCreativeDropFromBottomPart(Level world, BlockPos pos, BlockState state, Player player) {
        DoubleBlockHalf halfState = state.getValue(HALF);
        if (halfState == DoubleBlockHalf.UPPER) {
            BlockPos belowPos = pos.below();
            BlockState belowState = world.getBlockState(belowPos);
            if (belowState.getBlock() == state.getBlock() && belowState.getValue(HALF) == DoubleBlockHalf.LOWER) {
                world.setBlock(belowPos, Blocks.AIR.defaultBlockState(), 35);
                world.levelEvent(player, 2001, belowPos, Block.getId(belowState));
            }
        }
    }

    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HALF, FACING, WATERLOGGED);
    }
}
