package com.sophicreeper.backmath.block.custom;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.world.dimension.BMDimensions;
import com.sophicreeper.backmath.world.dimension.TheAljanTeleporter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
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

@SuppressWarnings("deprecation")
public class AljanPortalStandBlock extends Block implements IWaterLoggable {
    public static final BooleanProperty JANTICAL = BMBlockStateProperties.JANTICAL;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final VoxelShape WITHOUT_JANTICAL = Stream.of(Block.box(4, 0, 4, 12, 1, 12), Block.box(5, 1, 5, 11, 2, 11), Block.box(6, 2, 6, 10, 10, 10), Block.box(3, 11, 3, 13, 16, 13), Block.box(5, 10, 5, 11, 11, 11), Block.box(3, 16, 5, 4, 18, 11), Block.box(12, 16, 5, 13, 18, 11), Block.box(5, 16, 3, 11, 18, 4), Block.box(5, 16, 12, 11, 18, 13)).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    public static final VoxelShape WITH_JANTICAL = Stream.of(Block.box(4, 0, 4, 12, 1, 12), Block.box(5, 1, 5, 11, 2, 11), Block.box(6, 2, 6, 10, 10, 10), Block.box(3, 11, 3, 13, 16, 13), Block.box(5, 10, 5, 11, 11, 11), Block.box(3, 16, 5, 4, 18, 11), Block.box(12, 16, 5, 13, 18, 11), Block.box(5, 16, 3, 11, 18, 4), Block.box(5, 16, 12, 11, 18, 13), Block.box(4, 16, 4, 12, 19, 12)).reduce((shape1, shape2) -> VoxelShapes.join(shape1, shape2, IBooleanFunction.OR)).get();

    public AljanPortalStandBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(JANTICAL, false).setValue(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        if (state.getValue(JANTICAL)) return WITH_JANTICAL;
        else return WITHOUT_JANTICAL;
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if (state.getValue(JANTICAL) && BMConfigs.COMMON_CONFIGS.aljanEnabledThroughStand.get()) {
            if (!world.isClientSide) {
                if (!player.isCrouching()) {
                    MinecraftServer server = world.getServer();

                    if (server != null) {
                        if (world.dimension() == BMDimensions.THE_ALJAN) {
                            ServerWorld overworld = server.getLevel(World.OVERWORLD);
                            if (overworld != null) player.changeDimension(overworld, new TheAljanTeleporter(pos, false));
                        } else {
                            ServerWorld theAljan = server.getLevel(BMDimensions.THE_ALJAN);
                            if (theAljan != null) player.changeDimension(theAljan, new TheAljanTeleporter(pos, true));
                        }
                        return ActionResultType.SUCCESS;
                    }
                }
            }
        }

        return super.use(state, world, pos, player, hand, hit);
    }

    @Override
    public void entityInside(BlockState state, World world, BlockPos pos, Entity entity) {
        if (BMConfigs.COMMON_CONFIGS.standingAljanTeleport.get() && BMConfigs.COMMON_CONFIGS.aljanEnabledThroughStand.get()) {
            if (state.getValue(JANTICAL)) {
                if (!world.isClientSide) {
                    MinecraftServer server = world.getServer();

                    if (server != null) {
                        if (world.dimension() == BMDimensions.THE_ALJAN) {
                            ServerWorld overworld = server.getLevel(World.OVERWORLD);
                            if (overworld != null) entity.changeDimension(overworld, new TheAljanTeleporter(pos, false));
                        } else {
                            ServerWorld theAljan = server.getLevel(BMDimensions.THE_ALJAN);
                            if (theAljan != null) entity.changeDimension(theAljan, new TheAljanTeleporter(pos, true));
                        }
                    }
                }
            }
        }

        super.entityInside(state, world, pos, entity);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) world.getLiquidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(WATERLOGGED, fluidState.is(FluidTags.WATER) && fluidState.getAmount() == 8);
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, World world, BlockPos pos) {
        return state.getValue(JANTICAL) ? 15 : 0;
    }

    @Override
    public boolean isPathfindable(BlockState state, IBlockReader reader, BlockPos pos, PathType type) {
        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(JANTICAL, WATERLOGGED);
    }
}
