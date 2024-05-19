package com.sophicreeper.backmath.loot;

import com.sophicreeper.backmath.BackMath;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootParameters;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.function.Consumer;

public class BMLootParameterSets {
    public static final LootParameterSet BAG = register("bag", (paramBuilder) -> paramBuilder.required(LootParameters.ORIGIN).optional(LootParameters.THIS_ENTITY).optional(LootParameters.BLOCK_STATE).optional(LootParameters.BLOCK_ENTITY));

    private static LootParameterSet register(String name, Consumer<LootParameterSet.Builder> consumer) {
        LootParameterSet.Builder paramSetBuilder = new LootParameterSet.Builder();
        consumer.accept(paramSetBuilder);
        LootParameterSet paramSet = paramSetBuilder.build();
        ResourceLocation resourceLoc = BackMath.resourceLoc(name);
        LootParameterSet paramSet1 = LootParameterSets.REGISTRY.put(resourceLoc, paramSet);
        if (paramSet1 != null) {
            throw new IllegalArgumentException(new TranslationTextComponent("backmath.message_template", new TranslationTextComponent("error.backmath.illegal_argument.null_parameter_set", resourceLoc)).getString());
        } else {
            return paramSet;
        }
    }

    public static void init() {}
}
