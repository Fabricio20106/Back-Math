package com.sophicreeper.backmath.item.custom.weapon.milked;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class MilkedDevilSwordItem extends MilkedSwordItem {
    public MilkedDevilSwordItem(IItemTier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        entity.setFire(5);
        return super.onLeftClickEntity(stack, player, entity);
    }
}
