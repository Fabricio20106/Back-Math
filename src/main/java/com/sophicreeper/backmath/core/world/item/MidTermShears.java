package com.sophicreeper.backmath.core.world.item;

import com.sophicreeper.backmath.core.world.item.glistering.GlisteringShearsItem;
import net.minecraft.item.ItemStack;

public class MidTermShears extends GlisteringShearsItem {
    public MidTermShears(Properties properties) {
        super(properties);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return 0x1dc2d1;
    }
}
