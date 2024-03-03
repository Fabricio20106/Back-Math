package com.sophicreeper.backmath.block.dispenser.vanilla;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BoneMealDispenseBehavior extends OptionalDispenseBehavior {
    protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
        this.setSuccessful(true);
        World world = source.getWorld();
        BlockPos pos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
        if (!BoneMealItem.applyBonemeal(stack, world, pos) && !BoneMealItem.growSeagrass(stack, world, pos, null)) {
            this.setSuccessful(false);
        } else if (!world.isRemote) {
            BoneMealItem.spawnBonemealParticles(world, pos, 0);
        }
        return stack;
    }
}
