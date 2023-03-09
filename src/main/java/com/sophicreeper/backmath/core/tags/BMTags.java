package com.sophicreeper.backmath.core.tags;

import com.sophicreeper.backmath.core.client.BackMath;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class BMTags {
    public static class Items {
        public static final ITag.INamedTag<Item> INGOTS_DEVIL = forge("ingots/devil");
        public static final ITag.INamedTag<Item> INGOTS_ANGELIC = forge("ingots/angelic");
        public static final ITag.INamedTag<Item> INGOTS_CHRISTIAN_MID_TERM = forge("ingots/christian_mid_term");
        public static final ITag.INamedTag<Item> INGOTS_DEVIL_ANGELIC = forge("ingots/devil_angelic");
        public static final ITag.INamedTag<Item> INGOTS_CHRISTIAN_MID_TERM_ANGELIC = forge("ingots/christian_mid_term_angelic");
        public static final ITag.INamedTag<Item> INGOTS_CHRISTIAN_MID_TERM_DEVIL = forge("ingots/christian_mid_term_devil");
        public static final ITag.INamedTag<Item> INGOTS_MID_TERM = forge("ingots/mid_term");
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

        public static final ITag.INamedTag<Item> RODS_GUAVA = forge("rods/guava");
        public static final ITag.INamedTag<Item> RODS_ALJANWOOD = forge("rods/aljanwood");
        public static final ITag.INamedTag<Item> RODS_ALJANCAP = forge("rods/aljancap");
        public static final ITag.INamedTag<Item> RODS_INSOMNIAN = forge("rods/insomnian");
        public static final ITag.INamedTag<Item> RODS_ALJAMEED = forge("rods/aljameed");

        public static final ITag.INamedTag<Item> SQUIDS = backMath("squids");
        public static final ITag.INamedTag<Item> MOLDS = backMath("molds");
        public static final ITag.INamedTag<Item> MOLDS_SINGULARITY = backMath("molds/singularity");
        public static final ITag.INamedTag<Item> MOLDS_CRYSTALLIZED = backMath("molds/crystallized");
        public static final ITag.INamedTag<Item> MOLDS_INGOT = backMath("molds/ingot");
        public static final ITag.INamedTag<Item> MOLDS_EMPTY = backMath("molds/empty");
        public static final ITag.INamedTag<Item> MOLDS_MOLD = backMath("molds/mold");
        public static final ITag.INamedTag<Item> MOLDS_CRYSTALLINE_EMPTY = backMath("molds/crystalline_empty");
        public static final ITag.INamedTag<Item> MOLDS_CRYSTALLINE_GEM = backMath("molds/crystalline_gem");
        public static final ITag.INamedTag<Item> MOLDS_ROD = backMath("molds/rod");
        public static final ITag.INamedTag<Item> POPSICLES = backMath("popsicles");
        public static final ITag.INamedTag<Item> ALJANSTONE_CRAFTING_MATERIALS = backMath("aljanstone_crafting_materials");

        public static final ITag.INamedTag<Item> GEMS_CRYSTALLINE_ANGELIC = forge("gems/crystalline_angelic");
        public static final ITag.INamedTag<Item> GEMS_OBSIDIAN_INFUSED_MID_TERM = forge("gems/obsidian_infused_mid_term");
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
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_MID_TERM = forge("storage_blocks/mid_term");
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

        public static final ITag.INamedTag<Item> ORES_ALJAMEED = forge("ores/aljameed");
        public static final ITag.INamedTag<Item> ORES_MOONERING = forge("ores/moonering");
        public static final ITag.INamedTag<Item> ORES_JANTICAL = forge("ores/jantical");
        public static final ITag.INamedTag<Item> ORES_ALJAMIC_COPPER = forge("ores/aljamic_copper");
        public static final ITag.INamedTag<Item> ORES_ALJAMIC_TIN = forge("ores/aljamic_tin");
        public static final ITag.INamedTag<Item> ORES_COPPER = forge("ores/copper");
        public static final ITag.INamedTag<Item> ORES_TIN = forge("ores/tin");

        private static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Item> backMath(String path) {
            return ItemTags.makeWrapperTag(BackMath.resourceLoc(path).toString());
        }
    }

    public static class Blocks {
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_DEVIL = forgeBlock("storage_blocks/devil");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_RAW_DEVIL = forgeBlock("storage_blocks/raw_devil");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_ANGELIC = forgeBlock("storage_blocks/angelic");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_RAW_ANGELIC = forgeBlock("storage_blocks/raw_angelic");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_CHRISTIAN_MID_TERM = forgeBlock("storage_blocks/christian_mid_term");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_DEVIL_ANGELIC = forgeBlock("storage_blocks/devil_angelic");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_CHRISTIAN_MID_TERM_ANGELIC = forgeBlock("storage_blocks/christian_mid_term_angelic");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_CHRISTIAN_MID_TERM_DEVIL = forgeBlock("storage_blocks/christian_mid_term_devil");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_MID_TERM = forgeBlock("storage_blocks/mid_term");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_RAW_MID_TERM = forgeBlock("storage_blocks/raw_mid_term");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_OBSIDIAN_INFUSED_MID_TERM = forgeBlock("storage_blocks/obsidian_infused_mid_term");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_CRYSTALLINE_ANGELIC = forgeBlock("storage_blocks/crystalline_angelic");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_MILKLLARY = forgeBlock("storage_blocks/milkllary");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_HARDENED_AMARACAMEL = forgeBlock("storage_blocks/hardened_amaracamel");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_CHARJAN_COAL = forgeBlock("storage_blocks/charjan_coal");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_ALJAMEED = forgeBlock("storage_blocks/aljameed");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_ALJANSTEEL = forgeBlock("storage_blocks/aljansteel");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_RAW_ALJAMEED = forgeBlock("storage_blocks/raw_aljameed");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_MOONERING = forgeBlock("storage_blocks/moonering");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_RAW_MOONERING = forgeBlock("storage_blocks/raw_moonering");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_MID_HILLARY = forgeBlock("storage_blocks/mid_hillary");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_JANTICAL = forgeBlock("storage_blocks/jantical");

        public static final ITag.INamedTag<Block> ORES_ALJAMEED = forgeBlock("ores/aljameed");
        public static final ITag.INamedTag<Block> ORES_MOONERING = forgeBlock("ores/moonering");
        public static final ITag.INamedTag<Block> ORES_JANTICAL = forgeBlock("ores/jantical");
        public static final ITag.INamedTag<Block> ORES_ALJAMIC_COPPER = forgeBlock("ores/aljamic_copper");
        public static final ITag.INamedTag<Block> ORES_ALJAMIC_TIN = forgeBlock("ores/aljamic_tin");
        public static final ITag.INamedTag<Block> ORES_COPPER = forgeBlock("ores/copper");
        public static final ITag.INamedTag<Block> ORES_TIN = forgeBlock("ores/tin");

        public static final ITag.INamedTag<Block> BASE_STONE_ALJAN = modBlock("base_stone_aljan");

        private static ITag.INamedTag<Block> forgeBlock(String path) {
            return BlockTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Block> modBlock(String path) {
            return BlockTags.makeWrapperTag(BackMath.resourceLoc(path).toString());
        }

        private Blocks() {}
    }
}
