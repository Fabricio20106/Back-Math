package com.sophicreeper.backmath.core.world.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class GlisteringBlockItem extends BlockItem {
    public GlisteringBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
