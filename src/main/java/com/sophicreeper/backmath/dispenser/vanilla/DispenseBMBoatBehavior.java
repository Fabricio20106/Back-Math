package com.sophicreeper.backmath.dispenser.vanilla;

import com.sophicreeper.backmath.entity.custom.misc.BMBoatEntity;
import com.sophicreeper.backmath.util.BMUtils;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class DispenseBMBoatBehavior extends DefaultDispenseItemBehavior {
    private final DefaultDispenseItemBehavior dispenseBehavior = new DefaultDispenseItemBehavior();
    private final String woodType;

    public DispenseBMBoatBehavior(String woodType) {
        this.woodType = woodType;
    }

    @Override
    @Nonnull
    public ItemStack execute(IBlockSource source, ItemStack stack) {
        Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
        World world = source.getLevel();
        double x = source.x() + (double) ((float) direction.getStepX() * 1.125F);
        double y = source.y() + (double) ((float) direction.getStepY() * 1.125F);
        double z = source.z() + (double) ((float) direction.getStepZ() * 1.125F);
        BlockPos pos = source.getPos().relative(direction);
        double boatHeight;
        if (world.getFluidState(pos).is(FluidTags.WATER)) {
            boatHeight = 1;
        } else {
            if (!world.getBlockState(pos).isAir() || !world.getFluidState(pos.below()).is(FluidTags.WATER)) return this.dispenseBehavior.dispense(source, stack);
            boatHeight = 0;
        }

        BMBoatEntity bmBoat = new BMBoatEntity(world, x, y + boatHeight, z);
        bmBoat.setWoodType(BMUtils.getBoatType(stack, this.woodType));
        bmBoat.yRot = direction.toYRot();
        world.addFreshEntity(bmBoat);
        stack.shrink(1);
        return stack;
    }
}
