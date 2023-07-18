package com.sophicreeper.backmath.core.world.item.armor;

import com.sophicreeper.backmath.core.client.BackMath;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class QueenLucyShirtItem extends ArmorItem {
    private final String shirtDesign;

    public QueenLucyShirtItem(IArmorMaterial material, EquipmentSlotType slot, Properties properties, String shirtDesign) {
        super(material, slot, properties);
        this.shirtDesign = shirtDesign;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent("item." + BackMath.MOD_ID + ".queen_lucy_shirt.design").mergeStyle(TextFormatting.GRAY));
        tooltip.add(new TranslationTextComponent("item." + BackMath.MOD_ID + ".queen_lucy_shirt_" + shirtDesign + ".desc").mergeStyle(TextFormatting.BLUE));
        super.addInformation(stack, world, tooltip, flag);
    }
}
