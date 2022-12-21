package com.sophicreeper.backmath.core.world.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;

public class ButterSwordItem extends SwordItem {
    public ButterSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    // When player stops using item (i.e. stops using a bow (shooting), finished eating/drinking):
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (entityLiving instanceof PlayerEntity) {
            // Gives the player 500 experience points (XP points).
            ((PlayerEntity) entityLiving).giveExperiencePoints(500);
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
