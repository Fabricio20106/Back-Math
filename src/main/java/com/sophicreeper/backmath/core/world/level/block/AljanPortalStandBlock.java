package com.sophicreeper.backmath.core.world.level.block;

import com.sophicreeper.backmath.core.config.BMConfigs;
import com.sophicreeper.backmath.core.world.dimension.BMDimensions;
import com.sophicreeper.backmath.core.world.dimension.TheAljanTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class AljanPortalStandBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty JANTICAL = BMBlockStateProperties.JANTICAL;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final VoxelShape SHAPE_WITHOUT_JANTICAL = Stream.of(Block.box(4, 0, 4, 12, 1, 12), Block.box(5, 1, 5, 11, 2, 11), Block.box(6, 2, 6, 10, 10, 10), Block.box(3, 11, 3, 13, 16, 13), Block.box(5, 10, 5, 11, 11, 11), Block.box(3, 16, 5, 4, 18, 11), Block.box(12, 16, 5, 13, 18, 11), Block.box(5, 16, 3, 11, 18, 4), Block.box(5, 16, 12, 11, 18, 13)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape SHAPE_WITH_JANTICAL = Stream.of(Block.box(4, 0, 4, 12, 1, 12), Block.box(5, 1, 5, 11, 2, 11), Block.box(6, 2, 6, 10, 10, 10), Block.box(3, 11, 3, 13, 16, 13), Block.box(5, 10, 5, 11, 11, 11), Block.box(3, 16, 5, 4, 18, 11), Block.box(12, 16, 5, 13, 18, 11), Block.box(5, 16, 3, 11, 18, 4), Block.box(5, 16, 12, 11, 18, 13), Block.box(4, 16, 4, 12, 19, 12)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public AljanPortalStandBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(JANTICAL, false).setValue(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        if (state.getValue(JANTICAL)) {
            return SHAPE_WITH_JANTICAL;
        } else {
            return SHAPE_WITHOUT_JANTICAL;
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (state.getValue(JANTICAL)) {
            if (!world.isClientSide()) {
                if (!player.isCrouching()) {
                    MinecraftServer server = world.getServer();

                    if (server != null) {
                        if (world.dimension() == BMDimensions.THE_ALJAN) {
                            ServerLevel overworld = server.getLevel(Level.OVERWORLD);
                            if (overworld != null) {
                                player.changeDimension(overworld, new TheAljanTeleporter(pos, false));
                            }
                        } else {
                            ServerLevel theAljan = server.getLevel(BMDimensions.THE_ALJAN);
                            if (theAljan != null) {
                                player.changeDimension(theAljan, new TheAljanTeleporter(pos, true));
                            }
                        }
                        return InteractionResult.SUCCESS;
                    }
                }
            }
        }

        return super.use(state, world, pos, player, hand, hit);
    }

    @Override
    public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
        if (BMConfigs.SERVER_CONFIGS.standingAljanTeleport.get()) {
            if (state.getValue(JANTICAL)) {
                if (!world.isClientSide()) {
                    MinecraftServer server = world.getServer();

                    if (server != null) {
                        if (world.dimension() == BMDimensions.THE_ALJAN) {
                            ServerLevel overworld = server.getLevel(Level.OVERWORLD);
                            if (overworld != null) {
                                entity.changeDimension(overworld, new TheAljanTeleporter(pos, false));
                            }
                        } else {
                            ServerLevel theAljan = server.getLevel(BMDimensions.THE_ALJAN);
                            if (theAljan != null) {
                                entity.changeDimension(theAljan, new TheAljanTeleporter(pos, true));
                            }
                        }
                    }
                }
            }
        }

        super.entityInside(state, world, pos, entity);
    }

    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }

        return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(WATERLOGGED, fluidState.is(FluidTags.WATER) && fluidState.getAmount() == 8);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(JANTICAL, WATERLOGGED);
    }
}
