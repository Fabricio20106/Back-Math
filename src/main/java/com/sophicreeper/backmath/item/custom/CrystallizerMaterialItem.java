package com.sophicreeper.backmath.item.custom;

import com.sophicreeper.backmath.block.dispenser.CrystallizerRecipesDispenseBehavior;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.Item;

public class CrystallizerMaterialItem extends Item {
    public CrystallizerMaterialItem(Properties properties) {
        super(properties);
        DispenserBlock.registerDispenseBehavior(this, new CrystallizerRecipesDispenseBehavior());
    }
}
