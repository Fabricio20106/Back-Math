package com.sophicreeper.backmath.item.custom;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.WallOrFloorItem;

public class GlisteringWallOrFloorItem extends WallOrFloorItem {
    public GlisteringWallOrFloorItem(Block floorBlock, Block wallBlock, Properties properties) {
        super(floorBlock, wallBlock, properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
