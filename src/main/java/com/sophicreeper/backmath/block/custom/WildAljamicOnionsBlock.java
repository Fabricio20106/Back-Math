package com.sophicreeper.backmath.block.custom;

import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.util.IItemProvider;

public class WildAljamicOnionsBlock extends AbstractWildCropBlock {
    public WildAljamicOnionsBlock(Properties properties) {
        super(properties);
    }

    @Override
    public IItemProvider getSeedItem() {
        return AxolotlTest.ALJAMIC_ONION.get();
    }
}
