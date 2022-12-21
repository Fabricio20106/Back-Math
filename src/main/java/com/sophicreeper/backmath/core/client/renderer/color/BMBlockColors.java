package com.sophicreeper.backmath.core.client.renderer.color;

import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.world.GrassColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BMBlockColors extends BlockColors {
    public static BlockColors init() {
        BlockColors blockcolors = new BlockColors();
        blockcolors.register((state, reader, pos, color) -> reader != null && pos != null ? BiomeColors.getGrassColor(reader, pos) : GrassColors.get(0.5D, 1.0D), BMBlocks.ALJAMIC_GRASS_BLOCK.get());
        blockcolors.register((state, reader, pos, color) -> 0xFCB76B, BMBlocks.ALJAMIC_GRASS_BLOCK.get());
        return blockcolors;
    }
}
