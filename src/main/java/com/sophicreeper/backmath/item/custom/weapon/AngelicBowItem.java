package com.sophicreeper.backmath.item.custom.weapon;

import static com.sophicreeper.backmath.config.BMConfigs.SERVER_CONFIGS;

public class AngelicBowItem extends BMBowItem{
    public AngelicBowItem(Properties properties) {
        super(SERVER_CONFIGS.angelicBowFCA.get(), SERVER_CONFIGS.angelicBowCBD.get(), SERVER_CONFIGS.angelicBowAAD.get(), SERVER_CONFIGS.angelicBowFIT.get(),
                SERVER_CONFIGS.angelicBowFRD.get(), properties);
    }
}
