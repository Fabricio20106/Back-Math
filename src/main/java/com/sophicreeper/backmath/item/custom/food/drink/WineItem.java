package com.sophicreeper.backmath.item.custom.food.drink;

import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class WineItem extends Item {
    public WineItem(Properties properties) {
        super(properties);
    }

    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livingEntity) {
        super.finishUsingItem(stack, world, livingEntity);
        if (livingEntity instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) livingEntity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (stack.isEmpty()) {
            return new ItemStack(AxolotlTest.CORK_STOPPER.get());
        } else {
            if (livingEntity instanceof PlayerEntity && !((PlayerEntity) livingEntity).abilities.instabuild) {
                ItemStack corkStopper = new ItemStack(AxolotlTest.CORK_STOPPER.get());
                PlayerEntity player = (PlayerEntity) livingEntity;
                if (!player.inventory.add(corkStopper)) {
                    player.drop(corkStopper, false);
                }
            }

            return stack;
        }
    }

    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    public UseAction getUseAnimation(ItemStack stack) {
        return UseAction.DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        return DrinkHelper.useDrink(world, player, hand);
    }
}
