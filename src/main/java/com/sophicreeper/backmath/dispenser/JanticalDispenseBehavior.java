package com.sophicreeper.backmath.dispenser;

import com.sophicreeper.backmath.block.BMBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nonnull;

import static com.sophicreeper.backmath.block.custom.AljanPortalStandBlock.JANTICAL;
import static com.sophicreeper.backmath.block.custom.AljanPortalStandBlock.WATERLOGGED;

public class JanticalDispenseBehavior extends OptionalDispenseBehavior {
    @Override
    @Nonnull
    protected ItemStack execute(IBlockSource source, ItemStack stack) {
        BlockPos pos = source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING));
        BlockState state = source.getLevel().getBlockState(pos);
        setSuccess(true);
        if (state.is(BMBlocks.ALJAN_PORTAL_STAND.get()) && !state.getValue(JANTICAL)) {
            source.getLevel().setBlockAndUpdate(pos, state.setValue(WATERLOGGED, state.getValue(WATERLOGGED)).setValue(JANTICAL, true));
            stack.shrink(1);
        } else {
            return super.execute(source, stack);
        }
        return stack;
    }
}
