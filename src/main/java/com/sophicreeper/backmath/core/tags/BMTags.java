package com.sophicreeper.backmath.core.tags;

import com.sophicreeper.backmath.core.client.BackMath;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class BMTags {
    public static class Items {
        public static final TagKey<Item> INGOTS_DEVIL = forge("ingots/devil");
        public static final TagKey<Item> INGOTS_ANGELIC = forge("ingots/angelic");
        public static final TagKey<Item> INGOTS_CHRISTIAN_MID_TERM = forge("ingots/christian_mid_term");
        public static final TagKey<Item> INGOTS_DEVIL_ANGELIC = forge("ingots/devil_angelic");
        public static final TagKey<Item> INGOTS_CHRISTIAN_MID_TERM_ANGELIC = forge("ingots/christian_mid_term_angelic");
        public static final TagKey<Item> INGOTS_CHRISTIAN_MID_TERM_DEVIL = forge("ingots/christian_mid_term_devil");
        public static final TagKey<Item> INGOTS_MID_TERM = forge("ingots/mid_term");
        public static final TagKey<Item> INGOTS_OBSIDIAN_INFUSED_MID_TERM = forge("ingots/obsidian_infused_mid_term");
        public static final TagKey<Item> INGOTS_HARDENED_AMARACAMEL = forge("ingots/hardened_amaracamel");
        public static final TagKey<Item> INGOTS_MILKLLARY = forge("ingots/milkllary");
        public static final TagKey<Item> INGOTS_MID_HILLARY = forge("ingots/mid_hillary");
        public static final TagKey<Item> INGOTS_ALJAMEED = forge("ingots/aljameed");
        public static final TagKey<Item> INGOTS_ALJANSTEEL = forge("ingots/aljansteel");
        public static final TagKey<Item> INGOTS_MOONERING = forge("ingots/moonering");
        public static final TagKey<Item> INGOTS_ALJAMIC_COPPER = forge("ingots/aljamic_copper");
        public static final TagKey<Item> INGOTS_ALJAMIC_TIN = forge("ingots/aljamic_tin");
        public static final TagKey<Item> INGOTS_COPPER = forge("ingots/copper");
        public static final TagKey<Item> INGOTS_TIN = forge("ingots/tin");
        public static final TagKey<Item> INGOTS_OBSIDIAN = forge("ingots/obsidian");

        public static final TagKey<Item> NUGGETS_DEVIL = forge("nuggets/devil");
        public static final TagKey<Item> NUGGETS_ANGELIC = forge("nuggets/angelic");
        public static final TagKey<Item> NUGGETS_CHRISTIAN_MID_TERM = forge("nuggets/christian_mid_term");
        public static final TagKey<Item> NUGGETS_MID_TERM = forge("nuggets/mid_term");
        public static final TagKey<Item> NUGGETS_OBSIDIAN_INFUSED_MID_TERM = forge("nuggets/obsidian_infused_mid_term");
        public static final TagKey<Item> NUGGETS_ALJAMEED = forge("nuggets/aljameed");
        public static final TagKey<Item> NUGGETS_ALJANSTEEL = forge("nuggets/aljansteel");
        public static final TagKey<Item> NUGGETS_MOONERING = forge("nuggets/moonering");
        public static final TagKey<Item> NUGGETS_MILKLLARY = forge("nuggets/milkllary");
        public static final TagKey<Item> NUGGETS_MID_HILLARY = forge("nuggets/mid_hillary");
        public static final TagKey<Item> NUGGETS_HARDENED_AMARACAMEL = forge("nuggets/hardened_amaracamel");
        public static final TagKey<Item> NUGGETS_MILKLLARITY = forge("nuggets/milkllarity");
        public static final TagKey<Item> NUGGETS_CRYSTALLINE_ANGELIC = forge("nuggets/crystalline_angelic");
        public static final TagKey<Item> NUGGETS_JANTICAL = forge("nuggets/jantical");
        public static final TagKey<Item> NUGGETS_DIAMOND = forge("nuggets/diamond");

        public static final TagKey<Item> DUSTS_DEVIL = forge("dusts/devil");
        public static final TagKey<Item> DUSTS_ANGELIC = forge("dusts/angelic");
        public static final TagKey<Item> DUSTS_CHRISTIAN_MID_TERM = forge("dusts/christian_mid_term");
        public static final TagKey<Item> DUSTS_DEVIL_ANGELIC = forge("dusts/devil_angelic");
        public static final TagKey<Item> DUSTS_CHRISTIAN_MID_TERM_ANGELIC = forge("dusts/christian_mid_term_angelic");
        public static final TagKey<Item> DUSTS_CHRISTIAN_MID_TERM_DEVIL = forge("dusts/christian_mid_term_devil");
        public static final TagKey<Item> DUSTS_MID_TERM = forge("dusts/mid_term");
        public static final TagKey<Item> DUSTS_OBSIDIAN_INFUSED_MID_TERM = forge("dusts/obsidian_infused_mid_term");
        public static final TagKey<Item> DUSTS_ALJAMEED = forge("dusts/aljameed");
        public static final TagKey<Item> DUSTS_ALJANSTEEL = forge("dusts/aljansteel");
        public static final TagKey<Item> DUSTS_MOONERING = forge("dusts/moonering");
        public static final TagKey<Item> DUSTS_WATER = forge("dusts/water");
        public static final TagKey<Item> DUSTS_HILLARY = forge("dusts/hillary");
        public static final TagKey<Item> DUSTS_MILKLLARY = forge("dusts/milkllary");

        public static final TagKey<Item> SINGULARITIES = forge("singularities");
        public static final TagKey<Item> SINGULARITIES_MID_TERM = forge("singularities/mid_term");
        public static final TagKey<Item> SINGULARITIES_OBSIDIAN_INFUSED_MID_TERM = forge("singularities/obsidian_infused_mid_term");
        public static final TagKey<Item> SINGULARITIES_MILKLLARY = forge("singularities/milkllary");
        public static final TagKey<Item> SINGULARITIES_FRUTIFERY = forge("singularities/frutifery");
        public static final TagKey<Item> SINGULARITIES_FRUTIFERY_BACKMATH = forge("singularities/frutifery/backmath");
        public static final TagKey<Item> SINGULARITIES_FRUTIFERY_MINECRAFT = forge("singularities/frutifery/minecraft");
        public static final TagKey<Item> SINGULARITIES_MEATY = forge("singularities/meaty");
        public static final TagKey<Item> SINGULARITIES_MEATY_FABRICIO = forge("singularities/meaty/fabricio");
        public static final TagKey<Item> SINGULARITIES_MEATY_SOPHIE = forge("singularities/meaty/sophie");
        public static final TagKey<Item> SINGULARITIES_MEATY_LUCIA = forge("singularities/meaty/lucia");
        public static final TagKey<Item> SINGULARITIES_MEATY_MINECRAFT = forge("singularities/meaty/minecraft");
        public static final TagKey<Item> SINGULARITIES_FISHY = forge("singularities/fishy");
        public static final TagKey<Item> SINGULARITIES_VEGETABLY = forge("singularities/vegetably");
        public static final TagKey<Item> SINGULARITIES_VEGETABLY_VARIANTS = forge("singularities/vegetably/variants");
        public static final TagKey<Item> SINGULARITIES_CHRISTIANITY = forge("singularities/christianity");
        public static final TagKey<Item> SINGULARITIES_EMOTIONAL = forge("singularities/emotional");
        public static final TagKey<Item> SINGULARITIES_HEAT = forge("singularities/heat");
        public static final TagKey<Item> SINGULARITIES_MANGA_MANGO = forge("singularities/manga_mango");

        public static final TagKey<Item> RODS_DEVIL = forge("rods/devil");
        public static final TagKey<Item> RODS_ANGELIC = forge("rods/angelic");
        public static final TagKey<Item> RODS_MID_TERM = forge("rods/mid_term");
        public static final TagKey<Item> RODS_HILLARY = forge("rods/hillary");
        public static final TagKey<Item> RODS_ALJAMEED = forge("rods/aljameed");
        public static final TagKey<Item> RODS_CRYSTALLINE_BIRCH = forge("rods/crystalline_birch");
        public static final TagKey<Item> RODS_GOLDENWOOD = forge("rods/goldenwood");
        public static final TagKey<Item> RODS_GUAVA = forge("rods/guava");
        public static final TagKey<Item> RODS_JABUTICABA = forge("rods/jabuticaba");
        public static final TagKey<Item> RODS_CORK_OAK = forge("rods/cork_oak");
        public static final TagKey<Item> RODS_ALJANWOOD = forge("rods/aljanwood");
        public static final TagKey<Item> RODS_ALJANCAP = forge("rods/aljancap");
        public static final TagKey<Item> RODS_INSOMNIAN = forge("rods/insomnian");
        public static final TagKey<Item> RODS_AVONDALIC_WILLOW = forge("rods/avondalic_willow");

        public static final TagKey<Item> MOLDS = backMath("molds");
        public static final TagKey<Item> MOLDS_SINGULARITY = backMath("molds/singularity");
        public static final TagKey<Item> MOLDS_CRYSTALLIZED = backMath("molds/crystallized");
        public static final TagKey<Item> MOLDS_INGOT = backMath("molds/ingot");
        public static final TagKey<Item> MOLDS_EMPTY = backMath("molds/empty");
        public static final TagKey<Item> MOLDS_MOLD = backMath("molds/mold");
        public static final TagKey<Item> MOLDS_CRYSTALLINE_EMPTY = backMath("molds/crystalline_empty");
        public static final TagKey<Item> MOLDS_CRYSTALLINE_GEM = backMath("molds/crystalline_gem");
        public static final TagKey<Item> MOLDS_ROD = backMath("molds/rod");

        public static final TagKey<Item> SQUIDS = backMath("squids");
        public static final TagKey<Item> POPSICLES = backMath("popsicles");
        public static final TagKey<Item> ALJANSTONE_CRAFTING_MATERIALS = backMath("aljanstone_crafting_materials");
        public static final TagKey<Item> MID_TERM_MATERIALS = backMath("mid_term_materials");
        public static final TagKey<Item> OIMT_MATERIALS = backMath("oimt_materials");
        // Tag Migration
        public static final TagKey<Item> ALJAN_RECIPE_STICKS = backMath("aljan_recipe_sticks");
        public static final TagKey<Item> BACK_GUIDE_RECIPE_ACCEPTABLES = backMath("back_guide_recipe_acceptables");
        public static final TagKey<Item> MATERIALS = backMath("materials");
        public static final TagKey<Item> MATERIALS_HARDENED_AMARACAMEL = backMath("materials/hardened_amaracamel");
        public static final TagKey<Item> CROWNS = backMath("crowns");
        public static final TagKey<Item> FOOD_BAGS = backMath("food_bags");
        public static final TagKey<Item> ENERGETICS = backMath("energetics");
        public static final TagKey<Item> MORTAR_AND_PESTLES = backMath("mortar_and_pestles");
        public static final TagKey<Item> DISCS = backMath("discs");
        public static final TagKey<Item> BOTTLES = backMath("bottles");
        public static final TagKey<Item> BUCKETS = backMath("buckets");
        public static final TagKey<Item> JUICES = backMath("juices");
        public static final TagKey<Item> JAMS = backMath("jams");
        public static final TagKey<Item> CUT_FRUITS = backMath("cut_fruits");
        public static final TagKey<Item> ITEM_SACS = backMath("item_sacs");
        public static final TagKey<Item> EMPTY_ITEM_SACS = backMath("empty_item_sacs");
        public static final TagKey<Item> MILKED_SWORDS = backMath("milked_swords");
        public static final TagKey<Item> MILKED_SPAREYS = backMath("milked_spareys");

        public static final TagKey<Item> CRYSTALLINE_BIRCH_LOGS = backMath("crystalline_birch_logs");
        public static final TagKey<Item> CORK_OAK_LOGS = backMath("cork_oak_logs");
        public static final TagKey<Item> GOLDENWOOD_LOGS = backMath("goldenwood_logs");
        public static final TagKey<Item> GUAVA_LOGS = backMath("guava_logs");
        public static final TagKey<Item> JABUTICABA_LOGS = backMath("jabuticaba_logs");
        public static final TagKey<Item> ALJANWOOD_LOGS = backMath("aljanwood_logs");
        public static final TagKey<Item> ALJANCAP_LOGS = backMath("aljancap_logs");
        public static final TagKey<Item> INSOMNIAN_LOGS = backMath("insomnian_logs");
        public static final TagKey<Item> AVONDALIC_WILLOW_LOGS = backMath("avondalic_willow_logs");
        public static final TagKey<Item> STRIPPED_WOODS = backMath("stripped_woods");
        public static final TagKey<Item> ALJAN_LOGS = backMath("aljan_logs");

        public static final TagKey<Item> GRAPE_VINE_POSTS = backMath("grape_vine_posts");
        public static final TagKey<Item> TOYS = backMath("toys");

        public static final TagKey<Item> SOPHIE_IDEA = backMath("sophie_idea");
        public static final TagKey<Item> ALPHA_IDEA = backMath("sophie_idea/alpha");
        public static final TagKey<Item> SOPHIES_TAKE_OVER_IDEA = backMath("sophie_idea/sophies_take_over");
        public static final TagKey<Item> ALJAMIC_WARS_IDEA = backMath("sophie_idea/aljamic_wars");
        public static final TagKey<Item> BOUNTIFULLY_EXPANSIVE_IDEA = backMath("sophie_idea/bountifully_expansive");
        // Tag Migration

        public static final TagKey<Item> GEMS_MID_TERM = forge("gems/mid_term");
        public static final TagKey<Item> GEMS_OBSIDIAN_INFUSED_MID_TERM = forge("gems/obsidian_infused_mid_term");
        public static final TagKey<Item> GEMS_MILKLLARITY = forge("gems/milkllarity");
        public static final TagKey<Item> GEMS_CRYSTALLINE_ANGELIC = forge("gems/crystalline_angelic");
        public static final TagKey<Item> GEMS_JANTICAL = forge("gems/jantical");
        public static final TagKey<Item> GEMS_PERSONA = forge("gems/persona");

        public static final TagKey<Item> STORAGE_BLOCKS_DEVIL = forge("storage_blocks/devil");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_DEVIL = forge("storage_blocks/raw_devil");
        public static final TagKey<Item> STORAGE_BLOCKS_ANGELIC = forge("storage_blocks/angelic");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_ANGELIC = forge("storage_blocks/raw_angelic");
        public static final TagKey<Item> STORAGE_BLOCKS_CHRISTIAN_MID_TERM = forge("storage_blocks/christian_mid_term");
        public static final TagKey<Item> STORAGE_BLOCKS_DEVIL_ANGELIC = forge("storage_blocks/devil_angelic");
        public static final TagKey<Item> STORAGE_BLOCKS_CHRISTIAN_MID_TERM_ANGELIC = forge("storage_blocks/christian_mid_term_angelic");
        public static final TagKey<Item> STORAGE_BLOCKS_CHRISTIAN_MID_TERM_DEVIL = forge("storage_blocks/christian_mid_term_devil");
        public static final TagKey<Item> STORAGE_BLOCKS_MID_TERM = forge("storage_blocks/mid_term");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_MID_TERM = forge("storage_blocks/raw_mid_term");
        public static final TagKey<Item> STORAGE_BLOCKS_OBSIDIAN_INFUSED_MID_TERM = forge("storage_blocks/obsidian_infused_mid_term");
        public static final TagKey<Item> STORAGE_BLOCKS_CRYSTALLINE_ANGELIC = forge("storage_blocks/crystalline_angelic");
        public static final TagKey<Item> STORAGE_BLOCKS_MILKLLARY = forge("storage_blocks/milkllary");
        public static final TagKey<Item> STORAGE_BLOCKS_HARDENED_AMARACAMEL = forge("storage_blocks/hardened_amaracamel");
        public static final TagKey<Item> STORAGE_BLOCKS_CHARJAN_COAL = forge("storage_blocks/charjan_coal");
        public static final TagKey<Item> STORAGE_BLOCKS_ALJAMEED = forge("storage_blocks/aljameed");
        public static final TagKey<Item> STORAGE_BLOCKS_ALJANSTEEL = forge("storage_blocks/aljansteel");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_ALJAMEED = forge("storage_blocks/raw_aljameed");
        public static final TagKey<Item> STORAGE_BLOCKS_MOONERING = forge("storage_blocks/moonering");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_MOONERING = forge("storage_blocks/raw_moonering");
        public static final TagKey<Item> STORAGE_BLOCKS_MID_HILLARY = forge("storage_blocks/mid_hillary");
        public static final TagKey<Item> STORAGE_BLOCKS_JANTICAL = forge("storage_blocks/jantical");

        public static final TagKey<Item> ORES_DEVIL = forge("ores/devil");
        public static final TagKey<Item> ORES_ANGELIC = forge("ores/angelic");
        public static final TagKey<Item> ORES_MID_TERM = forge("ores/mid_term");
        public static final TagKey<Item> ORES_CRYSTALLINE_ANGELIC = forge("ores/crystalline_angelic");
        public static final TagKey<Item> ORES_ALJAMEED = forge("ores/aljameed");
        public static final TagKey<Item> ORES_MOONERING = forge("ores/moonering");
        public static final TagKey<Item> ORES_JANTICAL = forge("ores/jantical");
        public static final TagKey<Item> ORES_ALJAMIC_COPPER = forge("ores/aljamic_copper");
        public static final TagKey<Item> ORES_ALJAMIC_TIN = forge("ores/aljamic_tin");
        public static final TagKey<Item> ORES_COPPER = forge("ores/copper");
        public static final TagKey<Item> ORES_TIN = forge("ores/tin");

        public static final TagKey<Item> ARMORS_BOOTS = forge("armors/boots");
        public static final TagKey<Item> KNIVES = forge("knives");
        public static final TagKey<Item> MILK = forge("milk");

        // Tag Migration
        public static final TagKey<Item> GLASS_DEVIL = forge("glass/devil");
        public static final TagKey<Item> GLASS_PANES_DEVIL = forge("glass_panes/devil");

        public static final TagKey<Item> DYES_DEVIL = forge("dyes/devil");
        public static final TagKey<Item> DYES_ALJAN_LIGHT_BLUE = forge("dyes/aljan_light_blue");
        public static final TagKey<Item> DYES_POISON_BROWN = forge("dyes/poison_brown");
        public static final TagKey<Item> DYES_INSOMNIAN = forge("dyes/insomnian");

        private static TagKey<Item> forge(String path) {
            return ItemTags.create(new ResourceLocation("forge", path));
        }

        private static TagKey<Item> backMath(String path) {
            return ItemTags.create(BackMath.resourceLoc(path));
        }
    }

    public static class Blocks {
        public static final TagKey<Block> STORAGE_BLOCKS_DEVIL = forge("storage_blocks/devil");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_DEVIL = forge("storage_blocks/raw_devil");
        public static final TagKey<Block> STORAGE_BLOCKS_ANGELIC = forge("storage_blocks/angelic");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_ANGELIC = forge("storage_blocks/raw_angelic");
        public static final TagKey<Block> STORAGE_BLOCKS_CHRISTIAN_MID_TERM = forge("storage_blocks/christian_mid_term");
        public static final TagKey<Block> STORAGE_BLOCKS_DEVIL_ANGELIC = forge("storage_blocks/devil_angelic");
        public static final TagKey<Block> STORAGE_BLOCKS_CHRISTIAN_MID_TERM_ANGELIC = forge("storage_blocks/christian_mid_term_angelic");
        public static final TagKey<Block> STORAGE_BLOCKS_CHRISTIAN_MID_TERM_DEVIL = forge("storage_blocks/christian_mid_term_devil");
        public static final TagKey<Block> STORAGE_BLOCKS_MID_TERM = forge("storage_blocks/mid_term");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_MID_TERM = forge("storage_blocks/raw_mid_term");
        public static final TagKey<Block> STORAGE_BLOCKS_OBSIDIAN_INFUSED_MID_TERM = forge("storage_blocks/obsidian_infused_mid_term");
        public static final TagKey<Block> STORAGE_BLOCKS_CRYSTALLINE_ANGELIC = forge("storage_blocks/crystalline_angelic");
        public static final TagKey<Block> STORAGE_BLOCKS_MILKLLARY = forge("storage_blocks/milkllary");
        public static final TagKey<Block> STORAGE_BLOCKS_HARDENED_AMARACAMEL = forge("storage_blocks/hardened_amaracamel");
        public static final TagKey<Block> STORAGE_BLOCKS_CHARJAN_COAL = forge("storage_blocks/charjan_coal");
        public static final TagKey<Block> STORAGE_BLOCKS_ALJAMEED = forge("storage_blocks/aljameed");
        public static final TagKey<Block> STORAGE_BLOCKS_ALJANSTEEL = forge("storage_blocks/aljansteel");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_ALJAMEED = forge("storage_blocks/raw_aljameed");
        public static final TagKey<Block> STORAGE_BLOCKS_MOONERING = forge("storage_blocks/moonering");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_MOONERING = forge("storage_blocks/raw_moonering");
        public static final TagKey<Block> STORAGE_BLOCKS_MID_HILLARY = forge("storage_blocks/mid_hillary");
        public static final TagKey<Block> STORAGE_BLOCKS_JANTICAL = forge("storage_blocks/jantical");

        public static final TagKey<Block> ORES_DEVIL = forge("ores/devil");
        public static final TagKey<Block> ORES_ANGELIC = forge("ores/angelic");
        public static final TagKey<Block> ORES_MID_TERM = forge("ores/mid_term");
        public static final TagKey<Block> ORES_CRYSTALLINE_ANGELIC = forge("ores/crystalline_angelic");
        public static final TagKey<Block> ORES_ALJAMEED = forge("ores/aljameed");
        public static final TagKey<Block> ORES_MOONERING = forge("ores/moonering");
        public static final TagKey<Block> ORES_JANTICAL = forge("ores/jantical");
        public static final TagKey<Block> ORES_ALJAMIC_COPPER = forge("ores/aljamic_copper");
        public static final TagKey<Block> ORES_ALJAMIC_TIN = forge("ores/aljamic_tin");
        public static final TagKey<Block> ORES_COPPER = forge("ores/copper");
        public static final TagKey<Block> ORES_TIN = forge("ores/tin");

        public static final TagKey<Block> GLASS_DEVIL = forge("glass/devil");
        public static final TagKey<Block> GLASS_PANES_DEVIL = forge("glass_panes/devil");

        public static final TagKey<Block> BASE_STONE_ALJAN = backMath("base_stone_aljan");
        public static final TagKey<Block> INFINIBURN_ALJAN = backMath("infiniburn_aljan");
        public static final TagKey<Block> CRYSTALLINE_BIRCH_LOGS = backMath("crystalline_birch_logs");
        public static final TagKey<Block> CORK_OAK_LOGS = backMath("cork_oak_logs");
        public static final TagKey<Block> GOLDENWOOD_LOGS = backMath("goldenwood_logs");
        public static final TagKey<Block> GUAVA_LOGS = backMath("guava_logs");
        public static final TagKey<Block> JABUTICABA_LOGS = backMath("jabuticaba_logs");
        public static final TagKey<Block> ALJANWOOD_LOGS = backMath("aljanwood_logs");
        public static final TagKey<Block> ALJANCAP_LOGS = backMath("aljancap_logs");
        public static final TagKey<Block> INSOMNIAN_LOGS = backMath("insomnian_logs");
        public static final TagKey<Block> AVONDALIC_WILLOW_LOGS = backMath("avondalic_willow_logs");
        public static final TagKey<Block> STRIPPED_WOODS = backMath("stripped_woods");
        public static final TagKey<Block> GRAPE_VINE_POSTS = backMath("grape_vine_posts");
        public static final TagKey<Block> SQUIDS = backMath("squids");
        public static final TagKey<Block> TOYS = backMath("toys");
        public static final TagKey<Block> END_ORE_REPLACEABLE = backMath("end_ore_replaceable");
        public static final TagKey<Block> OBSIDIAN_ORE_REPLACEABLE = backMath("obsidian_ore_replaceable");

        public static final TagKey<Block> SOPHIE_IDEA = backMath("sophie_idea");
        public static final TagKey<Block> BOUNTIFULLY_EXPANSIVE_IDEA = backMath("sophie_idea/bountifully_expansive");

        private static TagKey<Block> forge(String path) {
            return BlockTags.create(new ResourceLocation("forge", path));
        }

        private static TagKey<Block> backMath(String path) {
            return BlockTags.create(BackMath.resourceLoc(path));
        }

        private Blocks() {}
    }

    public static class Fluids {
        public static final TagKey<Fluid> HILLARY = backMath("hillary");
        public static final TagKey<Fluid> MILKLLARY = backMath("milkllary");
        public static final TagKey<Fluid> LIQUID_ALJAME = backMath("liquid_aljame");
        public static final TagKey<Fluid> LIQUID_MANGA = backMath("liquid_manga");
        public static final TagKey<Fluid> LIQUEFIED_MONSTER = backMath("liquefied_monster");
        public static final TagKey<Fluid> SLEEPISHWATER = backMath("sleepishwater");

        private static TagKey<Fluid> backMath(String path) {
            return FluidTags.create(BackMath.resourceLoc(path));
        }
    }

    /*public static class EntityTypes {
        public static final TagKey<EntityType<?>> SOPHIE_IDEA = create("backmath:sophie_idea");
        public static final TagKey<EntityType<?>> ALJAMIC_WARS_IDEA = create("backmath:sophie_idea/aljamic_wars");

        private static TagKey<EntityType<?>> backMath(String path) {
            return EntityTypeTags.create(BackMath.resourceLoc(path));
        }
    }*/

    public static class Biomes {
        public static final TagKey<Biome> HAS_CRYSTALLINE_ANGELIC_ORE = backMath("has_crystalline_angelic_ore");
        public static final TagKey<Biome> HAS_ABUNDANT_ANGELIC_ORE = backMath("has_abundant_angelic_ore");

        public static final TagKey<Biome> IS_BACK_FIELDS = backMath("is_back_fields");

        public static final TagKey<Biome> IS_ALJAN = backMath("is_aljan");
        public static final TagKey<Biome> ALJAMIC_HIGHLANDS_ORES = backMath("aljamic_highlands_ores");

        private static TagKey<Biome> backMath(String name) {
            return TagKey.create(Registries.BIOME, BackMath.resourceLoc(name));
        }
    }
}
