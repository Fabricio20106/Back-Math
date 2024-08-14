package com.sophicreeper.backmath.item.custom.food.jam;

import net.minecraft.item.ItemStack;

public class GlisteringJamItem extends JamItem {
    public GlisteringJamItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
