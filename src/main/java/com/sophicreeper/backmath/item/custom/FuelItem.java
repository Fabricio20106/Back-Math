package com.sophicreeper.backmath.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;

import javax.annotation.Nullable;

public class FuelItem extends Item {
    private final int burnTime;

    public FuelItem(int burnTime, Properties properties) {
        super(properties);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack stack, @Nullable IRecipeType<?> recipeType) {
        return this.burnTime;
    }
}
