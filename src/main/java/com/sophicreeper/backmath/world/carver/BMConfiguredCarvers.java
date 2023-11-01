package com.sophicreeper.backmath.world.carver;

import com.sophicreeper.backmath.BackMath;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ICarverConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class BMConfiguredCarvers {
    public static final ConfiguredCarver<ProbabilityConfig> ALJAN_UNDERWATER_CAVE = register("aljan_underwater_cave", BMWorldCarvers.ALJAN_UNDERWATER_CAVE.get().func_242761_a(new ProbabilityConfig(0.06666667f)));
    public static final ConfiguredCarver<ProbabilityConfig> ALJAN_CAVE = register("aljan_cave", BMWorldCarvers.ALJAN_CAVE.get().func_242761_a(new ProbabilityConfig(0.14285715f)));
    public static final ConfiguredCarver<ProbabilityConfig> ALJAN_RAVINE = register("aljan_ravine", BMWorldCarvers.ALJAN_RAVINE.get().func_242761_a(new ProbabilityConfig(0.02f)));

    private static <WC extends ICarverConfig> ConfiguredCarver<WC> register(String name, ConfiguredCarver<WC> carver) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_CARVER, BackMath.resourceLoc(name), carver);
    }

    public static void register() {}
}
