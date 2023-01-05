package com.sophicreeper.backmath.core.world.entity.decoration;

import com.sophicreeper.backmath.core.client.BackMath;
import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BMMotives {
    public static final DeferredRegister<PaintingType> MOTIVES = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, BackMath.MOD_ID);

    // Back Math 1.6 and prior paintings
    public static final RegistryObject<PaintingType> ABROBRA_RAINBOW_BRABA = MOTIVES.register("abrobra_rainbow_braba", () -> new PaintingType(16, 16));
    public static final RegistryObject<PaintingType> ABOBRA_BRABA_OI = MOTIVES.register("abobra_braba_oi", () -> new PaintingType(16, 16));
    public static final RegistryObject<PaintingType> OI = MOTIVES.register("oi", () -> new PaintingType(16, 16));
    public static final RegistryObject<PaintingType> CRAFT_LOUD = MOTIVES.register("craft_loud", () -> new PaintingType(64, 64));
    public static final RegistryObject<PaintingType> GRADIENT = MOTIVES.register("gradient", () -> new PaintingType(16, 32));
    public static final RegistryObject<PaintingType> GRADIENT_SIDE = MOTIVES.register("gradient_side", () -> new PaintingType(32, 16));
    public static final RegistryObject<PaintingType> GRADIENT_SIDE_ALEX = MOTIVES.register("gradient_side_alex", () -> new PaintingType(32, 16));
    public static final RegistryObject<PaintingType> SAREPOCA = MOTIVES.register("sarepoca", () -> new PaintingType(32, 16));

    // Back Math 1.7 paintings
    public static final RegistryObject<PaintingType> SUNS_BIG = MOTIVES.register("suns_big", () -> new PaintingType(32, 16));
    public static final RegistryObject<PaintingType> ORIGINAL_CONCEPT = MOTIVES.register("original_concept", () -> new PaintingType(32, 16));

    // Back Math 1.8 paintings
    public static final RegistryObject<PaintingType> BATTLE_PLATFORM = MOTIVES.register("battle_platform", () -> new PaintingType(32, 16));
}
