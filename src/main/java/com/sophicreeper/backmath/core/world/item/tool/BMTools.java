package com.sophicreeper.backmath.core.world.item.tool;

import com.sophicreeper.backmath.core.tags.BMTags;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

@MethodsReturnNonnullByDefault
public class BMTools implements Tier {
    public final int harvestLevel;
    public final int maxUses;
    public final float efficiency;
    public final float attackDamage;
    public final int enchantmentValue;
    public final LazyLoadedValue<Ingredient> repairIngredient;

    public BMTools(int harvestLevel, int durability, float miningSpeed, float attackDamage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.harvestLevel = harvestLevel;
        this.maxUses = durability;
        this.efficiency = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }

    public int getUses() {
        return this.maxUses;
    }

    public float getSpeed() {
        return this.efficiency;
    }

    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    public int getLevel() {
        return this.harvestLevel;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public static class Butter extends BMTools {
        public Butter() {
            super(4, 200, 6.0F, 2.0F, 40, () -> Ingredient.of(Items.BREAD));
        }
    }
    public static class Talcum extends BMTools {
        public Talcum() {
            super(1, 720, 4.0F, 1.0F, 5, () -> Ingredient.of(Items.GOLD_INGOT));
        }
    }
    public static class Devil extends BMTools {
        public Devil() {
            super(2, 250, 6.0F, 2.0F, 14, () -> Ingredient.of(AxolotlTest.DEVIL_INGOT.get()));
        }
    }
    public static class RainbowPencil extends BMTools {
        public RainbowPencil() {
            super(3, 720, 5.0F, 43.0F, 69, () -> Ingredient.EMPTY);
        }
    }
    public static class Olive extends BMTools {
        public Olive() {
            super(3, 646, 4.0F, 1.0F, 69, () -> Ingredient.EMPTY);
        }
    }
    public static class Angelic extends BMTools {
        public Angelic() {
            super(2, 250, 6.0F, 2.0F, 14, () -> Ingredient.of(AxolotlTest.ANGELIC_INGOT.get()));
        }
    }
    public static class Milkllary extends BMTools {
        public Milkllary() {
            super(2, 450, 7.0F, 3.0F, 21, () -> Ingredient.of(AxolotlTest.MILKLLARY_INGOT.get()));
        }
    }
    public static class MidTerm extends BMTools {
        public MidTerm(float damage) {
            super(5, 4062, 12.0F, damage, 36, () -> Ingredient.of(BMTags.Items.SINGULARITIES_MID_TERM));
        }
    }
    public static class ObsidianInfusedMidTerm extends BMTools {
        public ObsidianInfusedMidTerm(float damage) {
            super(6, 8126, 16.0F, damage, 45, () -> Ingredient.of(BMTags.Items.SINGULARITIES_OBSIDIAN_INFUSED_MID_TERM));
        }
    }
    public static class Sparey extends BMTools {
        public Sparey(float damage) {
            super(4, 2031, 9.0F, damage, 12, () -> Ingredient.EMPTY);
        }
    }
    public static class MechMech extends BMTools {
        public MechMech() {
            super(3, 1561, 4.0F, 0.0F, 22, () -> Ingredient.of(AxolotlTest.DIAMOND_SHARD.get()));
        }
    }
    public static class Carewni extends BMTools {
        public Carewni() {
            super(0, 1758, 0.0f, 13.0f, 25, () -> Ingredient.EMPTY);
        }
    }
    public static class Persona extends BMTools {
        public Persona() {
            super(0, 1758, 0.0f, 8.0f, 13, () -> Ingredient.of(BMTags.Items.GEMS_PERSONA));
        }
    }
    public static class CorkOak extends BMTools {
        public CorkOak() {
            super(0, 59, 2.0f, 0.0f, 15, () -> Ingredient.EMPTY);
        }
    }
    public static class Guava extends BMTools {
        public Guava() {
            super(0, 59, 2.0f, 0.0f, 15, () -> Ingredient.of(AxolotlTest.GUAVA_PLANKS.get()));
        }
    }
    public static class Jabuticaba extends BMTools {
        public Jabuticaba() {
            super(0, 59, 2.0f, 0.0f, 15, () -> Ingredient.EMPTY);
        }
    }
    public static class Goldenwood extends BMTools {
        public Goldenwood() {
            super(0, 59, 2.0f, 0.0f, 15, () -> Ingredient.EMPTY);
        }
    }
    public static class AvondalicWillow extends BMTools {
        public AvondalicWillow() {
            super(0, 61, 2.2f, 0.4f, 16, () -> Ingredient.EMPTY);
        }
    }
    public static class CrystallineBirch extends BMTools {
        public CrystallineBirch() {
            super(0, 59, 2.0f, 0.0f, 15, () -> Ingredient.of(AxolotlTest.CRYSTALLINE_BIRCH_PLANKS.get()));
        }
    }
    public static class Aljanwood extends BMTools {
        public Aljanwood() {
            super(0, 59, 2.0f, 0.0f, 15, () -> Ingredient.of(AxolotlTest.ALJANWOOD_PLANKS.get()));
        }
    }
    public static class Aljancap extends BMTools {
        public Aljancap() {
            super(0, 68, 2.2f, 0.0f, 13, () -> Ingredient.of(AxolotlTest.ALJANCAP_PLANKS.get()));
        }
    }
    public static class Insomnian extends BMTools {
        public Insomnian() {
            super(0, 72, 2.3f, 0.0f, 13, () -> Ingredient.of(AxolotlTest.INSOMNIAN_PLANKS.get()));
        }
    }
    public static class Aljanstone extends BMTools {
        public Aljanstone() {
            super(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.of(BMTags.Items.ALJANSTONE_CRAFTING_MATERIALS));
        }
    }
    public static class Sleepingstone extends BMTools {
        public Sleepingstone() {
            super(1, 161, 4.5F, 1.0F, 5, () -> Ingredient.of(AxolotlTest.SLEEPINGSTONE.get()));
        }
    }
    public static class Aljameed extends BMTools {
        public Aljameed() {
            super(2, 250, 6.0F, 2.0F, 14, () -> Ingredient.of(BMTags.Items.INGOTS_ALJAMEED));
        }
    }
    public static class Aljansteel extends BMTools {
        public Aljansteel() {
            super(3, 500, 6.5F, 3, 16, () -> Ingredient.of(BMTags.Items.INGOTS_ALJANSTEEL));
        }
    }
    public static class Moonering extends BMTools {
        public Moonering() {
            super(3, 1561, 8.0F, 3.0F, 10, () -> Ingredient.of(BMTags.Items.INGOTS_MOONERING));
        }
    }
    public static class JantiquifiedMoonering extends BMTools {
        public JantiquifiedMoonering() {
            super(4, 2031, 10.0F, 4.5F, 14, () -> Ingredient.of(BMTags.Items.INGOTS_MOONERING));
        }
    }
}
