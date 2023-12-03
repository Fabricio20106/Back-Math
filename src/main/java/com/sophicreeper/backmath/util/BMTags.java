package com.sophicreeper.backmath.util;

import com.sophicreeper.backmath.BackMath;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.tags.*;
import net.minecraft.util.ResourceLocation;

import static net.minecraft.tags.EntityTypeTags.getTagById;

public class BMTags {
    public static class Items {
        public static final ITag.INamedTag<Item> INGOTS_DEVIL = forge("ingots/devil");
        public static final ITag.INamedTag<Item> INGOTS_ANGELIC = forge("ingots/angelic");
        public static final ITag.INamedTag<Item> INGOTS_CHRISTIAN_MID_TERM = forge("ingots/christian_mid_term");
        public static final ITag.INamedTag<Item> INGOTS_DEVIL_ANGELIC = forge("ingots/devil_angelic");
        public static final ITag.INamedTag<Item> INGOTS_CHRISTIAN_MID_TERM_ANGELIC = forge("ingots/christian_mid_term_angelic");
        public static final ITag.INamedTag<Item> INGOTS_CHRISTIAN_MID_TERM_DEVIL = forge("ingots/christian_mid_term_devil");
        public static final ITag.INamedTag<Item> INGOTS_WARMTERM = forge("ingots/warmterm");
        public static final ITag.INamedTag<Item> INGOTS_MID_TERM = forge("ingots/mid_term");
        public static final ITag.INamedTag<Item> INGOTS_COLDTERM = forge("ingots/coldterm");
        public static final ITag.INamedTag<Item> INGOTS_OBSIDIAN_INFUSED_MID_TERM = forge("ingots/obsidian_infused_mid_term");
        public static final ITag.INamedTag<Item> INGOTS_HARDENED_AMARACAMEL = forge("ingots/hardened_amaracamel");
        public static final ITag.INamedTag<Item> INGOTS_MILKLLARY = forge("ingots/milkllary");
        public static final ITag.INamedTag<Item> INGOTS_MID_HILLARY = forge("ingots/mid_hillary");
        public static final ITag.INamedTag<Item> INGOTS_ALJAMEED = forge("ingots/aljameed");
        public static final ITag.INamedTag<Item> INGOTS_ALJANSTEEL = forge("ingots/aljansteel");
        public static final ITag.INamedTag<Item> INGOTS_MOONERING = forge("ingots/moonering");
        public static final ITag.INamedTag<Item> INGOTS_ALJAMIC_COPPER = forge("ingots/aljamic_copper");
        public static final ITag.INamedTag<Item> INGOTS_ALJAMIC_TIN = forge("ingots/aljamic_tin");
        public static final ITag.INamedTag<Item> INGOTS_COPPER = forge("ingots/copper");
        public static final ITag.INamedTag<Item> INGOTS_TIN = forge("ingots/tin");
        public static final ITag.INamedTag<Item> INGOTS_OBSIDIAN = forge("ingots/obsidian");

        public static final ITag.INamedTag<Item> NUGGETS_DEVIL = forge("nuggets/devil");
        public static final ITag.INamedTag<Item> NUGGETS_ANGELIC = forge("nuggets/angelic");
        public static final ITag.INamedTag<Item> NUGGETS_CHRISTIAN_MID_TERM = forge("nuggets/christian_mid_term");
        public static final ITag.INamedTag<Item> NUGGETS_MID_TERM = forge("nuggets/mid_term");
        public static final ITag.INamedTag<Item> NUGGETS_OBSIDIAN_INFUSED_MID_TERM = forge("nuggets/obsidian_infused_mid_term");
        public static final ITag.INamedTag<Item> NUGGETS_ALJAMEED = forge("nuggets/aljameed");
        public static final ITag.INamedTag<Item> NUGGETS_ALJANSTEEL = forge("nuggets/aljansteel");
        public static final ITag.INamedTag<Item> NUGGETS_MOONERING = forge("nuggets/moonering");
        public static final ITag.INamedTag<Item> NUGGETS_MILKLLARY = forge("nuggets/milkllary");
        public static final ITag.INamedTag<Item> NUGGETS_MID_HILLARY = forge("nuggets/mid_hillary");
        public static final ITag.INamedTag<Item> NUGGETS_HARDENED_AMARACAMEL = forge("nuggets/hardened_amaracamel");
        public static final ITag.INamedTag<Item> NUGGETS_MILKLLARITY = forge("nuggets/milkllarity");
        public static final ITag.INamedTag<Item> NUGGETS_CRYSTALLINE_ANGELIC = forge("nuggets/crystalline_angelic");
        public static final ITag.INamedTag<Item> NUGGETS_JANTICAL = forge("nuggets/jantical");
        public static final ITag.INamedTag<Item> NUGGETS_DIAMOND = forge("nuggets/diamond");

