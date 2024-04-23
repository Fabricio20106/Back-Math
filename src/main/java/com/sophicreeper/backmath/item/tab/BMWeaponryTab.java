package com.sophicreeper.backmath.item.tab;

import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class BMWeaponryTab extends ItemGroup {
    public static final BMWeaponryTab TAB = new BMWeaponryTab("backmath.weaponry_tab");

    public BMWeaponryTab(String label) {
        super(label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(AxolotlTest.MID_TERM_BREASTPLATE.get());
    }
}
