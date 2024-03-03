package com.sophicreeper.backmath.item.custom;

import com.sophicreeper.backmath.block.dispenser.vanilla.BucketDispenseBehavior;
import net.minecraft.block.DispenserBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;

import java.util.function.Supplier;

public class BMBucketItem extends BucketItem {
    public BMBucketItem(Supplier<? extends Fluid> fluid, Properties properties) {
        super(fluid, properties);
        DispenserBlock.registerDispenseBehavior(this, new BucketDispenseBehavior());
    }
}
