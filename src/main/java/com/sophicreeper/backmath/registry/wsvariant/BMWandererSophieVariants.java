package com.sophicreeper.backmath.registry.wsvariant;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.registry.BMRegistries;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class BMWandererSophieVariants {
    public static final DeferredRegister<WandererSophieVariant> VARIANTS = DeferredRegister.create(BMRegistries.WANDERER_SOPHIE_VARIANT, BackMath.MOD_ID);

    public static final RegistryObject<WandererSophieVariant> YELLOW_AXOLOTL = VARIANTS.register("yellow_axolotl", () -> new WandererSophieVariant(BackMath.resourceLoc("yellow_axolotl"), true));
    public static final RegistryObject<WandererSophieVariant> CYAN_AXOLOTL = VARIANTS.register("cyan_axolotl", () -> new WandererSophieVariant(BackMath.resourceLoc("cyan_axolotl"), true));
    public static final RegistryObject<WandererSophieVariant> CREEPER = VARIANTS.register("creeper", () -> new WandererSophieVariant(BackMath.resourceLoc("creeper"), true));
    public static final RegistryObject<WandererSophieVariant> MODIFIED = VARIANTS.register("modified", () -> new WandererSophieVariant(BackMath.resourceLoc("modified"), true));
    public static final RegistryObject<WandererSophieVariant> ORIGINAL = VARIANTS.register("original", () -> new WandererSophieVariant(BackMath.resourceLoc("original"), true));
    public static final RegistryObject<WandererSophieVariant> SAVANNAH = VARIANTS.register("savannah", () -> new WandererSophieVariant(BackMath.resourceLoc("savannah"), true));
    public static final RegistryObject<WandererSophieVariant> BRAZIL_SHIRT = VARIANTS.register("brazil_shirt", () -> new WandererSophieVariant(BackMath.resourceLoc("brazil_shirt"), true));
    public static final RegistryObject<WandererSophieVariant> PAJAMA = VARIANTS.register("pajama", () -> new WandererSophieVariant(BackMath.resourceLoc("pajama"), true));
    public static final RegistryObject<WandererSophieVariant> WITCHER = VARIANTS.register("witcher", () -> new WandererSophieVariant(BackMath.resourceLoc("witcher"), true));
    public static final RegistryObject<WandererSophieVariant> MAID = VARIANTS.register("maid", () -> new WandererSophieVariant(BackMath.resourceLoc("maid"), true));
    public static final RegistryObject<WandererSophieVariant> ENDER = VARIANTS.register("ender", () -> new WandererSophieVariant(BackMath.resourceLoc("ender"), true));
    public static final RegistryObject<WandererSophieVariant> WORKER = VARIANTS.register("worker", () -> new WandererSophieVariant(BackMath.resourceLoc("worker"), true));
    public static final RegistryObject<WandererSophieVariant> BLUE_AXOLOTL = VARIANTS.register("blue_axolotl", () -> new WandererSophieVariant(BackMath.resourceLoc("blue_axolotl"), true));
    public static final RegistryObject<WandererSophieVariant> CYAN_AXOLOTL_2 = VARIANTS.register("cyan_axolotl_2", () -> new WandererSophieVariant(BackMath.resourceLoc("cyan_axolotl_2"), true));
    public static final RegistryObject<WandererSophieVariant> EMPRESARY2 = VARIANTS.register("empresary2", () -> new WandererSophieVariant(BackMath.resourceLoc("empresary2"), true));
    public static final RegistryObject<WandererSophieVariant> ENTREPRENEUR = VARIANTS.register("entrepreneur", () -> new WandererSophieVariant(BackMath.resourceLoc("entrepreneur"), true));
}
