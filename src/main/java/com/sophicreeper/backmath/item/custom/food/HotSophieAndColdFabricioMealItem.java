package com.sophicreeper.backmath.item.custom.food;

import com.sophicreeper.backmath.entity.BMDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class HotSophieAndColdFabricioMealItem extends Item {
    public HotSophieAndColdFabricioMealItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity livingEntity) {
        livingEntity.attackEntityFrom(BMDamageSources.HOT_AND_COLD_MEAL, Float.MAX_VALUE);
        return super.onItemUseFinish(stack, world, livingEntity);
    }
}
