package com.sophicreeper.backmath.item.custom;

import com.sophicreeper.backmath.block.dispenser.vanilla.BoneMealDispenseBehavior;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.BoneMealItem;

public class SleepishFertilizerItem extends BoneMealItem {
    public SleepishFertilizerItem(Properties properties) {
        super(properties);
        DispenserBlock.registerDispenseBehavior(this, new BoneMealDispenseBehavior());
    }
}
