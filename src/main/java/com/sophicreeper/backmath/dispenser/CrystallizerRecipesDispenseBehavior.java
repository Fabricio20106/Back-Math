package com.sophicreeper.backmath.dispenser;

import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.crystallizer.CrystallizerBlock;
import com.sophicreeper.backmath.crystallizer.Molds;
import com.sophicreeper.backmath.crystallizer.advanced.AdvancedMolds;
import com.sophicreeper.backmath.crystallizer.advanced.CrystallineCrystallizerBlock;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.misc.BMSounds;
import com.sophicreeper.backmath.util.tag.BMFluidTags;
import com.sophicreeper.backmath.util.tag.BMItemTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.material.Material;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.Tags;

import javax.annotation.Nonnull;

public class CrystallizerRecipesDispenseBehavior extends OptionalDispenseBehavior {
    @Override
    @Nonnull
    protected ItemStack execute(IBlockSource source, ItemStack stack) {
        BlockPos pos = source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING));
        BlockState state = source.getLevel().getBlockState(pos);
        setSuccess(true);
        if (state.is(BMBlocks.CRYSTALLIZER.get())) {
            return createCrystallizerRecipes(source, state, pos, stack);
        }
        if (state.is(BMBlocks.CRYSTALLINE_CRYSTALLIZER.get())) {
            return createCrystallineCrystallizerRecipes(source, state, pos, stack);
        }
        return super.execute(source, stack);
    }

    public static ItemStack createCrystallizerRecipes(@Nonnull IBlockSource source, @Nonnull BlockState state, BlockPos pos, ItemStack stack) {
        Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
        IPosition iPos = DispenserBlock.getDispensePosition(source);
        ServerWorld world = source.getLevel();

        // MOLD: Empty
        if (state.getValue(CrystallizerBlock.MOLD) == Molds.EMPTY) {
            // Places Liquid Aljame below the crystallizer if it's air.
            boolean canPlaceLiquidAljame = world.getBlockState(pos.below()).getMaterial() == Material.AIR;
            if (stack.getItem() == AxolotlTest.ALJAME.get() && stack.getCount() >= 4 && canPlaceLiquidAljame) {
                world.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundCategory.BLOCKS, 1, 1);
                world.setBlockAndUpdate(pos.below(), BMBlocks.LIQUID_ALJAME.get().defaultBlockState());
                stack.shrink(4);
                return stack;
            }
            world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
        }

        // MOLD: Rod
        if (state.getValue(CrystallizerBlock.MOLD) == Molds.ROD) {
            if (stack.getItem() == AxolotlTest.HILLARY_BUCKET.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.HILLARY_ROD.get(), 4), 6, direction, iPos);
                return new ItemStack(Items.BUCKET);
            }
            world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
        }

        // MOLD: Singularity
        if (state.getValue(CrystallizerBlock.MOLD) == Molds.SINGULARITY) {
            if (stack.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.MILKLLARITY.get()), 6, direction, iPos);
                return new ItemStack(Items.BUCKET);
            }
            if (stack.getItem().is(BMItemTags.INGOTS_MILKLLARY)) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.MILKLLARITY.get()), 6, direction, iPos);
                stack.shrink(1);
                return stack;
            }
            if (stack.getItem().is(BMItemTags.INGOTS_MID_TERM)) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.MID_TERM.get()), 6, direction, iPos);
                stack.shrink(1);
                return stack;
            }
            if (stack.getItem().is(BMItemTags.INGOTS_OBSIDIAN_INFUSED_MID_TERM)) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM.get()), 6, direction, iPos);
                stack.shrink(1);
                return stack;
            }
            world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
        }

        // MOLD: Ingot
        if (state.getValue(CrystallizerBlock.MOLD) == Molds.INGOT) {
            boolean hasHillaryAbove = world.getBlockState(pos.above()).is(BMBlocks.HILLARY.get());
            if (stack.getItem().is(BMItemTags.INGOTS_MILKLLARY) && hasHillaryAbove) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                world.setBlockAndUpdate(pos.above(), Blocks.AIR.defaultBlockState());
                spawnItem(world, new ItemStack(AxolotlTest.TWO_THIRDS_HILLARY_INGOT.get()), 6, direction, iPos);
                stack.shrink(1);
                return stack;
            }
            if (stack.getItem() == Items.MILK_BUCKET && hasHillaryAbove) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                world.setBlockAndUpdate(pos.above(), Blocks.AIR.defaultBlockState());
                spawnItem(world, new ItemStack(AxolotlTest.MILKLLARY_INGOT.get(), 2), 6, direction, iPos);
                return new ItemStack(Items.BUCKET);
            }
            if (stack.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.MILKLLARY_INGOT.get()), 6, direction, iPos);
                return new ItemStack(Items.BUCKET);
            }
            if (stack.getItem().is(BMItemTags.SINGULARITIES_MILKLLARY)) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.MILKLLARY_INGOT.get()), 6, direction, iPos);
                stack.shrink(1);
                return stack;
            }
            if (stack.getItem().is(BMItemTags.HARDENED_AMARACAMEL_MATERIALS)) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.HARDENED_AMARACAMEL_INGOT.get()), 6, direction, iPos);
                stack.shrink(1);
                return stack;
            }
            if (stack.getItem().is(BMItemTags.SINGULARITIES_MID_TERM)) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.MID_TERM_INGOT.get()), 6, direction, iPos);
                stack.shrink(1);
                return stack;
            }
            if (stack.getItem().is(BMItemTags.SINGULARITIES_OBSIDIAN_INFUSED_MID_TERM)) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_INGOT.get()), 6, direction, iPos);
                stack.shrink(1);
                return stack;
            }
            world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
        }

        // MOLD: Mold
        if (state.getValue(CrystallizerBlock.MOLD) == Molds.MOLD) {
            if (stack.getItem().is(BMItemTags.GEMS_CRYSTALLINE_ANGELIC)) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.CRYSTALLINE_EMPTY_MOLD.get()), 6, direction, iPos);
                stack.shrink(1);
                return stack;
            }
        }

        return stack;
    }

    public static ItemStack createCrystallineCrystallizerRecipes(@Nonnull IBlockSource source, @Nonnull BlockState state, BlockPos pos, ItemStack stack) {
        Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
        IPosition iPos = DispenserBlock.getDispensePosition(source);
        ServerWorld world = source.getLevel();

        // MOLD: Empty
        if (state.getValue(CrystallineCrystallizerBlock.MOLD) == AdvancedMolds.EMPTY) {
            // Places Liquid Aljame below the crystalline crystallizer if it's air.
            boolean canPlaceLiquidAljame = world.getBlockState(pos.below()).getMaterial() == Material.AIR;
            if (stack.getItem() == AxolotlTest.ALJAME.get() && stack.getCount() >= 4 && canPlaceLiquidAljame) {
                world.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundCategory.BLOCKS, 1, 1);
                world.setBlockAndUpdate(pos.below(), BMBlocks.LIQUID_ALJAME.get().defaultBlockState());
                stack.shrink(4);
                return stack;
            }
            world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
        }

        // MOLD: Rod
        if (state.getValue(CrystallineCrystallizerBlock.MOLD) == AdvancedMolds.ROD) {
            if (stack.getItem() == AxolotlTest.HILLARY_BUCKET.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.HILLARY_ROD.get(), 4), 6, direction, iPos);
                return new ItemStack(Items.BUCKET);
            }
            world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
        }

        // MOLD: Singularity
        if (state.getValue(CrystallineCrystallizerBlock.MOLD) == AdvancedMolds.SINGULARITY) {
            if (stack.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.MILKLLARITY.get()), 6, direction, iPos);
                return new ItemStack(Items.BUCKET);
            }
            if (stack.getItem().is(BMItemTags.INGOTS_MILKLLARY)) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.MILKLLARITY.get()), 6, direction, iPos);
                stack.shrink(1);
                return stack;
            }
            if (stack.getItem().is(BMItemTags.INGOTS_MID_TERM)) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.MID_TERM.get()), 6, direction, iPos);
                stack.shrink(1);
                return stack;
            }
            if (stack.getItem() == AxolotlTest.MOLTEN_MID_TERM_BUCKET.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.MID_TERM.get()), 6, direction, iPos);
                return new ItemStack(Items.BUCKET);
            }
            if (stack.getItem().is(BMItemTags.INGOTS_OBSIDIAN_INFUSED_MID_TERM)) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM.get()), 6, direction, iPos);
                stack.shrink(1);
                return stack;
            }
            world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
        }

        // MOLD: Ingot
        if (state.getValue(CrystallineCrystallizerBlock.MOLD) == AdvancedMolds.INGOT) {
            boolean hasHillaryAbove = world.getBlockState(pos.above()).is(BMBlocks.HILLARY.get());
            if (stack.getItem().is(BMItemTags.INGOTS_MILKLLARY) && hasHillaryAbove) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                world.setBlockAndUpdate(pos.above(), Blocks.AIR.defaultBlockState());
                spawnItem(world, new ItemStack(AxolotlTest.TWO_THIRDS_HILLARY_INGOT.get()), 6, direction, iPos);
                stack.shrink(1);
                return stack;
            }
            if (stack.getItem() == Items.MILK_BUCKET && hasHillaryAbove) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                world.setBlockAndUpdate(pos.above(), Blocks.AIR.defaultBlockState());
                spawnItem(world, new ItemStack(AxolotlTest.MILKLLARY_INGOT.get(), 2), 6, direction, iPos);
                return new ItemStack(Items.BUCKET);
            }
            if (stack.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.MILKLLARY_INGOT.get()), 6, direction, iPos);
                return new ItemStack(Items.BUCKET);
            }
            if (stack.getItem() == AxolotlTest.MOLTEN_MID_TERM_BUCKET.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.MID_TERM_INGOT.get()), 6, direction, iPos);
                return new ItemStack(Items.BUCKET);
            }
            if (stack.getItem().is(BMItemTags.SINGULARITIES_MILKLLARY)) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.MILKLLARY_INGOT.get()), 6, direction, iPos);
                stack.shrink(1);
                return stack;
            }
            if (stack.getItem().is(BMItemTags.HARDENED_AMARACAMEL_MATERIALS)) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.HARDENED_AMARACAMEL_INGOT.get()), 6, direction, iPos);
                stack.shrink(1);
                return stack;
            }
            if (stack.getItem().is(BMItemTags.SINGULARITIES_MID_TERM)) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.MID_TERM_INGOT.get()), 6, direction, iPos);
                stack.shrink(1);
                return stack;
            }
            if (stack.getItem().is(BMItemTags.SINGULARITIES_OBSIDIAN_INFUSED_MID_TERM)) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_INGOT.get()), 6, direction, iPos);
                stack.shrink(1);
                return stack;
            }
            if (stack.getItem().is(Tags.Items.OBSIDIAN)) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.OBSIDIAN_INGOT.get()), 6, direction, iPos);
                stack.shrink(1);
                return stack;
            }
            world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
        }

        // MOLD: Mold
        if (state.getValue(CrystallineCrystallizerBlock.MOLD) == AdvancedMolds.MOLD) {
            if (stack.getItem().is(BMItemTags.GEMS_CRYSTALLINE_ANGELIC)) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                spawnItem(world, new ItemStack(AxolotlTest.CRYSTALLINE_EMPTY_MOLD.get()), 6, direction, iPos);
                stack.shrink(1);
                return stack;
            }
        }

        return stack;
    }
}
