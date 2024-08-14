package com.sophicreeper.backmath.item.tab;

import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

public class SophiesCursedFoods extends ItemGroup {
    public static final SophiesCursedFoods TAB = new SophiesCursedFoods("backmath.comida");

    public SophiesCursedFoods(String label) {
        super(label);
    }

    @Override
    @Nonnull
    public ItemStack makeIcon() {
        return new ItemStack(AxolotlTest.FRIED_EGG.get());
    }

    @Override
    @Nonnull
    @OnlyIn(Dist.CLIENT)
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("itemGroup.backmath.comida").withStyle(TextFormatting.UNDERLINE);
    }
}
