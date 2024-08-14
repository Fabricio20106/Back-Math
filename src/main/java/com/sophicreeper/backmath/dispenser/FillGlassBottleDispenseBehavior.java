package com.sophicreeper.backmath.dispenser;

import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.util.tag.BMFluidTags;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.DispenserTileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nonnull;

public class FillGlassBottleDispenseBehavior extends OptionalDispenseBehavior {
    private final DefaultDispenseItemBehavior defaultBehavior = new DefaultDispenseItemBehavior();

    @Override
    @Nonnull
    public ItemStack execute(IBlockSource source, ItemStack stack) {
        this.setSuccess(false);
        ServerWorld world = source.getLevel();
        BlockPos pos = source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING));
        if (world.getFluidState(pos).is(BMFluidTags.SLEEPISHWATER)) {
            this.setSuccess(true);
            return this.takeLiquid(source, stack, new ItemStack(AxolotlTest.SLEEPISHWATER_BOTTLE.get()));
        } else {
            return super.execute(source, stack);
        }
    }

    private ItemStack takeLiquid(IBlockSource source, ItemStack empty, ItemStack filled) {
        empty.shrink(1);
        if (empty.isEmpty()) {
            return filled.copy();
        } else {
            if (source.<DispenserTileEntity>getEntity().addItem(filled.copy()) < 0) {
                this.defaultBehavior.dispense(source, filled.copy());
            }
            return empty;
        }
    }
}
