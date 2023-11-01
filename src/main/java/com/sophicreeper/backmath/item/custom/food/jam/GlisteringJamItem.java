package com.sophicreeper.backmath.item.custom.food.jam;

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

public class GlisteringJamItem extends Item {
    public GlisteringJamItem(Properties properties) {
        super(properties);
    }

    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity livingEntity) {
        super.onItemUseFinish(stack, world, livingEntity);
        if (livingEntity instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) livingEntity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.addStat(Stats.ITEM_USED.get(this));
        }

        if (livingEntity instanceof PlayerEntity && !((PlayerEntity) livingEntity).abilities.isCreativeMode) {
            stack.shrink(1);
        }

        if (stack.isEmpty()) {
            return new ItemStack(AxolotlTest.JAM_POT.get());
        } else {
            if (livingEntity instanceof PlayerEntity && !((PlayerEntity)livingEntity).abilities.isCreativeMode) {
                ItemStack jamPot = new ItemStack(AxolotlTest.JAM_POT.get());
                PlayerEntity player = (PlayerEntity) livingEntity;
                if (!player.inventory.addItemStackToInventory(jamPot)) {
                    player.dropItem(jamPot, false);
                }
            }
            return stack;
        }
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT;
    }

    public SoundEvent getDrinkSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }

    public SoundEvent getEatSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }

    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        return DrinkHelper.startDrinking(world, player, hand);
    }
}
