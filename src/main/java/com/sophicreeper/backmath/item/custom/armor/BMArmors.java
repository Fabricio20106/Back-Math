package com.sophicreeper.backmath.item.custom.armor;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.util.BMTags;
import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

public class BMArmors implements IArmorMaterial {
    private static final int[] DURABILITY_MUL_ARRAY = new int[] {13, 15, 16, 11};
    private final String name;
    private final int durablityMul;
    private final int[] armorPerPiece;
    private final int enchValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackRes;
    private final Supplier<Ingredient> repairIngredient;

    public BMArmors(String name, int durabilityMul, int[] armorPerPiece, int enchValue, SoundEvent equipSound, float toughness, float knockbackRes, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durablityMul = durabilityMul;
        this.armorPerPiece = armorPerPiece;
        this.enchValue = enchValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackRes = knockbackRes;
        this.repairIngredient = repairIngredient;
    }

    public int getDurabilityForSlot(EquipmentSlotType slot) {
        return DURABILITY_MUL_ARRAY[slot.getIndex()] * this.durablityMul;
    }

    public int getDefenseForSlot(EquipmentSlotType slot) {
        return this.armorPerPiece[slot.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchValue;
    }

    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackRes;
    }

    public static class Angelic extends BMArmors {
        public Angelic() {
            super(BackMath.MOD_ID + ":angelic", 15, new int[] {2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0, 0.01F, () -> Ingredient.of(BMTags.Items.INGOTS_ANGELIC));
        }
    }
    public static class Devil extends BMArmors {
        public Devil() {
            super(BackMath.MOD_ID + ":devil", 18, new int[] {3, 5, 6, 3}, 11, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMTags.Items.INGOTS_DEVIL));
        }
    }
    public static class MidTerm extends BMArmors {
        public MidTerm() {
            super(BackMath.MOD_ID + ":mid_term", 47, new int[] {8, 12, 14, 8}, 34, SoundEvents.ARMOR_EQUIP_NETHERITE, 11, 0.3F, () -> Ingredient.of(BMTags.Items.SINGULARITIES_MID_TERM));
        }
    }
    public static class ObsidianInfusedMidTerm extends BMArmors {
        public ObsidianInfusedMidTerm() {
            super(BackMath.MOD_ID + ":obsidian_infused_mid_term", 53, new int[] {12, 18, 16, 12}, 42, SoundEvents.ARMOR_EQUIP_NETHERITE, 15, 0.5F, () ->
                    Ingredient.of(BMTags.Items.SINGULARITIES_OBSIDIAN_INFUSED_MID_TERM));
        }
    }
    public static class CatTiara extends BMArmors {
        public CatTiara() {
            super(BackMath.MOD_ID + ":cat_tiara", 37, new int[] {3, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3, 0.1F, () -> Ingredient.of(Items.LIGHT_BLUE_WOOL));
        }
    }
    public static class DogTiara extends BMArmors {
        public DogTiara() {
            super(BackMath.MOD_ID + ":dog_tiara", 13, new int[] {0, 0, 0, 3}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0, () -> Ingredient.of(Items.BROWN_WOOL));
        }
    }
    public static class YellowKarateHeadband extends BMArmors {
        public YellowKarateHeadband() {
            super(BackMath.MOD_ID + ":karate_band", 4, new int[] {0, 0, 0, 1}, 63, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0, () -> Ingredient.of(Items.YELLOW_WOOL));
        }
    }
    public static class GoldenHalo extends BMArmors {
        public GoldenHalo() {
            super(BackMath.MOD_ID + ":golden_halo", 4, new int[] {0, 0, 0, 2}, 13, SoundEvents.ARMOR_EQUIP_GOLD, 0, 0, () -> Ingredient.of(Tags.Items.INGOTS_GOLD));
        }
    }
    public static class Glasses extends BMArmors {
        public Glasses(String glassType) {
            super(BackMath.MOD_ID + ":" + glassType + "_glasses", 4, new int[] {0, 0, 0, 0}, 13, SoundEvents.ARMOR_EQUIP_CHAIN, 0, 0, () -> Ingredient.of(Tags.Items.GLASS));
        }
    }
    public static class ArcherLuciaVest extends BMArmors {
        public ArcherLuciaVest() {
            super(BackMath.MOD_ID + ":archer_lucia_vest", 15, new int[] {2, 4, 5, 2}, 18, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0.05f, () -> Ingredient.of(BMTags.Items.INGOTS_MILKLLARY));
        }
    }
    public static class Milkllary extends BMArmors {
        public Milkllary() {
            super(BackMath.MOD_ID + ":milkllary", 15, new int[] {3, 6, 5, 3}, 18, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMTags.Items.INGOTS_MILKLLARY));
        }
    }
    public static class Jantskin extends BMArmors {
        public Jantskin() {
            super(BackMath.MOD_ID + ":jantskin", 5, new int[] {1, 3, 2, 1}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0, () -> Ingredient.of(AxolotlTest.JANTSKIN.get()));
        }
    }
    public static class Aljameed extends BMArmors {
        public Aljameed() {
            super(BackMath.MOD_ID + ":aljameed", 15, new int[] {2, 6, 5, 2}, 15, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMTags.Items.INGOTS_ALJAMEED));
        }
    }
    public static class AljamicBone extends BMArmors {
        public AljamicBone() {
            super(BackMath.MOD_ID + ":aljamic_bone", 15, new int[] {2, 6, 5, 2}, 15, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMTags.Items.INGOTS_ALJAMEED));
        }
    }
    public static class Moonering extends BMArmors {
        public Moonering() {
            super(BackMath.MOD_ID + ":moonering", 33, new int[] {3, 8, 6, 3}, 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2, 0, () -> Ingredient.of(BMTags.Items.INGOTS_MOONERING));
        }
    }
    public static class JantiquifiedMoonering extends BMArmors {
        public JantiquifiedMoonering() {
            super(BackMath.MOD_ID + ":jantiquified_moonering", 37, new int[] {4, 9, 7, 4}, 12, SoundEvents.ARMOR_EQUIP_NETHERITE, 3, 0.05F, () -> Ingredient.of(BMTags.Items.INGOTS_MOONERING));
        }
    }
    public static class ArcherFabricioVest extends BMArmors {
        public ArcherFabricioVest() {
            super(BackMath.MOD_ID + ":archer_fabricio_vest", 15, new int[] {3, 4, 4, 2}, 18, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0.05f, () -> Ingredient.of(BMTags.Items.INGOTS_ALJAMEED));
        }
    }
    public static class Bakugou extends BMArmors {
        public Bakugou() {
            super(BackMath.MOD_ID + ":bakugou", 5, new int[]{2, 3, 4, 2}, 13, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0, () -> Ingredient.EMPTY);
        }
    }
    public static class InsomniaSophieSleepwear extends BMArmors {
        public InsomniaSophieSleepwear() {
            super(BackMath.MOD_ID + ":insomnia_sophie_sleepwear", 5, new int[]{1, 3, 2, 1}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0, () -> Ingredient.EMPTY);
        }
    }
    public static class HardenedAmaracamel extends BMArmors {
        public HardenedAmaracamel() {
            super(BackMath.MOD_ID + ":hardened_amaracamel", 17, new int[] {2, 5, 6, 2}, 12, SoundEvents.ARMOR_EQUIP_CHAIN, 0, 0, () ->
                    Ingredient.of(BMTags.Items.HARDENED_AMARACAMEL_MATERIALS));
        }
    }
    public static class CandyYellowTurtle extends BMArmors {
        public CandyYellowTurtle() {
            super(BackMath.MOD_ID + ":candy_yellow_turtle", 25, new int[] {2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_TURTLE, 0, 0, () -> Ingredient.of(Items.SCUTE));
        }
    }
    public static class CandyPinkTurtle extends BMArmors {
        public CandyPinkTurtle() {
            super(BackMath.MOD_ID + ":candy_pink_turtle", 25, new int[] {2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_TURTLE, 0, 0, () -> Ingredient.of(Items.SCUTE));
        }
    }
    public static class GoldenPlated extends BMArmors {
        public GoldenPlated() {
            super(BackMath.MOD_ID + ":golden_plated", 17, new int[] {2, 6, 5, 2}, 15, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMTags.Items.INGOTS_CHRISTIAN_MID_TERM));
        }
    }
    public static class QueenLucyShirt extends BMArmors {
        public QueenLucyShirt(String design) {
            super(BackMath.MOD_ID + ":qls_" + design, 2, new int[] {0, 1, 0, 0}, 8, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0, () -> Ingredient.of(ItemTags.WOOL));
        }
    }

    // Warrior Helmets
    public static class WarriorHardenedAmaracamelHelmet extends BMArmors {
        public WarriorHardenedAmaracamelHelmet() {
            super(BackMath.MOD_ID + ":warrior_hardened_amaracamel", 17, new int[] {2, 5, 6, 2}, 12, SoundEvents.ARMOR_EQUIP_CHAIN, 0, 0, () ->
                    Ingredient.of(BMTags.Items.HARDENED_AMARACAMEL_MATERIALS));
        }
    }
    public static class WarriorDevilHelmet extends BMArmors {
        public WarriorDevilHelmet() {
            super(BackMath.MOD_ID + ":warrior_devil", 18, new int[] {3, 5, 6, 3}, 11, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMTags.Items.INGOTS_DEVIL));
        }
    }
    public static class WarriorAngelicHelmet extends BMArmors {
        public WarriorAngelicHelmet() {
            super(BackMath.MOD_ID + ":warrior_angelic", 15, new int[] {2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0, 0.01F, () -> Ingredient.of(BMTags.Items.INGOTS_ANGELIC));
        }
    }
    public static class WarriorMidTermHelmet extends BMArmors {
        public WarriorMidTermHelmet() {
            super(BackMath.MOD_ID + ":warrior_mid_term", 47, new int[] {8, 12, 14, 8}, 34, SoundEvents.ARMOR_EQUIP_NETHERITE, 11, 0.3F, () -> Ingredient.of(BMTags.Items.SINGULARITIES_MID_TERM));
        }
    }
    public static class WarriorObsidianInfusedMidTermHelmet extends BMArmors {
        public WarriorObsidianInfusedMidTermHelmet() {
            super(BackMath.MOD_ID + ":warrior_obsidian_infused_mid_term",53, new int[] {12, 18, 16, 12}, 42, SoundEvents.ARMOR_EQUIP_NETHERITE, 15, 0.5F, () ->
                    Ingredient.of(BMTags.Items.SINGULARITIES_OBSIDIAN_INFUSED_MID_TERM));
        }
    }
    public static class WarriorMilkllaryHelmet extends BMArmors {
        public WarriorMilkllaryHelmet() {
            super(BackMath.MOD_ID + ":warrior_milkllary", 18, new int[] {4, 7, 6, 4}, 21, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMTags.Items.INGOTS_MILKLLARY));
        }
    }
    public static class WarriorAljameedHelmet extends BMArmors {
        public WarriorAljameedHelmet() {
            super(BackMath.MOD_ID + ":warrior_aljameed", 15, new int[] {3, 6, 5, 2}, 15, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMTags.Items.INGOTS_ALJAMEED));
        }
    }
    public static class WarriorMooneringHelmet extends BMArmors {
        public WarriorMooneringHelmet() {
            super(BackMath.MOD_ID + ":warrior_moonering", 33, new int[] {4, 8, 6, 3}, 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 0, 0, () -> Ingredient.of(BMTags.Items.INGOTS_MOONERING));
        }
    }
    public static class WarriorJantiquifiedMooneringHelmet extends BMArmors {
        public WarriorJantiquifiedMooneringHelmet() {
            super(BackMath.MOD_ID + ":warrior_jantiquified_moonering", 40, new int[] {5, 10, 8, 5}, 14, SoundEvents.ARMOR_EQUIP_NETHERITE, 3, 0.05F, () -> Ingredient.of(
                    BMTags.Items.INGOTS_MOONERING));
        }
    }
}
