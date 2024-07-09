package com.sophicreeper.backmath.item.custom.tool;

import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class BMTools implements IItemTier {
    public final int harvestLevel;
    public final int maxUses;
    public final float efficiency;
    public final float attackDamage;
    public final int enchantmentValue;
    public final Supplier<Ingredient> repairIngredient;

    public BMTools(int harvestLevel, int durability, float miningSpeed, float attackDamage, int enchValue, Supplier<Ingredient> repairIngredient) {
        this.harvestLevel = harvestLevel;
        this.maxUses = durability;
        this.efficiency = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantmentValue = enchValue;
        this.repairIngredient = repairIngredient;
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

    @Nonnull
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public static class Butter extends BMTools {
        public Butter() {
            super(4, 200, 6, 2, 40, () -> Ingredient.of(Items.BREAD));
        }
    }
    public static class GoldenPatty extends BMTools {
        public GoldenPatty() {
            super(0, 32, 12, 0, 22, () -> Ingredient.of(BMTags.Items.INGOTS_CHRISTIAN_MID_TERM));
        }
    }
    public static class Talcum extends BMTools {
        public Talcum() {
            super(1, 720, 4, 1, 5, () -> Ingredient.of(Tags.Items.INGOTS_GOLD));
        }
    }
    public static class Devil extends BMTools {
        public Devil() {
            super(2, 250, 6, 2, 14, () -> Ingredient.of(BMTags.Items.INGOTS_DEVIL));
        }
    }
    public static class RainbowPencil extends BMTools {
        public RainbowPencil() {
            super(3, 720, 5, 43, 69, () -> Ingredient.EMPTY);
        }
    }
    public static class Olive extends BMTools {
        public Olive() {
            super(3, 646, 4, 1, 69, () -> Ingredient.EMPTY);
        }
    }
    public static class Angelic extends BMTools {
        public Angelic() {
            super(2, 250, 6, 2, 14, () -> Ingredient.of(BMTags.Items.INGOTS_ANGELIC));
        }
    }
    public static class Milkllary extends BMTools {
        public Milkllary() {
            super(2, 450, 7, 3, 21, () -> Ingredient.of(BMTags.Items.INGOTS_MILKLLARY));
        }
    }
    public static class MidTerm extends BMTools {
        public MidTerm() {
            super(5, 4062, 12, 43, 36, () -> Ingredient.of(BMTags.Items.SINGULARITIES_MID_TERM));
        }
    }
    public static class ObsidianInfusedMidTerm extends BMTools {
        public ObsidianInfusedMidTerm() {
            super(6, 8126, 16, 58, 45, () -> Ingredient.of(BMTags.Items.SINGULARITIES_OBSIDIAN_INFUSED_MID_TERM));
        }
    }
    public static class MidTermSparey extends BMTools {
        public MidTermSparey() {
            super(5, 4062, 12, 61, 36, () -> Ingredient.of(BMTags.Items.SINGULARITIES_MID_TERM));
        }
    }
    public static class ObsidianInfusedMidTermSparey extends BMTools {
        public ObsidianInfusedMidTermSparey() {
            super(4, 2031, 9, 76, 12, () -> Ingredient.of(BMTags.Items.SINGULARITIES_OBSIDIAN_INFUSED_MID_TERM));
        }
    }
    public static class Sparey extends BMTools {
        public Sparey() {
            super(4, 2031, 9, 18, 12, () -> Ingredient.of(BMTags.Items.INGOTS_CHRISTIAN_MID_TERM));
        }
    }
    public static class DevilSparey extends BMTools {
        public DevilSparey() {
            super(4, 2031, 9, 18, 12, () -> Ingredient.of(BMTags.Items.INGOTS_DEVIL));
        }
    }
    public static class MechMech extends BMTools {
        public MechMech() {
            super(3, 1561, 4, 0, 22, () -> Ingredient.of(BMTags.Items.NUGGETS_DIAMOND));
        }
    }
    public static class Carewni extends BMTools {
        public Carewni() {
            super(0, 1758, 0, 13, 25, () -> Ingredient.of(BMTags.Items.INGOTS_CHRISTIAN_MID_TERM));
        }
    }
    public static class Persona extends BMTools {
        public Persona() {
            super(0, 1758, 0, 8, 13, () -> Ingredient.of(BMTags.Items.GEMS_PERSONA));
        }
    }
    public static class Bread extends BMTools {
        public Bread() {
            super(0, 150, 0, 1, 13, () -> Ingredient.of(Items.BREAD));
        }
    }
    public static class Tabu extends BMTools {
        public Tabu() {
            super(1, 1250, 3, 2, 20, () -> Ingredient.of(BMTags.Items.TABU_SMELTABLES));
        }
    }
    public static class KarateTrainingStick extends BMTools {
        public KarateTrainingStick() {
            super(0, 1561, 8, 3, 25, () -> Ingredient.of(Tags.Items.RODS_WOODEN));
        }
    }
    public static class CorkOak extends BMTools {
        public CorkOak() {
            super(0, 59, 2, 0, 15, () -> Ingredient.of(AxolotlTest.CORK_OAK_PLANKS.get()));
        }
    }
    public static class Guava extends BMTools {
        public Guava() {
            super(0, 59, 2, 0, 15, () -> Ingredient.of(AxolotlTest.GUAVA_PLANKS.get()));
        }
    }
    public static class Jabuticaba extends BMTools {
        public Jabuticaba() {
            super(0, 59, 2, 0, 15, () -> Ingredient.of(AxolotlTest.JABUTICABA_PLANKS.get()));
        }
    }
    public static class Goldenwood extends BMTools {
        public Goldenwood() {
            super(0, 59, 2, 0, 15, () -> Ingredient.of(AxolotlTest.GOLDENWOOD_PLANKS.get()));
        }
    }
    public static class AvondalicWillow extends BMTools {
        public AvondalicWillow() {
            super(0, 61, 2.2F, 0.4F, 16, () -> Ingredient.of(AxolotlTest.AVONDALIC_WILLOW_PLANKS.get()));
        }
    }
    public static class CrystallineBirch extends BMTools {
        public CrystallineBirch() {
            super(0, 59, 2, 0, 15, () -> Ingredient.of(AxolotlTest.CRYSTALLINE_BIRCH_PLANKS.get()));
        }
    }
    public static class Aljanwood extends BMTools {
        public Aljanwood() {
            super(0, 59, 2, 0, 15, () -> Ingredient.of(AxolotlTest.ALJANWOOD_PLANKS.get()));
        }
    }
    public static class Aljancap extends BMTools {
        public Aljancap() {
            super(0, 68, 2.2F, 0, 13, () -> Ingredient.of(AxolotlTest.ALJANCAP_PLANKS.get()));
        }
    }
    public static class Insomnian extends BMTools {
        public Insomnian() {
            super(0, 72, 2.3F, 0, 13, () -> Ingredient.of(AxolotlTest.INSOMNIAN_PLANKS.get()));
        }
    }
    public static class Aljanstone extends BMTools {
        public Aljanstone() {
            super(1, 131, 4, 1, 5, () -> Ingredient.of(BMTags.Items.ALJANSTONE_CRAFTING_MATERIALS));
        }
    }
    public static class Sleepingstone extends BMTools {
        public Sleepingstone() {
            super(1, 161, 4.5F, 1, 5, () -> Ingredient.of(AxolotlTest.SLEEPINGSTONE.get()));
        }
    }
    public static class Aljameed extends BMTools {
        public Aljameed() {
            super(2, 250, 6, 2, 14, () -> Ingredient.of(BMTags.Items.INGOTS_ALJAMEED));
        }
    }
    public static class Aljansteel extends BMTools {
        public Aljansteel() {
            super(3, 500, 6.5F, 3, 16, () -> Ingredient.of(BMTags.Items.INGOTS_ALJANSTEEL));
        }
    }
    public static class Moonering extends BMTools {
        public Moonering() {
            super(3, 1561, 8, 3, 10, () -> Ingredient.of(BMTags.Items.INGOTS_MOONERING));
        }
    }
    public static class JantiquifiedMoonering extends BMTools {
        public JantiquifiedMoonering() {
            super(4, 2031, 10, 4.5F, 14, () -> Ingredient.of(BMTags.Items.INGOTS_MOONERING));
        }
    }
}
