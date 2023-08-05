package com.sophicreeper.backmath.core.world.item.armor;

import com.sophicreeper.backmath.core.client.BackMath;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class QueenLucyShirtItem extends ArmorItem {
    private final String shirtDesign;

    public QueenLucyShirtItem(ArmorMaterial material, ArmorItem.Type slot, Properties properties, String shirtDesign) {
        super(material, slot, properties);
        this.shirtDesign = shirtDesign;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("item." + BackMath.MOD_ID + ".queen_lucy_shirt.design").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("item." + BackMath.MOD_ID + ".queen_lucy_shirt_" + shirtDesign + ".desc").withStyle(ChatFormatting.BLUE));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}
