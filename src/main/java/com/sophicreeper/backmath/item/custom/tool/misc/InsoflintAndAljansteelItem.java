package com.sophicreeper.backmath.item.custom.tool.misc;

import com.sophicreeper.backmath.dispenser.IAADispenseBehavior;
import net.minecraft.block.*;
import net.minecraft.item.FlintAndSteelItem;

public class InsoflintAndAljansteelItem extends FlintAndSteelItem {
    public InsoflintAndAljansteelItem(Properties properties) {
        super(properties);
        DispenserBlock.registerBehavior(this, new IAADispenseBehavior());
    }
}
