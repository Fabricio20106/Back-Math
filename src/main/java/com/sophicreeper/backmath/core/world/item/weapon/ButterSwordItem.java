package com.sophicreeper.backmath.core.world.item.weapon;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class ButterSwordItem extends SwordItem {
    public ButterSwordItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    // When player stops using item (i.e. stops using a bow (shooting), finished eating/drinking):
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity livingEntity) {
        if (livingEntity instanceof Player) {
            // Gives the player 500 experience points (XP points).
            ((Player) livingEntity).giveExperiencePoints(500);
        }
        return super.finishUsingItem(stack, world, livingEntity);
    }
}
