package com.sophicreeper.backmath.core.world.item.tool;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class GlisteringKnifeItem extends KnifeItem {
    public GlisteringKnifeItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
