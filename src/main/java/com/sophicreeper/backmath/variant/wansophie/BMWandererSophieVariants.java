package com.sophicreeper.backmath.variant.wansophie;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.misc.BMRegistries;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import static com.sophicreeper.backmath.BackMath.resourceLoc;

public class BMWandererSophieVariants {
    public static final DeferredRegister<WandererSophieVariant> VARIANTS = DeferredRegister.create(BMRegistries.WANDERER_SOPHIE_VARIANT, BackMath.MOD_ID);

    public static final RegistryObject<WandererSophieVariant> YELLOW_AXOLOTL = VARIANTS.register("yellow_axolotl", () -> new WandererSophieVariant(resourceLoc("entity/wanderer_sophie/yellow_axolotl"), true));
    public static final RegistryObject<WandererSophieVariant> CYAN_AXOLOTL = VARIANTS.register("cyan_axolotl", () -> new WandererSophieVariant(resourceLoc("entity/wanderer_sophie/cyan_axolotl"), true));
    public static final RegistryObject<WandererSophieVariant> CREEPER = VARIANTS.register("creeper", () -> new WandererSophieVariant(resourceLoc("entity/wanderer_sophie/creeper"), true));
    public static final RegistryObject<WandererSophieVariant> MODIFIED = VARIANTS.register("modified", () -> new WandererSophieVariant(resourceLoc("entity/wanderer_sophie/modified"), true));
    public static final RegistryObject<WandererSophieVariant> ORIGINAL = VARIANTS.register("original", () -> new WandererSophieVariant(resourceLoc("entity/wanderer_sophie/original"), true));
    public static final RegistryObject<WandererSophieVariant> SAVANNAH = VARIANTS.register("savannah", () -> new WandererSophieVariant(resourceLoc("entity/wanderer_sophie/savannah"), true));
    public static final RegistryObject<WandererSophieVariant> BRAZIL_SHIRT = VARIANTS.register("brazil_shirt", () -> new WandererSophieVariant(resourceLoc("entity/wanderer_sophie/brazil_shirt"), true));
    public static final RegistryObject<WandererSophieVariant> PAJAMA = VARIANTS.register("pajama", () -> new WandererSophieVariant(resourceLoc("entity/wanderer_sophie/pajama"), true));
    public static final RegistryObject<WandererSophieVariant> WITCHER = VARIANTS.register("witcher", () -> new WandererSophieVariant(resourceLoc("entity/wanderer_sophie/witcher"), true));
    public static final RegistryObject<WandererSophieVariant> MAID = VARIANTS.register("maid", () -> new WandererSophieVariant(resourceLoc("entity/wanderer_sophie/maid"), true));
    public static final RegistryObject<WandererSophieVariant> ENDER = VARIANTS.register("ender", () -> new WandererSophieVariant(resourceLoc("entity/wanderer_sophie/ender"), true));
    public static final RegistryObject<WandererSophieVariant> WORKER = VARIANTS.register("worker", () -> new WandererSophieVariant(resourceLoc("entity/wanderer_sophie/worker"), true));
    public static final RegistryObject<WandererSophieVariant> BLUE_AXOLOTL = VARIANTS.register("blue_axolotl", () -> new WandererSophieVariant(resourceLoc("entity/wanderer_sophie/blue_axolotl"), true));
    public static final RegistryObject<WandererSophieVariant> CYAN_AXOLOTL_2 = VARIANTS.register("cyan_axolotl_2", () -> new WandererSophieVariant(resourceLoc("entity/wanderer_sophie/cyan_axolotl_2"), true));
    public static final RegistryObject<WandererSophieVariant> EMPRESARY2 = VARIANTS.register("empresary2", () -> new WandererSophieVariant(resourceLoc("entity/wanderer_sophie/empresary2"), true));
    public static final RegistryObject<WandererSophieVariant> ENTREPRENEUR = VARIANTS.register("entrepreneur", () -> new WandererSophieVariant(resourceLoc("entity/wanderer_sophie/entrepreneur"), true));
}
