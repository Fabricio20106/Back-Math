package com.sophicreeper.backmath.data.tags;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Items;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class BMItemTagsProvider extends ItemTagsProvider {
    public BMItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTagsProvider, @Nullable ExistingFileHelper fileHelper) {
        super(generator, blockTagsProvider, BackMath.MOD_ID, fileHelper);
    }

    @Override
    public String getName() {
        return "Back Math - Item Tags";
    }

    @Override
    protected void registerTags() {
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_DEVIL).add(AxolotlTest.DEVIL_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_ANGELIC).add(AxolotlTest.ANGELIC_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_CHRISTIAN_MID_TERM).add(AxolotlTest.CHRISTIAN_MID_TERM_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_WARMTERM).add(AxolotlTest.WARMTERM_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_MID_TERM).add(AxolotlTest.MID_TERM_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_COLDTERM).add(AxolotlTest.COLDTERM_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_CHRISTIAN_MID_TERM_ANGELIC).add(AxolotlTest.CHRISTIAN_MID_TERM_ANGELIC_ALLOY_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_CHRISTIAN_MID_TERM_DEVIL).add(AxolotlTest.CHRISTIAN_MID_TERM_DEVIL_ALLOY_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_DEVIL_ANGELIC).add(AxolotlTest.DEVIL_ANGELIC_ALLOY_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_OBSIDIAN_INFUSED_MID_TERM).add(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_ALJAMEED).add(AxolotlTest.ALJAMEED_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_ALJANSTEEL).add(AxolotlTest.ALJANSTEEL_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_MOONERING).add(AxolotlTest.MOONERING_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_CHARJAN_COAL).add(AxolotlTest.CHARJAN_COAL_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_HARDENED_AMARACAMEL).add(AxolotlTest.HARDENED_AMARACAMEL_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_MILKLLARY).add(AxolotlTest.MILKLLARY_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_CRYSTALLINE_ANGELIC).add(AxolotlTest.CRYSTALLINE_ANGELIC_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_RAW_DEVIL).add(AxolotlTest.RAW_DEVIL_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_RAW_ANGELIC).add(AxolotlTest.RAW_ANGELIC_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_RAW_MID_TERM).add(AxolotlTest.RAW_MID_TERM_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_RAW_ALJAMEED).add(AxolotlTest.RAW_ALJAMEED_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_RAW_MOONERING).add(AxolotlTest.RAW_MOONER_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_MID_HILLARY).add(AxolotlTest.MID_HILLARY_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_JANTICAL).add(AxolotlTest.JANTICAL_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_RAW_ALJAMIC_COPPER).add(AxolotlTest.RAW_ALJAMIC_COPPER_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_RAW_ALJAMIC_TIN).add(AxolotlTest.RAW_ALJAMIC_TIN_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_EMERIOND).add(AxolotlTest.EMERIOND_BLOCK.get());

        this.getOrCreateBuilder(BMTags.Items.ORES_DEVIL).add(AxolotlTest.DEVIL_ORE.get()).add(AxolotlTest.DEEPSLATE_DEVIL_ORE.get()).add(AxolotlTest.NETHER_DEVIL_ORE.get()).add(AxolotlTest.RAW_DEVIL.get());
        this.getOrCreateBuilder(BMTags.Items.ORES_ANGELIC).add(AxolotlTest.ANGELIC_ORE.get()).add(AxolotlTest.DEEPSLATE_ANGELIC_ORE.get()).add(AxolotlTest.RAW_ANGELIC.get());
        this.getOrCreateBuilder(BMTags.Items.ORES_MID_TERM).add(AxolotlTest.MID_TERM_ORE.get()).add(AxolotlTest.OBSIDIAN_MID_TERM_ORE.get()).add(AxolotlTest.RAW_MID_TERM.get());
        this.getOrCreateBuilder(BMTags.Items.ORES_CRYSTALLINE_ANGELIC).add(AxolotlTest.CRYSTALLINE_ANGELIC_ORE.get());
        this.getOrCreateBuilder(BMTags.Items.ORES_ALJAMEED).add(AxolotlTest.ALJAMEED_ORE.get()).add(AxolotlTest.SLEEPINGSTONE_ALJAMEED_ORE.get()).add(AxolotlTest.RAW_ALJAMEED.get());
        this.getOrCreateBuilder(BMTags.Items.ORES_MOONERING).add(AxolotlTest.MOONERING_ORE.get()).add(AxolotlTest.SLEEPINGSTONE_MOONERING_ORE.get()).add(AxolotlTest.RAW_MOONER.get());
        this.getOrCreateBuilder(BMTags.Items.ORES_JANTICAL).add(AxolotlTest.JANTIC_ORE.get()).add(AxolotlTest.SLEEPINGSTONE_JANTIC_ORE.get());
        this.getOrCreateBuilder(BMTags.Items.ORES_ALJAMIC_COPPER).add(AxolotlTest.ALJAMIC_COPPER_ORE.get()).add(AxolotlTest.RAW_ALJAMIC_COPPER.get()).add(AxolotlTest.SLEEPINGSTONE_ALJAMIC_COPPER_ORE.get());
        this.getOrCreateBuilder(BMTags.Items.ORES_COPPER).add(AxolotlTest.ALJAMIC_COPPER_ORE.get()).add(AxolotlTest.RAW_ALJAMIC_COPPER.get()).add(AxolotlTest.SLEEPINGSTONE_ALJAMIC_COPPER_ORE.get());
        this.getOrCreateBuilder(BMTags.Items.ORES_ALJAMIC_TIN).add(AxolotlTest.ALJAMIC_TIN_ORE.get()).add(AxolotlTest.RAW_ALJAMIC_TIN.get()).add(AxolotlTest.SLEEPINGSTONE_ALJAMIC_TIN_ORE.get());
        this.getOrCreateBuilder(BMTags.Items.ORES_TIN).add(AxolotlTest.ALJAMIC_TIN_ORE.get()).add(AxolotlTest.RAW_ALJAMIC_TIN.get()).add(AxolotlTest.SLEEPINGSTONE_ALJAMIC_TIN_ORE.get());

        this.getOrCreateBuilder(BMTags.Items.RAW_MATERIALS_DEVIL).add(AxolotlTest.RAW_DEVIL.get());
        this.getOrCreateBuilder(BMTags.Items.RAW_MATERIALS_ANGELIC).add(AxolotlTest.RAW_ANGELIC.get());
        this.getOrCreateBuilder(BMTags.Items.RAW_MATERIALS_MID_TERM).add(AxolotlTest.RAW_MID_TERM.get());
        this.getOrCreateBuilder(BMTags.Items.RAW_MATERIALS_ALJAMEED).add(AxolotlTest.RAW_ALJAMEED.get());
        this.getOrCreateBuilder(BMTags.Items.RAW_MATERIALS_ALJAMIC_COPPER).add(AxolotlTest.RAW_ALJAMIC_COPPER.get());
        this.getOrCreateBuilder(BMTags.Items.RAW_MATERIALS_ALJAMIC_TIN).add(AxolotlTest.RAW_ALJAMIC_TIN.get());
        this.getOrCreateBuilder(BMTags.Items.RAW_MATERIALS_MOONERING).add(AxolotlTest.RAW_MOONER.get());

        this.getOrCreateBuilder(BMTags.Items.RAW_MATERIALS).addTag(BMTags.Items.RAW_MATERIALS_DEVIL).addTag(BMTags.Items.RAW_MATERIALS_ANGELIC).addTag(BMTags.Items.RAW_MATERIALS_MID_TERM).addTag(BMTags.Items.RAW_MATERIALS_ALJAMEED)
                .addTag(BMTags.Items.RAW_MATERIALS_ALJAMIC_COPPER).addTag(BMTags.Items.RAW_MATERIALS_ALJAMIC_TIN).addTag(BMTags.Items.RAW_MATERIALS_MOONERING);

        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_DEVIL);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_ANGELIC);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_CHRISTIAN_MID_TERM);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_WARMTERM);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_MID_TERM);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_COLDTERM);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_CHRISTIAN_MID_TERM_ANGELIC);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_CHRISTIAN_MID_TERM_DEVIL);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_DEVIL_ANGELIC);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_OBSIDIAN_INFUSED_MID_TERM);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_ALJAMEED);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_ALJANSTEEL);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_MOONERING);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_CHARJAN_COAL);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_HARDENED_AMARACAMEL);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_MILKLLARY);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_CRYSTALLINE_ANGELIC);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_RAW_DEVIL);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_RAW_ANGELIC);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_RAW_MID_TERM);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_RAW_ALJAMEED);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_RAW_MOONERING);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_MID_HILLARY);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_JANTICAL);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_RAW_ALJAMIC_COPPER);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_RAW_ALJAMIC_TIN);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_EMERIOND);

        this.getOrCreateBuilder(Tags.Items.ORES).addTag(BMTags.Items.ORES_DEVIL).addTag(BMTags.Items.ORES_ANGELIC).addTag(BMTags.Items.ORES_MID_TERM)
                .addTag(BMTags.Items.ORES_CRYSTALLINE_ANGELIC).addTag(BMTags.Items.ORES_ALJAMEED).addTag(BMTags.Items.ORES_MOONERING).addTag(BMTags.Items.ORES_JANTICAL)
                .addTag(BMTags.Items.ORES_ALJAMIC_COPPER).addTag(BMTags.Items.ORES_COPPER).addTag(BMTags.Items.ORES_ALJAMIC_TIN).addTag(BMTags.Items.ORES_TIN);

        this.getOrCreateBuilder(BMTags.Items.INGOTS_CHRISTIAN_MID_TERM).add(AxolotlTest.CHRISTIAN_MID_TERM_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_ANGELIC).add(AxolotlTest.ANGELIC_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_DEVIL).add(AxolotlTest.DEVIL_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_WARMTERM).add(AxolotlTest.WARMTERM_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_MID_TERM).add(AxolotlTest.MID_TERM_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_COLDTERM).add(AxolotlTest.COLDTERM_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_CHRISTIAN_MID_TERM_ANGELIC).add(AxolotlTest.CHRISTIAN_MID_TERM_ANGELIC_ALLOY_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_CHRISTIAN_MID_TERM_DEVIL).add(AxolotlTest.CHRISTIAN_MID_TERM_DEVIL_ALLOY_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_DEVIL_ANGELIC).add(AxolotlTest.DEVIL_ANGELIC_ALLOY_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_MILKLLARY).add(AxolotlTest.MILKLLARY_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_OBSIDIAN_INFUSED_MID_TERM).add(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_MID_HILLARY).add(AxolotlTest.TWO_THIRDS_HILLARY_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_ALJAMEED).add(AxolotlTest.ALJAMEED_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_ALJANSTEEL).add(AxolotlTest.ALJANSTEEL_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_MOONERING).add(AxolotlTest.MOONERING_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_ALJAMIC_COPPER).add(AxolotlTest.ALJAMIC_COPPER_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_ALJAMIC_TIN).add(AxolotlTest.ALJAMIC_TIN_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_COPPER).add(AxolotlTest.ALJAMIC_COPPER_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_TIN).add(AxolotlTest.ALJAMIC_TIN_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_HARDENED_AMARACAMEL).add(AxolotlTest.HARDENED_AMARACAMEL_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_OBSIDIAN).add(AxolotlTest.OBSIDIAN_INGOT.get());

        this.getOrCreateBuilder(BMTags.Items.ORES_JANTICAL).add(AxolotlTest.JANTIC_ORE.get());

        this.getOrCreateBuilder(BMTags.Items.DUSTS_DEVIL).add(AxolotlTest.DEVIL_DUST.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_ANGELIC).add(AxolotlTest.ANGELIC_DUST.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_CHRISTIAN_MID_TERM).add(AxolotlTest.CHRISTIAN_MID_TERM_DUST.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_MID_TERM).add(AxolotlTest.MID_TERM_DUST.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_HILLARY).add(AxolotlTest.HILLARY_AGGLOMERATIO.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_MILKLLARY).add(AxolotlTest.MILKLLARY_AGGLOMERATIO.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_MID_HILLARY).add(AxolotlTest.TWO_THIRDS_HILLARY_DUST.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_CHRISTIAN_MID_TERM_ANGELIC).add(AxolotlTest.CHRISTIAN_MID_TERM_ANGELIC_DUST.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_CHRISTIAN_MID_TERM_DEVIL).add(AxolotlTest.CHRISTIAN_MID_TERM_DEVIL_DUST.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_DEVIL_ANGELIC).add(AxolotlTest.DEVIL_ANGELIC_DUST.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_OBSIDIAN_INFUSED_MID_TERM).add(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_DUST.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_ALJAMEED).add(AxolotlTest.ALJAMEED_DUST.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_ALJANSTEEL).add(AxolotlTest.ALJANSTEEL_BLEND.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_MOONERING).add(AxolotlTest.MOONERING_DUST.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_WATER).add(AxolotlTest.WATER_TALC_POWDER.get());

        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_CHRISTIANITY).add(AxolotlTest.CHRISTIANITY_SINGULARITY.get());
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_EMOTIONAL).add(AxolotlTest.EMOTIONAL_SINGULARITY.get());
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_HEAT).add(AxolotlTest.HEAT_SINGULARITY.get()).add(AxolotlTest.TEMPERATURE_SINGULARITY.get());
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_FISHY).add(AxolotlTest.FISHY_SINGULARITY.get());
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_MANGA_MANGO).add(AxolotlTest.MANGIBELARITY.get());
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_AMARACAMEL).add(AxolotlTest.AMARACAMELARITY.get());
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_MID_TERM).add(AxolotlTest.MID_TERM.get());
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_OBSIDIAN_INFUSED_MID_TERM).add(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM.get());
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_MILKLLARY).add(AxolotlTest.MILKLLARITY.get());
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_MEATY).addTag(BMTags.Items.SINGULARITIES_MEATY_FABRICIO).addTag(BMTags.Items.SINGULARITIES_MEATY_SOPHIE).addTag(BMTags.Items.SINGULARITIES_MEATY_LUCIA).addTag(BMTags.Items.SINGULARITIES_MEATY_MINECRAFT);
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_VEGETABLY).addTag(BMTags.Items.SINGULARITIES_VEGETABLY_VARIANTS).add(AxolotlTest.VEGETABLY_SINGULARITY.get());
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_VEGETABLY_VARIANTS).add(AxolotlTest.VEGETABLY_SINGULARITY_VARIANTS.get());
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_FRUTIFERY).addTag(BMTags.Items.SINGULARITIES_FRUTIFERY_BACKMATH).addTag(BMTags.Items.SINGULARITIES_FRUTIFERY_MINECRAFT);
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_FRUTIFERY_BACKMATH).add(AxolotlTest.FRUTIFERY_SINGULARITY_BACKMATH.get());
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_FRUTIFERY_MINECRAFT).add(AxolotlTest.FRUTIFERY_SINGULARITY_MINECRAFT.get());
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_MEATY_FABRICIO).add(AxolotlTest.MEATY_SINGULARITY_FABRICIO.get());
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_MEATY_SOPHIE).add(AxolotlTest.MEATY_SINGULARITY_SOPHIE.get());
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_MEATY_LUCIA).add(AxolotlTest.MEATY_SINGULARITY_LUCIA.get());
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_MEATY_MINECRAFT).add(AxolotlTest.MEATY_SINGULARITY_MINECRAFT.get());

        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES).addTag(BMTags.Items.SINGULARITIES_FRUTIFERY).addTag(BMTags.Items.SINGULARITIES_MEATY).addTag(BMTags.Items.SINGULARITIES_VEGETABLY).addTag(BMTags.Items.SINGULARITIES_EMOTIONAL)
                .addTag(BMTags.Items.SINGULARITIES_CHRISTIANITY).addTag(BMTags.Items.SINGULARITIES_HEAT).addTag(BMTags.Items.SINGULARITIES_FISHY).addTag(BMTags.Items.SINGULARITIES_MID_TERM).addTag(BMTags.Items.SINGULARITIES_OBSIDIAN_INFUSED_MID_TERM)
                .addTag(BMTags.Items.SINGULARITIES_MILKLLARY).addTag(BMTags.Items.SINGULARITIES_MANGA_MANGO).addTag(BMTags.Items.SINGULARITIES_AMARACAMEL).addTag(BMTags.Items.SINGULARITIES_MEATY_FABRICIO)
                .addTag(BMTags.Items.SINGULARITIES_MEATY_SOPHIE).addTag(BMTags.Items.SINGULARITIES_MEATY_LUCIA).addTag(BMTags.Items.SINGULARITIES_MEATY_MINECRAFT).addTag(BMTags.Items.SINGULARITIES_FRUTIFERY_BACKMATH)
                .addTag(BMTags.Items.SINGULARITIES_FRUTIFERY_MINECRAFT).addTag(BMTags.Items.SINGULARITIES_VEGETABLY_VARIANTS);

        this.getOrCreateBuilder(BMTags.Items.NUGGETS_DEVIL).add(AxolotlTest.DEVIL_NUGGET.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_ANGELIC).add(AxolotlTest.ANGELIC_NUGGET.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_CHRISTIAN_MID_TERM).add(AxolotlTest.CHRISTIAN_MID_TERM_NUGGET.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_MID_TERM).add(AxolotlTest.MID_TERM_NUGGET.get()).add(AxolotlTest.MID_TERM_SHARD.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_OBSIDIAN_INFUSED_MID_TERM).add(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_NUGGET.get()).add(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_SHARD.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_ALJAMEED).add(AxolotlTest.ALJAMEED_NUGGET.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_ALJANSTEEL).add(AxolotlTest.ALJANSTEEL_NUGGET.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_MOONERING).add(AxolotlTest.MOONERING_NUGGET.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_HARDENED_AMARACAMEL).add(AxolotlTest.HARDENED_AMARACAMEL_NUGGET.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_MILKLLARY).add(AxolotlTest.MILKLLARY_NUGGET.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_MID_HILLARY).add(AxolotlTest.TWO_THIRDS_HILLARY_NUGGET.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_MILKLLARITY).add(AxolotlTest.MILKLLARITY_SHARD.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_CRYSTALLINE_ANGELIC).add(AxolotlTest.CRYSTALLINE_ANGELIC_SHARD.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_JANTICAL).add(AxolotlTest.JANTICAL_SHARD.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_DIAMOND).add(AxolotlTest.DIAMOND_SHARD.get());

        this.getOrCreateBuilder(BMTags.Items.RODS_GOLD);
        this.getOrCreateBuilder(BMTags.Items.RODS_DEVIL).add(AxolotlTest.DEVIL_ROD.get());
        this.getOrCreateBuilder(BMTags.Items.RODS_ANGELIC).add(AxolotlTest.ANGELIC_ROD.get());
        this.getOrCreateBuilder(BMTags.Items.RODS_HILLARY).add(AxolotlTest.HILLARY_ROD.get());
        this.getOrCreateBuilder(BMTags.Items.RODS_MID_TERM).add(AxolotlTest.MID_TERM_ROD.get());
        this.getOrCreateBuilder(BMTags.Items.RODS_CRYSTALLINE_BIRCH).add(AxolotlTest.CRYSTALLINE_BIRCH_STICK.get());
        this.getOrCreateBuilder(BMTags.Items.RODS_GOLDENWOOD).add(AxolotlTest.GOLDENWOOD_STICK.get());
        this.getOrCreateBuilder(BMTags.Items.RODS_GUAVA).add(AxolotlTest.GUAVA_STICK.get());
        this.getOrCreateBuilder(BMTags.Items.RODS_JABUTICABA).add(AxolotlTest.JABUTICABA_STICK.get());
        this.getOrCreateBuilder(BMTags.Items.RODS_CORK_OAK).add(AxolotlTest.CORK_OAK_STICK.get());
        this.getOrCreateBuilder(BMTags.Items.RODS_ALJANCAP).add(AxolotlTest.ALJANCAP_STICK.get());
        this.getOrCreateBuilder(BMTags.Items.RODS_ALJANWOOD).add(AxolotlTest.ALJANWOOD_STICK.get());
        this.getOrCreateBuilder(BMTags.Items.RODS_INSOMNIAN).add(AxolotlTest.INSOMNIAN_STICK.get());
        this.getOrCreateBuilder(BMTags.Items.RODS_AVONDALIC_WILLOW).add(AxolotlTest.AVONDALIC_WILLOW_STICK.get());
        this.getOrCreateBuilder(BMTags.Items.RODS_ALJAMEED).add(AxolotlTest.ALJAMEED_BONE.get());

        this.getOrCreateBuilder(BMTags.Items.SQUIDS).add(AxolotlTest.TITO.get()).add(AxolotlTest.TOTI.get());
        this.getOrCreateBuilder(BMTags.Items.BONE_MEALS).add(Items.BONE_MEAL).add(AxolotlTest.SLEEPISH_FERTILIZER.get());
        this.getOrCreateBuilder(BMTags.Items.MOLDS_SINGULARITY).add(AxolotlTest.SINGULARITY_MOLD.get());
        this.getOrCreateBuilder(BMTags.Items.MOLDS_CRYSTALLIZED).add(AxolotlTest.CRYSTALLIZED_MOLD.get());
        this.getOrCreateBuilder(BMTags.Items.MOLDS_INGOT).add(AxolotlTest.INGOT_MOLD.get());
        this.getOrCreateBuilder(BMTags.Items.MOLDS_EMPTY).add(AxolotlTest.EMPTY_MOLD.get());
        this.getOrCreateBuilder(BMTags.Items.MOLDS_MOLD).add(AxolotlTest.MOLD_MOLD.get());
        this.getOrCreateBuilder(BMTags.Items.MOLDS_CRYSTALLINE_EMPTY).add(AxolotlTest.CRYSTALLINE_EMPTY_MOLD.get());
        this.getOrCreateBuilder(BMTags.Items.MOLDS_CRYSTALLINE_GEM).add(AxolotlTest.CRYSTALLINE_GEM_MOLD.get());
        this.getOrCreateBuilder(BMTags.Items.MOLDS_ROD).add(AxolotlTest.ROD_MOLD.get());
        this.getOrCreateBuilder(BMTags.Items.MOLDS).addTag(BMTags.Items.MOLDS_ROD).addTag(BMTags.Items.MOLDS_CRYSTALLIZED).addTag(BMTags.Items.MOLDS_INGOT).addTag(BMTags.Items.MOLDS_SINGULARITY)
                .addTag(BMTags.Items.MOLDS_EMPTY).addTag(BMTags.Items.MOLDS_MOLD).addTag(BMTags.Items.MOLDS_CRYSTALLINE_EMPTY).addTag(BMTags.Items.MOLDS_CRYSTALLINE_GEM);
        this.getOrCreateBuilder(BMTags.Items.POPSICLES).add(AxolotlTest.GUARANA_POPSICLE.get(), AxolotlTest.MANGO_POPSICLE.get(), AxolotlTest.GRAPE_POPSICLE.get(),
                AxolotlTest.ALJAME_POPSICLE.get(), AxolotlTest.LEMON_POPSICLE.get(), AxolotlTest.BANANA_POPSICLE.get(), AxolotlTest.ORANGE_POPSICLE.get(),
                AxolotlTest.PINEAPPLE_POPSICLE.get(), AxolotlTest.HILLARY_POPSICLE.get(), AxolotlTest.MILKLLARY_POPSICLE.get(), AxolotlTest.WATER_POPSICLE.get(),
                AxolotlTest.APPLE_POPSICLE.get(), AxolotlTest.MELON_POPSICLE.get(), AxolotlTest.GOLDEN_APPLE_POPSICLE.get()).add(AxolotlTest.MANGA_POPSICLE.get(),
                AxolotlTest.SWEET_BERRY_POPSICLE.get(), AxolotlTest.GLOW_BERRY_POPSICLE.get(), AxolotlTest.PUMPKIN_POPSICLE.get(), AxolotlTest.ENCHANTED_GOLDEN_APPLE_POPSICLE.get(),
                AxolotlTest.GUAVA_POPSICLE.get(), AxolotlTest.JABUTICABA_POPSICLE.get(), AxolotlTest.ALJAMIC_BERRY_POPSICLE.get(), AxolotlTest.GREEN_APPLE_POPSICLE.get());

        this.getOrCreateBuilder(BMTags.Items.GEMS_MID_TERM).add(AxolotlTest.MID_TERM.get());
        this.getOrCreateBuilder(BMTags.Items.GEMS_MILKLLARITY).add(AxolotlTest.MILKLLARITY.get());
        this.getOrCreateBuilder(BMTags.Items.GEMS_CRYSTALLINE_ANGELIC).add(AxolotlTest.CRYSTALLINE_ANGELIC.get());
        this.getOrCreateBuilder(BMTags.Items.GEMS_OBSIDIAN_INFUSED_MID_TERM).add(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM.get());
        this.getOrCreateBuilder(BMTags.Items.GEMS_JANTICAL).add(AxolotlTest.JANTICAL.get());
        this.getOrCreateBuilder(BMTags.Items.GEMS_PERSONA).add(AxolotlTest.PERSONA_SHARD.get());
        this.getOrCreateBuilder(BMTags.Items.GEMS_EMERIOND).add(AxolotlTest.EMERIOND.get());

        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_ANGELIC);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_DEVIL);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_CHRISTIAN_MID_TERM);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_WARMTERM);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_MID_TERM);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_COLDTERM);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_DEVIL_ANGELIC);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_CHRISTIAN_MID_TERM_ANGELIC);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_CHRISTIAN_MID_TERM_DEVIL);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_MILKLLARY);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_OBSIDIAN_INFUSED_MID_TERM);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_MID_HILLARY);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_MOONERING);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_ALJAMEED);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_ALJANSTEEL);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_ALJAMIC_COPPER);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_ALJAMIC_TIN);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_COPPER);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_TIN);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_HARDENED_AMARACAMEL);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_OBSIDIAN);

        // Rods
        this.getOrCreateBuilder(Tags.Items.RODS).addTag(BMTags.Items.RODS_GOLD).addTag(BMTags.Items.RODS_DEVIL).addTag(BMTags.Items.RODS_ANGELIC).addTag(BMTags.Items.RODS_MID_TERM).addTag(BMTags.Items.RODS_HILLARY)
                .addTag(BMTags.Items.RODS_ALJAMEED).addTag(BMTags.Items.RODS_CRYSTALLINE_BIRCH).addTag(BMTags.Items.RODS_GOLDENWOOD).addTag(BMTags.Items.RODS_GUAVA).addTag(BMTags.Items.RODS_JABUTICABA).addTag(BMTags.Items.RODS_CORK_OAK)
                .addTag(BMTags.Items.RODS_ALJANWOOD).addTag(BMTags.Items.RODS_ALJANCAP).addTag(BMTags.Items.RODS_INSOMNIAN).addTag(BMTags.Items.RODS_AVONDALIC_WILLOW);

        // Gems
        this.getOrCreateBuilder(Tags.Items.GEMS).addTag(BMTags.Items.GEMS_CRYSTALLINE_ANGELIC).addTag(BMTags.Items.GEMS_OBSIDIAN_INFUSED_MID_TERM).addTag(BMTags.Items.GEMS_JANTICAL)
                .addTag(BMTags.Items.GEMS_PERSONA).addTag(BMTags.Items.GEMS_EMERIOND).addTag(BMTags.Items.GEMS_MID_TERM).addTag(BMTags.Items.GEMS_MILKLLARITY);

        // Glass and Glass Panes
        this.getOrCreateBuilder(Tags.Items.GLASS_COLORLESS).add(AxolotlTest.ALJAMIC_GLASS.get());
        this.getOrCreateBuilder(Tags.Items.GLASS_PANES_COLORLESS).add(AxolotlTest.ALJAMIC_GLASS_PANE.get());
        this.getOrCreateBuilder(Tags.Items.GLASS).addTag(BMTags.Items.GLASS_DEVIL).addTag(BMTags.Items.GLASS_ALJAN_LIGHT_BLUE).addTag(BMTags.Items.GLASS_POISON_BROWN).addTag(BMTags.Items.GLASS_INSOMNIAN);
        this.getOrCreateBuilder(Tags.Items.GLASS_PANES).addTag(BMTags.Items.GLASS_PANES_DEVIL).addTag(BMTags.Items.GLASS_PANES_ALJAN_LIGHT_BLUE).addTag(BMTags.Items.GLASS_PANES_POISON_BROWN)
                .addTag(BMTags.Items.GLASS_PANES_INSOMNIAN);
        this.getOrCreateBuilder(BMTags.Items.GLASS_DEVIL).add(AxolotlTest.DEVIL_STAINED_GLASS.get());
        this.getOrCreateBuilder(BMTags.Items.GLASS_ALJAN_LIGHT_BLUE).add(AxolotlTest.ALJAN_LIGHT_BLUE_STAINED_GLASS.get());
        this.getOrCreateBuilder(BMTags.Items.GLASS_POISON_BROWN).add(AxolotlTest.POISON_BROWN_STAINED_GLASS.get());
        this.getOrCreateBuilder(BMTags.Items.GLASS_INSOMNIAN).add(AxolotlTest.INSOMNIAN_STAINED_GLASS.get());
        this.getOrCreateBuilder(BMTags.Items.GLASS_PANES_DEVIL).add(AxolotlTest.DEVIL_STAINED_GLASS_PANE.get());
        this.getOrCreateBuilder(BMTags.Items.GLASS_PANES_ALJAN_LIGHT_BLUE).add(AxolotlTest.ALJAN_LIGHT_BLUE_STAINED_GLASS_PANE.get());
        this.getOrCreateBuilder(BMTags.Items.GLASS_PANES_POISON_BROWN).add(AxolotlTest.POISON_BROWN_STAINED_GLASS_PANE.get());
        this.getOrCreateBuilder(BMTags.Items.GLASS_PANES_INSOMNIAN).add(AxolotlTest.INSOMNIAN_STAINED_GLASS_PANE.get());
        this.getOrCreateBuilder(Tags.Items.STAINED_GLASS).add(AxolotlTest.DEVIL_STAINED_GLASS.get()).add(AxolotlTest.ALJAN_LIGHT_BLUE_STAINED_GLASS.get()).add(AxolotlTest.POISON_BROWN_STAINED_GLASS.get()).add(AxolotlTest.INSOMNIAN_STAINED_GLASS.get());
        this.getOrCreateBuilder(Tags.Items.STAINED_GLASS_PANES).add(AxolotlTest.DEVIL_STAINED_GLASS_PANE.get()).add(AxolotlTest.ALJAN_LIGHT_BLUE_STAINED_GLASS_PANE.get()).add(AxolotlTest.POISON_BROWN_STAINED_GLASS_PANE.get())
                .add(AxolotlTest.INSOMNIAN_STAINED_GLASS_PANE.get());

        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_ANGELIC);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_DEVIL);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_CHRISTIAN_MID_TERM);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_MID_TERM);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_HILLARY);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_MILKLLARY);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_MID_HILLARY);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_CHRISTIAN_MID_TERM_ANGELIC);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_CHRISTIAN_MID_TERM_DEVIL);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_DEVIL_ANGELIC);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_OBSIDIAN_INFUSED_MID_TERM);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_ALJAMEED);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_ALJANSTEEL);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_MOONERING);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_WATER);

        // Dyes
        this.getOrCreateBuilder(BMTags.Items.DYES_DEVIL).add(AxolotlTest.DEVIL_DYE.get());
        this.getOrCreateBuilder(BMTags.Items.DYES_ALJAN_LIGHT_BLUE).add(AxolotlTest.ALJAN_LIGHT_BLUE_DYE.get());
        this.getOrCreateBuilder(BMTags.Items.DYES_POISON_BROWN).add(AxolotlTest.POISON_BROWN_DYE.get());
        this.getOrCreateBuilder(BMTags.Items.DYES_INSOMNIAN).add(AxolotlTest.INSOMNIAN_DYE.get());
        this.getOrCreateBuilder(Tags.Items.DYES).addTag(BMTags.Items.DYES_DEVIL).addTag(BMTags.Items.DYES_ALJAN_LIGHT_BLUE).addTag(BMTags.Items.DYES_POISON_BROWN)
                .addTag(BMTags.Items.DYES_INSOMNIAN);

        // Miscellaneous Tags
        this.getOrCreateBuilder(Tags.Items.BONES).add(AxolotlTest.ALJAMEED_BONE.get()).add(AxolotlTest.SLEEPISH_BONE.get());
        this.getOrCreateBuilder(BMTags.Items.ARMORS_BOOTS).add(Items.LEATHER_BOOTS).add(Items.CHAINMAIL_BOOTS).add(Items.IRON_BOOTS).add(Items.GOLDEN_BOOTS).add(Items.DIAMOND_BOOTS)
                .add(Items.NETHERITE_BOOTS).add(AxolotlTest.DEVIL_BOOTS.get()).add(AxolotlTest.ANGELIC_BOOTS.get()).add(AxolotlTest.MID_TERM_BOOTS.get()).add(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_BOOTS.get())
                .add(AxolotlTest.BAKUGOU_SHOES.get()).add(AxolotlTest.HARDENED_AMARACAMEL_BOOTS.get()).add(AxolotlTest.MILKLLARY_BOOTS.get()).add(AxolotlTest.ALJAMEED_BOOTS.get())
                .add(AxolotlTest.MOONERING_BOOTS.get()).add(AxolotlTest.JANTIQUIFIED_MOONERING_BOOTS.get());
        this.getOrCreateBuilder(Tags.Items.HEADS).add(AxolotlTest.ANGRY_SOPHIE_HEAD.get()).add(AxolotlTest.INSOMNIA_SOPHIE_HEAD.get()).add(AxolotlTest.QUEEN_LUCY_HEAD.get()).add(AxolotlTest.ZOMBIE_FABRICIO_HEAD.get());
        this.getOrCreateBuilder(BMTags.Items.KNIVES).add(AxolotlTest.WOODEN_KNIFE.get()).add(AxolotlTest.STONE_KNIFE.get()).add(AxolotlTest.IRON_KNIFE.get()).add(AxolotlTest.DIAMOND_KNIFE.get())
                .add(AxolotlTest.GOLDEN_KNIFE.get()).add(AxolotlTest.NETHERITE_KNIFE.get()).add(AxolotlTest.DEVIL_KNIFE.get()).add(AxolotlTest.ANGELIC_KNIFE.get()).add(AxolotlTest.MID_TERM_KNIFE.get())
                .add(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_KNIFE.get()).add(AxolotlTest.MILKLLARY_KNIFE.get()).add(AxolotlTest.OLIVE_KNIFE.get()).add(AxolotlTest.CORK_OAK_KNIFE.get())
                .add(AxolotlTest.ALJANWOOD_KNIFE.get()).add(AxolotlTest.ALJANCAP_KNIFE.get()).add(AxolotlTest.INSOMNIAN_KNIFE.get()).add(AxolotlTest.AVONDALIC_WILLOW_KNIFE.get()).add(AxolotlTest.ALJANSTONE_KNIFE.get())
                .add(AxolotlTest.SLEEPINGSTONE_KNIFE.get()).add(AxolotlTest.ALJAMEED_KNIFE.get()).add(AxolotlTest.ALJANSTEEL_KNIFE.get()).add(AxolotlTest.MOONERING_KNIFE.get()).add(AxolotlTest.JANTIQUIFIED_MOONERING_KNIFE.get())
                .add(AxolotlTest.GUAVA_KNIFE.get()).add(AxolotlTest.JABUTICABA_KNIFE.get()).add(AxolotlTest.CRYSTALLINE_BIRCH_KNIFE.get()).add(AxolotlTest.GOLDENWOOD_KNIFE.get());
        this.getOrCreateBuilder(BMTags.Items.MILK).add(AxolotlTest.MILK_POT.get());
        this.getOrCreateBuilder(Tags.Items.SHEARS).add(AxolotlTest.DEVIL_SHEARS.get()).add(AxolotlTest.ANGELIC_SHEARS.get()).add(AxolotlTest.CHRISTIAN_MID_TERM_SHEARS.get())
                .add(AxolotlTest.MID_TERM_SHEARS.get()).add(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_SHEARS.get()).add(AxolotlTest.MILKLLARY_SHEARS.get()).add(AxolotlTest.ALJAMEED_SHEARS.get())
                .add(AxolotlTest.ALJANSTEEL_SHEARS.get()).add(AxolotlTest.MOONERING_SHEARS.get()).add(AxolotlTest.JANTIQUIFIED_MOONERING_SHEARS.get());
        this.getOrCreateBuilder(Tags.Items.SLIMEBALLS).add(AxolotlTest.STICKY_AMARACAMEL_BALL.get());
        this.getOrCreateBuilder(BMTags.Items.FRUITS).add(AxolotlTest.GUARANA.get(), AxolotlTest.MANGO.get(), AxolotlTest.GRAPES.get(), AxolotlTest.LEMON.get(), AxolotlTest.PINEAPPLE.get(), AxolotlTest.ORANGE.get(), AxolotlTest.BANANA.get(), AxolotlTest.GUAVA.get(),
                AxolotlTest.JABUTICABA.get(), AxolotlTest.GREEN_APPLE.get(), AxolotlTest.ALJAMIC_BERRY.get());
        this.getOrCreateBuilder(BMTags.Items.ARCHER_LUCIA_PICKUPABLES).addTag(BMTags.Items.CROSSBOWS);
        this.getOrCreateBuilder(BMTags.Items.QUEEN_LUCY_PET_TAME_ITEMS).addTag(BMTags.Items.FRUITS);
        this.getOrCreateBuilder(BMTags.Items.QUEEN_LUCY_PET_DEADLY_ITEMS).add(AxolotlTest.ALJAME.get());
        this.getOrCreateBuilder(BMTags.Items.TABU_SMELTABLES).add(AxolotlTest.TABU.get()).add(AxolotlTest.CUBIC_TABU.get()).add(AxolotlTest.TABU_MOSAIC.get()).add(AxolotlTest.TABU_PILLAR.get());
        this.getOrCreateBuilder(BMTags.Items.MID_TERM_MATERIALS).addTag(BMTags.Items.SINGULARITIES_MID_TERM).addTag(BMTags.Items.INGOTS_MID_TERM);
        this.getOrCreateBuilder(BMTags.Items.OIMT_MATERIALS).addTag(BMTags.Items.SINGULARITIES_OBSIDIAN_INFUSED_MID_TERM).addTag(BMTags.Items.INGOTS_OBSIDIAN_INFUSED_MID_TERM);
        this.getOrCreateBuilder(BMTags.Items.CANNOT_USE_AT_CRYSTALLIZER).addTag(BMTags.Items.MOLDS).add(AxolotlTest.REGULAR_MOLDS_BOOK.get()).add(AxolotlTest.ADVANCED_MOLDS_BOOK.get()).add(Items.AIR);
        this.getOrCreateBuilder(BMTags.Items.FENCE_GATES_DEVIL).add(AxolotlTest.DEVIL_FENCE_GATE.get());
        this.getOrCreateBuilder(Tags.Items.FENCE_GATES).addTag(BMTags.Items.FENCE_GATES_DEVIL);

        this.getOrCreateBuilder(BMTags.Items.WANDERER_SOPHIE_TEMPT_ITEMS).add(AxolotlTest.MILKLLARY_CAKE.get());
        this.getOrCreateBuilder(BMTags.Items.QUEEN_LUCY_PET_TEMPT_ITEMS).add(AxolotlTest.GUARANA.get(), Items.CAKE);
        this.getOrCreateBuilder(BMTags.Items.ARCHER_LUCIA_TEMPT_ITEMS).add(Items.APPLE);
        this.getOrCreateBuilder(BMTags.Items.SHY_FABRICIO_TEMPT_ITEMS).add(AxolotlTest.HONEYED_BREAD.get());
        this.getOrCreateBuilder(BMTags.Items.MOB_TEMPT_ITEMS).addTag(BMTags.Items.WANDERER_SOPHIE_TEMPT_ITEMS).addTag(BMTags.Items.QUEEN_LUCY_PET_TEMPT_ITEMS).addTag(BMTags.Items.ARCHER_LUCIA_TEMPT_ITEMS)
                .addTag(BMTags.Items.SHY_FABRICIO_TEMPT_ITEMS);

        this.getOrCreateBuilder(Tags.Items.NUGGETS).addTag(BMTags.Items.NUGGETS_DEVIL).addTag(BMTags.Items.NUGGETS_ANGELIC).addTag(BMTags.Items.NUGGETS_CHRISTIAN_MID_TERM)
                .addTag(BMTags.Items.NUGGETS_MID_TERM).addTag(BMTags.Items.NUGGETS_OBSIDIAN_INFUSED_MID_TERM).addTag(BMTags.Items.NUGGETS_ALJAMEED).addTag(BMTags.Items.NUGGETS_MOONERING)
                .addTag(BMTags.Items.NUGGETS_HARDENED_AMARACAMEL).addTag(BMTags.Items.NUGGETS_MILKLLARY).addTag(BMTags.Items.NUGGETS_MID_HILLARY).addTag(BMTags.Items.NUGGETS_MILKLLARITY)
                .addTag(BMTags.Items.NUGGETS_CRYSTALLINE_ANGELIC).addTag(BMTags.Items.NUGGETS_JANTICAL).addTag(BMTags.Items.NUGGETS_ALJANSTEEL);

        // Melony Tags
        this.getOrCreateBuilder(BMTags.Items.SHIELDS).add(Items.SHIELD).add(AxolotlTest.DEVIL_SHIELD.get()).add(AxolotlTest.ANGELIC_SHIELD.get()).add(AxolotlTest.MID_TERM_SHIELD.get()).add(AxolotlTest.ALJAMEED_SHIELD.get())
                .add(AxolotlTest.MOONERING_SHIELD.get());
        this.getOrCreateBuilder(BMTags.Items.BOWS).add(AxolotlTest.DEVIL_BOW.get()).add(AxolotlTest.ANGELIC_BOW.get()).add(AxolotlTest.MID_TERM_BOW.get());
        this.getOrCreateBuilder(BMTags.Items.CROSSBOWS).add(Items.CROSSBOW).add(AxolotlTest.DEVIL_CROSSBOW.get()).add(AxolotlTest.ANGELIC_CROSSBOW.get());
        this.getOrCreateBuilder(BMTags.Items.PROVIDES_WATER_BREATHING).add(Items.TURTLE_HELMET).add(AxolotlTest.CANDY_PINK_TURTLE_HELMET.get()).add(AxolotlTest.CANDY_YELLOW_TURTLE_HELMET.get());
        this.getOrCreateBuilder(BMTags.Items.PROVIDES_RESISTANCE);
        this.getOrCreateBuilder(BMTags.Items.PROVIDES_EFFECT).addTag(BMTags.Items.PROVIDES_WATER_BREATHING).addTag(BMTags.Items.PROVIDES_RESISTANCE);

        // Back Math Tags

        // Logs & Woods
        this.getOrCreateBuilder(BMTags.Items.CRYSTALLINE_BIRCH_LOGS).add(AxolotlTest.CRYSTALLINE_BIRCH_LOG.get()).add(AxolotlTest.CRYSTALLINE_BIRCH_WOOD.get()).add(AxolotlTest.STRIPPED_CRYSTALLINE_BIRCH_LOG.get()).add(AxolotlTest.STRIPPED_CRYSTALLINE_BIRCH_WOOD.get());
        this.getOrCreateBuilder(BMTags.Items.CORK_OAK_LOGS).add(AxolotlTest.CORK_OAK_LOG.get()).add(AxolotlTest.CORK_OAK_WOOD.get()).add(AxolotlTest.STRIPPED_CORK_OAK_LOG.get()).add(AxolotlTest.STRIPPED_CORK_OAK_WOOD.get());
        this.getOrCreateBuilder(BMTags.Items.GOLDENWOOD_LOGS).add(AxolotlTest.GOLDENWOOD_LOG.get()).add(AxolotlTest.GOLDENWOOD_WOOD.get()).add(AxolotlTest.STRIPPED_GOLDENWOOD_LOG.get()).add(AxolotlTest.STRIPPED_GOLDENWOOD_WOOD.get());
        this.getOrCreateBuilder(BMTags.Items.GUAVA_LOGS).add(AxolotlTest.GUAVA_LOG.get()).add(AxolotlTest.GUAVA_WOOD.get()).add(AxolotlTest.STRIPPED_GUAVA_LOG.get()).add(AxolotlTest.STRIPPED_GUAVA_WOOD.get());
        this.getOrCreateBuilder(BMTags.Items.JABUTICABA_LOGS).add(AxolotlTest.JABUTICABA_LOG.get()).add(AxolotlTest.JABUTICABA_WOOD.get()).add(AxolotlTest.STRIPPED_JABUTICABA_LOG.get()).add(AxolotlTest.STRIPPED_JABUTICABA_WOOD.get());
        this.getOrCreateBuilder(BMTags.Items.ALJANWOOD_LOGS).add(AxolotlTest.ALJANWOOD_LOG.get()).add(AxolotlTest.ALJANWOOD_WOOD.get()).add(AxolotlTest.STRIPPED_ALJANWOOD_LOG.get()).add(AxolotlTest.STRIPPED_ALJANWOOD_WOOD.get());
        this.getOrCreateBuilder(BMTags.Items.ALJANCAP_LOGS).add(AxolotlTest.ALJANCAP_LOG.get()).add(AxolotlTest.ALJANCAP_WOOD.get()).add(AxolotlTest.STRIPPED_ALJANCAP_LOG.get()).add(AxolotlTest.STRIPPED_ALJANCAP_WOOD.get());
        this.getOrCreateBuilder(BMTags.Items.INSOMNIAN_LOGS).add(AxolotlTest.INSOMNIAN_LOG.get()).add(AxolotlTest.INSOMNIAN_WOOD.get()).add(AxolotlTest.STRIPPED_INSOMNIAN_LOG.get()).add(AxolotlTest.STRIPPED_INSOMNIAN_WOOD.get());
        this.getOrCreateBuilder(BMTags.Items.AVONDALIC_WILLOW_LOGS).add(AxolotlTest.AVONDALIC_WILLOW_LOG.get()).add(AxolotlTest.AVONDALIC_WILLOW_WOOD.get()).add(AxolotlTest.STRIPPED_AVONDALIC_WILLOW_LOG.get()).add(AxolotlTest.STRIPPED_AVONDALIC_WILLOW_WOOD.get());

        this.getOrCreateBuilder(BMTags.Items.STRIPPED_WOODS).add(Items.STRIPPED_OAK_WOOD).add(Items.STRIPPED_SPRUCE_WOOD).add(Items.STRIPPED_BIRCH_WOOD).add(Items.STRIPPED_JUNGLE_WOOD)
                .add(Items.STRIPPED_ACACIA_WOOD).add(Items.STRIPPED_DARK_OAK_WOOD).add(Items.STRIPPED_CRIMSON_HYPHAE).add(Items.STRIPPED_WARPED_HYPHAE).add(AxolotlTest.STRIPPED_CRYSTALLINE_BIRCH_WOOD.get())
                .add(AxolotlTest.STRIPPED_CORK_OAK_WOOD.get()).add(AxolotlTest.STRIPPED_GOLDENWOOD_WOOD.get()).add(AxolotlTest.STRIPPED_GUAVA_WOOD.get()).add(AxolotlTest.STRIPPED_JABUTICABA_WOOD.get())
                .add(AxolotlTest.STRIPPED_ALJANWOOD_WOOD.get()).add(AxolotlTest.STRIPPED_ALJANCAP_WOOD.get()).add(AxolotlTest.STRIPPED_INSOMNIAN_WOOD.get()).add(AxolotlTest.STRIPPED_AVONDALIC_WILLOW_WOOD.get());

        this.getOrCreateBuilder(BMTags.Items.GRAPE_VINE_POSTS).add(AxolotlTest.OAK_GRAPE_VINE_POST.get()).add(AxolotlTest.SPRUCE_GRAPE_VINE_POST.get()).add(AxolotlTest.BIRCH_GRAPE_VINE_POST.get())
                .add(AxolotlTest.JUNGLE_GRAPE_VINE_POST.get()).add(AxolotlTest.ACACIA_GRAPE_VINE_POST.get()).add(AxolotlTest.DARK_OAK_GRAPE_VINE_POST.get()).add(AxolotlTest.CRIMSON_GRAPE_VINE_POST.get())
                .add(AxolotlTest.WARPED_GRAPE_VINE_POST.get()).add(AxolotlTest.CRYSTALLINE_BIRCH_GRAPE_VINE_POST.get()).add(AxolotlTest.CORK_OAK_GRAPE_VINE_POST.get()).add(AxolotlTest.GOLDENWOOD_GRAPE_VINE_POST.get())
                .add(AxolotlTest.GUAVA_GRAPE_VINE_POST.get()).add(AxolotlTest.JABUTICABA_GRAPE_VINE_POST.get()).add(AxolotlTest.ALJANWOOD_GRAPE_VINE_POST.get()).add(AxolotlTest.ALJANCAP_GRAPE_VINE_POST.get())
                .add(AxolotlTest.INSOMNIAN_GRAPE_VINE_POST.get()).add(AxolotlTest.AVONDALIC_WILLOW_GRAPE_VINE_POST.get());

        this.getOrCreateBuilder(BMTags.Items.TOYS).add(AxolotlTest.INNOVATOR_TOY.get()).add(AxolotlTest.ALICE_TOY.get()).add(AxolotlTest.ALAN_TOY.get()).add(AxolotlTest.TEENAGER_ALICE_TOY.get())
                .add(AxolotlTest.LEANDRO_TOY.get()).add(AxolotlTest.TYLER_TOY.get()).add(AxolotlTest.MALENA_TOY.get());

        this.getOrCreateBuilder(BMTags.Items.ALPHA_IDEA).add(AxolotlTest.GOLDEN_PLATED.get()).add(AxolotlTest.GOLDEN_PATTY.get()).add(AxolotlTest.BUTTER_SWORD.get())
                .add(AxolotlTest.SPATH_SIRIUS_BLACK.get()).add(AxolotlTest.BLACK_SULIOS.get()).add(AxolotlTest.RAINBOW_PENCIL.get()).add(AxolotlTest.WATER_TALC_POWDER.get())
                .add(AxolotlTest.CAT_TIARA.get()).add(AxolotlTest.HILLARY_BUCKET.get()).add(AxolotlTest.LAGUSTA.get()).add(AxolotlTest.PATTY.get()).add(AxolotlTest.CHEESE_BREAD.get())
                .add(AxolotlTest.CHEESE_BREAD_BAG.get()).add(AxolotlTest.OLIVE_PICKAXE.get()).addTag(BMTags.Items.SINGULARITIES_MID_TERM);
        this.getOrCreateBuilder(BMTags.Items.SOPHIES_TAKE_OVER_IDEA).add(AxolotlTest.ALJAME.get()).add(AxolotlTest.HUMAN_PATRICK.get()).add(AxolotlTest.MECH_MECH.get()).add(AxolotlTest.CAREWNI.get())
                .add(AxolotlTest.AMARACAMEL_BATTER.get()).add(AxolotlTest.AMARACAMEL_BATTER_BAG.get()).add(AxolotlTest.EMPTY_AMARACAMEL_BATTER_BAG.get()).add(AxolotlTest.ENERGETIC_MONSTER.get());
        this.getOrCreateBuilder(BMTags.Items.ALJAMIC_WARS_IDEA).add(AxolotlTest.PINE_JELLY.get()).add(AxolotlTest.PATIENCE_TEA.get()).add(AxolotlTest.PEACE_TEA.get()).add(AxolotlTest.DISGUST_TEA.get())
                .add(AxolotlTest.MOOD_TEA.get());
        this.getOrCreateBuilder(BMTags.Items.BOUNTIFULLY_EXPANSIVE_IDEA).add(AxolotlTest.AMARACAMEL_JUICE.get()).add(AxolotlTest.CHOCOGLUE.get()).add(AxolotlTest.GLUE.get())
                .add(AxolotlTest.PINK_GUM_FRYING_PAN.get()).add(AxolotlTest.BREAD_WITH_PAO.get()).add(AxolotlTest.CHOCOLATE_NAKED_CAKE.get()).add(AxolotlTest.QUEEN_LUCY_SHIRT_CURRENT.get())
                .add(AxolotlTest.QUEEN_LUCY_SHIRT_ALT.get()).add(AxolotlTest.QUEEN_LUCY_RELIC.get()).add(AxolotlTest.ALJAMIC_BERRY.get()).add(AxolotlTest.ALJAMIC_BERRY_JAM.get()).add(AxolotlTest.ALJAMIC_BERRY_JUICE.get())
                .add(AxolotlTest.ALJAMIC_ALJAMIC_BERRY_JUICE.get()).add(AxolotlTest.ALJAMIC_BERRY_POPSICLE.get()).add(AxolotlTest.ALJAMIC_BERRY_JAM_BREAD.get());

        this.getOrCreateBuilder(BMTags.Items.SOPHIE_IDEA).addTag(BMTags.Items.ALPHA_IDEA);
        this.getOrCreateBuilder(BMTags.Items.SOPHIE_IDEA).addTag(BMTags.Items.SOPHIES_TAKE_OVER_IDEA);
        this.getOrCreateBuilder(BMTags.Items.SOPHIE_IDEA).addTag(BMTags.Items.ALJAMIC_WARS_IDEA);
        this.getOrCreateBuilder(BMTags.Items.SOPHIE_IDEA).addTag(BMTags.Items.BOUNTIFULLY_EXPANSIVE_IDEA);

        this.getOrCreateBuilder(BMTags.Items.ALJANSTONE_CRAFTING_MATERIALS).add(AxolotlTest.ALJANSTONE.get()).add(AxolotlTest.COBBLED_ALJANSTONE.get());
        this.getOrCreateBuilder(BMTags.Items.ALJAN_RECIPE_STICKS).addTag(BMTags.Items.RODS_ALJANWOOD).addTag(BMTags.Items.RODS_ALJANCAP).addTag(BMTags.Items.RODS_INSOMNIAN).addTag(
                BMTags.Items.RODS_AVONDALIC_WILLOW);
        this.getOrCreateBuilder(BMTags.Items.BACK_GUIDE_RECIPE_ACCEPTABLES).addTag(BMTags.Items.FRUITS).add(AxolotlTest.ALJAME.get(), AxolotlTest.ALJAMIC_ONION.get(), AxolotlTest.CARAMELED_WHEAT.get());
        this.getOrCreateBuilder(BMTags.Items.MATERIALS_HARDENED_AMARACAMEL).addTag(BMTags.Items.INGOTS_HARDENED_AMARACAMEL).add(AxolotlTest.HARDENED_AMARACAMEL_BATTER.get());
        this.getOrCreateBuilder(BMTags.Items.MATERIALS).addTag(BMTags.Items.MATERIALS_HARDENED_AMARACAMEL);
        this.getOrCreateBuilder(BMTags.Items.CROWNS).add(AxolotlTest.GOLDEN_CROWN.get()).add(AxolotlTest.DEVIL_CROWN.get()).add(AxolotlTest.ANGELIC_CROWN.get())
                .add(AxolotlTest.CHRISTIAN_MID_TERM_CROWN.get()).add(AxolotlTest.MID_TERM_CROWN.get()).add(AxolotlTest.MILKLLARY_CROWN.get()).add(AxolotlTest.CRYSTALLINE_ANGELIC_CROWN.get());
        this.getOrCreateBuilder(BMTags.Items.FOOD_BAGS).add(AxolotlTest.FOOD_BAG.get()).add(AxolotlTest.FOOD_BAG_ALT.get());
        this.getOrCreateBuilder(BMTags.Items.ENERGETICS).add(AxolotlTest.ENERGETIC_MONSTER.get()).add(AxolotlTest.MONSTER_ENERGY_DRINK.get());
        this.getOrCreateBuilder(BMTags.Items.MORTAR_AND_PESTLES).add(AxolotlTest.MORTAR_AND_PESTLE.get()).add(AxolotlTest.CRYSTALLINE_BIRCH_MORTAR_AND_PESTLE.get())
                .add(AxolotlTest.GOLDENWOOD_MORTAR_AND_PESTLE.get()).add(AxolotlTest.GUAVA_MORTAR_AND_PESTLE.get()).add(AxolotlTest.JABUTICABA_MORTAR_AND_PESTLE.get()).add(AxolotlTest.CORK_OAK_MORTAR_AND_PESTLE.get())
                .add(AxolotlTest.ALJANWOOD_MORTAR_AND_PESTLE.get()).add(AxolotlTest.ALJANCAP_MORTAR_AND_PESTLE.get()).add(AxolotlTest.INSOMNIAN_MORTAR_AND_PESTLE.get())
                .add(AxolotlTest.AVONDALIC_WILLOW_MORTAR_AND_PESTLE.get());
        this.getOrCreateBuilder(BMTags.Items.DISCS).add(AxolotlTest.WELLERMAN_DISC.get()).add(AxolotlTest.SNOWMAN_DISC.get()).add(AxolotlTest.DADADADA_DA_DISC.get()).add(AxolotlTest.ARCADE_DISC.get())
                .add(AxolotlTest.SUGAR_CRASH_DISC.get()).add(AxolotlTest.O_ZONIBUS_VAI_DERRAPAR_DISC.get()).add(AxolotlTest.IEVAN_POLKKA_DISC.get()).add(AxolotlTest.NEVER_GONNA_GIVE_YOU_UP_DISC.get())
                .add(AxolotlTest.BEGGIN_DISC.get()).add(AxolotlTest.STAY_DISC.get()).add(AxolotlTest.THE_FLYING_ARM_DISC.get()).add(AxolotlTest.SOPHIES_DRAMATIC_ENTRANCE_1_DISC.get())
                .add(AxolotlTest.SOPHIES_DRAMATIC_ENTRANCE_2_DISC.get()).add(AxolotlTest.SOPHIES_DRAMATIC_ENTRANCE_3_DISC.get());
        this.getOrCreateBuilder(BMTags.Items.BOTTLES).addTag(BMTags.Items.JUICES).add(AxolotlTest.CHOCCY_MILK_BOTTLE.get()).add(AxolotlTest.HILLARY_BOTTLE.get()).add(AxolotlTest.MILKLLARY_BOTTLE.get())
                .add(AxolotlTest.SOPHIE_FRAGRANCE.get()).add(AxolotlTest.GEL_ALCOHOL.get());
        this.getOrCreateBuilder(BMTags.Items.BUCKETS).add(AxolotlTest.HILLARY_BUCKET.get()).add(AxolotlTest.MILKLLARY_BUCKET.get()).add(AxolotlTest.LIQUEFIED_MONSTER_BUCKET.get())
                .add(AxolotlTest.LIQUID_ALJAME_BUCKET.get()).add(AxolotlTest.LIQUID_MANGA_BUCKET.get()).add(AxolotlTest.SLEEPISHWATER_BUCKET.get()).add(AxolotlTest.MOLTEN_MID_TERM_BUCKET.get())
                .add(AxolotlTest.CHOCCY_MILK_BUCKET.get()).add(AxolotlTest.COFFEE_MUG.get());
        this.getOrCreateBuilder(BMTags.Items.JUICES).add(AxolotlTest.GUARANA_JUICE.get()).add(AxolotlTest.MANGO_JUICE.get()).add(AxolotlTest.MANGA_JUICE.get()).add(AxolotlTest.GRAPE_JUICE.get())
                .add(AxolotlTest.LEMON_JUICE.get()).add(AxolotlTest.PINEAPPLE_JUICE.get()).add(AxolotlTest.ORANGE_JUICE.get()).add(AxolotlTest.BANANA_JUICE.get()).add(AxolotlTest.GUAVA_JUICE.get())
                .add(AxolotlTest.JABUTICABADA.get()).add(AxolotlTest.GREEN_APPLE_JUICE.get()).add(AxolotlTest.ALJAME_JUICE.get()).add(AxolotlTest.ALJAMIC_BERRY_JUICE.get()).add(AxolotlTest.APPLE_JUICE.get())
                .add(AxolotlTest.GOLDEN_APPLE_JUICE.get()).add(AxolotlTest.ENCHANTED_GOLDEN_APPLE_JUICE.get()).add(AxolotlTest.MELON_JUICE.get()).add(AxolotlTest.PUMPKIN_JUICE.get())
                .add(AxolotlTest.SWEET_BERRY_JUICE.get()).add(AxolotlTest.GLOW_BERRY_JUICE.get());
        this.getOrCreateBuilder(BMTags.Items.JAMS).add(AxolotlTest.OREGANO_POT.get()).add(AxolotlTest.GUARANA_JAM.get()).add(AxolotlTest.MANGO_JAM.get()).add(AxolotlTest.MANGA_JAM.get()).add(AxolotlTest.GRAPE_JAM.get())
                .add(AxolotlTest.LEMON_JAM.get()).add(AxolotlTest.PINEAPPLE_JAM.get()).add(AxolotlTest.ORANGE_JAM.get()).add(AxolotlTest.BANANA_JAM.get()).add(AxolotlTest.GUAVA_JAM.get())
                .add(AxolotlTest.JABUTICABADA.get()).add(AxolotlTest.GREEN_APPLE_JAM.get()).add(AxolotlTest.ALJAME_JAM.get()).add(AxolotlTest.ALJAMIC_BERRY_JAM.get()).add(AxolotlTest.APPLE_JAM.get())
                .add(AxolotlTest.GOLDEN_APPLE_JAM.get()).add(AxolotlTest.ENCHANTED_GOLDEN_APPLE_JAM.get()).add(AxolotlTest.MELON_JAM.get()).add(AxolotlTest.PUMPKIN_JAM.get())
                .add(AxolotlTest.SWEET_BERRY_JAM.get()).add(AxolotlTest.GLOW_BERRY_JAM.get()).add(AxolotlTest.MUSHROOM_STEW_POT.get()).add(AxolotlTest.FUNGI_STEW_POT.get()).add(
                        AxolotlTest.END_FUNGI_STEW_POT.get()).add(AxolotlTest.ALJAN_FUNGI_STEW_POT.get()).add(AxolotlTest.BEETROOT_SOUP_POT.get()).add(AxolotlTest.RABBIT_STEW_POT.get())
                .add(AxolotlTest.HILLARY_JAM.get()).add(AxolotlTest.MILKLLARY_JAM.get()).add(AxolotlTest.WATER_JAM.get()).add(AxolotlTest.LAVA_POT.get()).add(AxolotlTest.MILK_POT.get())
                .add(AxolotlTest.POWDER_SNOW_POT.get()).add(AxolotlTest.COOKIE_POT.get()).add(AxolotlTest.EFFECT_JAM.get()); //.add(AxolotlTest.JAM_POT.get()); // Don't know if this counts for this tag.
        this.getOrCreateBuilder(BMTags.Items.CUT_FRUITS).add(AxolotlTest.CUT_GUARANA.get()).add(AxolotlTest.CUT_MANGO.get()).add(AxolotlTest.CUT_GRAPES.get())
                .add(AxolotlTest.CUT_LEMON.get()).add(AxolotlTest.CUT_PINEAPPLE.get()).add(AxolotlTest.CUT_ORANGE.get()).add(AxolotlTest.CUT_BANANA.get()).add(AxolotlTest.CUT_GUAVA.get())
                .add(AxolotlTest.CUT_JABUTICABA.get()).add(AxolotlTest.CUT_GREEN_APPLE.get()).add(AxolotlTest.CUT_ALJAME.get()).add(AxolotlTest.CUT_JANTIQUIFIED_ALJAME.get())
                .add(AxolotlTest.CUT_HOLY_JANTIQUIFIED_ALJAME.get()).add(AxolotlTest.CUT_ALJAMIC_BERRY.get()).add(AxolotlTest.CUT_APPLE.get()).add(AxolotlTest.CUT_GOLDEN_APPLE.get())
                .add(AxolotlTest.CUT_ENCHANTED_GOLDEN_APPLE.get()).add(Items.MELON_SLICE).add(AxolotlTest.PUMPKIN_SLICE.get()).add(AxolotlTest.CUT_SWEET_BERRIES.get())
                .add(AxolotlTest.CUT_GLOW_BERRIES.get());
        this.getOrCreateBuilder(BMTags.Items.ITEM_SACS).add(AxolotlTest.AMARACAMEL_BATTER_BAG.get()).add(AxolotlTest.LAGUSTA_BAG.get()).add(AxolotlTest.FRIED_EGG_BAG.get())
                .add(AxolotlTest.TURTLE_FRIED_EGG_BAG.get()).add(AxolotlTest.ENDER_DRAGON_FRIED_EGG_BAG.get()).add(AxolotlTest.ALJAME_TEA_BOX.get()).add(AxolotlTest.QUEEN_LUCY_BATTLE_PACK.get())
                .add(AxolotlTest.BOOT_PACK.get());
        this.getOrCreateBuilder(BMTags.Items.EMPTY_ITEM_SACS).add(AxolotlTest.EMPTY_AMARACAMEL_BATTER_BAG.get()).add(AxolotlTest.EMPTY_LAGUSTA_BAG.get()).add(AxolotlTest.EMPTY_FRIED_EGG_BAG.get())
                .add(AxolotlTest.EMPTY_TURTLE_FRIED_EGG_BAG.get()).add(AxolotlTest.EMPTY_ENDER_DRAGON_FRIED_EGG_BAG.get()).add(AxolotlTest.EMPTY_BOOT_PACK.get());
        this.getOrCreateBuilder(BMTags.Items.MILKED_SPAREYS).add(AxolotlTest.MILKED_DEVIL_SPAREY.get()).add(AxolotlTest.MILKED_SPAREY.get()).add(AxolotlTest.MILKED_MID_TERM_SPAREY.get())
                .add(AxolotlTest.MILKED_OBSIDIAN_INFUSED_MID_TERM_SPAREY.get());
        this.getOrCreateBuilder(BMTags.Items.MILKED_SWORDS).addTag(BMTags.Items.MILKED_SPAREYS).add(AxolotlTest.MILKED_WOODEN_SWORD.get()).add(AxolotlTest.MILKED_STONE_SWORD.get())
                .add(AxolotlTest.MILKED_IRON_SWORD.get()).add(AxolotlTest.MILKED_DIAMOND_SWORD.get()).add(AxolotlTest.MILKED_GOLDEN_SWORD.get()).add(AxolotlTest.MILKED_NETHERITE_SWORD.get())
                .add(AxolotlTest.MILKED_DEVIL_SWORD.get()).add(AxolotlTest.MILKED_ANGELIC_SWORD.get()).add(AxolotlTest.MILKED_MID_TERM_SWORD.get()).add(AxolotlTest.MILKED_OBSIDIAN_INFUSED_MID_TERM_SWORD.get())
                .add(AxolotlTest.MILKEDLLARY_SWORD.get()).add(AxolotlTest.MILKED_OLIVE_SWORD.get()).add(AxolotlTest.MILKED_PERSONA_BLADE.get()).add(AxolotlTest.MILKED_BUTTER_SWORD.get())
                .add(AxolotlTest.MILKED_GOLDEN_PATTY.get()).add(AxolotlTest.MILKED_ALJANWOOD_SWORD.get()).add(AxolotlTest.MILKED_ALJANCAP_SWORD.get()).add(AxolotlTest.MILKED_INSOMNIAN_SWORD.get())
                .add(AxolotlTest.MILKED_AVONDALIC_WILLOW_SWORD.get()).add(AxolotlTest.MILKED_ALJANSTONE_SWORD.get()).add(AxolotlTest.MILKED_SLEEPINGSTONE_SWORD.get())
                .add(AxolotlTest.MILKED_ALJAMEED_BLADE.get()).add(AxolotlTest.MILKED_ALJANSTEEL_BLADE.get()).add(AxolotlTest.MILKED_MOONERING_SWORD.get())
                .add(AxolotlTest.MILKED_JANTIQUIFIED_MOONERING_SWORD.get()).add(AxolotlTest.MILKED_CRYSTALLINE_BIRCH_SWORD.get()).add(AxolotlTest.MILKED_CORK_OAK_SWORD.get())
                .add(AxolotlTest.MILKED_GOLDENWOOD_SWORD.get()).add(AxolotlTest.MILKED_GUAVA_SWORD.get()).add(AxolotlTest.MILKED_JABUTICABA_SWORD.get());
        this.getOrCreateBuilder(BMTags.Items.ALJAN_LOGS).addTag(BMTags.Items.ALJANWOOD_LOGS).addTag(BMTags.Items.ALJANCAP_LOGS).addTag(BMTags.Items.INSOMNIAN_LOGS).addTag(BMTags.Items.AVONDALIC_WILLOW_LOGS);


        // TODO: MINECRAFT TAGS


        this.getOrCreateBuilder(ItemTags.ARROWS).add(AxolotlTest.INSOMNIA_ARROW.get());
        this.getOrCreateBuilder(ItemTags.BOATS).add(AxolotlTest.ALJANWOOD_BOAT.get()).add(AxolotlTest.ALJANCAP_BOAT.get()).add(AxolotlTest.INSOMNIAN_BOAT.get());
        this.getOrCreateBuilder(ItemTags.COALS).add(AxolotlTest.CHARJAN_COAL.get());
        this.getOrCreateBuilder(ItemTags.MUSIC_DISCS).addTag(BMTags.Items.DISCS);
        this.getOrCreateBuilder(ItemTags.PIGLIN_REPELLENTS).add(AxolotlTest.MID_TERM_SOUL_LANTERN.get());

        // Copied from the Block Tags class.
        this.getOrCreateBuilder(ItemTags.PIGLIN_LOVED).addTag(BMTags.Items.MOLDS_ROD).addTag(BMTags.Items.MOLDS_CRYSTALLIZED).addTag(BMTags.Items.MOLDS_INGOT).addTag(BMTags.Items.MOLDS_SINGULARITY).addTag(BMTags.Items.MOLDS_EMPTY)
                .addTag(BMTags.Items.MOLDS_MOLD).add(AxolotlTest.CRYSTALLINE_BIRCH_LEAVES.get()).add(AxolotlTest.CRYSTALLINE_BIRCH_SAPLING.get()).add(AxolotlTest.CRYSTALLINE_CRYSTALLIZER.get()).add(AxolotlTest.QUEEN_LUCY_RELIC.get())
                .add(AxolotlTest.QUEEN_LUCY_PET_RELIC.get()).add(AxolotlTest.MILKED_GOLDEN_SWORD.get()).add(AxolotlTest.ANGELIC_SPOON.get()).add(AxolotlTest.GOLDEN_CROWN.get()).add(AxolotlTest.GOLDEN_APPLE_JUICE.get())
                .add(AxolotlTest.GOLDEN_APPLE_POPSICLE.get()).add(AxolotlTest.GOLDEN_APPLE_JAM.get()).add(AxolotlTest.GOLDEN_APPLE_JAM_BREAD.get()).add(AxolotlTest.CUT_GOLDEN_APPLE.get()).add(AxolotlTest.ENCHANTED_GOLDEN_APPLE_JUICE.get())
                .add(AxolotlTest.ENCHANTED_GOLDEN_APPLE_POPSICLE.get()).add(AxolotlTest.ENCHANTED_GOLDEN_APPLE_JAM.get()).add(AxolotlTest.ENCHANTED_GOLDEN_APPLE_JAM_BREAD.get()).add(AxolotlTest.CUT_ENCHANTED_GOLDEN_APPLE.get());

        this.getOrCreateBuilder(ItemTags.WOOL).add(AxolotlTest.DEVIL_WOOL.get());
        this.getOrCreateBuilder(ItemTags.CARPETS).add(AxolotlTest.DEVIL_CARPET.get());
        this.getOrCreateBuilder(ItemTags.PIGLIN_REPELLENTS).add(AxolotlTest.MID_TERM_SOUL_LANTERN.get());
        this.getOrCreateBuilder(ItemTags.SAND).add(AxolotlTest.ALJAMIC_SAND.get());
        this.getOrCreateBuilder(ItemTags.SMALL_FLOWERS).add(AxolotlTest.RED_YELLOW_FLOWER.get()).add(AxolotlTest.FRIED_EGG_FLOWER.get()).add(AxolotlTest.TURTLE_FRIED_EGG_FLOWER.get()).add(AxolotlTest.ENDER_DRAGON_FRIED_EGG_FLOWER.get())
                .add(AxolotlTest.ALJAN_TULIP.get()).add(AxolotlTest.POISON_ROSE.get()).add(AxolotlTest.INSOMNIAN_TULIP.get());

        this.getOrCreateBuilder(ItemTags.STAIRS).add(AxolotlTest.DEVIL_STAIRS.get()).add(AxolotlTest.DEVIL_BRICK_STAIRS.get()).add(AxolotlTest.ANGELIC_BRICK_STAIRS.get()).add(AxolotlTest.MOSSY_ANGELIC_BRICK_STAIRS.get())
                .add(AxolotlTest.WARMTERM_BRICK_STAIRS.get()).add(AxolotlTest.COLDTERM_BRICK_STAIRS.get()).add(AxolotlTest.OBSIDITERM_BRICK_STAIRS.get()).add(AxolotlTest.HILLARIED_STONE_STAIRS.get()).add(AxolotlTest.CUBIC_TABU_STAIRS.get())
                .add(AxolotlTest.TABU_MOSAIC_STAIRS.get()).add(AxolotlTest.COBBLED_ALJANSTONE_STAIRS.get()).add(AxolotlTest.ALJANSTONE_STAIRS.get()).add(AxolotlTest.ALJANSTONE_BRICK_STAIRS.get()).add(AxolotlTest.SLEEPINGSTONE_STAIRS.get())
                .add(AxolotlTest.POLISHED_SLEEPINGSTONE_STAIRS.get()).add(AxolotlTest.SLEEPINGSTONE_BRICK_STAIRS.get());
        this.getOrCreateBuilder(ItemTags.SLABS).add(AxolotlTest.DEVIL_SLAB.get()).add(AxolotlTest.DEVIL_BRICK_SLAB.get()).add(AxolotlTest.ANGELIC_BRICK_SLAB.get()).add(AxolotlTest.MOSSY_ANGELIC_BRICK_SLAB.get())
                .add(AxolotlTest.WARMTERM_BRICK_SLAB.get()).add(AxolotlTest.COLDTERM_BRICK_SLAB.get()).add(AxolotlTest.OBSIDITERM_BRICK_SLAB.get()).add(AxolotlTest.HILLARIED_STONE_SLAB.get()).add(AxolotlTest.CUBIC_TABU_SLAB.get())
                .add(AxolotlTest.TABU_MOSAIC_SLAB.get()).add(AxolotlTest.COBBLED_ALJANSTONE_SLAB.get()).add(AxolotlTest.ALJANSTONE_SLAB.get()).add(AxolotlTest.ALJANSTONE_BRICK_SLAB.get()).add(AxolotlTest.SMOOTH_ALJANSTONE_SLAB.get())
                .add(AxolotlTest.SLEEPINGSTONE_SLAB.get()).add(AxolotlTest.POLISHED_SLEEPINGSTONE_SLAB.get()).add(AxolotlTest.SLEEPINGSTONE_BRICK_SLAB.get());
        this.getOrCreateBuilder(ItemTags.WALLS).add(AxolotlTest.DEVIL_WALL.get()).add(AxolotlTest.DEVIL_BRICK_WALL.get()).add(AxolotlTest.ANGELIC_BRICK_WALL.get()).add(AxolotlTest.MOSSY_ANGELIC_BRICK_WALL.get())
                .add(AxolotlTest.WARMTERM_BRICK_WALL.get()).add(AxolotlTest.COLDTERM_BRICK_WALL.get()).add(AxolotlTest.OBSIDITERM_BRICK_WALL.get()).add(AxolotlTest.HILLARIED_STONE_WALL.get()).add(AxolotlTest.COBBLED_ALJANSTONE_WALL.get())
                .add(AxolotlTest.ALJANSTONE_WALL.get()).add(AxolotlTest.ALJANSTONE_BRICK_WALL.get()).add(AxolotlTest.SLEEPINGSTONE_WALL.get()).add(AxolotlTest.POLISHED_SLEEPINGSTONE_WALL.get()).add(AxolotlTest.SLEEPINGSTONE_BRICK_WALL.get());
        this.getOrCreateBuilder(ItemTags.FENCES).add(AxolotlTest.DEVIL_FENCE.get());
        this.getOrCreateBuilder(ItemTags.DOORS).add(AxolotlTest.DEVIL_DOOR.get()).add(AxolotlTest.ANGELIC_DOOR.get()).add(AxolotlTest.MID_TERM_DOOR.get()).add(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_DOOR.get());
        this.getOrCreateBuilder(ItemTags.TRAPDOORS).add(AxolotlTest.DEVIL_TRAPDOOR.get()).add(AxolotlTest.ANGELIC_TRAPDOOR.get()).add(AxolotlTest.MID_TERM_TRAPDOOR.get()).add(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_TRAPDOOR.get());

        // Wood Related
        this.getOrCreateBuilder(ItemTags.LOGS_THAT_BURN).addTag(BMTags.Items.CRYSTALLINE_BIRCH_LOGS).addTag(BMTags.Items.GOLDENWOOD_LOGS).addTag(BMTags.Items.GUAVA_LOGS).addTag(BMTags.Items.JABUTICABA_LOGS)
                .addTag(BMTags.Items.CORK_OAK_LOGS).addTag(BMTags.Items.ALJANWOOD_LOGS).addTag(BMTags.Items.ALJANCAP_LOGS).addTag(BMTags.Items.INSOMNIAN_LOGS).addTag(BMTags.Items.AVONDALIC_WILLOW_LOGS);
        this.getOrCreateBuilder(ItemTags.PLANKS).add(AxolotlTest.CRYSTALLINE_BIRCH_PLANKS.get()).add(AxolotlTest.GOLDENWOOD_PLANKS.get()).add(AxolotlTest.GUAVA_PLANKS.get()).add(AxolotlTest.JABUTICABA_PLANKS.get()).add(AxolotlTest.CORK_OAK_PLANKS.get())
                .add(AxolotlTest.ALJANWOOD_PLANKS.get()).add(AxolotlTest.ALJANCAP_PLANKS.get()).add(AxolotlTest.INSOMNIAN_PLANKS.get()).add(AxolotlTest.AVONDALIC_WILLOW_PLANKS.get());
        this.getOrCreateBuilder(ItemTags.WOODEN_STAIRS).add(AxolotlTest.CRYSTALLINE_BIRCH_STAIRS.get()).add(AxolotlTest.GOLDENWOOD_STAIRS.get()).add(AxolotlTest.GUAVA_STAIRS.get()).add(AxolotlTest.JABUTICABA_STAIRS.get()).add(AxolotlTest.CORK_OAK_STAIRS.get())
                .add(AxolotlTest.ALJANWOOD_STAIRS.get()).add(AxolotlTest.ALJANCAP_STAIRS.get()).add(AxolotlTest.INSOMNIAN_STAIRS.get()).add(AxolotlTest.AVONDALIC_WILLOW_STAIRS.get());
        this.getOrCreateBuilder(ItemTags.WOODEN_SLABS).add(AxolotlTest.CRYSTALLINE_BIRCH_SLAB.get()).add(AxolotlTest.GOLDENWOOD_SLAB.get()).add(AxolotlTest.GUAVA_SLAB.get()).add(AxolotlTest.JABUTICABA_SLAB.get()).add(AxolotlTest.CORK_OAK_SLAB.get())
                .add(AxolotlTest.ALJANWOOD_SLAB.get()).add(AxolotlTest.ALJANCAP_SLAB.get()).add(AxolotlTest.INSOMNIAN_SLAB.get()).add(AxolotlTest.AVONDALIC_WILLOW_SLAB.get());
        this.getOrCreateBuilder(ItemTags.WOODEN_FENCES).add(AxolotlTest.CRYSTALLINE_BIRCH_FENCE.get()).add(AxolotlTest.GOLDENWOOD_FENCE.get()).add(AxolotlTest.GUAVA_FENCE.get()).add(AxolotlTest.JABUTICABA_FENCE.get()).add(AxolotlTest.CORK_OAK_FENCE.get())
                .add(AxolotlTest.ALJANWOOD_FENCE.get()).add(AxolotlTest.ALJANCAP_FENCE.get()).add(AxolotlTest.INSOMNIAN_FENCE.get()).add(AxolotlTest.AVONDALIC_WILLOW_FENCE.get());
        this.getOrCreateBuilder(Tags.Items.FENCE_GATES_WOODEN).add(AxolotlTest.CRYSTALLINE_BIRCH_FENCE_GATE.get()).add(AxolotlTest.GOLDENWOOD_FENCE_GATE.get()).add(AxolotlTest.GUAVA_FENCE_GATE.get())
                .add(AxolotlTest.JABUTICABA_FENCE_GATE.get()).add(AxolotlTest.CORK_OAK_FENCE_GATE.get()).add(AxolotlTest.ALJANWOOD_FENCE_GATE.get()).add(AxolotlTest.ALJANCAP_FENCE_GATE.get()).add(AxolotlTest.INSOMNIAN_FENCE_GATE.get())
                .add(AxolotlTest.AVONDALIC_WILLOW_FENCE_GATE.get());
        this.getOrCreateBuilder(ItemTags.WOODEN_DOORS).add(AxolotlTest.CRYSTALLINE_BIRCH_DOOR.get()).add(AxolotlTest.GOLDENWOOD_DOOR.get()).add(AxolotlTest.GUAVA_DOOR.get()).add(AxolotlTest.JABUTICABA_DOOR.get()).add(AxolotlTest.CORK_OAK_DOOR.get())
                .add(AxolotlTest.ALJANWOOD_DOOR.get()).add(AxolotlTest.AVONDALIC_WILLOW_DOOR.get());
        this.getOrCreateBuilder(ItemTags.WOODEN_TRAPDOORS).add(AxolotlTest.CRYSTALLINE_BIRCH_TRAPDOOR.get()).add(AxolotlTest.GOLDENWOOD_TRAPDOOR.get()).add(AxolotlTest.GUAVA_TRAPDOOR.get()).add(AxolotlTest.JABUTICABA_TRAPDOOR.get())
                .add(AxolotlTest.CORK_OAK_TRAPDOOR.get()).add(AxolotlTest.ALJANWOOD_TRAPDOOR.get()).add(AxolotlTest.AVONDALIC_WILLOW_TRAPDOOR.get());
        this.getOrCreateBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(AxolotlTest.CRYSTALLINE_BIRCH_PRESSURE_PLATE.get()).add(AxolotlTest.GOLDENWOOD_PRESSURE_PLATE.get()).add(AxolotlTest.GUAVA_PRESSURE_PLATE.get())
                .add(AxolotlTest.JABUTICABA_PRESSURE_PLATE.get()).add(AxolotlTest.CORK_OAK_PRESSURE_PLATE.get()).add(AxolotlTest.ALJANWOOD_PRESSURE_PLATE.get()).add(AxolotlTest.ALJANCAP_PRESSURE_PLATE.get()).add(AxolotlTest.INSOMNIAN_PRESSURE_PLATE.get())
                .add(AxolotlTest.AVONDALIC_WILLOW_PRESSURE_PLATE.get());
        this.getOrCreateBuilder(ItemTags.WOODEN_BUTTONS).add(AxolotlTest.CRYSTALLINE_BIRCH_BUTTON.get()).add(AxolotlTest.GOLDENWOOD_BUTTON.get()).add(AxolotlTest.GUAVA_BUTTON.get()).add(AxolotlTest.JABUTICABA_BUTTON.get())
                .add(AxolotlTest.CORK_OAK_BUTTON.get()).add(AxolotlTest.ALJANWOOD_BUTTON.get()).add(AxolotlTest.ALJANCAP_BUTTON.get()).add(AxolotlTest.INSOMNIAN_BUTTON.get()).add(AxolotlTest.AVONDALIC_WILLOW_BUTTON.get());

        this.getOrCreateBuilder(ItemTags.SAPLINGS).add(AxolotlTest.GUARANA_OAK_SAPLING.get()).add(AxolotlTest.MANGO_OAK_SAPLING.get()).add(AxolotlTest.MANGAED_MANGO_OAK_SAPLING.get())
                .add(AxolotlTest.GRAPE_VINE_SAPLING.get()).add(AxolotlTest.LEMON_OAK_SAPLING.get()).add(AxolotlTest.PINEAPPLE_OAK_SAPLING.get()).add(AxolotlTest.ORANGE_OAK_SAPLING.get()).add(AxolotlTest.BANANA_JUNGLE_SAPLING.get())
                .add(AxolotlTest.GUAVA_SAPLING.get()).add(AxolotlTest.JABUTICABA_SAPLING.get()).add(AxolotlTest.ALJAME_BIRCH_SAPLING.get()).add(AxolotlTest.CRYSTALLINE_BIRCH_SAPLING.get()).add(AxolotlTest.GOLDENWOOD_SAPLING.get())
                .add(AxolotlTest.ENCHANTED_GOLDENWOOD_SAPLING.get()).add(AxolotlTest.CORK_OAK_SAPLING.get()).add(AxolotlTest.ALJANWOOD_SAPLING.get()).add(AxolotlTest.ALJANCAP_SAPLING.get()).add(AxolotlTest.INSOMNIAN_SAPLING.get())
                .add(AxolotlTest.AVONDALIC_WILLOW_SAPLING.get());
        this.getOrCreateBuilder(ItemTags.LEAVES).add(AxolotlTest.GUARANA_OAK_LEAVES.get()).add(AxolotlTest.MANGO_OAK_LEAVES.get()).add(AxolotlTest.MANGAED_MANGO_OAK_LEAVES.get())
                .add(AxolotlTest.GRAPE_VINE_LEAVES.get()).add(AxolotlTest.LEMON_OAK_LEAVES.get()).add(AxolotlTest.PINEAPPLE_OAK_LEAVES.get()).add(AxolotlTest.GUAVA_LEAVES.get()).add(AxolotlTest.JABUTICABA_LEAVES.get())
                .add(AxolotlTest.CRYSTALLINE_BIRCH_LEAVES.get()).add(AxolotlTest.GOLDENWOOD_LEAVES.get()).add(AxolotlTest.ENCHANTED_GOLDENWOOD_LEAVES.get()).add(AxolotlTest.CORK_OAK_LEAVES.get())
                .add(AxolotlTest.ALJANWOOD_LEAVES.get()).add(AxolotlTest.ALJANCAP_LEAVES.get()).add(AxolotlTest.AMARACAP_LEAVES.get()).add(AxolotlTest.INSOMNIAN_LEAVES.get()).add(AxolotlTest.AVONDALIC_WILLOW_LEAVES.get());
    }
}
