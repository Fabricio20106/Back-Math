package com.sophicreeper.backmath.dispenser;

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
    protected ItemStack execute(IBlockSource source, ItemStack stack) {
        BlockPos pos = source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING));
        BlockState state = source.getLevel().getBlockState(pos);
        if (state.is(BMBlocks.MEAL_COOKER.get())) {
            setSuccess(true);
            return createMealCookingRecipes(source, state, pos, stack);
        }
        return super.execute(source, stack);
    }

    private ItemStack createMealCookingRecipes(@Nonnull IBlockSource source, @Nonnull BlockState state, BlockPos pos, ItemStack stack) {
        Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
        IPosition iPos = DispenserBlock.getDispensePosition(source);

        // Pasta
        if (stack.getItem() == AxolotlTest.ANGELIC_SPOON.get()) {
            spawnItem(source.getLevel(), new ItemStack(AxolotlTest.PASTA.get()), 6, direction, iPos);
            if (this.isSuccess() && stack.hurt(1, source.getLevel().random, null)) {
                stack.setCount(0);
            }
        }
        // Aljame Teacup
        if (stack.getItem() == AxolotlTest.ALJAME_TEA.get()) {
            spawnItem(source.getLevel(), new ItemStack(AxolotlTest.ALJAME_TEACUP.get()), 6, direction, iPos);
            stack.shrink(1);
        }
        return stack;
    }
}
