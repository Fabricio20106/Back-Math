package com.sophicreeper.backmath.core.proxy;

import com.sophicreeper.backmath.core.client.LightBakedModel;
import com.sophicreeper.backmath.core.client.renderer.entity.*;
import com.sophicreeper.backmath.core.world.entity.BMEntities;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import com.sophicreeper.backmath.core.world.level.material.BMFluids;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.sophicreeper.backmath.core.client.BackMath.LOGGER;
import static net.minecraft.item.ItemModelsProperties.registerProperty;

public class ClientProxy extends CommonProxy {
    public ClientProxy() {
        super();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        // Block and Fluid Render Lookups
        RenderTypeLookup.setRenderLayer(BMBlocks.FRIED_EGG_FLOWER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ANGELIC_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ANGELIC_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.GUARANA_OAK_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.MANGO_OAK_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.GUARANA_OAK_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.MANGO_OAK_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.HILLARY_LANTERN.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.MID_TERM_HILLARY_LANTERN.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.MID_TERM_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.RED_YELLOW_FLOWER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_FRIED_EGG_FLOWER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_RED_YELLOW_FLOWER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.DEVIL_STAINED_GLASS.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMBlocks.DEVIL_STAINED_GLASS_PANE.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_GUARANA_OAK_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_MANGO_OAK_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.HILLARY_TORCH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.HILLARY_WALL_TORCH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.GRAPE_VINE_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_GRAPE_VINE_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.GRAPE_VINE_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.DEVIL_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.DEVIL_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ANGRY_SOPHIE_HEAD.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ANGRY_SOPHIE_WALL_HEAD.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ALJAME_BIRCH_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ALJAME_BIRCH_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_ALJAME_BIRCH_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.CRYSTALLINE_ANGELIC_ORE.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMBlocks.LEMON_OAK_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_LEMON_OAK_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.QUEEN_LUCY_RELIC.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.QUEEN_LUCY_HEAD.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.QUEEN_LUCY_WALL_HEAD.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.PINEAPPLE_OAK_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.PINEAPPLE_OAK_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_PINEAPPLE_OAK_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_SAPLING.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_PLANKS.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_TRAPDOOR.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_DOOR.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_STAIRS.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_SLAB.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_FENCE.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_FENCE_GATE.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_PRESSURE_PLATE.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_BUTTON.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMBlocks.MID_TERM_LANTERN.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.MID_TERM_SOUL_LANTERN.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_TURTLE_FRIED_EGG_FLOWER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.TURTLE_FRIED_EGG_FLOWER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_CRYSTALLINE_BIRCH_SAPLING.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMBlocks.ALJANWOOD_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_ALJANWOOD_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ALJANWOOD_LADDER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ALJANWOOD_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ALJANWOOD_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.OAK_GRAPE_VINE_POST.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.SPRUCE_GRAPE_VINE_POST.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.BIRCH_GRAPE_VINE_POST.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.JUNGLE_GRAPE_VINE_POST.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ACACIA_GRAPE_VINE_POST.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.DARK_OAK_GRAPE_VINE_POST.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.CRIMSON_GRAPE_VINE_POST.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.WARPED_GRAPE_VINE_POST.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.OBSIDIAN_INFUSED_MID_TERM_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.OBSIDIAN_INFUSED_MID_TERM_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.MID_TERM_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ALJAN_TULIP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POISON_ROSE.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ALJANSHROOM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.SLEEPSHROOM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_ALJANSHROOM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_SLEEPSHROOM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_ALJAN_TULIP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_POISON_ROSE.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.INSOMNIAN_TULIP.get(), ClientProxy::getDoubleLayer);
        RenderTypeLookup.setRenderLayer(BMBlocks.INSOMNIAN_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.INSOMNIAN_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_INSOMNIAN_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_INSOMNIAN_TULIP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ALJANCAP_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ALJANCAP_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_ALJANCAP_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ALJANCAP_LADDER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.INSOMNIAN_LADDER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ALJANWOOD_GRAPE_VINE_POST.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ALJANCAP_GRAPE_VINE_POST.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.INSOMNIAN_GRAPE_VINE_POST.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ALJAMIC_GRASS_BLOCK.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BMBlocks.SLEEPYSHROOM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_SLEEPYSHROOM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ORANGE_OAK_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.BANANA_JUNGLE_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_ORANGE_OAK_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_BANANA_JUNGLE_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_STAIRS.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMBlocks.CHARJAN_WOOD_TORCH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.CHARJAN_WOOD_WALL_TORCH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.CHARJAN_ALJANWOOD_TORCH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.CHARJAN_ALJANWOOD_WALL_TORCH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.CHARJAN_ALJANCAP_TORCH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.CHARJAN_ALJANCAP_WALL_TORCH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.CHARJAN_INSOMNIAN_TORCH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.CHARJAN_INSOMNIAN_WALL_TORCH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.CARAMELED_WHEAT.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.WILD_CARAMELED_WHEAT.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ALJAMIC_ONIONS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.DEVIL_CHAIN.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ANGELIC_CHAIN.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.CHRISTIAN_MID_TERM_CHAIN.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.MILKLLARY_CHAIN.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.MID_HILLARY_CHAIN.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.MID_TERM_CHAIN.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.OBSIDIAN_INFUSED_MID_TERM_CHAIN.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ALJAMEED_CHAIN.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.MOONERING_CHAIN.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.CRYSTALLINE_ANGELIC_BLOCK.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMBlocks.STICKY_AMARACAMEL_BLOCK.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMBlocks.GUAVA_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.GUAVA_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.GUAVA_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_GUAVA_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.GUAVA_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.MANGAED_MANGO_OAK_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.GUAVA_LADDER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ALJAMIC_GLASS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ALJAMIC_GLASS_PANE.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.QUEEN_SOPHIE_PET_RELIC.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.WILD_ALJAMIC_ONIONS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.GUAVA_GRAPE_VINE_POST.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ALJANSTEEL_CHAIN.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.GOLDENWOOD_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_GOLDENWOOD_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ENCHANTED_GOLDENWOOD_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_ENCHANTED_GOLDENWOOD_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.GOLDENWOOD_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ENCHANTED_GOLDENWOOD_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.GOLDENWOOD_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.GOLDENWOOD_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.GOLDENWOOD_GRAPE_VINE_POST.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.JABUTICABA_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.JABUTICABA_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_JABUTICABA_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.JABUTICABA_GRAPE_VINE_POST.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.AVONDALIC_WILLOW_GRAPE_VINE_POST.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.AVONDALIC_WILLOW_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.STRIPPED_CRYSTALLINE_BIRCH_LOG.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMBlocks.STRIPPED_CRYSTALLINE_BIRCH_WOOD.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMBlocks.AVONDALIC_NYLIUM.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BMBlocks.AVONDALIC_WILLOW_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_LOG.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_WOOD.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMBlocks.JABUTICABA_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.JABUTICABA_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.AVONDALIC_WILLOW_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.AVONDALIC_WILLOW_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_AVONDALIC_WILLOW_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.AVONDALIC_WILLOW_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.AVONDALIC_WILLOW_LADDER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.JABUTICABA_LADDER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.CORK_OAK_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.CORK_OAK_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.CORK_OAK_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.CORK_OAK_GRAPE_VINE_POST.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.CORK_OAK_LADDER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_GRAPE_VINE_POST.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMBlocks.MANGAED_MANGO_OAK_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_MANGAED_MANGO_OAK_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.ENDER_DRAGON_FRIED_EGG_FLOWER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.POTTED_ENDER_DRAGON_FRIED_EGG_FLOWER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.CRYSTALLINE_BIRCH_LADDER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.GOLDENWOOD_LADDER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.INSOMNIA_SOPHIE_HEAD.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMBlocks.INSOMNIA_SOPHIE_WALL_HEAD.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BMFluids.HILLARY.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMFluids.MILKLLARY.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMFluids.FLOWING_HILLARY.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMFluids.FLOWING_MILKLLARY.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMFluids.LIQUID_ALJAME.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMFluids.FLOWING_LIQUID_ALJAME.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMFluids.SLEEPISHWATER.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMFluids.FLOWING_SLEEPISHWATER.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMFluids.LIQUID_MANGA.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BMFluids.FLOWING_LIQUID_MANGA.get(), RenderType.getTranslucent());

        // Entity Renderers
        RenderingRegistry.registerEntityRenderingHandler(BMEntities.WANDERER_SOPHIE.get(), WandererSophieRenderer::new);
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
        RenderingRegistry.registerEntityRenderingHandler(BMEntities.INSOMNIA_ARROW.get(), InsomniaArrowRenderer::new);

        // Item Properties
        registerProperty(AxolotlTest.DEVIL_SHIELD.get(), new ResourceLocation("blocking"), (stack, world, livingEntity) -> livingEntity != null && livingEntity.isHandActive() &&
                livingEntity.getActiveItemStack() == stack ? 1 : 0);
        registerProperty(AxolotlTest.ANGELIC_SHIELD.get(), new ResourceLocation("blocking"), (stack, world, livingEntity) -> livingEntity != null && livingEntity.isHandActive() &&
                livingEntity.getActiveItemStack() == stack ? 1 : 0);
        registerProperty(AxolotlTest.MID_TERM_SHIELD.get(), new ResourceLocation("blocking"), (stack, world, livingEntity) -> livingEntity != null && livingEntity.isHandActive() &&
                livingEntity.getActiveItemStack() == stack ? 1 : 0);

        registerProperty(AxolotlTest.ANGELIC_BOW.get(), new ResourceLocation("pull"), (stack, world, livingEntity) -> {
            if (livingEntity == null) {
                return 0;
            } else {
                return livingEntity.getActiveItemStack() != stack ? 0 : (float) (stack.getUseDuration() - livingEntity.getItemInUseCount()) / 20;
            }
        });
        registerProperty(AxolotlTest.ANGELIC_BOW.get(), new ResourceLocation("pulling"), (stack, world, livingEntity) -> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == stack ? 1 : 0);
        registerProperty(AxolotlTest.ANGELIC_CROSSBOW.get(), new ResourceLocation("pulling"), (stack, world, livingEntity) -> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == stack && !CrossbowItem.isCharged(stack) ? 1 : 0);
        registerProperty(AxolotlTest.ANGELIC_CROSSBOW.get(), new ResourceLocation("charged"), (stack, world, livingEntity) -> livingEntity != null && CrossbowItem.isCharged(stack) ? 1 : 0);
        registerProperty(AxolotlTest.ANGELIC_CROSSBOW.get(), new ResourceLocation("firework"), (stack, world, livingEntity) -> livingEntity != null && CrossbowItem.isCharged(stack) && CrossbowItem.hasChargedProjectile(stack, Items.FIREWORK_ROCKET) ? 1 : 0);

        registerProperty(AxolotlTest.DEVIL_BOW.get(), new ResourceLocation("pull"), (stack, world, livingEntity) -> {
            if (livingEntity == null) {
                return 0;
            } else {
                return livingEntity.getActiveItemStack() != stack ? 0 : (float) (stack.getUseDuration() - livingEntity.getItemInUseCount()) / 20;
            }
        });
        registerProperty(AxolotlTest.DEVIL_BOW.get(), new ResourceLocation("pulling"), (stack, world, livingEntity) -> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == stack ? 1 : 0);
        registerProperty(AxolotlTest.DEVIL_CROSSBOW.get(), new ResourceLocation("pulling"), (stack, world, livingEntity) -> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == stack && !CrossbowItem.isCharged(stack) ? 1 : 0);
        registerProperty(AxolotlTest.DEVIL_CROSSBOW.get(), new ResourceLocation("charged"), (stack, world, livingEntity) -> livingEntity != null && CrossbowItem.isCharged(stack) ? 1 : 0);
        registerProperty(AxolotlTest.DEVIL_CROSSBOW.get(), new ResourceLocation("firework"), (stack, world, livingEntity) -> livingEntity != null && CrossbowItem.isCharged(stack) && CrossbowItem.hasChargedProjectile(stack, Items.FIREWORK_ROCKET) ? 1 : 0);

        registerProperty(AxolotlTest.MID_TERM_BOW.get(), new ResourceLocation("pull"), (stack, world, livingEntity) -> {
            if (livingEntity == null) {
                return 0;
            } else {
                return livingEntity.getActiveItemStack() != stack ? 0 : (float) (stack.getUseDuration() - livingEntity.getItemInUseCount()) / 20;
            }
        });
        registerProperty(AxolotlTest.MID_TERM_BOW.get(), new ResourceLocation("pulling"), (stack, world, livingEntity) -> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == stack ? 1 : 0);
    }

    @SubscribeEvent
    public static void onModelBakeEvent(ModelBakeEvent event) {
        for (BlockState blockState : BMBlocks.INSOMNIAN_TULIP.get().getStateContainer().getValidStates()) {
            ModelResourceLocation variantMRL = BlockModelShapes.getModelLocation(blockState);
            IBakedModel existingModel = event.getModelRegistry().get(variantMRL);
            if (existingModel == null) {
                LOGGER.warn(new TranslationTextComponent("messages.backmath.it_baked_model_not_found").toString());
            } else if (existingModel instanceof LightBakedModel) {
                LOGGER.warn(new TranslationTextComponent("messages.backmath.replace_light_baked_model").toString());
            } else {
                LightBakedModel lightBakedModel = new LightBakedModel();
                event.getModelRegistry().put(variantMRL, lightBakedModel);
            }
        }
    }

    // Double layer render lookup
    public static boolean getDoubleLayer(RenderType layerToCheck) {
        return layerToCheck == RenderType.getCutout() || layerToCheck == RenderType.getTranslucent();
    }
}
