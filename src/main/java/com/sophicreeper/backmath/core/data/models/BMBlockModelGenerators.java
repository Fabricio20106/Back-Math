package com.sophicreeper.backmath.core.data.models;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;

import static net.minecraftforge.client.model.generators.ModelProvider.BLOCK_FOLDER;

public class BMBlockModelGenerators extends BlockStateProvider {
    public BMBlockModelGenerators(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, BackMath.MOD_ID, fileHelper);
    }

    @Nonnull
    @Override
    public String getName() {
        return "BackMath - Block States and Models";
    }

    @Override
    protected void registerStatesAndModels() {
        ResourceLocation aljanwoodPlanks = modLoc("block/aljanwood_planks");
        ResourceLocation insomnianPlanks = modLoc("block/insomnian_planks");
        ResourceLocation aljanstone = modLoc("block/aljanstone");
        ResourceLocation aljanstoneBricks = modLoc("block/aljanstone_bricks");
        ResourceLocation cobbledAljanstone = modLoc("block/cobbled_aljanstone");

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
        simpleBlock(BMBlocks.RED_YELLOW_FLOWER.get(), models().cross("red_yellow_flower", modLoc("block/red_yellow_flower")));
        trapdoorBlock((TrapDoorBlock) BMBlocks.ANGELIC_TRAPDOOR.get(), modLoc("block/angelic_trapdoor"), true);
        simpleBlock(BMBlocks.GUARANA_OAK_LEAVES.get());
        simpleBlock(BMBlocks.MANGO_OAK_LEAVES.get());
        simpleBlock(BMBlocks.GRAPE_VINE_LEAVES.get());
        simpleBlock(BMBlocks.GUARANA_OAK_SAPLING.get(), models().cross("guarana_oak_sapling", modLoc("block/guarana_oak_sapling")));
        simpleBlock(BMBlocks.MANGO_OAK_SAPLING.get(), models().cross("mango_oak_sapling", modLoc("block/mango_oak_sapling")));
        simpleBlock(BMBlocks.GRAPE_VINE_SAPLING.get(), models().cross("grape_vine_sapling", modLoc("block/grape_vine_sapling")));
        doorBlock((DoorBlock) BMBlocks.MID_TERM_DOOR.get(), modLoc("block/mid_term_door_bottom"), modLoc("block/mid_term_door_top"));
        simpleBlock(BMBlocks.MID_TERM_ORE.get());
        simpleBlock(BMBlocks.POTTED_RED_YELLOW_FLOWER.get(), models().withExistingParent("potted_red_yellow_flower",
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
        simpleBlock(BMBlocks.DEVIL_STAINED_GLASS.get());
        paneBlock((PaneBlock) BMBlocks.DEVIL_STAINED_GLASS_PANE.get(), modLoc("block/devil_stained_glass"), modLoc("block/devil_stained_glass_pane_top"));
        simpleBlock(BMBlocks.DEVIL_CONCRETE.get());
        simpleBlock(BMBlocks.DEVIL_CONCRETE_POWDER.get());
        simpleBlock(BMBlocks.DEVIL_WOOL.get());
        simpleBlock(BMBlocks.DEVIL_TERRACOTTA.get());
        horizontalBlock(BMBlocks.DEVIL_GLAZED_TERRACOTTA.get(), modLoc("block/devil_glazed_terracotta"), modLoc("block/devil_glazed_terracotta"), modLoc("block/devil_glazed_terracotta"));
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
                        modLoc("block/hillary_torch"))).rotationY((int) state.get(BlockStateProperties.HORIZONTAL_FACING).getHorizontalAngle() + 90).build());
        simpleBlock(BMBlocks.RAW_ANGELIC_BLOCK.get());
        simpleBlock(BMBlocks.RAW_MID_TERM_BLOCK.get());
        simpleBlock(BMBlocks.deepslate_angelic_ore.get());
        simpleBlock(BMBlocks.DEEPSLATE_DEVIL_ORE.get());
        simpleBlock(BMBlocks.OBSIDIAN_INFUSED_MID_TERM.get());
        simpleBlock(BMBlocks.ALJAME_BIRCH_LEAVES.get());
        simpleBlock(BMBlocks.POTTED_ALJAME_BIRCH_SAPLING.get(), models().withExistingParent("potted_aljame_birch_sapling",
                "block/flower_pot_cross").texture("plant", "block/aljame_birch_sapling"));
        simpleBlock(BMBlocks.ALJAME_BIRCH_SAPLING.get(), models().cross("aljame_birch_sapling", modLoc("block/aljame_birch_sapling")));

        // lemon oak
        simpleBlock(BMBlocks.LEMON_OAK_LEAVES.get());
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
        simpleBlock(BMBlocks.PINEAPPLE_OAK_LEAVES.get());
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
        simpleBlock(BMBlocks.ALJANWOOD_LEAVES.get());
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
        simpleBlock(BMBlocks.INSOMNIAN_LEAVES.get());
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
        simpleBlock(BMBlocks.ALJANCAP_LEAVES.get());
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
        simpleBlock(BMBlocks.ORANGE_OAK_LEAVES.get());
        simpleBlock(BMBlocks.BANANA_JUNGLE_LEAVES.get());
        simpleBlock(BMBlocks.ORANGE_OAK_SAPLING.get(), models().cross("orange_oak_sapling", modLoc("block/orange_oak_sapling")));
        simpleBlock(BMBlocks.BANANA_JUNGLE_SAPLING.get(), models().cross("banana_jungle_sapling", modLoc("block/banana_jungle_sapling")));
        simpleBlock(BMBlocks.POTTED_ORANGE_OAK_SAPLING.get(), models().withExistingParent("potted_orange_oak_sapling", "block/flower_pot_cross").texture("plant", "block/orange_oak_sapling"));
        simpleBlock(BMBlocks.POTTED_BANANA_JUNGLE_SAPLING.get(), models().withExistingParent("potted_banana_jungle_sapling", "block/flower_pot_cross").texture("plant", "block/banana_jungle_sapling"));
        simpleBlock(BMBlocks.CRYSTALLINE_ANGELIC_BLOCK.get());
        simpleBlock(BMBlocks.CHARJAN_WOOD_TORCH.get(), models().torch("charjan_wood_torch", modLoc("block/charjan_wood_torch")));
        getVariantBuilder(BMBlocks.CHARJAN_WOOD_WALL_TORCH.get()).forAllStates(state -> ConfiguredModel.builder().modelFile(wallTorch("charjan_wood_wall_torch",
                modLoc("block/charjan_wood_torch"))).rotationY((int) state.get(BlockStateProperties.HORIZONTAL_FACING).getHorizontalAngle() + 90).build());
        simpleBlock(BMBlocks.CHARJAN_ALJANWOOD_TORCH.get(), models().torch("charjan_aljanwood_torch", modLoc("block/charjan_aljanwood_torch")));
        getVariantBuilder(BMBlocks.CHARJAN_ALJANWOOD_WALL_TORCH.get()).forAllStates(state -> ConfiguredModel.builder().modelFile(wallTorch("charjan_aljanwood_wall_torch",
                modLoc("block/charjan_aljanwood_torch"))).rotationY((int) state.get(BlockStateProperties.HORIZONTAL_FACING).getHorizontalAngle() + 90).build());
        simpleBlock(BMBlocks.CHARJAN_ALJANCAP_TORCH.get(), models().torch("charjan_aljancap_torch", modLoc("block/charjan_aljancap_torch")));
        getVariantBuilder(BMBlocks.CHARJAN_ALJANCAP_WALL_TORCH.get()).forAllStates(state -> ConfiguredModel.builder().modelFile(wallTorch("charjan_aljancap_wall_torch",
                modLoc("block/charjan_aljancap_torch"))).rotationY((int) state.get(BlockStateProperties.HORIZONTAL_FACING).getHorizontalAngle() + 90).build());
        simpleBlock(BMBlocks.CHARJAN_INSOMNIAN_TORCH.get(), models().torch("charjan_insomnian_torch", modLoc("block/charjan_insomnian_torch")));
        getVariantBuilder(BMBlocks.CHARJAN_INSOMNIAN_WALL_TORCH.get()).forAllStates(state -> ConfiguredModel.builder().modelFile(wallTorch("charjan_insomnian_wall_torch",
                modLoc("block/charjan_insomnian_torch"))).rotationY((int) state.get(BlockStateProperties.HORIZONTAL_FACING).getHorizontalAngle() + 90).build());
        simpleBlock(BMBlocks.AMARACAP_LEAVES.get());
        simpleBlock(BMBlocks.INSOGRAVEL.get());
        simpleBlock(BMBlocks.ALJAMIC_COPPER_ORE.get());
        simpleBlock(BMBlocks.ALJAMIC_TIN_ORE.get());
        simpleBlock(BMBlocks.SLEEPINGSTONE_ALJAMEED_ORE.get());
        simpleBlock(BMBlocks.SLEEPINGSTONE_MOONERING_ORE.get());
        simpleBlock(BMBlocks.SLEEPINGSTONE_JANTIC_ORE.get());
        simpleBlock(BMBlocks.SLEEPINGSTONE_ALJAMIC_COPPER_ORE.get());
        simpleBlock(BMBlocks.SLEEPINGSTONE_ALJAMIC_TIN_ORE.get());

        getVariantBuilder(BMBlocks.ALJAMIC_ONIONS.get()).forAllStates(state -> {
            int i = cropAgeToIndexPotato(state.get(CropsBlock.AGE));
            return ConfiguredModel.builder().modelFile(models().crop("aljamic_onions_stage" + i, modLoc("block/aljamic_onions_stage" + i))).build();
        });
        getVariantBuilder(BMBlocks.CARAMELED_WHEAT.get()).forAllStates(state -> {
            int i = cropAgeToIndexWheat(state.get(CropsBlock.AGE));
            return ConfiguredModel.builder().modelFile(models().crop("carameled_wheat_stage" + i, modLoc("block/carameled_wheat_stage" + i))).build();
        });
        simpleBlock(BMBlocks.WILD_CARAMELED_WHEAT.get(), models().withExistingParent("wild_carameled_wheat", "backmath:block/template_wild_crop").texture("crop", "block/wild_carameled_wheat"));

        // BM 1.8.0:
        horizontalBlock(BMBlocks.GLAZED_TABU.get(), modLoc("block/glazed_tabu"), modLoc("block/glazed_tabu"), modLoc("block/glazed_tabu"));
        simpleBlock(BMBlocks.CUBIC_TABU.get());
        stairsBlock((StairsBlock) BMBlocks.CUBIC_TABU_STAIRS.get(), modLoc("block/cubic_tabu"));
        slabBlock((SlabBlock) BMBlocks.CUBIC_TABU_SLAB.get(), modLoc("block/cubic_tabu"), modLoc("block/cubic_tabu"));
        simpleBlock(BMBlocks.TABU_MOSAIC.get());
        stairsBlock((StairsBlock) BMBlocks.TABU_MOSAIC_STAIRS.get(), modLoc("block/tabu_mosaic"));
        slabBlock((SlabBlock) BMBlocks.TABU_MOSAIC_SLAB.get(), modLoc("block/tabu_mosaic"), modLoc("block/tabu_mosaic"));
        axisBlock((RotatedPillarBlock) BMBlocks.TABU_PILLAR.get(), modLoc("block/tabu_pillar"), modLoc("block/tabu_pillar_top"));

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

        simpleBlock(BMBlocks.MANGAED_MANGO_OAK_LEAVES.get());
        simpleBlock(BMBlocks.ALJAMIC_SAND.get());
        simpleBlock(BMBlocks.ALJAMIC_GLASS.get());
        paneBlock((PaneBlock) BMBlocks.ALJAMIC_GLASS_PANE.get(), modLoc("block/aljamic_glass"), modLoc("block/aljamic_glass_pane_top"));
        simpleBlock(BMBlocks.JANTICAL_BLOCK.get());
        simpleBlock(BMBlocks.WILD_ALJAMIC_ONIONS.get(), models().withExistingParent("wild_aljamic_onions", "backmath:block/template_wild_crop").texture("crop", "block/wild_aljamic_onions"));
    }

    public ModelBuilder<BlockModelBuilder> wallTorch(String name, ResourceLocation torch) {
        return models().singleTexture(name, mcLoc(BLOCK_FOLDER + "/wall_torch"), "torch", torch);
    }

    // Methods below were taken from my other mod "Variants"

    /**
     * Determines a value on {@link PotatoBlock}/{@link CarrotBlock} "AGE" {@link IntegerProperty} field for data generation.
     *
     * @param age A link to {@link PotatoBlock}/{@link CarrotBlock} on the "AGE" {@link IntegerProperty} field.
     * If the parameter "age" returns 6, then in returns 3,
     * if the parameter "age" returns 3, then in returns 2,
     * if the parameter "age" returns 1, then in returns 1,
     * else it returns 0.
     */
    public static int cropAgeToIndexPotato(int age) {
        if (age > 6) return 3;
        if (age > 3) return 2;
        if (age > 1) return 1;
        return 0;
    }

    /**
     * Determines a value on {@link CropsBlock} "AGE" {@link IntegerProperty} field for data generation.
     *
     * @param age A link to {@link CropsBlock} on the "AGE" {@link IntegerProperty} field.
     * If the parameter "age" returns 7, then in returns 7,
     * if the parameter "age" returns 6, then in returns 6,
     * if the parameter "age" returns 5, then in returns 5,
     * and so on till it returns 0.
     */
    public static int cropAgeToIndexWheat(int age) {
        if (age == 7) return 7;
        if (age == 6) return 6;
        if (age == 5) return 5;
        if (age == 4) return 4;
        if (age == 3) return 3;
        if (age == 2) return 2;
        if (age == 1) return 1;
        return 0;
    }
}
