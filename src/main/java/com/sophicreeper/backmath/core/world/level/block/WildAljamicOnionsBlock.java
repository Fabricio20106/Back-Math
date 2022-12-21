package com.sophicreeper.backmath.core.world.level.block;

import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import com.sophicreeper.backmath.core.world.level.block.AbstractWildCropBlock;
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
