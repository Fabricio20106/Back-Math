package com.sophicreeper.backmath.item.custom;

import com.sophicreeper.backmath.dispenser.BagDispenseBehavior;
import net.minecraft.block.Block;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.BlockItem;

public class PlaceableBagItem extends BlockItem {
    public PlaceableBagItem(Block block, Properties properties) {
        super(block, properties);
        DispenserBlock.registerBehavior(this, new BagDispenseBehavior());
    }
}
