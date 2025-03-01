package com.sophicreeper.backmath.variant.queenlucy;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.misc.BMRegistries;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import static com.sophicreeper.backmath.BackMath.backMath;

public class BMQueenLucyVariants {
    public static final DeferredRegister<QueenLucyVariant> VARIANTS = DeferredRegister.create(BMRegistries.QUEEN_LUCY_VARIANT, BackMath.MOD_ID);

    public static final RegistryObject<QueenLucyVariant> CURRENT = VARIANTS.register("current", () -> new QueenLucyVariant(backMath("current"), backMath("entity/queen_lucy/current"), backMath("entity/queen_lucy/current_emissive")));
    public static final RegistryObject<QueenLucyVariant> ALTERNATE = VARIANTS.register("alternate", () -> new QueenLucyVariant(backMath("alternate"), backMath("entity/queen_lucy/alternate"), backMath("entity/queen_lucy/alternate_emissive")));
    public static final RegistryObject<QueenLucyVariant> RELIC = VARIANTS.register("relic", () -> new QueenLucyVariant(backMath("relic"), backMath("entity/queen_lucy/relic"), backMath("entity/queen_lucy/relic_emissive")));
}
