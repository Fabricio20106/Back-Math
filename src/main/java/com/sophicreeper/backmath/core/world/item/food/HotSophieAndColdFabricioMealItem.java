package com.sophicreeper.backmath.core.world.item.food;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class HotSophieAndColdFabricioMealItem extends Item {
    public HotSophieAndColdFabricioMealItem() {
        super(new Properties().stacksTo(8).rarity(Rarity.UNCOMMON).food(new FoodProperties.Builder().nutrition(2).saturationMod(9.5f).build()));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity livingEntity) {
        // livingEntity.hurt(BMDamageSources.HOT_AND_COLD_MEAL, Float.MAX_VALUE);
        return super.finishUsingItem(stack, world, livingEntity);
    }
}
