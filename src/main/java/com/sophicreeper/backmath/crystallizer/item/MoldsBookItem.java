package com.sophicreeper.backmath.crystallizer.item;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.crystallizer.dispenser.CrystallizerMoldDispenseBehavior;
import com.sophicreeper.backmath.util.BMKeys;
import net.minecraft.block.DispenserBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class MoldsBookItem extends Item {
    public MoldsBookItem(Properties properties) {
        super(properties);
        DispenserBlock.registerDispenseBehavior(this, new CrystallizerMoldDispenseBehavior("book"));
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        if (!BMKeys.isHoldingShift()) tooltip.add(new TranslationTextComponent("tooltip.backmath.hold_shift.not_held"));
        if (BMKeys.isHoldingShift()) tooltip.add(new TranslationTextComponent("tooltip.backmath.hold_shift.held"));
        if (BMKeys.isHoldingShift()) tooltip.add(new TranslationTextComponent("tooltip.backmath.empty"));
        if (BMKeys.isHoldingShift()) tooltip.add(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + "." + this.getRegistryName().getPath()));
        super.addInformation(stack, world, tooltip, flag);
    }
}
