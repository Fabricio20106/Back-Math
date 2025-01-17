package com.sophicreeper.backmath.misc;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.variant.queenlucypet.QueenLucyPetVariant;
import com.sophicreeper.backmath.variant.wansophie.WandererSophieVariant;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

public class BMRegistries {
    public static final IForgeRegistry<WandererSophieVariant> WANDERER_SOPHIE_VARIANT = new RegistryBuilder<WandererSophieVariant>().setType(WandererSophieVariant.class).setDefaultKey(BackMath.backMath("yellow_axolotl")).tagFolder("wanderer_sophie_variant").setName(BackMath.backMath("wanderer_sophie_variant")).create();
    public static final IForgeRegistry<QueenLucyPetVariant> QUEEN_LUCY_PET_VARIANT = new RegistryBuilder<QueenLucyPetVariant>().setType(QueenLucyPetVariant.class).setDefaultKey(BackMath.backMath("current")).tagFolder("queen_lucy_pet_variant").setName(BackMath.backMath("queen_lucy_pet_variant")).create();
    // public static final RegistryKey<Registry<WandererSophieVariant>> WANDERER_SOPHIE_VARIANT_REG = RegistryKey.createRegistryKey(BackMath.resourceLoc("wanderer_sophie_variant"));

    public static void init() {}
}
