package com.sophicreeper.backmath.core.world.gen.carver;

import com.sophicreeper.backmath.core.client.BackMath;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ICarverConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class BMConfiguredCarvers {
    public static final ConfiguredCarver<ProbabilityConfig> UNDERWATER_ALJAN_CAVE = register("underwater_aljan_cave", BMWorldCarvers.UNDERWATER_ALJAN_CAVE.get().func_242761_a(new ProbabilityConfig(0.06666667f)));
    public static final ConfiguredCarver<ProbabilityConfig> ALJAN_CAVE = register("aljan_cave", BMWorldCarvers.ALJAN_CAVE.get().func_242761_a(new ProbabilityConfig(0.14285715f)));
    public static final ConfiguredCarver<ProbabilityConfig> ALJAN_CANYON = register("aljan_canyon", BMWorldCarvers.ALJAN_CANYON.get().func_242761_a(new ProbabilityConfig(0.02f)));

    private static <WC extends ICarverConfig> ConfiguredCarver<WC> register(String name, ConfiguredCarver<WC> carver) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_CARVER, BackMath.resourceLoc(name), carver);
    }

    public static void register() {}
}
