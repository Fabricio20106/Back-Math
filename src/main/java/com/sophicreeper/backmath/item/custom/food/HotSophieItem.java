package com.sophicreeper.backmath.item.custom.food;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.world.World;

public class HotSophieItem extends Item {
    public HotSophieItem(Properties properties) {
        super(properties);
    }

    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livingEntity) {
        super.finishUsingItem(stack, world, livingEntity);
        if (livingEntity instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) livingEntity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (!world.isClientSide) {
            livingEntity.setSecondsOnFire(5);
        }
        return stack;
    }
}
