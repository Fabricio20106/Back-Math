package com.sophicreeper.backmath.item.tab;

import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class BMWeaponryTab extends ItemGroup {
    public static final BMWeaponryTab TAB = new BMWeaponryTab("backmath.weaponry");

    public BMWeaponryTab(String label) {
        super(label);
    }

    @Override
    @Nonnull
    public ItemStack makeIcon() {
        return new ItemStack(AxolotlTest.MID_TERM_BREASTPLATE.get());
    }
}