        public static final ITag.INamedTag<Item> DUSTS_DEVIL = forge("dusts/devil");
        public static final ITag.INamedTag<Item> DUSTS_ANGELIC = forge("dusts/angelic");
        public static final ITag.INamedTag<Item> DUSTS_CHRISTIAN_MID_TERM = forge("dusts/christian_mid_term");
        public static final ITag.INamedTag<Item> DUSTS_DEVIL_ANGELIC = forge("dusts/devil_angelic");
        public static final ITag.INamedTag<Item> DUSTS_CHRISTIAN_MID_TERM_ANGELIC = forge("dusts/christian_mid_term_angelic");
        public static final ITag.INamedTag<Item> DUSTS_CHRISTIAN_MID_TERM_DEVIL = forge("dusts/christian_mid_term_devil");
        public static final ITag.INamedTag<Item> DUSTS_MID_TERM = forge("dusts/mid_term");
        public static final ITag.INamedTag<Item> DUSTS_OBSIDIAN_INFUSED_MID_TERM = forge("dusts/obsidian_infused_mid_term");
        public static final ITag.INamedTag<Item> DUSTS_ALJAMEED = forge("dusts/aljameed");
        public static final ITag.INamedTag<Item> DUSTS_ALJANSTEEL = forge("dusts/aljansteel");
        public static final ITag.INamedTag<Item> DUSTS_MOONERING = forge("dusts/moonering");
        public static final ITag.INamedTag<Item> DUSTS_WATER = forge("dusts/water");
        public static final ITag.INamedTag<Item> DUSTS_HILLARY = forge("dusts/hillary");
        public static final ITag.INamedTag<Item> DUSTS_MILKLLARY = forge("dusts/milkllary");

        public static final ITag.INamedTag<Item> SINGULARITIES = forge("singularities");
        public static final ITag.INamedTag<Item> SINGULARITIES_MID_TERM = forge("singularities/mid_term");
        public static final ITag.INamedTag<Item> SINGULARITIES_OBSIDIAN_INFUSED_MID_TERM = forge("singularities/obsidian_infused_mid_term");
        public static final ITag.INamedTag<Item> SINGULARITIES_MILKLLARY = forge("singularities/milkllary");
        public static final ITag.INamedTag<Item> SINGULARITIES_FRUTIFERY = forge("singularities/frutifery");
        public static final ITag.INamedTag<Item> SINGULARITIES_FRUTIFERY_BACKMATH = forge("singularities/frutifery/backmath");
        public static final ITag.INamedTag<Item> SINGULARITIES_FRUTIFERY_MINECRAFT = forge("singularities/frutifery/minecraft");
        public static final ITag.INamedTag<Item> SINGULARITIES_MEATY = forge("singularities/meaty");
        public static final ITag.INamedTag<Item> SINGULARITIES_MEATY_FABRICIO = forge("singularities/meaty/fabricio");
        public static final ITag.INamedTag<Item> SINGULARITIES_MEATY_SOPHIE = forge("singularities/meaty/sophie");
        public static final ITag.INamedTag<Item> SINGULARITIES_MEATY_LUCIA = forge("singularities/meaty/lucia");
        public static final ITag.INamedTag<Item> SINGULARITIES_MEATY_MINECRAFT = forge("singularities/meaty/minecraft");
        public static final ITag.INamedTag<Item> SINGULARITIES_FISHY = forge("singularities/fishy");
        public static final ITag.INamedTag<Item> SINGULARITIES_VEGETABLY = forge("singularities/vegetably");
        public static final ITag.INamedTag<Item> SINGULARITIES_VEGETABLY_VARIANTS = forge("singularities/vegetably/variants");
        public static final ITag.INamedTag<Item> SINGULARITIES_CHRISTIANITY = forge("singularities/christianity");
        public static final ITag.INamedTag<Item> SINGULARITIES_EMOTIONAL = forge("singularities/emotional");
        public static final ITag.INamedTag<Item> SINGULARITIES_HEAT = forge("singularities/heat");
        public static final ITag.INamedTag<Item> SINGULARITIES_MANGA_MANGO = forge("singularities/manga_mango");

