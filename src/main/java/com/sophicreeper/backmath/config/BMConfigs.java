package com.sophicreeper.backmath.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class BMConfigs {
    public static final BMCommonConfigs COMMON_CONFIGS;
    public static final ForgeConfigSpec COMMON_SPEC;

    static {
        final Pair<BMCommonConfigs, ForgeConfigSpec> serverConfigPair = new ForgeConfigSpec.Builder().configure(BMCommonConfigs::new);

        COMMON_CONFIGS = serverConfigPair.getLeft();
        COMMON_SPEC = serverConfigPair.getRight();
    }

    public static void init() {}
}
