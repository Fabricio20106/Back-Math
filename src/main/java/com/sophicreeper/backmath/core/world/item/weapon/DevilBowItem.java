package com.sophicreeper.backmath.core.world.item.weapon;

import static com.sophicreeper.backmath.core.config.BMConfigs.SERVER_CONFIGS;

public class DevilBowItem extends BMBowItem {
    public DevilBowItem(Properties properties) {
        super(SERVER_CONFIGS.devilBowFCA.get(), SERVER_CONFIGS.devilBowCBD.get(), SERVER_CONFIGS.devilBowAAD.get(), SERVER_CONFIGS.devilBowFIT.get(),
                SERVER_CONFIGS.devilBowFRD.get(), properties);
    }
}
