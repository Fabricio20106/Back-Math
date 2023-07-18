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

public class UpgradeTokenItem extends Item {
    private final String upgradeToken;

    public UpgradeTokenItem(Properties properties, String upgradeToken) {
        super(properties);
        this.upgradeToken = upgradeToken;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent("upgrade_token." + BackMath.MOD_ID + "." + upgradeToken).mergeStyle(TextFormatting.GRAY));
        tooltip.add(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".empty"));
        tooltip.add(new TranslationTextComponent("item." + BackMath.MOD_ID + ".upgrade_token.applies_to").mergeStyle(TextFormatting.GRAY));
        tooltip.add(new TranslationTextComponent("item." + BackMath.MOD_ID + ".upgrade_token_" + upgradeToken + ".applies_to").mergeStyle(TextFormatting.BLUE));
        super.addInformation(stack, world, tooltip, flag);
    }
}
