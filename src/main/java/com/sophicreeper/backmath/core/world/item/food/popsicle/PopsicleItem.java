package com.sophicreeper.backmath.core.world.item.food.popsicle;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class PopsicleItem extends Item {
    public PopsicleItem(FoodProperties food) {
        super(new Properties().food(food));
    }

    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity livingEntity) {
        ItemStack stack1 = super.finishUsingItem(stack, world, livingEntity);
        return livingEntity instanceof Player && ((Player) livingEntity).getAbilities().instabuild ? stack1 : new ItemStack(Items.STICK);
    }
}
