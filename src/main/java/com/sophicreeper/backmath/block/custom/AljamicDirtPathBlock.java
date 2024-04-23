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
    protected static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 15, 16);

    public AljamicDirtPathBlock(Properties properties) {
        super(properties);
    }

    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return !this.defaultBlockState().canSurvive(context.getLevel(), context.getClickedPos()) ? Block.pushEntitiesUp(this.defaultBlockState(), BMBlocks.ALJAMIC_DIRT.get().defaultBlockState(), context.getLevel(), context.getClickedPos()) : super.getStateForPlacement(context);
    }

    // Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
    // For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately returns its solidified counterpart.
    // Note that this method should ideally consider only the specific face passed in.
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
        if (facing == Direction.UP && !state.canSurvive(world, currentPos)) {
            world.getBlockTicks().scheduleTick(currentPos, this, 1);
        }

        return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }

    public void tick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
        turnToAljamicDirt(state, world, pos);
    }

    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockState aboveBlock = worldIn.getBlockState(pos.above());
        return !aboveBlock.getMaterial().isSolid() || aboveBlock.getBlock() instanceof FenceGateBlock;
    }

    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public boolean isPathfindable(BlockState state, IBlockReader world, BlockPos pos, PathType type) {
        return false;
    }

    public static void turnToAljamicDirt(BlockState state, World worldIn, BlockPos pos) {
        worldIn.setBlockAndUpdate(pos, pushEntitiesUp(state, BMBlocks.ALJAMIC_DIRT.get().defaultBlockState(), worldIn, pos));
    }
}
