package com.sophicreeper.backmath.item.custom.weapon;

import static com.sophicreeper.backmath.config.BMConfigs.COMMON_CONFIGS;

public class DevilBowItem extends BMBowItem {
    public DevilBowItem(Properties properties) {
        super(COMMON_CONFIGS.devilBowFCA.get(), COMMON_CONFIGS.devilBowCBD.get(), COMMON_CONFIGS.devilBowAAD.get(), COMMON_CONFIGS.devilBowFIT.get(),
                COMMON_CONFIGS.devilBowFRD.get(), properties);
    }
}
