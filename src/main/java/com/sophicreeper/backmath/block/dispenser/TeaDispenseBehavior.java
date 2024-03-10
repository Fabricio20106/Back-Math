package com.sophicreeper.backmath.block.dispenser;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.effect.BMEffects;
import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class TeaDispenseBehavior extends OptionalDispenseBehavior {
    @Override
    protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
        BlockPos pos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
        for (LivingEntity livEntity : source.getWorld().getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(pos), LivingEntity::isAlive)) {
            if (stack.getItem() == AxolotlTest.PEACE_TEA.get()) {
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
                if (BMConfigs.COMMON_CONFIGS.peaceTeaInvisibilityToggle.get()) livEntity.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 6000));
                livEntity.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 6000));
                livEntity.addPotionEffect(new EffectInstance(Effects.SATURATION, 6000));
                if (BMConfigs.COMMON_CONFIGS.peaceTeaGlowingToggle.get()) livEntity.addPotionEffect(new EffectInstance(Effects.GLOWING, 6000));
                livEntity.addPotionEffect(new EffectInstance(Effects.LUCK, 6000));
                livEntity.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 6000));
                livEntity.addPotionEffect(new EffectInstance(Effects.CONDUIT_POWER, 6000));
                livEntity.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 6000));
                livEntity.addPotionEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 6000));
                livEntity.addPotionEffect(new EffectInstance(BMEffects.MOOD.get(), 6000));
                setSuccessful(true);
                stack.shrink(1);
                return stack;
            }
            if (stack.getItem() == AxolotlTest.MOOD_TEA.get()) {
                livEntity.addPotionEffect(new EffectInstance(BMEffects.MOOD.get(), 6000));
                setSuccessful(true);
                stack.shrink(1);
                return stack;
            }
            if (stack.getItem() == AxolotlTest.DISGUST_TEA.get()) {
                livEntity.addPotionEffect(new EffectInstance(BMEffects.DISGUST.get(), 600));
                setSuccessful(true);
                stack.shrink(1);
                return stack;
            }
            if (stack.getItem() == AxolotlTest.PATIENCE_TEA.get()) {
                livEntity.addPotionEffect(new EffectInstance(BMEffects.PATIENCE.get(), 600));
                setSuccessful(true);
                stack.shrink(1);
                return stack;
            }
            if (stack.getItem() == AxolotlTest.ALJAME_TEACUP.get()) {
                livEntity.addPotionEffect(new EffectInstance(Effects.REGENERATION, 200));
                if (source.getWorld().rand.nextBoolean()) livEntity.addPotionEffect(new EffectInstance(Effects.SATURATION, 100));
                if (source.getWorld().rand.nextFloat() < 0.000001F) livEntity.addPotionEffect(new EffectInstance(Effects.POISON, 1200, 100));
                setSuccessful(true);
                stack.shrink(1);
                return stack;
            }
        }
        return super.dispenseStack(source, stack);
    }
}
