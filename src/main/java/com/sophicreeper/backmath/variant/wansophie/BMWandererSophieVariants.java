package com.sophicreeper.backmath.variant.wansophie;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.misc.BMRegistries;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import static com.sophicreeper.backmath.BackMath.backMath;

public class BMWandererSophieVariants {
    public static final DeferredRegister<WandererSophieVariant> VARIANTS = DeferredRegister.create(BMRegistries.WANDERER_SOPHIE_VARIANT, BackMath.MOD_ID);

    public static final RegistryObject<WandererSophieVariant> YELLOW_AXOLOTL = VARIANTS.register("yellow_axolotl", () -> new WandererSophieVariant(backMath("yellow_axolotl"), backMath("entity/sophie/wanderer/yellow_axolotl"), true));
    public static final RegistryObject<WandererSophieVariant> CYAN_AXOLOTL = VARIANTS.register("cyan_axolotl", () -> new WandererSophieVariant(backMath("cyan_axolotl"), backMath("entity/sophie/wanderer/cyan_axolotl"), true));
    public static final RegistryObject<WandererSophieVariant> CREEPER = VARIANTS.register("creeper", () -> new WandererSophieVariant(backMath("creeper"), backMath("entity/sophie/wanderer/creeper"), true));
    public static final RegistryObject<WandererSophieVariant> MODIFIED = VARIANTS.register("modified", () -> new WandererSophieVariant(backMath("modified"), backMath("entity/sophie/wanderer/modified"), true));
    public static final RegistryObject<WandererSophieVariant> ORIGINAL = VARIANTS.register("original", () -> new WandererSophieVariant(backMath("original"), backMath("entity/sophie/wanderer/original"), true));
    public static final RegistryObject<WandererSophieVariant> SAVANNAH = VARIANTS.register("savannah", () -> new WandererSophieVariant(backMath("savannah"), backMath("entity/sophie/wanderer/savannah"), true));
    public static final RegistryObject<WandererSophieVariant> BRAZIL_SHIRT = VARIANTS.register("brazil_shirt", () -> new WandererSophieVariant(backMath("brazil_shirt"), backMath("entity/sophie/wanderer/brazil_shirt"), true));
    public static final RegistryObject<WandererSophieVariant> PAJAMA = VARIANTS.register("pajama", () -> new WandererSophieVariant(backMath("pajama"), backMath("entity/sophie/wanderer/pajama"), true));
    public static final RegistryObject<WandererSophieVariant> WITCHER = VARIANTS.register("witcher", () -> new WandererSophieVariant(backMath("witcher"), backMath("entity/sophie/wanderer/witcher"), true));
    public static final RegistryObject<WandererSophieVariant> MAID = VARIANTS.register("maid", () -> new WandererSophieVariant(backMath("maid"), backMath("entity/sophie/wanderer/maid"), true));
    public static final RegistryObject<WandererSophieVariant> ENDER = VARIANTS.register("ender", () -> new WandererSophieVariant(backMath("ender"), backMath("entity/sophie/wanderer/ender"), true));
    public static final RegistryObject<WandererSophieVariant> WORKER = VARIANTS.register("worker", () -> new WandererSophieVariant(backMath("worker"), backMath("entity/sophie/wanderer/worker"), true));
    public static final RegistryObject<WandererSophieVariant> BLUE_AXOLOTL = VARIANTS.register("blue_axolotl", () -> new WandererSophieVariant(backMath("blue_axolotl"), backMath("entity/sophie/wanderer/blue_axolotl"), true));
    public static final RegistryObject<WandererSophieVariant> CYAN_AXOLOTL_2 = VARIANTS.register("cyan_axolotl_2", () -> new WandererSophieVariant(backMath("cyan_axolotl_2"), backMath("entity/sophie/wanderer/cyan_axolotl_2"), true));
    public static final RegistryObject<WandererSophieVariant> EMPRESARY2 = VARIANTS.register("empresary2", () -> new WandererSophieVariant(backMath("empresary2"), backMath("entity/sophie/wanderer/empresary2"), true));
    public static final RegistryObject<WandererSophieVariant> ENTREPRENEUR = VARIANTS.register("entrepreneur", () -> new WandererSophieVariant(backMath("entrepreneur"), backMath("entity/sophie/wanderer/entrepreneur"), true));
    public static final RegistryObject<WandererSophieVariant> FARMER = VARIANTS.register("farmer", () -> new WandererSophieVariant(backMath("farmer"), backMath("entity/sophie/wanderer/farmer"), true));
    public static final RegistryObject<WandererSophieVariant> SWIMSUIT = VARIANTS.register("swimsuit", () -> new WandererSophieVariant(backMath("swimsuit"), backMath("entity/sophie/wanderer/swimsuit"), true, false));
    public static final RegistryObject<WandererSophieVariant> GREEN_HOODIE = VARIANTS.register("green_hoodie", () -> new WandererSophieVariant(backMath("green_hoodie"), backMath("entity/sophie/wanderer/green_hoodie"), true, false));
    public static final RegistryObject<WandererSophieVariant> ROUND_SIX = VARIANTS.register("round_six", () -> new WandererSophieVariant(backMath("round_six"), backMath("entity/sophie/wanderer/round_six"), true, false));
}
