package com.sophicreeper.backmath.block.custom;

import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeHooks;

import java.util.Random;

public class GrapeVinePostBlock extends HorizontalBlock implements IGrowable {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    public static final VoxelShape SHAPE_NS = Block.makeCuboidShape(0.0d, 0.0d, 7.0d, 16.0d, 16.0d, 9.0d);
    public static final VoxelShape SHAPE_EW = Block.makeCuboidShape(7.0d, 0.0d, 0.0d, 9.0d, 16.0d, 16.0d);

    public GrapeVinePostBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(AGE, 0).with(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        if (state.get(FACING) == Direction.NORTH || state.get(FACING) == Direction.SOUTH) {
            return SHAPE_NS;
        } else {
            return SHAPE_EW;
        }
    }

    public boolean ticksRandomly(BlockState state) {
        return state.get(AGE) < 3;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
        int ageState = state.get(AGE);
        if (ageState < 3 && world.getLightSubtracted(pos.up(), 0) >= 9 && ForgeHooks.onCropsGrowPre(world, pos, state, rand.nextInt(5) == 0)) {
            world.setBlockState(pos, state.with(AGE, ageState + 1), 2);
            ForgeHooks.onCropsGrowPost(world, pos, state);
        }
    }

    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        int ageState = state.get(AGE);
        boolean flag = ageState == 3;
        if (!flag && player.getHeldItem(hand).getItem() == Items.BONE_MEAL) {
            return ActionResultType.PASS;
        } else if (ageState > 1) {
            int j = 1 + world.rand.nextInt(2);
            spawnAsEntity(world, pos, new ItemStack(AxolotlTest.GRAPES.get(), j + (flag ? 1 : 0)));
            world.playSound(null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + world.rand.nextFloat() * 0.4F);
            world.setBlockState(pos, state.with(AGE, 1), 2);
            return ActionResultType.func_233537_a_(world.isRemote);
        } else {
            return super.onBlockActivated(state, world, pos, player, hand, hit);
        }
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.with(HORIZONTAL_FACING, rotation.rotate(state.get(HORIZONTAL_FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.toRotation(state.get(HORIZONTAL_FACING)));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AGE, FACING);
    }

    public boolean canGrow(IBlockReader world, BlockPos pos, BlockState state, boolean isClient) {
        return state.get(AGE) < 3;
    }

    public boolean canUseBonemeal(World world, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld world, Random rand, BlockPos pos, BlockState state) {
        int i = Math.min(3, state.get(AGE) + 1);
        world.setBlockState(pos, state.with(AGE, i), 2);
    }
}
