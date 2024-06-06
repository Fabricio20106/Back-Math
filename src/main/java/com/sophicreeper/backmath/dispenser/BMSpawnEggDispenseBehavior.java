package com.sophicreeper.backmath.dispenser;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Direction;

public class BMSpawnEggDispenseBehavior extends DefaultDispenseItemBehavior {
    @Override
    protected ItemStack execute(IBlockSource source, ItemStack stack) {
        Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
        EntityType<?> type = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
        type.spawn(source.getLevel(), stack, null, source.getPos().relative(direction), SpawnReason.DISPENSER, direction != Direction.UP, false);
        stack.shrink(1);
        return stack;
    }
}
