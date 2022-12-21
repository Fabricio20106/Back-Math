package com.sophicreeper.backmath.core.world.item;

import com.sophicreeper.backmath.core.util.Keys;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;

public class CrystallizerItem extends BlockItem {
    public CrystallizerItem(RegistryObject<Block> blockIn, Properties builder) {
        super(blockIn.get(), builder);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (!Keys.isHoldingShift()) tooltip.add(new TranslationTextComponent("messages.backmath.hold_shift"));
        if (Keys.isHoldingShift()) tooltip.add(new TranslationTextComponent(this.getTranslationKey() + ".desc"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
