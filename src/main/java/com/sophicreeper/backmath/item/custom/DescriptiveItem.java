package com.sophicreeper.backmath.item.custom;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class DescriptiveItem extends Item {
    private final ITextComponent description;

    public DescriptiveItem(ITextComponent description, Properties properties) {
        super(properties);
        this.description = description;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(this.description);
        super.appendHoverText(stack, world, tooltip, flag);
    }
}
