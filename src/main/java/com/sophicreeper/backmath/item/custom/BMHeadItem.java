package com.sophicreeper.backmath.item.custom;

import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.WallOrFloorItem;

import javax.annotation.Nullable;

public class BMHeadItem extends WallOrFloorItem {
    public BMHeadItem(Block floorBlock, Block wallBlock, Properties properties) {
        super(floorBlock, wallBlock, properties);
    }

    @Nullable
    @Override
    public EquipmentSlotType getEquipmentSlot(ItemStack stack) {
        return EquipmentSlotType.HEAD;
    }
}
