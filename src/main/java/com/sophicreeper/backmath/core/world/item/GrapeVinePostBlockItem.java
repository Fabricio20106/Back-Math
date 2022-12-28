package com.sophicreeper.backmath.core.world.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class GrapeVinePostBlockItem extends BlockItem {
    public GrapeVinePostBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public int getBurnTime(ItemStack stack) {
        return 150;
    }
}
