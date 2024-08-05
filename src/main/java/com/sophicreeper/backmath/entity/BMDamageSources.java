package com.sophicreeper.backmath.entity;

import net.minecraft.util.DamageSource;

public class BMDamageSources {
    public static final DamageSource CHOCOGLUED = new DamageSource("chocoglued").setProjectile();
    public static final DamageSource MID_TERM_ARMOR_INSTABILITY = new DamageSource("mid_term_armor_instability").bypassArmor();
    public static final DamageSource PATIENCE_TEA = new DamageSource("patience_tea").bypassMagic().bypassArmor().setMagic();
    public static final DamageSource POISON_ROSE = new DamageSource("poison_rose").bypassArmor();
    public static final DamageSource TEMPERATURE_MEAL = new DamageSource("temperature_meal");
    public static final DamageSource WATER_TALC_POWDER = new DamageSource("water_talc_powder").bypassMagic();
    public static final DamageSource WENT_AMERICANAS = new DamageSource("went_americanas").bypassArmor();
    public static final DamageSource WENT_FOOD_AND_DRINKS = new DamageSource("went_food_and_drinks").bypassArmor();
}
