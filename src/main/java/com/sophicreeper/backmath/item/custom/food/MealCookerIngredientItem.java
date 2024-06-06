package com.sophicreeper.backmath.item.custom.food;

import com.sophicreeper.backmath.dispenser.MealCookingDispenseBehavior;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.Item;

public class MealCookerIngredientItem extends Item {
    public MealCookerIngredientItem(Properties properties) {
        super(properties);
        DispenserBlock.registerBehavior(this, new MealCookingDispenseBehavior());
    }
}
