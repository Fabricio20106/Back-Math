package com.sophicreeper.backmath.loot;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.loot.function.*;
import net.minecraft.loot.ILootSerializer;
import net.minecraft.loot.LootFunctionType;
import net.minecraft.loot.functions.ILootFunction;
import net.minecraft.util.registry.Registry;

public class BMLootFunctions {
    public static final LootFunctionType COPY_WANDERER_SOPHIE_VARIANT = register("copy_wanderer_sophie_variant", new CopyWandererSophieVariant.Serializer());
    public static final LootFunctionType COPY_QUEEN_LUCY_VARIANT = register("copy_queen_lucy_variant", new CopyQueenLucyVariant.Serializer());
    public static final LootFunctionType INCREASE_DROPPED_SKULLS = register("increase_dropped_skulls", new IncreaseDroppedSkulls.Serializer());
    public static final LootFunctionType SET_STORED_EXPERIENCE = register("set_stored_experience", new SetStoredExperience.Serializer());
    public static final LootFunctionType SET_CRATE_CONTENTS = register("set_crate_contents", new SetCrateContents.Serializer());

    private static LootFunctionType register(String name, ILootSerializer<? extends ILootFunction> lootSerializer) {
        return Registry.register(Registry.LOOT_FUNCTION_TYPE, BackMath.backMath(name), new LootFunctionType(lootSerializer));
    }

    public static void init() {}
}
