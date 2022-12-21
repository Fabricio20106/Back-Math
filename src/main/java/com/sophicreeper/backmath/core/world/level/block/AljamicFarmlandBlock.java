package com.sophicreeper.backmath.core.world.level.block;

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
    public static final IntegerProperty MOISTURE = BlockStateProperties.MOISTURE_0_7;
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);

    public AljamicFarmlandBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(MOISTURE, 0));
    }

    /**
     * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
     * returns its solidified counterpart.
     * Note that this method should ideally consider only the specific face passed in.
     */
    public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
        if (facing == Direction.UP && !state.isValidPosition(world, currentPos)) {
            world.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
        }

        return super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldReader, BlockPos pos) {
        BlockState upperBlock = worldReader.getBlockState(pos.up());
        return !upperBlock.getMaterial().isSolid() || upperBlock.getBlock() instanceof FenceGateBlock || upperBlock.getBlock() instanceof MovingPistonBlock;
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return !this.getDefaultState().isValidPosition(context.getWorld(), context.getPos()) ? BMBlocks.ALJAMIC_DIRT.get().getDefaultState() : super.getStateForPlacement(context);
    }

    public boolean isTransparent(BlockState state) {
        return true;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (!state.isValidPosition(worldIn, pos)) {
            turnToAljamicDirt(state, worldIn, pos);
        }
    }

    /**
     * Performs a random tick on a block.
     */
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        int i = state.get(MOISTURE);
        if (!hasWater(worldIn, pos) && !worldIn.isRainingAt(pos.up())) {
            if (i > 0) {
                worldIn.setBlockState(pos, state.with(MOISTURE, i - 1), 2);
            } else if (!hasCrops(worldIn, pos)) {
                turnToAljamicDirt(state, worldIn, pos);
            }
        } else if (i < 7) {
            worldIn.setBlockState(pos, state.with(MOISTURE, 7), 2);
        }

    }

    /**
     * Block's chance to react to a living entity falling on it.
     */
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        if (!worldIn.isRemote && ForgeHooks.onFarmlandTrample(worldIn, pos, BMBlocks.ALJAMIC_DIRT.get().getDefaultState(), fallDistance, entityIn)) { // Forge: Move logic to Entity#canTrample
            turnToAljamicDirt(worldIn.getBlockState(pos), worldIn, pos);
        }

        super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
    }

    public static void turnToAljamicDirt(BlockState state, World worldIn, BlockPos pos) {
        worldIn.setBlockState(pos, nudgeEntitiesWithNewState(state, BMBlocks.ALJAMIC_DIRT.get().getDefaultState(), worldIn, pos));
    }

    private boolean hasCrops(IBlockReader worldIn, BlockPos pos) {
        BlockState plant = worldIn.getBlockState(pos.up());
        BlockState state = worldIn.getBlockState(pos);
        return plant.getBlock() instanceof IPlantable && state.canSustainPlant(worldIn, pos, Direction.UP, (IPlantable) plant.getBlock());
    }

    private static boolean hasWater(IWorldReader worldIn, BlockPos pos) {
        for(BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-4, 0, -4), pos.add(4, 1, 4))) {
            if (worldIn.getFluidState(blockpos).isTagged(FluidTags.WATER)) {
                return true;
            }
        }

        return FarmlandWaterManager.hasBlockWaterTicket(worldIn, pos);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(MOISTURE);
    }

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }
}
