package com.sophicreeper.backmath.core.world.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;

public class MilkedSwordItem extends SwordItem {
    public MilkedSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        player.addItemStackToInventory(new ItemStack(Items.MILK_BUCKET));
        return super.onLeftClickEntity(stack, player, entity);
    }
}
