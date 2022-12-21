package com.sophicreeper.backmath.core.world.item;

import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;

public class BMCrossbowItem extends CrossbowItem {
    public BMCrossbowItem() {
        super(new Properties().maxDamage(520).group(BMWeaponryTab.WEAPONRY_TAB));
    }

    public boolean isCrossbow(ItemStack itemStack) {
        return itemStack.getItem() == AxolotlTest.ANGELIC_CROSSBOW.get() || itemStack.getItem() == AxolotlTest.DEVIL_CROSSBOW.get();
    }
}
