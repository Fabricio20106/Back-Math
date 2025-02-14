package com.sophicreeper.backmath.particle;

import com.sophicreeper.backmath.BackMath;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BMParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, BackMath.MOD_ID);

//    public static final RegistryObject<BasicParticleType> HILLARY_FLAME = PARTICLES.register("hillary_flame", () -> new BasicParticleType(false));
//    public static final RegistryObject<BasicParticleType> JANTICAL = PARTICLES.register("jantical", () -> new BasicParticleType(false));
//    public static final RegistryObject<BasicParticleType> WARMTERM = PARTICLES.register("warmterm", () -> new BasicParticleType(false));
//    public static final RegistryObject<BasicParticleType> COLDTERM = PARTICLES.register("coldterm", () -> new BasicParticleType(false));
}
