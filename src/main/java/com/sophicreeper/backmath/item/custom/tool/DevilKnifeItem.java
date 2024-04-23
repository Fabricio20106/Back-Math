package com.sophicreeper.backmath.item.custom.tool;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class DevilKnifeItem extends KnifeItem {
    public DevilKnifeItem(float attackDamage, float swingSpeed, IItemTier tier, Properties properties) {
        super(attackDamage, swingSpeed, tier, properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livEntity = (LivingEntity) entity;
            livEntity.setSecondsOnFire(5);
        }
        return super.onLeftClickEntity(stack, player, entity);
    }
}
