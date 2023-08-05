package com.sophicreeper.backmath.core.world.level.block;

import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.world.level.ItemLike;

public class WildAljamicOnionsBlock extends AbstractWildCropBlock {
    public WildAljamicOnionsBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ItemLike getSeedItem() {
        return AxolotlTest.ALJAMIC_ONION.get();
    }
}
