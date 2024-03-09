package com.sophicreeper.backmath.crystallizer.item;

import com.sophicreeper.backmath.crystallizer.dispenser.CrystallizerMoldDispenseBehavior;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.Item;

public class MoldItem extends Item {
    public MoldItem(String type, Properties properties) {
        super(properties);
        DispenserBlock.registerDispenseBehavior(this, new CrystallizerMoldDispenseBehavior(type));
    }
}