        public static final ITag.INamedTag<Item> RODS_DEVIL = forge("rods/devil");
        public static final ITag.INamedTag<Item> RODS_ANGELIC = forge("rods/angelic");
        public static final ITag.INamedTag<Item> RODS_MID_TERM = forge("rods/mid_term");
        public static final ITag.INamedTag<Item> RODS_HILLARY = forge("rods/hillary");
        public static final ITag.INamedTag<Item> RODS_ALJAMEED = forge("rods/aljameed");
        public static final ITag.INamedTag<Item> RODS_CRYSTALLINE_BIRCH = forge("rods/crystalline_birch");
        public static final ITag.INamedTag<Item> RODS_GOLDENWOOD = forge("rods/goldenwood");
        public static final ITag.INamedTag<Item> RODS_GUAVA = forge("rods/guava");
        public static final ITag.INamedTag<Item> RODS_JABUTICABA = forge("rods/jabuticaba");
        public static final ITag.INamedTag<Item> RODS_CORK_OAK = forge("rods/cork_oak");
        public static final ITag.INamedTag<Item> RODS_ALJANWOOD = forge("rods/aljanwood");
        public static final ITag.INamedTag<Item> RODS_ALJANCAP = forge("rods/aljancap");
        public static final ITag.INamedTag<Item> RODS_INSOMNIAN = forge("rods/insomnian");
        public static final ITag.INamedTag<Item> RODS_AVONDALIC_WILLOW = forge("rods/avondalic_willow");

        public static final ITag.INamedTag<Item> MOLDS = backMath("molds");
        public static final ITag.INamedTag<Item> MOLDS_SINGULARITY = backMath("molds/singularity");
        public static final ITag.INamedTag<Item> MOLDS_CRYSTALLIZED = backMath("molds/crystallized");
        public static final ITag.INamedTag<Item> MOLDS_INGOT = backMath("molds/ingot");
        public static final ITag.INamedTag<Item> MOLDS_EMPTY = backMath("molds/empty");
        public static final ITag.INamedTag<Item> MOLDS_MOLD = backMath("molds/mold");
        public static final ITag.INamedTag<Item> MOLDS_CRYSTALLINE_EMPTY = backMath("molds/crystalline_empty");
        public static final ITag.INamedTag<Item> MOLDS_CRYSTALLINE_GEM = backMath("molds/crystalline_gem");
        public static final ITag.INamedTag<Item> MOLDS_ROD = backMath("molds/rod");

