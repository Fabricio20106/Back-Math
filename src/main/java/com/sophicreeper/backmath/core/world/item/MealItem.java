package com.sophicreeper.backmath.core.world.item;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class MealItem extends Item {
    public MealItem(int nutrition) {
        super(new Properties().group(SophiesCursedFoods.TAB).maxStackSize(8).rarity(Rarity.UNCOMMON).food(new Food.Builder().hunger(nutrition).saturation(9.5f).build()));
    }
}
