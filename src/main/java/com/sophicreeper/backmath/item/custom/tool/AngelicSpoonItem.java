package com.sophicreeper.backmath.item.custom.tool;

import com.sophicreeper.backmath.block.dispenser.MealCookingDispenseBehavior;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ShovelItem;

public class AngelicSpoonItem extends ShovelItem {
    public AngelicSpoonItem(IItemTier tier, float attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
        DispenserBlock.registerDispenseBehavior(this, new MealCookingDispenseBehavior());
    }
}