        public static final ITag.INamedTag<Item> SQUIDS = backMath("squids");
        public static final ITag.INamedTag<Item> POPSICLES = backMath("popsicles");
        public static final ITag.INamedTag<Item> ALJANSTONE_CRAFTING_MATERIALS = backMath("aljanstone_crafting_materials");
        public static final ITag.INamedTag<Item> BONE_MEALS = backMath("bone_meals");
        // Tag Migration
        public static final ITag.INamedTag<Item> ALJAN_RECIPE_STICKS = backMath("aljan_recipe_sticks");
        public static final ITag.INamedTag<Item> BACK_GUIDE_RECIPE_ACCEPTABLES = backMath("back_guide_recipe_acceptables");
        public static final ITag.INamedTag<Item> MATERIALS = backMath("materials");
        public static final ITag.INamedTag<Item> MATERIALS_HARDENED_AMARACAMEL = backMath("materials/hardened_amaracamel");
        public static final ITag.INamedTag<Item> CROWNS = backMath("crowns");
        public static final ITag.INamedTag<Item> FOOD_BAGS = backMath("food_bags");
        public static final ITag.INamedTag<Item> ENERGETICS = backMath("energetics");
        public static final ITag.INamedTag<Item> MORTAR_AND_PESTLES = backMath("mortar_and_pestles");
        public static final ITag.INamedTag<Item> DISCS = backMath("discs");
        public static final ITag.INamedTag<Item> BOTTLES = backMath("bottles");
        public static final ITag.INamedTag<Item> BUCKETS = backMath("buckets");
        public static final ITag.INamedTag<Item> JUICES = backMath("juices");
        public static final ITag.INamedTag<Item> JAMS = backMath("jams");
        public static final ITag.INamedTag<Item> CUT_FRUITS = backMath("cut_fruits");
        public static final ITag.INamedTag<Item> ITEM_SACS = backMath("item_sacs");
        public static final ITag.INamedTag<Item> EMPTY_ITEM_SACS = backMath("empty_item_sacs");
        public static final ITag.INamedTag<Item> MILKED_SWORDS = backMath("milked_swords");
        public static final ITag.INamedTag<Item> MILKED_SPAREYS = backMath("milked_spareys");

        public static final ITag.INamedTag<Item> CRYSTALLINE_BIRCH_LOGS = backMath("crystalline_birch_logs");
        public static final ITag.INamedTag<Item> CORK_OAK_LOGS = backMath("cork_oak_logs");
        public static final ITag.INamedTag<Item> GOLDENWOOD_LOGS = backMath("goldenwood_logs");
        public static final ITag.INamedTag<Item> GUAVA_LOGS = backMath("guava_logs");
        public static final ITag.INamedTag<Item> JABUTICABA_LOGS = backMath("jabuticaba_logs");
        public static final ITag.INamedTag<Item> ALJANWOOD_LOGS = backMath("aljanwood_logs");
        public static final ITag.INamedTag<Item> ALJANCAP_LOGS = backMath("aljancap_logs");
        public static final ITag.INamedTag<Item> INSOMNIAN_LOGS = backMath("insomnian_logs");
        public static final ITag.INamedTag<Item> AVONDALIC_WILLOW_LOGS = backMath("avondalic_willow_logs");
        public static final ITag.INamedTag<Item> STRIPPED_WOODS = backMath("stripped_woods");
        public static final ITag.INamedTag<Item> ALJAN_LOGS = backMath("aljan_logs");

        public static final ITag.INamedTag<Item> GRAPE_VINE_POSTS = backMath("grape_vine_posts");
        public static final ITag.INamedTag<Item> TOYS = backMath("toys");

        public static final ITag.INamedTag<Item> SOPHIE_IDEA = backMath("sophie_idea");
        public static final ITag.INamedTag<Item> ALPHA_IDEA = backMath("sophie_idea/alpha");
        public static final ITag.INamedTag<Item> SOPHIES_TAKE_OVER_IDEA = backMath("sophie_idea/sophies_take_over");
        public static final ITag.INamedTag<Item> ALJAMIC_WARS_IDEA = backMath("sophie_idea/aljamic_wars");
        public static final ITag.INamedTag<Item> BOUNTIFULLY_EXPANSIVE_IDEA = backMath("sophie_idea/bountifully_expansive");
        // Tag Migration

