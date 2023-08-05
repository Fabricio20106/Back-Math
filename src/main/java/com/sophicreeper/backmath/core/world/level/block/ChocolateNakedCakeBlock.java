package com.sophicreeper.backmath.core.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ChocolateNakedCakeBlock extends Block {
    public ChocolateNakedCakeBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return makeShape();
    }

    public VoxelShape makeShape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.create(0.0625, 0, 0.0625, 0.9375, 0.75, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.05625, 0.125, 0.05625, 0.94375, 0.25, 0.94375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.125, 0.75, 0.125, 0.875, 0.875, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.1875, 0.75, 0.1875, 0.8125, 0.88125, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.create(0.05625, 0.4375, 0.05625, 0.94375, 0.5625, 0.94375), BooleanOp.OR);

        return shape;
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult rayTraceResult) {
        if (world.isClientSide) {
            ItemStack heldItem = player.getItemInHand(hand);
            if (this.eatWholeCake(world, pos, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }
            if (heldItem.isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }
        return this.eatWholeCake(world, pos, player);
    }

    public InteractionResult eatWholeCake(LevelAccessor world, BlockPos pos, Player player) {
        if (!player.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            player.awardStat(Stats.EAT_CAKE_SLICE);
            player.getFoodData().eat(35, 4.2f);
            world.removeBlock(pos, false);
        }

        return InteractionResult.SUCCESS;
    }

    /**
     * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
     * returns its solidified counterpart.
     * Note that this method should ideally consider only the specific face passed in.
     */
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !state.canSurvive(world, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }

    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return world.getBlockState(pos.below()).isSolid();
    }

    public boolean isPathfindable(BlockState state, BlockGetter world, BlockPos pos, PathComputationType type) {
        return false;
    }
}
