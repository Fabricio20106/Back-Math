package com.sophicreeper.backmath.core.world.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class BMWeaponryTab extends ItemGroup {
    public static final BMWeaponryTab TAB = new BMWeaponryTab("backmath.weaponry_tab");

    public BMWeaponryTab(String label) {
        super(label);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(AxolotlTest.MID_TERM_BREASTPLATE.get());
    }
}
