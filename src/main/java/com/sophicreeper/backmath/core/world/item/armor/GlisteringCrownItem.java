package com.sophicreeper.backmath.core.world.item.armor;

import com.sophicreeper.backmath.core.world.item.armor.CrownItem;
import net.minecraft.item.ItemStack;

public class GlisteringCrownItem extends CrownItem {
    public GlisteringCrownItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
