package com.sophicreeper.backmath.core.world.item;

import com.sophicreeper.backmath.core.world.entity.BMDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.world.World;

public class HotSophieAndColdFabricioMealItem extends Item {
    public HotSophieAndColdFabricioMealItem() {
        super(new Properties().group(SophiesCursedFoods.COMIDA).maxStackSize(8).rarity(Rarity.UNCOMMON).food(new Food.Builder().hunger(2).saturation(9.5f).build()));
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        entityLiving.attackEntityFrom(BMDamageSources.HOT_AND_COLD_MEAL, Float.MAX_VALUE);
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
