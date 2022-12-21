package com.sophicreeper.backmath.core.world.item.aljamicwars;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CharjanCoalItem extends Item {
    public CharjanCoalItem(Properties builder) {
        super(builder);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 2400;
    }
}
