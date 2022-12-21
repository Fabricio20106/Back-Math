package com.sophicreeper.backmath.core.world.item.glistering;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GlisteringItem extends Item {
    public GlisteringItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
