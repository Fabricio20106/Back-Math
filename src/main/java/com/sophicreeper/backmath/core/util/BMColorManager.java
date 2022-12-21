package com.sophicreeper.backmath.core.util;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import net.minecraft.world.GrassColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BackMath.MOD_ID)
public class BMColorManager {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerBlockColorHandlers(final ColorHandlerEvent.Block event) {
        event.getBlockColors().register((x, reader, pos, u) -> reader != null && pos != null
                ? BiomeColors.getGrassColor(reader, pos) : GrassColors.get(0.5d, 1.0d), BMBlocks.ALJAMIC_GRASS_BLOCK.get());
    }
}
