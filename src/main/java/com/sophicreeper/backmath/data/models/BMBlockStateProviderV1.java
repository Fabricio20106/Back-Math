package com.sophicreeper.backmath.data.models;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.block.BMBlocks;
import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;

@Deprecated
public class BMBlockStateProviderV1 extends BMBlockStateModels {
    public BMBlockStateProviderV1(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, BackMath.MOD_ID, fileHelper);
    }

    @Override
    @Nonnull
    public String getName() {
        return "Back Math - Block States and Models V1";
    }

    @Override
    protected void registerStatesAndModels() {
        ResourceLocation aljanwoodPlanks = modLoc("block/aljanwood_planks");
        ResourceLocation insomnianPlanks = modLoc("block/insomnian_planks");
        ResourceLocation aljanstone = modLoc("block/aljanstone");
        ResourceLocation aljanstoneBricks = modLoc("block/aljanstone_bricks");
        ResourceLocation cobbledAljanstone = modLoc("block/cobbled_aljanstone");

        // From pre-data generation era. / From the handwritten JSON files.
        simpleBlock(BMBlocks.DEVIL_BLOCK.get());

        // Other handwritten files that, for some reason, were made there instead of here.
        // Back Math 1.8.0
        simpleBlock(BMBlocks.ALJANSTEEL_BLOCK.get(), models().cubeTop("aljansteel_block", modLoc("block/aljansteel_block"), modLoc("block/aljansteel_block_end")));

        simpleBlock(BMBlocks.DEVIL_ORE.get());
        simpleBlock(BMBlocks.NETHER_DEVIL_ORE.get());
        simpleBlock(BMBlocks.CHISELED_DEVIL_BLOCK.get());
        simpleBlock(BMBlocks.CHISELED_DEVIL_BLOCK_SOPHIE.get());
        slabBlock((SlabBlock) BMBlocks.DEVIL_SLAB.get(), modLoc("block/devil_block"), modLoc("block/devil_block"));
        stairsBlock((StairsBlock) BMBlocks.DEVIL_STAIRS.get(), modLoc("block/devil_block"));
        fenceBlock((FenceBlock) BMBlocks.DEVIL_FENCE.get(), modLoc("block/devil_block"));
        fenceGateBlock((FenceGateBlock) BMBlocks.DEVIL_FENCE_GATE.get(), modLoc("block/devil_block"));
        trapdoorBlock((TrapDoorBlock) BMBlocks.DEVIL_TRAPDOOR.get(), modLoc("block/devil_block"), true);
        wallBlock((WallBlock) BMBlocks.DEVIL_WALL.get(), modLoc("block/devil_block"));
        doorBlock((DoorBlock) BMBlocks.DEVIL_DOOR.get(), modLoc("block/devil_door_bottom"), modLoc("block/devil_door_top"));
        simpleBlock(BMBlocks.FRIED_EGG_FLOWER.get(), models().cross("cooked_egg_flower", modLoc("block/cooked_egg_flower")));
        simpleBlock(BMBlocks.RED_YELLOW_ALLIUM.get(), models().cross("red_yellow_flower", modLoc("block/red_yellow_flower")));
        trapdoorBlock((TrapDoorBlock) BMBlocks.ANGELIC_TRAPDOOR.get(), modLoc("block/angelic_trapdoor"), true);
        simpleBlock(BMBlocks.GUARANA_OAK_LEAVES.get(), models().withExistingParent("guarana_oak_leaves", modLoc("block/template_fruit_leaves")).texture("leaf",
                "backmath:block/oak_fruit_leaves").texture("fruit", "backmath:block/guarana_fruit_leaves"));
        simpleBlock(BMBlocks.MANGO_OAK_LEAVES.get(), models().withExistingParent("mango_oak_leaves", modLoc("block/template_fruit_leaves")).texture("leaf",
                "backmath:block/oak_fruit_leaves").texture("fruit", "backmath:block/mango_fruit_leaves"));
        simpleBlock(BMBlocks.GRAPE_VINE_LEAVES.get(), models().withExistingParent("grape_vine_leaves", modLoc("block/template_fruit_leaves")).texture("leaf",
                "backmath:block/spruce_fruit_leaves").texture("fruit", "backmath:block/grape_fruit_leaves"));
        simpleBlock(BMBlocks.GUARANA_OAK_SAPLING.get(), models().cross("guarana_oak_sapling", modLoc("block/guarana_oak_sapling")));
        simpleBlock(BMBlocks.MANGO_OAK_SAPLING.get(), models().cross("mango_oak_sapling", modLoc("block/mango_oak_sapling")));
        simpleBlock(BMBlocks.GRAPE_VINE_SAPLING.get(), models().cross("grape_vine_sapling", modLoc("block/grape_vine_sapling")));
        doorBlock((DoorBlock) BMBlocks.MID_TERM_DOOR.get(), modLoc("block/mid_term_door_bottom"), modLoc("block/mid_term_door_top"));
        simpleBlock(BMBlocks.MID_TERM_ORE.get());
        simpleBlock(BMBlocks.POTTED_RED_YELLOW_ALLIUM.get(), models().withExistingParent("potted_red_yellow_flower",
                "block/flower_pot_cross").texture("plant", "block/red_yellow_flower"));
        simpleBlock(BMBlocks.POTTED_FRIED_EGG_FLOWER.get(), models().withExistingParent("potted_cooked_egg_flower",
                "block/flower_pot_cross").texture("plant", "block/cooked_egg_flower"));
        simpleBlock(BMBlocks.POTTED_GUARANA_OAK_SAPLING.get(), models().withExistingParent("potted_guarana_oak_sapling",
                "block/flower_pot_cross").texture("plant", "block/guarana_oak_sapling"));
        simpleBlock(BMBlocks.POTTED_MANGO_OAK_SAPLING.get(), models().withExistingParent("potted_mango_oak_sapling",
                "block/flower_pot_cross").texture("plant", "block/mango_oak_sapling"));
        simpleBlock(BMBlocks.POTTED_GRAPE_VINE_SAPLING.get(), models().withExistingParent("potted_grape_vine_sapling",
                "block/flower_pot_cross").texture("plant", "block/grape_vine_sapling"));
        simpleBlock(BMBlocks.RAW_DEVIL_BLOCK.get());
        simpleBlock(BMBlocks.RED_YELLOW_STAINED_GLASS.get());
        paneBlock((PaneBlock) BMBlocks.RED_YELLOW_STAINED_GLASS_PANE.get(), modLoc("block/devil_stained_glass"), modLoc("block/devil_stained_glass_pane_top"));
        simpleBlock(BMBlocks.RED_YELLOW_CONCRETE.get());
        simpleBlock(BMBlocks.RED_YELLOW_CONCRETE_POWDER.get());
        simpleBlock(BMBlocks.RED_YELLOW_WOOL.get());
        simpleBlock(BMBlocks.RED_YELLOW_TERRACOTTA.get());
        horizontalBlock(BMBlocks.RED_YELLOW_GLAZED_TERRACOTTA.get(), modLoc("block/devil_glazed_terracotta"), modLoc("block/devil_glazed_terracotta"), modLoc("block/devil_glazed_terracotta"));
        simpleBlock(BMBlocks.ANGELIC_BLOCK.get());
        simpleBlock(BMBlocks.ANGELIC_ORE.get());
        simpleBlock(BMBlocks.CHRISTIAN_MID_TERM_BLOCK.get());
        simpleBlock(BMBlocks.DEVIL_ANGELIC_ALLOY_BLOCK.get(), models().withExistingParent("devil_angelic_alloy_block","block/cube_bottom_top")
                .texture("top", "block/devil_block").texture("bottom", "block/angelic_block").texture("side", "block/devil_angelic_alloy_block"));
        simpleBlock(BMBlocks.CHRISTIAN_MID_TERM_ANGELIC_ALLOY_BLOCK.get(), models().withExistingParent("christian_mid_term_angelic_alloy_block","block/cube_bottom_top")
                .texture("top", "block/christian_mid_term_block").texture("bottom", "block/angelic_block").texture("side", "block/christian_mid_term_angelic_alloy_block"));
        simpleBlock(BMBlocks.CHRISTIAN_MID_TERM_DEVIL_ALLOY_BLOCK.get(), models().withExistingParent("christian_mid_term_devil_alloy_block","block/cube_bottom_top")
                .texture("top", "block/christian_mid_term_block").texture("bottom", "block/devil_block").texture("side", "block/christian_mid_term_devil_alloy_block"));

        simpleBlock(BMBlocks.HILLARY_TORCH.get(), models().torch("hillary_torch", modLoc("block/hillary_torch")));
        getVariantBuilder(BMBlocks.HILLARY_WALL_TORCH.get()).forAllStates(state -> ConfiguredModel.builder().modelFile(wallTorch("hillary_wall_torch",
                        modLoc("block/hillary_torch"))).rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 90).build());
        simpleBlock(BMBlocks.RAW_ANGELIC_BLOCK.get());
        simpleBlock(BMBlocks.RAW_MID_TERM_BLOCK.get());
        simpleBlock(BMBlocks.DEEPSLATE_ANGELIC_ORE.get());
        simpleBlock(BMBlocks.DEEPSLATE_DEVIL_ORE.get());
        simpleBlock(BMBlocks.OBSIDIAN_MID_TERM_ORE.get());
        simpleBlock(BMBlocks.ALJAME_BIRCH_LEAVES.get(), models().withExistingParent("aljame_birch_leaves", modLoc("block/template_fruit_leaves")).texture("leaf",
                "backmath:block/birch_fruit_leaves").texture("fruit", "backmath:block/aljame_fruit_leaves"));
        simpleBlock(BMBlocks.POTTED_ALJAME_BIRCH_SAPLING.get(), models().withExistingParent("potted_aljame_birch_sapling",
                "block/flower_pot_cross").texture("plant", "block/aljame_birch_sapling"));
        simpleBlock(BMBlocks.ALJAME_BIRCH_SAPLING.get(), models().cross("aljame_birch_sapling", modLoc("block/aljame_birch_sapling")));
        simpleBlock(BMBlocks.LEMON_OAK_LEAVES.get(), models().withExistingParent("lemon_oak_leaves", modLoc("block/template_fruit_leaves")).texture("leaf",
                "backmath:block/oak_fruit_leaves").texture("fruit", "backmath:block/lemon_fruit_leaves"));
        simpleBlock(BMBlocks.POTTED_LEMON_OAK_SAPLING.get(), models().withExistingParent("potted_lemon_oak_sapling",
                "block/flower_pot_cross").texture("plant", "block/lemon_oak_sapling"));
        simpleBlock(BMBlocks.LEMON_OAK_SAPLING.get(), models().cross("lemon_oak_sapling", modLoc("block/lemon_oak_sapling")));
        simpleBlock(BMBlocks.CRYSTALLINE_ANGELIC_ORE.get());
        doorBlock((DoorBlock) BMBlocks.ANGELIC_DOOR.get(), modLoc("block/angelic_door_bottom"), modLoc("block/angelic_door_top"));
        simpleBlock(BMBlocks.ANGELICAL_CASING.get());
        simpleBlock(BMBlocks.DEVIL_BRICKS.get());
        stairsBlock((StairsBlock) BMBlocks.DEVIL_BRICK_STAIRS.get(), modLoc("block/devil_bricks"));
        slabBlock((SlabBlock) BMBlocks.DEVIL_BRICK_SLAB.get(), modLoc("block/devil_bricks"), modLoc("block/devil_bricks"));
        wallBlock((WallBlock) BMBlocks.DEVIL_BRICK_WALL.get(), modLoc("block/devil_bricks"));
        simpleBlock(BMBlocks.PINEAPPLE_OAK_LEAVES.get(), models().withExistingParent("pineapple_oak_leaves", modLoc("block/template_fruit_leaves")).texture("leaf",
                "backmath:block/oak_fruit_leaves").texture("fruit", "backmath:block/pineapple_fruit_leaves"));
        simpleBlock(BMBlocks.PINEAPPLE_OAK_SAPLING.get(), models().cross("pineapple_oak_sapling", modLoc("block/pineapple_oak_sapling")));
        simpleBlock(BMBlocks.POTTED_PINEAPPLE_OAK_SAPLING.get(), models().withExistingParent("potted_pineapple_oak_sapling",
                "block/flower_pot_cross").texture("plant", "block/pineapple_oak_sapling"));
        simpleBlock(BMBlocks.CRYSTALLINE_BIRCH_PLANKS.get());
        axisBlock((RotatedPillarBlock) BMBlocks.CRYSTALLINE_BIRCH_LOG.get(), modLoc("block/crystalline_birch_log"), modLoc("block/crystalline_birch_log_top"));
        axisBlock((RotatedPillarBlock) BMBlocks.CRYSTALLINE_BIRCH_WOOD.get(), modLoc("block/crystalline_birch_log"), modLoc("block/crystalline_birch_log"));
        simpleBlock(BMBlocks.CRYSTALLINE_BIRCH_LEAVES.get());
        simpleBlock(BMBlocks.CRYSTALLINE_BIRCH_SAPLING.get(), models().cross("crystalline_birch_sapling", modLoc("block/crystalline_birch_sapling")));
        trapdoorBlock((TrapDoorBlock) BMBlocks.CRYSTALLINE_BIRCH_TRAPDOOR.get(), modLoc("block/crystalline_birch_trapdoor"), true);
        doorBlock((DoorBlock) BMBlocks.CRYSTALLINE_BIRCH_DOOR.get(), modLoc("block/crystalline_birch_door_bottom"), modLoc("block/crystalline_birch_door_top"));
        simpleBlock(BMBlocks.ANGELIC_BRICKS.get());
        simpleBlock(BMBlocks.CRACKED_ANGELIC_BRICKS.get());
        stairsBlock((StairsBlock) BMBlocks.ANGELIC_BRICK_STAIRS.get(), modLoc("block/angelic_bricks"));
        slabBlock((SlabBlock) BMBlocks.ANGELIC_BRICK_SLAB.get(), modLoc("block/angelic_bricks"), modLoc("block/angelic_bricks"));
        wallBlock((WallBlock) BMBlocks.ANGELIC_BRICK_WALL.get(), modLoc("block/angelic_bricks"));
        stairsBlock((StairsBlock) BMBlocks.CRYSTALLINE_BIRCH_STAIRS.get(), modLoc("block/crystalline_birch_planks"));
        slabBlock((SlabBlock) BMBlocks.CRYSTALLINE_BIRCH_SLAB.get(), modLoc("block/crystalline_birch_planks"), modLoc("block/crystalline_birch_planks"));
        fenceBlock((FenceBlock) BMBlocks.CRYSTALLINE_BIRCH_FENCE.get(), modLoc("block/crystalline_birch_planks"));
        fenceGateBlock((FenceGateBlock) BMBlocks.CRYSTALLINE_BIRCH_FENCE_GATE.get(), modLoc("block/crystalline_birch_planks"));

        // Todo: Back Math 1.7.0
        simpleBlock(BMBlocks.ALJANSTONE.get());
        simpleBlock(BMBlocks.ALJAMEED_ORE.get());
        simpleBlock(BMBlocks.ALJAMEED_BLOCK.get());
        simpleBlock(BMBlocks.RAW_ALJAMEED_BLOCK.get());
        simpleBlock(BMBlocks.MOONERING_ORE.get());
        simpleBlock(BMBlocks.MOONERING_BLOCK.get());
        simpleBlock(BMBlocks.RAW_MOONER_BLOCK.get());
        simpleBlock(BMBlocks.ALJANWOOD_PLANKS.get());
        simpleBlock(BMBlocks.ALJANCAP_PLANKS.get());
        stairsBlock((StairsBlock) BMBlocks.ALJANSTONE_STAIRS.get(), aljanstone);
        slabBlock((SlabBlock) BMBlocks.ALJANSTONE_SLAB.get(), aljanstone, aljanstone);
        simpleBlock(BMBlocks.ALJANSTONE_BRICKS.get());
        stairsBlock((StairsBlock) BMBlocks.ALJANSTONE_BRICK_STAIRS.get(), aljanstoneBricks);
        slabBlock((SlabBlock) BMBlocks.ALJANSTONE_BRICK_SLAB.get(), aljanstoneBricks, aljanstoneBricks);
        wallBlock((WallBlock) BMBlocks.ALJANSTONE_BRICK_WALL.get(), aljanstoneBricks);
        simpleBlock(BMBlocks.SMOOTH_ALJANSTONE.get());
        slabBlock((SlabBlock) BMBlocks.SMOOTH_ALJANSTONE_SLAB.get(), modLoc("block/smooth_aljanstone"), modLoc("block/smooth_aljanstone"));
        simpleBlock(BMBlocks.COBBLED_ALJANSTONE.get());
        stairsBlock((StairsBlock) BMBlocks.COBBLED_ALJANSTONE_STAIRS.get(), cobbledAljanstone);
        slabBlock((SlabBlock) BMBlocks.COBBLED_ALJANSTONE_SLAB.get(), cobbledAljanstone, cobbledAljanstone);
        wallBlock((WallBlock) BMBlocks.COBBLED_ALJANSTONE_WALL.get(), cobbledAljanstone);
        axisBlock((RotatedPillarBlock) BMBlocks.ALJANWOOD_LOG.get(), modLoc("block/aljanwood_log"), modLoc("block/aljanwood_log_top"));
        axisBlock((RotatedPillarBlock) BMBlocks.ALJANWOOD_WOOD.get(), modLoc("block/aljanwood_log"), modLoc("block/aljanwood_log"));
        axisBlock((RotatedPillarBlock) BMBlocks.STRIPPED_ALJANWOOD_LOG.get(), modLoc("block/stripped_aljanwood_log"), modLoc("block/stripped_aljanwood_log_top"));
        axisBlock((RotatedPillarBlock) BMBlocks.STRIPPED_ALJANWOOD_WOOD.get(), modLoc("block/stripped_aljanwood_log"), modLoc("block/stripped_aljanwood_log"));
        simpleBlock(BMBlocks.ALJANWOOD_LEAVES.get(), models().withExistingParent("aljanwood_leaves", mcLoc("block/leaves")).texture("all",
                "minecraft:block/oak_leaves"));
        stairsBlock((StairsBlock) BMBlocks.ALJANWOOD_STAIRS.get(), aljanwoodPlanks);
        slabBlock((SlabBlock) BMBlocks.ALJANWOOD_SLAB.get(), aljanwoodPlanks, aljanwoodPlanks);
        trapdoorBlock((TrapDoorBlock) BMBlocks.ALJANWOOD_TRAPDOOR.get(), modLoc("block/aljanwood_trapdoor"), true);
        simpleBlock(BMBlocks.ALJANWOOD_SAPLING.get(), models().cross("aljanwood_sapling", modLoc("block/aljanwood_sapling")));
        simpleBlock(BMBlocks.TURTLE_FRIED_EGG_FLOWER.get(), models().cross("turtle_fried_egg_flower", modLoc("block/turtle_fried_egg_flower")));
        simpleBlock(BMBlocks.POTTED_TURTLE_FRIED_EGG_FLOWER.get(), models().withExistingParent("potted_turtle_fried_egg_flower",
                "block/flower_pot_cross").texture("plant", "block/turtle_fried_egg_flower"));
        simpleBlock(BMBlocks.POTTED_ALJANWOOD_SAPLING.get(), models().withExistingParent("potted_aljanwood_sapling",
                "block/flower_pot_cross").texture("plant", "block/aljanwood_sapling"));
        simpleBlock(BMBlocks.POTTED_CRYSTALLINE_BIRCH_SAPLING.get(), models().withExistingParent("potted_crystalline_birch_sapling",
                "block/flower_pot_cross").texture("plant", "block/crystalline_birch_sapling"));
        doorBlock((DoorBlock) BMBlocks.ALJANWOOD_DOOR.get(), modLoc("block/aljanwood_door_bottom"), modLoc("block/aljanwood_door_top"));
        simpleBlock(BMBlocks.ALJAN_TULIP.get(), models().cross("aljan_tulip", modLoc("block/aljan_tulip")));
        simpleBlock(BMBlocks.POISON_ROSE.get(), models().cross("poison_rose", modLoc("block/poison_rose")));
        simpleBlock(BMBlocks.ALJANSHROOM.get(), models().cross("aljanshroom", modLoc("block/aljanshroom")));
        simpleBlock(BMBlocks.SLEEPSHROOM.get(), models().cross("sleepshroom", modLoc("block/sleepshroom")));
        simpleBlock(BMBlocks.POTTED_ALJAN_TULIP.get(), models().withExistingParent("potted_aljan_tulip",
                "block/flower_pot_cross").texture("plant", "block/aljan_tulip"));
        simpleBlock(BMBlocks.POTTED_POISON_ROSE.get(), models().withExistingParent("potted_poison_rose",
                "block/flower_pot_cross").texture("plant", "block/poison_rose"));
        simpleBlock(BMBlocks.POTTED_ALJANSHROOM.get(), models().withExistingParent("potted_aljanshroom",
                "block/flower_pot_cross").texture("plant", "block/aljanshroom"));
        simpleBlock(BMBlocks.POTTED_SLEEPSHROOM.get(), models().withExistingParent("potted_sleepshroom",
                "block/flower_pot_cross").texture("plant", "block/sleepshroom"));
        doorBlock((DoorBlock) BMBlocks.OBSIDIAN_INFUSED_MID_TERM_DOOR.get(), modLoc("block/obsidian_infused_mid_term_door_bottom"), modLoc("block/obsidian_infused_mid_term_door_top"));
        trapdoorBlock((TrapDoorBlock) BMBlocks.MID_TERM_TRAPDOOR.get(), modLoc("block/mid_term_trapdoor"), true);
        trapdoorBlock((TrapDoorBlock) BMBlocks.OBSIDIAN_INFUSED_MID_TERM_TRAPDOOR.get(), modLoc("block/obsidian_infused_mid_term_trapdoor"), true);
        simpleBlock(BMBlocks.CHARJAN_COAL_BLOCK.get());
        wallBlock((WallBlock) BMBlocks.ALJANSTONE_WALL.get(), aljanstone);
        simpleBlock(BMBlocks.SLEEPINGSTONE.get());
        simpleBlock(BMBlocks.POLISHED_SLEEPINGSTONE.get());
        simpleBlock(BMBlocks.SLEEPINGSTONE_BRICKS.get());
        slabBlock((SlabBlock) BMBlocks.SLEEPINGSTONE_SLAB.get(), modLoc("block/sleepingstone"), modLoc("block/sleepingstone"));
        slabBlock((SlabBlock) BMBlocks.SLEEPINGSTONE_BRICK_SLAB.get(), modLoc("block/sleepingstone_bricks"), modLoc("block/sleepingstone_bricks"));
        slabBlock((SlabBlock) BMBlocks.POLISHED_SLEEPINGSTONE_SLAB.get(), modLoc("block/polished_sleepingstone"), modLoc("block/polished_sleepingstone"));
        stairsBlock((StairsBlock) BMBlocks.SLEEPINGSTONE_STAIRS.get(), modLoc("block/sleepingstone"));
        stairsBlock((StairsBlock) BMBlocks.SLEEPINGSTONE_BRICK_STAIRS.get(), modLoc("block/sleepingstone_bricks"));
        stairsBlock((StairsBlock) BMBlocks.POLISHED_SLEEPINGSTONE_STAIRS.get(), modLoc("block/polished_sleepingstone"));
        wallBlock((WallBlock) BMBlocks.SLEEPINGSTONE_WALL.get(), modLoc("block/sleepingstone"));
        wallBlock((WallBlock) BMBlocks.SLEEPINGSTONE_BRICK_WALL.get(), modLoc("block/sleepingstone_bricks"));
        wallBlock((WallBlock) BMBlocks.POLISHED_SLEEPINGSTONE_WALL.get(), modLoc("block/polished_sleepingstone"));
        stairsBlock((StairsBlock) BMBlocks.ALJANCAP_STAIRS.get(), modLoc("block/aljancap_planks"));
        slabBlock((SlabBlock) BMBlocks.ALJANCAP_SLAB.get(), modLoc("block/aljancap_planks"), modLoc("block/aljancap_planks"));
        fenceBlock((FenceBlock) BMBlocks.ALJANCAP_FENCE.get(), modLoc("block/aljancap_planks"));
        fenceGateBlock((FenceGateBlock) BMBlocks.ALJANCAP_FENCE_GATE.get(), modLoc("block/aljancap_planks"));
        fenceBlock((FenceBlock) BMBlocks.ALJANWOOD_FENCE.get(), modLoc("block/aljanwood_planks"));
        fenceGateBlock((FenceGateBlock) BMBlocks.ALJANWOOD_FENCE_GATE.get(), modLoc("block/aljanwood_planks"));
        axisBlock((RotatedPillarBlock) BMBlocks.INSOMNIAN_LOG.get(), modLoc("block/insomnian_log"), modLoc("block/insomnian_log_top"));
        axisBlock((RotatedPillarBlock) BMBlocks.INSOMNIAN_WOOD.get(), modLoc("block/insomnian_log"), modLoc("block/insomnian_log"));
        simpleBlock(BMBlocks.INSOMNIAN_LEAVES.get(), models().withExistingParent("insomnian_leaves", mcLoc("block/leaves")).texture("all",
                "minecraft:block/oak_leaves"));
        simpleBlock(BMBlocks.INSOMNIAN_SAPLING.get(), models().cross("insomnian_sapling", modLoc("block/insomnian_sapling")));
        simpleBlock(BMBlocks.INSOMNIAN_PLANKS.get());
        stairsBlock((StairsBlock) BMBlocks.INSOMNIAN_STAIRS.get(), insomnianPlanks);
        slabBlock((SlabBlock) BMBlocks.INSOMNIAN_SLAB.get(), insomnianPlanks, insomnianPlanks);
        fenceBlock((FenceBlock) BMBlocks.INSOMNIAN_FENCE.get(), insomnianPlanks);
        fenceGateBlock((FenceGateBlock) BMBlocks.INSOMNIAN_FENCE_GATE.get(), insomnianPlanks);
        simpleBlock(BMBlocks.POTTED_INSOMNIAN_SAPLING.get(), models().withExistingParent("potted_insomnian_sapling",
                "block/flower_pot_cross").texture("plant", "block/insomnian_sapling"));
        simpleBlock(BMBlocks.POTTED_INSOMNIAN_TULIP.get(), models().withExistingParent("potted_insomnian_tulip",
                "block/flower_pot_cross").texture("plant", "block/insomnian_tulip"));
        axisBlock((RotatedPillarBlock) BMBlocks.STRIPPED_INSOMNIAN_LOG.get(), modLoc("block/stripped_insomnian_log"), modLoc("block/stripped_insomnian_log_top"));
        axisBlock((RotatedPillarBlock) BMBlocks.STRIPPED_INSOMNIAN_WOOD.get(), modLoc("block/stripped_insomnian_log"), modLoc("block/stripped_insomnian_log"));
        axisBlock((RotatedPillarBlock) BMBlocks.ALJANCAP_LOG.get(), modLoc("block/aljancap_log"), modLoc("block/aljancap_log_top"));
        axisBlock((RotatedPillarBlock) BMBlocks.ALJANCAP_WOOD.get(), modLoc("block/aljancap_log"), modLoc("block/aljancap_log"));
        axisBlock((RotatedPillarBlock) BMBlocks.STRIPPED_ALJANCAP_LOG.get(), modLoc("block/stripped_aljancap_log"), modLoc("block/stripped_aljancap_log_top"));
        axisBlock((RotatedPillarBlock) BMBlocks.STRIPPED_ALJANCAP_WOOD.get(), modLoc("block/stripped_aljancap_log"), modLoc("block/stripped_aljancap_log"));
        simpleBlock(BMBlocks.JANTIC_ORE.get());
        simpleBlock(BMBlocks.ALJANCAP_LEAVES.get(), models().withExistingParent("aljancap_leaves", mcLoc("block/leaves")).texture("all",
                "minecraft:block/oak_leaves"));
        simpleBlock(BMBlocks.ALJANCAP_SAPLING.get(), models().cross("aljancap_sapling", modLoc("block/aljancap_sapling")));
        simpleBlock(BMBlocks.POTTED_ALJANCAP_SAPLING.get(), models().withExistingParent("potted_aljancap_sapling", "block/flower_pot_cross").texture("plant", "block/aljancap_sapling"));
        simpleBlock(BMBlocks.ALJAMIC_DIRT.get());
        simpleBlock(BMBlocks.CHISELED_ALJANSTONE_FABRICIO.get());
        simpleBlock(BMBlocks.CHISELED_ALJANSTONE_JUNE.get());
        simpleBlock(BMBlocks.CHISELED_ALJANSTONE_SOPHIE.get());
        simpleBlock(BMBlocks.CHISELED_ALJANSTONE_LUCIA.get());
        simpleBlock(BMBlocks.CHISELED_ALJANSTONE_CREEPER.get());
        simpleBlock(BMBlocks.CHISELED_SLEEPINGSTONE_FABRICIO.get());
        simpleBlock(BMBlocks.CHISELED_SLEEPINGSTONE_JUNE.get());
        simpleBlock(BMBlocks.CHISELED_SLEEPINGSTONE_SOPHIE.get());
        simpleBlock(BMBlocks.CHISELED_SLEEPINGSTONE_LUCIA.get());
        simpleBlock(BMBlocks.CHISELED_SLEEPINGSTONE_CREEPER.get());
        simpleBlock(BMBlocks.SLEEPYSHROOM.get(), models().cross("sleepyshroom", modLoc("block/sleepyshroom")));
        simpleBlock(BMBlocks.POTTED_SLEEPYSHROOM.get(), models().withExistingParent("potted_sleepyshroom", "block/flower_pot_cross").texture("plant", "block/sleepyshroom"));
        simpleBlock(BMBlocks.ORANGE_OAK_LEAVES.get(), models().withExistingParent("orange_oak_leaves", modLoc("block/template_fruit_leaves")).texture("leaf",
                "backmath:block/oak_fruit_leaves").texture("fruit", "backmath:block/orange_fruit_leaves"));
        simpleBlock(BMBlocks.BANANA_JUNGLE_LEAVES.get(), models().withExistingParent("banana_jungle_leaves", modLoc("block/template_fruit_leaves")).texture("leaf",
                "backmath:block/jungle_fruit_leaves").texture("fruit", "backmath:block/banana_fruit_leaves"));
        simpleBlock(BMBlocks.ORANGE_OAK_SAPLING.get(), models().cross("orange_oak_sapling", modLoc("block/orange_oak_sapling")));
        simpleBlock(BMBlocks.BANANA_JUNGLE_SAPLING.get(), models().cross("banana_jungle_sapling", modLoc("block/banana_jungle_sapling")));
        simpleBlock(BMBlocks.POTTED_ORANGE_OAK_SAPLING.get(), models().withExistingParent("potted_orange_oak_sapling", "block/flower_pot_cross").texture("plant", "block/orange_oak_sapling"));
        simpleBlock(BMBlocks.POTTED_BANANA_JUNGLE_SAPLING.get(), models().withExistingParent("potted_banana_jungle_sapling", "block/flower_pot_cross").texture("plant", "block/banana_jungle_sapling"));
        simpleBlock(BMBlocks.CRYSTALLINE_ANGELIC_BLOCK.get());
        simpleBlock(BMBlocks.CHARJAN_WOOD_TORCH.get(), models().torch("charjan_wood_torch", modLoc("block/charjan_wood_torch")));
        getVariantBuilder(BMBlocks.CHARJAN_WOOD_WALL_TORCH.get()).forAllStates(state -> ConfiguredModel.builder().modelFile(wallTorch("charjan_wood_wall_torch",
                modLoc("block/charjan_wood_torch"))).rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 90).build());
        simpleBlock(BMBlocks.CHARJAN_ALJANWOOD_TORCH.get(), models().torch("charjan_aljanwood_torch", modLoc("block/charjan_aljanwood_torch")));
        getVariantBuilder(BMBlocks.CHARJAN_ALJANWOOD_WALL_TORCH.get()).forAllStates(state -> ConfiguredModel.builder().modelFile(wallTorch("charjan_aljanwood_wall_torch",
                modLoc("block/charjan_aljanwood_torch"))).rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 90).build());
        simpleBlock(BMBlocks.CHARJAN_ALJANCAP_TORCH.get(), models().torch("charjan_aljancap_torch", modLoc("block/charjan_aljancap_torch")));
        getVariantBuilder(BMBlocks.CHARJAN_ALJANCAP_WALL_TORCH.get()).forAllStates(state -> ConfiguredModel.builder().modelFile(wallTorch("charjan_aljancap_wall_torch",
                modLoc("block/charjan_aljancap_torch"))).rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 90).build());
        simpleBlock(BMBlocks.CHARJAN_INSOMNIAN_TORCH.get(), models().torch("charjan_insomnian_torch", modLoc("block/charjan_insomnian_torch")));
        getVariantBuilder(BMBlocks.CHARJAN_INSOMNIAN_WALL_TORCH.get()).forAllStates(state -> ConfiguredModel.builder().modelFile(wallTorch("charjan_insomnian_wall_torch",
                modLoc("block/charjan_insomnian_torch"))).rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 90).build());
        simpleBlock(BMBlocks.AMARACAP_LEAVES.get(), models().withExistingParent("amaracap_leaves", mcLoc("block/leaves")).texture("all",
                "minecraft:block/acacia_leaves"));
        simpleBlock(BMBlocks.INSOGRAVEL.get());
        simpleBlock(BMBlocks.ALJAMIC_COPPER_ORE.get());
        simpleBlock(BMBlocks.ALJAMIC_TIN_ORE.get());
        simpleBlock(BMBlocks.SLEEPINGSTONE_ALJAMEED_ORE.get());
        simpleBlock(BMBlocks.SLEEPINGSTONE_MOONERING_ORE.get());
        simpleBlock(BMBlocks.SLEEPINGSTONE_JANTIC_ORE.get());
        simpleBlock(BMBlocks.SLEEPINGSTONE_ALJAMIC_COPPER_ORE.get());
        simpleBlock(BMBlocks.SLEEPINGSTONE_ALJAMIC_TIN_ORE.get());

        getVariantBuilder(BMBlocks.ALJAMIC_ONIONS.get()).forAllStates(state -> {
            int cropAgeIndex = potatoAgeIndex(state.getValue(CropsBlock.AGE));
            return ConfiguredModel.builder().modelFile(models().crop("aljamic_onions_stage" + cropAgeIndex, modLoc("block/aljamic_onions_stage" + cropAgeIndex))).build();
        });
        getVariantBuilder(BMBlocks.CARAMELED_WHEAT.get()).forAllStates(state -> {
            int cropAgeIndex = wheatAgeIndex(state.getValue(CropsBlock.AGE));
            return ConfiguredModel.builder().modelFile(models().crop("carameled_wheat_stage" + cropAgeIndex, modLoc("block/carameled_wheat_stage" + cropAgeIndex))).build();
        });
        simpleBlock(BMBlocks.WILD_CARAMELED_WHEAT.get(), models().withExistingParent("wild_carameled_wheat", "backmath:block/template_wild_crop").texture("crop", "block/wild_carameled_wheat"));

        // TODO: Back Math 1.8.0:
        horizontalBlock(BMBlocks.GLAZED_TABU.get(), modLoc("block/glazed_tabu"), modLoc("block/glazed_tabu"), modLoc("block/glazed_tabu"));
        simpleBlock(BMBlocks.CUBIC_TABU.get());
        stairsBlock((StairsBlock) BMBlocks.CUBIC_TABU_STAIRS.get(), modLoc("block/cubic_tabu"));
        slabBlock((SlabBlock) BMBlocks.CUBIC_TABU_SLAB.get(), modLoc("block/cubic_tabu"), modLoc("block/cubic_tabu"));
        simpleBlock(BMBlocks.TABU_MOSAIC.get());
        stairsBlock((StairsBlock) BMBlocks.TABU_MOSAIC_STAIRS.get(), modLoc("block/tabu_mosaic"));
        slabBlock((SlabBlock) BMBlocks.TABU_MOSAIC_SLAB.get(), modLoc("block/tabu_mosaic"), modLoc("block/tabu_mosaic"));
        axisBlock((RotatedPillarBlock) BMBlocks.TABU_PILLAR.get(), modLoc("block/tabu_pillar"), modLoc("block/tabu_pillar_top"));

        simpleBlock(BMBlocks.HILLARIED_STONE.get());
        stairsBlock((StairsBlock) BMBlocks.HILLARIED_STONE_STAIRS.get(), modLoc("block/hillaried_stone"));
        slabBlock((SlabBlock) BMBlocks.HILLARIED_STONE_SLAB.get(), modLoc("block/hillaried_stone"), modLoc("block/hillaried_stone"));
        wallBlock((WallBlock) BMBlocks.HILLARIED_STONE_WALL.get(), modLoc("block/hillaried_stone"));
        simpleBlock(BMBlocks.CHISELED_HILLARIED_STONE.get());
        simpleBlock(BMBlocks.CHISELED_HILLARIED_STONE_BUCKET.get());
        axisBlock((RotatedPillarBlock) BMBlocks.HILLARIED_STONE_PILLAR.get(), modLoc("block/hillaried_stone_pillar"), modLoc("block/hillaried_stone_pillar_top"));

        simpleBlock(BMBlocks.GUAVA_LEAVES.get());
        simpleBlock(BMBlocks.GUAVA_SAPLING.get(), models().cross("guava_sapling", modLoc("block/guava_sapling")));
        simpleBlock(BMBlocks.POTTED_GUAVA_SAPLING.get(), models().withExistingParent("potted_guava_sapling", "block/flower_pot_cross").texture("plant", "block/guava_sapling"));
        axisBlock((RotatedPillarBlock) BMBlocks.GUAVA_LOG.get(), modLoc("block/guava_log"), modLoc("block/guava_log_top"));
        axisBlock((RotatedPillarBlock) BMBlocks.GUAVA_WOOD.get(), modLoc("block/guava_log"), modLoc("block/guava_log"));
        axisBlock((RotatedPillarBlock) BMBlocks.STRIPPED_GUAVA_LOG.get(), modLoc("block/stripped_guava_log"), modLoc("block/stripped_guava_log_top"));
        axisBlock((RotatedPillarBlock) BMBlocks.STRIPPED_GUAVA_WOOD.get(), modLoc("block/stripped_guava_log"), modLoc("block/stripped_guava_log"));
        simpleBlock(BMBlocks.GUAVA_PLANKS.get());
        stairsBlock((StairsBlock) BMBlocks.GUAVA_STAIRS.get(), modLoc("block/guava_planks"));
        slabBlock((SlabBlock) BMBlocks.GUAVA_SLAB.get(), modLoc("block/guava_planks"), modLoc("block/guava_planks"));
        fenceBlock((FenceBlock) BMBlocks.GUAVA_FENCE.get(), modLoc("block/guava_planks"));
        fenceGateBlock((FenceGateBlock) BMBlocks.GUAVA_FENCE_GATE.get(), modLoc("block/guava_planks"));
        doorBlock((DoorBlock) BMBlocks.GUAVA_DOOR.get(), modLoc("block/guava_door_bottom"), modLoc("block/guava_door_top"));
        trapdoorBlock((TrapDoorBlock) BMBlocks.GUAVA_TRAPDOOR.get(), modLoc("block/guava_trapdoor"), true);

        simpleBlock(BMBlocks.MANGAED_MANGO_OAK_LEAVES.get(), models().withExistingParent("mangaed_mango_oak_leaves", modLoc("block/template_fruit_leaves")).texture("leaf",
                "backmath:block/oak_fruit_leaves").texture("fruit", "backmath:block/mangaed_mango_fruit_leaves"));
        simpleBlock(BMBlocks.MANGAED_MANGO_OAK_SAPLING.get(), models().cross("mangaed_mango_oak_sapling", modLoc("block/mangaed_mango_oak_sapling")));
        simpleBlock(BMBlocks.POTTED_MANGAED_MANGO_OAK_SAPLING.get(), models().withExistingParent("potted_mangaed_mango_oak_sapling", "block/flower_pot_cross").texture("plant", "block/mangaed_mango_oak_sapling"));
        simpleBlock(BMBlocks.ALJAMIC_SAND.get());
        simpleBlock(BMBlocks.ALJAMIC_GLASS.get());
        paneBlock((PaneBlock) BMBlocks.ALJAMIC_GLASS_PANE.get(), modLoc("block/aljamic_glass"), modLoc("block/aljamic_glass_pane_top"));
        simpleBlock(BMBlocks.JANTICAL_BLOCK.get(), models().cubeBottomTop("jantical_block", modLoc("block/jantical_block_side"), modLoc("block/jantical_block_bottom"), modLoc("block/jantical_block_top")));
        simpleBlock(BMBlocks.WILD_ALJAMIC_ONIONS.get(), models().withExistingParent("wild_aljamic_onions", "backmath:block/template_wild_crop").texture("crop", "block/wild_aljamic_onions"));
        simpleBlock(BMBlocks.ENDER_DRAGON_FRIED_EGG_FLOWER.get(), models().cross("ender_dragon_fried_egg_flower", modLoc("block/ender_dragon_fried_egg_flower")));
        simpleBlock(BMBlocks.POTTED_ENDER_DRAGON_FRIED_EGG_FLOWER.get(), models().withExistingParent("potted_ender_dragon_fried_egg_flower",
                "block/flower_pot_cross").texture("plant", "block/ender_dragon_fried_egg_flower"));
        simpleBlock(BMBlocks.RAW_ALJAMIC_COPPER_BLOCK.get());
        simpleBlock(BMBlocks.RAW_ALJAMIC_TIN_BLOCK.get());

        simpleBlock(BMBlocks.GOLDENWOOD_LEAVES.get());
        simpleBlock(BMBlocks.ENCHANTED_GOLDENWOOD_LEAVES.get());
        simpleBlock(BMBlocks.GOLDENWOOD_SAPLING.get(), models().cross("goldenwood_sapling", modLoc("block/goldenwood_sapling")));
        simpleBlock(BMBlocks.ENCHANTED_GOLDENWOOD_SAPLING.get(), models().cross("enchanted_goldenwood_sapling", modLoc("block/enchanted_goldenwood_sapling")));
        simpleBlock(BMBlocks.POTTED_GOLDENWOOD_SAPLING.get(), models().withExistingParent("potted_goldenwood_sapling", "block/flower_pot_cross").texture("plant", "block/goldenwood_sapling"));
        simpleBlock(BMBlocks.POTTED_ENCHANTED_GOLDENWOOD_SAPLING.get(), models().withExistingParent("potted_enchanted_goldenwood_sapling", "block/flower_pot_cross").texture("plant", "block/enchanted_goldenwood_sapling"));
        axisBlock((RotatedPillarBlock) BMBlocks.GOLDENWOOD_LOG.get(), modLoc("block/goldenwood_log"), modLoc("block/goldenwood_log_top"));
        axisBlock((RotatedPillarBlock) BMBlocks.GOLDENWOOD_WOOD.get(), modLoc("block/goldenwood_log"), modLoc("block/goldenwood_log"));
        axisBlock((RotatedPillarBlock) BMBlocks.STRIPPED_GOLDENWOOD_LOG.get(), modLoc("block/stripped_goldenwood_log"), modLoc("block/stripped_goldenwood_log_top"));
        axisBlock((RotatedPillarBlock) BMBlocks.STRIPPED_GOLDENWOOD_WOOD.get(), modLoc("block/stripped_goldenwood_log"), modLoc("block/stripped_goldenwood_log"));
        simpleBlock(BMBlocks.GOLDENWOOD_PLANKS.get());
        stairsBlock((StairsBlock) BMBlocks.GOLDENWOOD_STAIRS.get(), modLoc("block/goldenwood_planks"));
        slabBlock((SlabBlock) BMBlocks.GOLDENWOOD_SLAB.get(), modLoc("block/goldenwood_planks"), modLoc("block/goldenwood_planks"));
        fenceBlock((FenceBlock) BMBlocks.GOLDENWOOD_FENCE.get(), modLoc("block/goldenwood_planks"));
        fenceGateBlock((FenceGateBlock) BMBlocks.GOLDENWOOD_FENCE_GATE.get(), modLoc("block/goldenwood_planks"));
        doorBlock((DoorBlock) BMBlocks.GOLDENWOOD_DOOR.get(), modLoc("block/goldenwood_door_bottom"), modLoc("block/goldenwood_door_top"));
        trapdoorBlock((TrapDoorBlock) BMBlocks.GOLDENWOOD_TRAPDOOR.get(), modLoc("block/goldenwood_trapdoor"), true);

        simpleBlock(BMBlocks.AVONDALIC_WILLOW_LEAVES.get(), models().withExistingParent("avondalic_willow_leaves", mcLoc("block/leaves")).texture("all",
                "minecraft:block/acacia_leaves"));
        simpleBlock(BMBlocks.AVONDALIC_WILLOW_SAPLING.get(), models().cross("avondalic_willow_sapling", modLoc("block/avondalic_willow_sapling")));
        simpleBlock(BMBlocks.POTTED_AVONDALIC_WILLOW_SAPLING.get(), models().withExistingParent("potted_avondalic_willow_sapling", "block/flower_pot_cross").texture("plant", "block/avondalic_willow_sapling"));
        axisBlock((RotatedPillarBlock) BMBlocks.AVONDALIC_WILLOW_LOG.get(), modLoc("block/avondalic_willow_log"), modLoc("block/avondalic_willow_log_top"));
        axisBlock((RotatedPillarBlock) BMBlocks.AVONDALIC_WILLOW_WOOD.get(), modLoc("block/avondalic_willow_log"), modLoc("block/avondalic_willow_log"));
        axisBlock((RotatedPillarBlock) BMBlocks.STRIPPED_AVONDALIC_WILLOW_LOG.get(), modLoc("block/stripped_avondalic_willow_log"), modLoc("block/stripped_avondalic_willow_log_top"));
        axisBlock((RotatedPillarBlock) BMBlocks.STRIPPED_AVONDALIC_WILLOW_WOOD.get(), modLoc("block/stripped_avondalic_willow_log"), modLoc("block/stripped_avondalic_willow_log"));
        simpleBlock(BMBlocks.AVONDALIC_WILLOW_PLANKS.get());
        stairsBlock((StairsBlock) BMBlocks.AVONDALIC_WILLOW_STAIRS.get(), modLoc("block/avondalic_willow_planks"));
        slabBlock((SlabBlock) BMBlocks.AVONDALIC_WILLOW_SLAB.get(), modLoc("block/avondalic_willow_planks"), modLoc("block/avondalic_willow_planks"));
        fenceBlock((FenceBlock) BMBlocks.AVONDALIC_WILLOW_FENCE.get(), modLoc("block/avondalic_willow_planks"));
        fenceGateBlock((FenceGateBlock) BMBlocks.AVONDALIC_WILLOW_FENCE_GATE.get(), modLoc("block/avondalic_willow_planks"));
        doorBlock((DoorBlock) BMBlocks.AVONDALIC_WILLOW_DOOR.get(), modLoc("block/avondalic_willow_door_bottom"), modLoc("block/avondalic_willow_door_top"));
        trapdoorBlock((TrapDoorBlock) BMBlocks.AVONDALIC_WILLOW_TRAPDOOR.get(), modLoc("block/avondalic_willow_trapdoor"), true);

        simpleBlock(BMBlocks.JABUTICABA_LEAVES.get(), models().withExistingParent("jabuticaba_leaves", "minecraft:block/leaves").texture("all", "backmath:block/jabuticaba_leaves"));
        simpleBlock(BMBlocks.JABUTICABA_SAPLING.get(), models().cross("jabuticaba_sapling", modLoc("block/jabuticaba_sapling")));
        simpleBlock(BMBlocks.POTTED_JABUTICABA_SAPLING.get(), models().withExistingParent("potted_jabuticaba_sapling", "block/flower_pot_cross").texture("plant", "block/jabuticaba_sapling"));
        axisBlock((RotatedPillarBlock) BMBlocks.JABUTICABA_LOG.get(), modLoc("block/jabuticaba_log"), modLoc("block/jabuticaba_log_top"));
        axisBlock((RotatedPillarBlock) BMBlocks.JABUTICABA_WOOD.get(), modLoc("block/jabuticaba_log"), modLoc("block/jabuticaba_log"));
        axisBlock((RotatedPillarBlock) BMBlocks.STRIPPED_JABUTICABA_LOG.get(), modLoc("block/stripped_jabuticaba_log"), modLoc("block/stripped_jabuticaba_log_top"));
        axisBlock((RotatedPillarBlock) BMBlocks.STRIPPED_JABUTICABA_WOOD.get(), modLoc("block/stripped_jabuticaba_log"), modLoc("block/stripped_jabuticaba_log"));
        simpleBlock(BMBlocks.JABUTICABA_PLANKS.get());
        stairsBlock((StairsBlock) BMBlocks.JABUTICABA_STAIRS.get(), modLoc("block/jabuticaba_planks"));
        slabBlock((SlabBlock) BMBlocks.JABUTICABA_SLAB.get(), modLoc("block/jabuticaba_planks"), modLoc("block/jabuticaba_planks"));
        fenceBlock((FenceBlock) BMBlocks.JABUTICABA_FENCE.get(), modLoc("block/jabuticaba_planks"));
        fenceGateBlock((FenceGateBlock) BMBlocks.JABUTICABA_FENCE_GATE.get(), modLoc("block/jabuticaba_planks"));
        doorBlock((DoorBlock) BMBlocks.JABUTICABA_DOOR.get(), modLoc("block/jabuticaba_door_bottom"), modLoc("block/jabuticaba_door_top"));
        trapdoorBlock((TrapDoorBlock) BMBlocks.JABUTICABA_TRAPDOOR.get(), modLoc("block/jabuticaba_trapdoor"), true);

        axisBlock((RotatedPillarBlock) BMBlocks.STRIPPED_CRYSTALLINE_BIRCH_LOG.get(), modLoc("block/stripped_crystalline_birch_log"), modLoc("block/stripped_crystalline_birch_log_top"));
        axisBlock((RotatedPillarBlock) BMBlocks.STRIPPED_CRYSTALLINE_BIRCH_WOOD.get(), modLoc("block/stripped_crystalline_birch_log"), modLoc("block/stripped_crystalline_birch_log"));

        simpleBlock(BMBlocks.CORK_OAK_LEAVES.get(), models().withExistingParent("cork_oak_leaves", "minecraft:block/leaves").texture("all", "backmath:block/cork_oak_leaves"));
        simpleBlock(BMBlocks.CORK_OAK_SAPLING.get(), models().cross("cork_oak_sapling", modLoc("block/cork_oak_sapling")));
        simpleBlock(BMBlocks.POTTED_CORK_OAK_SAPLING.get(), models().withExistingParent("potted_cork_oak_sapling", "block/flower_pot_cross").texture("plant", "block/cork_oak_sapling"));
        axisBlock((RotatedPillarBlock) BMBlocks.CORK_OAK_LOG.get(), modLoc("block/cork_oak_log"), modLoc("block/cork_oak_log_top"));
        axisBlock((RotatedPillarBlock) BMBlocks.CORK_OAK_WOOD.get(), modLoc("block/cork_oak_log"), modLoc("block/cork_oak_log"));
        axisBlock((RotatedPillarBlock) BMBlocks.STRIPPED_CORK_OAK_LOG.get(), modLoc("block/stripped_cork_oak_log"), modLoc("block/stripped_cork_oak_log_top"));
        axisBlock((RotatedPillarBlock) BMBlocks.STRIPPED_CORK_OAK_WOOD.get(), modLoc("block/stripped_cork_oak_log"), modLoc("block/stripped_cork_oak_log"));
        simpleBlock(BMBlocks.CORK_OAK_PLANKS.get());
        stairsBlock((StairsBlock) BMBlocks.CORK_OAK_STAIRS.get(), modLoc("block/cork_oak_planks"));
        slabBlock((SlabBlock) BMBlocks.CORK_OAK_SLAB.get(), modLoc("block/cork_oak_planks"), modLoc("block/cork_oak_planks"));
        fenceBlock((FenceBlock) BMBlocks.CORK_OAK_FENCE.get(), modLoc("block/cork_oak_planks"));
        fenceGateBlock((FenceGateBlock) BMBlocks.CORK_OAK_FENCE_GATE.get(), modLoc("block/cork_oak_planks"));
        doorBlock((DoorBlock) BMBlocks.CORK_OAK_DOOR.get(), modLoc("block/cork_oak_door_bottom"), modLoc("block/cork_oak_door_top"));
        trapdoorBlock((TrapDoorBlock) BMBlocks.CORK_OAK_TRAPDOOR.get(), modLoc("block/cork_oak_trapdoor"), true);

        simpleBlock(BMBlocks.COLDTERM_BLOCK.get());
        simpleBlock(BMBlocks.COLDTERM_BRICKS.get());
        stairsBlock((StairsBlock) BMBlocks.COLDTERM_BRICK_STAIRS.get(), modLoc("block/coldterm_bricks"));
        slabBlock((SlabBlock) BMBlocks.COLDTERM_BRICK_SLAB.get(), modLoc("block/coldterm_bricks"), modLoc("block/coldterm_bricks"));
        wallBlock((WallBlock) BMBlocks.COLDTERM_BRICK_WALL.get(), modLoc("block/coldterm_bricks"));
        simpleBlock(BMBlocks.WARMTERM_BLOCK.get());
        simpleBlock(BMBlocks.WARMTERM_BRICKS.get());
        stairsBlock((StairsBlock) BMBlocks.WARMTERM_BRICK_STAIRS.get(), modLoc("block/warmterm_bricks"));
        slabBlock((SlabBlock) BMBlocks.WARMTERM_BRICK_SLAB.get(), modLoc("block/warmterm_bricks"), modLoc("block/warmterm_bricks"));
        wallBlock((WallBlock) BMBlocks.WARMTERM_BRICK_WALL.get(), modLoc("block/warmterm_bricks"));
        simpleBlock(BMBlocks.CHISELED_OBSIDITERM.get());
        simpleBlock(BMBlocks.OBSIDITERM_BRICKS.get());
        stairsBlock((StairsBlock) BMBlocks.OBSIDITERM_BRICK_STAIRS.get(), modLoc("block/obsiditerm_bricks"));
        slabBlock((SlabBlock) BMBlocks.OBSIDITERM_BRICK_SLAB.get(), modLoc("block/obsiditerm_bricks"), modLoc("block/obsiditerm_bricks"));
        wallBlock((WallBlock) BMBlocks.OBSIDITERM_BRICK_WALL.get(), modLoc("block/obsiditerm_bricks"));

        simpleBlock(BMBlocks.MOSSY_ANGELIC_BRICKS.get());
        stairsBlock((StairsBlock) BMBlocks.MOSSY_ANGELIC_BRICK_STAIRS.get(), modLoc("block/mossy_angelic_bricks"));
        slabBlock((SlabBlock) BMBlocks.MOSSY_ANGELIC_BRICK_SLAB.get(), modLoc("block/mossy_angelic_bricks"), modLoc("block/mossy_angelic_bricks"));
        wallBlock((WallBlock) BMBlocks.MOSSY_ANGELIC_BRICK_WALL.get(), modLoc("block/mossy_angelic_bricks"));
        axisBlock((RotatedPillarBlock) BMBlocks.ANGELIC_PILLAR.get(), modLoc("block/angelic_pillar"));

        // 12/02/2024
        simpleBlock(BMBlocks.TABU.get());
        simpleBlock(BMBlocks.EMERIOND_BLOCK.get());

        //25/02/2024
        simpleBlock(BMBlocks.ALJAN_LIGHT_BLUE_STAINED_GLASS.get());
        paneBlock((PaneBlock) BMBlocks.ALJAN_LIGHT_BLUE_STAINED_GLASS_PANE.get(), modLoc("block/aljan_light_blue_stained_glass"), modLoc("block/aljan_light_blue_stained_glass_pane_top"));
        simpleBlock(BMBlocks.POISON_BROWN_STAINED_GLASS.get());
        paneBlock((PaneBlock) BMBlocks.POISON_BROWN_STAINED_GLASS_PANE.get(), modLoc("block/poison_brown_stained_glass"), modLoc("block/poison_brown_stained_glass_pane_top"));
        simpleBlock(BMBlocks.INSOMNIAN_STAINED_GLASS.get());
        paneBlock((PaneBlock) BMBlocks.INSOMNIAN_STAINED_GLASS_PANE.get(), modLoc("block/insomnian_stained_glass"), modLoc("block/insomnian_stained_glass_pane_top"));
    }
}
