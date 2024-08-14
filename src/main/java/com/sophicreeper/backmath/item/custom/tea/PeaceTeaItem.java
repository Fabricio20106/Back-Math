package com.sophicreeper.backmath.item.custom.tea;

import com.google.common.collect.Lists;
import com.sophicreeper.backmath.dispenser.TeaDispenseBehavior;
import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.item.custom.ToolBehaviors;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class PeaceTeaItem extends Item implements ToolBehaviors {
    public PeaceTeaItem(Properties properties) {
        super(properties);
        DispenserBlock.registerBehavior(this, new TeaDispenseBehavior());
    }

    @Override
    @Nonnull
    public List<EffectInstance> getAppliedEffects() {
        List<EffectInstance> effects = Lists.newArrayList(new EffectInstance(Effects.ABSORPTION, 6000), new EffectInstance(Effects.HEALTH_BOOST, 6000), new EffectInstance(Effects.HEAL, 6000), new EffectInstance(Effects.REGENERATION, 6000),
                new EffectInstance(Effects.MOVEMENT_SPEED, 6000), new EffectInstance(Effects.DIG_SPEED, 6000), new EffectInstance(Effects.DAMAGE_BOOST, 6000), new EffectInstance(Effects.JUMP, 6000),
                new EffectInstance(Effects.DAMAGE_RESISTANCE, 6000), new EffectInstance(Effects.FIRE_RESISTANCE, 6000), new EffectInstance(Effects.WATER_BREATHING, 6000),
                new EffectInstance(Effects.NIGHT_VISION, 6000), new EffectInstance(Effects.SATURATION, 6000), new EffectInstance(Effects.LUCK, 6000), new EffectInstance(Effects.SLOW_FALLING, 6000),
                new EffectInstance(Effects.CONDUIT_POWER, 6000), new EffectInstance(Effects.DOLPHINS_GRACE, 6000), new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 6000),
                new EffectInstance(BMEffects.MOOD.get(), 6000));
        if (BMConfigs.COMMON_CONFIGS.peaceTeaInvisibilityToggle.get()) effects.add(new EffectInstance(Effects.INVISIBILITY, 6000));
        if (BMConfigs.COMMON_CONFIGS.peaceTeaGlowingToggle.get()) effects.add(new EffectInstance(Effects.GLOWING, 6000));
        return effects;
    }

    @Override
    @Nonnull
    public ActionResultType interactLivingEntity(ItemStack stack, PlayerEntity player, LivingEntity livEntity, Hand hand) {
        applyTagEffects(stack, livEntity);
        if (livEntity instanceof PlayerEntity && !((PlayerEntity) livEntity).abilities.instabuild) stack.shrink(1);
        return ActionResultType.SUCCESS;
    }

    @Override
    @Nonnull
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        return DrinkHelper.useDrink(world, player, hand);
    }

    @Override
    @Nonnull
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livEntity) {
        applyTagEffects(stack, livEntity);
        if (livEntity instanceof PlayerEntity && !((PlayerEntity) livEntity).abilities.instabuild) stack.shrink(1);
        return super.finishUsingItem(stack, world, livEntity);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    @Nonnull
    public UseAction getUseAnimation(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    @Nonnull
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        tooltip.add(new TranslationTextComponent(this.getDescriptionId() + ".quote").withStyle(TextFormatting.GRAY));
        if (!BMKeys.isHoldingShift()) tooltip.add(new TranslationTextComponent("tooltip.backmath.hold_shift.not_held"));
        if (BMKeys.isHoldingShift()) tooltip.add(new TranslationTextComponent("tooltip.backmath.hold_shift.held"));
        if (BMKeys.isHoldingShift()) tooltip.add(new TranslationTextComponent("tooltip.backmath.empty"));
        if (BMKeys.isHoldingShift()) tooltip.add(new TranslationTextComponent(this.getDescriptionId() + ".desc").withStyle(TextFormatting.GRAY).withStyle(TextFormatting.ITALIC));
    }
}
