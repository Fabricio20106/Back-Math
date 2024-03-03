package com.sophicreeper.backmath.block.dispenser;

import com.sophicreeper.backmath.block.BMBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

import static com.sophicreeper.backmath.block.custom.AljanPortalStandBlock.JANTICAL;
import static com.sophicreeper.backmath.block.custom.AljanPortalStandBlock.WATERLOGGED;

public class JanticalDispenseBehavior extends OptionalDispenseBehavior {
    @Override
    protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
        BlockPos pos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
        BlockState state = source.getWorld().getBlockState(pos);
        setSuccessful(true);
        if (state.isIn(BMBlocks.ALJAN_PORTAL_STAND.get()) && !state.get(JANTICAL)) {
            source.getWorld().setBlockState(pos, state.with(WATERLOGGED, state.get(WATERLOGGED)).with(JANTICAL, true));
            stack.shrink(1);
        } else {
            return super.dispenseStack(source, stack);
        }
        return stack;
    }
}
