package com.sophicreeper.backmath.loot;

import com.google.common.collect.ImmutableList;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootParameters;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3d;

import java.util.Collection;

public class BMLootTableUtils {
    public static Collection<ItemStack> giftFromPlayer(ResourceLocation lootTable, ServerPlayerEntity serverPlayer) {
        MinecraftServer server = serverPlayer.level.getServer();
        if (server == null) return ImmutableList.of();

        LootContext lootContext = new LootContext.Builder(serverPlayer.getLevel()).withParameter(LootParameters.THIS_ENTITY, serverPlayer).withParameter(LootParameters.ORIGIN, serverPlayer.position()).withLuck(serverPlayer.getLuck()).create(LootParameterSets.GIFT);
        return server.getLootTables().get(lootTable).getRandomItems(lootContext);
    }

    public static Collection<ItemStack> giftFromDispenser(ResourceLocation lootTable, IBlockSource source) {
        MinecraftServer server = source.getLevel().getServer();

        LootContext lootContext = new LootContext.Builder(source.getLevel()).withParameter(LootParameters.BLOCK_ENTITY, source.getEntity()).withParameter(LootParameters.THIS_ENTITY, null).withParameter(LootParameters.ORIGIN, new Vector3d(source.x(), source.y(), source.z()))
                .withLuck(source.getLevel().getCurrentDifficultyAt(source.getPos()).getSpecialMultiplier()).create(LootParameterSets.GIFT);
        return server.getLootTables().get(lootTable).getRandomItems(lootContext);
    }
}
