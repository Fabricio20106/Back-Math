package com.sophicreeper.backmath.item.custom.armor;

import net.minecraft.item.ItemStack;

public class GlisteringCrownItem extends CrownItem {
    public GlisteringCrownItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
