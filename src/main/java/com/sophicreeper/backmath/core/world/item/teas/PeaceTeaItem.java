package com.sophicreeper.backmath.core.world.item.teas;

import com.sophicreeper.backmath.core.config.BMConfigs;
import com.sophicreeper.backmath.core.util.BMKeys;
import com.sophicreeper.backmath.core.world.effect.BMMobEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class PeaceTeaItem extends Item {
    public PeaceTeaItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity livEntity, InteractionHand hand) {
        livEntity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.HEAL, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.JUMP, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 6000));
        if (BMConfigs.SERVER_CONFIGS.peaceTeaInvisibilityToggle.get()) {
            livEntity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 6000));
        }
        livEntity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 6000));
        if (BMConfigs.SERVER_CONFIGS.peaceTeaGlowingToggle.get()) {
            livEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 6000));
        }
        livEntity.addEffect(new MobEffectInstance(MobEffects.LUCK, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 6000));
        livEntity.addEffect(new MobEffectInstance(BMMobEffects.MOOD.get(), 6000));

        if (livEntity instanceof Player && !((Player) livEntity).getAbilities().instabuild) {
            stack.shrink(1);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity livEntity) {
        livEntity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.HEAL, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.JUMP, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 6000));
        if (BMConfigs.SERVER_CONFIGS.peaceTeaInvisibilityToggle.get()) {
            livEntity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 6000));
        }
        livEntity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 6000));
        if (BMConfigs.SERVER_CONFIGS.peaceTeaGlowingToggle.get()) {
            livEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 6000));
        }
        livEntity.addEffect(new MobEffectInstance(MobEffects.LUCK, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 6000));
        livEntity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 6000));
        livEntity.addEffect(new MobEffectInstance(BMMobEffects.MOOD.get(), 6000));

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
        if (!BMKeys.isHoldingShift()) tooltip.add(Component.translatable("messages.backmath.hold_shift"));
        if (BMKeys.isHoldingShift()) tooltip.add(Component.translatable(this.getDescriptionId() + ".desc").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}
