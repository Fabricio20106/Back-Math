package com.sophicreeper.backmath.item.tab;

import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class SophiesCursedFoods extends ItemGroup {
    public static final SophiesCursedFoods TAB = new SophiesCursedFoods("comida");

    public SophiesCursedFoods(String label) {
        super(label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(AxolotlTest.FRIED_EGG.get());
    }
}
