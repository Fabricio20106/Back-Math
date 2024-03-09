package com.sophicreeper.backmath.block.dispenser;

import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nonnull;

public class MealCookingDispenseBehavior extends OptionalDispenseBehavior {
    @Override
    @Nonnull
    protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
        BlockPos pos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
        BlockState state = source.getWorld().getBlockState(pos);
        if (state.isIn(BMBlocks.MEAL_COOKER.get())) {
            setSuccessful(true);
            return createMealCookingRecipes(source, state, pos, stack);
        }
        return super.dispenseStack(source, stack);
    }

    private ItemStack createMealCookingRecipes(@Nonnull IBlockSource source, @Nonnull BlockState state, BlockPos pos, ItemStack stack) {
        Direction direction = source.getBlockState().get(DispenserBlock.FACING);
        IPosition iPos = DispenserBlock.getDispensePosition(source);

        // Pasta
        if (stack.getItem() == AxolotlTest.ANGELIC_SPOON.get()) {
            doDispense(source.getWorld(), new ItemStack(AxolotlTest.PASTA.get()), 6, direction, iPos);
            if (this.isSuccessful() && stack.attemptDamageItem(1, source.getWorld().rand, null)) {
                stack.setCount(0);
            }
        }
        // Aljame Teacup
        if (stack.getItem() == AxolotlTest.ALJAME_TEA.get()) {
            doDispense(source.getWorld(), new ItemStack(AxolotlTest.ALJAME_TEACUP.get()), 6, direction, iPos);
            stack.shrink(1);
        }
        return stack;
    }
}
