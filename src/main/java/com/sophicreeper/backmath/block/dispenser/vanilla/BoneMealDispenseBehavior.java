package com.sophicreeper.backmath.block.dispenser.vanilla;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BoneMealDispenseBehavior extends OptionalDispenseBehavior {
    protected ItemStack execute(IBlockSource source, ItemStack stack) {
        this.setSuccess(true);
        World world = source.getLevel();
        BlockPos pos = source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING));
        if (!BoneMealItem.growCrop(stack, world, pos) && !BoneMealItem.growWaterPlant(stack, world, pos, null)) {
            this.setSuccess(false);
        } else if (!world.isClientSide) {
            BoneMealItem.addGrowthParticles(world, pos, 0);
        }
        return stack;
    }
}
