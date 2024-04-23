package com.sophicreeper.backmath.item.custom;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.crystallizer.item.CrystallizerMaterialItem;
import com.sophicreeper.backmath.util.BMKeys;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class MidTermItem extends CrystallizerMaterialItem {
    public MidTermItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        if (!BMKeys.isHoldingShift()) tooltip.add(new TranslationTextComponent("tooltip.backmath.hold_shift.not_held"));
        if (BMKeys.isHoldingShift()) tooltip.add(new TranslationTextComponent("tooltip.backmath.hold_shift.held"));
        if (BMKeys.isHoldingShift()) tooltip.add(new TranslationTextComponent("tooltip.backmath.empty"));
        if (BMKeys.isHoldingShift()) tooltip.add(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".mid_term"));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}
