package com.sophicreeper.backmath.item.tab;

import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class BMBlockTab extends ItemGroup {
    public static final BMBlockTab TAB = new BMBlockTab("backmath.blocks");

    public BMBlockTab(String label) {
        super(label);
    }

    @Override
    @Nonnull
    public ItemStack makeIcon() {
        return new ItemStack(AxolotlTest.MEAL_COOKER.get());
    }
}
