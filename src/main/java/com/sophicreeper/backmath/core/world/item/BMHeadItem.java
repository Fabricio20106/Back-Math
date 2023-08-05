package com.sophicreeper.backmath.core.world.item;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;

public class BMHeadItem extends StandingAndWallBlockItem {
    public BMHeadItem(Block floorBlock, Block wallBlock, Properties properties) {
        super(floorBlock, wallBlock, properties, Direction.DOWN);
    }

    @Nullable
    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.HEAD;
    }
}
