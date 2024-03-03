package com.sophicreeper.backmath.block.dispenser;

import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.block.custom.properties.AdvancedMolds;
import com.sophicreeper.backmath.block.custom.properties.Molds;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.misc.BMSounds;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.block.BlockState;
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
import net.minecraftforge.common.Tags;

import javax.annotation.Nonnull;

import static com.sophicreeper.backmath.block.custom.machine.CrystallineCrystallizerBlock.ADVANCED_MOLD;
import static com.sophicreeper.backmath.block.custom.machine.CrystallizerBlock.MOLD;

public class CrystallizerRecipesDispenseBehavior extends OptionalDispenseBehavior {
    @Override
    protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
        BlockPos pos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
        BlockState state = source.getWorld().getBlockState(pos);
        setSuccessful(true);
        if (state.isIn(BMBlocks.CRYSTALLIZER.get())) {
            return createCrystallizerRecipes(source, state, pos, stack);
        }
        if (state.isIn(BMBlocks.CRYSTALLINE_CRYSTALLIZER.get())) {
            return createCrystallineCrystallizerRecipes(source, state, pos, stack);
        }
        return super.dispenseStack(source, stack);
    }

    public static ItemStack createCrystallizerRecipes(@Nonnull IBlockSource source, @Nonnull BlockState state, BlockPos pos, ItemStack stack) {
        Direction direction = source.getBlockState().get(DispenserBlock.FACING);
        IPosition iPos = DispenserBlock.getDispensePosition(source);

        // MOLD: Empty
        if (state.get(MOLD) == Molds.EMPTY) {
            // Places Liquid Aljame below the crystallizer if it's air.
            boolean canPlaceLiquidAljame = source.getWorld().getBlockState(pos.down()).getMaterial() == Material.AIR;
            if (stack.getItem() == AxolotlTest.ALJAME.get() && stack.getCount() >= 4 && canPlaceLiquidAljame) {
                source.getWorld().playSound(null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1, 1);
                source.getWorld().setBlockState(pos.down(), BMBlocks.LIQUID_ALJAME.get().getDefaultState());
                stack.shrink(4);
            }
            source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
        }

        // MOLD: Rod
        if (state.get(MOLD) == Molds.ROD) {
            if (stack.getItem() == AxolotlTest.HILLARY_BUCKET.get()) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.HILLARY_ROD.get(), 4), 6, direction, iPos);
                return new ItemStack(Items.BUCKET);
            }
            source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
        }

        // MOLD: Singularity
        if (state.get(MOLD) == Molds.SINGULARITY) {
            if (stack.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.MILKLLARITY.get()), 6, direction, iPos);
                return new ItemStack(Items.BUCKET);
            }
            if (stack.getItem().isIn(BMTags.Items.INGOTS_MILKLLARY)) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.MILKLLARITY.get()), 6, direction, iPos);
                stack.shrink(1);
            }
            if (stack.getItem().isIn(BMTags.Items.INGOTS_MID_TERM)) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.MID_TERM.get()), 6, direction, iPos);
                stack.shrink(1);
            }
            if (stack.getItem().isIn(BMTags.Items.INGOTS_OBSIDIAN_INFUSED_MID_TERM)) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM.get()), 6, direction, iPos);
                stack.shrink(1);
            }
            source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
        }

        // MOLD: Ingot
        if (state.get(MOLD) == Molds.INGOT) {
            if (stack.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.MILKLLARY_INGOT.get()), 6, direction, iPos);
                return new ItemStack(Items.BUCKET);
            }
            boolean hasHillaryBelowCrystallizer = source.getWorld().getFluidState(pos.down()).isTagged(BMTags.Fluids.HILLARY);
            if (stack.getItem().isIn(BMTags.Items.INGOTS_MILKLLARY) && hasHillaryBelowCrystallizer) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.TWO_THIRDS_HILLARY_INGOT.get()), 6, direction, iPos);
                stack.shrink(1);
            }
            if (stack.getItem().isIn(BMTags.Items.SINGULARITIES_MILKLLARY)) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.MILKLLARY_INGOT.get()), 6, direction, iPos);
                stack.shrink(1);
            }
            if (stack.getItem().isIn(BMTags.Items.MATERIALS_HARDENED_AMARACAMEL)) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.HARDENED_AMARACAMEL_INGOT.get()), 6, direction, iPos);
                stack.shrink(1);
            }
            if (stack.getItem().isIn(BMTags.Items.SINGULARITIES_MID_TERM)) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.MID_TERM_INGOT.get()), 6, direction, iPos);
                stack.shrink(1);
            }
            if (stack.getItem().isIn(BMTags.Items.SINGULARITIES_OBSIDIAN_INFUSED_MID_TERM)) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_INGOT.get()), 6, direction, iPos);
                stack.shrink(1);
            }
            source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
        }

        // MOLD: Mold
        if (state.get(MOLD) == Molds.MOLD) {
            if (stack.getItem().isIn(BMTags.Items.GEMS_CRYSTALLINE_ANGELIC)) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.CRYSTALLINE_EMPTY_MOLD.get()), 6, direction, iPos);
                stack.shrink(1);
            }
        }

        return stack;
    }

    public static ItemStack createCrystallineCrystallizerRecipes(@Nonnull IBlockSource source, @Nonnull BlockState state, BlockPos pos, ItemStack stack) {
        Direction direction = source.getBlockState().get(DispenserBlock.FACING);
        IPosition iPos = DispenserBlock.getDispensePosition(source);

        // MOLD: Empty
        if (state.get(ADVANCED_MOLD) == AdvancedMolds.EMPTY) {
            // Places Liquid Aljame below the crystalline crystallizer if it's air.
            boolean canPlaceLiquidAljame = source.getWorld().getBlockState(pos.down()).getMaterial() == Material.AIR;
            if (stack.getItem() == AxolotlTest.ALJAME.get() && stack.getCount() >= 4 && canPlaceLiquidAljame) {
                source.getWorld().playSound(null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1, 1);
                source.getWorld().setBlockState(pos.down(), BMBlocks.LIQUID_ALJAME.get().getDefaultState());
                stack.shrink(4);
            }
            source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
        }

        // MOLD: Rod
        if (state.get(ADVANCED_MOLD) == AdvancedMolds.ROD) {
            if (stack.getItem() == AxolotlTest.HILLARY_BUCKET.get()) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.HILLARY_ROD.get(), 4), 6, direction, iPos);
                return new ItemStack(Items.BUCKET);
            }
            source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
        }

        // MOLD: Singularity
        if (state.get(ADVANCED_MOLD) == AdvancedMolds.SINGULARITY) {
            if (stack.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.MILKLLARITY.get()), 6, direction, iPos);
                return new ItemStack(Items.BUCKET);
            }
            if (stack.getItem().isIn(BMTags.Items.INGOTS_MILKLLARY)) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.MILKLLARITY.get()), 6, direction, iPos);
                stack.shrink(1);
            }
            if (stack.getItem().isIn(BMTags.Items.INGOTS_MID_TERM)) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.MID_TERM.get()), 6, direction, iPos);
                stack.shrink(1);
            }
            if (stack.getItem() == AxolotlTest.MOLTEN_MID_TERM_BUCKET.get()) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.MID_TERM.get()), 6, direction, iPos);
                return new ItemStack(Items.BUCKET);
            }
            if (stack.getItem().isIn(BMTags.Items.INGOTS_OBSIDIAN_INFUSED_MID_TERM)) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM.get()), 6, direction, iPos);
                stack.shrink(1);
            }
            source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
        }

        // MOLD: Ingot
        if (state.get(ADVANCED_MOLD) == AdvancedMolds.INGOT) {
            if (stack.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.MILKLLARY_INGOT.get()), 6, direction, iPos);
                return new ItemStack(Items.BUCKET);
            }
            boolean hasHillaryBelowCrystallizer = source.getWorld().getFluidState(pos.down()).isTagged(BMTags.Fluids.HILLARY);
            if (stack.getItem().isIn(BMTags.Items.INGOTS_MILKLLARY) && hasHillaryBelowCrystallizer) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.TWO_THIRDS_HILLARY_INGOT.get()), 6, direction, iPos);
                stack.shrink(1);
            }
            if (stack.getItem() == AxolotlTest.MOLTEN_MID_TERM_BUCKET.get()) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.MID_TERM_INGOT.get()), 6, direction, iPos);
                return new ItemStack(Items.BUCKET);
            }
            if (stack.getItem().isIn(BMTags.Items.SINGULARITIES_MILKLLARY)) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.MILKLLARY_INGOT.get()), 6, direction, iPos);
                stack.shrink(1);
            }
            if (stack.getItem().isIn(BMTags.Items.MATERIALS_HARDENED_AMARACAMEL)) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.HARDENED_AMARACAMEL_INGOT.get()), 6, direction, iPos);
                stack.shrink(1);
            }
            if (stack.getItem().isIn(BMTags.Items.SINGULARITIES_MID_TERM)) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.MID_TERM_INGOT.get()), 6, direction, iPos);
                stack.shrink(1);
            }
            if (stack.getItem().isIn(BMTags.Items.SINGULARITIES_OBSIDIAN_INFUSED_MID_TERM)) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_INGOT.get()), 6, direction, iPos);
                stack.shrink(1);
            }
            if (stack.getItem().isIn(Tags.Items.OBSIDIAN)) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.OBSIDIAN_INGOT.get()), 6, direction, iPos);
                stack.shrink(1);
            }
            source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
        }

        // MOLD: Mold
        if (state.get(ADVANCED_MOLD) == AdvancedMolds.MOLD) {
            if (stack.getItem().isIn(BMTags.Items.GEMS_CRYSTALLINE_ANGELIC)) {
                source.getWorld().playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                doDispense(source.getWorld(), new ItemStack(AxolotlTest.CRYSTALLINE_EMPTY_MOLD.get()), 6, direction, iPos);
                stack.shrink(1);
            }
        }

        return stack;
    }
}
