package com.sophicreeper.backmath.item.custom.weapon;

import static com.sophicreeper.backmath.config.BMConfigs.COMMON_CONFIGS;

public class AngelicBowItem extends BMBowItem {
    public AngelicBowItem(Properties properties) {
        super(COMMON_CONFIGS.angelicBowFCA.get(), COMMON_CONFIGS.angelicBowCBD.get(), COMMON_CONFIGS.angelicBowAAD.get(), COMMON_CONFIGS.angelicBowFIT.get(), COMMON_CONFIGS.angelicBowFRD.get(), properties);
    }
}
