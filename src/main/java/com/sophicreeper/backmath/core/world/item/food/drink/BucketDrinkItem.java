package com.sophicreeper.backmath.core.world.item.food.drink;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class BucketDrinkItem extends Item {
    public BucketDrinkItem() {
        super(new Properties().stacksTo(1));
    }

    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity livingEntity) {
        super.finishUsingItem(stack, world, livingEntity);
        if (livingEntity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) livingEntity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (stack.isEmpty()) {
            return new ItemStack(Items.BUCKET);
        } else {
            if (livingEntity instanceof Player && !((Player) livingEntity).getAbilities().instabuild) {
                ItemStack glassBottle = new ItemStack(Items.BUCKET);
                Player player = (Player) livingEntity;
                if (!player.getInventory().add(glassBottle)) {
                    player.drop(glassBottle, false);
                }
            }

            return stack;
        }
    }

    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    public SoundEvent getDrinkSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    public SoundEvent getEatSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    public InteractionResultHolder<ItemStack> onItemRightClick(Level world, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(world, player, hand);
    }
}
