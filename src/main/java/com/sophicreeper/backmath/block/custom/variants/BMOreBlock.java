package com.sophicreeper.backmath.block.custom.variants;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.fml.ModList;

import javax.annotation.Nullable;
import java.util.List;

public class BMOreBlock extends OreBlock {
    private final int minXP;
    private final int maxXP;

    public BMOreBlock(int minXP, int maxXP, Properties properties) {
        super(properties);
        this.minXP = minXP;
        this.maxXP = maxXP;
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silkTouch) {
        return silkTouch == 0 ? MathHelper.nextInt(RANDOM, this.minXP, this.maxXP) : 0;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable IBlockReader world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        if (flag.isAdvanced() && ModList.get().isLoaded("variants")) tooltip.add(new TranslationTextComponent("tooltip.variants.ore_experience_drops", this.minXP, this.maxXP).withStyle(TextFormatting.GRAY));
    }
}
