package com.sophicreeper.backmath.blockentity.custom;

import com.sophicreeper.backmath.blockentity.BMBlockEntities;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

import javax.annotation.Nonnull;

public class HeadBlockEntity extends TileEntity {
    public HeadBlockEntity() {
        super(BMBlockEntities.HEAD.get());
    }

    @Override
    @Nonnull
    public TileEntityType<?> getType() {
        return BMBlockEntities.HEAD.get();
    }
}
