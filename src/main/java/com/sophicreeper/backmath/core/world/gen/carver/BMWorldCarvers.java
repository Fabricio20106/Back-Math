package com.sophicreeper.backmath.core.world.gen.carver;

import com.sophicreeper.backmath.core.client.BackMath;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BMWorldCarvers {
    public static final DeferredRegister<WorldCarver<?>> WORLD_CARVERS = DeferredRegister.create(ForgeRegistries.WORLD_CARVERS, BackMath.MOD_ID);

    public static final RegistryObject<WorldCarver<ProbabilityConfig>> UNDERWATER_ALJAN_CAVE = WORLD_CARVERS.register("underwater_aljan_cave", () -> new UnderwaterAljanCaveCarver(ProbabilityConfig.CODEC));
    public static final RegistryObject<WorldCarver<ProbabilityConfig>> ALJAN_CAVE = WORLD_CARVERS.register("aljan_cave", () -> new AljanCaveCarver(ProbabilityConfig.CODEC));
    public static final RegistryObject<WorldCarver<ProbabilityConfig>> ALJAN_CANYON = WORLD_CARVERS.register("aljan_canyon", () -> new AljanCanyonCarver(ProbabilityConfig.CODEC));
}
