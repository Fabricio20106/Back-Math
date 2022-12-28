package com.sophicreeper.backmath.core.data.tags;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import com.sophicreeper.backmath.core.tags.BMTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
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
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_MID_TERM).add(AxolotlTest.MID_TERM_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_CHRISTIAN_MID_TERM_ANGELIC).add(AxolotlTest.CHRISTIAN_MID_TERM_ANGELIC_ALLOY_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_CHRISTIAN_MID_TERM_DEVIL).add(AxolotlTest.CHRISTIAN_MID_TERM_DEVIL_ALLOY_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_DEVIL_ANGELIC).add(AxolotlTest.DEVIL_ANGELIC_ALLOY_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_OBSIDIAN_INFUSED_MID_TERM).add(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Items.STORAGE_BLOCKS_ALJAMEED).add(AxolotlTest.ALJAMEED_BLOCK.get());
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

        this.getOrCreateBuilder(BMTags.Items.ORES_ALJAMEED).add(AxolotlTest.ALJAMEED_ORE.get()).add(AxolotlTest.SLEEPINGSTONE_ALJAMEED_ORE.get());
        this.getOrCreateBuilder(BMTags.Items.ORES_MOONERING).add(AxolotlTest.MOONERING_ORE.get()).add(AxolotlTest.SLEEPINGSTONE_MOONERING_ORE.get());
        this.getOrCreateBuilder(BMTags.Items.ORES_JANTICAL).add(AxolotlTest.JANTIC_ORE.get()).add(AxolotlTest.SLEEPINGSTONE_JANTIC_ORE.get());
        this.getOrCreateBuilder(BMTags.Items.ORES_ALJAMIC_COPPER).add(AxolotlTest.ALJAMIC_COPPER_ORE.get()).add(AxolotlTest.RAW_ALJAMIC_COPPER.get()).add(AxolotlTest.SLEEPINGSTONE_ALJAMIC_COPPER_ORE.get());
        this.getOrCreateBuilder(BMTags.Items.ORES_COPPER).add(AxolotlTest.ALJAMIC_COPPER_ORE.get()).add(AxolotlTest.RAW_ALJAMIC_COPPER.get()).add(AxolotlTest.SLEEPINGSTONE_ALJAMIC_COPPER_ORE.get());
        this.getOrCreateBuilder(BMTags.Items.ORES_ALJAMIC_TIN).add(AxolotlTest.ALJAMIC_TIN_ORE.get()).add(AxolotlTest.RAW_ALJAMIC_TIN.get()).add(AxolotlTest.SLEEPINGSTONE_ALJAMIC_TIN_ORE.get());
        this.getOrCreateBuilder(BMTags.Items.ORES_TIN).add(AxolotlTest.ALJAMIC_TIN_ORE.get()).add(AxolotlTest.RAW_ALJAMIC_TIN.get()).add(AxolotlTest.SLEEPINGSTONE_ALJAMIC_TIN_ORE.get());

        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_DEVIL);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_ANGELIC);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_CHRISTIAN_MID_TERM);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_MID_TERM);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_CHRISTIAN_MID_TERM_ANGELIC);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_CHRISTIAN_MID_TERM_DEVIL);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_DEVIL_ANGELIC);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_OBSIDIAN_INFUSED_MID_TERM);
        this.getOrCreateBuilder(Tags.Items.STORAGE_BLOCKS).addTag(BMTags.Items.STORAGE_BLOCKS_ALJAMEED);
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
        this.getOrCreateBuilder(Tags.Items.ORES).addTag(BMTags.Items.ORES_ALJAMEED);
        this.getOrCreateBuilder(Tags.Items.ORES).addTag(BMTags.Items.ORES_MOONERING);
        this.getOrCreateBuilder(Tags.Items.ORES).addTag(BMTags.Items.ORES_JANTICAL);

        this.getOrCreateBuilder(BMTags.Items.INGOTS_CHRISTIAN_MID_TERM).add(AxolotlTest.CHRISTIAN_MID_TERM_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_ANGELIC).add(AxolotlTest.ANGELIC_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_DEVIL).add(AxolotlTest.DEVIL_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_MID_TERM).add(AxolotlTest.MID_TERM_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_CHRISTIAN_MID_TERM_ANGELIC).add(AxolotlTest.CHRISTIAN_MID_TERM_ANGELIC_ALLOY_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_CHRISTIAN_MID_TERM_DEVIL).add(AxolotlTest.CHRISTIAN_MID_TERM_DEVIL_ALLOY_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_DEVIL_ANGELIC).add(AxolotlTest.DEVIL_ANGELIC_ALLOY_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_MILKLLARY).add(AxolotlTest.MILKLLARY_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_OBSIDIAN_INFUSED_MID_TERM).add(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_MID_HILLARY).add(AxolotlTest.MID_HILLARY_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_ALJAMEED).add(AxolotlTest.ALJAMEED_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_MOONERING).add(AxolotlTest.MOONERING_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_ALJAMIC_COPPER).add(AxolotlTest.ALJAMIC_COPPER_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_ALJAMIC_TIN).add(AxolotlTest.ALJAMIC_TIN_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_COPPER).add(AxolotlTest.ALJAMIC_COPPER_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_TIN).add(AxolotlTest.ALJAMIC_TIN_INGOT.get());
        this.getOrCreateBuilder(BMTags.Items.INGOTS_HARDENED_AMARACAMEL).add(AxolotlTest.HARDENED_AMARACAMEL_INGOT.get());

        this.getOrCreateBuilder(BMTags.Items.ORES_ALJAMEED).add(AxolotlTest.RAW_ALJAMEED.get()).add(AxolotlTest.ALJAMEED_ORE.get());
        this.getOrCreateBuilder(BMTags.Items.ORES_MOONERING).add(AxolotlTest.RAW_MOONER.get()).add(AxolotlTest.MOONERING_ORE.get());
        this.getOrCreateBuilder(BMTags.Items.ORES_JANTICAL).add(AxolotlTest.JANTIC_ORE.get());

        this.getOrCreateBuilder(BMTags.Items.DUSTS_CHRISTIAN_MID_TERM_ANGELIC).add(AxolotlTest.CHRISTIAN_MID_TERM_ANGELIC_DUST.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_CHRISTIAN_MID_TERM_DEVIL).add(AxolotlTest.CHRISTIAN_MID_TERM_DEVIL_DUST.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_DEVIL_ANGELIC).add(AxolotlTest.DEVIL_ANGELIC_DUST.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_OBSIDIAN_INFUSED_MID_TERM).add(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_DUST.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_ALJAMEED).add(AxolotlTest.ALJAMEED_DUST.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_MOONERING).add(AxolotlTest.MOONERING_DUST.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_WATER).add(AxolotlTest.WATER_TALC_POWDER.get());

        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES).addTag(BMTags.Items.SINGULARITIES_FRUTIFERY).addTag(BMTags.Items.SINGULARITIES_MEATY).addTag(BMTags.Items.SINGULARITIES_VEGETABLY).addTag(BMTags.Items.SINGULARITIES_EMOTIONAL).addTag(BMTags.Items.SINGULARITIES_CHRISTIANITY)
                .addTag(BMTags.Items.SINGULARITIES_HEAT).addTag(BMTags.Items.SINGULARITIES_FISHY).addTag(BMTags.Items.SINGULARITIES_MID_TERM).addTag(BMTags.Items.SINGULARITIES_OBSIDIAN_INFUSED_MID_TERM).addTag(BMTags.Items.SINGULARITIES_MILKLLARY).addTag(BMTags.Items.SINGULARITIES_MANGA_MANGO)
                .addTag(BMTags.Items.SINGULARITIES_MEATY_FABRICIO).addTag(BMTags.Items.SINGULARITIES_MEATY_SOPHIE).addTag(BMTags.Items.SINGULARITIES_MEATY_LUCIA).addTag(BMTags.Items.SINGULARITIES_MEATY_MINECRAFT).addTag(BMTags.Items.SINGULARITIES_FRUTIFERY_BACKMATH)
                .addTag(BMTags.Items.SINGULARITIES_FRUTIFERY_MINECRAFT).addTag(BMTags.Items.SINGULARITIES_VEGETABLY_VARIANTS);
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_CHRISTIANITY).add(AxolotlTest.CHRISTIANITY_SINGULARITY.get());
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_EMOTIONAL).add(AxolotlTest.EMOTIONAL_SINGULARITY.get());
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_HEAT).add(AxolotlTest.HEAT_SINGULARITY.get()).add(AxolotlTest.TEMPERATURE_SINGULARITY.get());
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_FISHY).add(AxolotlTest.FISHY_SINGULARITY.get());
        this.getOrCreateBuilder(BMTags.Items.SINGULARITIES_MANGA_MANGO).add(AxolotlTest.MANGIBELARITY.get());
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

        this.getOrCreateBuilder(BMTags.Items.DUSTS_DEVIL).add(AxolotlTest.DEVIL_DUST.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_ANGELIC).add(AxolotlTest.ANGELIC_DUST.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_CHRISTIAN_MID_TERM).add(AxolotlTest.CHRISTIAN_MID_TERM_DUST.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_MID_TERM).add(AxolotlTest.MID_TERM_DUST.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_HILLARY).add(AxolotlTest.HILLARY_AGGLOMERATIO.get());
        this.getOrCreateBuilder(BMTags.Items.DUSTS_MILKLLARY).add(AxolotlTest.MILKLLARY_AGGLOMERATIO.get());

        this.getOrCreateBuilder(BMTags.Items.NUGGETS_CHRISTIAN_MID_TERM).add(AxolotlTest.CHRISTIAN_MID_TERM_NUGGET.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_MID_TERM).add(AxolotlTest.MID_TERM_NUGGET.get()).add(AxolotlTest.MID_TERM_SHARD.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_OBSIDIAN_INFUSED_MID_TERM).add(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_NUGGET.get()).add(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_SHARD.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_ALJAMEED).add(AxolotlTest.ALJAMEED_NUGGET.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_MOONERING).add(AxolotlTest.MOONERING_NUGGET.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_HARDENED_AMARACAMEL).add(AxolotlTest.HARDENED_AMARACAMEL_NUGGET.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_MILKLLARY).add(AxolotlTest.MILKLLARY_NUGGET.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_MID_HILLARY).add(AxolotlTest.MID_HILLARY_NUGGET.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_MILKLLARITY).add(AxolotlTest.MILKLLARITY_SHARD.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_CRYSTALLINE_ANGELIC).add(AxolotlTest.CRYSTALLINE_ANGELIC_SHARD.get());
        this.getOrCreateBuilder(BMTags.Items.NUGGETS_JANTICAL).add(AxolotlTest.JANTICAL_SHARD.get());

        this.getOrCreateBuilder(BMTags.Items.RODS_GUAVA).add(AxolotlTest.GUAVA_STICK.get());
        this.getOrCreateBuilder(BMTags.Items.RODS_ALJANCAP).add(AxolotlTest.ALJANCAP_STICK.get());
        this.getOrCreateBuilder(BMTags.Items.RODS_ALJANWOOD).add(AxolotlTest.ALJANWOOD_STICK.get());
        this.getOrCreateBuilder(BMTags.Items.RODS_INSOMNIAN).add(AxolotlTest.INSOMNIAN_STICK.get());
        this.getOrCreateBuilder(BMTags.Items.RODS_ALJAMEED).add(AxolotlTest.ALJAMEED_BONE.get());

        this.getOrCreateBuilder(BMTags.Items.SQUIDS).add(AxolotlTest.TITO.get()).add(AxolotlTest.TOTI.get());
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
                AxolotlTest.GUAVA_POPSICLE.get(), AxolotlTest.JABUTICABA_POPSICLE.get(), AxolotlTest.ALJAMIC_BERRY_POPSICLE.get());

        this.getOrCreateBuilder(BMTags.Items.GEMS_CRYSTALLINE_ANGELIC).add(AxolotlTest.CRYSTALLINE_ANGELIC.get());
        this.getOrCreateBuilder(BMTags.Items.GEMS_OBSIDIAN_INFUSED_MID_TERM).add(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM.get());
        this.getOrCreateBuilder(BMTags.Items.GEMS_JANTICAL).add(AxolotlTest.JANTICAL.get());
        this.getOrCreateBuilder(BMTags.Items.GEMS_PERSONA).add(AxolotlTest.PERSONA_SHARD.get());

        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_ANGELIC);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_DEVIL);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_CHRISTIAN_MID_TERM);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_MID_TERM);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_DEVIL_ANGELIC);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_CHRISTIAN_MID_TERM_ANGELIC);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_CHRISTIAN_MID_TERM_DEVIL);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_MILKLLARY);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_OBSIDIAN_INFUSED_MID_TERM);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_MID_HILLARY);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_MOONERING);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_ALJAMEED);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_ALJAMIC_COPPER);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_ALJAMIC_TIN);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_COPPER);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_TIN);
        this.getOrCreateBuilder(Tags.Items.INGOTS).addTag(BMTags.Items.INGOTS_HARDENED_AMARACAMEL);

        this.getOrCreateBuilder(Tags.Items.RODS).addTag(BMTags.Items.RODS_ALJANWOOD).addTag(BMTags.Items.RODS_ALJANCAP).addTag(BMTags.Items.RODS_INSOMNIAN).addTag(BMTags.Items.RODS_ALJAMEED).addTag(BMTags.Items.RODS_GUAVA);
        this.getOrCreateBuilder(ItemTags.COALS).add(AxolotlTest.CHARJAN_COAL.get());

        this.getOrCreateBuilder(Tags.Items.GEMS).addTag(BMTags.Items.GEMS_CRYSTALLINE_ANGELIC).addTag(BMTags.Items.GEMS_OBSIDIAN_INFUSED_MID_TERM).addTag(BMTags.Items.GEMS_JANTICAL).addTag(BMTags.Items.GEMS_PERSONA);

        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_ANGELIC);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_DEVIL);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_CHRISTIAN_MID_TERM);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_MID_TERM);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_HILLARY);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_MILKLLARY);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_CHRISTIAN_MID_TERM_ANGELIC);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_CHRISTIAN_MID_TERM_DEVIL);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_DEVIL_ANGELIC);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_OBSIDIAN_INFUSED_MID_TERM);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_ALJAMEED);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_MOONERING);
        this.getOrCreateBuilder(Tags.Items.DUSTS).addTag(BMTags.Items.DUSTS_WATER);

        this.getOrCreateBuilder(Tags.Items.NUGGETS).addTag(BMTags.Items.NUGGETS_CHRISTIAN_MID_TERM).addTag(BMTags.Items.NUGGETS_MID_TERM).addTag(BMTags.Items.NUGGETS_OBSIDIAN_INFUSED_MID_TERM).addTag(BMTags.Items.NUGGETS_ALJAMEED)
                .addTag(BMTags.Items.NUGGETS_MOONERING).addTag(BMTags.Items.NUGGETS_HARDENED_AMARACAMEL).addTag(BMTags.Items.NUGGETS_MILKLLARY).addTag(BMTags.Items.NUGGETS_MID_HILLARY).addTag(BMTags.Items.NUGGETS_MILKLLARITY)
                .addTag(BMTags.Items.NUGGETS_CRYSTALLINE_ANGELIC).addTag(BMTags.Items.NUGGETS_JANTICAL);
    }
}
