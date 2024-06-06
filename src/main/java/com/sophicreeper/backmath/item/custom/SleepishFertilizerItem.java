package com.sophicreeper.backmath.item.custom;

import com.sophicreeper.backmath.dispenser.vanilla.BoneMealDispenseBehavior;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.BoneMealItem;

public class SleepishFertilizerItem extends BoneMealItem {
    public SleepishFertilizerItem(Properties properties) {
        super(properties);
        DispenserBlock.registerBehavior(this, new BoneMealDispenseBehavior());
    }
}
