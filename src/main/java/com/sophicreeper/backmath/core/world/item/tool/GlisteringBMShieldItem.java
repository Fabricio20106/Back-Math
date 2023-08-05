package com.sophicreeper.backmath.core.world.item.tool;

import net.minecraft.world.item.ItemStack;

public class GlisteringBMShieldItem extends BMShieldItem {
    public GlisteringBMShieldItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    //@Override
    //public int getRGBDurabilityForDisplay(ItemStack stack) {
    //    return 0x1dc2d1;
    //}
}
