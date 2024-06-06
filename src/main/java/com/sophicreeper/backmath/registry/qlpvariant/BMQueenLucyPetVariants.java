package com.sophicreeper.backmath.registry.qlpvariant;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.registry.BMRegistries;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class BMQueenLucyPetVariants {
    public static final DeferredRegister<QueenLucyPetVariant> VARIANTS = DeferredRegister.create(BMRegistries.QUEEN_LUCY_PET_VARIANT, BackMath.MOD_ID);

    public static final RegistryObject<QueenLucyPetVariant> CURRENT = VARIANTS.register("current", () -> new QueenLucyPetVariant(BackMath.resourceLoc("current")));
    public static final RegistryObject<QueenLucyPetVariant> ALTERNATE = VARIANTS.register("alternate", () -> new QueenLucyPetVariant(BackMath.resourceLoc("alternate")));
    public static final RegistryObject<QueenLucyPetVariant> RELIC = VARIANTS.register("relic", () -> new QueenLucyPetVariant(BackMath.resourceLoc("relic")));
    public static final RegistryObject<QueenLucyPetVariant> SHY_FABRICIO = VARIANTS.register("shy_fabricio", () -> new QueenLucyPetVariant(BackMath.resourceLoc("shy_fabricio")));
    public static final RegistryObject<QueenLucyPetVariant> SV_ORIGINAL = VARIANTS.register("sv_original", () -> new QueenLucyPetVariant(BackMath.resourceLoc("sv_original")));
    public static final RegistryObject<QueenLucyPetVariant> SV_MODIFIED = VARIANTS.register("sv_modified", () -> new QueenLucyPetVariant(BackMath.resourceLoc("sv_modified")));
    public static final RegistryObject<QueenLucyPetVariant> SV_CREEPER = VARIANTS.register("sv_creeper", () -> new QueenLucyPetVariant(BackMath.resourceLoc("sv_creeper")));
    public static final RegistryObject<QueenLucyPetVariant> SV_BRAZIL_SHIRT = VARIANTS.register("sv_brazil_shirt", () -> new QueenLucyPetVariant(BackMath.resourceLoc("sv_brazil_shirt")));
    public static final RegistryObject<QueenLucyPetVariant> SV_PAJAMA = VARIANTS.register("sv_pajama", () -> new QueenLucyPetVariant(BackMath.resourceLoc("sv_pajama")));
    public static final RegistryObject<QueenLucyPetVariant> SV_SAVANNAH = VARIANTS.register("sv_savannah", () -> new QueenLucyPetVariant(BackMath.resourceLoc("sv_savannah")));
    public static final RegistryObject<QueenLucyPetVariant> SV_WITCHER = VARIANTS.register("sv_witcher", () -> new QueenLucyPetVariant(BackMath.resourceLoc("sv_witcher")));
    public static final RegistryObject<QueenLucyPetVariant> SV_MAID = VARIANTS.register("sv_maid", () -> new QueenLucyPetVariant(BackMath.resourceLoc("sv_maid")));
    public static final RegistryObject<QueenLucyPetVariant> SV_YELLOW_AXOLOTL = VARIANTS.register("sv_yellow_axolotl", () -> new QueenLucyPetVariant(BackMath.resourceLoc("sv_yellow_axolotl")));
    public static final RegistryObject<QueenLucyPetVariant> SV_CYAN_AXOLOTL = VARIANTS.register("sv_cyan_axolotl", () -> new QueenLucyPetVariant(BackMath.resourceLoc("sv_blue_axolotl")));
    public static final RegistryObject<QueenLucyPetVariant> SV_ENDER = VARIANTS.register("sv_ender", () -> new QueenLucyPetVariant(BackMath.resourceLoc("sv_ender")));
    public static final RegistryObject<QueenLucyPetVariant> SV_WORKER = VARIANTS.register("sv_worker", () -> new QueenLucyPetVariant(BackMath.resourceLoc("sv_worker")));
    public static final RegistryObject<QueenLucyPetVariant> SV_EMPRESARY2 = VARIANTS.register("sv_empresary2", () -> new QueenLucyPetVariant(BackMath.resourceLoc("sv_empresary2")));
    public static final RegistryObject<QueenLucyPetVariant> SV_ENTREPRENEUR = VARIANTS.register("sv_entrepreneur", () -> new QueenLucyPetVariant(BackMath.resourceLoc("sv_entrepreneur")));
    public static final RegistryObject<QueenLucyPetVariant> SV_BLUE_AXOLOTL = VARIANTS.register("sv_blue_axolotl", () -> new QueenLucyPetVariant(BackMath.resourceLoc("sv_blue_axolotl")));
    public static final RegistryObject<QueenLucyPetVariant> SV_CYAN_AXOLOTL_2 = VARIANTS.register("sv_cyan_axolotl_2", () -> new QueenLucyPetVariant(BackMath.resourceLoc("sv_cyan_axolotl_2")));
}
