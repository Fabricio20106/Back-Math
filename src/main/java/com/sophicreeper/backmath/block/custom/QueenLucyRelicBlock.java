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
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    public static final VoxelShape SHAPE_FIRST_HALF_NS = Stream.of(
            Block.makeCuboidShape(1, 0, 1, 15, 2, 15),
            Block.makeCuboidShape(4, 2, 6, 8, 14, 10),
            Block.makeCuboidShape(8, 2, 6, 12, 14, 10),
            Block.makeCuboidShape(4, 14, 6, 12, 16, 10),
            Block.makeCuboidShape(12, 14, 6, 15, 16, 10),
            Block.makeCuboidShape(1, 14, 6, 4, 16, 10)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    public VoxelShape shapeFirstHalfEW() {
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.0625, 0, 0.0625, 0.9375, 0.125, 0.9375), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.375, 0.125, 0.5, 0.625, 0.875, 0.75), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.375, 0.125, 0.25, 0.625, 0.875, 0.5), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.375, 0.875, 0.25, 0.625, 1, 0.75), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.375, 0.875, 0.0625, 0.625, 1, 0.25), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.375, 0.875, 0.75, 0.625, 1, 0.9375), IBooleanFunction.OR);
        return shape;
    }

    public static final VoxelShape SHAPE_SECOND_HALF_NS = Stream.of(
            Block.makeCuboidShape(11, 18, 5, 11, 22, 11),
            Block.makeCuboidShape(5, 18, 5, 5, 22, 11),
            Block.makeCuboidShape(5, 18, 11, 11, 22, 11),
            Block.makeCuboidShape(5, 18, 5, 11, 22, 5),
            Block.makeCuboidShape(4, 10, 4, 12, 18, 12),
            Block.makeCuboidShape(4, 0, 6, 12, 10, 10),
            Block.makeCuboidShape(1, 0, 6, 4, 10, 10),
            Block.makeCuboidShape(12, 0, 6, 15, 10, 10)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    public VoxelShape shapeSecondHalfEW(){
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.375, 0, 0.0625, 0.625, 0.625, 0.25), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.375, 0, 0.75, 0.625, 0.625, 0.9375), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.375, 0, 0.25, 0.625, 0.625, 0.75), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.25, 0.625, 0.25, 0.75, 1.125, 0.75), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.3125, 1.125, 0.3125, 0.3125, 1.375, 0.6875), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.6875, 1.125, 0.3125, 0.6875, 1.375, 0.6875), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.3125, 1.125, 0.6875, 0.6875, 1.375, 0.6875), IBooleanFunction.OR);
        shape = VoxelShapes.combineAndSimplify(shape, VoxelShapes.create(0.3125, 1.125, 0.3125, 0.6875, 1.375, 0.3125), IBooleanFunction.OR);
        return shape;
    }

    public QueenLucyRelicBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(HALF, DoubleBlockHalf.LOWER).with(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        boolean facingNS = state.get(FACING) == Direction.NORTH || state.get(FACING) == Direction.SOUTH;
        boolean facingEW = state.get(FACING) == Direction.EAST || state.get(FACING) == Direction.WEST;
        boolean lowerHalf = state.get(HALF) == DoubleBlockHalf.LOWER;
        boolean upperHalf = state.get(HALF) == DoubleBlockHalf.UPPER;

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
    public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
        DoubleBlockHalf halfState = state.get(HALF);
        if (state.get(WATERLOGGED)) {
            world.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        if (facing.getAxis() != Direction.Axis.Y || halfState == DoubleBlockHalf.LOWER != (facing == Direction.UP) || facingState.isIn(this) && facingState.get(HALF) != halfState) {
            return halfState == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.isValidPosition(world, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
        } else {
            return Blocks.AIR.getDefaultState();
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos pos = context.getPos();
        World world = context.getWorld();
        FluidState state = world.getFluidState(pos);
        boolean isAtMaxHeight = pos.getY() < 256 - 1 && world.getBlockState(pos.up()).isReplaceable(context);

        return isAtMaxHeight ? super.getStateForPlacement(context).with(FACING, context.getPlacementHorizontalFacing().getOpposite()).with(WATERLOGGED, state.isTagged(FluidTags.WATER) && state.getLevel() == 8) :
                this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite()).with(WATERLOGGED, state.isTagged(FluidTags.WATER) && state.getLevel() == 8);
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        world.setBlockState(pos.up(), copyWaterloggedFrom(world, pos.up(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER).with(FACING, state.get(FACING))), 3);
    }

    public static BlockState copyWaterloggedFrom(IWorldReader world, BlockPos pos, BlockState state) {
        return state.hasProperty(WATERLOGGED) ? state.with(WATERLOGGED, world.hasWater(pos)) : state;
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
        if (state.get(HALF) != DoubleBlockHalf.UPPER) {
            return super.isValidPosition(state, world, pos);
        } else {
            BlockState belowState = world.getBlockState(pos.down());
            if (state.getBlock() != this) return super.isValidPosition(state, world, pos); // Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
            return belowState.isIn(this) && belowState.get(HALF) == DoubleBlockHalf.LOWER;
        }
    }

    // Called before the Block is set to air in the world. Called regardless of if the player's tool can actually collect this block.
    @Override
    public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isRemote) {
            if (player.isCreative()) {
                removeBottomHalf(world, pos, state, player);
            } else {
                spawnDrops(state, world, pos, null, player, player.getHeldItemMainhand());
            }
        }

        super.onBlockHarvested(world, pos, state, player);
    }

    // Spawns the block's drops in the world. By the time this is called the Block has possibly been set to air via Block.removedByPlayer.
    @Override
    public void harvestBlock(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable TileEntity blockEntity, ItemStack stack) {
        super.harvestBlock(world, player, pos, Blocks.AIR.getDefaultState(), blockEntity, stack);
    }

    protected static void removeBottomHalf(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        DoubleBlockHalf halfState = state.get(HALF);
        if (halfState == DoubleBlockHalf.UPPER) {
            BlockPos belowPos = pos.down();
            BlockState belowState = world.getBlockState(belowPos);
            if (belowState.getBlock() == state.getBlock() && belowState.get(HALF) == DoubleBlockHalf.LOWER) {
                world.setBlockState(belowPos, Blocks.AIR.getDefaultState(), 35);
                world.playEvent(player, 2001, belowPos, Block.getStateId(belowState));
            }
        }
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, HALF, WATERLOGGED);
    }
}
