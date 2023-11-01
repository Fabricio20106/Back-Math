package com.sophicreeper.backmath.block.custom;

import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.util.IItemProvider;

public class WildCarameledWheatBlock extends AbstractWildCropBlock {
    public WildCarameledWheatBlock(Properties properties) {
        super(properties);
    }

    @Override
    public IItemProvider getSeedItem() {
        return AxolotlTest.CARAMELED_WHEAT_SEEDS.get();
    }
}
