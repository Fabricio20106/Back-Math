package com.sophicreeper.backmath.loot.function;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.sophicreeper.backmath.loot.BMLootFunctions;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootFunction;
import net.minecraft.loot.LootFunctionType;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.JSONUtils;

import javax.annotation.Nonnull;
import java.util.Random;

public class SetStoredExperience extends LootFunction {
    private final int storedExperienceMin;
    private final int storedExperienceMax;

    public SetStoredExperience(ILootCondition[] conditions, int storedExperienceMin, int storedExperienceMax) {
        super(conditions);
        this.storedExperienceMin = storedExperienceMin;
        this.storedExperienceMax = storedExperienceMax;
    }

    @Override
    @Nonnull
    public LootFunctionType getType() {
        return BMLootFunctions.SET_STORED_EXPERIENCE;
    }

    @Override
    @Nonnull
    public ItemStack run(ItemStack stack, LootContext context) {
        CompoundNBT tag = stack.getOrCreateTag();
        tag.putInt("stored_experience", randomBetweenInclusive(context.getRandom(), this.storedExperienceMin, this.storedExperienceMax));
        return stack;
    }

    // Copied from UniformInt from 1.18.
    public static int randomBetweenInclusive(Random rand, int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }

    public static class Serializer extends LootFunction.Serializer<SetStoredExperience> {
        @Override
        public void serialize(JsonObject object, SetStoredExperience function, JsonSerializationContext context) {
            super.serialize(object, function, context);
            JsonObject storedExperience = new JsonObject();
            storedExperience.addProperty("min", function.storedExperienceMin);
            storedExperience.addProperty("max", function.storedExperienceMax);
            object.add("stored_experience", storedExperience);
        }

        @Override
        @Nonnull
        public SetStoredExperience deserialize(JsonObject object, JsonDeserializationContext context, ILootCondition[] conditions) {
            JsonObject storedExperience = object.get("stored_experience").getAsJsonObject();
            return new SetStoredExperience(conditions, JSONUtils.getAsInt(storedExperience, "min"), JSONUtils.getAsInt(storedExperience, "max"));
        }
    }
}
