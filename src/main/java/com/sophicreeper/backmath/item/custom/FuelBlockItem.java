package com.sophicreeper.backmath.item.custom;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;

import javax.annotation.Nullable;

public class FuelBlockItem extends BlockItem {
    private final int burnTime;

    public FuelBlockItem(int burnTime, Block block, Properties properties) {
        super(block, properties);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack stack, @Nullable IRecipeType<?> recipeType) {
        return this.burnTime;
    }
}
