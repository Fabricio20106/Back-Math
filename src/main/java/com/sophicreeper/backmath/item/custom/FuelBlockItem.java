package com.sophicreeper.backmath.item.custom;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class FuelBlockItem extends BlockItem {
    private final int burnTime;

    public FuelBlockItem(int burnTime, Block block, Properties properties) {
        super(block, properties);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack stack) {
        return this.burnTime;
    }
}
