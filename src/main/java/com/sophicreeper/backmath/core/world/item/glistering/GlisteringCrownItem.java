package com.sophicreeper.backmath.core.world.item.glistering;

import com.sophicreeper.backmath.core.world.item.CrownItem;
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
