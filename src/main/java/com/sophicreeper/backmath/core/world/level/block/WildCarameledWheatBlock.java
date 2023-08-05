package com.sophicreeper.backmath.core.world.level.block;

import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.world.level.ItemLike;

public class WildCarameledWheatBlock extends AbstractWildCropBlock {
    public WildCarameledWheatBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ItemLike getSeedItem() {
        return AxolotlTest.CARAMELED_WHEAT_SEEDS.get();
    }
}
