package com.sophicreeper.backmath.loot.modifier;

import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.List;

public class ItemStackAdditionLootModifier extends LootModifier {
    private final ItemStack additionalItem;
    private final float chance;

    public ItemStackAdditionLootModifier(ILootCondition[] conditions, ItemStack additionalItem, float chance) {
        super(conditions);
        this.additionalItem = additionalItem;
        this.chance = chance;
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        if (context.getRandom().nextFloat() < this.chance) generatedLoot.add(this.additionalItem);
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<ItemStackAdditionLootModifier> {
        @Override
        public ItemStackAdditionLootModifier read(ResourceLocation location, JsonObject object, ILootCondition[] conditions) {
            JsonObject addition = object.getAsJsonObject("addition");
            Item additionalItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getAsString(addition, "id")));
            return new ItemStackAdditionLootModifier(conditions, new ItemStack(additionalItem, addition.get("count").getAsInt()), object.get("chance").getAsFloat());
        }

        @Override
        public JsonObject write(ItemStackAdditionLootModifier instance) {
            JsonObject conditions = makeConditions(instance.conditions);
            JsonObject addition = new JsonObject();
            addition.addProperty("id", ForgeRegistries.ITEMS.getKey(instance.additionalItem.getItem()).toString());
            addition.addProperty("count", instance.additionalItem.getCount());
            conditions.add("addition", addition);
            conditions.addProperty("chance", instance.chance);
            return conditions;
        }
    }
}
