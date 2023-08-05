package com.sophicreeper.backmath.core.world.item.food.jam;

import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class MangaedMangoJamItem extends JamItem {
    public MangaedMangoJamItem(Properties builder) {
        super(builder);
    }

    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity livingEntity) {
        super.finishUsingItem(stack, world, livingEntity);
        if (livingEntity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) livingEntity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
            serverPlayer.setItemSlot(EquipmentSlot.HEAD, new ItemStack(AxolotlTest.BAKUGOU_HAIR.get()));
            serverPlayer.setItemSlot(EquipmentSlot.CHEST, new ItemStack(AxolotlTest.BAKUGOU_BLOUSE.get()));
            serverPlayer.setItemSlot(EquipmentSlot.LEGS, new ItemStack(AxolotlTest.BAKUGOU_PANTS.get()));
            serverPlayer.setItemSlot(EquipmentSlot.FEET, new ItemStack(AxolotlTest.BAKUGOU_SHOES.get()));
        }

        if (livingEntity instanceof Player && !((Player) livingEntity).getAbilities().instabuild) {
            stack.shrink(1);
        }

        if (stack.isEmpty()) {
            return new ItemStack(AxolotlTest.JAM_POT.get());
        } else {
            if (livingEntity instanceof Player && !((Player) livingEntity).getAbilities().instabuild) {
                ItemStack jamPot = new ItemStack(AxolotlTest.JAM_POT.get());
                Player player = (Player) livingEntity;
                if (!player.getInventory().add(jamPot)) {
                    player.drop(jamPot, false);
                }
            }
            return stack;
        }
    }

    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.EAT;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(world, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("messages.backmath.take_armor_off.jam"));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}
