package com.sophicreeper.backmath.item.tab;

import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

public class BackLayer extends ItemGroup {
    public static final BackLayer TAB = new BackLayer("backmath.main");

    public BackLayer(String label) {
        super(label);
    }

    @Override
    @Nonnull
    public ItemStack makeIcon() {
        return new ItemStack(AxolotlTest.GOLDEN_PLATED.get());
    }

    @Override
    @Nonnull
    @OnlyIn(Dist.CLIENT)
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("itemGroup.backmath.main").withStyle(TextFormatting.UNDERLINE);
    }
}
