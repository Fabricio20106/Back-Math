package com.sophicreeper.backmath.core.world.item;

import com.sophicreeper.backmath.core.client.BackMath;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class UpgradeTokenItem extends Item {
    private final String upgradeToken;

    public UpgradeTokenItem(Properties properties, String upgradeToken) {
        super(properties);
        this.upgradeToken = upgradeToken;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("upgrade_token." + BackMath.MOD_ID + "." + upgradeToken).withStyle(ChatFormatting.GRAY));
        tooltip.add(CommonComponents.EMPTY);
        tooltip.add(Component.translatable("item." + BackMath.MOD_ID + ".upgrade_token.applies_to").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("item." + BackMath.MOD_ID + ".upgrade_token_" + upgradeToken + ".applies_to").withStyle(ChatFormatting.BLUE));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}
