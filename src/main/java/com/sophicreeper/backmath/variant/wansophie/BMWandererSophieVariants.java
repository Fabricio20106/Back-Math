package com.sophicreeper.backmath.variant.wansophie;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.misc.BMRegistries;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import static com.sophicreeper.backmath.BackMath.backMath;

public class BMWandererSophieVariants {
    public static final DeferredRegister<WandererSophieVariant> VARIANTS = DeferredRegister.create(BMRegistries.WANDERER_SOPHIE_VARIANT, BackMath.MOD_ID);

    public static final RegistryObject<WandererSophieVariant> YELLOW_AXOLOTL = VARIANTS.register("yellow_axolotl", () -> new WandererSophieVariant(backMath("entity/sophie/wanderer/yellow_axolotl"), true));
    public static final RegistryObject<WandererSophieVariant> CYAN_AXOLOTL = VARIANTS.register("cyan_axolotl", () -> new WandererSophieVariant(backMath("entity/sophie/wanderer/cyan_axolotl"), true));
    public static final RegistryObject<WandererSophieVariant> CREEPER = VARIANTS.register("creeper", () -> new WandererSophieVariant(backMath("entity/sophie/wanderer/creeper"), true));
    public static final RegistryObject<WandererSophieVariant> MODIFIED = VARIANTS.register("modified", () -> new WandererSophieVariant(backMath("entity/sophie/wanderer/modified"), true));
    public static final RegistryObject<WandererSophieVariant> ORIGINAL = VARIANTS.register("original", () -> new WandererSophieVariant(backMath("entity/sophie/wanderer/original"), true));
    public static final RegistryObject<WandererSophieVariant> SAVANNAH = VARIANTS.register("savannah", () -> new WandererSophieVariant(backMath("entity/sophie/wanderer/savannah"), true));
    public static final RegistryObject<WandererSophieVariant> BRAZIL_SHIRT = VARIANTS.register("brazil_shirt", () -> new WandererSophieVariant(backMath("entity/sophie/wanderer/brazil_shirt"), true));
    public static final RegistryObject<WandererSophieVariant> PAJAMA = VARIANTS.register("pajama", () -> new WandererSophieVariant(backMath("entity/sophie/wanderer/pajama"), true));
    public static final RegistryObject<WandererSophieVariant> WITCHER = VARIANTS.register("witcher", () -> new WandererSophieVariant(backMath("entity/sophie/wanderer/witcher"), true));
    public static final RegistryObject<WandererSophieVariant> MAID = VARIANTS.register("maid", () -> new WandererSophieVariant(backMath("entity/sophie/wanderer/maid"), true));
    public static final RegistryObject<WandererSophieVariant> ENDER = VARIANTS.register("ender", () -> new WandererSophieVariant(backMath("entity/sophie/wanderer/ender"), true));
    public static final RegistryObject<WandererSophieVariant> WORKER = VARIANTS.register("worker", () -> new WandererSophieVariant(backMath("entity/sophie/wanderer/worker"), true));
    public static final RegistryObject<WandererSophieVariant> BLUE_AXOLOTL = VARIANTS.register("blue_axolotl", () -> new WandererSophieVariant(backMath("entity/sophie/wanderer/blue_axolotl"), true));
    public static final RegistryObject<WandererSophieVariant> CYAN_AXOLOTL_2 = VARIANTS.register("cyan_axolotl_2", () -> new WandererSophieVariant(backMath("entity/sophie/wanderer/cyan_axolotl_2"), true));
    public static final RegistryObject<WandererSophieVariant> EMPRESARY2 = VARIANTS.register("empresary2", () -> new WandererSophieVariant(backMath("entity/sophie/wanderer/empresary2"), true));
    public static final RegistryObject<WandererSophieVariant> ENTREPRENEUR = VARIANTS.register("entrepreneur", () -> new WandererSophieVariant(backMath("entity/sophie/wanderer/entrepreneur"), true));
}
