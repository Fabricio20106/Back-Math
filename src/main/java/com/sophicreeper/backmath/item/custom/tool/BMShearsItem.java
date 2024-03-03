package com.sophicreeper.backmath.item.custom.tool;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.BeehiveDispenseBehavior;
import net.minecraft.item.ShearsItem;

public class BMShearsItem extends ShearsItem {
    public BMShearsItem(Properties properties) {
        super(properties);
        DispenserBlock.registerDispenseBehavior(this, new BeehiveDispenseBehavior());
    }
}
