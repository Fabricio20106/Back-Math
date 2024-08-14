package com.sophicreeper.backmath.item.custom.food.popsicle;

import net.minecraft.item.ItemStack;

public class GlisteringPopsicleItem extends PopsicleItem {
    public GlisteringPopsicleItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
