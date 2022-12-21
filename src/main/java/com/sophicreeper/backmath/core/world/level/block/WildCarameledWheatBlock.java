package com.sophicreeper.backmath.core.world.level.block;

import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import com.sophicreeper.backmath.core.world.level.block.AbstractWildCropBlock;
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
