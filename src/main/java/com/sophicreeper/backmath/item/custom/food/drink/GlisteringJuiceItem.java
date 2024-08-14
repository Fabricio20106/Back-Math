package com.sophicreeper.backmath.item.custom.food.drink;

import net.minecraft.item.ItemStack;

public class GlisteringJuiceItem extends JuiceItem {
    public GlisteringJuiceItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
