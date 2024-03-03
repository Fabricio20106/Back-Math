package com.sophicreeper.backmath.block.dispenser.vanilla;

import com.sophicreeper.backmath.entity.custom.BMBoat;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DispenseBMBoatBehavior extends DefaultDispenseItemBehavior {
    private final DefaultDispenseItemBehavior dispenseBehavior = new DefaultDispenseItemBehavior();
    private final String woodType;

    public DispenseBMBoatBehavior(String woodType) {
        this.woodType = woodType;
    }

    public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
        Direction direction = source.getBlockState().get(DispenserBlock.FACING);
        World world = source.getWorld();
        double x = source.getX() + (double)((float)direction.getXOffset() * 1.125F);
        double y = source.getY() + (double)((float)direction.getYOffset() * 1.125F);
        double z = source.getZ() + (double)((float)direction.getZOffset() * 1.125F);
        BlockPos pos = source.getBlockPos().offset(direction);
        double boatHeight;
        if (world.getFluidState(pos).isTagged(FluidTags.WATER)) {
            boatHeight = 1;
        } else {
            if (!world.getBlockState(pos).isAir() || !world.getFluidState(pos.down()).isTagged(FluidTags.WATER)) return this.dispenseBehavior.dispense(source, stack);
            boatHeight = 0;
        }

        BMBoat bmBoat = new BMBoat(world, x, y + boatHeight, z);
        bmBoat.setWoodType(this.woodType);
        bmBoat.rotationYaw = direction.getHorizontalAngle();
        world.addEntity(bmBoat);
        stack.shrink(1);
        return stack;
    }

    protected void playDispenseSound(IBlockSource source) {
        source.getWorld().playEvent(1000, source.getBlockPos(), 0);
    }
}
