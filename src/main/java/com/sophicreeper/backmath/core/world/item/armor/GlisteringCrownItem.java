package com.sophicreeper.backmath.core.world.item.armor;

import net.minecraft.world.item.ItemStack;

public class GlisteringCrownItem extends CrownItem {
    public GlisteringCrownItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
