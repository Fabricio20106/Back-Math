package com.sophicreeper.backmath.item.custom.tool;

import com.sophicreeper.backmath.item.custom.ToolBehaviors;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

public class MilkedSwordItem extends SwordItem implements ToolBehaviors {
    public MilkedSwordItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        giveMilkedSwordItem(stack, player);
        return super.onLeftClickEntity(stack, player, entity);
    }
}
