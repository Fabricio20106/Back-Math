package com.sophicreeper.backmath.item.custom.tea;

import com.sophicreeper.backmath.dispenser.TeaDispenseBehavior;
import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.util.BMKeys;
import com.sophicreeper.backmath.effect.BMEffects;
import net.minecraft.block.DispenserBlock;
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
        DispenserBlock.registerBehavior(this, new TeaDispenseBehavior());
    }

    @Override
    public ActionResultType interactLivingEntity(ItemStack stack, PlayerEntity player, LivingEntity livEntity, Hand hand) {
        livEntity.addEffect(new EffectInstance(Effects.ABSORPTION, 6000));
        livEntity.addEffect(new EffectInstance(Effects.HEALTH_BOOST, 6000));
        livEntity.addEffect(new EffectInstance(Effects.HEAL, 6000));
        livEntity.addEffect(new EffectInstance(Effects.REGENERATION, 6000));
        livEntity.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 6000));
        livEntity.addEffect(new EffectInstance(Effects.DIG_SPEED, 6000));
        livEntity.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 6000));
        livEntity.addEffect(new EffectInstance(Effects.JUMP, 6000));
        livEntity.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 6000));
        livEntity.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 6000));
        livEntity.addEffect(new EffectInstance(Effects.WATER_BREATHING, 6000));
        if (BMConfigs.COMMON_CONFIGS.peaceTeaInvisibilityToggle.get()) {
            livEntity.addEffect(new EffectInstance(Effects.INVISIBILITY, 6000));
        }
        livEntity.addEffect(new EffectInstance(Effects.NIGHT_VISION, 6000));
        livEntity.addEffect(new EffectInstance(Effects.SATURATION, 6000));
        if (BMConfigs.COMMON_CONFIGS.peaceTeaGlowingToggle.get()) {
            livEntity.addEffect(new EffectInstance(Effects.GLOWING, 6000));
        }
        livEntity.addEffect(new EffectInstance(Effects.LUCK, 6000));
        livEntity.addEffect(new EffectInstance(Effects.SLOW_FALLING, 6000));
        livEntity.addEffect(new EffectInstance(Effects.CONDUIT_POWER, 6000));
        livEntity.addEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 6000));
        livEntity.addEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 6000));
        livEntity.addEffect(new EffectInstance(BMEffects.MOOD.get(), 6000));

        if (livEntity instanceof PlayerEntity && !((PlayerEntity) livEntity).abilities.instabuild) {
            stack.shrink(1);
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livEntity) {
        livEntity.addEffect(new EffectInstance(Effects.ABSORPTION, 6000));
        livEntity.addEffect(new EffectInstance(Effects.HEALTH_BOOST, 6000));
        livEntity.addEffect(new EffectInstance(Effects.HEAL, 6000));
        livEntity.addEffect(new EffectInstance(Effects.REGENERATION, 6000));
        livEntity.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 6000));
        livEntity.addEffect(new EffectInstance(Effects.DIG_SPEED, 6000));
        livEntity.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 6000));
        livEntity.addEffect(new EffectInstance(Effects.JUMP, 6000));
        livEntity.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 6000));
        livEntity.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 6000));
        livEntity.addEffect(new EffectInstance(Effects.WATER_BREATHING, 6000));
        if (BMConfigs.COMMON_CONFIGS.peaceTeaInvisibilityToggle.get()) {
            livEntity.addEffect(new EffectInstance(Effects.INVISIBILITY, 6000));
        }
        livEntity.addEffect(new EffectInstance(Effects.NIGHT_VISION, 6000));
        livEntity.addEffect(new EffectInstance(Effects.SATURATION, 6000));
        if (BMConfigs.COMMON_CONFIGS.peaceTeaGlowingToggle.get()) {
            livEntity.addEffect(new EffectInstance(Effects.GLOWING, 6000));
        }
        livEntity.addEffect(new EffectInstance(Effects.LUCK, 6000));
        livEntity.addEffect(new EffectInstance(Effects.SLOW_FALLING, 6000));
        livEntity.addEffect(new EffectInstance(Effects.CONDUIT_POWER, 6000));
        livEntity.addEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 6000));
        livEntity.addEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 6000));
        livEntity.addEffect(new EffectInstance(BMEffects.MOOD.get(), 6000));

        if (livEntity instanceof PlayerEntity && !((PlayerEntity) livEntity).abilities.instabuild) {
            stack.shrink(1);
        }
        return super.finishUsingItem(stack, world, livEntity);
    }

    public int getUseDuration(ItemStack stack) {
        return 32;
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

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent(this.getDescriptionId() + ".quote").withStyle(TextFormatting.GRAY));
        if (!BMKeys.isHoldingShift()) tooltip.add(new TranslationTextComponent("tooltip.backmath.hold_shift.not_held"));
        if (BMKeys.isHoldingShift()) tooltip.add(new TranslationTextComponent("tooltip.backmath.hold_shift.held"));
        if (BMKeys.isHoldingShift()) tooltip.add(new TranslationTextComponent("tooltip.backmath.empty"));
        if (BMKeys.isHoldingShift()) tooltip.add(new TranslationTextComponent(this.getDescriptionId() + ".desc").withStyle(TextFormatting.GRAY).withStyle(TextFormatting.ITALIC));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}
