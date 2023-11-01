package com.sophicreeper.backmath.item.custom.tool;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class GlisteringKnifeItem extends KnifeItem {
    public GlisteringKnifeItem(float attackDamage, float attackSpeed, IItemTier tier, Properties properties) {
        super(attackDamage, attackSpeed, tier, properties);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
