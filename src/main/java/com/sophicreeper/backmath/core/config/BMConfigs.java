package com.sophicreeper.backmath.core.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class BMConfigs {
    public static final BMServerConfigs SERVER_CONFIGS;
    public static final ForgeConfigSpec SERVER_SPEC;

    static {
        final Pair<BMServerConfigs, ForgeConfigSpec> serverConfigPair = new ForgeConfigSpec.Builder().configure(BMServerConfigs::new);

        SERVER_CONFIGS = serverConfigPair.getLeft();
        SERVER_SPEC = serverConfigPair.getRight();
    }

    public static void init() {}
}
