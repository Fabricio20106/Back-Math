package com.sophicreeper.backmath.core.world.item.teas;

import com.sophicreeper.backmath.core.world.effect.BMEffects;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class PatienceTeaItem extends Item {
    public PatienceTeaItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType itemInteractionForEntity(ItemStack stack, PlayerEntity player, LivingEntity livEntity, Hand hand) {
        if (livEntity instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) livEntity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.addStat(Stats.ITEM_USED.get(this));
        }
        livEntity.addPotionEffect(new EffectInstance(BMEffects.PATIENCE_TEA.get(), 600));
        return ActionResultType.SUCCESS;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity livEntity) {
        if (livEntity instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) livEntity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.addStat(Stats.ITEM_USED.get(this));
        }
        livEntity.addPotionEffect(new EffectInstance(BMEffects.PATIENCE_TEA.get(), 600));
        stack.shrink(1);
        return super.onItemUseFinish(stack, world, livEntity);
    }

    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    public SoundEvent getDrinkSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        return DrinkHelper.startDrinking(world, player, hand);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent(this.getTranslationKey() + ".desc").mergeStyle(TextFormatting.GRAY));
        super.addInformation(stack, world, tooltip, flag);
    }
}
