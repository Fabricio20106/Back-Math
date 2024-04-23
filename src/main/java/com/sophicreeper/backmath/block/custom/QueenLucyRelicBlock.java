package com.sophicreeper.backmath.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class QueenLucyRelicBlock extends HorizontalBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    public static final VoxelShape SHAPE_FIRST_HALF_NS = Stream.of(
            Block.box(1, 0, 1, 15, 2, 15),
            Block.box(4, 2, 6, 8, 14, 10),
            Block.box(8, 2, 6, 12, 14, 10),
            Block.box(4, 14, 6, 12, 16, 10),
            Block.box(12, 14, 6, 15, 16, 10),
            Block.box(1, 14, 6, 4, 16, 10)).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public VoxelShape shapeFirstHalfEW() {
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.0625, 0, 0.0625, 0.9375, 0.125, 0.9375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.375, 0.125, 0.5, 0.625, 0.875, 0.75), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.375, 0.125, 0.25, 0.625, 0.875, 0.5), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.375, 0.875, 0.25, 0.625, 1, 0.75), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.375, 0.875, 0.0625, 0.625, 1, 0.25), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.375, 0.875, 0.75, 0.625, 1, 0.9375), IBooleanFunction.OR);
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
            Block.box(12, 0, 6, 15, 10, 10)).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public VoxelShape shapeSecondHalfEW(){
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.375, 0, 0.0625, 0.625, 0.625, 0.25), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.375, 0, 0.75, 0.625, 0.625, 0.9375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.375, 0, 0.25, 0.625, 0.625, 0.75), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.25, 0.625, 0.25, 0.75, 1.125, 0.75), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.3125, 1.125, 0.3125, 0.3125, 1.375, 0.6875), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.6875, 1.125, 0.3125, 0.6875, 1.375, 0.6875), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.3125, 1.125, 0.6875, 0.6875, 1.375, 0.6875), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.3125, 1.125, 0.3125, 0.6875, 1.375, 0.3125), IBooleanFunction.OR);
        return shape;
    }

    public QueenLucyRelicBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
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

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
        DoubleBlockHalf halfState = state.getValue(HALF);
        if (state.getValue(WATERLOGGED)) {
            world.getLiquidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }

        if (facing.getAxis() != Direction.Axis.Y || halfState == DoubleBlockHalf.LOWER != (facing == Direction.UP) || facingState.is(this) && facingState.getValue(HALF) != halfState) {
            return halfState == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.canSurvive(world, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, world, currentPos, facingPos);
        } else {
            return Blocks.AIR.defaultBlockState();
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos pos = context.getClickedPos();
        World world = context.getLevel();
        FluidState state = world.getFluidState(pos);
        boolean isAtMaxHeight = pos.getY() < 256 - 1 && world.getBlockState(pos.above()).canBeReplaced(context);

        return isAtMaxHeight ? super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, state.is(FluidTags.WATER) && state.getAmount() == 8) :
                this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, state.is(FluidTags.WATER) && state.getAmount() == 8);
    }

    @Override
    public void setPlacedBy(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        world.setBlock(pos.above(), copyWaterloggedFrom(world, pos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER).setValue(FACING, state.getValue(FACING))), 3);
    }

    public static BlockState copyWaterloggedFrom(IWorldReader world, BlockPos pos, BlockState state) {
        return state.hasProperty(WATERLOGGED) ? state.setValue(WATERLOGGED, world.isWaterAt(pos)) : state;
    }

    @Override
    public boolean canSurvive(BlockState state, IWorldReader world, BlockPos pos) {
        if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
            return super.canSurvive(state, world, pos);
        } else {
            BlockState belowState = world.getBlockState(pos.below());
            if (state.getBlock() != this) return super.canSurvive(state, world, pos); // Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
            return belowState.is(this) && belowState.getValue(HALF) == DoubleBlockHalf.LOWER;
        }
    }

    // Called before the Block is set to air in the world. Called regardless of if the player's tool can actually collect this block.
    @Override
    public void playerWillDestroy(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClientSide) {
            if (player.isCreative()) {
                removeBottomHalf(world, pos, state, player);
            } else {
                dropResources(state, world, pos, null, player, player.getMainHandItem());
            }
        }

        super.playerWillDestroy(world, pos, state, player);
    }

    // Spawns the block's drops in the world. By the time this is called the Block has possibly been set to air via Block.removedByPlayer.
    @Override
    public void playerDestroy(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable TileEntity blockEntity, ItemStack stack) {
        super.playerDestroy(world, player, pos, Blocks.AIR.defaultBlockState(), blockEntity, stack);
    }

    protected static void removeBottomHalf(World world, BlockPos pos, BlockState state, PlayerEntity player) {
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

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, HALF, WATERLOGGED);
    }
}
