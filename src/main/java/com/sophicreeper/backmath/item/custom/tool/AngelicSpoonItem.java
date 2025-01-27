package com.sophicreeper.backmath.item.custom.tool;

import com.sophicreeper.backmath.dispenser.MealCookingDispenseBehavior;
import com.sophicreeper.backmath.item.custom.behavior.BMShovelItem;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.IItemTier;

public class AngelicSpoonItem extends BMShovelItem {
    public AngelicSpoonItem(IItemTier tier, float attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
        DispenserBlock.registerBehavior(this, new MealCookingDispenseBehavior());
    }
}
