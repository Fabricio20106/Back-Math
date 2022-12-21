package com.sophicreeper.backmath.core.world.item.glistering;

import com.sophicreeper.backmath.core.world.item.BMShieldItem;
import net.minecraft.item.ItemStack;

public class MidTermShieldItem extends BMShieldItem {
    public MidTermShieldItem(Properties builder) {
        super(builder);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return 0x1dc2d1;
    }
}
