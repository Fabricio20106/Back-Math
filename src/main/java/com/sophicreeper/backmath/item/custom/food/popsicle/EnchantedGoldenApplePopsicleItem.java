package com.sophicreeper.backmath.item.custom.food.popsicle;

import com.sophicreeper.backmath.item.tab.SophiesCursedFoods;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class EnchantedGoldenApplePopsicleItem extends Item {
    public EnchantedGoldenApplePopsicleItem(Food food) {
        super(new Properties().group(SophiesCursedFoods.TAB).rarity(Rarity.EPIC).food(food));
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity livingEntity) {
        ItemStack stack1 = super.onItemUseFinish(stack, world, livingEntity);
        return livingEntity instanceof PlayerEntity && ((PlayerEntity) livingEntity).abilities.isCreativeMode ? stack1 : new ItemStack(Items.STICK);
    }
}
