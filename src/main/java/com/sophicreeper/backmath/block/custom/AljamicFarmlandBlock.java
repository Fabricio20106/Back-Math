package com.sophicreeper.backmath.block.custom;

import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.FarmlandWaterManager;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class AljamicFarmlandBlock extends Block {
    public static final IntegerProperty MOISTURE = BlockStateProperties.MOISTURE;
    protected static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 15, 16);

    public AljamicFarmlandBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(MOISTURE, 0));
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

    public boolean canSurvive(BlockState state, IWorldReader worldReader, BlockPos pos) {
        BlockState aboveBlock = worldReader.getBlockState(pos.above());
        return !aboveBlock.getMaterial().isSolid() || aboveBlock.is(BMTags.Blocks.FARMLAND_TRANSPARENT);
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return !this.defaultBlockState().canSurvive(context.getLevel(), context.getClickedPos()) ? BMBlocks.ALJAMIC_DIRT.get().defaultBlockState() : super.getStateForPlacement(context);
    }

    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public void tick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
        if (!state.canSurvive(world, pos)) {
            turnToAljamicDirt(state, world, pos);
        }
    }

    // Performs a random tick on a block.
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int moistureState = state.getValue(MOISTURE);
        if (!hasWater(world, pos) && !world.isRainingAt(pos.above())) {
            if (moistureState > 0) {
                world.setBlock(pos, state.setValue(MOISTURE, moistureState - 1), 2);
            } else if (!hasCrops(world, pos)) {
                turnToAljamicDirt(state, world, pos);
            }
        } else if (moistureState < 7) {
            world.setBlock(pos, state.setValue(MOISTURE, 7), 2);
        }
    }

    // Block's chance to react to a living entity falling on it.
    public void fallOn(World worldIn, BlockPos pos, Entity entity, float fallDistance) {
        // Forge: Move logic to Entity#canTrample.
        if (!worldIn.isClientSide && ForgeHooks.onFarmlandTrample(worldIn, pos, BMBlocks.ALJAMIC_DIRT.get().defaultBlockState(), fallDistance, entity)) {
            turnToAljamicDirt(worldIn.getBlockState(pos), worldIn, pos);
        }

        super.fallOn(worldIn, pos, entity, fallDistance);
    }

    public static void turnToAljamicDirt(BlockState state, World world, BlockPos pos) {
        world.setBlockAndUpdate(pos, pushEntitiesUp(state, BMBlocks.ALJAMIC_DIRT.get().defaultBlockState(), world, pos));
    }

    private boolean hasCrops(IBlockReader world, BlockPos pos) {
        BlockState plant = world.getBlockState(pos.above());
        BlockState state = world.getBlockState(pos);
        return plant.getBlock() instanceof IPlantable && state.canSustainPlant(world, pos, Direction.UP, (IPlantable) plant.getBlock());
    }

    private static boolean hasWater(IWorldReader world, BlockPos pos) {
        for(BlockPos blockPos : BlockPos.betweenClosed(pos.offset(-4, 0, -4), pos.offset(4, 1, 4))) {
            if (world.getFluidState(blockPos).is(FluidTags.WATER)) {
                return true;
            }
        }

        return FarmlandWaterManager.hasBlockWaterTicket(world, pos);
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(MOISTURE);
    }

    public boolean isPathfindable(BlockState state, IBlockReader world, BlockPos pos, PathType type) {
        return false;
    }
}
