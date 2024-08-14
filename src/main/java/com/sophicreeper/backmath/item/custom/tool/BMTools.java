package com.sophicreeper.backmath.item.custom.tool;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class BMTools implements IItemTier {
    public final int level;
    public final int durability;
    public final float miningSpeed;
    public final float attackDamage;
    public final int enchantmentValue;
    public final Supplier<Ingredient> repairIngredient;

    public BMTools(int level, int durability, float miningSpeed, float attackDamage, int enchValue, Supplier<Ingredient> repairIngredient) {
        this.level = level;
        this.durability = durability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantmentValue = enchValue;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getUses() {
        return this.durability;
    }

    @Override
    public float getSpeed() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    @Nonnull
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
