package com.sophicreeper.backmath.item;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.item.custom.armor.BMArmors;
import com.sophicreeper.backmath.item.custom.tool.BMTools;
import com.sophicreeper.backmath.util.tag.BMItemTags;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.Tags;

public class BMSetFields {
    // Helmets
    public static final BMArmors CAT_TIARA_ARMOR = new BMArmors(BackMath.MOD_ID + ":cat_tiara", 37, new int[] {3, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3, 0.1F, () -> Ingredient.of(Items.LIGHT_BLUE_WOOL));
    public static final BMArmors DOG_TIARA_ARMOR = new BMArmors(BackMath.MOD_ID + ":dog_tiara", 13, new int[] {0, 0, 0, 3}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0, () -> Ingredient.of(Items.BROWN_WOOL));
    public static final BMArmors KARATE_HEADBAND_ARMOR = new BMArmors(BackMath.MOD_ID + ":karate_headband", 4, new int[] {0, 0, 0, 1}, 63, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0, () -> Ingredient.of(ItemTags.WOOL));
    public static final BMArmors CANDY_YELLOW_TURTLE_ARMOR = new BMArmors(BackMath.MOD_ID + ":candy_yellow_turtle", 25, new int[] {2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_TURTLE, 0, 0, () -> Ingredient.of(Items.SCUTE));
    public static final BMArmors CANDY_PINK_TURTLE_ARMOR = new BMArmors(BackMath.MOD_ID + ":candy_pink_turtle", 25, new int[] {2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_TURTLE, 0, 0, () -> Ingredient.of(Items.SCUTE));
    public static final BMArmors ALJAMIC_BONE_ARMOR = new BMArmors(BackMath.MOD_ID + ":aljamic_bone", 15, new int[] {2, 6, 5, 2}, 15, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMItemTags.INGOTS_ALJAMEED));
    public static final BMArmors GOLDEN_HALO_ARMOR = new BMArmors(BackMath.MOD_ID + ":golden_halo", 4, new int[] {0, 0, 0, 2}, 13, SoundEvents.ARMOR_EQUIP_GOLD, 0, 0, () -> Ingredient.of(Tags.Items.INGOTS_GOLD));
    public static final BMArmors RED_YELLOW_GLASSES_ARMOR = glasses("red_yellow");

    // Chestplates
    public static final BMArmors GOLDEN_PLATED_ARMOR = new BMArmors(BackMath.MOD_ID + ":golden_plated", 17, new int[] {2, 6, 5, 2}, 15, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMItemTags.INGOTS_CHRISTIAN_MID_TERM));
    public static final BMArmors QLS_CURRENT = queenLucyShirt("current");
    public static final BMArmors QLS_ALT = queenLucyShirt("alt");
    public static final BMArmors QLS_RELIC = queenLucyShirt("relic");

    // (Mostly) Full Armor Sets
    public static final BMArmors ANGELIC_ARMOR = new BMArmors(BackMath.MOD_ID + ":angelic", 15, new int[] {2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0, 0.01F, () -> Ingredient.of(BMItemTags.INGOTS_ANGELIC));
    public static final BMArmors DEVIL_ARMOR = new BMArmors(BackMath.MOD_ID + ":devil", 18, new int[] {3, 5, 6, 3}, 11, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMItemTags.INGOTS_DEVIL));
    public static final BMArmors MILKLLARY_ARMOR = new BMArmors(BackMath.MOD_ID + ":milkllary", 15, new int[] {3, 6, 5, 3}, 18, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMItemTags.INGOTS_MILKLLARY));
    public static final BMArmors MID_TERM_ARMOR = new BMArmors(BackMath.MOD_ID + ":mid_term", 47, new int[] {8, 12, 14, 8}, 34, SoundEvents.ARMOR_EQUIP_NETHERITE, 11, 0.3F, () -> Ingredient.of(BMItemTags.SINGULARITIES_MID_TERM));
    public static final BMArmors OBSIDIAN_INFUSED_MID_TERM_ARMOR = new BMArmors(BackMath.MOD_ID + ":obsidian_infused_mid_term", 53, new int[] {12, 16, 18, 12}, 42, SoundEvents.ARMOR_EQUIP_NETHERITE, 15, 0.5F, () -> Ingredient.of(BMItemTags.SINGULARITIES_OBSIDIAN_INFUSED_MID_TERM));
    public static final BMArmors PLATEFORCED_MID_TERM_ARMOR = new BMArmors(BackMath.MOD_ID + ":plateforced_mid_term", 50, new int[] {6, 8, 9, 6}, 17, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.5F, 0.4F, () -> Ingredient.of(BMItemTags.INGOTS_OBSIDIAN));
    public static final BMArmors ARCHER_LUCIA_ARMOR = new BMArmors(BackMath.MOD_ID + ":archer_lucia_vest", 15, new int[] {2, 4, 5, 2}, 18, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0.05f, () -> Ingredient.of(BMItemTags.INGOTS_MILKLLARY));
    public static final BMArmors ARCHER_FABRICIO_ARMOR = new BMArmors(BackMath.MOD_ID + ":archer_fabricio_vest", 15, new int[] {3, 4, 4, 2}, 18, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0.05f, () -> Ingredient.of(BMItemTags.INGOTS_ALJAMEED));
    public static final BMArmors HARDENED_AMARACAMEL_ARMOR = new BMArmors(BackMath.MOD_ID + ":hardened_amaracamel", 17, new int[] {2, 5, 6, 2}, 12, SoundEvents.ARMOR_EQUIP_CHAIN, 0, 0, () -> Ingredient.of(BMItemTags.HARDENED_AMARACAMEL_MATERIALS));
    public static final BMArmors JANTSKIN_ARMOR = new BMArmors(BackMath.MOD_ID + ":jantskin", 5, new int[] {1, 3, 2, 1}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0, () -> Ingredient.of(AxolotlTest.JANTSKIN.get()));
    public static final BMArmors ALJAMEED_ARMOR = new BMArmors(BackMath.MOD_ID + ":aljameed", 15, new int[] {2, 6, 5, 2}, 15, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMItemTags.INGOTS_ALJAMEED));
    public static final BMArmors MOONERING_ARMOR = new BMArmors(BackMath.MOD_ID + ":moonering", 33, new int[] {3, 8, 6, 3}, 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2, 0, () -> Ingredient.of(BMItemTags.INGOTS_MOONERING));
    public static final BMArmors JANTIQUIFIED_MOONERING_ARMOR = new BMArmors(BackMath.MOD_ID + ":jantiquified_moonering", 37, new int[] {4, 9, 7, 4}, 12, SoundEvents.ARMOR_EQUIP_NETHERITE, 3, 0.05F, () -> Ingredient.of(BMItemTags.INGOTS_MOONERING));
    public static final BMArmors BAKUGOU_ARMOR = new BMArmors(BackMath.MOD_ID + ":bakugou", 5, new int[] {0, 0, 0, 0}, 13, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0, () -> Ingredient.EMPTY);
    public static final BMArmors INSOMNIA_SOPHIE_SLEEPWEAR_ARMOR = new BMArmors(BackMath.MOD_ID + ":insomnia_sophie_sleepwear", 5, new int[] {0, 0, 0, 0}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0, () -> Ingredient.EMPTY);

    // Warrior Helmets
    public static final BMArmors WARRIOR_ANGELIC_ARMOR = new BMArmors(BackMath.MOD_ID + ":warrior_angelic", 15, new int[] {2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0, 0.01F, () -> Ingredient.of(BMItemTags.INGOTS_ANGELIC));
    public static final BMArmors WARRIOR_DEVIL_ARMOR = new BMArmors(BackMath.MOD_ID + ":warrior_devil", 18, new int[] {3, 5, 6, 3}, 11, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMItemTags.INGOTS_DEVIL));
    public static final BMArmors WARRIOR_MID_TERM_ARMOR = new BMArmors(BackMath.MOD_ID + ":warrior_mid_term", 47, new int[] {8, 12, 14, 8}, 34, SoundEvents.ARMOR_EQUIP_NETHERITE, 11, 0.3F, () -> Ingredient.of(BMItemTags.SINGULARITIES_MID_TERM));
    public static final BMArmors WARRIOR_OBSIDIAN_INFUSED_MID_TERM_ARMOR = new BMArmors(BackMath.MOD_ID + ":warrior_obsidian_infused_mid_term",53, new int[] {12, 18, 16, 12}, 42, SoundEvents.ARMOR_EQUIP_NETHERITE, 15, 0.5F, () -> Ingredient.of(BMItemTags.SINGULARITIES_OBSIDIAN_INFUSED_MID_TERM));
    public static final BMArmors WARRIOR_MILKLLARY_ARMOR = new BMArmors(BackMath.MOD_ID + ":warrior_milkllary", 18, new int[] {4, 7, 6, 4}, 21, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMItemTags.INGOTS_MILKLLARY));
    public static final BMArmors WARRIOR_HARDENED_AMARACAMEL_ARMOR = new BMArmors(BackMath.MOD_ID + ":warrior_hardened_amaracamel", 17, new int[] {2, 5, 6, 2}, 12, SoundEvents.ARMOR_EQUIP_CHAIN, 0, 0, () -> Ingredient.of(BMItemTags.HARDENED_AMARACAMEL_MATERIALS));
    public static final BMArmors WARRIOR_ALJAMEED_ARMOR = new BMArmors(BackMath.MOD_ID + ":warrior_aljameed", 15, new int[] {3, 6, 5, 2}, 15, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(BMItemTags.INGOTS_ALJAMEED));
    public static final BMArmors WARRIOR_MOONERING_ARMOR = new BMArmors(BackMath.MOD_ID + ":warrior_moonering", 33, new int[] {4, 8, 6, 3}, 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 0, 0, () -> Ingredient.of(BMItemTags.INGOTS_MOONERING));
    public static final BMArmors WARRIOR_JANTIQUIFIED_MOONERING_ARMOR = new BMArmors(BackMath.MOD_ID + ":warrior_jantiquified_moonering", 40, new int[] {5, 10, 8, 5}, 14, SoundEvents.ARMOR_EQUIP_NETHERITE, 3, 0.05F, () -> Ingredient.of(BMItemTags.INGOTS_MOONERING));

    // Single-Piece Tool Sets
    public static final BMTools BUTTER_SWORD_SET = new BMTools(4, 200, 6, 2, 40, () -> Ingredient.of(Items.BREAD));
    public static final BMTools GOLDEN_PATTY_SET = new BMTools(0, 32, 12, 0, 22, () -> Ingredient.of(BMItemTags.INGOTS_CHRISTIAN_MID_TERM));
    public static final BMTools WATER_TALC_POWDER_SET = new BMTools(1, 720, 4, 1, 5, () -> Ingredient.of(Tags.Items.INGOTS_GOLD));
    public static final BMTools RAINBOW_PENCIL_SET = new BMTools(3, 720, 5, 43, 69, () -> Ingredient.EMPTY);
    public static final BMTools MECH_MECH_SET = new BMTools(3, 1561, 4, 0, 22, () -> Ingredient.of(BMItemTags.NUGGETS_DIAMOND));
    public static final BMTools CAREWNI_SET = new BMTools(0, 1758, 0, 13, 25, () -> Ingredient.of(BMItemTags.INGOTS_CHRISTIAN_MID_TERM));
    public static final BMTools PERSONA_SWORD_SET = new BMTools(0, 1758, 0, 8, 13, () -> Ingredient.of(BMItemTags.GEMS_PERSONA));
    public static final BMTools BREAD_SWORD_SET = new BMTools(0, 150, 0, 1, 13, () -> Ingredient.of(Items.BREAD));
    public static final BMTools TABU_SWORD_SET = new BMTools(1, 1250, 3, 2, 20, () -> Ingredient.of(BMItemTags.TABU_SMELTABLES));
    public static final BMTools KARATE_TRAINING_STICK_SET = new BMTools(0, 1561, 8, 3, 25, () -> Ingredient.of(Tags.Items.RODS_WOODEN));

    // Tool Sets
    public static final BMTools DEVIL_SET = new BMTools(2, 250, 6, 2, 14, () -> Ingredient.of(BMItemTags.INGOTS_DEVIL));
    public static final BMTools ANGELIC_SET = new BMTools(2, 250, 6, 2, 14, () -> Ingredient.of(BMItemTags.INGOTS_ANGELIC));
    public static final BMTools MILKLLARY_SET = new BMTools(2, 450, 7, 3, 21, () -> Ingredient.of(BMItemTags.INGOTS_MILKLLARY));
    public static final BMTools OLIVE_SET = new BMTools(3, 646, 4, 1, 69, () -> Ingredient.EMPTY);
    public static final BMTools DEVIL_SPAREY_SET = new BMTools(4, 2031, 9, 18, 12, () -> Ingredient.of(BMItemTags.INGOTS_DEVIL));
    public static final BMTools SPAREY_SET = new BMTools(4, 2031, 9, 18, 12, () -> Ingredient.of(BMItemTags.INGOTS_CHRISTIAN_MID_TERM));
    public static final BMTools MID_TERM_SET = new BMTools(5, 4062, 12, 16, 17, () -> Ingredient.of(BMItemTags.MID_TERM_MATERIALS));
    public static final BMTools MID_TERM_SPAREY_SET = new BMTools(5, 4062, 12, 61, 36, () -> Ingredient.of(BMItemTags.MID_TERM_MATERIALS));
    public static final BMTools OBSIDIAN_INFUSED_MID_TERM_SET = new BMTools(6, 8126, 16, 58, 45, () -> Ingredient.of(BMItemTags.OIMT_MATERIALS));
    public static final BMTools OBSIDIAN_INFUSED_MID_TERM_SPAREY_SET = new BMTools(4, 2031, 9, 76, 12, () -> Ingredient.of(BMItemTags.OIMT_MATERIALS));
    public static final BMTools CRYSTALLINE_BIRCH_SET = new BMTools(0, 59, 2, 0, 15, () -> Ingredient.of(AxolotlTest.CRYSTALLINE_BIRCH_PLANKS.get()));
    public static final BMTools GOLDENWOOD_SET = new BMTools(0, 59, 2, 0, 15, () -> Ingredient.of(AxolotlTest.GOLDENWOOD_PLANKS.get()));
    public static final BMTools GUAVA_SET = new BMTools(0, 59, 2, 0, 15, () -> Ingredient.of(AxolotlTest.GUAVA_PLANKS.get()));
    public static final BMTools JABUTICABA_SET = new BMTools(0, 59, 2, 0, 15, () -> Ingredient.of(AxolotlTest.JABUTICABA_PLANKS.get()));
    public static final BMTools CORK_OAK_SET = new BMTools(0, 59, 2, 0, 15, () -> Ingredient.of(AxolotlTest.CORK_OAK_PLANKS.get()));
    public static final BMTools ALJANWOOD_SET = new BMTools(0, 59, 2, 0, 15, () -> Ingredient.of(AxolotlTest.ALJANWOOD_PLANKS.get()));
    public static final BMTools ALJANCAP_SET = new BMTools(0, 68, 2.2F, 0, 13, () -> Ingredient.of(AxolotlTest.ALJANCAP_PLANKS.get()));
    public static final BMTools INSOMNIAN_SET = new BMTools(0, 72, 2.3F, 0, 13, () -> Ingredient.of(AxolotlTest.INSOMNIAN_PLANKS.get()));
    public static final BMTools AVONDALIC_WILLOW_SET = new BMTools(0, 61, 2.2F, 0.4F, 16, () -> Ingredient.of(AxolotlTest.AVONDALIC_WILLOW_PLANKS.get()));
    public static final BMTools ALJANSTONE_SET = new BMTools(1, 131, 4, 1, 5, () -> Ingredient.of(BMItemTags.ALJANSTONE_CRAFTING_MATERIALS));
    public static final BMTools SLEEPINGSTONE_SET = new BMTools(1, 161, 4.5F, 1, 5, () -> Ingredient.of(AxolotlTest.SLEEPINGSTONE.get()));
    public static final BMTools ALJAMEED_SET = new BMTools(2, 250, 6, 2, 14, () -> Ingredient.of(BMItemTags.INGOTS_ALJAMEED));
    public static final BMTools ALJANSTEEL_SET = new BMTools(3, 500, 6.5F, 3, 16, () -> Ingredient.of(BMItemTags.INGOTS_ALJANSTEEL));
    public static final BMTools MOONERING_SET = new BMTools(3, 1561, 8, 3, 10, () -> Ingredient.of(BMItemTags.INGOTS_MOONERING));
    public static final BMTools JANTIQUIFIED_MOONERING_SET = new BMTools(4, 2031, 10, 4.5F, 14, () -> Ingredient.of(BMItemTags.INGOTS_MOONERING));

    private static BMArmors glasses(String glassType) {
        return new BMArmors(BackMath.MOD_ID + ":" + glassType + "_glasses", 4, new int[] {0, 0, 0, 0}, 13, SoundEvents.ARMOR_EQUIP_CHAIN, 0, 0, () -> Ingredient.of(Tags.Items.GLASS));
    }

    private static BMArmors queenLucyShirt(String shirtDesign) {
        return new BMArmors(BackMath.MOD_ID + ":qls_" + shirtDesign, 2, new int[] {0, 1, 0, 0}, 8, SoundEvents.ARMOR_EQUIP_LEATHER, 0, 0, () -> Ingredient.of(ItemTags.WOOL));
    }
}
