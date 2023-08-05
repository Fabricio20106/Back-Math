package com.sophicreeper.backmath.core.world.item.teas;

import com.sophicreeper.backmath.core.util.BMKeys;
import com.sophicreeper.backmath.core.world.effect.BMMobEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class PatienceTeaItem extends Item {
    public PatienceTeaItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity livEntity, InteractionHand hand) {
        if (livEntity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) livEntity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }
        livEntity.addEffect(new MobEffectInstance(BMMobEffects.PATIENCE.get(), 600));

        if (livEntity instanceof Player && !((Player) livEntity).getAbilities().instabuild) {
            stack.shrink(1);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity livEntity) {
        if (livEntity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) livEntity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }
        livEntity.addEffect(new MobEffectInstance(BMMobEffects.PATIENCE.get(), 600));

        if (livEntity instanceof Player && !((Player) livEntity).getAbilities().instabuild) {
            stack.shrink(1);
        }
        return super.finishUsingItem(stack, world, livEntity);
    }

    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(world, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable(this.getDescriptionId() + ".quote").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("messages.backmath.hold_shift"));
        tooltip.add(Component.translatable(this.getDescriptionId() + ".desc").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}
