package com.sophicreeper.backmath.core.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.piston.MovingPistonBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.FarmlandWaterManager;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;

public class AljamicFarmlandBlock extends Block {
    public static final IntegerProperty MOISTURE = BlockStateProperties.MOISTURE;
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);

    public AljamicFarmlandBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(MOISTURE, 0));
    }

    /**
     * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
     * returns its solidified counterpart.
     * Note that this method should ideally consider only the specific face passed in.
     */
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        if (facing == Direction.UP && !state.canSurvive(world, currentPos)) {
            world.scheduleTick(currentPos, this, 1);
        }

        return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }

    public boolean canSurvive(BlockState state, LevelReader worldReader, BlockPos pos) {
        BlockState aboveBlock = worldReader.getBlockState(pos.above());
        return !aboveBlock.isSolid() || aboveBlock.getBlock() instanceof FenceGateBlock || aboveBlock.getBlock() instanceof MovingPistonBlock;
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return !this.defaultBlockState().canSurvive(context.getLevel(), context.getClickedPos()) ? BMBlocks.ALJAMIC_DIRT.get().defaultBlockState() : super.getStateForPlacement(context);
    }

    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource rand) {
        if (!state.canSurvive(world, pos)) {
            turnToAljamicDirt(null, state, world, pos);
        }
    }

    /**
     * Performs a random tick on a block.
     */
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        int moistureState = state.getValue(MOISTURE);
        if (!hasWater(world, pos) && !world.isRainingAt(pos.above())) {
            if (moistureState > 0) {
                world.setBlock(pos, state.setValue(MOISTURE, moistureState - 1), 2);
            } else if (!hasCrops(world, pos)) {
                turnToAljamicDirt(null, state, world, pos);
            }
        } else if (moistureState < 7) {
            world.setBlock(pos, state.setValue(MOISTURE, 7), 2);
        }
    }

    /**
     * Block's chance to react to a living entity falling on it.
     */
    public void fallOn(Level world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (!world.isClientSide && ForgeHooks.onFarmlandTrample(world, pos, BMBlocks.ALJAMIC_DIRT.get().defaultBlockState(), fallDistance, entity)) { // Forge: Move logic to Entity#canTrample
            turnToAljamicDirt(entity, world.getBlockState(pos), world, pos);
        }

        super.fallOn(world, state, pos, entity, fallDistance);
    }

    public static void turnToAljamicDirt(@Nullable Entity entity, BlockState state, Level world, BlockPos pos) {
        BlockState aljamicDirt = pushEntitiesUp(state, BMBlocks.ALJAMIC_DIRT.get().defaultBlockState(), world, pos);
        world.setBlockAndUpdate(pos, aljamicDirt);
        world.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(entity, aljamicDirt));
    }

    private boolean hasCrops(BlockGetter world, BlockPos pos) {
        BlockState plant = world.getBlockState(pos.above());
        BlockState state = world.getBlockState(pos);
        return plant.getBlock() instanceof IPlantable && state.canSustainPlant(world, pos, Direction.UP, (IPlantable) plant.getBlock());
    }

    private static boolean hasWater(LevelReader world, BlockPos pos) {
        for(BlockPos blockPos : BlockPos.betweenClosed(pos.offset(-4, 0, -4), pos.offset(4, 1, 4))) {
            if (world.getFluidState(blockPos).is(FluidTags.WATER)) {
                return true;
            }
        }

        return FarmlandWaterManager.hasBlockWaterTicket(world, pos);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(MOISTURE);
    }

    public boolean isPathfindable(BlockState state, BlockGetter world, BlockPos pos, PathComputationType type) {
        return false;
    }
}
