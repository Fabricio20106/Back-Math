package com.sophicreeper.backmath.item.custom.food.jam;

import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class MangaedMangoJamItem extends JamItem {
    public MangaedMangoJamItem(Properties properties) {
        super(properties);
    }

    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livEntity) {
        super.finishUsingItem(stack, world, livEntity);
        if (livEntity instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) livEntity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
            serverPlayer.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(AxolotlTest.BAKUGOU_HAIR.get()));
            serverPlayer.setItemSlot(EquipmentSlotType.CHEST, new ItemStack(AxolotlTest.BAKUGOU_BLOUSE.get()));
            serverPlayer.setItemSlot(EquipmentSlotType.LEGS, new ItemStack(AxolotlTest.BAKUGOU_PANTS.get()));
            serverPlayer.setItemSlot(EquipmentSlotType.FEET, new ItemStack(AxolotlTest.BAKUGOU_SHOES.get()));
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

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent("messages.backmath.take_armor_off.jam"));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}
