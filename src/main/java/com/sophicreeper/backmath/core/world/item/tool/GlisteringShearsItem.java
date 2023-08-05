package com.sophicreeper.backmath.core.world.item.tool;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;

public class GlisteringShearsItem extends ShearsItem {
    public GlisteringShearsItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
