package com.sophicreeper.backmath.block.dispenser;

import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.block.custom.properties.AdvancedMolds;
import com.sophicreeper.backmath.block.custom.properties.Molds;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

import static com.sophicreeper.backmath.block.custom.machine.CrystallineCrystallizerBlock.ADVANCED_MOLD;
import static com.sophicreeper.backmath.block.custom.machine.CrystallizerBlock.HORIZONTAL_FACING;
import static com.sophicreeper.backmath.block.custom.machine.CrystallizerBlock.MOLD;

public class CrystallizerMoldDispenseBehavior extends OptionalDispenseBehavior {
    private final String moldType;

    public CrystallizerMoldDispenseBehavior(String type) {
        this.moldType = type;
    }

    @Override
    protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
        BlockPos pos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
        BlockState state = source.getWorld().getBlockState(pos);
        setSuccessful(true);
        if (state.isIn(BMBlocks.CRYSTALLIZER.get())) {
            if (stack.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get()) {
                source.getWorld().setBlockState(pos, state.with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)).with(MOLD, getNextMold(state.get(MOLD))));
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_SINGULARITY) && state.get(MOLD) != Molds.SINGULARITY) {
                setMold(Molds.getMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_CRYSTALLIZED) && state.get(MOLD) != Molds.CRYSTALLIZED) {
                setMold(Molds.getMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_INGOT) && state.get(MOLD) != Molds.INGOT) {
                setMold(Molds.getMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_MOLD) && state.get(MOLD) != Molds.MOLD) {
                setMold(Molds.getMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_ROD) && state.get(MOLD) != Molds.ROD) {
                setMold(Molds.getMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_EMPTY) && state.get(MOLD) != Molds.EMPTY) {
                setMold(Molds.getMoldFromString(this.moldType), pos, source);
            }
        } else if (state.isIn(BMBlocks.CRYSTALLINE_CRYSTALLIZER.get())) {
            if (stack.getItem() == AxolotlTest.ADVANCED_MOLDS_BOOK.get()) {
                source.getWorld().setBlockState(pos, state.with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)).with(ADVANCED_MOLD, getNextAdvancedMold(state.get(ADVANCED_MOLD))));
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_SINGULARITY) && state.get(ADVANCED_MOLD) != AdvancedMolds.SINGULARITY) {
                setAdvancedMold(AdvancedMolds.getMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_CRYSTALLIZED) && state.get(ADVANCED_MOLD) != AdvancedMolds.CRYSTALLIZED) {
                setAdvancedMold(AdvancedMolds.getMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_INGOT) && state.get(ADVANCED_MOLD) != AdvancedMolds.INGOT) {
                setAdvancedMold(AdvancedMolds.getMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_MOLD) && state.get(ADVANCED_MOLD) != AdvancedMolds.MOLD) {
                setAdvancedMold(AdvancedMolds.getMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_ROD) && state.get(ADVANCED_MOLD) != AdvancedMolds.ROD) {
                setAdvancedMold(AdvancedMolds.getMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_EMPTY) && state.get(ADVANCED_MOLD) != AdvancedMolds.EMPTY) {
                setAdvancedMold(AdvancedMolds.getMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_CRYSTALLINE_EMPTY) && state.get(ADVANCED_MOLD) != AdvancedMolds.CRYSTALLINE_EMPTY) {
                setAdvancedMold(AdvancedMolds.getMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_CRYSTALLINE_GEM) && state.get(ADVANCED_MOLD) != AdvancedMolds.CRYSTALLINE_GEM) {
                setAdvancedMold(AdvancedMolds.getMoldFromString(this.moldType), pos, source);
            }
        } else {
            return super.dispenseStack(source, stack);
        }
        return stack;
    }

    private static void setMold(Molds mold, BlockPos pos, IBlockSource source) {
        BlockState state = source.getWorld().getBlockState(pos);
        source.getWorld().setBlockState(pos, state.with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)).with(MOLD, mold));
    }

    private static void setAdvancedMold(AdvancedMolds mold, BlockPos pos, IBlockSource source) {
        BlockState state = source.getWorld().getBlockState(pos);
        source.getWorld().setBlockState(pos, state.with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)).with(ADVANCED_MOLD, mold));
    }

    private static Molds getNextMold(Molds mold) {
        switch (mold) {
            case EMPTY:
                return Molds.SINGULARITY;
            case SINGULARITY:
                return Molds.CRYSTALLIZED;
            case CRYSTALLIZED:
                return Molds.INGOT;
            case INGOT:
                return Molds.MOLD;
            case MOLD:
                return Molds.ROD;
            case ROD:
                return Molds.EMPTY;
        }
        return Molds.EMPTY;
    }

    private static AdvancedMolds getNextAdvancedMold(AdvancedMolds mold) {
        switch (mold) {
            case EMPTY:
                return AdvancedMolds.SINGULARITY;
            case SINGULARITY:
                return AdvancedMolds.CRYSTALLIZED;
            case CRYSTALLIZED:
                return AdvancedMolds.INGOT;
            case INGOT:
                return AdvancedMolds.MOLD;
            case MOLD:
                return AdvancedMolds.ROD;
            case ROD:
                return AdvancedMolds.CRYSTALLINE_EMPTY;
            case CRYSTALLINE_EMPTY:
                return AdvancedMolds.CRYSTALLINE_GEM;
            case CRYSTALLINE_GEM:
                return AdvancedMolds.EMPTY;
        }
        return AdvancedMolds.EMPTY;
    }
}
