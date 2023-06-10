package com.sophicreeper.backmath.core.world.item.tool;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class DevilKnifeItem extends KnifeItem {
    public DevilKnifeItem(float attackDamage, float attackSpeed, IItemTier tier, Properties properties) {
        super(attackDamage, attackSpeed, tier, properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        entity.setFire(5);
        return super.onLeftClickEntity(stack, player, entity);
    }
}
