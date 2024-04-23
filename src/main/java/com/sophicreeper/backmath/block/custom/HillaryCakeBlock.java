package com.sophicreeper.backmath.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class HillaryCakeBlock extends Block {
    public static final IntegerProperty BITES = BlockStateProperties.BITES;
    protected static final VoxelShape[] SHAPES = new VoxelShape[] {
            Block.box(1, 0, 1, 15, 8, 15),
            Block.box(3, 0, 1, 15, 8, 15),
            Block.box(5, 0, 1, 15, 8, 15),
            Block.box(7, 0, 1, 15, 8, 15),
            Block.box(9, 0, 1, 15, 8, 15),
            Block.box(11, 0, 1, 15, 8, 15),
            Block.box(13, 0, 1, 15, 8, 15)};

    public HillaryCakeBlock(AbstractBlock.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BITES, 0));
    }

    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        return SHAPES[state.getValue(BITES)];
    }

    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if (world.isClientSide) {
            ItemStack heldItem = player.getItemInHand(hand);
            if (this.eatSlice(world, pos, state, player).consumesAction()) {
                return ActionResultType.SUCCESS;
            }

            if (heldItem.isEmpty()) {
                return ActionResultType.CONSUME;
            }
        }

        return this.eatSlice(world, pos, state, player);
    }

    private ActionResultType eatSlice(IWorld world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.canEat(false)) {
            return ActionResultType.PASS;
        } else {
            player.awardStat(Stats.EAT_CAKE_SLICE);
            player.getFoodData().eat(4, 0.3F);
            int bitesState = state.getValue(BITES);
            if (bitesState < 6) {
                world.setBlock(pos, state.setValue(BITES, bitesState + 1), 3);
            } else {
                world.removeBlock(pos, false);
            }

            return ActionResultType.SUCCESS;
        }
    }

    /**
     * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
     * returns its solidified counterpart.
     * Note that this method should ideally consider only the specific face passed in.
     */
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !state.canSurvive(world, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }

    public boolean canSurvive(BlockState state, IWorldReader world, BlockPos pos) {
        return world.getBlockState(pos.below()).getMaterial().isSolid();
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BITES);
    }

    public int getAnalogOutputSignal(BlockState state, World world, BlockPos pos) {
        return (7 - state.getValue(BITES)) * 2;
    }

    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    public boolean isPathfindable(BlockState state, IBlockReader world, BlockPos pos, PathType type) {
        return false;
    }
}
