package com.sophicreeper.backmath.item.custom.food.popsicle;

import net.minecraft.item.*;

public class GlisteringPopsicleItem extends Item {
    public GlisteringPopsicleItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
