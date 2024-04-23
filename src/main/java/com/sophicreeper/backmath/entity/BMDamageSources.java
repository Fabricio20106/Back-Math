package com.sophicreeper.backmath.entity;

import net.minecraft.util.DamageSource;

public class BMDamageSources {
    public static final DamageSource HOT_AND_COLD_MEAL = new DamageSource("hotAndColdMeal");
    public static final DamageSource POISON_ROSE = new DamageSource("poisonRose").bypassArmor();
    public static final DamageSource WATER_TALC_POWDER = new DamageSource("waterTalcPowder").bypassMagic();
    public static final DamageSource MID_TERM_ARMOR_INSTABILITY = new DamageSource("midTermArmorInstability").bypassArmor();
    public static final DamageSource PATIENCE_TEA = new DamageSource("patienceTea").bypassMagic().bypassArmor().setMagic();
    public static final DamageSource CHOCOGLUED = new DamageSource("chocoglued").setProjectile();
}
