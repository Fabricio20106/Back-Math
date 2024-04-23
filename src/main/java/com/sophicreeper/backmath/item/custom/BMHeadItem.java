package com.sophicreeper.backmath.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.DispenserBlock;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.WallOrFloorItem;

import javax.annotation.Nullable;

import static net.minecraft.item.ArmorItem.DISPENSE_ITEM_BEHAVIOR;

public class BMHeadItem extends WallOrFloorItem {
    public BMHeadItem(Block floorBlock, Block wallBlock, Properties properties) {
        super(floorBlock, wallBlock, properties);
        DispenserBlock.registerBehavior(this, DISPENSE_ITEM_BEHAVIOR);
    }

    @Nullable
    @Override
    public EquipmentSlotType getEquipmentSlot(ItemStack stack) {
        return EquipmentSlotType.HEAD;
    }
}
