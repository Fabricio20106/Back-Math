package com.sophicreeper.backmath.block.custom;

import com.sophicreeper.backmath.block.BMBlocks;
import net.minecraft.block.*;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class AljamicDirtPathBlock extends Block {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(0, 0, 0, 16, 15, 16);

    public AljamicDirtPathBlock(Properties builder) {
        super(builder);
    }

    public boolean isTransparent(BlockState state) {
        return true;
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return !this.getDefaultState().isValidPosition(context.getWorld(), context.getPos()) ? Block.nudgeEntitiesWithNewState(this.getDefaultState(), BMBlocks.ALJAMIC_DIRT.get().getDefaultState(), context.getWorld(), context.getPos()) : super.getStateForPlacement(context);
    }

    // Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
    // For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately returns its solidified counterpart.
    // Note that this method should ideally consider only the specific face passed in.
    public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
        if (facing == Direction.UP && !state.isValidPosition(world, currentPos)) {
            world.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
        }

        return super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
    }

    public void tick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
        turnToAljamicDirt(state, world, pos);
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockState aboveBlock = worldIn.getBlockState(pos.up());
        return !aboveBlock.getMaterial().isSolid() || aboveBlock.getBlock() instanceof FenceGateBlock;
    }

    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public boolean allowsMovement(BlockState state, IBlockReader world, BlockPos pos, PathType type) {
        return false;
    }

    public static void turnToAljamicDirt(BlockState state, World worldIn, BlockPos pos) {
        worldIn.setBlockState(pos, nudgeEntitiesWithNewState(state, BMBlocks.ALJAMIC_DIRT.get().getDefaultState(), worldIn, pos));
    }
}
