package com.sophicreeper.backmath.block.dispenser.vanilla;

import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.block.dispenser.CrystallizerRecipesDispenseBehavior;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BucketDispenseBehavior extends DefaultDispenseItemBehavior {
    private final DefaultDispenseItemBehavior defaultBehaviour = new DefaultDispenseItemBehavior();

    public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
        BucketItem bucket = (BucketItem) stack.getItem();
        BlockPos pos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
        BlockState state = source.getWorld().getBlockState(pos);
        World world = source.getWorld();
        if (bucket.tryPlaceContainedLiquid(null, world, pos, null)) {
            bucket.onLiquidPlaced(world, stack, pos);
            return stack.getContainerItem();
        } else if (state.isIn(BMBlocks.CRYSTALLIZER.get())) {
            CrystallizerRecipesDispenseBehavior.createCrystallizerRecipes(source, state, pos, stack);
            // TODO: Items with no recipe available for this mold gets transformed into a bucket without crafting anything.
            return stack.getContainerItem();
        } else if (state.isIn(BMBlocks.CRYSTALLINE_CRYSTALLIZER.get())) {
            CrystallizerRecipesDispenseBehavior.createCrystallineCrystallizerRecipes(source, state, pos, stack);
            return stack.getContainerItem();
        }
        return this.defaultBehaviour.dispense(source, stack);
    }
}
