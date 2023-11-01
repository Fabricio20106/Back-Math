package com.sophicreeper.backmath.item.custom.weapon;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;

public class ButterSwordItem extends SwordItem {
    public ButterSwordItem(IItemTier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    // When player stops using item (i.e. stops using a bow (shooting), finished eating/drinking):
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity livingEntity) {
        if (livingEntity instanceof PlayerEntity) {
            // Gives the player 500 experience points (XP points).
            ((PlayerEntity) livingEntity).giveExperiencePoints(500);
        }
        return super.onItemUseFinish(stack, world, livingEntity);
    }
}
