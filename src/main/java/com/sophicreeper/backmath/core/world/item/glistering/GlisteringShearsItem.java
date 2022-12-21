package com.sophicreeper.backmath.core.world.item.glistering;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;

public class GlisteringShearsItem extends ShearsItem {
    public GlisteringShearsItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
