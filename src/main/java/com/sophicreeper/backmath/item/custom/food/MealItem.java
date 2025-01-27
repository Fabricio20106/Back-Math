package com.sophicreeper.backmath.item.custom.food;

import com.sophicreeper.backmath.item.tab.SophiesCursedFoods;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class MealItem extends Item {
    public MealItem(int nutrition) {
        super(new Properties().stacksTo(8).rarity(Rarity.UNCOMMON).food(new Food.Builder().nutrition(nutrition).saturationMod(4.75F).build()).tab(SophiesCursedFoods.TAB));
    }
}
