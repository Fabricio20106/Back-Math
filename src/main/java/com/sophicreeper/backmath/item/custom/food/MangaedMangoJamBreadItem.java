package com.sophicreeper.backmath.item.custom.food;

import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class MangaedMangoJamBreadItem extends Item {
    public MangaedMangoJamBreadItem(Properties properties) {
        super(properties);
    }

    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livingEntity) {
        super.finishUsingItem(stack, world, livingEntity);
        if (livingEntity instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) livingEntity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
            serverPlayer.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.BAKUGOU_HAIR.get()));
            serverPlayer.setItemSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.BAKUGOU_BLOUSE.get()));
            serverPlayer.setItemSlot(EquipmentSlotType.LEGS, new ItemStack(AxolotlTest.BAKUGOU_PANTS.get()));
            serverPlayer.setItemSlot(EquipmentSlotType.FEET, new ItemStack(AxolotlTest.BAKUGOU_SHOES.get()));
        }

        if (livingEntity instanceof PlayerEntity && !((PlayerEntity)livingEntity).abilities.instabuild) {
            stack.shrink(1);
        }
        return stack;
    }

    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    public UseAction getUseAnimation(ItemStack stack) {
        return UseAction.EAT;
    }

    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        return DrinkHelper.useDrink(world, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent("messages.backmath.take_armor_off.jam_bread"));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}
