package com.sophicreeper.backmath.core.world.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class BMBlockTab extends ItemGroup {
    public static final BMBlockTab TAB = new BMBlockTab("backmath.blocks");

    public BMBlockTab(String label) {
        super(label);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(AxolotlTest.MEAL_COOKER.get());
    }
}
