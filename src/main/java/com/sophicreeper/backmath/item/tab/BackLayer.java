package com.sophicreeper.backmath.item.tab;

import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class BackLayer extends ItemGroup {
    public static final BackLayer TAB = new BackLayer("back_math");

    public BackLayer(String label) {
        super(label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(AxolotlTest.GOLDEN_PLATED.get());
    }
}
