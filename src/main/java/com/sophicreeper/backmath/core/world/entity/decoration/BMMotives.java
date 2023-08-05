package com.sophicreeper.backmath.core.world.entity.decoration;

import com.sophicreeper.backmath.core.client.BackMath;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BMMotives {
    public static final DeferredRegister<PaintingVariant> MOTIVES = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, BackMath.MOD_ID);

    // Back Math 1.6 and prior paintings
    public static final RegistryObject<PaintingVariant> ABROBRA_RAINBOW_BRABA = MOTIVES.register("abrobra_rainbow_braba", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> ABOBRA_BRABA_OI = MOTIVES.register("abobra_braba_oi", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> OI = MOTIVES.register("oi", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> CRAFT_LOUD = MOTIVES.register("craft_loud", () -> new PaintingVariant(64, 64));
    public static final RegistryObject<PaintingVariant> GRADIENT = MOTIVES.register("gradient", () -> new PaintingVariant(16, 32));
    public static final RegistryObject<PaintingVariant> GRADIENT_SIDE = MOTIVES.register("gradient_side", () -> new PaintingVariant(32, 16));
    public static final RegistryObject<PaintingVariant> GRADIENT_SIDE_ALEX = MOTIVES.register("gradient_side_alex", () -> new PaintingVariant(32, 16));
    public static final RegistryObject<PaintingVariant> SAREPOCA = MOTIVES.register("sarepoca", () -> new PaintingVariant(32, 16));

    // Back Math 1.7 paintings
    public static final RegistryObject<PaintingVariant> SUNS_BIG = MOTIVES.register("suns_big", () -> new PaintingVariant(32, 16));
    public static final RegistryObject<PaintingVariant> ORIGINAL_CONCEPT = MOTIVES.register("original_concept", () -> new PaintingVariant(32, 16));

    // Back Math 1.8 paintings
    public static final RegistryObject<PaintingVariant> BATTLE_PLATFORM = MOTIVES.register("battle_platform", () -> new PaintingVariant(32, 16));
}
