package com.sophicreeper.backmath.block.dispenser.vanilla;

import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.crystallizer.CrystallizerBlock;
import com.sophicreeper.backmath.crystallizer.Molds;
import com.sophicreeper.backmath.crystallizer.advanced.AdvancedMolds;
import com.sophicreeper.backmath.crystallizer.advanced.CrystallineCrystallizerBlock;
import com.sophicreeper.backmath.crystallizer.dispenser.CrystallizerRecipesDispenseBehavior;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.misc.BMSounds;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BucketDispenseBehavior extends DefaultDispenseItemBehavior {
    private final DefaultDispenseItemBehavior defaultBehaviour = new DefaultDispenseItemBehavior();

    public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
        BucketItem bucket = (BucketItem) stack.getItem();
        BlockPos pos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
        BlockState state = source.getWorld().getBlockState(pos);
        World world = source.getWorld();
        Direction direction = source.getBlockState().get(DispenserBlock.FACING);
        IPosition iPos = DispenserBlock.getDispensePosition(source);

        if (bucket.tryPlaceContainedLiquid(null, world, pos, null)) {
            bucket.onLiquidPlaced(world, stack, pos);
            return stack.getContainerItem();
        } else if (state.isIn(BMBlocks.CRYSTALLIZER.get())) {
            // MOLD: Rod
            if (state.get(CrystallizerBlock.MOLD) == Molds.ROD) {
                if (stack.getItem() == AxolotlTest.HILLARY_BUCKET.get()) {
                    source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                    doDispense(source.getWorld(), new ItemStack(AxolotlTest.HILLARY_ROD.get(), 4), 6, direction, iPos);
                    return new ItemStack(Items.BUCKET);
                }
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
            }
            // MOLD: Ingot
            if (state.get(CrystallizerBlock.MOLD) == Molds.INGOT) {
                if (stack.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                    source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                    doDispense(source.getWorld(), new ItemStack(AxolotlTest.MILKLLARY_INGOT.get()), 6, direction, iPos);
                    return new ItemStack(Items.BUCKET);
                }
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
            }
            // MOLD: Singularity
            if (state.get(CrystallizerBlock.MOLD) == Molds.SINGULARITY) {
                if (stack.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                    source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                    doDispense(source.getWorld(), new ItemStack(AxolotlTest.MILKLLARITY.get()), 6, direction, iPos);
                    return new ItemStack(Items.BUCKET);
                }
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
            }
        } else if (state.isIn(BMBlocks.CRYSTALLINE_CRYSTALLIZER.get())) {
            // MOLD: Rod
            if (state.get(CrystallineCrystallizerBlock.MOLD) == AdvancedMolds.ROD) {
                if (stack.getItem() == AxolotlTest.HILLARY_BUCKET.get()) {
                    source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                    doDispense(source.getWorld(), new ItemStack(AxolotlTest.HILLARY_ROD.get(), 4), 6, direction, iPos);
                    return new ItemStack(Items.BUCKET);
                }
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
            }
            // MOLD: Ingot
            if (state.get(CrystallineCrystallizerBlock.MOLD) == AdvancedMolds.INGOT) {
                if (stack.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                    source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                    doDispense(source.getWorld(), new ItemStack(AxolotlTest.MILKLLARY_INGOT.get()), 6, direction, iPos);
                    return new ItemStack(Items.BUCKET);
                }
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
            }
            // MOLD: Singularity
            if (state.get(CrystallineCrystallizerBlock.MOLD) == AdvancedMolds.SINGULARITY) {
                if (stack.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                    source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                    doDispense(source.getWorld(), new ItemStack(AxolotlTest.MILKLLARITY.get()), 6, direction, iPos);
                    return new ItemStack(Items.BUCKET);
                }
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
            }
        }
        return this.defaultBehaviour.dispense(source, stack);
    }
}
