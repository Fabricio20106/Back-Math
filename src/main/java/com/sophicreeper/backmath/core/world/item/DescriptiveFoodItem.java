package com.sophicreeper.backmath.core.world.item;

import com.sophicreeper.backmath.core.client.BackMath;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class DescriptiveFoodItem extends Item {
    public DescriptiveFoodItem(Properties properties) {
        super(properties);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".when_eaten").mergeStyle(TextFormatting.DARK_GREEN));
        tooltip.add(new TranslationTextComponent("foodtip." + BackMath.MOD_ID + "." + this.getTranslationKey() + ".nutrition").mergeStyle(TextFormatting.DARK_GREEN));
        tooltip.add(new TranslationTextComponent("foodtip." + BackMath.MOD_ID + this.getTranslationKey() + ".saturationMod").mergeStyle(TextFormatting.DARK_GREEN));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
