package com.sophicreeper.backmath.crystallizer.item;

import com.sophicreeper.backmath.dispenser.CrystallizerRecipesDispenseBehavior;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.Item;

public class CrystallizerMaterialItem extends Item {
    public CrystallizerMaterialItem(Properties properties) {
        super(properties);
        DispenserBlock.registerBehavior(this, new CrystallizerRecipesDispenseBehavior());
    }
}
