package com.sophicreeper.backmath.block.custom.head;

import com.sophicreeper.backmath.blockentity.custom.BMHeadType;
import com.sophicreeper.backmath.blockentity.custom.HeadBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.enchantment.IArmorVanishable;
import net.minecraft.pathfinding.PathType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class AbstractHeadBlock extends ContainerBlock implements IArmorVanishable {
    private final BMHeadType type;

    public AbstractHeadBlock(BMHeadType type, Properties properties) {
        super(properties);
        this.type = type;
    }

    public BMHeadType getType() {
        return this.type;
    }

    @Override
    @Nullable
    public TileEntity newBlockEntity(IBlockReader world) {
        return new HeadBlockEntity();
    }

    @Override
    public boolean isPathfindable(BlockState state, IBlockReader world, BlockPos pos, PathType type) {
        return false;
    }
}
