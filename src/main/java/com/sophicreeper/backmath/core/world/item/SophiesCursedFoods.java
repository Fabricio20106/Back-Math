package com.sophicreeper.backmath.core.world.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class SophiesCursedFoods extends ItemGroup {
    public static final SophiesCursedFoods COMIDA = new SophiesCursedFoods("comida");

    public SophiesCursedFoods(String label) {
        super(label);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(AxolotlTest.FRIED_EGG.get());
    }
}
