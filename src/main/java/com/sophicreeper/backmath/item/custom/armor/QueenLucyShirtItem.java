package com.sophicreeper.backmath.item.custom.armor;

import com.sophicreeper.backmath.BackMath;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class QueenLucyShirtItem extends OutfitItem {
    private final String shirtDesign;

    public QueenLucyShirtItem(IArmorMaterial material, EquipmentSlotType slot, Properties properties, String shirtDesign) {
        super(material, slot, properties);
        this.shirtDesign = shirtDesign;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        tooltip.add(new TranslationTextComponent("item." + BackMath.MOD_ID + ".queen_lucy_shirt.design").withStyle(TextFormatting.GRAY));
        tooltip.add(new TranslationTextComponent("item." + BackMath.MOD_ID + ".queen_lucy_shirt_" + this.shirtDesign + ".desc").withStyle(TextFormatting.BLUE));
    }
}
