package com.sophicreeper.backmath.item.behavior;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.misc.BMRegistries;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class BMItemBehaviors {
    public static final DeferredRegister<ItemBehavior> BEHAVIORS = DeferredRegister.create(BMRegistries.ITEM_BEHAVIOR, BackMath.MOD_ID);

    public static final RegistryObject<ItemBehavior> MID_TERM = BEHAVIORS.register("mid_term", () -> new ItemBehavior((stack, livEntity, world) -> {}).durabilityBarColor(BMConfigs.COMMON_CONFIGS.midTermCustomDurabilityBar.get()));
    public static final RegistryObject<ItemBehavior> MILKED_MID_TERM = BEHAVIORS.register("milked_mid_term", () -> new ItemBehavior(MID_TERM.get().effects));
}
