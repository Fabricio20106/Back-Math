package com.sophicreeper.backmath.registry;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.registry.wsvariant.WandererSophieVariant;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

public class BMRegistries {
    public static final IForgeRegistry<WandererSophieVariant> WANDERER_SOPHIE_VARIANT = new RegistryBuilder<WandererSophieVariant>().setType(WandererSophieVariant.class).setName(BackMath.resourceLoc("wanderer_sophie_variant")).create();

    public static void init() {}
}
