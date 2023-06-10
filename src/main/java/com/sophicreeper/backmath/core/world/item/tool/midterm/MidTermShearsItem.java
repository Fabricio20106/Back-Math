package com.sophicreeper.backmath.core.world.item.tool.midterm;

import com.sophicreeper.backmath.core.world.item.tool.GlisteringShearsItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MidTermShearsItem extends GlisteringShearsItem {
    public MidTermShearsItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return 0x1dc2d1;
    }
}
