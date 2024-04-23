package com.sophicreeper.backmath.world.carver;

import com.sophicreeper.backmath.BackMath;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ICarverConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class BMConfiguredCarvers {
    public static final ConfiguredCarver<ProbabilityConfig> ALJAN_UNDERWATER_CAVE = register("aljan_underwater_cave", BMWorldCarvers.ALJAN_UNDERWATER_CAVE.get().configured(new ProbabilityConfig(0.06666667F))); // 6.666667%
    public static final ConfiguredCarver<ProbabilityConfig> ALJAN_CAVE = register("aljan_cave", BMWorldCarvers.ALJAN_CAVE.get().configured(new ProbabilityConfig(0.14285715F))); // 14.285715%
    public static final ConfiguredCarver<ProbabilityConfig> ALJAN_RAVINE = register("aljan_ravine", BMWorldCarvers.ALJAN_RAVINE.get().configured(new ProbabilityConfig(0.02F))); // 2%

    private static <WC extends ICarverConfig> ConfiguredCarver<WC> register(String name, ConfiguredCarver<WC> carver) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_CARVER, BackMath.resourceLoc(name), carver);
    }

    public static void init() {}
}
