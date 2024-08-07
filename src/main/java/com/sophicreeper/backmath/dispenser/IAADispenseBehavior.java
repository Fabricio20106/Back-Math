package com.sophicreeper.backmath.dispenser;

import net.minecraft.block.*;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class IAADispenseBehavior extends OptionalDispenseBehavior {
    @Override
    @Nonnull
    protected ItemStack execute(IBlockSource source, ItemStack stack) {
        World world = source.getLevel();
        this.setSuccess(true);
        Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
        BlockPos pos = source.getPos().relative(direction);
        BlockState state = world.getBlockState(pos);
        if (AbstractFireBlock.canBePlacedAt(world, pos, direction)) {
            world.setBlockAndUpdate(pos, AbstractFireBlock.getState(world, pos));
        } else if (CampfireBlock.canLight(state)) {
            world.setBlockAndUpdate(pos, state.setValue(BlockStateProperties.LIT, true));
        } else if (state.isFlammable(world, pos, source.getBlockState().getValue(DispenserBlock.FACING).getOpposite())) {
            state.catchFire(world, pos, source.getBlockState().getValue(DispenserBlock.FACING).getOpposite(), null);
            if (state.getBlock() instanceof TNTBlock)
                world.removeBlock(pos, false);
        } else {
            this.setSuccess(false);
        }

        if (this.isSuccess() && stack.hurt(1, world.random, null)) {
            stack.setCount(0);
        }

        return stack;
    }
}
