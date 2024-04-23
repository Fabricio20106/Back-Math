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

public class JamItem extends Item {
    public JamItem(Properties properties) {
        super(properties);
    }

    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livEntity) {
        super.finishUsingItem(stack, world, livEntity);
        if (livEntity instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) livEntity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (livEntity instanceof PlayerEntity && !((PlayerEntity) livEntity).abilities.instabuild) {
            stack.shrink(1);
        }

        if (stack.isEmpty()) {
            return new ItemStack(AxolotlTest.JAM_POT.get());
        } else {
            if (livEntity instanceof PlayerEntity && !((PlayerEntity) livEntity).abilities.instabuild) {
                ItemStack jamPot = new ItemStack(AxolotlTest.JAM_POT.get());
                PlayerEntity player = (PlayerEntity) livEntity;
                if (!player.inventory.add(jamPot)) {
                    player.drop(jamPot, false);
                }
            }
            return stack;
        }
    }

    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    public UseAction getUseAnimation(ItemStack stack) {
        return UseAction.EAT;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        return DrinkHelper.useDrink(world, player, hand);
    }
}
