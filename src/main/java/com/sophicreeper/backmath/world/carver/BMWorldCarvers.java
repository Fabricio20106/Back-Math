package com.sophicreeper.backmath.world.carver;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.world.carver.custom.AljanCaveCarver;
import com.sophicreeper.backmath.world.carver.custom.AljanRavineCarver;
import com.sophicreeper.backmath.world.carver.custom.AljanUnderwaterCaveCarver;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BMWorldCarvers {
    public static final DeferredRegister<WorldCarver<?>> WORLD_CARVERS = DeferredRegister.create(ForgeRegistries.WORLD_CARVERS, BackMath.MOD_ID);

    public static final RegistryObject<WorldCarver<ProbabilityConfig>> ALJAN_UNDERWATER_CAVE = WORLD_CARVERS.register("aljan_underwater_cave", () -> new AljanUnderwaterCaveCarver(ProbabilityConfig.CODEC));
    public static final RegistryObject<WorldCarver<ProbabilityConfig>> ALJAN_CAVE = WORLD_CARVERS.register("aljan_cave", () -> new AljanCaveCarver(ProbabilityConfig.CODEC));
    public static final RegistryObject<WorldCarver<ProbabilityConfig>> ALJAN_RAVINE = WORLD_CARVERS.register("aljan_ravine", () -> new AljanRavineCarver(ProbabilityConfig.CODEC));
}
