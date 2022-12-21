package com.sophicreeper.backmath.core.world.item.glistering;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class GlisteringBlockItem extends BlockItem {
    public GlisteringBlockItem(Block blockIn, Properties builder) {
        super(blockIn, builder);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
