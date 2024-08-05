package com.sophicreeper.backmath.item.custom.food;

import com.sophicreeper.backmath.entity.BMDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class HotSophieAndColdFabricioMealItem extends Item {
    public HotSophieAndColdFabricioMealItem(Properties properties) {
        super(properties);
    }

    @Override
    @Nonnull
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livEntity) {
        livEntity.hurt(BMDamageSources.TEMPERATURE_MEAL, Float.MAX_VALUE);
        return super.finishUsingItem(stack, world, livEntity);
    }
}
