package com.sophicreeper.backmath.core.world.effect;

import com.sophicreeper.backmath.core.client.BackMath;
import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BMEffects {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, BackMath.MOD_ID);

    public static final RegistryObject<Effect> PATIENCE = EFFECTS.register("patience", PatienceTeaEffect::new);
    public static final RegistryObject<Effect> DISGUST = EFFECTS.register("disgust", DisgustTeaEffect::new);
    public static final RegistryObject<Effect> MOOD = EFFECTS.register("mood", MoodTeaEffect::new);
}
