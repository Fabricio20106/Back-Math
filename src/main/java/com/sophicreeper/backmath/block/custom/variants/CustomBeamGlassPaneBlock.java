package com.sophicreeper.backmath.block.custom.variants;

import net.minecraft.block.BlockState;
import net.minecraft.block.IBeaconBeamColorProvider;
import net.minecraft.block.PaneBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Color;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.fml.ModList;

import javax.annotation.Nullable;
import java.util.List;

public class CustomBeamGlassPaneBlock extends PaneBlock implements IBeaconBeamColorProvider {
    private final int beamColor;

    public CustomBeamGlassPaneBlock(int beamColor, Properties properties) {
        super(properties);
        this.beamColor = beamColor;
        this.setDefaultState(this.stateContainer.getBaseState().with(NORTH, false).with(EAST, false).with(SOUTH, false).with(WEST, false).with(WATERLOGGED, false));
    }

    @Nullable
    public float[] getBeaconColorMultiplier(BlockState state, IWorldReader world, BlockPos pos, BlockPos beaconPos) {
        int i = (beamColor & 16711680) >> 16;
        int j = (beamColor & '\uff00') >> 8;
        int k = (beamColor & 255);

        float[] textureDiffuseColors = new float[] {(float) i / 255f, (float) j / 255f, (float) k / 255f};

        if (getBlock() instanceof IBeaconBeamColorProvider) {
            return textureDiffuseColors;
        }

        return null;
    }

    @Override
    public DyeColor getColor() {
        return DyeColor.WHITE;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable IBlockReader world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        if (ModList.get().isLoaded("variants")) tooltip.add(new TranslationTextComponent("tooltip.variants.glass_beam_color", String.format("#%06X", beamColor)).mergeStyle(Style.EMPTY.setColor(Color.fromInt(beamColor))));
        super.addInformation(stack, world, tooltip, flag);
    }
}
