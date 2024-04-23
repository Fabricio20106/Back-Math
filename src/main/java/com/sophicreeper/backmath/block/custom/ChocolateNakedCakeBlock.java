package com.sophicreeper.backmath.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class ChocolateNakedCakeBlock extends Block {
    public ChocolateNakedCakeBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        return makeShape();
    }

    public VoxelShape makeShape(){
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.0625, 0, 0.0625, 0.9375, 0.75, 0.9375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.05625, 0.125, 0.05625, 0.94375, 0.25, 0.94375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.125, 0.75, 0.125, 0.875, 0.875, 0.875), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.1875, 0.75, 0.1875, 0.8125, 0.88125, 0.8125), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.05625, 0.4375, 0.05625, 0.94375, 0.5625, 0.94375), IBooleanFunction.OR);

        return shape;
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult) {
        if (world.isClientSide) {
            ItemStack heldItem = player.getItemInHand(hand);
            if (this.eatWholeCake(world, pos, player).consumesAction()) {
                return ActionResultType.SUCCESS;
            }
            if (heldItem.isEmpty()) {
                return ActionResultType.CONSUME;
            }
        }
        return this.eatWholeCake(world, pos, player);
    }

    public ActionResultType eatWholeCake(IWorld world, BlockPos pos, PlayerEntity player) {
        if (!player.canEat(false)) {
            return ActionResultType.PASS;
        } else {
            player.awardStat(Stats.EAT_CAKE_SLICE);
            player.getFoodData().eat(35, 4.2F);
            world.removeBlock(pos, false);
        }

        return ActionResultType.SUCCESS;
    }

    // Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
    // For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately returns its solidified counterpart.
    // Note that this method should ideally consider only the specific face passed in.
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !state.canSurvive(world, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }

    public boolean canSurvive(BlockState state, IWorldReader world, BlockPos pos) {
        return world.getBlockState(pos.below()).getMaterial().isSolid();
    }

    public boolean isPathfindable(BlockState state, IBlockReader world, BlockPos pos, PathType type) {
        return false;
    }
}
