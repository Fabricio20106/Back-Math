package com.sophicreeper.backmath.core.proxy;

import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import com.sophicreeper.backmath.core.world.level.fluid.BMFluids;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.sophicreeper.backmath.core.client.BackMath.MOD_ID;
import static net.minecraft.client.renderer.item.ItemProperties.register;

public class ClientProxy extends CommonProxy {
    public ClientProxy() {
        super();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        // Block and fluid render lookups
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.FRIED_EGG_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ANGELIC_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ANGELIC_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.GUARANA_OAK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.MANGO_OAK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.GUARANA_OAK_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.MANGO_OAK_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.HILLARY_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.MID_TERM_HILLARY_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.MID_TERM_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.RED_YELLOW_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_FRIED_EGG_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_RED_YELLOW_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.DEVIL_STAINED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.DEVIL_STAINED_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_GUARANA_OAK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_MANGO_OAK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.HILLARY_TORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.HILLARY_WALL_TORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.GRAPE_VINE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_GRAPE_VINE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.GRAPE_VINE_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.DEVIL_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.DEVIL_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ANGRY_SOPHIE_HEAD.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ANGRY_SOPHIE_WALL_HEAD.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ALJAME_BIRCH_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ALJAME_BIRCH_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_ALJAME_BIRCH_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CRYSTALLINE_ANGELIC_ORE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.LEMON_OAK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_LEMON_OAK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.QUEEN_SOPHIE_RELIC.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.QUEEN_SOPHIE_HEAD.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.QUEEN_SOPHIE_WALL_HEAD.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.PINEAPPLE_OAK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.PINEAPPLE_OAK_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_PINEAPPLE_OAK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_SAPLING.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_PLANKS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_TRAPDOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_STAIRS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_SLAB.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_FENCE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_FENCE_GATE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_PRESSURE_PLATE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_BUTTON.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.MID_TERM_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.MID_TERM_SOUL_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_TURTLE_FRIED_EGG_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.TURTLE_FRIED_EGG_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_CRYSTALLINE_BIRCH_SAPLING.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ALJANWOOD_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_ALJANWOOD_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ALJANWOOD_LADDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ALJANWOOD_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ALJANWOOD_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.OAK_GRAPE_VINE_POST.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.SPRUCE_GRAPE_VINE_POST.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.BIRCH_GRAPE_VINE_POST.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.JUNGLE_GRAPE_VINE_POST.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ACACIA_GRAPE_VINE_POST.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.DARK_OAK_GRAPE_VINE_POST.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CRIMSON_GRAPE_VINE_POST.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.WARPED_GRAPE_VINE_POST.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.OBSIDIAN_INFUSED_MID_TERM_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.OBSIDIAN_INFUSED_MID_TERM_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.MID_TERM_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ALJAN_TULIP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POISON_ROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ALJANSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.SLEEPSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_ALJANSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_SLEEPSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_ALJAN_TULIP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_POISON_ROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.INSOMNIAN_TULIP.get(), ClientProxy::getDoubleLayer);
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.INSOMNIAN_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.INSOMNIAN_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_INSOMNIAN_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_INSOMNIAN_TULIP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ALJANCAP_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ALJANCAP_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_ALJANCAP_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ALJANCAP_LADDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.INSOMNIAN_LADDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ALJANWOOD_GRAPE_VINE_POST.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ALJANCAP_GRAPE_VINE_POST.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.INSOMNIAN_GRAPE_VINE_POST.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ALJAMIC_GRASS_BLOCK.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.SLEEPYSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_SLEEPYSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ORANGE_OAK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.BANANA_JUNGLE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_ORANGE_OAK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_BANANA_JUNGLE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_STAIRS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CHARJAN_WOOD_TORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CHARJAN_WOOD_WALL_TORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CHARJAN_ALJANWOOD_TORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CHARJAN_ALJANWOOD_WALL_TORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CHARJAN_ALJANCAP_TORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CHARJAN_ALJANCAP_WALL_TORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CHARJAN_INSOMNIAN_TORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CHARJAN_INSOMNIAN_WALL_TORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CARAMELED_WHEAT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.WILD_CARAMELED_WHEAT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ALJAMIC_ONIONS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.DEVIL_CHAIN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ANGELIC_CHAIN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CHRISTIAN_MID_TERM_CHAIN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.MILKLLARY_CHAIN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.MID_HILLARY_CHAIN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.MID_TERM_CHAIN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.OBSIDIAN_INFUSED_MID_TERM_CHAIN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ALJAMEED_CHAIN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.MOONERING_CHAIN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CRYSTALLINE_ANGELIC_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.STICKY_AMARACAMEL_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.GUAVA_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.GUAVA_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.GUAVA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_GUAVA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.GUAVA_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.MANGAED_MANGO_OAK_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.GUAVA_LADDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ALJAMIC_GLASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ALJAMIC_GLASS_PANE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.QUEEN_SOPHIE_PET_RELIC.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.WILD_ALJAMIC_ONIONS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.GUAVA_GRAPE_VINE_POST.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ALJANSTEEL_CHAIN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.GOLDENWOOD_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_GOLDENWOOD_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ENCHANTED_GOLDENWOOD_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_ENCHANTED_GOLDENWOOD_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.GOLDENWOOD_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ENCHANTED_GOLDENWOOD_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.GOLDENWOOD_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.GOLDENWOOD_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.GOLDENWOOD_GRAPE_VINE_POST.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.JABUTICABA_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.JABUTICABA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_JABUTICABA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.JABUTICABA_GRAPE_VINE_POST.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.AVONDALIC_WILLOW_GRAPE_VINE_POST.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.AVONDALIC_WILLOW_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.STRIPPED_CRYSTALLINE_BIRCH_LOG.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.STRIPPED_CRYSTALLINE_BIRCH_WOOD.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.AVONDALIC_NYLIUM.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.AVONDALIC_WILLOW_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_LOG.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_WOOD.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.JABUTICABA_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.JABUTICABA_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.AVONDALIC_WILLOW_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.AVONDALIC_WILLOW_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_AVONDALIC_WILLOW_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.AVONDALIC_WILLOW_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.AVONDALIC_WILLOW_LADDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.JABUTICABA_LADDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CORK_OAK_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CORK_OAK_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CORK_OAK_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CORK_OAK_GRAPE_VINE_POST.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CORK_OAK_LADDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_GRAPE_VINE_POST.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.MANGAED_MANGO_OAK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_MANGAED_MANGO_OAK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.ENDER_DRAGON_FRIED_EGG_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.POTTED_ENDER_DRAGON_FRIED_EGG_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_LADDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.GOLDENWOOD_LADDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.INSOMNIA_SOPHIE_HEAD.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMBlocks.INSOMNIA_SOPHIE_WALL_HEAD.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BMFluids.HILLARY.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMFluids.FLOWING_HILLARY.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMFluids.MILKLLARY.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMFluids.FLOWING_MILKLLARY.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMFluids.LIQUID_ALJAME.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMFluids.FLOWING_LIQUID_ALJAME.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMFluids.SLEEPISHWATER.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMFluids.FLOWING_SLEEPISHWATER.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMFluids.LIQUID_MANGA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BMFluids.FLOWING_LIQUID_MANGA.get(), RenderType.translucent());

        // Entity renderers
        /*RenderingRegistry.registerEntityRenderingHandler(BMEntities.WANDERER_SOPHIE.get(), WandererSophieRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(BMEntities.ARCHER_LUCIA.get(), ArcherLuciaRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(BMEntities.ANGRY_SOPHIE.get(), AngrySophieRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(BMEntities.SHY_FABRICIO.get(), ShyFabricioRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(BMEntities.KARATE_LUCIA.get(), KarateLuciaRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(BMEntities.INSOMNIA_SOPHIE.get(), InsomniaSophieRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(BMEntities.QUEEN_SOPHIE.get(), QueenSophieRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(BMEntities.WARRIOR_SOPHIE.get(), WarriorSophieRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(BMEntities.QUEEN_SOPHIE_PET.get(), QueenSophiePetRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(BMEntities.ARCHER_INSOMNIA_SOPHIE.get(), ArcherInsomniaSophieRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(BMEntities.INSOMNIA_ZOMBIE.get(), InsomniaZombieRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(BMEntities.ZOMBIE_FABRICIO.get(), ZombieFabricioRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(BMEntities.AMARACAMELER.get(), AmaracamelerRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(BMEntities.MALAIKA.get(), MalaikaRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(BMEntities.JANTICLE.get(), JanticleRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(BMEntities.ALJAMIC_BONES.get(), AljamicBonesRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(BMEntities.SLEEPISH_SKELETON.get(), SleepishSkeletonRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(BMEntities.BACKMATH_BOAT.get(), BMBoatRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(BMEntities.INSOMNIA_ARROW.get(), InsomniaArrowRenderer::new);*/

        // Item properties
        register(AxolotlTest.DEVIL_SHIELD.get(), new ResourceLocation("blocking"), (stack, world, livingEntity, a) -> livingEntity != null && livingEntity.isUsingItem()&&
                livingEntity.getUseItem() == stack ? 1 : 0);
        register(AxolotlTest.ANGELIC_SHIELD.get(), new ResourceLocation("blocking"), (stack, world, livingEntity, a) -> livingEntity != null && livingEntity.isUsingItem()&&
                livingEntity.getUseItem() == stack ? 1 : 0);
        register(AxolotlTest.MID_TERM_SHIELD.get(), new ResourceLocation("blocking"), (stack, world, livingEntity, a) -> livingEntity != null && livingEntity.isUsingItem()&&
                livingEntity.getUseItem() == stack ? 1 : 0);

        register(AxolotlTest.ANGELIC_BOW.get(), new ResourceLocation("pull"), (stack, world, livingEntity, a) -> {
            if (livingEntity == null) {
                return 0;
            } else {
                return livingEntity.getUseItem() != stack ? 0 : (float) (stack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / 20;
            }
        });
        register(AxolotlTest.ANGELIC_BOW.get(), new ResourceLocation("pulling"), (stack, world, livingEntity, a) -> livingEntity != null && livingEntity.isUsingItem()&& livingEntity.getUseItem() == stack ? 1 : 0);
        register(AxolotlTest.ANGELIC_CROSSBOW.get(), new ResourceLocation("pulling"), (stack, world, livingEntity, a) -> livingEntity != null && livingEntity.isUsingItem()&& livingEntity.getUseItem() == stack && !CrossbowItem.isCharged(stack) ? 1 : 0);
        register(AxolotlTest.ANGELIC_CROSSBOW.get(), new ResourceLocation("charged"), (stack, world, livingEntity, a) -> livingEntity != null && CrossbowItem.isCharged(stack) ? 1 : 0);
        register(AxolotlTest.ANGELIC_CROSSBOW.get(), new ResourceLocation("firework"), (stack, world, livingEntity, a) -> livingEntity != null && CrossbowItem.isCharged(stack) && CrossbowItem.containsChargedProjectile(stack, Items.FIREWORK_ROCKET) ? 1 : 0);

        register(AxolotlTest.DEVIL_BOW.get(), new ResourceLocation("pull"), (stack, world, livingEntity, a) -> {
            if (livingEntity == null) {
                return 0;
            } else {
                return livingEntity.getUseItem() != stack ? 0 : (float) (stack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / 20;
            }
        });
        register(AxolotlTest.DEVIL_BOW.get(), new ResourceLocation("pulling"), (stack, world, livingEntity, a) -> livingEntity != null && livingEntity.isUsingItem()&& livingEntity.getUseItem() == stack ? 1 : 0);
        register(AxolotlTest.DEVIL_CROSSBOW.get(), new ResourceLocation("pulling"), (stack, world, livingEntity, a) -> livingEntity != null && livingEntity.isUsingItem()&& livingEntity.getUseItem() == stack && !CrossbowItem.isCharged(stack) ? 1 : 0);
        register(AxolotlTest.DEVIL_CROSSBOW.get(), new ResourceLocation("charged"), (stack, world, livingEntity,a ) -> livingEntity != null && CrossbowItem.isCharged(stack) ? 1 : 0);
        register(AxolotlTest.DEVIL_CROSSBOW.get(), new ResourceLocation("firework"), (stack, world, livingEntity, a) -> livingEntity != null && CrossbowItem.isCharged(stack) && CrossbowItem.containsChargedProjectile(stack, Items.FIREWORK_ROCKET) ? 1 : 0);

        register(AxolotlTest.MID_TERM_BOW.get(), new ResourceLocation("pull"), (stack, world, livingEntity, a) -> {
            if (livingEntity == null) {
                return 0;
            } else {
                return livingEntity.getUseItem() != stack ? 0 : (float) (stack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / 20;
            }
        });
        register(AxolotlTest.MID_TERM_BOW.get(), new ResourceLocation("pulling"), (stack, world, livingEntity, a) -> livingEntity != null && livingEntity.isUsingItem()&& livingEntity.getUseItem() == stack ? 1 : 0);
    }

    // Didn't work anyway.
    /*@SubscribeEvent
    public static void onModelBakeEvent(ModelEvent.ModifyBakingResult event) {
        for (BlockState blockState : BMBlocks.INSOMNIAN_TULIP.get().getStateContainer().getValidStates()) {
            ModelResourceLocation variantMRL = BlockModelShaper.stateToModelLocation(blockState);
            BakedModel existingModel = event.getModels().get(variantMRL);
            if (existingModel == null) {
                LOGGER.warn("Back Math: Did not find the expected vanilla baked model(s) for insomnian_tulip in registry");
            } else if (existingModel instanceof LightBakedModel) {
                LOGGER.warn("Back Math: Tried to replace LightBakedModel twice");
            } else {
                LightBakedModel lightBakedModel = new LightBakedModel();
                event.getModels().put(variantMRL, lightBakedModel);
            }
        }
    }*/

    // Double layer render lookup
    public static boolean getDoubleLayer(RenderType layerToCheck) {
        return layerToCheck == RenderType.cutout() || layerToCheck == RenderType.translucent();
    }
}
