package com.sophicreeper.backmath.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CharjanCoalItem extends Item {
    public CharjanCoalItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack stack) {
        return 2400;
    }
}
