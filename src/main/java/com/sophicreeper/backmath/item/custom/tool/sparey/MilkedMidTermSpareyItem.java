package com.sophicreeper.backmath.item.custom.tool.sparey;

import com.sophicreeper.backmath.item.custom.tool.midterm.MidTermSpareyItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class MilkedMidTermSpareyItem extends MidTermSpareyItem {
    public MilkedMidTermSpareyItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity target) {
        giveMilkedSwordItem(stack, player);
        return super.onLeftClickEntity(stack, player, target);
    }
}
