package com.sophicreeper.backmath.core.data.tags;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import com.sophicreeper.backmath.core.tags.BMTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class BMBlockTagsProvider extends BlockTagsProvider {
    public BMBlockTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper fileHelper) {
        super(generator, BackMath.MOD_ID, fileHelper);
    }

    @Override
    public String getName() {
        return "Back Math - Block Tags";
    }

    @Override
    protected void registerTags() {
        this.getOrCreateBuilder(BMTags.Blocks.STORAGE_BLOCKS_DEVIL).add(BMBlocks.DEVIL_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Blocks.STORAGE_BLOCKS_ANGELIC).add(BMBlocks.ANGELIC_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Blocks.STORAGE_BLOCKS_CHRISTIAN_MID_TERM).add(BMBlocks.CHRISTIAN_MID_TERM_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Blocks.STORAGE_BLOCKS_MID_TERM).add(BMBlocks.MID_TERM_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Blocks.STORAGE_BLOCKS_CHRISTIAN_MID_TERM_ANGELIC).add(BMBlocks.CHRISTIAN_MID_TERM_ANGELIC_ALLOY_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Blocks.STORAGE_BLOCKS_CHRISTIAN_MID_TERM_DEVIL).add(BMBlocks.CHRISTIAN_MID_TERM_DEVIL_ALLOY_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Blocks.STORAGE_BLOCKS_DEVIL_ANGELIC).add(BMBlocks.DEVIL_ANGELIC_ALLOY_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Blocks.STORAGE_BLOCKS_OBSIDIAN_INFUSED_MID_TERM).add(BMBlocks.OBSIDIAN_INFUSED_MID_TERM_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Blocks.STORAGE_BLOCKS_ALJAMEED).add(BMBlocks.ALJAMEED_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Blocks.STORAGE_BLOCKS_MOONERING).add(BMBlocks.MOONERING_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Blocks.STORAGE_BLOCKS_CHARJAN_COAL).add(BMBlocks.CHARJAN_COAL_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Blocks.STORAGE_BLOCKS_HARDENED_AMARACAMEL).add(BMBlocks.HARDENED_AMARACAMEL_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Blocks.STORAGE_BLOCKS_MILKLLARY).add(BMBlocks.MILKLLARY_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Blocks.STORAGE_BLOCKS_CRYSTALLINE_ANGELIC).add(BMBlocks.CRYSTALLINE_ANGELIC_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Blocks.STORAGE_BLOCKS_RAW_DEVIL).add(BMBlocks.RAW_DEVIL_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Blocks.STORAGE_BLOCKS_RAW_ANGELIC).add(BMBlocks.RAW_ANGELIC_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Blocks.STORAGE_BLOCKS_RAW_MID_TERM).add(BMBlocks.RAW_MID_TERM_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Blocks.STORAGE_BLOCKS_RAW_ALJAMEED).add(BMBlocks.RAW_ALJAMEED_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Blocks.STORAGE_BLOCKS_RAW_MOONERING).add(BMBlocks.RAW_MOONER_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Blocks.STORAGE_BLOCKS_MID_HILLARY).add(BMBlocks.MID_HILLARY_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Blocks.STORAGE_BLOCKS_JANTICAL).add(BMBlocks.JANTICAL_BLOCK.get());
        this.getOrCreateBuilder(BMTags.Blocks.ORES_ALJAMEED).add(BMBlocks.ALJAMEED_ORE.get()).add(BMBlocks.SLEEPINGSTONE_ALJAMEED_ORE.get());
        this.getOrCreateBuilder(BMTags.Blocks.ORES_MOONERING).add(BMBlocks.MOONERING_ORE.get()).add(BMBlocks.SLEEPINGSTONE_MOONERING_ORE.get());
        this.getOrCreateBuilder(BMTags.Blocks.ORES_JANTICAL).add(BMBlocks.JANTIC_ORE.get()).add(BMBlocks.SLEEPINGSTONE_JANTIC_ORE.get());
        this.getOrCreateBuilder(BMTags.Blocks.ORES_ALJAMIC_COPPER).add(BMBlocks.ALJAMIC_COPPER_ORE.get()).add(BMBlocks.SLEEPINGSTONE_ALJAMIC_COPPER_ORE.get());
        this.getOrCreateBuilder(BMTags.Blocks.ORES_COPPER).add(BMBlocks.ALJAMIC_COPPER_ORE.get()).add(BMBlocks.SLEEPINGSTONE_ALJAMIC_COPPER_ORE.get());
        this.getOrCreateBuilder(BMTags.Blocks.ORES_ALJAMIC_TIN).add(BMBlocks.ALJAMIC_TIN_ORE.get()).add(BMBlocks.SLEEPINGSTONE_ALJAMIC_TIN_ORE.get());
        this.getOrCreateBuilder(BMTags.Blocks.ORES_TIN).add(BMBlocks.ALJAMIC_TIN_ORE.get()).add(BMBlocks.SLEEPINGSTONE_ALJAMIC_TIN_ORE.get());
        this.getOrCreateBuilder(BMTags.Blocks.BASE_STONE_ALJAN).add(BMBlocks.ALJANSTONE.get()).add(BMBlocks.SLEEPINGSTONE.get()).add(BMBlocks.INSOGRAVEL.get());

        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_DEVIL);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_ANGELIC);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_CHRISTIAN_MID_TERM);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_CHRISTIAN_MID_TERM_ANGELIC);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_CHRISTIAN_MID_TERM_DEVIL);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_DEVIL_ANGELIC);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_OBSIDIAN_INFUSED_MID_TERM);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_ALJAMEED);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_MOONERING);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_CHARJAN_COAL);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_HARDENED_AMARACAMEL);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_MILKLLARY);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_CRYSTALLINE_ANGELIC);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_MID_TERM);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_RAW_DEVIL);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_RAW_ANGELIC);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_RAW_MID_TERM);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_RAW_ALJAMEED);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_RAW_MOONERING);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_MID_HILLARY);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_JANTICAL);
        this.getOrCreateBuilder(Tags.Blocks.ORES).addTag(BMTags.Blocks.ORES_ALJAMEED);
        this.getOrCreateBuilder(Tags.Blocks.ORES).addTag(BMTags.Blocks.ORES_MOONERING);
        this.getOrCreateBuilder(Tags.Blocks.ORES).addTag(BMTags.Blocks.ORES_JANTICAL);
        this.getOrCreateBuilder(Tags.Blocks.ORES).addTag(BMTags.Blocks.ORES_ALJAMIC_COPPER);
        this.getOrCreateBuilder(Tags.Blocks.ORES).addTag(BMTags.Blocks.ORES_COPPER);
        this.getOrCreateBuilder(Tags.Blocks.ORES).addTag(BMTags.Blocks.ORES_ALJAMIC_TIN);
        this.getOrCreateBuilder(Tags.Blocks.ORES).addTag(BMTags.Blocks.ORES_TIN);

        this.getOrCreateBuilder(BlockTags.GUARDED_BY_PIGLINS).add(BMBlocks.CRYSTALLINE_BIRCH_LEAVES.get()).add(BMBlocks.CRYSTALLINE_CRYSTALLIZER.get()).add(BMBlocks.QUEEN_SOPHIE_RELIC.get()).add(BMBlocks.CRYSTALLINE_BIRCH_SAPLING.get())
                .add(BMBlocks.POTTED_CRYSTALLINE_BIRCH_SAPLING.get());
    }
}
