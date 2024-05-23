package com.sophicreeper.backmath.loot;

import com.google.common.collect.ImmutableList;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootParameters;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.server.ServerWorld;

import java.util.Collection;

public class BMLootTableUtils {
    public static Collection<ItemStack> giftFromPlayer(ResourceLocation lootTable, ServerPlayerEntity serverPlayer) {
        MinecraftServer server = serverPlayer.level.getServer();
        if (server == null) return ImmutableList.of();

        LootContext lootContext = new LootContext.Builder(serverPlayer.getLevel()).withParameter(LootParameters.THIS_ENTITY, serverPlayer).withParameter(LootParameters.ORIGIN, serverPlayer.position()).withLuck(serverPlayer.getLuck()).create(BMLootParameterSets.BAG);
        return server.getLootTables().get(lootTable).getRandomItems(lootContext);
    }

    public static Collection<ItemStack> giftFromDispenser(ResourceLocation lootTable, IBlockSource source) {
        MinecraftServer server = source.getLevel().getServer();

        LootContext lootContext = new LootContext.Builder(source.getLevel()).withParameter(LootParameters.BLOCK_STATE, source.getBlockState()).withParameter(LootParameters.BLOCK_ENTITY, source.getEntity()).withParameter(LootParameters.ORIGIN, new Vector3d(
                source.x(), source.y(), source.z())).withLuck(source.getLevel().getCurrentDifficultyAt(source.getPos()).getSpecialMultiplier()).create(BMLootParameterSets.BAG);
        return server.getLootTables().get(lootTable).getRandomItems(lootContext);
    }

    public static Collection<ItemStack> dropFromCutting(ResourceLocation cuttingTable, ItemUseContext context) {
        MinecraftServer server = context.getLevel().getServer();
        if (server == null) return ImmutableList.of();

        if (context.getLevel() instanceof ServerWorld) {
            LootContext lootContext = new LootContext.Builder((ServerWorld) context.getLevel()).withParameter(LootParameters.BLOCK_STATE, context.getLevel().getBlockState(context.getClickedPos())).withParameter(LootParameters.ORIGIN, new Vector3d(
                    context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ())).withParameter(LootParameters.TOOL, context.getPlayer().getItemInHand(Hand.MAIN_HAND)).withParameter(LootParameters.THIS_ENTITY, context.getPlayer())
                    .create(LootParameterSets.BLOCK);
            return server.getLootTables().get(cuttingTable).getRandomItems(lootContext);
        }
        return ImmutableList.of();
    }
}
