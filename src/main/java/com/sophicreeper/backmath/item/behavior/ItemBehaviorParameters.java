package com.sophicreeper.backmath.item.behavior;

import com.google.common.collect.Lists;
import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.effect.BMEffectInstance;
import com.sophicreeper.backmath.effect.BMEffects;
import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvents;

import java.util.List;

public class ItemBehaviorParameters {
    // Durability bars
    public static final int MID_TERM_DURABILITY = BMConfigs.COMMON_CONFIGS.midTermCustomDurabilityBar.get();
    public static final int SPAREY_DURABILITY = BMConfigs.COMMON_CONFIGS.spareyCustomDurabilityBar.get();

    // Food settings
    public static final FoodSettings FOOD = new FoodSettings().animation(UseAction.EAT).consumeSound(SoundEvents.GENERIC_EAT);
    public static final FoodSettings DRINK = new FoodSettings(true);
    public static final FoodSettings BOTTLE_DRINK = new FoodSettings(true).defaultRemainder(() -> Items.GLASS_BOTTLE);
    public static final FoodSettings BUCKET_DRINK = new FoodSettings(true).defaultRemainder(() -> Items.BUCKET);
    public static final FoodSettings ALJAMIC_BOTTLE_DRINK = new FoodSettings(true).defaultRemainder(AxolotlTest.ALJAMIC_GLASS_BOTTLE);
    public static final FoodSettings JAM = new FoodSettings(true).useDuration(40).animation(UseAction.EAT).consumeSound(SoundEvents.HONEY_DRINK).defaultRemainder(AxolotlTest.JAM_POT);
    public static final FoodSettings SPICE_POT = new FoodSettings(true).useDuration(40).animation(UseAction.EAT).consumeSound(SoundEvents.HONEY_DRINK).defaultRemainder(AxolotlTest.SPICE_POT);
    public static final FoodSettings WINE = new FoodSettings(true).defaultRemainder(AxolotlTest.CORK_STOPPER).useDuration(40);
    public static final FoodSettings POPSICLE = new FoodSettings().animation(UseAction.EAT).consumeSound(SoundEvents.GENERIC_EAT).defaultRemainder(() -> Items.STICK);

    public static List<EffectInstance> getPeaceTeaEffects() {
        List<EffectInstance> effects = Lists.newArrayList(new EffectInstance(Effects.ABSORPTION, 6000), new EffectInstance(Effects.HEALTH_BOOST, 6000), new EffectInstance(Effects.HEAL, 6000), new EffectInstance(Effects.REGENERATION, 6000),
                new EffectInstance(Effects.MOVEMENT_SPEED, 6000), new EffectInstance(Effects.DIG_SPEED, 6000), new EffectInstance(Effects.DAMAGE_BOOST, 6000), new EffectInstance(Effects.JUMP, 6000),
                new EffectInstance(Effects.DAMAGE_RESISTANCE, 6000), new EffectInstance(Effects.FIRE_RESISTANCE, 6000), new EffectInstance(Effects.WATER_BREATHING, 6000),
                new EffectInstance(Effects.NIGHT_VISION, 6000), new EffectInstance(Effects.SATURATION, 6000), new EffectInstance(Effects.LUCK, 6000), new EffectInstance(Effects.SLOW_FALLING, 6000),
                new EffectInstance(Effects.CONDUIT_POWER, 6000), new EffectInstance(Effects.DOLPHINS_GRACE, 6000), new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 6000),
                new BMEffectInstance(BMEffects.MOOD, 6000), new BMEffectInstance(BMEffects.SUPERCHARGED, 6000));
        if (BMConfigs.COMMON_CONFIGS.peaceTeaInvisibilityToggle.get()) effects.add(new EffectInstance(Effects.INVISIBILITY, 6000));
        if (BMConfigs.COMMON_CONFIGS.peaceTeaGlowingToggle.get()) effects.add(new EffectInstance(Effects.GLOWING, 6000));
        return effects;
    }
}
