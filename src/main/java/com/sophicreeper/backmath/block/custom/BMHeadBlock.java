package com.sophicreeper.backmath.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.enchantment.IArmorVanishable;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class BMHeadBlock extends HorizontalBlock implements IArmorVanishable {
    public static final IntegerProperty ROTATION = BlockStateProperties.ROTATION_0_15;
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(4, 0, 4, 12, 8, 12);

    public BMHeadBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(ROTATION, 0));
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(ROTATION, MathHelper.floor((double) (context.getPlacementYaw() * 16 / 360) + 0.5D) & 15);
    }

    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.with(ROTATION, rotation.rotate(state.get(ROTATION), 16));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.with(ROTATION, mirror.mirrorRotation(state.get(ROTATION), 16));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(ROTATION);
    }

    @Override
    public boolean allowsMovement(BlockState state, IBlockReader world, BlockPos pos, PathType type) {
        return false;
    }
}
