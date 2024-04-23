package com.sophicreeper.backmath.crystallizer.item;

import com.sophicreeper.backmath.crystallizer.dispenser.CrystallizerRecipesDispenseBehavior;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GlisteringCrystallizerMaterialItem extends Item {
    public GlisteringCrystallizerMaterialItem(Properties properties) {
        super(properties);
        DispenserBlock.registerBehavior(this, new CrystallizerRecipesDispenseBehavior());
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
