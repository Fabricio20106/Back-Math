package com.sophicreeper.backmath.core.data.tags;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.tags.BMTags;
import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import net.minecraft.block.Blocks;
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
        this.getOrCreateBuilder(BMTags.Blocks.STORAGE_BLOCKS_ALJANSTEEL).add(BMBlocks.ALJANSTEEL_BLOCK.get());
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

        this.getOrCreateBuilder(BMTags.Blocks.ORES_DEVIL).add(BMBlocks.DEVIL_ORE.get()).add(BMBlocks.DEEPSLATE_DEVIL_ORE.get()).add(BMBlocks.NETHER_DEVIL_ORE.get());
        this.getOrCreateBuilder(BMTags.Blocks.ORES_ANGELIC).add(BMBlocks.ANGELIC_ORE.get()).add(BMBlocks.DEEPSLATE_ANGELIC_ORE.get());
        this.getOrCreateBuilder(BMTags.Blocks.ORES_MID_TERM).add(BMBlocks.MID_TERM_ORE.get()).add(BMBlocks.OBSIDIAN_MID_TERM_ORE.get());
        this.getOrCreateBuilder(BMTags.Blocks.ORES_CRYSTALLINE_ANGELIC).add(BMBlocks.CRYSTALLINE_ANGELIC_ORE.get());
        this.getOrCreateBuilder(BMTags.Blocks.ORES_ALJAMEED).add(BMBlocks.ALJAMEED_ORE.get()).add(BMBlocks.SLEEPINGSTONE_ALJAMEED_ORE.get());
        this.getOrCreateBuilder(BMTags.Blocks.ORES_MOONERING).add(BMBlocks.MOONERING_ORE.get()).add(BMBlocks.SLEEPINGSTONE_MOONERING_ORE.get());
        this.getOrCreateBuilder(BMTags.Blocks.ORES_JANTICAL).add(BMBlocks.JANTIC_ORE.get()).add(BMBlocks.SLEEPINGSTONE_JANTIC_ORE.get());
        this.getOrCreateBuilder(BMTags.Blocks.ORES_ALJAMIC_COPPER).add(BMBlocks.ALJAMIC_COPPER_ORE.get()).add(BMBlocks.SLEEPINGSTONE_ALJAMIC_COPPER_ORE.get());
        this.getOrCreateBuilder(BMTags.Blocks.ORES_COPPER).add(BMBlocks.ALJAMIC_COPPER_ORE.get()).add(BMBlocks.SLEEPINGSTONE_ALJAMIC_COPPER_ORE.get());
        this.getOrCreateBuilder(BMTags.Blocks.ORES_ALJAMIC_TIN).add(BMBlocks.ALJAMIC_TIN_ORE.get()).add(BMBlocks.SLEEPINGSTONE_ALJAMIC_TIN_ORE.get());
        this.getOrCreateBuilder(BMTags.Blocks.ORES_TIN).add(BMBlocks.ALJAMIC_TIN_ORE.get()).add(BMBlocks.SLEEPINGSTONE_ALJAMIC_TIN_ORE.get());
        this.getOrCreateBuilder(BMTags.Blocks.BASE_STONE_ALJAN).add(BMBlocks.ALJANSTONE.get()).add(BMBlocks.SLEEPINGSTONE.get()).add(BMBlocks.INSOGRAVEL.get());

        this.getOrCreateBuilder(BMTags.Blocks.GLASS_DEVIL).add(BMBlocks.DEVIL_STAINED_GLASS.get());
        this.getOrCreateBuilder(BMTags.Blocks.GLASS_PANES_DEVIL).add(BMBlocks.DEVIL_STAINED_GLASS_PANE.get());

        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_DEVIL);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_RAW_DEVIL);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_ANGELIC);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_RAW_ANGELIC);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_CHRISTIAN_MID_TERM);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_CHRISTIAN_MID_TERM_ANGELIC);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_CHRISTIAN_MID_TERM_DEVIL);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_DEVIL_ANGELIC);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_OBSIDIAN_INFUSED_MID_TERM);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_ALJAMEED);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_RAW_ALJAMEED);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_ALJANSTEEL);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_MOONERING);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_RAW_MOONERING);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_CHARJAN_COAL);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_HARDENED_AMARACAMEL);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_MILKLLARY);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_CRYSTALLINE_ANGELIC);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_MID_TERM);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_RAW_MID_TERM);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_MID_HILLARY);
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(BMTags.Blocks.STORAGE_BLOCKS_JANTICAL);

        this.getOrCreateBuilder(Tags.Blocks.ORES).addTag(BMTags.Blocks.ORES_DEVIL).addTag(BMTags.Blocks.ORES_ANGELIC).addTag(BMTags.Blocks.ORES_MID_TERM).addTag(BMTags.Blocks
                .ORES_CRYSTALLINE_ANGELIC).addTag(BMTags.Blocks.ORES_ALJAMEED).addTag(BMTags.Blocks.ORES_MOONERING).addTag(BMTags.Blocks.ORES_JANTICAL).addTag(BMTags.Blocks
                .ORES_ALJAMIC_COPPER).addTag(BMTags.Blocks.ORES_COPPER).addTag(BMTags.Blocks.ORES_ALJAMIC_TIN).addTag(BMTags.Blocks.ORES_TIN);

        this.getOrCreateBuilder(Tags.Blocks.GLASS_COLORLESS).add(BMBlocks.ALJAMIC_GLASS.get());
        this.getOrCreateBuilder(Tags.Blocks.GLASS_PANES_COLORLESS).add(BMBlocks.ALJAMIC_GLASS_PANE.get());
        this.getOrCreateBuilder(Tags.Blocks.GLASS).addTag(BMTags.Blocks.GLASS_DEVIL);
        this.getOrCreateBuilder(Tags.Blocks.GLASS_PANES).addTag(BMTags.Blocks.GLASS_PANES_DEVIL);

        this.getOrCreateBuilder(Tags.Blocks.DIRT).add(BMBlocks.ALJAMIC_GRASS_BLOCK.get()).add(BMBlocks.AVONDALIC_NYLIUM.get()).add(BMBlocks.ALJAMIC_DIRT.get());
        this.getOrCreateBuilder(Tags.Blocks.COBBLESTONE).add(BMBlocks.COBBLED_ALJANSTONE.get());

        this.getOrCreateBuilder(BlockTags.GUARDED_BY_PIGLINS).add(BMBlocks.CRYSTALLINE_BIRCH_LEAVES.get()).add(BMBlocks.CRYSTALLINE_CRYSTALLIZER.get()).add(BMBlocks.QUEEN_SOPHIE_RELIC
                .get()).add(BMBlocks.CRYSTALLINE_BIRCH_SAPLING.get()).add(BMBlocks.POTTED_CRYSTALLINE_BIRCH_SAPLING.get()).add(BMBlocks.QUEEN_SOPHIE_PET_RELIC.get());

        // Back Math Tags
        this.getOrCreateBuilder(BMTags.Blocks.INFINIBURN_ALJAN).add(Blocks.NETHERRACK).add(Blocks.MAGMA_BLOCK);

        // Logs & Woods
        this.getOrCreateBuilder(BMTags.Blocks.CRYSTALLINE_BIRCH_LOGS).add(BMBlocks.CRYSTALLINE_BIRCH_LOG.get()).add(BMBlocks.CRYSTALLINE_BIRCH_WOOD.get()).add(BMBlocks.STRIPPED_CRYSTALLINE_BIRCH_LOG.get()).add(BMBlocks.STRIPPED_CRYSTALLINE_BIRCH_WOOD.get());
        this.getOrCreateBuilder(BMTags.Blocks.CORK_OAK_LOGS).add(BMBlocks.CORK_OAK_LOG.get()).add(BMBlocks.CORK_OAK_WOOD.get()).add(BMBlocks.STRIPPED_CORK_OAK_LOG.get()).add(BMBlocks.STRIPPED_CORK_OAK_WOOD.get());
        this.getOrCreateBuilder(BMTags.Blocks.GOLDENWOOD_LOGS).add(BMBlocks.GOLDENWOOD_LOG.get()).add(BMBlocks.GOLDENWOOD_WOOD.get()).add(BMBlocks.STRIPPED_GOLDENWOOD_LOG.get()).add(BMBlocks.STRIPPED_GOLDENWOOD_WOOD.get());
        this.getOrCreateBuilder(BMTags.Blocks.GUAVA_LOGS).add(BMBlocks.GUAVA_LOG.get()).add(BMBlocks.GUAVA_WOOD.get()).add(BMBlocks.STRIPPED_GUAVA_LOG.get()).add(BMBlocks.STRIPPED_GUAVA_WOOD.get());
        this.getOrCreateBuilder(BMTags.Blocks.JABUTICABA_LOGS).add(BMBlocks.JABUTICABA_LOG.get()).add(BMBlocks.JABUTICABA_WOOD.get()).add(BMBlocks.JABUTICABA_LOG.get()).add(BMBlocks.JABUTICABA_WOOD.get());
        this.getOrCreateBuilder(BMTags.Blocks.ALJANWOOD_LOGS).add(BMBlocks.ALJANWOOD_LOG.get()).add(BMBlocks.ALJANWOOD_WOOD.get()).add(BMBlocks.STRIPPED_ALJANWOOD_LOG.get()).add(BMBlocks.STRIPPED_ALJANWOOD_WOOD.get());
        this.getOrCreateBuilder(BMTags.Blocks.ALJANCAP_LOGS).add(BMBlocks.ALJANCAP_LOG.get()).add(BMBlocks.ALJANCAP_WOOD.get()).add(BMBlocks.STRIPPED_ALJANCAP_LOG.get()).add(BMBlocks.STRIPPED_ALJANCAP_WOOD.get());
        this.getOrCreateBuilder(BMTags.Blocks.INSOMNIAN_LOGS).add(BMBlocks.INSOMNIAN_LOG.get()).add(BMBlocks.INSOMNIAN_WOOD.get()).add(BMBlocks.STRIPPED_INSOMNIAN_LOG.get()).add(BMBlocks.STRIPPED_INSOMNIAN_WOOD.get());
        this.getOrCreateBuilder(BMTags.Blocks.AVONDALIC_WILLOW_LOGS).add(BMBlocks.AVONDALIC_WILLOW_LOG.get()).add(BMBlocks.AVONDALIC_WILLOW_WOOD.get()).add(BMBlocks.STRIPPED_AVONDALIC_WILLOW_LOG.get()).add(BMBlocks.STRIPPED_AVONDALIC_WILLOW_WOOD.get());

        this.getOrCreateBuilder(BMTags.Blocks.STRIPPED_WOODS).add(Blocks.STRIPPED_OAK_WOOD).add(Blocks.STRIPPED_SPRUCE_WOOD).add(Blocks.STRIPPED_BIRCH_WOOD).add(Blocks.STRIPPED_JUNGLE_WOOD)
                .add(Blocks.STRIPPED_ACACIA_WOOD).add(Blocks.STRIPPED_DARK_OAK_WOOD).add(Blocks.STRIPPED_CRIMSON_HYPHAE).add(Blocks.STRIPPED_WARPED_HYPHAE).add(BMBlocks.STRIPPED_CRYSTALLINE_BIRCH_WOOD.get())
                .add(BMBlocks.STRIPPED_CORK_OAK_WOOD.get()).add(BMBlocks.STRIPPED_GOLDENWOOD_WOOD.get()).add(BMBlocks.STRIPPED_GUAVA_WOOD.get()).add(BMBlocks.STRIPPED_JABUTICABA_WOOD.get())
                .add(BMBlocks.STRIPPED_ALJANWOOD_WOOD.get()).add(BMBlocks.STRIPPED_ALJANCAP_WOOD.get()).add(BMBlocks.STRIPPED_INSOMNIAN_WOOD.get()).add(BMBlocks.STRIPPED_AVONDALIC_WILLOW_WOOD.get());

        this.getOrCreateBuilder(BMTags.Blocks.GRAPE_VINE_POSTS).add(BMBlocks.OAK_GRAPE_VINE_POST.get()).add(BMBlocks.SPRUCE_GRAPE_VINE_POST.get()).add(BMBlocks.BIRCH_GRAPE_VINE_POST.get())
                .add(BMBlocks.JUNGLE_GRAPE_VINE_POST.get()).add(BMBlocks.ACACIA_GRAPE_VINE_POST.get()).add(BMBlocks.DARK_OAK_GRAPE_VINE_POST.get()).add(BMBlocks.CRIMSON_GRAPE_VINE_POST.get())
                .add(BMBlocks.WARPED_GRAPE_VINE_POST.get()).add(BMBlocks.CRYSTALLINE_BIRCH_GRAPE_VINE_POST.get()).add(BMBlocks.CORK_OAK_GRAPE_VINE_POST.get()).add(BMBlocks.GOLDENWOOD_GRAPE_VINE_POST.get())
                .add(BMBlocks.GUAVA_GRAPE_VINE_POST.get()).add(BMBlocks.JABUTICABA_GRAPE_VINE_POST.get()).add(BMBlocks.ALJANWOOD_GRAPE_VINE_POST.get()).add(BMBlocks.ALJANCAP_GRAPE_VINE_POST.get())
                .add(BMBlocks.INSOMNIAN_GRAPE_VINE_POST.get()).add(BMBlocks.AVONDALIC_WILLOW_GRAPE_VINE_POST.get());

        this.getOrCreateBuilder(BMTags.Blocks.SQUIDS).add(BMBlocks.TITO.get()).add(BMBlocks.TOTI.get());
        this.getOrCreateBuilder(BMTags.Blocks.TOYS).add(BMBlocks.INNOVATOR_TOY.get()).add(BMBlocks.ALICE_TOY.get()).add(BMBlocks.ALAN_TOY.get()).add(BMBlocks.TEENAGER_ALICE_TOY.get())
                .add(BMBlocks.LEANDRO_TOY.get()).add(BMBlocks.TYLER_TOY.get()).add(BMBlocks.MALENA_TOY.get());

        this.getOrCreateBuilder(BMTags.Blocks.BOUNTIFULLY_EXPANSIVE_IDEA).add(BMBlocks.CHOCOLATE_NAKED_CAKE.get());
        this.getOrCreateBuilder(BMTags.Blocks.SOPHIE_IDEA).addTag(BMTags.Blocks.BOUNTIFULLY_EXPANSIVE_IDEA);
    }
}
