package com.sophicreeper.backmath.loot.function;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.sophicreeper.backmath.blockentity.custom.WandererSophieHeadBlockEntity;
import com.sophicreeper.backmath.entity.custom.WandererSophieEntity;
import com.sophicreeper.backmath.loot.BMLootFunctions;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootFunction;
import net.minecraft.loot.LootFunctionType;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.tileentity.TileEntity;

import javax.annotation.Nonnull;

public class CopyWandererSophieVariant extends LootFunction {
    public CopyWandererSophieVariant(ILootCondition[] conditions) {
        super(conditions);
    }

    @Override
    @Nonnull
    public LootFunctionType getType() {
        return BMLootFunctions.COPY_WANDERER_SOPHIE_VARIANT;
    }

    @Override
    @Nonnull
    protected ItemStack run(ItemStack stack, LootContext context) {
        Entity entity = context.getParamOrNull(LootParameters.THIS_ENTITY);
        TileEntity blockEntity = context.getParamOrNull(LootParameters.BLOCK_ENTITY);

        if (entity instanceof WandererSophieEntity) {
            stack.getOrCreateTag().putString("variant", ((WandererSophieEntity) entity).getVariant());
        } else if (blockEntity instanceof WandererSophieHeadBlockEntity && ((WandererSophieHeadBlockEntity) blockEntity).getVariant() != null) {
            stack.getOrCreateTag().putString("variant", ((WandererSophieHeadBlockEntity) blockEntity).getVariant().getAssetID().toString());
        }
        return stack;
    }

    public static class Serializer extends LootFunction.Serializer<CopyWandererSophieVariant> {
        @Override
        @Nonnull
        public CopyWandererSophieVariant deserialize(JsonObject object, JsonDeserializationContext context, ILootCondition[] conditions) {
            return new CopyWandererSophieVariant(conditions);
        }
    }
}
