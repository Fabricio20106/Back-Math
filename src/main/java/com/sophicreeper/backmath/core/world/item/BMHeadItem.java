package com.sophicreeper.backmath.core.world.item;

import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.WallOrFloorItem;

import javax.annotation.Nullable;

public class BMHeadItem extends WallOrFloorItem {
    public BMHeadItem(Block floorBlock, Block wallBlockIn, Properties propertiesIn) {
        super(floorBlock, wallBlockIn, propertiesIn);
    }

    @Nullable
    @Override
    public EquipmentSlotType getEquipmentSlot(ItemStack stack) {
        return EquipmentSlotType.HEAD;
    }
}
