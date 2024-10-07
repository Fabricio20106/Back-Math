package com.sophicreeper.backmath.variant.queenlucypet;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.misc.BMRegistries;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import static com.sophicreeper.backmath.BackMath.backMath;

public class BMQueenLucyPetVariants {
    public static final DeferredRegister<QueenLucyPetVariant> VARIANTS = DeferredRegister.create(BMRegistries.QUEEN_LUCY_PET_VARIANT, BackMath.MOD_ID);

    public static final RegistryObject<QueenLucyPetVariant> CURRENT = VARIANTS.register("current", () -> new QueenLucyPetVariant(backMath("current"), new TranslationTextComponent("entity.backmath.queen_lucy_pet.current"), backMath("entity/queen_lucy_pet/qsp_current")));
    public static final RegistryObject<QueenLucyPetVariant> ALTERNATE = VARIANTS.register("alternate", () -> new QueenLucyPetVariant(backMath("alternate"), new TranslationTextComponent("entity.backmath.queen_lucy_pet.alternate"), backMath("entity/queen_lucy_pet/qsp_alt")));
    public static final RegistryObject<QueenLucyPetVariant> RELIC = VARIANTS.register("relic", () -> new QueenLucyPetVariant(backMath("relic"), new TranslationTextComponent("entity.backmath.queen_lucy_pet.relic"), backMath("entity/queen_lucy_pet/qsp_relic")));
    public static final RegistryObject<QueenLucyPetVariant> SHY_FABRICIO = VARIANTS.register("shy_fabricio", () -> new QueenLucyPetVariant(backMath("shy_fabricio"), new TranslationTextComponent("entity.backmath.queen_lucy_pet.shy_fabricio"), backMath("entity/queen_lucy_pet/qsp_shy_fabricio")));
    public static final RegistryObject<QueenLucyPetVariant> SV_ORIGINAL = VARIANTS.register("sv_original", () -> new QueenLucyPetVariant(backMath("sv_original"), new TranslationTextComponent("entity.backmath.queen_lucy_pet.sv_original"), backMath("entity/queen_lucy_pet/qsp_sv_original")));
    public static final RegistryObject<QueenLucyPetVariant> SV_MODIFIED = VARIANTS.register("sv_modified", () -> new QueenLucyPetVariant(backMath("sv_modified"), new TranslationTextComponent("entity.backmath.queen_lucy_pet.sv_modified"), backMath("entity/queen_lucy_pet/qsp_sv_modified")));
    public static final RegistryObject<QueenLucyPetVariant> SV_CREEPER = VARIANTS.register("sv_creeper", () -> new QueenLucyPetVariant(backMath("sv_creeper"), new TranslationTextComponent("entity.backmath.queen_lucy_pet.sv_creeper"), backMath("entity/queen_lucy_pet/qsp_sv_creeper")));
    public static final RegistryObject<QueenLucyPetVariant> SV_BRAZIL_SHIRT = VARIANTS.register("sv_brazil_shirt", () -> new QueenLucyPetVariant(backMath("sv_brazil_shirt"), new TranslationTextComponent("entity.backmath.queen_lucy_pet.sv_brazil_shirt"), backMath("entity/queen_lucy_pet/qsp_sv_brazil_shirt")));
    public static final RegistryObject<QueenLucyPetVariant> SV_PAJAMA = VARIANTS.register("sv_pajama", () -> new QueenLucyPetVariant(backMath("sv_pajama"), new TranslationTextComponent("entity.backmath.queen_lucy_pet.sv_pajama"), backMath("entity/queen_lucy_pet/qsp_sv_pajama")));
    public static final RegistryObject<QueenLucyPetVariant> SV_SAVANNAH = VARIANTS.register("sv_savannah", () -> new QueenLucyPetVariant(backMath("sv_savannah"), new TranslationTextComponent("entity.backmath.queen_lucy_pet.sv_savannah"), backMath("entity/queen_lucy_pet/qsp_sv_savannah")));
    public static final RegistryObject<QueenLucyPetVariant> SV_WITCHER = VARIANTS.register("sv_witcher", () -> new QueenLucyPetVariant(backMath("sv_witcher"), new TranslationTextComponent("entity.backmath.queen_lucy_pet.sv_witcher"), backMath("entity/queen_lucy_pet/qsp_sv_witcher")));
    public static final RegistryObject<QueenLucyPetVariant> SV_MAID = VARIANTS.register("sv_maid", () -> new QueenLucyPetVariant(backMath("sv_maid"), new TranslationTextComponent("entity.backmath.queen_lucy_pet.sv_maid"), backMath("entity/queen_lucy_pet/qsp_sv_maid")));
    public static final RegistryObject<QueenLucyPetVariant> SV_YELLOW_AXOLOTL = VARIANTS.register("sv_yellow_axolotl", () -> new QueenLucyPetVariant(backMath("sv_yellow_axolotl"), new TranslationTextComponent("entity.backmath.queen_lucy_pet.sv_yellow_axolotl"), backMath("entity/queen_lucy_pet/qsp_sv_yellow_sophixolotl")));
    public static final RegistryObject<QueenLucyPetVariant> SV_CYAN_AXOLOTL = VARIANTS.register("sv_cyan_axolotl", () -> new QueenLucyPetVariant(backMath("sv_cyan_axolotl"), new TranslationTextComponent("entity.backmath.queen_lucy_pet.sv_blue_axolotl"), backMath("entity/queen_lucy_pet/qsp_sv_cyan_sophixolotl")));
    public static final RegistryObject<QueenLucyPetVariant> SV_ENDER = VARIANTS.register("sv_ender", () -> new QueenLucyPetVariant(backMath("sv_ender"), new TranslationTextComponent("entity.backmath.queen_lucy_pet.sv_ender"), backMath("entity/queen_lucy_pet/qsp_sv_enderphie")));
    public static final RegistryObject<QueenLucyPetVariant> SV_WORKER = VARIANTS.register("sv_worker", () -> new QueenLucyPetVariant(backMath("sv_worker"), new TranslationTextComponent("entity.backmath.queen_lucy_pet.sv_worker"), backMath("entity/queen_lucy_pet/qsp_sv_worker")));
    public static final RegistryObject<QueenLucyPetVariant> SV_EMPRESARY2 = VARIANTS.register("sv_empresary2", () -> new QueenLucyPetVariant(backMath("sv_empresary2"), new TranslationTextComponent("entity.backmath.queen_lucy_pet.sv_empresary2"), backMath("entity/queen_lucy_pet/qsp_sv_empresary2")));
    public static final RegistryObject<QueenLucyPetVariant> SV_ENTREPRENEUR = VARIANTS.register("sv_entrepreneur", () -> new QueenLucyPetVariant(backMath("sv_entrepreneur"), new TranslationTextComponent("entity.backmath.queen_lucy_pet.sv_entrepreneur"), backMath("entity/queen_lucy_pet/qsp_sv_entrepreneur")));
    public static final RegistryObject<QueenLucyPetVariant> SV_BLUE_AXOLOTL = VARIANTS.register("sv_blue_axolotl", () -> new QueenLucyPetVariant(backMath("sv_blue_axolotl"), new TranslationTextComponent("entity.backmath.queen_lucy_pet.sv_blue_axolotl"), backMath("entity/queen_lucy_pet/qsp_sv_blue_axolotl")));
    public static final RegistryObject<QueenLucyPetVariant> SV_CYAN_AXOLOTL_2 = VARIANTS.register("sv_cyan_axolotl_2", () -> new QueenLucyPetVariant(backMath("sv_cyan_axolotl_2"), new TranslationTextComponent("entity.backmath.queen_lucy_pet.sv_cyan_axolotl_2"), backMath("entity/queen_lucy_pet/qsp_sv_cyan_axolotl")));
}
