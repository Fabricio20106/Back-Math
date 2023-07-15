package com.sophicreeper.backmath.core.world.item.teas;

import com.sophicreeper.backmath.core.config.BMConfigs;
import com.sophicreeper.backmath.core.util.BMKeys;
import com.sophicreeper.backmath.core.world.effect.BMEffects;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class PeaceTeaItem extends Item {
    public PeaceTeaItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType itemInteractionForEntity(ItemStack stack, PlayerEntity player, LivingEntity livEntity, Hand hand) {
        livEntity.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.REGENERATION, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.SPEED, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.HASTE, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.STRENGTH, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 6000));
        if (BMConfigs.SERVER_CONFIGS.peaceTeaInvisibilityToggle.get()) {
            livEntity.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 6000));
        }
        livEntity.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.SATURATION, 6000));
        if (BMConfigs.SERVER_CONFIGS.peaceTeaGlowingToggle.get()) {
            livEntity.addPotionEffect(new EffectInstance(Effects.GLOWING, 6000));
        }
        livEntity.addPotionEffect(new EffectInstance(Effects.LUCK, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.CONDUIT_POWER, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 6000));
        livEntity.addPotionEffect(new EffectInstance(BMEffects.MOOD.get(), 6000));

        if (livEntity instanceof PlayerEntity && !((PlayerEntity) livEntity).abilities.isCreativeMode) {
            stack.shrink(1);
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity livEntity) {
        livEntity.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.REGENERATION, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.SPEED, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.HASTE, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.STRENGTH, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 6000));
        if (BMConfigs.SERVER_CONFIGS.peaceTeaInvisibilityToggle.get()) {
            livEntity.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 6000));
        }
        livEntity.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.SATURATION, 6000));
        if (BMConfigs.SERVER_CONFIGS.peaceTeaGlowingToggle.get()) {
            livEntity.addPotionEffect(new EffectInstance(Effects.GLOWING, 6000));
        }
        livEntity.addPotionEffect(new EffectInstance(Effects.LUCK, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.CONDUIT_POWER, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 6000));
        livEntity.addPotionEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 6000));
        livEntity.addPotionEffect(new EffectInstance(BMEffects.MOOD.get(), 6000));

        if (livEntity instanceof PlayerEntity && !((PlayerEntity) livEntity).abilities.isCreativeMode) {
            stack.shrink(1);
        }
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
        tooltip.add(new TranslationTextComponent(this.getTranslationKey() + ".quote").mergeStyle(TextFormatting.GRAY));
        if (!BMKeys.isHoldingShift()) tooltip.add(new TranslationTextComponent("messages.backmath.hold_shift"));
        if (BMKeys.isHoldingShift()) tooltip.add(new TranslationTextComponent(this.getTranslationKey() + ".desc").mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        super.addInformation(stack, world, tooltip, flag);
    }
}
