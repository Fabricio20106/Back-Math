package com.sophicreeper.backmath.particle;

import com.sophicreeper.backmath.BackMath;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BMParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, BackMath.MOD_ID);

    //public static final RegistryObject<ParticleType<BasicParticleType>> JANTICAL = PARTICLES.register("jantical", () -> new BasicParticleType(false));
}
