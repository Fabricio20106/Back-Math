package com.sophicreeper.backmath.core.world.level.block;

import com.sophicreeper.backmath.core.world.dimension.BMDimensions;
import com.sophicreeper.backmath.core.world.dimension.TheAljanTeleporter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.server.MinecraftServer;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
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
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class AljanPortalStandBlock extends Block implements IWaterLoggable {
    public static final BooleanProperty JANTICAL = BMBlockStateProperties.JANTICAL;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final VoxelShape SHAPE_WITHOUT_JANTICAL = Stream.of(Block.makeCuboidShape(4, 0, 4, 12, 1, 12), Block.makeCuboidShape(5, 1, 5, 11, 2, 11), Block.makeCuboidShape(6, 2, 6, 10, 10, 10), Block.makeCuboidShape(3, 11, 3, 13, 16, 13), Block.makeCuboidShape(5, 10, 5, 11, 11, 11), Block.makeCuboidShape(3, 16, 5, 4, 18, 11), Block.makeCuboidShape(12, 16, 5, 13, 18, 11), Block.makeCuboidShape(5, 16, 3, 11, 18, 4), Block.makeCuboidShape(5, 16, 12, 11, 18, 13)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
    public static final VoxelShape SHAPE_WITH_JANTICAL = Stream.of(Block.makeCuboidShape(4, 0, 4, 12, 1, 12), Block.makeCuboidShape(5, 1, 5, 11, 2, 11), Block.makeCuboidShape(6, 2, 6, 10, 10, 10), Block.makeCuboidShape(3, 11, 3, 13, 16, 13), Block.makeCuboidShape(5, 10, 5, 11, 11, 11), Block.makeCuboidShape(3, 16, 5, 4, 18, 11), Block.makeCuboidShape(12, 16, 5, 13, 18, 11), Block.makeCuboidShape(5, 16, 3, 11, 18, 4), Block.makeCuboidShape(5, 16, 12, 11, 18, 13), Block.makeCuboidShape(4, 16, 4, 12, 19, 12)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    public AljanPortalStandBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(JANTICAL, false).with(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        if (state.get(JANTICAL)) {
            return SHAPE_WITH_JANTICAL;
        } else {
            return SHAPE_WITHOUT_JANTICAL;
        }
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if (state.get(JANTICAL)) {
            if (!world.isRemote()) {
                if (!player.isCrouching()) {
                    MinecraftServer server = world.getServer();

                    if (server != null) {
                        if (world.getDimensionKey() == BMDimensions.THE_ALJAN) {
                            ServerWorld overworld = server.getWorld(World.OVERWORLD);
                            if (overworld != null) {
                                player.changeDimension(overworld, new TheAljanTeleporter(pos, false));
                            }
                        } else {
                            ServerWorld theAljan = server.getWorld(BMDimensions.THE_ALJAN);
                            if (theAljan != null) {
                                player.changeDimension(theAljan, new TheAljanTeleporter(pos, true));
                            }
                        }
                        return ActionResultType.SUCCESS;
                    }
                }
            }
        }

        return super.onBlockActivated(state, world, pos, player, hand, hit);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
    }

    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
        if (state.get(WATERLOGGED)) {
            world.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        FluidState fluidState = context.getWorld().getFluidState(context.getPos());
        return this.getDefaultState().with(WATERLOGGED, fluidState.isTagged(FluidTags.WATER) && fluidState.getLevel() == 8);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(JANTICAL, WATERLOGGED);
    }
}
