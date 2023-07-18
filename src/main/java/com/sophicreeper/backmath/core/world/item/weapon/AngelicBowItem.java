package com.sophicreeper.backmath.core.world.item.weapon;

import static com.sophicreeper.backmath.core.config.BMConfigs.SERVER_CONFIGS;

public class AngelicBowItem extends BMBowItem{
    public AngelicBowItem(Properties properties) {
        super(SERVER_CONFIGS.angelicBowFCA.get(), SERVER_CONFIGS.angelicBowCBD.get(), SERVER_CONFIGS.angelicBowAAD.get(), SERVER_CONFIGS.angelicBowFIT.get(),
                SERVER_CONFIGS.angelicBowFRD.get(), properties);
    }
}