        public static final ITag.INamedTag<Item> GEMS_MID_TERM = forge("gems/mid_term");
        public static final ITag.INamedTag<Item> GEMS_OBSIDIAN_INFUSED_MID_TERM = forge("gems/obsidian_infused_mid_term");
        public static final ITag.INamedTag<Item> GEMS_MILKLLARITY = forge("gems/milkllarity");
        public static final ITag.INamedTag<Item> GEMS_CRYSTALLINE_ANGELIC = forge("gems/crystalline_angelic");
        public static final ITag.INamedTag<Item> GEMS_JANTICAL = forge("gems/jantical");
        public static final ITag.INamedTag<Item> GEMS_PERSONA = forge("gems/persona");

        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_DEVIL = forge("storage_blocks/devil");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_RAW_DEVIL = forge("storage_blocks/raw_devil");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_ANGELIC = forge("storage_blocks/angelic");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_RAW_ANGELIC = forge("storage_blocks/raw_angelic");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_CHRISTIAN_MID_TERM = forge("storage_blocks/christian_mid_term");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_DEVIL_ANGELIC = forge("storage_blocks/devil_angelic");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_CHRISTIAN_MID_TERM_ANGELIC = forge("storage_blocks/christian_mid_term_angelic");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_CHRISTIAN_MID_TERM_DEVIL = forge("storage_blocks/christian_mid_term_devil");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_WARMTERM = forge("storage_blocks/warmterm");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_MID_TERM = forge("storage_blocks/mid_term");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_COLDTERM = forge("storage_blocks/coldterm");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_RAW_MID_TERM = forge("storage_blocks/raw_mid_term");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_OBSIDIAN_INFUSED_MID_TERM = forge("storage_blocks/obsidian_infused_mid_term");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_CRYSTALLINE_ANGELIC = forge("storage_blocks/crystalline_angelic");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_MILKLLARY = forge("storage_blocks/milkllary");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_HARDENED_AMARACAMEL = forge("storage_blocks/hardened_amaracamel");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_CHARJAN_COAL = forge("storage_blocks/charjan_coal");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_ALJAMEED = forge("storage_blocks/aljameed");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_ALJANSTEEL = forge("storage_blocks/aljansteel");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_RAW_ALJAMEED = forge("storage_blocks/raw_aljameed");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_MOONERING = forge("storage_blocks/moonering");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_RAW_MOONERING = forge("storage_blocks/raw_moonering");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_MID_HILLARY = forge("storage_blocks/mid_hillary");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_JANTICAL = forge("storage_blocks/jantical");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_RAW_ALJAMIC_COPPER = forge("storage_blocks/raw_aljamic_copper");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_RAW_ALJAMIC_TIN = forge("storage_blocks/raw_aljamic_tin");

        public static final ITag.INamedTag<Item> ORES_DEVIL = forge("ores/devil");
        public static final ITag.INamedTag<Item> ORES_ANGELIC = forge("ores/angelic");
        public static final ITag.INamedTag<Item> ORES_MID_TERM = forge("ores/mid_term");
        public static final ITag.INamedTag<Item> ORES_CRYSTALLINE_ANGELIC = forge("ores/crystalline_angelic");
        public static final ITag.INamedTag<Item> ORES_ALJAMEED = forge("ores/aljameed");
        public static final ITag.INamedTag<Item> ORES_MOONERING = forge("ores/moonering");
        public static final ITag.INamedTag<Item> ORES_JANTICAL = forge("ores/jantical");
        public static final ITag.INamedTag<Item> ORES_ALJAMIC_COPPER = forge("ores/aljamic_copper");
        public static final ITag.INamedTag<Item> ORES_ALJAMIC_TIN = forge("ores/aljamic_tin");
        public static final ITag.INamedTag<Item> ORES_COPPER = forge("ores/copper");
        public static final ITag.INamedTag<Item> ORES_TIN = forge("ores/tin");

        public static final ITag.INamedTag<Item> ARMORS_BOOTS = forge("armors/boots");
        public static final ITag.INamedTag<Item> KNIVES = forge("knives");
        public static final ITag.INamedTag<Item> MILK = forge("milk");

