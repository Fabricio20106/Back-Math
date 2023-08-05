package com.sophicreeper.backmath.core.world.item.armor;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.tags.BMTags;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.Tags;

import java.util.EnumMap;
import java.util.function.Supplier;

public class BMArmors implements ArmorMaterial {
    private static final EnumMap<ArmorItem.Type, Integer> MAX_DAMAGE_ARRAY = Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
        map.put(ArmorItem.Type.BOOTS, 13);
        map.put(ArmorItem.Type.LEGGINGS, 15);
        map.put(ArmorItem.Type.CHESTPLATE, 16);
        map.put(ArmorItem.Type.HELMET, 11);
    });

    private final String name;
    private final int maxDamageFactor;
    private final EnumMap<ArmorItem.Type, Integer> damageReductionAmountArray;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    public BMArmors(String name, int damageFactor, EnumMap<ArmorItem.Type, Integer> damageReductionAmountArray, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.maxDamageFactor = damageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }

    public int getDurabilityForType(ArmorItem.Type slot) {
        return MAX_DAMAGE_ARRAY.get(slot) * this.maxDamageFactor;
    }

    public int getDefenseForType(ArmorItem.Type slot) {
        return this.damageReductionAmountArray.get(slot);
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
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
        return this.knockbackResistance;
    }

    public static class Angelic extends BMArmors {
        public Angelic() {
            super("backmath:angelic", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
            }), 9, SoundEvents.ARMOR_EQUIP_IRON, 0, 0.01F, () -> Ingredient.of(BMTags.Items.INGOTS_ANGELIC));
        }
    }
    public static class Devil extends BMArmors {
        public Devil() {
            super("backmath:devil", 18, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 3);
            }), 11, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMTags.Items.INGOTS_DEVIL));
        }
    }
    public static class MidTerm extends BMArmors {
        public MidTerm() {
            super("backmath:mid_term", 47, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 8);
                map.put(ArmorItem.Type.LEGGINGS, 12);
                map.put(ArmorItem.Type.CHESTPLATE, 14);
                map.put(ArmorItem.Type.HELMET, 8);
            }), 34, SoundEvents.ARMOR_EQUIP_NETHERITE, 11, 0.3F, () -> Ingredient.of(BMTags.Items.SINGULARITIES_MID_TERM));
        }
    }
    public static class ObsidianInfusedMidTerm extends BMArmors {
        public ObsidianInfusedMidTerm() {
            super("backmath:obsidian_infused_mid_term", 53, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 12);
                map.put(ArmorItem.Type.LEGGINGS, 16);
                map.put(ArmorItem.Type.CHESTPLATE, 18);
                map.put(ArmorItem.Type.HELMET, 12);
            }), 42, SoundEvents.ARMOR_EQUIP_NETHERITE, 15, 0.5F, () -> Ingredient.of(BMTags.Items.SINGULARITIES_OBSIDIAN_INFUSED_MID_TERM));
        }
    }
    public static class CatTiara extends BMArmors {
        public CatTiara() {
            super(BackMath.MOD_ID + ":cat_tiara", 37, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
            }), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3, 0.1F, () -> Ingredient.of(Items.LIGHT_BLUE_WOOL));
        }
    }
    public static class DogTiara extends BMArmors {
        public DogTiara() {
            super(BackMath.MOD_ID + ":dog_tiara", 37, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
            }), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 3, 0, () -> Ingredient.of(Items.BROWN_WOOL));
        }
    }
    public static class YellowKarateHeadband extends BMArmors {
        public YellowKarateHeadband() {
            super("backmath:karate_band", 4, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 2);
                map.put(ArmorItem.Type.CHESTPLATE, 3);
                map.put(ArmorItem.Type.HELMET, 1);
            }), 63, SoundEvents.ARMOR_EQUIP_GENERIC, 0, 0, () -> Ingredient.EMPTY);
        }
    }
    public static class GoldenHalo extends BMArmors {
        public GoldenHalo() {
            super("backmath:golden_halo", 4, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 0);
                map.put(ArmorItem.Type.LEGGINGS, 0);
                map.put(ArmorItem.Type.CHESTPLATE, 0);
                map.put(ArmorItem.Type.HELMET, 2);
            }), 13, SoundEvents.ARMOR_EQUIP_GOLD, 0, 0, () -> Ingredient.of(Tags.Items.INGOTS_GOLD));
        }
    }
    public static class ArcherLuciaVest extends BMArmors {
        public ArcherLuciaVest() {
            super("backmath:archer_lucia_vest", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 5);
                map.put(ArmorItem.Type.HELMET, 2);
            }), 18, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0.05f, () -> Ingredient.of(BMTags.Items.INGOTS_CHRISTIAN_MID_TERM));
        }
    }
    public static class Milkllary extends BMArmors {
        public Milkllary() {
            super("backmath:milkllary", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 3);
            }), 18, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMTags.Items.INGOTS_MILKLLARY));
        }
    }
    public static class Jantskin extends BMArmors {
        public Jantskin() {
            super("backmath:jantskin", 5, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 2);
                map.put(ArmorItem.Type.CHESTPLATE, 3);
                map.put(ArmorItem.Type.HELMET, 1);
            }), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0, () -> Ingredient.of(AxolotlTest.JANTSKIN.get()));
        }
    }
    public static class Aljameed extends BMArmors {
        public Aljameed() {
            super("backmath:aljameed", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
            }), 15, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMTags.Items.INGOTS_ALJAMEED));
        }
    }
    public static class AljamicBone extends BMArmors {
        public AljamicBone() {
            super("backmath:aljamic_bone", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
            }), 15, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMTags.Items.INGOTS_ALJAMEED));
        }
    }
    public static class Moonering extends BMArmors {
        public Moonering() {
            super("backmath:moonering", 33, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
            }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 0, 0, () -> Ingredient.of(BMTags.Items.INGOTS_MOONERING));
        }
    }
    public static class ArcherFabricioVest extends BMArmors {
        public ArcherFabricioVest() {
            super("backmath:archer_fabricio_vest", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 4);
                map.put(ArmorItem.Type.HELMET, 2);
            }), 18, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0.05f, () -> Ingredient.EMPTY);
        }
    }
    public static class Bakugou extends BMArmors {
        public Bakugou() {
            super("backmath:bakugou", 5, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 3);
                map.put(ArmorItem.Type.CHESTPLATE, 4);
                map.put(ArmorItem.Type.HELMET, 2);
            }), 13, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0, () -> Ingredient.EMPTY);
        }
    }
    public static class InsomniaSophieSleepwear extends BMArmors {
        public InsomniaSophieSleepwear() {
            super("backmath:insomnia_sophie_sleepwear", 5, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 2);
                map.put(ArmorItem.Type.CHESTPLATE, 3);
                map.put(ArmorItem.Type.HELMET, 1);
            }), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0, () -> Ingredient.EMPTY);
        }
    }
    public static class HardenedAmaracamel extends BMArmors {
        public HardenedAmaracamel() {
            super("backmath:hardened_amaracamel", 17, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
            }), 12, SoundEvents.ARMOR_EQUIP_CHAIN, 0, 0, () -> Ingredient.of(BMTags.Items.MATERIALS_HARDENED_AMARACAMEL));
        }
    }
    public static class CandyYellowTurtle extends BMArmors {
        public CandyYellowTurtle() {
            super("backmath:candy_yellow_turtle", 25, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
            }), 9, SoundEvents.ARMOR_EQUIP_TURTLE, 0, 0, () -> Ingredient.EMPTY);
        }
    }
    public static class CandyPinkTurtle extends BMArmors {
        public CandyPinkTurtle() {
            super("backmath:candy_pink_turtle", 25, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
            }), 9, SoundEvents.ARMOR_EQUIP_TURTLE, 0, 0, () -> Ingredient.EMPTY);
        }
    }
    public static class GoldenPlated extends BMArmors {
        public GoldenPlated() {
            super("backmath:golden_plated", 17, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
            }), 15, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMTags.Items.INGOTS_CHRISTIAN_MID_TERM));
        }
    }
    public static class QueenLucyShirt extends BMArmors {
        public QueenLucyShirt(String name) {
            super("backmath:qls_" + name, 2, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 0);
                map.put(ArmorItem.Type.LEGGINGS, 0);
                map.put(ArmorItem.Type.CHESTPLATE, 0);
                map.put(ArmorItem.Type.HELMET, 0);
            }), 8, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0, () -> Ingredient.of(ItemTags.WOOL));
        }
    }

    // Warrior Helmets
    public static class WarriorHardenedAmaracamelHelmet extends BMArmors {
        public WarriorHardenedAmaracamelHelmet() {
            super("backmath:warrior_hardened_amaracamel", 17, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
            }), 12, SoundEvents.ARMOR_EQUIP_CHAIN, 0, 0, () -> Ingredient.of(BMTags.Items.MATERIALS_HARDENED_AMARACAMEL));
        }
    }
    public static class WarriorDevilHelmet extends BMArmors {
        public WarriorDevilHelmet() {
            super("backmath:warrior_devil", 18, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 3);
            }), 11, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMTags.Items.INGOTS_DEVIL));
        }
    }
    public static class WarriorAngelicHelmet extends BMArmors {
        public WarriorAngelicHelmet() {
            super("backmath:warrior_angelic", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
            }), 9, SoundEvents.ARMOR_EQUIP_IRON, 0, 0.01F, () ->
                    Ingredient.of(BMTags.Items.INGOTS_ANGELIC));
        }
    }
    public static class WarriorMidTermHelmet extends BMArmors {
        public WarriorMidTermHelmet() {
            super("backmath:warrior_mid_term", 47, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 8);
                map.put(ArmorItem.Type.LEGGINGS, 12);
                map.put(ArmorItem.Type.CHESTPLATE, 14);
                map.put(ArmorItem.Type.HELMET, 8);
            }), 34, SoundEvents.ARMOR_EQUIP_NETHERITE, 11, 0.3F, () -> Ingredient.of(BMTags.Items.SINGULARITIES_MID_TERM));
        }
    }
    public static class WarriorObsidianInfusedMidTermHelmet extends BMArmors {
        public WarriorObsidianInfusedMidTermHelmet() {
            super("backmath:warrior_oimt",53, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 12);
                map.put(ArmorItem.Type.LEGGINGS, 16);
                map.put(ArmorItem.Type.CHESTPLATE, 18);
                map.put(ArmorItem.Type.HELMET, 12);
            }), 42, SoundEvents.ARMOR_EQUIP_NETHERITE, 15, 0.5f, () -> Ingredient.of(BMTags.Items.SINGULARITIES_OBSIDIAN_INFUSED_MID_TERM));
        }
    }
    public static class WarriorAljameedHelmet extends BMArmors {
        public WarriorAljameedHelmet() {
            super("backmath:warrior_aljameed", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 3);
            }), 15, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMTags.Items.INGOTS_ALJAMEED));
        }
    }
    public static class WarriorMooneringHelmet extends BMArmors {
        public WarriorMooneringHelmet() {
            super("backmath:warrior_moonering", 33, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 4);
            }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 0, 0, () -> Ingredient.of(BMTags.Items.INGOTS_MOONERING));
        }
    }
}
