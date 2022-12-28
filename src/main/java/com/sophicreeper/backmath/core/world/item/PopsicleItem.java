package com.sophicreeper.backmath.core.world.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class PopsicleItem extends Item {
    public PopsicleItem(Food food) {
        super(new Properties().group(SophiesCursedFoods.TAB).food(food));
    }

    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity livingEntity) {
        ItemStack stack1 = super.onItemUseFinish(stack, world, livingEntity);
        return livingEntity instanceof PlayerEntity && ((PlayerEntity) livingEntity).abilities.isCreativeMode ? stack1 : new ItemStack(Items.STICK);
    }
}