        // Tag Migration
        public static final ITag.INamedTag<Item> GLASS_DEVIL = forge("glass/devil");
        public static final ITag.INamedTag<Item> GLASS_PANES_DEVIL = forge("glass_panes/devil");

        public static final ITag.INamedTag<Item> DYES_DEVIL = forge("dyes/devil");
        public static final ITag.INamedTag<Item> DYES_ALJAN_LIGHT_BLUE = forge("dyes/aljan_light_blue");
        public static final ITag.INamedTag<Item> DYES_POISON_BROWN = forge("dyes/poison_brown");
        public static final ITag.INamedTag<Item> DYES_INSOMNIAN = forge("dyes/insomnian");

        private static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Item> backMath(String path) {
            return ItemTags.makeWrapperTag(BackMath.resourceLoc(path).toString());
        }
    }

    public static class Blocks {
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_DEVIL = forge("storage_blocks/devil");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_RAW_DEVIL = forge("storage_blocks/raw_devil");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_ANGELIC = forge("storage_blocks/angelic");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_RAW_ANGELIC = forge("storage_blocks/raw_angelic");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_CHRISTIAN_MID_TERM = forge("storage_blocks/christian_mid_term");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_DEVIL_ANGELIC = forge("storage_blocks/devil_angelic");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_CHRISTIAN_MID_TERM_ANGELIC = forge("storage_blocks/christian_mid_term_angelic");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_CHRISTIAN_MID_TERM_DEVIL = forge("storage_blocks/christian_mid_term_devil");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_WARMTERM = forge("storage_blocks/warmterm");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_MID_TERM = forge("storage_blocks/mid_term");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_COLDTERM = forge("storage_blocks/coldterm");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_RAW_MID_TERM = forge("storage_blocks/raw_mid_term");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_OBSIDIAN_INFUSED_MID_TERM = forge("storage_blocks/obsidian_infused_mid_term");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_CRYSTALLINE_ANGELIC = forge("storage_blocks/crystalline_angelic");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_MILKLLARY = forge("storage_blocks/milkllary");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_HARDENED_AMARACAMEL = forge("storage_blocks/hardened_amaracamel");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_CHARJAN_COAL = forge("storage_blocks/charjan_coal");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_ALJAMEED = forge("storage_blocks/aljameed");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_ALJANSTEEL = forge("storage_blocks/aljansteel");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_RAW_ALJAMEED = forge("storage_blocks/raw_aljameed");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_MOONERING = forge("storage_blocks/moonering");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_RAW_MOONERING = forge("storage_blocks/raw_moonering");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_MID_HILLARY = forge("storage_blocks/mid_hillary");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_JANTICAL = forge("storage_blocks/jantical");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_RAW_ALJAMIC_COPPER = forge("storage_blocks/raw_aljamic_copper");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_RAW_ALJAMIC_TIN = forge("storage_blocks/raw_aljamic_tin");

        public static final ITag.INamedTag<Block> ORES_DEVIL = forge("ores/devil");
        public static final ITag.INamedTag<Block> ORES_ANGELIC = forge("ores/angelic");
        public static final ITag.INamedTag<Block> ORES_MID_TERM = forge("ores/mid_term");
        public static final ITag.INamedTag<Block> ORES_CRYSTALLINE_ANGELIC = forge("ores/crystalline_angelic");
        public static final ITag.INamedTag<Block> ORES_ALJAMEED = forge("ores/aljameed");
        public static final ITag.INamedTag<Block> ORES_MOONERING = forge("ores/moonering");
        public static final ITag.INamedTag<Block> ORES_JANTICAL = forge("ores/jantical");
        public static final ITag.INamedTag<Block> ORES_ALJAMIC_COPPER = forge("ores/aljamic_copper");
        public static final ITag.INamedTag<Block> ORES_ALJAMIC_TIN = forge("ores/aljamic_tin");
        public static final ITag.INamedTag<Block> ORES_COPPER = forge("ores/copper");
        public static final ITag.INamedTag<Block> ORES_TIN = forge("ores/tin");

