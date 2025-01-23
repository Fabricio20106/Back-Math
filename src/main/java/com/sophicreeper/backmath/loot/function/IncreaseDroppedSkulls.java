package com.sophicreeper.backmath.loot.function;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.sophicreeper.backmath.loot.BMLootFunctions;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootFunction;
import net.minecraft.loot.LootFunctionType;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.DamageSource;

import javax.annotation.Nonnull;

public class IncreaseDroppedSkulls extends LootFunction {
    public IncreaseDroppedSkulls(ILootCondition[] conditions) {
        super(conditions);
    }

    @Override
    @Nonnull
    public LootFunctionType getType() {
        return BMLootFunctions.INCREASE_DROPPED_SKULLS;
    }

    @Override
    @Nonnull
    protected ItemStack run(ItemStack stack, LootContext context) {
        DamageSource source = context.getParamOrNull(LootParameters.DAMAGE_SOURCE);
        if (source != null && source.getEntity() instanceof CreeperEntity) {
            CreeperEntity creeper = (CreeperEntity) source.getEntity();
            if (creeper.isPowered()) creeper.increaseDroppedSkulls();
        }
        return stack;
    }

    public static class Serializer extends LootFunction.Serializer<IncreaseDroppedSkulls> {
        @Override
        @Nonnull
        public IncreaseDroppedSkulls deserialize(JsonObject object, JsonDeserializationContext context, ILootCondition[] conditions) {
            return new IncreaseDroppedSkulls(conditions);
        }
    }
}
