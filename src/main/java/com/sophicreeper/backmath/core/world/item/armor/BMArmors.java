package com.sophicreeper.backmath.core.world.item.armor;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.tags.BMTags;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

public class BMArmors implements IArmorMaterial {
    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyValue<Ingredient> repairIngredient;

    public BMArmors(String name, int damageFactor, int[] damageReductionAmountArray, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.maxDamageFactor = damageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = new LazyValue<>(repairIngredient);
    }

    public int getDurability(EquipmentSlotType slot) {
        return MAX_DAMAGE_ARRAY[slot.getIndex()] * this.maxDamageFactor;
    }

    public int getDamageReductionAmount(EquipmentSlotType slot) {
        return this.damageReductionAmountArray[slot.getIndex()];
    }

    public int getEnchantability() {
        return this.enchantmentValue;
    }

    public SoundEvent getSoundEvent() {
        return this.equipSound;
    }

    public Ingredient getRepairMaterial() {
        return this.repairIngredient.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    public static class Angelic extends BMArmors {
        public Angelic() {
            super("backmath:angelic", 15, new int[] {2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.01F, () ->
                    Ingredient.fromTag(BMTags.Items.INGOTS_ANGELIC));
        }
    }
    public static class Devil extends BMArmors {
        public Devil() {
            super("backmath:devil", 18, new int[] {3, 5, 6, 3}, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () ->
                    Ingredient.fromTag(BMTags.Items.INGOTS_DEVIL));
        }
    }
    public static class MidTerm extends BMArmors {
        public MidTerm() {
            super("backmath:mid_term", 47, new int[] {8, 12, 14, 8}, 34, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 11.0F, 0.3F,
                    () -> Ingredient.fromTag(BMTags.Items.SINGULARITIES_MID_TERM));
        }
    }
    public static class ObsidianInfusedMidTerm extends BMArmors {
        public ObsidianInfusedMidTerm() {
            super("backmath:obsidian_infused_mid_term", 53, new int[] {12, 18, 16, 12}, 42, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 15.0F, 0.5F,
                    () -> Ingredient.fromTag(BMTags.Items.SINGULARITIES_OBSIDIAN_INFUSED_MID_TERM));
        }
    }
    public static class CatTiara extends BMArmors {
        public CatTiara() {
            super(BackMath.MOD_ID + ":cat_tiara", 37, new int[] {3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F,
                    0.1F, () -> Ingredient.fromItems(Items.LIGHT_BLUE_WOOL));
        }
    }
    public static class DogTiara extends BMArmors {
        public DogTiara() {
            super(BackMath.MOD_ID + ":dog_tiara", 37, new int[] {3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 3.0F,
                    0.0f, () -> Ingredient.fromItems(Items.BROWN_WOOL));
        }
    }
    public static class YellowKarateHeadband extends BMArmors {
        public YellowKarateHeadband() {
            super("backmath:karate_band", 4, new int[] {1, 2, 3, 1}, 63, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0f,
                    0.0f, () -> Ingredient.EMPTY);
        }
    }
    public static class GoldenHalo extends BMArmors {
        public GoldenHalo() {
            super("backmath:golden_halo", 4, new int[] {2, 0, 0, 0}, 13, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0f,
                    0.0f, () -> Ingredient.fromTag(Tags.Items.INGOTS_GOLD));
        }
    }
    public static class ArcherLuciaVest extends BMArmors {
        public ArcherLuciaVest() {
            super("backmath:archer_lucia_vest", 15, new int[] {2, 4, 5, 2}, 18, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f,
                    0.05f, () -> Ingredient.fromTag(BMTags.Items.INGOTS_CHRISTIAN_MID_TERM));
        }
    }
    public static class Milkllary extends BMArmors {
        public Milkllary() {
            super("backmath:milkllary", 15, new int[] {3, 6, 5, 3}, 18, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f,
                    0.0f, () -> Ingredient.fromTag(BMTags.Items.INGOTS_MILKLLARY));
        }
    }
    public static class Jantskin extends BMArmors {
        public Jantskin() {
            super("backmath:jantskin", 5, new int[] {1, 3, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f,
                    0.0f, () -> Ingredient.fromItems(AxolotlTest.JANTSKIN.get()));
        }
    }
    public static class Aljameed extends BMArmors {
        public Aljameed() {
            super("backmath:aljameed", 15, new int[] {2, 6, 5, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f,
                    0.0f, () -> Ingredient.fromTag(BMTags.Items.INGOTS_ALJAMEED));
        }
    }
    public static class AljamicBone extends BMArmors {
        public AljamicBone() {
            super("backmath:aljamic_bone", 15, new int[] {2, 6, 5, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f,
                    0.0f, () -> Ingredient.fromTag(BMTags.Items.INGOTS_ALJAMEED));
        }
    }
    public static class Moonering extends BMArmors {
        public Moonering() {
            super("backmath:moonering", 33, new int[] {3, 8, 6, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0f,
                    0.0f, () -> Ingredient.fromTag(BMTags.Items.INGOTS_MOONERING));
        }
    }
    public static class ArcherFabricioVest extends BMArmors {
        public ArcherFabricioVest() {
            super("backmath:archer_fabricio_vest", 15, new int[] {3, 4, 4, 2}, 18, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f,
                    0.05f, () -> Ingredient.EMPTY);
        }
    }
    public static class Bakugou extends BMArmors {
        public Bakugou() {
            super("backmath:bakugou", 5, new int[]{2, 3, 4, 2}, 13, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f,
                    0.0f, () -> Ingredient.EMPTY);
        }
    }
    public static class InsomniaSophieSleepwear extends BMArmors {
        public InsomniaSophieSleepwear() {
            super("backmath:insomnia_sophie_sleepwear", 5, new int[]{1, 3, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f,
                    0.0f, () -> Ingredient.EMPTY);
        }
    }
    public static class HardenedAmaracamel extends BMArmors {
        public HardenedAmaracamel() {
            super("backmath:hardened_amaracamel", 17, new int[] {2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0f, 0.0f, () ->
                    Ingredient.fromItems(AxolotlTest.HARDENED_AMARACAMEL_BATTER.get()));
        }
    }
    public static class CandyYellowTurtle extends BMArmors {
        public CandyYellowTurtle() {
            super("backmath:candy_yellow_turtle", 25, new int[] {2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 0.0f, 0.0f, () ->
                    Ingredient.EMPTY);
        }
    }
    public static class CandyPinkTurtle extends BMArmors {
        public CandyPinkTurtle() {
            super("backmath:candy_pink_turtle", 25, new int[] {2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 0.0f, 0.0f, () ->
                    Ingredient.EMPTY);
        }
    }
    public static class GoldenPlated extends BMArmors {
        public GoldenPlated() {
            super("backmath:golden_plated", 17, new int[] {2, 6, 5, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0, 0,
                    () -> Ingredient.fromTag(BMTags.Items.INGOTS_CHRISTIAN_MID_TERM));
        }
    }

    // warrior helmets
    public static class WarriorHardenedAmaracamelHelmet extends BMArmors {
        public WarriorHardenedAmaracamelHelmet() {
            super("backmath:warrior_hardened_amaracamel", 17, new int[] {2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0f, 0.0f, () ->
                    Ingredient.fromItems(AxolotlTest.HARDENED_AMARACAMEL_BATTER.get()));
        }
    }
    public static class WarriorDevilHelmet extends BMArmors {
        public WarriorDevilHelmet() {
            super("backmath:warrior_devil", 18, new int[] {3, 5, 6, 3}, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () ->
                    Ingredient.fromTag(BMTags.Items.INGOTS_DEVIL));
        }
    }
    public static class WarriorAngelicHelmet extends BMArmors {
        public WarriorAngelicHelmet() {
            super("backmath:warrior_angelic", 15, new int[] {2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.01F, () ->
                    Ingredient.fromTag(BMTags.Items.INGOTS_ANGELIC));
        }
    }
    public static class WarriorMidTermHelmet extends BMArmors {
        public WarriorMidTermHelmet() {
            super("backmath:warrior_mid_term", 47, new int[] {8, 12, 14, 8}, 34, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 11.0F, 0.3F,
                    () -> Ingredient.fromTag(BMTags.Items.SINGULARITIES_MID_TERM));
        }
    }
    public static class WarriorAljameedHelmet extends BMArmors {
        public WarriorAljameedHelmet() {
            super("backmath:warrior_aljameed", 15, new int[] {3, 6, 5, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f,
                    0.0f, () -> Ingredient.fromTag(BMTags.Items.INGOTS_ALJAMEED));
        }
    }
    public static class WarriorMooneringHelmet extends BMArmors {
        public WarriorMooneringHelmet() {
            super("backmath:warrior_moonering", 33, new int[] {4, 8, 6, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0f,
                    0.0f, () -> Ingredient.fromTag(BMTags.Items.INGOTS_MOONERING));
        }
    }
}
