package com.sophicreeper.backmath.core.world.item;

import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;

public class BMCrossbowItem extends CrossbowItem {
    public BMCrossbowItem() {
        super(new Properties().maxDamage(520).group(BMWeaponryTab.TAB));
    }

    public boolean isCrossbow(ItemStack stack) {
        return stack.getItem() == AxolotlTest.ANGELIC_CROSSBOW.get() || stack.getItem() == AxolotlTest.DEVIL_CROSSBOW.get();
    }
}
