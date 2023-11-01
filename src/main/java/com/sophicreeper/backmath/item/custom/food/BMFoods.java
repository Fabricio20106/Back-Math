package com.sophicreeper.backmath.item.custom.food;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class BMFoods {
    public static final Food TODDY = new Food.Builder().hunger(10).saturation(10.0f).effect(() -> new EffectInstance(Effects.STRENGTH, 1200), 1.0f).build();
    public static final Food ALJAME = new Food.Builder().hunger(5).saturation(3.5f).effect(() ->
            new EffectInstance(Effects.POISON, 100), 1.0f).effect(() ->
            new EffectInstance(Effects.BLINDNESS, 600), 1.0f).build();
    public static final Food LAGUSTA = new Food.Builder().hunger(9).saturation(6).build();
    public static final Food AMARACAMEL = new Food.Builder().hunger(5).saturation(2.2f).build();
    public static final Food ALJAME_TEACUP = new Food.Builder().hunger(4).saturation(1.2f).effect(
            () -> new EffectInstance(Effects.REGENERATION, 200), 1.0f).effect(
            // 1 in a 1,000,000 (million)
            () -> new EffectInstance(Effects.POISON, 1200, 100), 0.000001f).effect(
            () -> new EffectInstance(Effects.SATURATION, 100), 0.5f).build();
    public static final Food PINE_JELLY = new Food.Builder().hunger(4).saturation(0.3f).effect(() -> new EffectInstance(Effects.ABSORPTION, 6000, 1), 1.0f).build();
    public static final Food JANTIQUIFIED_ALJAME = new Food.Builder().hunger(5).saturation(3.5f).effect(
            () -> new EffectInstance(Effects.REGENERATION, 100, 1), 1.0F).effect(
            () -> new EffectInstance(Effects.ABSORPTION, 2400, 0), 1.0F).setAlwaysEdible().build();
    public static final Food HOLY_JANTIQUIFIED_ALJAME = new Food.Builder().hunger(5).saturation(3.5F).effect(
            () -> new EffectInstance(Effects.REGENERATION, 400, 1), 1.0F).effect(
            () -> new EffectInstance(Effects.RESISTANCE, 6000, 0), 1.0F).effect(
            () -> new EffectInstance(Effects.FIRE_RESISTANCE, 6000, 0), 1.0F).effect(
            () -> new EffectInstance(Effects.ABSORPTION, 2400, 3), 1.0F).setAlwaysEdible().build();

    // Back Math 1.8.0:
    // Foods
    public static final Food GUAVA = new Food.Builder().hunger(5).saturation(0.5f).build();
    public static final Food JABUTICABA = new Food.Builder().hunger(3).saturation(0.4f).build();

    // Cut Fruits
    public static final Food HALVED_APPLE = new Food.Builder().hunger(2).saturation(0.15f).fastToEat().build();
    public static final Food HALVED_GOLDEN_APPLE = new Food.Builder().hunger(2).saturation(0.6f).effect(
            () -> new EffectInstance(Effects.REGENERATION, 50, 0), 1).effect(
            () -> new EffectInstance(Effects.ABSORPTION, 1200, 0), 1).setAlwaysEdible().fastToEat().build();
    public static final Food HALVED_ENCHANTED_GOLDEN_APPLE = new Food.Builder().hunger(2).saturation(0.6f).effect(
            () -> new EffectInstance(Effects.REGENERATION, 200, 0), 1).effect(
            () -> new EffectInstance(Effects.ABSORPTION, 1200, 1), 1).effect(
            () -> new EffectInstance(Effects.RESISTANCE, 3000, 0), 1).effect(
            () -> new EffectInstance(Effects.FIRE_RESISTANCE, 1200, 1), 1).setAlwaysEdible().fastToEat().build();
    public static final Food HALVED_CARROT = new Food.Builder().hunger(1).saturation(0.3f).fastToEat().build();
    public static final Food HALVED_SWEET_BERRIES = new Food.Builder().hunger(1).saturation(0.05f).fastToEat().build();
    public static final Food HALVED_BAKED_POTATO = new Food.Builder().hunger(2).saturation(0.3f).fastToEat().build();
    public static final Food HALVED_HONEY_BOTTLE = new Food.Builder().hunger(3).saturation(0.05f).fastToEat().build();
    public static final Food HALVED_ALJAME = new Food.Builder().hunger(2).saturation(1.75f).effect(() ->
            new EffectInstance(Effects.POISON, 100), 1.0f).effect(() ->
            new EffectInstance(Effects.BLINDNESS, 600), 1.0f).fastToEat().build();
    public static final Food HALVED_JANTIQUIFIED_ALJAME = new Food.Builder().hunger(2).saturation(1.75f).effect(
            () -> new EffectInstance(Effects.REGENERATION, 50, 1), 1.0F).effect(
            () -> new EffectInstance(Effects.ABSORPTION, 1200, 0), 1.0F).setAlwaysEdible().build();
    public static final Food HALVED_HOLY_JANTIQUIFIED_ALJAME = new Food.Builder().hunger(2).saturation(1.75f).effect(
            () -> new EffectInstance(Effects.REGENERATION, 200, 1), 1.0F).effect(
            () -> new EffectInstance(Effects.RESISTANCE, 3000, 0), 1.0F).effect(
            () -> new EffectInstance(Effects.FIRE_RESISTANCE, 3000, 0), 1.0F).effect(
            () -> new EffectInstance(Effects.ABSORPTION, 1200, 3), 1.0F).setAlwaysEdible().build();
    public static final Food HALVED_GUAVA = new Food.Builder().hunger(2).saturation(0.25f).fastToEat().build();
    public static final Food HALVED_JABUTICABA = new Food.Builder().hunger(1).saturation(0.2f).fastToEat().build();
    public static final Food ALJAMIC_BERRY = new Food.Builder().hunger(5).saturation(3.5f).build();
    public static final Food HALVED_ALJAMIC_BERRY = new Food.Builder().hunger(2).saturation(1.75f).fastToEat().build();
    public static final Food AMARACAMEL_JUICE = new Food.Builder().hunger(6).saturation(3.2f).build();
}
