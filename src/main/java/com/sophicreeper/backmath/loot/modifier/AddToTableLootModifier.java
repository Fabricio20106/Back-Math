package com.sophicreeper.backmath.loot.modifier;

import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;
import java.util.List;

public class AddToTableLootModifier extends LootModifier {
    private final ResourceLocation additionTable;
    private final double chance;

    public AddToTableLootModifier(ILootCondition[] conditions, ResourceLocation additionTable, double chance) {
        super(conditions);
        this.additionTable = additionTable;
        this.chance = chance;
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        MinecraftServer server = context.getLevel().getServer();
        if (context.getRandom().nextDouble() < this.chance) {
            return server.getLootTables().get(this.additionTable).getRandomItems(context);
        }
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<AddToTableLootModifier> {
        @Override
        public AddToTableLootModifier read(ResourceLocation location, JsonObject object, ILootCondition[] conditions) {
            return new AddToTableLootModifier(conditions, ResourceLocation.tryParse(object.get("addition_table").getAsString()), object.get("chance").getAsDouble());
        }

        @Override
        public JsonObject write(AddToTableLootModifier instance) {
            JsonObject conditions = makeConditions(instance.conditions);
            conditions.addProperty("addition_table", instance.additionTable.toString());
            conditions.addProperty("chance", instance.chance);
            return conditions;
        }
    }
}
