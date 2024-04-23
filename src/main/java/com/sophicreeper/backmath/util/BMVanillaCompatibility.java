package com.sophicreeper.backmath.util;

import com.google.common.collect.Maps;
import com.sophicreeper.backmath.block.BMBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ShovelItem;

public class BMVanillaCompatibility {
    public static void initCompats() {
        flammable(BMBlocks.GUARANA_OAK_LEAVES.get(), 30, 60);
        flammable(BMBlocks.MANGO_OAK_LEAVES.get(), 30, 60);
        flammable(BMBlocks.GRAPE_VINE_LEAVES.get(), 30, 60);
        flammable(BMBlocks.LEMON_OAK_LEAVES.get(), 30, 60);
        flammable(BMBlocks.ALJAME_BIRCH_LEAVES.get(), 30, 60);
        flammable(BMBlocks.PINEAPPLE_OAK_LEAVES.get(), 30, 60);
        flammable(BMBlocks.CRYSTALLINE_BIRCH_LEAVES.get(), 30, 60);
        flammable(BMBlocks.ALJANWOOD_LEAVES.get(), 30, 60);
        flammable(BMBlocks.ALJANCAP_LEAVES.get(), 30, 60);
        flammable(BMBlocks.AMARACAP_LEAVES.get(), 30, 60);
        flammable(BMBlocks.INSOMNIAN_LEAVES.get(), 30, 60);
        flammable(BMBlocks.DEVIL_WOOL.get(), 30, 60);
        flammable(BMBlocks.DEVIL_CARPET.get(), 60, 20);
        flammable(BMBlocks.RED_YELLOW_ALLIUM.get(), 60, 100);
        flammable(BMBlocks.FRIED_EGG_FLOWER.get(), 60, 100);
        flammable(BMBlocks.TURTLE_FRIED_EGG_FLOWER.get(), 60, 100);
        flammable(BMBlocks.ALJAN_TULIP.get(), 60, 100);
        flammable(BMBlocks.POISON_ROSE.get(), 60, 100);
        flammable(BMBlocks.INSOMNIAN_TULIP.get(), 60, 100);
        flammable(BMBlocks.TITO.get(), 30, 60);
        flammable(BMBlocks.TOTI.get(), 30, 60);
        flammable(BMBlocks.ALICE_TOY.get(), 60, 20);
        flammable(BMBlocks.ALAN_TOY.get(), 60, 20);
        flammable(BMBlocks.INNOVATOR_TOY.get(), 60, 20);
        flammable(BMBlocks.TYLER_TOY.get(), 60, 20);
        flammable(BMBlocks.MALENA_TOY.get(), 60, 20);

        strippable(BMBlocks.ALJANWOOD_LOG.get(), BMBlocks.STRIPPED_ALJANWOOD_LOG.get());
        strippable(BMBlocks.ALJANWOOD_WOOD.get(), BMBlocks.STRIPPED_ALJANWOOD_WOOD.get());
        strippable(BMBlocks.ALJANCAP_LOG.get(), BMBlocks.STRIPPED_ALJANCAP_LOG.get());
        strippable(BMBlocks.ALJANCAP_WOOD.get(), BMBlocks.STRIPPED_ALJANCAP_WOOD.get());
        strippable(BMBlocks.INSOMNIAN_LOG.get(), BMBlocks.STRIPPED_INSOMNIAN_LOG.get());
        strippable(BMBlocks.INSOMNIAN_WOOD.get(), BMBlocks.STRIPPED_INSOMNIAN_WOOD.get());

        tillable(BMBlocks.ALJAMIC_GRASS_BLOCK.get(), BMBlocks.ALJAMIC_FARMLAND.get().defaultBlockState());
        tillable(BMBlocks.ALJAMIC_DIRT.get(), BMBlocks.ALJAMIC_FARMLAND.get().defaultBlockState());

        // Back Math 1.8.0:
        flammable(BMBlocks.GUAVA_PLANKS.get(), 5, 20);
        flammable(BMBlocks.GUAVA_STAIRS.get(), 5, 20);
        flammable(BMBlocks.GUAVA_SLAB.get(), 5, 20);
        flammable(BMBlocks.GUAVA_FENCE.get(), 5, 20);
        flammable(BMBlocks.GUAVA_FENCE_GATE.get(), 5, 20);
        flammable(BMBlocks.GUAVA_TRAPDOOR.get(), 5, 20);
        flammable(BMBlocks.GUAVA_DOOR.get(), 5, 20);
        flammable(BMBlocks.GUAVA_BUTTON.get(), 5, 20);
        flammable(BMBlocks.GUAVA_PRESSURE_PLATE.get(), 5, 20);
        flammable(BMBlocks.GUAVA_LADDER.get(), 5, 20);
        flammable(BMBlocks.GUAVA_LOG.get(), 5, 5);
        flammable(BMBlocks.STRIPPED_GUAVA_LOG.get(), 5, 5);
        flammable(BMBlocks.GUAVA_WOOD.get(), 5, 5);
        flammable(BMBlocks.STRIPPED_GUAVA_WOOD.get(), 5, 5);
        flammable(BMBlocks.GUAVA_LEAVES.get(), 30, 60);
        flammable(BMBlocks.GOLDENWOOD_PLANKS.get(), 5, 20);
        flammable(BMBlocks.GOLDENWOOD_STAIRS.get(), 5, 20);
        flammable(BMBlocks.GOLDENWOOD_SLAB.get(), 5, 20);
        flammable(BMBlocks.GOLDENWOOD_FENCE.get(), 5, 20);
        flammable(BMBlocks.GOLDENWOOD_FENCE_GATE.get(), 5, 20);
        flammable(BMBlocks.GOLDENWOOD_TRAPDOOR.get(), 5, 20);
        flammable(BMBlocks.GOLDENWOOD_DOOR.get(), 5, 20);
        flammable(BMBlocks.GOLDENWOOD_BUTTON.get(), 5, 20);
        flammable(BMBlocks.GOLDENWOOD_PRESSURE_PLATE.get(), 5, 20);
        flammable(BMBlocks.GOLDENWOOD_LOG.get(), 5, 5);
        flammable(BMBlocks.STRIPPED_GOLDENWOOD_LOG.get(), 5, 5);
        flammable(BMBlocks.GOLDENWOOD_WOOD.get(), 5, 5);
        flammable(BMBlocks.STRIPPED_GOLDENWOOD_WOOD.get(), 5, 5);
        flammable(BMBlocks.GOLDENWOOD_LEAVES.get(), 30, 60);
        flammable(BMBlocks.ENCHANTED_GOLDENWOOD_LEAVES.get(), 30, 60);
        flammable(BMBlocks.MANGAED_MANGO_OAK_LEAVES.get(), 30, 60);
        flammable(BMBlocks.LEANDRO_TOY.get(), 60, 20);
        flammable(BMBlocks.TEENAGER_ALICE_TOY.get(), 60, 20);
        flammable(BMBlocks.JABUTICABA_PLANKS.get(), 5, 20);
        flammable(BMBlocks.JABUTICABA_STAIRS.get(), 5, 20);
        flammable(BMBlocks.JABUTICABA_SLAB.get(), 5, 20);
        flammable(BMBlocks.JABUTICABA_FENCE.get(), 5, 20);
        flammable(BMBlocks.JABUTICABA_FENCE_GATE.get(), 5, 20);
        flammable(BMBlocks.JABUTICABA_TRAPDOOR.get(), 5, 20);
        flammable(BMBlocks.JABUTICABA_DOOR.get(), 5, 20);
        flammable(BMBlocks.JABUTICABA_BUTTON.get(), 5, 20);
        flammable(BMBlocks.JABUTICABA_PRESSURE_PLATE.get(), 5, 20);
        flammable(BMBlocks.JABUTICABA_LADDER.get(), 5, 20);
        flammable(BMBlocks.JABUTICABA_LOG.get(), 5, 5);
        flammable(BMBlocks.STRIPPED_JABUTICABA_LOG.get(), 5, 5);
        flammable(BMBlocks.JABUTICABA_WOOD.get(), 5, 5);
        flammable(BMBlocks.STRIPPED_JABUTICABA_WOOD.get(), 5, 5);
        flammable(BMBlocks.JABUTICABA_LEAVES.get(), 30, 60);
        flammable(BMBlocks.AVONDALIC_WILLOW_PLANKS.get(), 5, 20);
        flammable(BMBlocks.AVONDALIC_WILLOW_STAIRS.get(), 5, 20);
        flammable(BMBlocks.AVONDALIC_WILLOW_SLAB.get(), 5, 20);
        flammable(BMBlocks.AVONDALIC_WILLOW_FENCE.get(), 5, 20);
        flammable(BMBlocks.AVONDALIC_WILLOW_FENCE_GATE.get(), 5, 20);
        flammable(BMBlocks.AVONDALIC_WILLOW_TRAPDOOR.get(), 5, 20);
        flammable(BMBlocks.AVONDALIC_WILLOW_DOOR.get(), 5, 20);
        flammable(BMBlocks.AVONDALIC_WILLOW_BUTTON.get(), 5, 20);
        flammable(BMBlocks.AVONDALIC_WILLOW_PRESSURE_PLATE.get(), 5, 20);
        flammable(BMBlocks.AVONDALIC_WILLOW_LADDER.get(), 5, 20);
        flammable(BMBlocks.AVONDALIC_WILLOW_LOG.get(), 5, 5);
        flammable(BMBlocks.STRIPPED_AVONDALIC_WILLOW_LOG.get(), 5, 5);
        flammable(BMBlocks.AVONDALIC_WILLOW_WOOD.get(), 5, 5);
        flammable(BMBlocks.STRIPPED_AVONDALIC_WILLOW_WOOD.get(), 5, 5);
        flammable(BMBlocks.AVONDALIC_WILLOW_LEAVES.get(), 30, 60);
        flammable(BMBlocks.CORK_OAK_PLANKS.get(), 5, 20);
        flammable(BMBlocks.CORK_OAK_STAIRS.get(), 5, 20);
        flammable(BMBlocks.CORK_OAK_SLAB.get(), 5, 20);
        flammable(BMBlocks.CORK_OAK_FENCE.get(), 5, 20);
        flammable(BMBlocks.CORK_OAK_FENCE_GATE.get(), 5, 20);
        flammable(BMBlocks.CORK_OAK_TRAPDOOR.get(), 5, 20);
        flammable(BMBlocks.CORK_OAK_DOOR.get(), 5, 20);
        flammable(BMBlocks.CORK_OAK_BUTTON.get(), 5, 20);
        flammable(BMBlocks.CORK_OAK_PRESSURE_PLATE.get(), 5, 20);
        flammable(BMBlocks.CORK_OAK_LADDER.get(), 5, 20);
        flammable(BMBlocks.CORK_OAK_LOG.get(), 5, 5);
        flammable(BMBlocks.STRIPPED_CORK_OAK_LOG.get(), 5, 5);
        flammable(BMBlocks.CORK_OAK_WOOD.get(), 5, 5);
        flammable(BMBlocks.STRIPPED_CORK_OAK_WOOD.get(), 5, 5);
        flammable(BMBlocks.CORK_OAK_LEAVES.get(), 30, 60);

        strippable(BMBlocks.GUAVA_LOG.get(), BMBlocks.STRIPPED_GUAVA_LOG.get());
        strippable(BMBlocks.GUAVA_WOOD.get(), BMBlocks.STRIPPED_GUAVA_WOOD.get());
        strippable(BMBlocks.GOLDENWOOD_LOG.get(), BMBlocks.STRIPPED_GOLDENWOOD_LOG.get());
        strippable(BMBlocks.GOLDENWOOD_WOOD.get(), BMBlocks.STRIPPED_GOLDENWOOD_WOOD.get());
        strippable(BMBlocks.JABUTICABA_LOG.get(), BMBlocks.STRIPPED_JABUTICABA_LOG.get());
        strippable(BMBlocks.JABUTICABA_WOOD.get(), BMBlocks.STRIPPED_JABUTICABA_WOOD.get());
        strippable(BMBlocks.AVONDALIC_WILLOW_LOG.get(), BMBlocks.STRIPPED_AVONDALIC_WILLOW_LOG.get());
        strippable(BMBlocks.AVONDALIC_WILLOW_WOOD.get(), BMBlocks.STRIPPED_AVONDALIC_WILLOW_WOOD.get());
        strippable(BMBlocks.CRYSTALLINE_BIRCH_LOG.get(), BMBlocks.STRIPPED_CRYSTALLINE_BIRCH_LOG.get());
        strippable(BMBlocks.CRYSTALLINE_BIRCH_WOOD.get(), BMBlocks.STRIPPED_CRYSTALLINE_BIRCH_WOOD.get());
        strippable(BMBlocks.CORK_OAK_LOG.get(), BMBlocks.STRIPPED_CORK_OAK_LOG.get());
        strippable(BMBlocks.CORK_OAK_WOOD.get(), BMBlocks.STRIPPED_CORK_OAK_WOOD.get());

        tillable(BMBlocks.ALJAMIC_DIRT_PATH.get(), BMBlocks.ALJAMIC_FARMLAND.get().defaultBlockState());
        tillable(BMBlocks.AVONDALIC_NYLIUM.get(), BMBlocks.ALJAMIC_FARMLAND.get().defaultBlockState());

        flattenable(BMBlocks.ALJAMIC_GRASS_BLOCK.get(), BMBlocks.ALJAMIC_DIRT_PATH.get().defaultBlockState());
        flattenable(BMBlocks.ALJAMIC_DIRT.get(), BMBlocks.ALJAMIC_DIRT_PATH.get().defaultBlockState());
        flattenable(BMBlocks.ALJAMIC_FARMLAND.get(), BMBlocks.ALJAMIC_DIRT_PATH.get().defaultBlockState());
        flattenable(BMBlocks.AVONDALIC_NYLIUM.get(), BMBlocks.ALJAMIC_DIRT_PATH.get().defaultBlockState());
    }

    public static void strippable(Block log, Block strippedLog) {
        AxeItem.STRIPABLES = Maps.newHashMap(AxeItem.STRIPABLES);
        AxeItem.STRIPABLES.put(log, strippedLog);
    }

    private static void flammable(Block block, int encouragement, int flammability) {
        FireBlock fireBlock = (FireBlock) Blocks.FIRE;
        fireBlock.setFlammable(block, encouragement, flammability);
    }

    private static void tillable(Block block, BlockState farmland) {
        HoeItem.TILLABLES = Maps.newHashMap(HoeItem.TILLABLES);
        HoeItem.TILLABLES.put(block, farmland);
    }

    private static void flattenable(Block block, BlockState path) {
        ShovelItem.FLATTENABLES = Maps.newHashMap(ShovelItem.FLATTENABLES);
        ShovelItem.FLATTENABLES.put(block, path);
    }
}
