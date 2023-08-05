package com.sophicreeper.backmath.core.world.effect;

import com.sophicreeper.backmath.core.client.BackMath;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BMMobEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, BackMath.MOD_ID);

    public static final RegistryObject<MobEffect> PATIENCE = MOB_EFFECTS.register("patience", PatienceTeaEffect::new);
    public static final RegistryObject<MobEffect> DISGUST = MOB_EFFECTS.register("disgust", DisgustTeaEffect::new);
    public static final RegistryObject<MobEffect> MOOD = MOB_EFFECTS.register("mood", MoodTeaEffect::new);
}
