package com.sophicreeper.backmath.item.custom.weapon.milked;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class MilkedDevilSwordItem extends MilkedSwordItem {
    public MilkedDevilSwordItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livEntity = (LivingEntity) entity;
            livEntity.setFire(5);
        }
        return super.onLeftClickEntity(stack, player, entity);
    }
}
