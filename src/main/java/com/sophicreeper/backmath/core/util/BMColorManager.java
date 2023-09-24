package com.sophicreeper.backmath.core.util;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BackMath.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BMColorManager {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    // Todo: Swap to Forge's RegisterColorHandlersEvent.Block
    public static void registerBlockColorHandlers(final RegisterColorHandlersEvent.Block event) {
        event.getBlockColors().register((x, reader, pos, u) -> reader != null && pos != null ? BiomeColors.getAverageGrassColor(reader, pos) : GrassColor.get(0.5d, 1),
                BMBlocks.ALJAMIC_GRASS_BLOCK.get(), BMBlocks.AVONDALIC_NYLIUM.get());

        event.getBlockColors().register((x, reader, pos, u) -> reader != null && pos != null ? BiomeColors.getAverageFoliageColor(reader, pos) : FoliageColor.getDefaultColor(),
                BMBlocks.JABUTICABA_LEAVES.get(), BMBlocks.GUARANA_OAK_LEAVES.get(), BMBlocks.MANGO_OAK_LEAVES.get(), BMBlocks.PINEAPPLE_OAK_LEAVES.get(), BMBlocks.LEMON_OAK_LEAVES.get(),
                BMBlocks.BANANA_JUNGLE_LEAVES.get(), BMBlocks.MANGAED_MANGO_OAK_LEAVES.get(), BMBlocks.ORANGE_OAK_LEAVES.get(), BMBlocks.CORK_OAK_LEAVES.get(), BMBlocks.ALJANWOOD_LEAVES.get(),
                BMBlocks.ALJANCAP_LEAVES.get(), BMBlocks.INSOMNIAN_LEAVES.get(), BMBlocks.AMARACAP_LEAVES.get(), BMBlocks.AVONDALIC_WILLOW_LEAVES.get());

        event.getBlockColors().register((x, reader, pos, u) -> FoliageColor.getEvergreenColor(), BMBlocks.GRAPE_VINE_LEAVES.get());
        event.getBlockColors().register((x, reader, pos, u) -> FoliageColor.getBirchColor(), BMBlocks.ALJAME_BIRCH_LEAVES.get());
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerItemColorHandlers(final RegisterColorHandlersEvent.Item event) {
        event.getItemColors().register((stack, color) -> GrassColor.get(0.5d, 1), AxolotlTest.ALJAMIC_GRASS_BLOCK.get(), BMBlocks.AVONDALIC_NYLIUM.get(),
                BMBlocks.JABUTICABA_LEAVES.get(), BMBlocks.GUARANA_OAK_LEAVES.get(), BMBlocks.MANGO_OAK_LEAVES.get(), BMBlocks.PINEAPPLE_OAK_LEAVES.get(), BMBlocks.LEMON_OAK_LEAVES.get(),
                BMBlocks.BANANA_JUNGLE_LEAVES.get(), BMBlocks.MANGAED_MANGO_OAK_LEAVES.get(), BMBlocks.ORANGE_OAK_LEAVES.get(), BMBlocks.CORK_OAK_LEAVES.get(), BMBlocks.ALJANWOOD_LEAVES.get(),
                BMBlocks.ALJANCAP_LEAVES.get(), BMBlocks.INSOMNIAN_LEAVES.get(), BMBlocks.AMARACAP_LEAVES.get(), BMBlocks.AVONDALIC_WILLOW_LEAVES.get());

        event.getItemColors().register((stack, color) -> FoliageColor.getEvergreenColor(), BMBlocks.GRAPE_VINE_LEAVES.get());
        event.getItemColors().register((stack, color) -> FoliageColor.getBirchColor(), BMBlocks.ALJAME_BIRCH_LEAVES.get());
    }
}