        public static final ITag.INamedTag<Block> GLASS_DEVIL = forge("glass/devil");
        public static final ITag.INamedTag<Block> GLASS_PANES_DEVIL = forge("glass_panes/devil");

        public static final ITag.INamedTag<Block> BASE_STONE_ALJAN = backMath("base_stone_aljan");
        public static final ITag.INamedTag<Block> INFINIBURN_ALJAN = backMath("infiniburn_aljan");
        public static final ITag.INamedTag<Block> CRYSTALLINE_BIRCH_LOGS = backMath("crystalline_birch_logs");
        public static final ITag.INamedTag<Block> CORK_OAK_LOGS = backMath("cork_oak_logs");
        public static final ITag.INamedTag<Block> GOLDENWOOD_LOGS = backMath("goldenwood_logs");
        public static final ITag.INamedTag<Block> GUAVA_LOGS = backMath("guava_logs");
        public static final ITag.INamedTag<Block> JABUTICABA_LOGS = backMath("jabuticaba_logs");
        public static final ITag.INamedTag<Block> ALJANWOOD_LOGS = backMath("aljanwood_logs");
        public static final ITag.INamedTag<Block> ALJANCAP_LOGS = backMath("aljancap_logs");
        public static final ITag.INamedTag<Block> INSOMNIAN_LOGS = backMath("insomnian_logs");
        public static final ITag.INamedTag<Block> AVONDALIC_WILLOW_LOGS = backMath("avondalic_willow_logs");
        public static final ITag.INamedTag<Block> STRIPPED_WOODS = backMath("stripped_woods");
        public static final ITag.INamedTag<Block> GRAPE_VINE_POSTS = backMath("grape_vine_posts");
        public static final ITag.INamedTag<Block> SQUIDS = backMath("squids");
        public static final ITag.INamedTag<Block> TOYS = backMath("toys");

        public static final ITag.INamedTag<Block> WILD_CROPS_PLANTABLE_ON = backMath("wild_crops_plantable_on");
        public static final ITag.INamedTag<Block> ALJAN_CROP_PLANTABLE_ON = backMath("aljan_crop_plantable_on");
        public static final ITag.INamedTag<Block> EDFEF_PLANTABLE_ON = backMath("edfef_plantable_on");
        public static final ITag.INamedTag<Block> TFEF_PLANTABLE_ON = backMath("tfef_plantable_on");

        public static final ITag.INamedTag<Block> SOPHIE_IDEA = backMath("sophie_idea");
        public static final ITag.INamedTag<Block> BOUNTIFULLY_EXPANSIVE_IDEA = backMath("sophie_idea/bountifully_expansive");

        private static ITag.INamedTag<Block> forge(String path) {
            return BlockTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Block> backMath(String path) {
            return BlockTags.makeWrapperTag(BackMath.resourceLoc(path).toString());
        }

        public Blocks() {}
    }

    public static class Fluids {
        public static final ITag.INamedTag<Fluid> HILLARY = backMath("hillary");
        public static final ITag.INamedTag<Fluid> MILKLLARY = backMath("milkllary");
        public static final ITag.INamedTag<Fluid> LIQUID_ALJAME = backMath("liquid_aljame");
        public static final ITag.INamedTag<Fluid> LIQUID_MANGA = backMath("liquid_manga");
        public static final ITag.INamedTag<Fluid> LIQUEFIED_MONSTER = backMath("liquefied_monster");
        public static final ITag.INamedTag<Fluid> SLEEPISHWATER = backMath("sleepishwater");

        private static ITag.INamedTag<Fluid> backMath(String path) {
            return FluidTags.makeWrapperTag(BackMath.resourceLoc(path).toString());
        }
    }

    public static class EntityTypes {
        public static final ITag.INamedTag<EntityType<?>> SOPHIE_IDEA = getTagById("backmath:sophie_idea");
        public static final ITag.INamedTag<EntityType<?>> ALJAMIC_WARS_IDEA = getTagById("backmath:sophie_idea/aljamic_wars");
    }
}
