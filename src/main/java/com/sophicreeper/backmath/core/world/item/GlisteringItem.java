package com.sophicreeper.backmath.core.world.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class GlisteringItem extends Item {
    public GlisteringItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
