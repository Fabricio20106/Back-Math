package com.sophicreeper.backmath.item.custom.food;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class BMFoods {
    public static final Food TODDY = new Food.Builder().hunger(10).saturation(1).effect(() -> new EffectInstance(Effects.STRENGTH, 1200), 1).build();
    public static final Food ALJAME = new Food.Builder().hunger(5).saturation(3.5F).effect(() ->
            new EffectInstance(Effects.POISON, 100), 1).effect(() ->
            new EffectInstance(Effects.BLINDNESS, 600), 1).build();
    public static final Food LAGUSTA = new Food.Builder().hunger(9).saturation(0.7F).build();
    public static final Food AMARACAMEL = new Food.Builder().hunger(5).saturation(2.2F).build();
    public static final Food ALJAME_TEACUP = new Food.Builder().hunger(4).saturation(1.2F).effect(
            () -> new EffectInstance(Effects.REGENERATION, 200), 1).effect(
            // 1 in a 1,000,000 (million)
            () -> new EffectInstance(Effects.POISON, 1200, 100), 0.000001F).effect(
            () -> new EffectInstance(Effects.SATURATION, 100), 0.5F).build();
    public static final Food PINE_JELLY = new Food.Builder().hunger(4).saturation(0.3F).effect(
            () -> new EffectInstance(Effects.ABSORPTION, 6000, 1), 1).build();
    public static final Food JANTIQUIFIED_ALJAME = new Food.Builder().hunger(4).saturation(1.2F).effect(
            () -> new EffectInstance(Effects.REGENERATION, 100, 1), 1).effect(
            () -> new EffectInstance(Effects.ABSORPTION, 2400, 0), 1).setAlwaysEdible().build();
    public static final Food HOLY_JANTIQUIFIED_ALJAME = new Food.Builder().hunger(4).saturation(1.2F).effect(
            () -> new EffectInstance(Effects.REGENERATION, 400, 1), 1).effect(
            () -> new EffectInstance(Effects.RESISTANCE, 6000, 0), 1).effect(
            () -> new EffectInstance(Effects.FIRE_RESISTANCE, 6000, 0), 1).effect(
            () -> new EffectInstance(Effects.ABSORPTION, 2400, 3), 1).setAlwaysEdible().build();

    // Ported from AxolotlTest.
    public static final Food CHOCCY_MILK_BUCKET = new Food.Builder().hunger(5).saturation(0.8F).effect(
            () -> new EffectInstance(Effects.SPEED, 200, 1), 1).effect(
            () -> new EffectInstance(Effects.HASTE, 100, 1), 1).build();
    public static final Food CHOCCY_MILK_BOTTLE = new Food.Builder().hunger(5).saturation(0.8F).effect( // Saturation was 6.5F.
            () -> new EffectInstance(Effects.SPEED, 100, 0), 1).effect(
            () -> new EffectInstance(Effects.HASTE, 50, 0), 0.5F).build();
    public static final Food RAW_MINCED_MEAT = new Food.Builder().hunger(1).saturation(0.3F).fastToEat().build();
    public static final Food COOKED_MINCED_MEAT = new Food.Builder().hunger(3).saturation(1.67F).fastToEat().build();
    public static final Food WATER_TALCUM_POWDER = new Food.Builder().hunger(4).saturation(0.3F).build();
    public static final Food WATER_JAM_BREAD = new Food.Builder().hunger(4).saturation(0.6F).build();
    public static final Food HILLARY_JAM_BREAD = new Food.Builder().hunger(7).saturation(2.65F).build();
    public static final Food MILKLLARY_JAM_BREAD = new Food.Builder().hunger(10).saturation(0.3F).build();
    public static final Food BERRY_JAM_BREAD = new Food.Builder().hunger(4).saturation(0.6F).build();
    public static final Food HOT_SOPHIE_AND_COLD_FABRICIO_MEAL = new Food.Builder().hunger(2).saturation(4.75F).build();

    // Back Math 1.8.0:
    // Foods
    public static final Food GUAVA = new Food.Builder().hunger(5).saturation(0.5F).build();
    public static final Food JABUTICABA = new Food.Builder().hunger(3).saturation(0.4F).build();

    // Cut Fruits
    public static final Food HALVED_APPLE = new Food.Builder().hunger(2).saturation(0.15F).fastToEat().build();
    public static final Food HALVED_GOLDEN_APPLE = new Food.Builder().hunger(2).saturation(0.6F).effect(
            () -> new EffectInstance(Effects.REGENERATION, 50, 0), 1).effect(
            () -> new EffectInstance(Effects.ABSORPTION, 1200, 0), 1).setAlwaysEdible().fastToEat().build();
    public static final Food HALVED_ENCHANTED_GOLDEN_APPLE = new Food.Builder().hunger(2).saturation(0.6F).effect(
            () -> new EffectInstance(Effects.REGENERATION, 200, 0), 1).effect(
            () -> new EffectInstance(Effects.ABSORPTION, 1200, 1), 1).effect(
            () -> new EffectInstance(Effects.RESISTANCE, 3000, 0), 1).effect(
            () -> new EffectInstance(Effects.FIRE_RESISTANCE, 1200, 1), 1).setAlwaysEdible().fastToEat().build();
    public static final Food HALVED_CARROT = new Food.Builder().hunger(1).saturation(0.3F).fastToEat().build();
    public static final Food HALVED_SWEET_BERRIES = new Food.Builder().hunger(1).saturation(0.05F).fastToEat().build();
    public static final Food HALVED_BAKED_POTATO = new Food.Builder().hunger(2).saturation(0.3F).fastToEat().build();
    public static final Food HALVED_HONEY_BOTTLE = new Food.Builder().hunger(3).saturation(0.05F).fastToEat().build();
    public static final Food HALVED_ALJAME = new Food.Builder().hunger(2).saturation(1.75F).effect(() ->
            new EffectInstance(Effects.POISON, 100), 1).effect(() ->
            new EffectInstance(Effects.BLINDNESS, 600), 1).fastToEat().build();
    public static final Food HALVED_JANTIQUIFIED_ALJAME = new Food.Builder().hunger(2).saturation(1.75F).effect(
            () -> new EffectInstance(Effects.REGENERATION, 50, 1), 1).effect(
            () -> new EffectInstance(Effects.ABSORPTION, 1200, 0), 1).setAlwaysEdible().build();
    public static final Food HALVED_HOLY_JANTIQUIFIED_ALJAME = new Food.Builder().hunger(2).saturation(1.75F).effect(
            () -> new EffectInstance(Effects.REGENERATION, 200, 1), 1).effect(
            () -> new EffectInstance(Effects.RESISTANCE, 3000, 0), 1).effect(
            () -> new EffectInstance(Effects.FIRE_RESISTANCE, 3000, 0), 1).effect(
            () -> new EffectInstance(Effects.ABSORPTION, 1200, 3), 1).setAlwaysEdible().build();
    public static final Food HALVED_GUAVA = new Food.Builder().hunger(2).saturation(0.25F).fastToEat().build();
    public static final Food HALVED_JABUTICABA = new Food.Builder().hunger(1).saturation(0.2F).fastToEat().build();
    public static final Food ALJAMIC_BERRY = new Food.Builder().hunger(5).saturation(3.5F).build();
    public static final Food HALVED_ALJAMIC_BERRY = new Food.Builder().hunger(2).saturation(1.75F).fastToEat().build();
    public static final Food AMARACAMEL_JUICE = new Food.Builder().hunger(6).saturation(3.2F).build();

    // Ported from AxolotlTest.
    public static final Food FRIED_EGG_BREAD = new Food.Builder().hunger(5).saturation(0.93F).build();
    public static final Food BREAD_WITH_PAO = new Food.Builder().hunger(10).saturation(0.12F).build();
}
