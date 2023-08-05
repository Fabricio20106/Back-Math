package com.sophicreeper.backmath.core.world.item.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class BMFoods {
    public static final FoodProperties TODDY = new FoodProperties.Builder().nutrition(10).saturationMod(10.0f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200), 1.0f).build();
    public static final FoodProperties ALJAME = new FoodProperties.Builder().nutrition(5).saturationMod(3.5f).effect(() ->
            new MobEffectInstance(MobEffects.POISON, 100), 1.0f).effect(() ->
            new MobEffectInstance(MobEffects.BLINDNESS, 600), 1.0f).build();
    public static final FoodProperties LAGUSTA = new FoodProperties.Builder().nutrition(9).saturationMod(6).build();
    public static final FoodProperties AMARACAMEL = new FoodProperties.Builder().nutrition(5).saturationMod(2.2f).build();
    public static final FoodProperties ALJAME_TEACUP = new FoodProperties.Builder().nutrition(4).saturationMod(1.2f).effect(
            () -> new MobEffectInstance(MobEffects.REGENERATION, 200), 1.0f).effect(
            // 1 in a 1,000,000 (million)
            () -> new MobEffectInstance(MobEffects.POISON, 1200, 100), 0.000001f).effect(
            () -> new MobEffectInstance(MobEffects.SATURATION, 100), 0.5f).build();
    public static final FoodProperties PINE_JELLY = new FoodProperties.Builder().nutrition(4).saturationMod(0.3f).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 6000, 1), 1.0f).build();
    public static final FoodProperties JANTIQUIFIED_ALJAME = new FoodProperties.Builder().nutrition(5).saturationMod(3.5f).effect(
            () -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F).effect(
            () -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0F).alwaysEat().build();
    public static final FoodProperties HOLY_JANTIQUIFIED_ALJAME = new FoodProperties.Builder().nutrition(5).saturationMod(3.5F).effect(
            () -> new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0F).effect(
            () -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0F).effect(
            () -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0F).effect(
            () -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3), 1.0F).alwaysEat().build();

    // Back Math 1.8.0:
    // Foods
    public static final FoodProperties GUAVA = new FoodProperties.Builder().nutrition(5).saturationMod(0.5f).build();
    public static final FoodProperties JABUTICABA = new FoodProperties.Builder().nutrition(3).saturationMod(0.4f).build();

    // Cut Fruits
    public static final FoodProperties HALVED_APPLE = new FoodProperties.Builder().nutrition(2).saturationMod(0.15f).fast().build();
    public static final FoodProperties HALVED_GOLDEN_APPLE = new FoodProperties.Builder().nutrition(2).saturationMod(0.6f).effect(
            () -> new MobEffectInstance(MobEffects.REGENERATION, 50, 0), 1).effect(
            () -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0), 1).alwaysEat().fast().build();
    public static final FoodProperties HALVED_ENCHANTED_GOLDEN_APPLE = new FoodProperties.Builder().nutrition(2).saturationMod(0.6f).effect(
            () -> new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 1).effect(
            () -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 1), 1).effect(
            () -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3000, 0), 1).effect(
            () -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 1), 1).alwaysEat().fast().build();
    public static final FoodProperties HALVED_CARROT = new FoodProperties.Builder().nutrition(1).saturationMod(0.3f).fast().build();
    public static final FoodProperties HALVED_SWEET_BERRIES = new FoodProperties.Builder().nutrition(1).saturationMod(0.05f).fast().build();
    public static final FoodProperties HALVED_BAKED_POTATO = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).fast().build();
    public static final FoodProperties HALVED_HONEY_BOTTLE = new FoodProperties.Builder().nutrition(3).saturationMod(0.05f).fast().build();
    public static final FoodProperties HALVED_ALJAME = new FoodProperties.Builder().nutrition(2).saturationMod(1.75f).effect(() ->
            new MobEffectInstance(MobEffects.POISON, 100), 1.0f).effect(() ->
            new MobEffectInstance(MobEffects.BLINDNESS, 600), 1.0f).fast().build();
    public static final FoodProperties HALVED_JANTIQUIFIED_ALJAME = new FoodProperties.Builder().nutrition(2).saturationMod(1.75f).effect(
            () -> new MobEffectInstance(MobEffects.REGENERATION, 50, 1), 1.0F).effect(
            () -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0), 1.0F).alwaysEat().build();
    public static final FoodProperties HALVED_HOLY_JANTIQUIFIED_ALJAME = new FoodProperties.Builder().nutrition(2).saturationMod(1.75f).effect(
            () -> new MobEffectInstance(MobEffects.REGENERATION, 200, 1), 1.0F).effect(
            () -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3000, 0), 1.0F).effect(
            () -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3000, 0), 1.0F).effect(
            () -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 3), 1.0F).alwaysEat().build();
    public static final FoodProperties HALVED_GUAVA = new FoodProperties.Builder().nutrition(2).saturationMod(0.25f).fast().build();
    public static final FoodProperties HALVED_JABUTICABA = new FoodProperties.Builder().nutrition(1).saturationMod(0.2f).fast().build();
    public static final FoodProperties ALJAMIC_BERRY = new FoodProperties.Builder().nutrition(5).saturationMod(3.5f).build();
    public static final FoodProperties HALVED_ALJAMIC_BERRY = new FoodProperties.Builder().nutrition(2).saturationMod(1.75f).fast().build();
    public static final FoodProperties AMARACAMEL_JUICE = new FoodProperties.Builder().nutrition(6).saturationMod(3.2f).build();
}
