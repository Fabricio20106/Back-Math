package com.sophicreeper.backmath.misc;

import com.sophicreeper.backmath.BackMath;
import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BMPaintings {
    public static final DeferredRegister<PaintingType> PAINTINGS = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, BackMath.MOD_ID);

    // Back Math 1.6 and prior paintings
    public static final RegistryObject<PaintingType> ABROBRA_RAINBOW_BRABA = PAINTINGS.register("abrobra_rainbow_braba", () -> new PaintingType(16, 16));
    public static final RegistryObject<PaintingType> ABOBRA_BRABA_OI = PAINTINGS.register("abobra_braba_oi", () -> new PaintingType(16, 16));
    public static final RegistryObject<PaintingType> OI = PAINTINGS.register("oi", () -> new PaintingType(16, 16));
    public static final RegistryObject<PaintingType> CRAFT_LOUD = PAINTINGS.register("craft_loud", () -> new PaintingType(64, 64));
    public static final RegistryObject<PaintingType> GRADIENT = PAINTINGS.register("gradient", () -> new PaintingType(16, 32));
    public static final RegistryObject<PaintingType> GRADIENT_SIDE = PAINTINGS.register("gradient_side", () -> new PaintingType(32, 16));
    public static final RegistryObject<PaintingType> GRADIENT_SIDE_ALEX = PAINTINGS.register("gradient_side_alex", () -> new PaintingType(32, 16));
    public static final RegistryObject<PaintingType> SAREPOCA = PAINTINGS.register("sarepoca", () -> new PaintingType(32, 16));

    // Back Math 1.7 paintings
    public static final RegistryObject<PaintingType> SUNS_BIG = PAINTINGS.register("suns_big", () -> new PaintingType(32, 16));
    public static final RegistryObject<PaintingType> ORIGINAL_CONCEPT = PAINTINGS.register("original_concept", () -> new PaintingType(32, 16));

    // Back Math 1.8 paintings
    public static final RegistryObject<PaintingType> BATTLE_PLATFORM = PAINTINGS.register("battle_platform", () -> new PaintingType(32, 16));
    public static final RegistryObject<PaintingType> EEF = PAINTINGS.register("eef", () -> new PaintingType(16, 16));
    public static final RegistryObject<PaintingType> ALL_POWERFUL_FABRICIO = PAINTINGS.register("all_powerful_fabricio", () -> new PaintingType(32, 16));
}
