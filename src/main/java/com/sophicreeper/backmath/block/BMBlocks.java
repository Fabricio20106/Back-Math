package com.sophicreeper.backmath.block;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.block.custom.*;
import com.sophicreeper.backmath.block.custom.variants.BMOreBlock;
import com.sophicreeper.backmath.block.custom.variants.CustomBeamGlassBlock;
import com.sophicreeper.backmath.block.custom.variants.CustomBeamGlassPaneBlock;
import com.sophicreeper.backmath.crystallizer.CrystallizerBlock;
import com.sophicreeper.backmath.crystallizer.advanced.CrystallineCrystallizerBlock;
import com.sophicreeper.backmath.util.BMTags;
import com.sophicreeper.backmath.world.plant.tree.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.item.DyeColor;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effects;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BMBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BackMath.MOD_ID);

    public static final RegistryObject<Block> DEVIL_ORE = BLOCKS.register("devil_ore", () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_ORE).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(1)));
    public static final RegistryObject<Block> DEEPSLATE_DEVIL_ORE = BLOCKS.register("deepslate_devil_ore", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(1).hardnessAndResistance(4.5F, 3)));
    public static final RegistryObject<Block> NETHER_DEVIL_ORE = BLOCKS.register("nether_devil_ore", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.NETHERRACK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(3).harvestLevel(1).sound(SoundType.NETHER_ORE)));
    public static final RegistryObject<Block> CHRISTIAN_MID_TERM_BLOCK = BLOCKS.register("christian_mid_term_block", () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> CHRISTIAN_MID_TERM_ANGELIC_ALLOY_BLOCK = BLOCKS.register("christian_mid_term_angelic_alloy_block", () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> CHRISTIAN_MID_TERM_DEVIL_ALLOY_BLOCK = BLOCKS.register("christian_mid_term_devil_alloy_block", () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> DEVIL_ANGELIC_ALLOY_BLOCK = BLOCKS.register("devil_angelic_alloy_block", () -> new DevilBlock(AbstractBlock.Properties.from(Blocks.IRON_BLOCK).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> MID_TERM_ORE = BLOCKS.register("mid_term_ore", () -> new BMOreBlock(5, 7, AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(3).hardnessAndResistance(50, 1200)));
    public static final RegistryObject<Block> OBSIDIAN_MID_TERM_ORE = BLOCKS.register("obsidian_mid_term_ore", () -> new BMOreBlock(5, 7, AbstractBlock.Properties.create(Material.ROCK).harvestLevel(3).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(100, 2400)));
    public static final RegistryObject<Block> MID_TERM_BLOCK = BLOCKS.register("mid_term_block", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.YELLOW).sound(SoundType.METAL).harvestLevel(3).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(50, 1200)));
    public static final RegistryObject<Block> OBSIDIAN_INFUSED_MID_TERM_BLOCK = BLOCKS.register("obsidian_infused_mid_term_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.YELLOW).sound(SoundType.METAL).harvestLevel(3).setRequiresTool().setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(100, 2400)));
    public static final RegistryObject<Block> RAW_MID_TERM_BLOCK = BLOCKS.register("raw_mid_term_block", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.YELLOW).harvestLevel(3).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(50, 1200)));
    public static final RegistryObject<Block> DEVIL_BLOCK = BLOCKS.register("devil_block", () -> new DevilBlock(AbstractBlock.Properties.create(Material.IRON, MaterialColor.RED).setRequiresTool().hardnessAndResistance(5, 6).sound(SoundType.METAL).harvestLevel(2)));
    public static final RegistryObject<Block> RAW_DEVIL_BLOCK = BLOCKS.register("raw_devil_block", () -> new DevilBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.RED).setRequiresTool().harvestLevel(1).hardnessAndResistance(5, 6)));
    public static final RegistryObject<Block> CHISELED_DEVIL_BLOCK = BLOCKS.register("chiseled_devil_block", () -> new DevilBlock(AbstractBlock.Properties.from(DEVIL_BLOCK.get())));
    public static final RegistryObject<Block> CHISELED_DEVIL_BLOCK_SOPHIE = BLOCKS.register("sophie_chiseled_devil_block", () -> new DevilBlock(AbstractBlock.Properties.from(DEVIL_BLOCK.get())));
    public static final RegistryObject<Block> DEVIL_STAIRS = BLOCKS.register("devil_stairs", () -> new StairsBlock(() -> DEVIL_BLOCK.get().getDefaultState(), AbstractBlock.Properties.from(DEVIL_BLOCK.get())));
    public static final RegistryObject<Block> DEVIL_SLAB = BLOCKS.register("devil_slab", () -> new SlabBlock(AbstractBlock.Properties.from(DEVIL_BLOCK.get()).hardnessAndResistance(2, 6)));
    public static final RegistryObject<Block> DEVIL_FENCE = BLOCKS.register("devil_fence", () -> new FenceBlock(AbstractBlock.Properties.from(DEVIL_BLOCK.get())));
    public static final RegistryObject<Block> DEVIL_WALL = BLOCKS.register("devil_wall", () -> new WallBlock(AbstractBlock.Properties.from(DEVIL_BLOCK.get())));
    public static final RegistryObject<Block> DEVIL_FENCE_GATE = BLOCKS.register("devil_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.from(DEVIL_BLOCK.get())));
    public static final RegistryObject<Block> DEVIL_TRAPDOOR = BLOCKS.register("devil_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.from(DEVIL_BLOCK.get()).notSolid().setAllowsSpawn(BMBlocks::neverAllowSpawns)));
    public static final RegistryObject<Block> DEVIL_PRESSURE_PLATE = BLOCKS.register("devil_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.from(DEVIL_BLOCK.get()).doesNotBlockMovement()));
    public static final RegistryObject<Block> DEVIL_BUTTON = BLOCKS.register("devil_button", () -> new StoneButtonBlock(AbstractBlock.Properties.from(DEVIL_BLOCK.get()).doesNotBlockMovement()));
    public static final RegistryObject<Block> DEVIL_DOOR = BLOCKS.register("devil_door", () -> new DoorBlock(AbstractBlock.Properties.from(DEVIL_BLOCK.get()).notSolid()));
    public static final RegistryObject<Block> FRIED_EGG_FLOWER = BLOCKS.register("cooked_egg_flower", () -> new FlowerBlock(Effects.GLOWING, 5, AbstractBlock.Properties.from(Blocks.POPPY).sound(SoundType.CROP)));
    public static final RegistryObject<Block> TURTLE_FRIED_EGG_FLOWER = BLOCKS.register("turtle_fried_egg_flower", () -> new TurtleFriedEggFlowerBlock(Effects.WATER_BREATHING, 12, AbstractBlock.Properties.from(Blocks.POPPY).sound(SoundType.CROP)));
    public static final RegistryObject<Block> MID_TERM_DOOR = BLOCKS.register("mid_term_door", () -> new DoorBlock(AbstractBlock.Properties.from(MID_TERM_BLOCK.get()).notSolid()));
    public static final RegistryObject<Block> RAW_ANGELIC_BLOCK = BLOCKS.register("raw_angelic_block", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.SNOW).harvestLevel(2).hardnessAndResistance(5, 6)));
    public static final RegistryObject<Block> ANGELIC_BLOCK = BLOCKS.register("angelic_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.SNOW).harvestLevel(2).setRequiresTool().hardnessAndResistance(3, 6).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ANGELIC_DOOR = BLOCKS.register("angelic_door", () -> new DoorBlock(AbstractBlock.Properties.from(BMBlocks.ANGELIC_BLOCK.get()).notSolid()));
    public static final RegistryObject<Block> ANGELIC_TRAPDOOR = BLOCKS.register("angelic_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.from(BMBlocks.ANGELIC_BLOCK.get()).notSolid().setAllowsSpawn(BMBlocks::neverAllowSpawns)));
    public static final RegistryObject<Block> GUARANA_OAK_LEAVES = BLOCKS.register("guarana_oak_leaves", () -> new LeavesBlock(AbstractBlock.Properties.from(Blocks.OAK_LEAVES).notSolid().setAllowsSpawn(BMBlocks::neverAllowSpawns).setOpaque(BMBlocks::isntSolid).setSuffocates(BMBlocks::isntSolid).setBlocksVision(BMBlocks::isntSolid)));
    public static final RegistryObject<Block> MANGO_OAK_LEAVES = BLOCKS.register("mango_oak_leaves", () -> new LeavesBlock(AbstractBlock.Properties.from(Blocks.OAK_LEAVES).notSolid()));
    public static final RegistryObject<Block> ALJAME_BIRCH_LEAVES = BLOCKS.register("aljame_birch_leaves", () -> new LeavesBlock(AbstractBlock.Properties.from(Blocks.BIRCH_LEAVES).notSolid()));
    public static final RegistryObject<Block> GRAPE_VINE_LEAVES = BLOCKS.register("grape_vine_leaves", () -> new LeavesBlock(AbstractBlock.Properties.from(Blocks.SPRUCE_LEAVES).notSolid()));
    public static final RegistryObject<Block> PINEAPPLE_OAK_LEAVES = BLOCKS.register("pineapple_oak_leaves", () -> new LeavesBlock(AbstractBlock.Properties.from(Blocks.OAK_LEAVES).notSolid()));
    public static final RegistryObject<Block> GUARANA_OAK_SAPLING = BLOCKS.register("guarana_oak_sapling", () -> new SaplingBlock(new GuaranaOakGrower(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> MANGO_OAK_SAPLING = BLOCKS.register("mango_oak_sapling", () -> new SaplingBlock(new MangoOakGrower(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> GRAPE_VINE_SAPLING = BLOCKS.register("grape_vine_sapling", () -> new SaplingBlock(new GrapeVineGrower(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> ALJAME_BIRCH_SAPLING = BLOCKS.register("aljame_birch_sapling", () -> new SaplingBlock(new AljameBirchGrower(), AbstractBlock.Properties.from(Blocks.BIRCH_SAPLING)));
    public static final RegistryObject<Block> PINEAPPLE_OAK_SAPLING = BLOCKS.register("pineapple_oak_sapling", () -> new SaplingBlock(new PineappleOakGrower(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> LEMON_OAK_LEAVES = BLOCKS.register("lemon_oak_leaves", () -> new LeavesBlock(AbstractBlock.Properties.from(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> LEMON_OAK_SAPLING = BLOCKS.register("lemon_oak_sapling", () -> new SaplingBlock(new LemonOakGrower(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> OAK_GRAPE_VINE_POST = BLOCKS.register("oak_grape_vine_post", () -> new GrapeVinePostBlock(AbstractBlock.Properties.from(Blocks.OAK_PLANKS).tickRandomly().hardnessAndResistance(0.5F).sound(SoundType.SWEET_BERRY_BUSH).notSolid()));
    public static final RegistryObject<Block> SPRUCE_GRAPE_VINE_POST = BLOCKS.register("spruce_grape_vine_post", () -> new GrapeVinePostBlock(AbstractBlock.Properties.from(Blocks.SPRUCE_PLANKS).tickRandomly().hardnessAndResistance(0.5F).sound(SoundType.SWEET_BERRY_BUSH).notSolid()));
    public static final RegistryObject<Block> BIRCH_GRAPE_VINE_POST = BLOCKS.register("birch_grape_vine_post", () -> new GrapeVinePostBlock(AbstractBlock.Properties.from(Blocks.BIRCH_PLANKS).tickRandomly().hardnessAndResistance(0.5F).sound(SoundType.SWEET_BERRY_BUSH).notSolid()));
    public static final RegistryObject<Block> JUNGLE_GRAPE_VINE_POST = BLOCKS.register("jungle_grape_vine_post", () -> new GrapeVinePostBlock(AbstractBlock.Properties.from(Blocks.JUNGLE_PLANKS).tickRandomly().hardnessAndResistance(0.5F).sound(SoundType.SWEET_BERRY_BUSH).notSolid()));
    public static final RegistryObject<Block> ACACIA_GRAPE_VINE_POST = BLOCKS.register("acacia_grape_vine_post", () -> new GrapeVinePostBlock(AbstractBlock.Properties.from(Blocks.ACACIA_PLANKS).tickRandomly().hardnessAndResistance(0.5F).sound(SoundType.SWEET_BERRY_BUSH).notSolid()));
    public static final RegistryObject<Block> DARK_OAK_GRAPE_VINE_POST = BLOCKS.register("dark_oak_grape_vine_post", () -> new GrapeVinePostBlock(AbstractBlock.Properties.from(Blocks.DARK_OAK_PLANKS).tickRandomly().hardnessAndResistance(0.5F).sound(SoundType.SWEET_BERRY_BUSH).notSolid()));
    public static final RegistryObject<Block> CRIMSON_GRAPE_VINE_POST = BLOCKS.register("crimson_grape_vine_post", () -> new GrapeVinePostBlock(AbstractBlock.Properties.from(Blocks.CRIMSON_PLANKS).tickRandomly().hardnessAndResistance(0.5F).sound(SoundType.SWEET_BERRY_BUSH).notSolid()));
    public static final RegistryObject<Block> WARPED_GRAPE_VINE_POST = BLOCKS.register("warped_grape_vine_post", () -> new GrapeVinePostBlock(AbstractBlock.Properties.from(Blocks.WARPED_PLANKS).tickRandomly().hardnessAndResistance(0.5F).sound(SoundType.SWEET_BERRY_BUSH).notSolid()));
    public static final RegistryObject<Block> HILLARY_LANTERN = BLOCKS.register("hilary_lantern", () -> new LanternBlock(AbstractBlock.Properties.from(Blocks.LANTERN)));
    public static final RegistryObject<Block> MID_TERM_HILLARY_LANTERN = BLOCKS.register("hilary_mid_term_lantern", () -> new LanternBlock(AbstractBlock.Properties.from(Blocks.LANTERN).harvestLevel(3).setRequiresTool().hardnessAndResistance(50, 1200)));
    public static final RegistryObject<Block> MID_TERM_LANTERN = BLOCKS.register("mid_term_lantern", () -> new LanternBlock(AbstractBlock.Properties.from(Blocks.LANTERN).harvestLevel(3).setRequiresTool().hardnessAndResistance(50, 1200)));
    public static final RegistryObject<Block> MID_TERM_SOUL_LANTERN = BLOCKS.register("mid_term_soul_lantern", () -> new LanternBlock(AbstractBlock.Properties.from(Blocks.SOUL_LANTERN).harvestLevel(3).setRequiresTool().hardnessAndResistance(50, 1200)));
    public static final RegistryObject<Block> RED_YELLOW_FLOWER = BLOCKS.register("red_yellow_flower", () -> new FlowerBlock(Effects.FIRE_RESISTANCE, 5, AbstractBlock.Properties.from(Blocks.POPPY).sound(SoundType.CROP)));
    public static final RegistryObject<Block> DEVIL_CONCRETE = BLOCKS.register("devil_concrete", () -> new Block(AbstractBlock.Properties.from(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> DEVIL_CONCRETE_POWDER = BLOCKS.register("devil_concrete_powder", () -> new ConcretePowderBlock(DEVIL_CONCRETE.get(), AbstractBlock.Properties.from(Blocks.RED_CONCRETE_POWDER)));
    public static final RegistryObject<Block> DEVIL_TERRACOTTA = BLOCKS.register("devil_terracotta", () -> new Block(AbstractBlock.Properties.from(Blocks.RED_TERRACOTTA)));
    public static final RegistryObject<Block> DEVIL_GLAZED_TERRACOTTA = BLOCKS.register("devil_glazed_terracotta", () -> new GlazedTerracottaBlock(AbstractBlock.Properties.from(Blocks.RED_GLAZED_TERRACOTTA)));
    public static final RegistryObject<Block> DEVIL_WOOL = BLOCKS.register("devil_wool", () -> new Block(AbstractBlock.Properties.from(Blocks.RED_WOOL)));
    public static final RegistryObject<Block> DEVIL_CARPET = BLOCKS.register("devil_carpet", () -> new CarpetBlock(DyeColor.RED, AbstractBlock.Properties.from(Blocks.RED_CARPET)));
    public static final RegistryObject<Block> DEVIL_STAINED_GLASS = BLOCKS.register("devil_stained_glass", () -> new CustomBeamGlassBlock(0xFF0E07, AbstractBlock.Properties.from(Blocks.RED_STAINED_GLASS)));
    public static final RegistryObject<Block> DEVIL_STAINED_GLASS_PANE = BLOCKS.register("devil_stained_glass_pane", () -> new CustomBeamGlassPaneBlock(0xFF0E07, AbstractBlock.Properties.from(Blocks.RED_STAINED_GLASS_PANE)));
    public static final RegistryObject<Block> ANGELIC_ORE = BLOCKS.register("angelic_ore", () -> new Block(AbstractBlock.Properties.from(Blocks.GOLD_ORE).harvestLevel(1)));
    public static final RegistryObject<Block> DEEPSLATE_ANGELIC_ORE = BLOCKS.register("deepslate_angelic_ore", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).setRequiresTool().harvestLevel(1).hardnessAndResistance(4.5F, 3)));
    public static final RegistryObject<Block> HILLARY_CAKE = BLOCKS.register("hillary_cake", () -> new HillaryCakeBlock(AbstractBlock.Properties.from(Blocks.CAKE)));
    public static final RegistryObject<Block> MILKLLARY_CAKE = BLOCKS.register("milkllary_cake", () -> new MilkllaryCakeBlock(AbstractBlock.Properties.from(Blocks.CAKE)));
    public static final RegistryObject<FlowingFluidBlock> HILLARY = BLOCKS.register("hilary", () -> new FlowingFluidBlock(BMFluids.HILLARY, AbstractBlock.Properties.create(Material.WATER, MaterialColor.MAGENTA).doesNotBlockMovement().hardnessAndResistance(100).noDrops()));
    public static final RegistryObject<FlowingFluidBlock> MILKLLARY = BLOCKS.register("milklary", () -> new FlowingFluidBlock(BMFluids.MILKLLARY, AbstractBlock.Properties.create(Material.WATER, MaterialColor.QUARTZ).doesNotBlockMovement().hardnessAndResistance(100).noDrops()));
    public static final RegistryObject<FlowingFluidBlock> LIQUID_ALJAME = BLOCKS.register("liquid_aljame", () -> new FlowingFluidBlock(BMFluids.LIQUID_ALJAME, AbstractBlock.Properties.create(Material.WATER, MaterialColor.LIGHT_BLUE).doesNotBlockMovement().hardnessAndResistance(100).noDrops()));
    public static final RegistryObject<FlowingFluidBlock> LIQUID_MANGA = BLOCKS.register("liquid_manga", () -> new FlowingFluidBlock(BMFluids.LIQUID_MANGA, AbstractBlock.Properties.create(Material.WATER, MaterialColor.CYAN).doesNotBlockMovement().hardnessAndResistance(100).noDrops()));
    public static final RegistryObject<FlowingFluidBlock> LIQUEFIED_MONSTER = BLOCKS.register("liquefied_monster", () -> new FlowingFluidBlock(BMFluids.LIQUEFIED_MONSTER, AbstractBlock.Properties.create(Material.WATER, MaterialColor.GREEN_TERRACOTTA).doesNotBlockMovement().hardnessAndResistance(100).noDrops()));
    public static final RegistryObject<FlowingFluidBlock> SLEEPISHWATER = BLOCKS.register("sleepishwater", () -> new FlowingFluidBlock(BMFluids.SLEEPISHWATER, AbstractBlock.Properties.create(BMMaterials.SLEEPISHWATER).doesNotBlockMovement().hardnessAndResistance(100).noDrops()));
    public static final RegistryObject<Block> HILLARY_TORCH = BLOCKS.register("hillary_torch", () -> new TorchBlock(AbstractBlock.Properties.from(Blocks.TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> HILLARY_WALL_TORCH = BLOCKS.register("hillary_wall_torch", () -> new WallTorchBlock(AbstractBlock.Properties.from(Blocks.TORCH).lootFrom(BMBlocks.HILLARY_TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CRYSTALLIZER = BLOCKS.register("crystallizer", () -> new CrystallizerBlock(AbstractBlock.Properties.create(Material.IRON, MaterialColor.SNOW).hardnessAndResistance(3, 6).setRequiresTool().sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final RegistryObject<Block> CRYSTALLINE_CRYSTALLIZER = BLOCKS.register("crystalline_crystallizer", () -> new CrystallineCrystallizerBlock(AbstractBlock.Properties.create(Material.IRON, MaterialColor.SNOW).hardnessAndResistance(3.5F, 6).setRequiresTool().sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final RegistryObject<Block> ANGRY_SOPHIE_HEAD = BLOCKS.register("angry_sophie_head", () -> new BMHeadBlock(AbstractBlock.Properties.from(Blocks.PLAYER_HEAD)));
    public static final RegistryObject<Block> ANGRY_SOPHIE_WALL_HEAD = BLOCKS.register("angry_sophie_wall_head", () -> new BMWallHeadBlock(AbstractBlock.Properties.from(Blocks.PLAYER_WALL_HEAD).lootFrom(BMBlocks.ANGRY_SOPHIE_HEAD)));
    public static final RegistryObject<Block> CRYSTALLINE_ANGELIC_ORE = BLOCKS.register("crystalline_angelic_ore", () -> new CrystallineAngelicOreBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.AIR).sound(SoundType.CLOTH).doesNotBlockMovement().notSolid()));
    public static final RegistryObject<Block> CRYSTALLINE_ANGELIC_BLOCK = BLOCKS.register("crystalline_angelic_block", () -> new Block(AbstractBlock.Properties.from(BMBlocks.ANGELIC_BLOCK.get()).hardnessAndResistance(5, 6).sound(SoundType.METAL).notSolid()));
    public static final RegistryObject<Block> ALICE_TOY = BLOCKS.register("alice_toy", () -> new ToyBlock(ToyBlock.Type.ALICE_OR_ALAN));
    public static final RegistryObject<Block> ALAN_TOY = BLOCKS.register("alan_toy", () -> new ToyBlock(ToyBlock.Type.ALICE_OR_ALAN));
    public static final RegistryObject<Block> INNOVATOR_TOY = BLOCKS.register("innovator_toy", () -> new ToyBlock(ToyBlock.Type.INNOVATOR));
    public static final RegistryObject<Block> TYLER_TOY = BLOCKS.register("tyler_toy", () -> new ToyBlock(ToyBlock.Type.TYLER));
    public static final RegistryObject<Block> MALENA_TOY = BLOCKS.register("malena_toy", () -> new ToyBlock(ToyBlock.Type.MALENA));
    public static final RegistryObject<Block> ANGELICAL_CASING = BLOCKS.register("angelical_casing", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.SNOW).hardnessAndResistance(3).setRequiresTool().sound(SoundType.METAL)));
    public static final RegistryObject<Block> MEAL_COOKER = BLOCKS.register("meal_cooker", () -> new MealCookerBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.WOOD).setRequiresTool().sound(SoundType.WOOD).hardnessAndResistance(2, 6)));
    public static final RegistryObject<Block> QUEEN_LUCY_RELIC = BLOCKS.register("queen_sophie_relic", () -> new QueenLucyRelicBlock(AbstractBlock.Properties.from(Blocks.GOLD_BLOCK).harvestLevel(2).setLightLevel(state -> 10)));
    public static final RegistryObject<Block> QUEEN_LUCY_HEAD = BLOCKS.register("queen_sophie_head", () -> new BMHeadBlock(AbstractBlock.Properties.from(Blocks.PLAYER_HEAD)));
    public static final RegistryObject<Block> QUEEN_LUCY_WALL_HEAD = BLOCKS.register("queen_sophie_wall_head", () -> new BMWallHeadBlock(AbstractBlock.Properties.from(Blocks.PLAYER_WALL_HEAD).lootFrom(BMBlocks.QUEEN_LUCY_HEAD)));
    public static final RegistryObject<Block> DEVIL_BRICKS = BLOCKS.register("devil_bricks", () -> new Block(AbstractBlock.Properties.from(DEVIL_BLOCK.get())));
    public static final RegistryObject<Block> DEVIL_BRICK_STAIRS = BLOCKS.register("devil_brick_stairs", () -> new StairsBlock(() -> DEVIL_BRICKS.get().getDefaultState(), AbstractBlock.Properties.from(DEVIL_BLOCK.get())));
    public static final RegistryObject<Block> DEVIL_BRICK_SLAB = BLOCKS.register("devil_brick_slab", () -> new SlabBlock(AbstractBlock.Properties.from(DEVIL_BLOCK.get())));
    public static final RegistryObject<Block> DEVIL_BRICK_WALL = BLOCKS.register("devil_brick_wall", () -> new WallBlock(AbstractBlock.Properties.from(DEVIL_BLOCK.get())));
    public static final RegistryObject<Block> ANGELIC_BUTTON = BLOCKS.register("angelic_button", () -> new StoneButtonBlock(AbstractBlock.Properties.from(ANGELIC_BLOCK.get()).doesNotBlockMovement()));
    public static final RegistryObject<Block> ANGELIC_PRESSURE_PLATE = BLOCKS.register("angelic_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.from(ANGELIC_BLOCK.get()).doesNotBlockMovement()));
    public static final RegistryObject<Block> CRYSTALLINE_BIRCH_LOG = BLOCKS.register("crystalline_birch_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(2).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> CRYSTALLINE_BIRCH_WOOD = BLOCKS.register("crystalline_birch_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(2).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> CRYSTALLINE_BIRCH_PLANKS = BLOCKS.register("crystalline_birch_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(2, 3).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> CRYSTALLINE_BIRCH_DOOR = BLOCKS.register("crystalline_birch_door", () -> new DoorBlock(AbstractBlock.Properties.from(CRYSTALLINE_BIRCH_PLANKS.get()).hardnessAndResistance(3)));
    public static final RegistryObject<Block> CRYSTALLINE_BIRCH_TRAPDOOR = BLOCKS.register("crystalline_birch_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.from(CRYSTALLINE_BIRCH_PLANKS.get()).hardnessAndResistance(2)));
    public static final RegistryObject<Block> CRYSTALLINE_BIRCH_LEAVES = BLOCKS.register("crystalline_birch_leaves", () -> new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES, MaterialColor.GOLD).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid().setAllowsSpawn(BMBlocks::allowsSpawnOnLeaves).setSuffocates(BMBlocks::isntSolid).setBlocksVision(BMBlocks::isntSolid)));
    public static final RegistryObject<Block> CRYSTALLINE_BIRCH_SAPLING = BLOCKS.register("crystalline_birch_sapling", () -> new SaplingBlock(new CrystallineBirchGrower(), AbstractBlock.Properties.from(Blocks.BIRCH_SAPLING)));
    public static final RegistryObject<Block> CRYSTALLINE_BIRCH_STAIRS = BLOCKS.register("crystalline_birch_stairs", () -> new StairsBlock(() -> CRYSTALLINE_BIRCH_PLANKS.get().getDefaultState(), AbstractBlock.Properties.from(CRYSTALLINE_BIRCH_PLANKS.get())));
    public static final RegistryObject<Block> CRYSTALLINE_BIRCH_SLAB = BLOCKS.register("crystalline_birch_slab", () -> new SlabBlock(AbstractBlock.Properties.from(CRYSTALLINE_BIRCH_PLANKS.get())));
    public static final RegistryObject<Block> CRYSTALLINE_BIRCH_FENCE = BLOCKS.register("crystalline_birch_fence", () -> new FenceBlock(AbstractBlock.Properties.from(CRYSTALLINE_BIRCH_PLANKS.get())));
    public static final RegistryObject<Block> CRYSTALLINE_BIRCH_FENCE_GATE = BLOCKS.register("crystalline_birch_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.from(CRYSTALLINE_BIRCH_PLANKS.get())));
    public static final RegistryObject<Block> CRYSTALLINE_BIRCH_BUTTON = BLOCKS.register("crystalline_birch_button", () -> new WoodButtonBlock(AbstractBlock.Properties.from(CRYSTALLINE_BIRCH_PLANKS.get()).doesNotBlockMovement().hardnessAndResistance(0.5F)));
    public static final RegistryObject<Block> CRYSTALLINE_BIRCH_PRESSURE_PLATE = BLOCKS.register("crystalline_birch_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.from(CRYSTALLINE_BIRCH_PLANKS.get()).doesNotBlockMovement().hardnessAndResistance(0.5F)));
    public static final RegistryObject<Block> ANGELIC_BRICKS = BLOCKS.register("angelic_bricks", () -> new Block(AbstractBlock.Properties.from(ANGELIC_BLOCK.get())));
    public static final RegistryObject<Block> ANGELIC_BRICK_SLAB = BLOCKS.register("angelic_brick_slab", () -> new SlabBlock(AbstractBlock.Properties.from(ANGELIC_BLOCK.get())));
    public static final RegistryObject<Block> ANGELIC_BRICK_STAIRS = BLOCKS.register("angelic_brick_stairs", () -> new StairsBlock(() -> ANGELIC_BLOCK.get().getDefaultState(), AbstractBlock.Properties.from(ANGELIC_BLOCK.get())));
    public static final RegistryObject<Block> ANGELIC_BRICK_WALL = BLOCKS.register("angelic_brick_wall", () -> new WallBlock(AbstractBlock.Properties.from(ANGELIC_BLOCK.get())));
    public static final RegistryObject<Block> CRACKED_ANGELIC_BRICKS = BLOCKS.register("cracked_angelic_bricks", () -> new Block(AbstractBlock.Properties.from(ANGELIC_BLOCK.get())));
    public static final RegistryObject<Block> TITO = BLOCKS.register("tito", () -> new EmotionalSquidBlock(AbstractBlock.Properties.create(Material.WOOL, MaterialColor.PINK).hardnessAndResistance(0.8F).sound(SoundType.CLOTH)));
    public static final RegistryObject<Block> TOTI = BLOCKS.register("toti", () -> new EmotionalSquidBlock(AbstractBlock.Properties.create(Material.WOOL, MaterialColor.LIGHT_BLUE).hardnessAndResistance(0.8F).sound(SoundType.CLOTH)));
    public static final RegistryObject<Block> ORANGE_OAK_LEAVES = BLOCKS.register("orange_oak_leaves", () -> new LeavesBlock(AbstractBlock.Properties.from(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> ORANGE_OAK_SAPLING = BLOCKS.register("orange_oak_sapling", () -> new SaplingBlock(new OrangeOakGrower(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> BANANA_JUNGLE_LEAVES = BLOCKS.register("banana_jungle_leaves", () -> new LeavesBlock(AbstractBlock.Properties.from(Blocks.JUNGLE_LEAVES)));
    public static final RegistryObject<Block> BANANA_JUNGLE_SAPLING = BLOCKS.register("banana_jungle_sapling", () -> new SaplingBlock(new BananaJungleGrower(), AbstractBlock.Properties.from(Blocks.JUNGLE_SAPLING)));
    public static final RegistryObject<Block> POTTED_FRIED_EGG_FLOWER = BLOCKS.register("potted_cooked_egg_flower", () -> new FlowerPotBlock(FRIED_EGG_FLOWER.get(), AbstractBlock.Properties.from(Blocks.POTTED_POPPY)));
    public static final RegistryObject<Block> POTTED_RED_YELLOW_FLOWER = BLOCKS.register("potted_red_yellow_flower", () -> new FlowerPotBlock(RED_YELLOW_FLOWER.get(), AbstractBlock.Properties.from(Blocks.POTTED_POPPY)));
    public static final RegistryObject<Block> POTTED_GUARANA_OAK_SAPLING = BLOCKS.register("potted_guarana_oak_sapling", () -> new FlowerPotBlock(GUARANA_OAK_SAPLING.get(), AbstractBlock.Properties.from(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_MANGO_OAK_SAPLING = BLOCKS.register("potted_mango_oak_sapling", () -> new FlowerPotBlock(MANGO_OAK_SAPLING.get(), AbstractBlock.Properties.from(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_GRAPE_VINE_SAPLING = BLOCKS.register("potted_grape_vine_sapling", () -> new FlowerPotBlock(GRAPE_VINE_SAPLING.get(), AbstractBlock.Properties.from(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_LEMON_OAK_SAPLING = BLOCKS.register("potted_lemon_oak_sapling", () -> new FlowerPotBlock(LEMON_OAK_SAPLING.get(), AbstractBlock.Properties.from(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_ALJAME_BIRCH_SAPLING = BLOCKS.register("potted_aljame_birch_sapling", () -> new FlowerPotBlock(ALJAME_BIRCH_SAPLING.get(), AbstractBlock.Properties.from(Blocks.POTTED_BIRCH_SAPLING)));
    public static final RegistryObject<Block> POTTED_PINEAPPLE_OAK_SAPLING = BLOCKS.register("potted_pineapple_oak_sapling", () -> new FlowerPotBlock(PINEAPPLE_OAK_SAPLING.get(), AbstractBlock.Properties.from(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_ORANGE_OAK_SAPLING = BLOCKS.register("potted_orange_oak_sapling", () -> new FlowerPotBlock(ORANGE_OAK_SAPLING.get(), AbstractBlock.Properties.from(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_BANANA_JUNGLE_SAPLING = BLOCKS.register("potted_banana_jungle_sapling", () -> new FlowerPotBlock(BANANA_JUNGLE_SAPLING.get(), AbstractBlock.Properties.from(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_CRYSTALLINE_BIRCH_SAPLING = BLOCKS.register("potted_crystalline_birch_sapling", () -> new FlowerPotBlock(CRYSTALLINE_BIRCH_SAPLING.get(), AbstractBlock.Properties.from(Blocks.POTTED_BIRCH_SAPLING)));
    public static final RegistryObject<Block> POTTED_TURTLE_FRIED_EGG_FLOWER = BLOCKS.register("potted_turtle_fried_egg_flower", () -> new FlowerPotBlock(TURTLE_FRIED_EGG_FLOWER.get(), AbstractBlock.Properties.from(Blocks.POTTED_POPPY)));

    // ---------------------------------------------------
    // TODO: BACK MATH 1.7.0: FABRICIOS TA... I MEAN, ALJAMIC WARS CONTENT
    // ---------------------------------------------------

    // 1.7.0: Miscellaneous:
    public static final RegistryObject<Block> ALJAMEED_ORE = BLOCKS.register("aljameed_ore", () -> new Block(AbstractBlock.Properties.create(BMMaterials.ALJAN_ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(3).harvestLevel(1)));
    public static final RegistryObject<Block> MOONERING_ORE = BLOCKS.register("moonering_ore", () -> new Block(AbstractBlock.Properties.create(BMMaterials.ALJAN_ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(3).harvestLevel(2)));
    public static final RegistryObject<Block> ALJAMIC_COPPER_ORE = BLOCKS.register("aljamic_copper_ore", () -> new Block(AbstractBlock.Properties.create(BMMaterials.ALJAN_ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(3)));
    public static final RegistryObject<Block> ALJAMIC_TIN_ORE = BLOCKS.register("aljamic_tin_ore", () -> new Block(AbstractBlock.Properties.create(BMMaterials.ALJAN_ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(3)));
    public static final RegistryObject<Block> JANTIC_ORE = BLOCKS.register("jantic_ore", () -> new JanticOreBlock(AbstractBlock.Properties.create(BMMaterials.ALJAN_ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(3).harvestLevel(2)));
    public static final RegistryObject<Block> SLEEPINGSTONE_ALJAMEED_ORE = BLOCKS.register("sleepingstone_aljameed_ore", () -> new Block(AbstractBlock.Properties.create(BMMaterials.SLEEPINGSTONE_ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(3).harvestLevel(1)));
    public static final RegistryObject<Block> SLEEPINGSTONE_MOONERING_ORE = BLOCKS.register("sleepingstone_moonering_ore", () -> new Block(AbstractBlock.Properties.create(BMMaterials.SLEEPINGSTONE_ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(3).harvestLevel(2)));
    public static final RegistryObject<Block> SLEEPINGSTONE_ALJAMIC_COPPER_ORE = BLOCKS.register("sleepingstone_aljamic_copper_ore", () -> new Block(AbstractBlock.Properties.create(BMMaterials.SLEEPINGSTONE_ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(3)));
    public static final RegistryObject<Block> SLEEPINGSTONE_ALJAMIC_TIN_ORE = BLOCKS.register("sleepingstone_aljamic_tin_ore", () -> new Block(AbstractBlock.Properties.create(BMMaterials.SLEEPINGSTONE_ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(3)));
    public static final RegistryObject<Block> SLEEPINGSTONE_JANTIC_ORE = BLOCKS.register("sleepingstone_jantic_ore", () -> new JanticOreBlock(AbstractBlock.Properties.create(BMMaterials.SLEEPINGSTONE_ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(3).harvestLevel(2)));
    public static final RegistryObject<Block> ALJAMEED_BLOCK = BLOCKS.register("aljameed_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON, BMMaterials.ALJAN).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(5, 6).sound(SoundType.METAL)));
    public static final RegistryObject<Block> MOONERING_BLOCK = BLOCKS.register("moonering_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.PURPLE).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(5, 6).sound(SoundType.METAL)));
    public static final RegistryObject<Block> CHARJAN_COAL_BLOCK = BLOCKS.register("charjan_coal_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY_TERRACOTTA).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(5, 6)));
    public static final RegistryObject<Block> HARDENED_AMARACAMEL_BLOCK = BLOCKS.register("hardened_amaracamel_block", () -> new Block(AbstractBlock.Properties.create(Material.CORAL, MaterialColor.ADOBE).hardnessAndResistance(0.5F).harvestTool(ToolType.PICKAXE).sound(SoundType.CORAL)));
    public static final RegistryObject<Block> MILKLLARY_BLOCK = BLOCKS.register("milkllary_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.SNOW).setRequiresTool().hardnessAndResistance(5, 6).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
    public static final RegistryObject<Block> RAW_ALJAMEED_BLOCK = BLOCKS.register("raw_aljameed_block", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, BMMaterials.ALJAN).harvestLevel(1).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5, 6)));
    public static final RegistryObject<Block> RAW_MOONER_BLOCK = BLOCKS.register("raw_mooner_block", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PURPLE).harvestLevel(1).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5, 6)));
    public static final RegistryObject<Block> ALJAN_TULIP = BLOCKS.register("aljan_tulip", () -> new FlowerBlock(Effects.WEAKNESS, 6, AbstractBlock.Properties.from(Blocks.POPPY).sound(SoundType.CROP)));
    public static final RegistryObject<Block> INSOMNIAN_TULIP = BLOCKS.register("insomnian_tulip", () -> new InsomnianTulipBlock(Effects.GLOWING, 10, AbstractBlock.Properties.from(Blocks.POPPY).sound(SoundType.CROP)));
    public static final RegistryObject<Block> POISON_ROSE = BLOCKS.register("poison_rose", () -> new PoisonRoseBlock(Effects.POISON, 10, AbstractBlock.Properties.from(Blocks.POPPY).sound(SoundType.CROP)));
    public static final RegistryObject<Block> ALJANSHROOM = BLOCKS.register("aljanshroom", () -> new MushroomBlock(AbstractBlock.Properties.create(Material.PLANTS, BMMaterials.ALJAN).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT).setLightLevel((state) -> 1)));
    public static final RegistryObject<Block> SLEEPSHROOM = BLOCKS.register("sleepshroom", () -> new MushroomBlock(AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.PURPLE).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT).setNeedsPostProcessing(BMBlocks::needsPostProcessing)));
    public static final RegistryObject<Block> SLEEPYSHROOM = BLOCKS.register("sleepyshroom", () -> new MushroomBlock(AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.LIGHT_BLUE).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT).setNeedsPostProcessing(BMBlocks::needsPostProcessing)));
    public static final RegistryObject<Block> POTTED_ALJAN_TULIP = BLOCKS.register("potted_aljan_tulip", () -> new FlowerPotBlock(ALJAN_TULIP.get(), AbstractBlock.Properties.from(Blocks.POTTED_POPPY)));
    public static final RegistryObject<Block> POTTED_INSOMNIAN_TULIP = BLOCKS.register("potted_insomnian_tulip", () -> new FlowerPotBlock(INSOMNIAN_TULIP.get(), AbstractBlock.Properties.from(Blocks.POTTED_POPPY)));
    public static final RegistryObject<Block> POTTED_POISON_ROSE = BLOCKS.register("potted_poison_rose", () -> new FlowerPotBlock(POISON_ROSE.get(), AbstractBlock.Properties.from(Blocks.POTTED_POPPY)));
    public static final RegistryObject<Block> POTTED_ALJANSHROOM = BLOCKS.register("potted_aljanshroom", () -> new FlowerPotBlock(ALJANSHROOM.get(), AbstractBlock.Properties.from(Blocks.POTTED_POPPY)));
    public static final RegistryObject<Block> POTTED_SLEEPSHROOM = BLOCKS.register("potted_sleepshroom", () -> new FlowerPotBlock(SLEEPSHROOM.get(), AbstractBlock.Properties.from(Blocks.POTTED_POPPY)));
    public static final RegistryObject<Block> POTTED_SLEEPYSHROOM = BLOCKS.register("potted_sleepyshroom", () -> new FlowerPotBlock(SLEEPYSHROOM.get(), AbstractBlock.Properties.from(Blocks.POTTED_POPPY)));
    public static final RegistryObject<Block> OBSIDIAN_INFUSED_MID_TERM_DOOR = BLOCKS.register("obsidian_infused_mid_term_door", () -> new DoorBlock(AbstractBlock.Properties.from(BMBlocks.OBSIDIAN_INFUSED_MID_TERM_BLOCK.get()).notSolid().sound(SoundType.METAL)));
    public static final RegistryObject<Block> MID_TERM_TRAPDOOR = BLOCKS.register("mid_term_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.from(MID_TERM_BLOCK.get()).notSolid()));
    public static final RegistryObject<Block> OBSIDIAN_INFUSED_MID_TERM_TRAPDOOR = BLOCKS.register("obsidian_infused_mid_term_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.from(OBSIDIAN_INFUSED_MID_TERM_BLOCK.get()).notSolid()));
    public static final RegistryObject<Block> AMARACAMEL_BATTER_BAG = BLOCKS.register("amaracamel_batter_bag", () -> new BagBlock(AbstractBlock.Properties.create(Material.WOOL, MaterialColor.ADOBE).hardnessAndResistance(0.8F).sound(SoundType.CLOTH)));
    public static final RegistryObject<Block> BOOT_PACK = BLOCKS.register("boot_pack", () -> new BagBlock(AbstractBlock.Properties.create(Material.WOOL, MaterialColor.RED).hardnessAndResistance(0.8F).sound(SoundType.CLOTH)));
    public static final RegistryObject<Block> ALJAMIC_GRASS_BLOCK = BLOCKS.register("aljamic_grass_block", () -> new AljamicGrassBlock(AbstractBlock.Properties.create(Material.ORGANIC, BMMaterials.ALJAN).tickRandomly().hardnessAndResistance(0.6F).sound(SoundType.PLANT).harvestTool(ToolType.SHOVEL)));
    public static final RegistryObject<Block> ALJAMIC_DIRT = BLOCKS.register("aljamic_dirt", () -> new Block(AbstractBlock.Properties.create(Material.EARTH, BMMaterials.ALJAN).hardnessAndResistance(0.5F).sound(SoundType.GROUND).harvestTool(ToolType.SHOVEL)));
    public static final RegistryObject<Block> ALJAMIC_FARMLAND = BLOCKS.register("aljamic_farmland", () -> new AljamicFarmlandBlock(AbstractBlock.Properties.create(Material.EARTH, BMMaterials.ALJAN).tickRandomly().hardnessAndResistance(0.6F).sound(SoundType.GROUND).harvestTool(ToolType.SHOVEL).setBlocksVision(BMBlocks::needsPostProcessing).setSuffocates(BMBlocks::needsPostProcessing)));
    public static final RegistryObject<Block> ZOMBIE_FABRICIO_HEAD = BLOCKS.register("zombie_fabricio_head", () -> new BMHeadBlock(AbstractBlock.Properties.from(Blocks.PLAYER_HEAD)));
    public static final RegistryObject<Block> ZOMBIE_FABRICIO_WALL_HEAD = BLOCKS.register("zombie_fabricio_wall_head", () -> new BMWallHeadBlock(AbstractBlock.Properties.from(Blocks.PLAYER_WALL_HEAD).lootFrom(BMBlocks.ZOMBIE_FABRICIO_HEAD)));
    public static final RegistryObject<Block> CHARJAN_WOOD_TORCH = BLOCKS.register("charjan_wood_torch", () -> new TorchBlock(AbstractBlock.Properties.from(Blocks.TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_WOOD_WALL_TORCH = BLOCKS.register("charjan_wood_wall_torch", () -> new WallTorchBlock(AbstractBlock.Properties.from(Blocks.TORCH).lootFrom(BMBlocks.CHARJAN_WOOD_TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CARAMELED_WHEAT = BLOCKS.register("carameled_wheat", () -> new CarameledWheatBlock(AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.ADOBE).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> WILD_CARAMELED_WHEAT = BLOCKS.register("wild_carameled_wheat", () -> new WildCarameledWheatBlock(AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.ADOBE).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> ALJAMIC_ONIONS = BLOCKS.register("aljamic_onions", () -> new AljamicOnionsBlock(AbstractBlock.Properties.create(Material.PLANTS, BMMaterials.ALJAN).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> ALJAMEED_PRESSURE_PLATE = BLOCKS.register("aljameed_pressure_plate", () -> new WeightedPressurePlateBlock(82, AbstractBlock.Properties.from(BMBlocks.ALJAMEED_BLOCK.get()).doesNotBlockMovement()));
    public static final RegistryObject<Block> MOONERING_PRESSURE_PLATE = BLOCKS.register("moonering_pressure_plate", () -> new WeightedPressurePlateBlock(225, AbstractBlock.Properties.from(BMBlocks.MOONERING_BLOCK.get()).doesNotBlockMovement()));
    public static final RegistryObject<Block> ALJAMEED_BUTTON = BLOCKS.register("aljameed_button", () -> new StoneButtonBlock(AbstractBlock.Properties.from(BMBlocks.ALJAMEED_BLOCK.get()).doesNotBlockMovement()));
    public static final RegistryObject<Block> MOONERING_BUTTON = BLOCKS.register("moonering_button", () -> new StoneButtonBlock(AbstractBlock.Properties.from(BMBlocks.MOONERING_BLOCK.get()).doesNotBlockMovement()));
    public static final RegistryObject<Block> DEVIL_CHAIN = BLOCKS.register("devil_chain", () -> new ChainBlock(AbstractBlock.Properties.from(Blocks.CHAIN)));
    public static final RegistryObject<Block> ANGELIC_CHAIN = BLOCKS.register("angelic_chain", () -> new ChainBlock(AbstractBlock.Properties.from(Blocks.CHAIN)));
    public static final RegistryObject<Block> CHRISTIAN_MID_TERM_CHAIN = BLOCKS.register("christian_mid_term_chain", () -> new ChainBlock(AbstractBlock.Properties.from(Blocks.CHAIN)));
    public static final RegistryObject<Block> MILKLLARY_CHAIN = BLOCKS.register("milkllary_chain", () -> new ChainBlock(AbstractBlock.Properties.from(Blocks.CHAIN)));
    public static final RegistryObject<Block> MID_HILLARY_CHAIN = BLOCKS.register("mid_hillary_chain", () -> new ChainBlock(AbstractBlock.Properties.from(Blocks.CHAIN)));
    public static final RegistryObject<Block> MID_TERM_CHAIN = BLOCKS.register("mid_term_chain", () -> new ChainBlock(AbstractBlock.Properties.from(Blocks.CHAIN).hardnessAndResistance(50, 1200)));
    public static final RegistryObject<Block> OBSIDIAN_INFUSED_MID_TERM_CHAIN = BLOCKS.register("obsidian_infused_mid_term_chain", () -> new ChainBlock(AbstractBlock.Properties.from(Blocks.CHAIN).hardnessAndResistance(100, 2400)));
    public static final RegistryObject<Block> ALJAMEED_CHAIN = BLOCKS.register("aljameed_chain", () -> new ChainBlock(AbstractBlock.Properties.from(Blocks.CHAIN)));
    public static final RegistryObject<Block> MOONERING_CHAIN = BLOCKS.register("moonering_chain", () -> new ChainBlock(AbstractBlock.Properties.from(Blocks.CHAIN)));
    public static final RegistryObject<Block> STICKY_AMARACAMEL_BLOCK = BLOCKS.register("sticky_amaracamel_block", () -> new StickyAmaracamelBlock(AbstractBlock.Properties.create(Material.CLAY, MaterialColor.ADOBE).slipperiness(0.8F).sound(SoundType.HONEY).notSolid()));

    // 1.7.0: Aljanstone:
    public static final RegistryObject<Block> ALJANSTONE = BLOCKS.register("aljanstone", () -> new Block(AbstractBlock.Properties.create(BMMaterials.ALJAN_ROCK).setRequiresTool().hardnessAndResistance(1.5F, 6)));
    public static final RegistryObject<Block> ALJANSTONE_STAIRS = BLOCKS.register("aljanstone_stairs", () -> new StairsBlock(() -> ALJANSTONE.get().getDefaultState(), AbstractBlock.Properties.from(ALJANSTONE.get())));
    public static final RegistryObject<Block> ALJANSTONE_SLAB = BLOCKS.register("aljanstone_slab", () -> new SlabBlock(AbstractBlock.Properties.from(ALJANSTONE.get())));
    public static final RegistryObject<Block> ALJANSTONE_WALL = BLOCKS.register("aljanstone_wall", () -> new WallBlock(AbstractBlock.Properties.from(ALJANSTONE.get())));
    public static final RegistryObject<Block> ALJANSTONE_BRICKS = BLOCKS.register("aljanstone_bricks", () -> new Block(AbstractBlock.Properties.from(ALJANSTONE.get())));
    public static final RegistryObject<Block> ALJANSTONE_BRICK_STAIRS = BLOCKS.register("aljanstone_brick_stairs", () -> new StairsBlock(() -> ALJANSTONE_BRICKS.get().getDefaultState(), AbstractBlock.Properties.from(ALJANSTONE.get())));
    public static final RegistryObject<Block> ALJANSTONE_BRICK_SLAB = BLOCKS.register("aljanstone_brick_slab", () -> new SlabBlock(AbstractBlock.Properties.from(ALJANSTONE.get())));
    public static final RegistryObject<Block> ALJANSTONE_BRICK_WALL = BLOCKS.register("aljanstone_brick_wall", () -> new WallBlock(AbstractBlock.Properties.from(ALJANSTONE.get())));
    public static final RegistryObject<Block> CHISELED_ALJANSTONE_FABRICIO = BLOCKS.register("chiseled_aljanstone_fabricio", () -> new Block(AbstractBlock.Properties.create(BMMaterials.ALJAN_ROCK).setRequiresTool().hardnessAndResistance(2, 6)));
    public static final RegistryObject<Block> CHISELED_ALJANSTONE_JUNE = BLOCKS.register("chiseled_aljanstone_june", () -> new Block(AbstractBlock.Properties.from(CHISELED_ALJANSTONE_FABRICIO.get())));
    public static final RegistryObject<Block> CHISELED_ALJANSTONE_SOPHIE = BLOCKS.register("chiseled_aljanstone_sophie", () -> new Block(AbstractBlock.Properties.from(CHISELED_ALJANSTONE_FABRICIO.get())));
    public static final RegistryObject<Block> CHISELED_ALJANSTONE_LUCIA = BLOCKS.register("chiseled_aljanstone_lucia", () -> new Block(AbstractBlock.Properties.from(CHISELED_ALJANSTONE_FABRICIO.get())));
    public static final RegistryObject<Block> CHISELED_ALJANSTONE_CREEPER = BLOCKS.register("chiseled_aljanstone_creeper", () -> new Block(AbstractBlock.Properties.from(CHISELED_ALJANSTONE_FABRICIO.get())));
    public static final RegistryObject<Block> SMOOTH_ALJANSTONE = BLOCKS.register("smooth_aljanstone", () -> new Block(AbstractBlock.Properties.from(CHISELED_ALJANSTONE_FABRICIO.get())));
    public static final RegistryObject<Block> SMOOTH_ALJANSTONE_SLAB = BLOCKS.register("smooth_aljanstone_slab", () -> new SlabBlock(AbstractBlock.Properties.from(CHISELED_ALJANSTONE_FABRICIO.get())));
    public static final RegistryObject<Block> COBBLED_ALJANSTONE = BLOCKS.register("cobbled_aljanstone", () -> new Block(AbstractBlock.Properties.from(CHISELED_ALJANSTONE_FABRICIO.get())));
    public static final RegistryObject<Block> COBBLED_ALJANSTONE_STAIRS = BLOCKS.register("cobbled_aljanstone_stairs", () -> new StairsBlock(() -> COBBLED_ALJANSTONE.get().getDefaultState(), AbstractBlock.Properties.from(CHISELED_ALJANSTONE_FABRICIO.get())));
    public static final RegistryObject<Block> COBBLED_ALJANSTONE_SLAB = BLOCKS.register("cobbled_aljanstone_slab", () -> new SlabBlock(AbstractBlock.Properties.from(CHISELED_ALJANSTONE_FABRICIO.get())));
    public static final RegistryObject<Block> COBBLED_ALJANSTONE_WALL = BLOCKS.register("cobbled_aljanstone_wall", () -> new WallBlock(AbstractBlock.Properties.from(CHISELED_ALJANSTONE_FABRICIO.get())));

    // 1.7.0: Sleepingstone:
    public static final RegistryObject<Block> SLEEPINGSTONE = BLOCKS.register("sleepingstone", () -> new Block(AbstractBlock.Properties.create(BMMaterials.SLEEPINGSTONE_ROCK).setRequiresTool().hardnessAndResistance(1.5F, 6)));
    public static final RegistryObject<Block> SLEEPINGSTONE_STAIRS = BLOCKS.register("sleepingstone_stairs", () -> new StairsBlock(() -> SLEEPINGSTONE.get().getDefaultState(), AbstractBlock.Properties.from(SLEEPINGSTONE.get())));
    public static final RegistryObject<Block> SLEEPINGSTONE_SLAB = BLOCKS.register("sleepingstone_slab", () -> new SlabBlock(AbstractBlock.Properties.from(SLEEPINGSTONE.get())));
    public static final RegistryObject<Block> SLEEPINGSTONE_WALL = BLOCKS.register("sleepingstone_wall", () -> new WallBlock(AbstractBlock.Properties.from(SLEEPINGSTONE.get())));
    public static final RegistryObject<Block> INSOGRAVEL = BLOCKS.register("insogravel", () -> new BMFallingBlock(0x3C135E, AbstractBlock.Properties.from(SLEEPINGSTONE.get()).hardnessAndResistance(0.6F).sound(SoundType.GROUND).harvestTool(ToolType.SHOVEL)));
    public static final RegistryObject<Block> POLISHED_SLEEPINGSTONE = BLOCKS.register("polished_sleepingstone", () -> new Block(AbstractBlock.Properties.from(SLEEPINGSTONE.get())));
    public static final RegistryObject<Block> POLISHED_SLEEPINGSTONE_STAIRS = BLOCKS.register("polished_sleepingstone_stairs", () -> new StairsBlock(() -> POLISHED_SLEEPINGSTONE.get().getDefaultState(), AbstractBlock.Properties.from(SLEEPINGSTONE.get())));
    public static final RegistryObject<Block> POLISHED_SLEEPINGSTONE_SLAB = BLOCKS.register("polished_sleepingstone_slab", () -> new SlabBlock(AbstractBlock.Properties.from(SLEEPINGSTONE.get())));
    public static final RegistryObject<Block> POLISHED_SLEEPINGSTONE_WALL = BLOCKS.register("polished_sleepingstone_wall", () -> new WallBlock(AbstractBlock.Properties.from(SLEEPINGSTONE.get())));
    public static final RegistryObject<Block> SLEEPINGSTONE_BRICKS = BLOCKS.register("sleepingstone_bricks", () -> new Block(AbstractBlock.Properties.from(SLEEPINGSTONE.get())));
    public static final RegistryObject<Block> SLEEPINGSTONE_BRICK_STAIRS = BLOCKS.register("sleepingstone_brick_stairs", () -> new StairsBlock(() -> SLEEPINGSTONE_BRICKS.get().getDefaultState(), AbstractBlock.Properties.from(SLEEPINGSTONE.get())));
    public static final RegistryObject<Block> SLEEPINGSTONE_BRICK_SLAB = BLOCKS.register("sleepingstone_brick_slab", () -> new SlabBlock(AbstractBlock.Properties.from(SLEEPINGSTONE.get())));
    public static final RegistryObject<Block> SLEEPINGSTONE_BRICK_WALL = BLOCKS.register("sleepingstone_brick_wall", () -> new WallBlock(AbstractBlock.Properties.from(SLEEPINGSTONE.get())));
    public static final RegistryObject<Block> CHISELED_SLEEPINGSTONE_FABRICIO = BLOCKS.register("chiseled_sleepingstone_fabricio", () -> new Block(AbstractBlock.Properties.from(SLEEPINGSTONE.get())));
    public static final RegistryObject<Block> CHISELED_SLEEPINGSTONE_JUNE = BLOCKS.register("chiseled_sleepingstone_june", () -> new Block(AbstractBlock.Properties.from(SLEEPINGSTONE.get())));
    public static final RegistryObject<Block> CHISELED_SLEEPINGSTONE_SOPHIE = BLOCKS.register("chiseled_sleepingstone_sophie", () -> new Block(AbstractBlock.Properties.from(SLEEPINGSTONE.get())));
    public static final RegistryObject<Block> CHISELED_SLEEPINGSTONE_LUCIA = BLOCKS.register("chiseled_sleepingstone_lucia", () -> new Block(AbstractBlock.Properties.from(SLEEPINGSTONE.get())));
    public static final RegistryObject<Block> CHISELED_SLEEPINGSTONE_CREEPER = BLOCKS.register("chiseled_sleepingstone_creeper", () -> new Block(AbstractBlock.Properties.from(SLEEPINGSTONE.get())));
    public static final RegistryObject<Block> ALJAN_PORTAL_STAND = BLOCKS.register("aljan_portal_stand", () -> new AljanPortalStandBlock(AbstractBlock.Properties.from(ALJANSTONE.get()).harvestTool(ToolType.PICKAXE).hardnessAndResistance(5)));

    // 1.7.0: Aljanwood Wood:
    public static final RegistryObject<Block> ALJANWOOD_LOG = BLOCKS.register("aljanwood_log", () -> createLogBlock(BMMaterials.ALJAN, BMMaterials.ALJAN));
    public static final RegistryObject<Block> ALJANWOOD_WOOD = BLOCKS.register("aljanwood_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, BMMaterials.ALJAN).hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_ALJANWOOD_LOG = BLOCKS.register("stripped_aljanwood_log", () -> createLogBlock(MaterialColor.BROWN_TERRACOTTA, MaterialColor.BROWN_TERRACOTTA));
    public static final RegistryObject<Block> STRIPPED_ALJANWOOD_WOOD = BLOCKS.register("stripped_aljanwood_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, BMMaterials.ALJAN).hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ALJANWOOD_LEAVES = BLOCKS.register("aljanwood_leaves", () -> createLeavesBlock(MaterialColor.LIGHT_GRAY));
    public static final RegistryObject<Block> ALJANWOOD_SAPLING = BLOCKS.register("aljanwood_sapling", () -> new SaplingBlock(new AljanwoodTreeGrower(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_ALJANWOOD_SAPLING = BLOCKS.register("potted_aljanwood_sapling", () -> new FlowerPotBlock(ALJANWOOD_SAPLING.get(), AbstractBlock.Properties.from(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> ALJANWOOD_PLANKS = BLOCKS.register("aljanwood_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD, BMMaterials.ALJAN).hardnessAndResistance(2, 3).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ALJANWOOD_STAIRS = BLOCKS.register("aljanwood_stairs", () -> new StairsBlock(() -> ALJANWOOD_PLANKS.get().getDefaultState(), AbstractBlock.Properties.from(ALJANWOOD_PLANKS.get())));
    public static final RegistryObject<Block> ALJANWOOD_SLAB = BLOCKS.register("aljanwood_slab", () -> new SlabBlock(AbstractBlock.Properties.from(ALJANWOOD_PLANKS.get())));
    public static final RegistryObject<Block> ALJANWOOD_FENCE = BLOCKS.register("aljanwood_fence", () -> new FenceBlock(AbstractBlock.Properties.from(ALJANWOOD_PLANKS.get())));
    public static final RegistryObject<Block> ALJANWOOD_FENCE_GATE = BLOCKS.register("aljanwood_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.from(ALJANWOOD_PLANKS.get())));
    public static final RegistryObject<Block> ALJANWOOD_GRAPE_VINE_POST = BLOCKS.register("aljanwood_grape_vine_post", () -> new GrapeVinePostBlock(AbstractBlock.Properties.from(ALJANWOOD_PLANKS.get()).tickRandomly().hardnessAndResistance(0.5F).sound(SoundType.SWEET_BERRY_BUSH).notSolid()));
    public static final RegistryObject<Block> ALJANWOOD_DOOR = BLOCKS.register("aljanwood_door", () -> new DoorBlock(AbstractBlock.Properties.from(ALJANWOOD_PLANKS.get()).notSolid()));
    public static final RegistryObject<Block> ALJANWOOD_TRAPDOOR = BLOCKS.register("aljanwood_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.from(ALJANWOOD_PLANKS.get()).hardnessAndResistance(3).notSolid().setAllowsSpawn(BMBlocks::neverAllowSpawns)));
    public static final RegistryObject<Block> ALJANWOOD_PRESSURE_PLATE = BLOCKS.register("aljanwood_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.from(ALJANWOOD_PLANKS.get()).doesNotBlockMovement().hardnessAndResistance(0.5F)));
    public static final RegistryObject<Block> ALJANWOOD_BUTTON = BLOCKS.register("aljanwood_button", () -> new WoodButtonBlock(AbstractBlock.Properties.from(ALJANWOOD_PLANKS.get()).doesNotBlockMovement().hardnessAndResistance(0.5F)));
    public static final RegistryObject<Block> ALJANWOOD_LADDER = BLOCKS.register("aljanwood_ladder", () -> new LadderBlock(AbstractBlock.Properties.from(Blocks.LADDER)));
    public static final RegistryObject<Block> CHARJAN_ALJANWOOD_TORCH = BLOCKS.register("charjan_aljanwood_torch", () -> new TorchBlock(AbstractBlock.Properties.from(Blocks.TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_ALJANWOOD_WALL_TORCH = BLOCKS.register("charjan_aljanwood_wall_torch", () -> new WallTorchBlock(AbstractBlock.Properties.from(Blocks.TORCH).lootFrom(BMBlocks.CHARJAN_ALJANWOOD_TORCH), ParticleTypes.FLAME));

    // 1.7.0: Aljancap Wood:
    public static final RegistryObject<Block> ALJANCAP_LOG = BLOCKS.register("aljancap_log", () -> createLogBlock(MaterialColor.BROWN_TERRACOTTA, MaterialColor.BROWN_TERRACOTTA));
    public static final RegistryObject<Block> ALJANCAP_WOOD = BLOCKS.register("aljancap_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_ALJANCAP_LOG = BLOCKS.register("stripped_aljancap_log", () -> createLogBlock(MaterialColor.BROWN_TERRACOTTA, MaterialColor.BROWN_TERRACOTTA));
    public static final RegistryObject<Block> STRIPPED_ALJANCAP_WOOD = BLOCKS.register("stripped_aljancap_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ALJANCAP_LEAVES = BLOCKS.register("aljancap_leaves", () -> createLeavesBlock(MaterialColor.CYAN));
    public static final RegistryObject<Block> AMARACAP_LEAVES = BLOCKS.register("amaracap_leaves", () -> createLeavesBlock(MaterialColor.ADOBE));
    public static final RegistryObject<Block> ALJANCAP_SAPLING = BLOCKS.register("aljancap_sapling", () -> new SaplingBlock(new AljancapTreeGrower(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_ALJANCAP_SAPLING = BLOCKS.register("potted_aljancap_sapling", () -> new FlowerPotBlock(ALJANCAP_SAPLING.get(), AbstractBlock.Properties.from(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> ALJANCAP_PLANKS = BLOCKS.register("aljancap_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(2, 3).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ALJANCAP_STAIRS = BLOCKS.register("aljancap_stairs", () -> new StairsBlock(() -> ALJANCAP_PLANKS.get().getDefaultState(), AbstractBlock.Properties.from(ALJANCAP_PLANKS.get())));
    public static final RegistryObject<Block> ALJANCAP_SLAB = BLOCKS.register("aljancap_slab", () -> new SlabBlock(AbstractBlock.Properties.from(ALJANCAP_PLANKS.get())));
    public static final RegistryObject<Block> ALJANCAP_FENCE = BLOCKS.register("aljancap_fence", () -> new FenceBlock(AbstractBlock.Properties.from(ALJANCAP_PLANKS.get())));
    public static final RegistryObject<Block> ALJANCAP_FENCE_GATE = BLOCKS.register("aljancap_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.from(ALJANCAP_PLANKS.get())));
    public static final RegistryObject<Block> ALJANCAP_GRAPE_VINE_POST = BLOCKS.register("aljancap_grape_vine_post", () -> new GrapeVinePostBlock(AbstractBlock.Properties.from(ALJANCAP_PLANKS.get()).tickRandomly().hardnessAndResistance(0.5F).sound(SoundType.SWEET_BERRY_BUSH).notSolid()));
    public static final RegistryObject<Block> ALJANCAP_PRESSURE_PLATE = BLOCKS.register("aljancap_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.from(ALJANCAP_PLANKS.get()).doesNotBlockMovement().hardnessAndResistance(0.5F)));
    public static final RegistryObject<Block> ALJANCAP_BUTTON = BLOCKS.register("aljancap_button", () -> new WoodButtonBlock(AbstractBlock.Properties.from(ALJANCAP_PLANKS.get()).doesNotBlockMovement().hardnessAndResistance(0.5F)));
    public static final RegistryObject<Block> ALJANCAP_LADDER = BLOCKS.register("aljancap_ladder", () -> new LadderBlock(AbstractBlock.Properties.from(Blocks.LADDER)));
    public static final RegistryObject<Block> CHARJAN_ALJANCAP_TORCH = BLOCKS.register("charjan_aljancap_torch", () -> new TorchBlock(AbstractBlock.Properties.from(Blocks.TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_ALJANCAP_WALL_TORCH = BLOCKS.register("charjan_aljancap_wall_torch", () -> new WallTorchBlock(AbstractBlock.Properties.from(Blocks.TORCH).lootFrom(BMBlocks.CHARJAN_ALJANCAP_TORCH), ParticleTypes.FLAME));

    // 1.7.0: Insomnian Wood:
    public static final RegistryObject<Block> INSOMNIAN_LOG = BLOCKS.register("insomnian_log", () -> createLogBlock(BMMaterials.INSOMNIAN_PLANKS, MaterialColor.BLUE));
    public static final RegistryObject<Block> INSOMNIAN_WOOD = BLOCKS.register("insomnian_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, BMMaterials.INSOMNIAN_PLANKS).hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_INSOMNIAN_LOG = BLOCKS.register("stripped_insomnian_log", () -> createLogBlock(BMMaterials.INSOMNIAN_PLANKS, BMMaterials.INSOMNIAN_PLANKS));
    public static final RegistryObject<Block> STRIPPED_INSOMNIAN_WOOD = BLOCKS.register("stripped_insomnian_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, BMMaterials.INSOMNIAN_PLANKS).hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> INSOMNIAN_LEAVES = BLOCKS.register("insomnian_leaves", () -> createLeavesBlock(MaterialColor.ADOBE));
    public static final RegistryObject<Block> INSOMNIAN_SAPLING = BLOCKS.register("insomnian_sapling", () -> new SaplingBlock(new InsomnianTreeGrower(), AbstractBlock.Properties.from(Blocks.DARK_OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_INSOMNIAN_SAPLING = BLOCKS.register("potted_insomnian_sapling", () -> new FlowerPotBlock(INSOMNIAN_SAPLING.get(), AbstractBlock.Properties.from(Blocks.POTTED_DARK_OAK_SAPLING)));
    public static final RegistryObject<Block> INSOMNIAN_PLANKS = BLOCKS.register("insomnian_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD, BMMaterials.INSOMNIAN_PLANKS).hardnessAndResistance(2, 3).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> INSOMNIAN_STAIRS = BLOCKS.register("insomnian_stairs", () -> new StairsBlock(() -> INSOMNIAN_PLANKS.get().getDefaultState(), AbstractBlock.Properties.from(INSOMNIAN_PLANKS.get())));
    public static final RegistryObject<Block> INSOMNIAN_SLAB = BLOCKS.register("insomnian_slab", () -> new SlabBlock(AbstractBlock.Properties.from(INSOMNIAN_PLANKS.get())));
    public static final RegistryObject<Block> INSOMNIAN_FENCE = BLOCKS.register("insomnian_fence", () -> new FenceBlock(AbstractBlock.Properties.from(INSOMNIAN_PLANKS.get())));
    public static final RegistryObject<Block> INSOMNIAN_FENCE_GATE = BLOCKS.register("insomnian_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.from(INSOMNIAN_PLANKS.get())));
    public static final RegistryObject<Block> INSOMNIAN_GRAPE_VINE_POST = BLOCKS.register("insomnian_grape_vine_post", () -> new GrapeVinePostBlock(AbstractBlock.Properties.from(INSOMNIAN_PLANKS.get()).tickRandomly().hardnessAndResistance(0.5F).sound(SoundType.SWEET_BERRY_BUSH).notSolid()));
    public static final RegistryObject<Block> INSOMNIAN_PRESSURE_PLATE = BLOCKS.register("insomnian_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.from(INSOMNIAN_PLANKS.get()).doesNotBlockMovement().hardnessAndResistance(0.5F)));
    public static final RegistryObject<Block> INSOMNIAN_BUTTON = BLOCKS.register("insomnian_button", () -> new WoodButtonBlock(AbstractBlock.Properties.from(INSOMNIAN_PLANKS.get()).doesNotBlockMovement().hardnessAndResistance(0.5F)));
    public static final RegistryObject<Block> INSOMNIAN_LADDER = BLOCKS.register("insomnian_ladder", () -> new LadderBlock(AbstractBlock.Properties.from(Blocks.LADDER)));
    public static final RegistryObject<Block> CHARJAN_INSOMNIAN_TORCH = BLOCKS.register("charjan_insomnian_torch", () -> new TorchBlock(AbstractBlock.Properties.from(Blocks.TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_INSOMNIAN_WALL_TORCH = BLOCKS.register("charjan_insomnian_wall_torch", () -> new WallTorchBlock(AbstractBlock.Properties.from(Blocks.TORCH).lootFrom(BMBlocks.CHARJAN_INSOMNIAN_TORCH), ParticleTypes.FLAME));

    // Todo: Back Math 1.8.0: Bountifully Expansive
    // 1.8.0: Tabu:
    public static final RegistryObject<Block> TABU = BLOCKS.register("tabu", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.WHITE_TERRACOTTA).setRequiresTool().hardnessAndResistance(1.5F, 6)));
    public static final RegistryObject<Block> GLAZED_TABU = BLOCKS.register("glazed_tabu", () -> new GlazedTerracottaBlock(AbstractBlock.Properties.from(TABU.get())));
    public static final RegistryObject<Block> CUBIC_TABU = BLOCKS.register("cubic_tabu", () -> new Block(AbstractBlock.Properties.from(TABU.get())));
    public static final RegistryObject<Block> CUBIC_TABU_STAIRS = BLOCKS.register("cubic_tabu_stairs", () -> new StairsBlock(() -> CUBIC_TABU.get().getDefaultState(), AbstractBlock.Properties.from(TABU.get())));
    public static final RegistryObject<Block> CUBIC_TABU_SLAB = BLOCKS.register("cubic_tabu_slab", () -> new SlabBlock(AbstractBlock.Properties.from(TABU.get())));
    public static final RegistryObject<Block> TABU_MOSAIC = BLOCKS.register("tabu_mosaic", () -> new Block(AbstractBlock.Properties.from(TABU.get())));
    public static final RegistryObject<Block> TABU_MOSAIC_STAIRS = BLOCKS.register("tabu_mosaic_stairs", () -> new StairsBlock(() -> TABU_MOSAIC.get().getDefaultState(), AbstractBlock.Properties.from(TABU.get())));
    public static final RegistryObject<Block> TABU_MOSAIC_SLAB = BLOCKS.register("tabu_mosaic_slab", () -> new SlabBlock(AbstractBlock.Properties.from(TABU.get())));
    public static final RegistryObject<Block> TABU_PILLAR = BLOCKS.register("tabu_pillar", () -> new RotatedPillarBlock(AbstractBlock.Properties.from(TABU.get())));

    // 1.8.0: Hillaried Stone:
    public static final RegistryObject<Block> HILLARIED_STONE = BLOCKS.register("hillaried_stone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.MAGENTA).setRequiresTool().hardnessAndResistance(1.5F, 6)));
    public static final RegistryObject<Block> HILLARIED_STONE_STAIRS = BLOCKS.register("hillaried_stone_stairs", () -> new StairsBlock(() -> HILLARIED_STONE.get().getDefaultState(), AbstractBlock.Properties.from(HILLARIED_STONE.get())));
    public static final RegistryObject<Block> HILLARIED_STONE_SLAB = BLOCKS.register("hillaried_stone_slab", () -> new SlabBlock(AbstractBlock.Properties.from(HILLARIED_STONE.get())));
    public static final RegistryObject<Block> HILLARIED_STONE_WALL = BLOCKS.register("hillaried_stone_wall", () -> new WallBlock(AbstractBlock.Properties.from(HILLARIED_STONE.get())));
    public static final RegistryObject<Block> HILLARIED_STONE_PILLAR = BLOCKS.register("hillaried_stone_pillar", () -> new RotatedPillarBlock(AbstractBlock.Properties.from(HILLARIED_STONE.get())));
    public static final RegistryObject<Block> CHISELED_HILLARIED_STONE = BLOCKS.register("chiseled_hillaried_stone", () -> new Block(AbstractBlock.Properties.from(HILLARIED_STONE.get())));
    public static final RegistryObject<Block> CHISELED_HILLARIED_STONE_BUCKET = BLOCKS.register("chiseled_hillaried_stone_bucket", () -> new Block(AbstractBlock.Properties.from(HILLARIED_STONE.get())));

    // 1.8.0: Cork Oak Wood:
    public static final RegistryObject<Block> CORK_OAK_LEAVES = BLOCKS.register("cork_oak_leaves", () -> createLeavesBlock(MaterialColor.FOLIAGE));
    public static final RegistryObject<Block> CORK_OAK_SAPLING = BLOCKS.register("cork_oak_sapling", () -> new SaplingBlock(new CorkOakTreeGrower(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_CORK_OAK_SAPLING = BLOCKS.register("potted_cork_oak_sapling", () -> new FlowerPotBlock(BMBlocks.CORK_OAK_SAPLING.get(), AbstractBlock.Properties.from(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> CORK_OAK_LOG = BLOCKS.register("cork_oak_log", () -> createLogBlock(MaterialColor.NETHERRACK, MaterialColor.BROWN));
    public static final RegistryObject<Block> CORK_OAK_WOOD = BLOCKS.register("cork_oak_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_CORK_OAK_LOG = BLOCKS.register("stripped_cork_oak_log", () -> createLogBlock(MaterialColor.NETHERRACK, MaterialColor.NETHERRACK));
    public static final RegistryObject<Block> STRIPPED_CORK_OAK_WOOD = BLOCKS.register("stripped_cork_oak_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.NETHERRACK).hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CORK_OAK_PLANKS = BLOCKS.register("cork_oak_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.NETHERRACK).hardnessAndResistance(2, 3).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CORK_OAK_STAIRS = BLOCKS.register("cork_oak_stairs", () -> new StairsBlock(() -> CORK_OAK_PLANKS.get().getDefaultState(), AbstractBlock.Properties.from(CORK_OAK_PLANKS.get())));
    public static final RegistryObject<Block> CORK_OAK_SLAB = BLOCKS.register("cork_oak_slab", () -> new SlabBlock(AbstractBlock.Properties.from(CORK_OAK_PLANKS.get())));
    public static final RegistryObject<Block> CORK_OAK_FENCE = BLOCKS.register("cork_oak_fence", () -> new FenceBlock(AbstractBlock.Properties.from(CORK_OAK_PLANKS.get())));
    public static final RegistryObject<Block> CORK_OAK_FENCE_GATE = BLOCKS.register("cork_oak_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.from(CORK_OAK_PLANKS.get())));
    public static final RegistryObject<Block> CORK_OAK_PRESSURE_PLATE = BLOCKS.register("cork_oak_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.from(CORK_OAK_PLANKS.get()).doesNotBlockMovement().hardnessAndResistance(0.5F)));
    public static final RegistryObject<Block> CORK_OAK_BUTTON = BLOCKS.register("cork_oak_button", () -> new WoodButtonBlock(AbstractBlock.Properties.from(CORK_OAK_PLANKS.get()).doesNotBlockMovement().hardnessAndResistance(0.5F)));
    public static final RegistryObject<Block> CORK_OAK_DOOR = BLOCKS.register("cork_oak_door", () -> new DoorBlock(AbstractBlock.Properties.from(CORK_OAK_PLANKS.get()).notSolid().hardnessAndResistance(3)));
    public static final RegistryObject<Block> CORK_OAK_TRAPDOOR = BLOCKS.register("cork_oak_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.from(CORK_OAK_PLANKS.get()).notSolid().hardnessAndResistance(3).setAllowsSpawn(BMBlocks::neverAllowSpawns)));
    public static final RegistryObject<Block> CORK_OAK_GRAPE_VINE_POST = BLOCKS.register("cork_oak_grape_vine_post", () -> new GrapeVinePostBlock(AbstractBlock.Properties.from(CORK_OAK_PLANKS.get()).tickRandomly().hardnessAndResistance(0.5F).sound(SoundType.SWEET_BERRY_BUSH).notSolid()));
    public static final RegistryObject<Block> CORK_OAK_LADDER = BLOCKS.register("cork_oak_ladder", () -> new LadderBlock(AbstractBlock.Properties.from(Blocks.LADDER)));

    // 1.8.0: Guava Wood:
    public static final RegistryObject<Block> GUAVA_LEAVES = BLOCKS.register("guava_leaves", () -> createLeavesBlock(MaterialColor.LIME_TERRACOTTA));
    public static final RegistryObject<Block> GUAVA_SAPLING = BLOCKS.register("guava_sapling", () -> new SaplingBlock(new GuavaTreeGrower(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_GUAVA_SAPLING = BLOCKS.register("potted_guava_sapling", () -> new FlowerPotBlock(BMBlocks.GUAVA_SAPLING.get(), AbstractBlock.Properties.from(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> GUAVA_LOG = BLOCKS.register("guava_log", () -> createLogBlock(MaterialColor.NETHERRACK, MaterialColor.BROWN_TERRACOTTA, 1.5F, 4));
    public static final RegistryObject<Block> GUAVA_WOOD = BLOCKS.register("guava_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(1.5F, 4).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_GUAVA_LOG = BLOCKS.register("stripped_guava_log", () -> createLogBlock(MaterialColor.NETHERRACK, MaterialColor.NETHERRACK, 1.5F, 4));
    public static final RegistryObject<Block> STRIPPED_GUAVA_WOOD = BLOCKS.register("stripped_guava_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.NETHERRACK).hardnessAndResistance(1.5F, 4).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> GUAVA_PLANKS = BLOCKS.register("guava_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.NETHERRACK).hardnessAndResistance(1.5F, 4).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> GUAVA_STAIRS = BLOCKS.register("guava_stairs", () -> new StairsBlock(() -> GUAVA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.from(GUAVA_PLANKS.get())));
    public static final RegistryObject<Block> GUAVA_SLAB = BLOCKS.register("guava_slab", () -> new SlabBlock(AbstractBlock.Properties.from(GUAVA_PLANKS.get())));
    public static final RegistryObject<Block> GUAVA_FENCE = BLOCKS.register("guava_fence", () -> new FenceBlock(AbstractBlock.Properties.from(GUAVA_PLANKS.get())));
    public static final RegistryObject<Block> GUAVA_FENCE_GATE = BLOCKS.register("guava_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.from(GUAVA_PLANKS.get())));
    public static final RegistryObject<Block> GUAVA_PRESSURE_PLATE = BLOCKS.register("guava_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.from(GUAVA_PLANKS.get()).doesNotBlockMovement().hardnessAndResistance(0.5F)));
    public static final RegistryObject<Block> GUAVA_BUTTON = BLOCKS.register("guava_button", () -> new WoodButtonBlock(AbstractBlock.Properties.from(GUAVA_PLANKS.get()).doesNotBlockMovement().hardnessAndResistance(0.5F)));
    public static final RegistryObject<Block> GUAVA_DOOR = BLOCKS.register("guava_door", () -> new DoorBlock(AbstractBlock.Properties.from(GUAVA_PLANKS.get()).hardnessAndResistance(3).notSolid()));
    public static final RegistryObject<Block> GUAVA_TRAPDOOR = BLOCKS.register("guava_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.from(GUAVA_PLANKS.get()).hardnessAndResistance(3).notSolid()));
    public static final RegistryObject<Block> GUAVA_GRAPE_VINE_POST = BLOCKS.register("guava_grape_vine_post", () -> new GrapeVinePostBlock(AbstractBlock.Properties.from(GUAVA_PLANKS.get()).tickRandomly().hardnessAndResistance(1.5F, 4).sound(SoundType.SWEET_BERRY_BUSH).notSolid()));
    public static final RegistryObject<Block> GUAVA_LADDER = BLOCKS.register("guava_ladder", () -> new LadderBlock(AbstractBlock.Properties.from(Blocks.LADDER).hardnessAndResistance(1.5F, 4)));

    // 1.8.0: Jabuticaba Wood:
    public static final RegistryObject<Block> JABUTICABA_LEAVES = BLOCKS.register("jabuticaba_leaves", () -> createLeavesBlock(MaterialColor.FOLIAGE));
    public static final RegistryObject<Block> JABUTICABA_SAPLING = BLOCKS.register("jabuticaba_sapling", () -> new SaplingBlock(new JabuticabaTreeGrower(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_JABUTICABA_SAPLING = BLOCKS.register("potted_jabuticaba_sapling", () -> new FlowerPotBlock(BMBlocks.JABUTICABA_SAPLING.get(), AbstractBlock.Properties.from(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> JABUTICABA_LOG = BLOCKS.register("jabuticaba_log", () -> createLogBlock(MaterialColor.BLACK_TERRACOTTA, MaterialColor.BROWN_TERRACOTTA));
    public static final RegistryObject<Block> JABUTICABA_WOOD = BLOCKS.register("jabuticaba_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_JABUTICABA_LOG = BLOCKS.register("stripped_jabuticaba_log", () -> createLogBlock(MaterialColor.BLACK_TERRACOTTA, MaterialColor.BLACK_TERRACOTTA));
    public static final RegistryObject<Block> STRIPPED_JABUTICABA_WOOD = BLOCKS.register("stripped_jabuticaba_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BLACK_TERRACOTTA).hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> JABUTICABA_PLANKS = BLOCKS.register("jabuticaba_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BLACK_TERRACOTTA).hardnessAndResistance(2, 3).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> JABUTICABA_STAIRS = BLOCKS.register("jabuticaba_stairs", () -> new StairsBlock(() -> JABUTICABA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.from(JABUTICABA_PLANKS.get())));
    public static final RegistryObject<Block> JABUTICABA_SLAB = BLOCKS.register("jabuticaba_slab", () -> new SlabBlock(AbstractBlock.Properties.from(JABUTICABA_PLANKS.get())));
    public static final RegistryObject<Block> JABUTICABA_FENCE = BLOCKS.register("jabuticaba_fence", () -> new FenceBlock(AbstractBlock.Properties.from(JABUTICABA_PLANKS.get())));
    public static final RegistryObject<Block> JABUTICABA_FENCE_GATE = BLOCKS.register("jabuticaba_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.from(JABUTICABA_PLANKS.get())));
    public static final RegistryObject<Block> JABUTICABA_PRESSURE_PLATE = BLOCKS.register("jabuticaba_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.from(JABUTICABA_PLANKS.get()).doesNotBlockMovement().hardnessAndResistance(0.5F)));
    public static final RegistryObject<Block> JABUTICABA_BUTTON = BLOCKS.register("jabuticaba_button", () -> new WoodButtonBlock(AbstractBlock.Properties.from(JABUTICABA_PLANKS.get()).doesNotBlockMovement().hardnessAndResistance(0.5F)));
    public static final RegistryObject<Block> JABUTICABA_DOOR = BLOCKS.register("jabuticaba_door", () -> new DoorBlock(AbstractBlock.Properties.from(JABUTICABA_PLANKS.get()).hardnessAndResistance(3).notSolid()));
    public static final RegistryObject<Block> JABUTICABA_TRAPDOOR = BLOCKS.register("jabuticaba_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.from(JABUTICABA_PLANKS.get()).hardnessAndResistance(3).notSolid()));
    public static final RegistryObject<Block> JABUTICABA_GRAPE_VINE_POST = BLOCKS.register("jabuticaba_grape_vine_post", () -> new GrapeVinePostBlock(AbstractBlock.Properties.from(JABUTICABA_PLANKS.get()).tickRandomly().hardnessAndResistance(0.5F).sound(SoundType.SWEET_BERRY_BUSH).notSolid()));
    public static final RegistryObject<Block> JABUTICABA_LADDER = BLOCKS.register("jabuticaba_ladder", () -> new LadderBlock(AbstractBlock.Properties.from(Blocks.LADDER)));

    // 1.8.0: Goldenwood Wood:
    public static final RegistryObject<Block> GOLDENWOOD_LEAVES = BLOCKS.register("goldenwood_leaves", () -> createLeavesBlock(MaterialColor.GOLD));
    public static final RegistryObject<Block> ENCHANTED_GOLDENWOOD_LEAVES = BLOCKS.register("enchanted_goldenwood_leaves", () -> createLeavesBlock(MaterialColor.MAGENTA));
    public static final RegistryObject<Block> GOLDENWOOD_SAPLING = BLOCKS.register("goldenwood_sapling", () -> new SaplingBlock(new GoldenwoodGrower(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> ENCHANTED_GOLDENWOOD_SAPLING = BLOCKS.register("enchanted_goldenwood_sapling", () -> new SaplingBlock(new EnchantedGoldenwoodGrower(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_GOLDENWOOD_SAPLING = BLOCKS.register("potted_goldenwood_sapling", () -> new FlowerPotBlock(BMBlocks.GOLDENWOOD_SAPLING.get(), AbstractBlock.Properties.from(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_ENCHANTED_GOLDENWOOD_SAPLING = BLOCKS.register("potted_enchanted_goldenwood_sapling", () -> new FlowerPotBlock(BMBlocks.ENCHANTED_GOLDENWOOD_SAPLING.get(), AbstractBlock.Properties.from(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> GOLDENWOOD_LOG = BLOCKS.register("goldenwood_log", () -> createLogBlock(MaterialColor.GOLD, MaterialColor.GRAY_TERRACOTTA));
    public static final RegistryObject<Block> GOLDENWOOD_WOOD = BLOCKS.register("goldenwood_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.GRAY_TERRACOTTA).hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_GOLDENWOOD_LOG = BLOCKS.register("stripped_goldenwood_log", () -> createLogBlock(MaterialColor.GOLD, MaterialColor.GOLD));
    public static final RegistryObject<Block> STRIPPED_GOLDENWOOD_WOOD = BLOCKS.register("stripped_goldenwood_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> GOLDENWOOD_PLANKS = BLOCKS.register("goldenwood_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(2, 3).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> GOLDENWOOD_STAIRS = BLOCKS.register("goldenwood_stairs", () -> new StairsBlock(() -> GOLDENWOOD_PLANKS.get().getDefaultState(), AbstractBlock.Properties.from(GOLDENWOOD_PLANKS.get())));
    public static final RegistryObject<Block> GOLDENWOOD_SLAB = BLOCKS.register("goldenwood_slab", () -> new SlabBlock(AbstractBlock.Properties.from(GOLDENWOOD_PLANKS.get())));
    public static final RegistryObject<Block> GOLDENWOOD_FENCE = BLOCKS.register("goldenwood_fence", () -> new FenceBlock(AbstractBlock.Properties.from(GOLDENWOOD_PLANKS.get())));
    public static final RegistryObject<Block> GOLDENWOOD_FENCE_GATE = BLOCKS.register("goldenwood_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.from(GOLDENWOOD_PLANKS.get())));
    public static final RegistryObject<Block> GOLDENWOOD_PRESSURE_PLATE = BLOCKS.register("goldenwood_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.from(GOLDENWOOD_PLANKS.get()).doesNotBlockMovement().hardnessAndResistance(0.5F)));
    public static final RegistryObject<Block> GOLDENWOOD_BUTTON = BLOCKS.register("goldenwood_button", () -> new WoodButtonBlock(AbstractBlock.Properties.from(GOLDENWOOD_PLANKS.get()).doesNotBlockMovement().hardnessAndResistance(0.5F)));
    public static final RegistryObject<Block> GOLDENWOOD_DOOR = BLOCKS.register("goldenwood_door", () -> new DoorBlock(AbstractBlock.Properties.from(GOLDENWOOD_PLANKS.get()).hardnessAndResistance(3).notSolid()));
    public static final RegistryObject<Block> GOLDENWOOD_TRAPDOOR = BLOCKS.register("goldenwood_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.from(GOLDENWOOD_PLANKS.get()).hardnessAndResistance(3).notSolid()));
    public static final RegistryObject<Block> GOLDENWOOD_GRAPE_VINE_POST = BLOCKS.register("goldenwood_grape_vine_post", () -> new GrapeVinePostBlock(AbstractBlock.Properties.from(GOLDENWOOD_PLANKS.get()).tickRandomly().hardnessAndResistance(0.5F).sound(SoundType.SWEET_BERRY_BUSH).notSolid()));
    public static final RegistryObject<Block> GOLDENWOOD_LADDER = BLOCKS.register("goldenwood_ladder", () -> new LadderBlock(AbstractBlock.Properties.from(Blocks.LADDER)));

    // 1.8.0: Miscellaneous:
    public static final RegistryObject<Block> MANGAED_MANGO_OAK_LEAVES = BLOCKS.register("mangaed_mango_oak_leaves", () -> createLeavesBlock(MaterialColor.FOLIAGE));
    public static final RegistryObject<Block> MANGAED_MANGO_OAK_SAPLING = BLOCKS.register("mangaed_mango_oak_sapling", () -> new SaplingBlock(new MangaedMangoOakGrower(), AbstractBlock.Properties.from(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> POTTED_MANGAED_MANGO_OAK_SAPLING = BLOCKS.register("potted_mangaed_mango_oak_sapling", () -> new FlowerPotBlock(BMBlocks.MANGAED_MANGO_OAK_SAPLING.get(), AbstractBlock.Properties.from(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> MID_HILLARY_BLOCK = BLOCKS.register("mid_hillary_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.MAGENTA).harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(5, 6).sound(SoundType.METAL)));
    public static final RegistryObject<Block> LEANDRO_TOY = BLOCKS.register("leandro_toy", () -> new ToyBlock(ToyBlock.Type.LEANDRO));
    public static final RegistryObject<Block> TEENAGER_ALICE_TOY = BLOCKS.register("teenager_alice_toy", () -> new ToyBlock(ToyBlock.Type.TEENAGER_ALICE));
    public static final RegistryObject<Block> QUEEN_LUCY_PET_RELIC = BLOCKS.register("queen_sophie_pet_relic", () -> new QueenLucyPetRelicBlock(AbstractBlock.Properties.from(Blocks.GOLD_BLOCK).harvestLevel(2).setLightLevel(state -> 5)));
    public static final RegistryObject<Block> CHOCOLATE_NAKED_CAKE = BLOCKS.register("chocolate_naked_cake", () -> new ChocolateNakedCakeBlock(AbstractBlock.Properties.from(Blocks.CAKE)));
    public static final RegistryObject<Block> STRIPPED_CRYSTALLINE_BIRCH_LOG = BLOCKS.register("stripped_crystalline_birch_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(2).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> STRIPPED_CRYSTALLINE_BIRCH_WOOD = BLOCKS.register("stripped_crystalline_birch_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(2).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> CRYSTALLINE_BIRCH_GRAPE_VINE_POST = BLOCKS.register("crystalline_birch_grape_vine_post", () -> new GrapeVinePostBlock(AbstractBlock.Properties.from(CRYSTALLINE_BIRCH_PLANKS.get()).tickRandomly().hardnessAndResistance(0.5F).sound(SoundType.SWEET_BERRY_BUSH).notSolid()));
    public static final RegistryObject<Block> ENDER_DRAGON_FRIED_EGG_FLOWER = BLOCKS.register("ender_dragon_fried_egg_flower", () -> new EnderDragonFriedEggFlowerBlock(Effects.LEVITATION, 10, AbstractBlock.Properties.from(Blocks.POPPY).sound(SoundType.CROP)));
    public static final RegistryObject<Block> POTTED_ENDER_DRAGON_FRIED_EGG_FLOWER = BLOCKS.register("potted_ender_dragon_fried_egg_flower", () -> new FlowerPotBlock(ENDER_DRAGON_FRIED_EGG_FLOWER.get(), AbstractBlock.Properties.from(Blocks.POTTED_POPPY)));
    public static final RegistryObject<Block> CRYSTALLINE_BIRCH_LADDER = BLOCKS.register("crystalline_birch_ladder", () -> new LadderBlock(AbstractBlock.Properties.from(Blocks.LADDER)));
    public static final RegistryObject<Block> ANGELIC_PILLAR = BLOCKS.register("angelic_pillar", () -> new RotatedPillarBlock(AbstractBlock.Properties.from(ANGELIC_BLOCK.get())));
    public static final RegistryObject<Block> MOSSY_ANGELIC_BRICKS = BLOCKS.register("mossy_angelic_bricks", () -> new Block(AbstractBlock.Properties.from(ANGELIC_BLOCK.get())));
    public static final RegistryObject<Block> MOSSY_ANGELIC_BRICK_STAIRS = BLOCKS.register("mossy_angelic_brick_stairs", () -> new StairsBlock(() -> MOSSY_ANGELIC_BRICKS.get().getDefaultState(), AbstractBlock.Properties.from(ANGELIC_BLOCK.get())));
    public static final RegistryObject<Block> MOSSY_ANGELIC_BRICK_SLAB = BLOCKS.register("mossy_angelic_brick_slab", () -> new SlabBlock(AbstractBlock.Properties.from(ANGELIC_BLOCK.get())));
    public static final RegistryObject<Block> MOSSY_ANGELIC_BRICK_WALL = BLOCKS.register("mossy_angelic_brick_wall", () -> new WallBlock(AbstractBlock.Properties.from(ANGELIC_BLOCK.get())));
    public static final RegistryObject<Block> INSOMNIA_SOPHIE_HEAD = BLOCKS.register("insomnia_sophie_head", () -> new BMHeadBlock(AbstractBlock.Properties.from(Blocks.PLAYER_HEAD)));
    public static final RegistryObject<Block> INSOMNIA_SOPHIE_WALL_HEAD = BLOCKS.register("insomnia_sophie_wall_head", () -> new BMWallHeadBlock(AbstractBlock.Properties.from(Blocks.PLAYER_WALL_HEAD).lootFrom(BMBlocks.INSOMNIA_SOPHIE_HEAD)));
    public static final RegistryObject<Block> EMERIOND_BLOCK = BLOCKS.register("emeriond_block", () -> new Block(AbstractBlock.Properties.from(Blocks.DIAMOND_BLOCK)));

    // 1.8.0: Coldterm, Warmterm and Obsiditerm Related Blocks:
    public static final RegistryObject<Block> COLDTERM_BLOCK = BLOCKS.register("coldterm_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.WARPED_NYLIUM).sound(SoundType.METAL).harvestLevel(3).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(50, 1200)));
    public static final RegistryObject<Block> COLDTERM_BRICKS = BLOCKS.register("coldterm_bricks", () -> new Block(AbstractBlock.Properties.from(COLDTERM_BLOCK.get())));
    public static final RegistryObject<Block> COLDTERM_BRICK_STAIRS = BLOCKS.register("coldterm_brick_stairs", () -> new StairsBlock(() -> COLDTERM_BLOCK.get().getDefaultState(), AbstractBlock.Properties.from(COLDTERM_BLOCK.get())));
    public static final RegistryObject<Block> COLDTERM_BRICK_SLAB = BLOCKS.register("coldterm_brick_slab", () -> new SlabBlock(AbstractBlock.Properties.from(COLDTERM_BLOCK.get())));
    public static final RegistryObject<Block> COLDTERM_BRICK_WALL = BLOCKS.register("coldterm_brick_wall", () -> new WallBlock(AbstractBlock.Properties.from(COLDTERM_BLOCK.get())));
    public static final RegistryObject<Block> WARMTERM_BLOCK = BLOCKS.register("warmterm_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.YELLOW).sound(SoundType.METAL).harvestLevel(3).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(50, 1200)));
    public static final RegistryObject<Block> WARMTERM_BRICKS = BLOCKS.register("warmterm_bricks", () -> new Block(AbstractBlock.Properties.from(WARMTERM_BLOCK.get())));
    public static final RegistryObject<Block> WARMTERM_BRICK_STAIRS = BLOCKS.register("warmterm_brick_stairs", () -> new StairsBlock(() -> WARMTERM_BLOCK.get().getDefaultState(), AbstractBlock.Properties.from(WARMTERM_BLOCK.get())));
    public static final RegistryObject<Block> WARMTERM_BRICK_SLAB = BLOCKS.register("warmterm_brick_slab", () -> new SlabBlock(AbstractBlock.Properties.from(WARMTERM_BLOCK.get())));
    public static final RegistryObject<Block> WARMTERM_BRICK_WALL = BLOCKS.register("warmterm_brick_wall", () -> new WallBlock(AbstractBlock.Properties.from(WARMTERM_BLOCK.get())));
    public static final RegistryObject<Block> CHISELED_OBSIDITERM = BLOCKS.register("chiseled_obsiditerm", () -> new Block(AbstractBlock.Properties.from(Blocks.OBSIDIAN).harvestLevel(3).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> OBSIDITERM_BRICKS = BLOCKS.register("obsiditerm_bricks", () -> new Block(AbstractBlock.Properties.from(CHISELED_OBSIDITERM.get())));
    public static final RegistryObject<Block> OBSIDITERM_BRICK_STAIRS = BLOCKS.register("obsiditerm_brick_stairs", () -> new StairsBlock(() -> OBSIDITERM_BRICKS.get().getDefaultState(), AbstractBlock.Properties.from(CHISELED_OBSIDITERM.get())));
    public static final RegistryObject<Block> OBSIDITERM_BRICK_SLAB = BLOCKS.register("obsiditerm_brick_slab", () -> new SlabBlock(AbstractBlock.Properties.from(CHISELED_OBSIDITERM.get())));
    public static final RegistryObject<Block> OBSIDITERM_BRICK_WALL = BLOCKS.register("obsiditerm_brick_wall", () -> new WallBlock(AbstractBlock.Properties.from(CHISELED_OBSIDITERM.get())));

    // 1.8.0: Aljan Content:
    public static final RegistryObject<Block> ALJAMIC_SAND = BLOCKS.register("aljamic_sand", () -> new SandBlock(0xD4EAEA, AbstractBlock.Properties.create(Material.SAND, BMMaterials.ALJAN).hardnessAndResistance(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ALJAMIC_GLASS = BLOCKS.register("aljamic_glass", () -> new GlassBlock(AbstractBlock.Properties.from(Blocks.GLASS)));
    public static final RegistryObject<Block> ALJAMIC_GLASS_PANE = BLOCKS.register("aljamic_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.from(Blocks.GLASS_PANE)));
    public static final RegistryObject<Block> ALJAMIC_DIRT_PATH = BLOCKS.register("aljamic_dirt_path", () -> new AljamicDirtPathBlock(AbstractBlock.Properties.create(Material.EARTH, MaterialColor.BLUE).hardnessAndResistance(0.65F).sound(SoundType.PLANT).setBlocksVision(BMBlocks::needsPostProcessing).setSuffocates(BMBlocks::needsPostProcessing)));
    public static final RegistryObject<Block> JANTICAL_BLOCK = BLOCKS.register("jantical_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON, BMMaterials.ALJAN).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(5, 6).sound(SoundType.METAL)));
    public static final RegistryObject<Block> WILD_ALJAMIC_ONIONS = BLOCKS.register("wild_aljamic_onions", () -> new WildAljamicOnionsBlock(AbstractBlock.Properties.create(Material.PLANTS, BMMaterials.ALJAN).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> ALJANSTEEL_CHAIN = BLOCKS.register("aljansteel_chain", () -> new ChainBlock(AbstractBlock.Properties.from(Blocks.CHAIN)));
    public static final RegistryObject<Block> ALJANSTEEL_BLOCK = BLOCKS.register("aljansteel_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON, BMMaterials.ALJAN).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(6, 7).sound(SoundType.METAL)));
    public static final RegistryObject<Block> RAW_ALJAMIC_COPPER_BLOCK = BLOCKS.register("raw_aljamic_copper_block", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, BMMaterials.ALJAN).harvestLevel(1).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5, 6)));
    public static final RegistryObject<Block> RAW_ALJAMIC_TIN_BLOCK = BLOCKS.register("raw_aljamic_tin_block", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, BMMaterials.ALJAN).harvestLevel(1).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5, 6)));
    public static final RegistryObject<Block> CARAMELED_HAY_BALE = BLOCKS.register("carameled_hay_bale", () -> new HayBlock(AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.ADOBE).hardnessAndResistance(0.5F).sound(SoundType.PLANT)));
    public static final RegistryObject<Block> CHARJAN_CRYSTALLINE_BIRCH_TORCH = BLOCKS.register("charjan_crystalline_birch_torch", () -> new TorchBlock(AbstractBlock.Properties.from(Blocks.TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_CRYSTALLINE_BIRCH_WALL_TORCH = BLOCKS.register("charjan_crystalline_birch_wall_torch", () -> new WallTorchBlock(AbstractBlock.Properties.from(Blocks.TORCH).lootFrom(BMBlocks.CHARJAN_CRYSTALLINE_BIRCH_TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_GOLDENWOOD_TORCH = BLOCKS.register("charjan_goldenwood_torch", () -> new TorchBlock(AbstractBlock.Properties.from(Blocks.TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_GOLDENWOOD_WALL_TORCH = BLOCKS.register("charjan_goldenwood_wall_torch", () -> new WallTorchBlock(AbstractBlock.Properties.from(Blocks.TORCH).lootFrom(BMBlocks.CHARJAN_GOLDENWOOD_TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_GUAVA_TORCH = BLOCKS.register("charjan_guava_torch", () -> new TorchBlock(AbstractBlock.Properties.from(Blocks.TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_GUAVA_WALL_TORCH = BLOCKS.register("charjan_guava_wall_torch", () -> new WallTorchBlock(AbstractBlock.Properties.from(Blocks.TORCH).lootFrom(BMBlocks.CHARJAN_GUAVA_TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_JABUTICABA_TORCH = BLOCKS.register("charjan_jabuticaba_torch", () -> new TorchBlock(AbstractBlock.Properties.from(Blocks.TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_JABUTICABA_WALL_TORCH = BLOCKS.register("charjan_jabuticaba_wall_torch", () -> new WallTorchBlock(AbstractBlock.Properties.from(Blocks.TORCH).lootFrom(BMBlocks.CHARJAN_JABUTICABA_TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_CORK_OAK_TORCH = BLOCKS.register("charjan_cork_oak_torch", () -> new TorchBlock(AbstractBlock.Properties.from(Blocks.TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_CORK_OAK_WALL_TORCH = BLOCKS.register("charjan_cork_oak_wall_torch", () -> new WallTorchBlock(AbstractBlock.Properties.from(Blocks.TORCH).lootFrom(BMBlocks.CHARJAN_CORK_OAK_TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_HILLARY_TORCH = BLOCKS.register("charjan_hillary_torch", () -> new TorchBlock(AbstractBlock.Properties.from(Blocks.TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_HILLARY_WALL_TORCH = BLOCKS.register("charjan_hillary_wall_torch", () -> new WallTorchBlock(AbstractBlock.Properties.from(Blocks.TORCH).lootFrom(BMBlocks.CHARJAN_HILLARY_TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_DEVIL_TORCH = BLOCKS.register("charjan_devil_torch", () -> new TorchBlock(AbstractBlock.Properties.from(Blocks.TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_DEVIL_WALL_TORCH = BLOCKS.register("charjan_devil_wall_torch", () -> new WallTorchBlock(AbstractBlock.Properties.from(Blocks.TORCH).lootFrom(BMBlocks.CHARJAN_DEVIL_TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_ANGELIC_TORCH = BLOCKS.register("charjan_angelic_torch", () -> new TorchBlock(AbstractBlock.Properties.from(Blocks.TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_ANGELIC_WALL_TORCH = BLOCKS.register("charjan_angelic_wall_torch", () -> new WallTorchBlock(AbstractBlock.Properties.from(Blocks.TORCH).lootFrom(BMBlocks.CHARJAN_ANGELIC_TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_MID_TERM_TORCH = BLOCKS.register("charjan_mid_term_torch", () -> new TorchBlock(AbstractBlock.Properties.from(Blocks.TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_MID_TERM_WALL_TORCH = BLOCKS.register("charjan_mid_term_wall_torch", () -> new WallTorchBlock(AbstractBlock.Properties.from(Blocks.TORCH).lootFrom(BMBlocks.CHARJAN_MID_TERM_TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_ALJAMEED_TORCH = BLOCKS.register("charjan_aljameed_torch", () -> new TorchBlock(AbstractBlock.Properties.from(Blocks.TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_ALJAMEED_WALL_TORCH = BLOCKS.register("charjan_aljameed_wall_torch", () -> new WallTorchBlock(AbstractBlock.Properties.from(Blocks.TORCH).lootFrom(BMBlocks.CHARJAN_ALJAMEED_TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> ALJAN_LIGHT_BLUE_STAINED_GLASS = BLOCKS.register("aljan_light_blue_stained_glass", () -> new CustomBeamGlassBlock(0xD4EAEA, AbstractBlock.Properties.create(Material.GLASS, BMMaterials.ALJAN).hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(BMBlocks::neverAllowSpawns).setOpaque(BMBlocks::isntSolid).setSuffocates(BMBlocks::isntSolid).setBlocksVision(BMBlocks::isntSolid)));
    public static final RegistryObject<Block> ALJAN_LIGHT_BLUE_STAINED_GLASS_PANE = BLOCKS.register("aljan_light_blue_stained_glass_pane", () -> new CustomBeamGlassPaneBlock(0xD4EAEA, AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid()));
    public static final RegistryObject<Block> POISON_BROWN_STAINED_GLASS = BLOCKS.register("poison_brown_stained_glass", () -> new CustomBeamGlassBlock(0x752802, AbstractBlock.Properties.create(Material.GLASS, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(BMBlocks::neverAllowSpawns).setOpaque(BMBlocks::isntSolid).setSuffocates(BMBlocks::isntSolid).setBlocksVision(BMBlocks::isntSolid)));
    public static final RegistryObject<Block> POISON_BROWN_STAINED_GLASS_PANE = BLOCKS.register("poison_brown_stained_glass_pane", () -> new CustomBeamGlassPaneBlock(0x752802, AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid()));
    public static final RegistryObject<Block> INSOMNIAN_STAINED_GLASS = BLOCKS.register("insomnian_stained_glass", () -> new CustomBeamGlassBlock(0x5F7AB0, AbstractBlock.Properties.create(Material.GLASS, MaterialColor.BLUE_TERRACOTTA).hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(BMBlocks::neverAllowSpawns).setOpaque(BMBlocks::isntSolid).setSuffocates(BMBlocks::isntSolid).setBlocksVision(BMBlocks::isntSolid)));
    public static final RegistryObject<Block> INSOMNIAN_STAINED_GLASS_PANE = BLOCKS.register("insomnian_stained_glass_pane", () -> new CustomBeamGlassPaneBlock(0x5F7AB0, AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid()));

    // 1.8.0: Avondalic Willow Wood:
    public static final RegistryObject<Block> AVONDALIC_NYLIUM = BLOCKS.register("avondalic_nylium", () -> new AljamicGrassBlock(AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.PURPLE).tickRandomly().hardnessAndResistance(0.6F).sound(SoundType.PLANT).harvestTool(ToolType.SHOVEL)));
    public static final RegistryObject<Block> AVONDALIC_WILLOW_LEAVES = BLOCKS.register("avondalic_willow_leaves", () -> createLeavesBlock(MaterialColor.MAGENTA));
    public static final RegistryObject<Block> AVONDALIC_WILLOW_SAPLING = BLOCKS.register("avondalic_willow_sapling", () -> new SaplingBlock(new AvondalicWillowGrower(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_AVONDALIC_WILLOW_SAPLING = BLOCKS.register("potted_avondalic_willow_sapling", () -> new FlowerPotBlock(BMBlocks.AVONDALIC_WILLOW_SAPLING.get(), AbstractBlock.Properties.from(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> AVONDALIC_WILLOW_LOG = BLOCKS.register("avondalic_willow_log", () -> createLogBlock(MaterialColor.MAGENTA, MaterialColor.WARPED_HYPHAE));
    public static final RegistryObject<Block> AVONDALIC_WILLOW_WOOD = BLOCKS.register("avondalic_willow_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WARPED_HYPHAE).hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_AVONDALIC_WILLOW_LOG = BLOCKS.register("stripped_avondalic_willow_log", () -> createLogBlock(MaterialColor.MAGENTA, MaterialColor.MAGENTA));
    public static final RegistryObject<Block> STRIPPED_AVONDALIC_WILLOW_WOOD = BLOCKS.register("stripped_avondalic_willow_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.MAGENTA).hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> AVONDALIC_WILLOW_PLANKS = BLOCKS.register("avondalic_willow_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.MAGENTA).hardnessAndResistance(2, 3).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> AVONDALIC_WILLOW_STAIRS = BLOCKS.register("avondalic_willow_stairs", () -> new StairsBlock(() -> AVONDALIC_WILLOW_PLANKS.get().getDefaultState(), AbstractBlock.Properties.from(AVONDALIC_WILLOW_PLANKS.get())));
    public static final RegistryObject<Block> AVONDALIC_WILLOW_SLAB = BLOCKS.register("avondalic_willow_slab", () -> new SlabBlock(AbstractBlock.Properties.from(AVONDALIC_WILLOW_PLANKS.get())));
    public static final RegistryObject<Block> AVONDALIC_WILLOW_FENCE = BLOCKS.register("avondalic_willow_fence", () -> new FenceBlock(AbstractBlock.Properties.from(AVONDALIC_WILLOW_PLANKS.get())));
    public static final RegistryObject<Block> AVONDALIC_WILLOW_FENCE_GATE = BLOCKS.register("avondalic_willow_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.from(AVONDALIC_WILLOW_PLANKS.get())));
    public static final RegistryObject<Block> AVONDALIC_WILLOW_PRESSURE_PLATE = BLOCKS.register("avondalic_willow_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.from(AVONDALIC_WILLOW_PLANKS.get()).doesNotBlockMovement().hardnessAndResistance(0.5F)));
    public static final RegistryObject<Block> AVONDALIC_WILLOW_BUTTON = BLOCKS.register("avondalic_willow_button", () -> new WoodButtonBlock(AbstractBlock.Properties.from(AVONDALIC_WILLOW_PLANKS.get()).doesNotBlockMovement().hardnessAndResistance(0.5F)));
    public static final RegistryObject<Block> AVONDALIC_WILLOW_DOOR = BLOCKS.register("avondalic_willow_door", () -> new DoorBlock(AbstractBlock.Properties.from(AVONDALIC_WILLOW_PLANKS.get()).hardnessAndResistance(3).notSolid()));
    public static final RegistryObject<Block> AVONDALIC_WILLOW_TRAPDOOR = BLOCKS.register("avondalic_willow_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.from(AVONDALIC_WILLOW_PLANKS.get()).hardnessAndResistance(3).notSolid()));
    public static final RegistryObject<Block> AVONDALIC_WILLOW_GRAPE_VINE_POST = BLOCKS.register("avondalic_willow_grape_vine_post", () -> new GrapeVinePostBlock(AbstractBlock.Properties.from(AVONDALIC_WILLOW_PLANKS.get()).tickRandomly().hardnessAndResistance(0.5F).sound(SoundType.SWEET_BERRY_BUSH).notSolid()));
    public static final RegistryObject<Block> AVONDALIC_WILLOW_LADDER = BLOCKS.register("avondalic_willow_ladder", () -> new LadderBlock(AbstractBlock.Properties.from(Blocks.LADDER)));
    public static final RegistryObject<Block> CHARJAN_AVONDALIC_WILLOW_TORCH = BLOCKS.register("charjan_avondalic_willow_torch", () -> new TorchBlock(AbstractBlock.Properties.from(Blocks.TORCH), ParticleTypes.FLAME));
    public static final RegistryObject<Block> CHARJAN_AVONDALIC_WILLOW_WALL_TORCH = BLOCKS.register("charjan_avondalic_willow_wall_torch", () -> new WallTorchBlock(AbstractBlock.Properties.from(Blocks.TORCH).lootFrom(BMBlocks.CHARJAN_AVONDALIC_WILLOW_TORCH), ParticleTypes.FLAME));

    private static RotatedPillarBlock createLogBlock(MaterialColor topColor, MaterialColor sideColor) {
        return new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, (state) -> state.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : sideColor).hardnessAndResistance(2).sound(SoundType.WOOD));
    }

    private static RotatedPillarBlock createLogBlock(MaterialColor topColor, MaterialColor sideColor, float hardness, float resistance) {
        return new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, (state) -> state.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : sideColor).hardnessAndResistance(hardness, resistance).sound(SoundType.WOOD));
    }

    private static LeavesBlock createLeavesBlock(MaterialColor color) {
        return new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES, color == null ? MaterialColor.FOLIAGE : color).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid().setAllowsSpawn(BMBlocks::allowsSpawnOnLeaves).setSuffocates(BMBlocks::isntSolid).setBlocksVision(BMBlocks::isntSolid));
    }

    private static Boolean allowsSpawnOnLeaves(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) {
        return entity.isContained(BMTags.EntityTypes.CAN_SPAWN_ON_LEAVES);
    }

    private static boolean neverAllowSpawns(BlockState state, IBlockReader world, BlockPos pos, EntityType<?> entity) {
        return false;
    }

    private static boolean isntSolid(BlockState state, IBlockReader world, BlockPos pos) {
        return false;
    }

    private static boolean needsPostProcessing(BlockState state, IBlockReader world, BlockPos pos) {
        return true;
    }
}