package com.sophicreeper.backmath.core.world.level.block;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
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

public class QueenSophieRelicBlock extends HorizontalBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    public static final VoxelShape SHAPE_FIRST_HALF = Stream.of(
            Block.makeCuboidShape(1, 0, 1, 15, 2, 15),
            Block.makeCuboidShape(4, 2, 6, 8, 14, 10),
            Block.makeCuboidShape(8, 2, 6, 12, 14, 10),
            Block.makeCuboidShape(4, 14, 6, 12, 16, 10),
            Block.makeCuboidShape(12, 14, 6, 15, 16, 10),
            Block.makeCuboidShape(1, 14, 6, 4, 16, 10)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    public static final VoxelShape SHAPE_SECOND_HALF = Stream.of(
            Block.makeCuboidShape(11, 18, 5, 11, 22, 11),
            Block.makeCuboidShape(5, 18, 5, 5, 22, 11),
            Block.makeCuboidShape(5, 18, 11, 11, 22, 11),
            Block.makeCuboidShape(5, 18, 5, 11, 22, 5),
            Block.makeCuboidShape(4, 10, 4, 12, 18, 12),
            Block.makeCuboidShape(4, 0, 6, 12, 10, 10),
            Block.makeCuboidShape(1, 0, 6, 4, 10, 10),
            Block.makeCuboidShape(12, 0, 6, 15, 10, 10)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    public QueenSophieRelicBlock() {
        super(AbstractBlock.Properties.from(Blocks.GOLD_BLOCK).harvestLevel(2).setLightLevel(state -> 10));
        this.setDefaultState(this.stateContainer.getBaseState().with(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        if (state.get(HALF) == DoubleBlockHalf.LOWER) {
            return SHAPE_FIRST_HALF;
        } else {
            return SHAPE_SECOND_HALF;
        }
    }

    public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
        DoubleBlockHalf halfState = state.get(HALF);
        if (facing.getAxis() != Direction.Axis.Y || halfState == DoubleBlockHalf.LOWER != (facing == Direction.UP) || facingState.isIn(this) && facingState.get(HALF) != halfState) {
            return halfState == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.isValidPosition(world, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
        } else {
            return Blocks.AIR.getDefaultState();
        }
    }

    public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        world.setBlockState(pos.up(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER), 3);
    }

    public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
        if (state.get(HALF) != DoubleBlockHalf.UPPER) {
            return super.isValidPosition(state, world, pos);
        } else {
            BlockState belowState = world.getBlockState(pos.down());
            if (state.getBlock() != this)
                return super.isValidPosition(state, world, pos); //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
            return belowState.isIn(this) && belowState.get(HALF) == DoubleBlockHalf.LOWER;
        }
    }

    /**
     * Called before the Block is set to air in the world. Called regardless of if the player's tool can actually collect
     * this block
     */
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

    /**
     * Spawns the block's drops in the world. By the time this is called the Block has possibly been set to air via
     * Block.removedByPlayer
     */
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

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HALF);
    }
}
