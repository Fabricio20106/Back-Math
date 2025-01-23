package com.sophicreeper.backmath.item.custom.tool.sparey;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class MilkedSpareyItem extends SpareyItem {
    public MilkedSpareyItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity target) {
        giveMilkedSwordItem(stack, player);
        return super.onLeftClickEntity(stack, player, target);
    }
}
