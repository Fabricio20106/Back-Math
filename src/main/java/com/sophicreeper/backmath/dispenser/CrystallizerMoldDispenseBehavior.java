package com.sophicreeper.backmath.dispenser;

import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.crystallizer.CrystallizerBlock;
import com.sophicreeper.backmath.crystallizer.MoldUtils;
import com.sophicreeper.backmath.crystallizer.Molds;
import com.sophicreeper.backmath.crystallizer.advanced.AdvancedMolds;
import com.sophicreeper.backmath.crystallizer.advanced.CrystallineCrystallizerBlock;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.misc.BMSounds;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;

import static com.sophicreeper.backmath.crystallizer.CrystallizerBlock.HORIZONTAL_FACING;

public class CrystallizerMoldDispenseBehavior extends OptionalDispenseBehavior {
    private final String moldType;

    public CrystallizerMoldDispenseBehavior(String type) {
        this.moldType = type;
    }

    @Override
    protected ItemStack execute(IBlockSource source, ItemStack stack) {
        BlockPos pos = source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING));
        BlockState state = source.getLevel().getBlockState(pos);
        setSuccess(true);
        if (state.is(BMBlocks.CRYSTALLIZER.get())) {
            if (stack.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get()) {
                source.getLevel().setBlockAndUpdate(pos, state.setValue(HORIZONTAL_FACING, state.getValue(HORIZONTAL_FACING)).setValue(CrystallizerBlock.MOLD, MoldUtils.getNext(state.getValue(CrystallizerBlock.MOLD))));
            }
            if (stack.getItem().is(BMTags.Items.MOLDS_SINGULARITY) && state.getValue(CrystallizerBlock.MOLD) != Molds.SINGULARITY) {
                setMold(MoldUtils.getMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().is(BMTags.Items.MOLDS_CRYSTALLIZED) && state.getValue(CrystallizerBlock.MOLD) != Molds.CRYSTALLIZED) {
                setMold(MoldUtils.getMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().is(BMTags.Items.MOLDS_INGOT) && state.getValue(CrystallizerBlock.MOLD) != Molds.INGOT) {
                setMold(MoldUtils.getMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().is(BMTags.Items.MOLDS_MOLD) && state.getValue(CrystallizerBlock.MOLD) != Molds.MOLD) {
                setMold(MoldUtils.getMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().is(BMTags.Items.MOLDS_ROD) && state.getValue(CrystallizerBlock.MOLD) != Molds.ROD) {
                setMold(MoldUtils.getMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().is(BMTags.Items.MOLDS_EMPTY) && state.getValue(CrystallizerBlock.MOLD) != Molds.EMPTY) {
                setMold(MoldUtils.getMoldFromString(this.moldType), pos, source);
            }
        } else if (state.is(BMBlocks.CRYSTALLINE_CRYSTALLIZER.get())) {
            if (stack.getItem() == AxolotlTest.ADVANCED_MOLDS_BOOK.get()) {
                source.getLevel().setBlockAndUpdate(pos, state.setValue(HORIZONTAL_FACING, state.getValue(HORIZONTAL_FACING)).setValue(CrystallineCrystallizerBlock.MOLD, MoldUtils.getNextAdvanced(state.getValue(CrystallineCrystallizerBlock.MOLD))));
            }
            if (stack.getItem().is(BMTags.Items.MOLDS_SINGULARITY) && state.getValue(CrystallineCrystallizerBlock.MOLD) != AdvancedMolds.SINGULARITY) {
                setAdvancedMold(MoldUtils.getAdvancedMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().is(BMTags.Items.MOLDS_CRYSTALLIZED) && state.getValue(CrystallineCrystallizerBlock.MOLD) != AdvancedMolds.CRYSTALLIZED) {
                setAdvancedMold(MoldUtils.getAdvancedMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().is(BMTags.Items.MOLDS_INGOT) && state.getValue(CrystallineCrystallizerBlock.MOLD) != AdvancedMolds.INGOT) {
                setAdvancedMold(MoldUtils.getAdvancedMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().is(BMTags.Items.MOLDS_MOLD) && state.getValue(CrystallineCrystallizerBlock.MOLD) != AdvancedMolds.MOLD) {
                setAdvancedMold(MoldUtils.getAdvancedMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().is(BMTags.Items.MOLDS_ROD) && state.getValue(CrystallineCrystallizerBlock.MOLD) != AdvancedMolds.ROD) {
                setAdvancedMold(MoldUtils.getAdvancedMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().is(BMTags.Items.MOLDS_EMPTY) && state.getValue(CrystallineCrystallizerBlock.MOLD) != AdvancedMolds.EMPTY) {
                setAdvancedMold(MoldUtils.getAdvancedMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().is(BMTags.Items.MOLDS_CRYSTALLINE_EMPTY) && state.getValue(CrystallineCrystallizerBlock.MOLD) != AdvancedMolds.CRYSTALLINE_EMPTY) {
                setAdvancedMold(MoldUtils.getAdvancedMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().is(BMTags.Items.MOLDS_CRYSTALLINE_GEM) && state.getValue(CrystallineCrystallizerBlock.MOLD) != AdvancedMolds.CRYSTALLINE_GEM) {
                setAdvancedMold(MoldUtils.getAdvancedMoldFromString(this.moldType), pos, source);
            }
        } else {
            return super.execute(source, stack);
        }
        return stack;
    }

    private static void setMold(Molds mold, BlockPos pos, IBlockSource source) {
        BlockState state = source.getLevel().getBlockState(pos);
        source.getLevel().setBlockAndUpdate(pos, state.setValue(HORIZONTAL_FACING, state.getValue(HORIZONTAL_FACING)).setValue(CrystallizerBlock.MOLD, mold));
    }

    private static void setAdvancedMold(AdvancedMolds mold, BlockPos pos, IBlockSource source) {
        BlockState state = source.getLevel().getBlockState(pos);
        source.getLevel().setBlockAndUpdate(pos, state.setValue(HORIZONTAL_FACING, state.getValue(HORIZONTAL_FACING)).setValue(CrystallineCrystallizerBlock.MOLD, mold));
    }

    @Override
    protected void playSound(IBlockSource source) {
        if (this.isSuccess()) {
            source.getLevel().playSound(null, source.getPos(), BMSounds.BLOCK_CRYSTALLIZER_CHANGE_MOLD, SoundCategory.BLOCKS, 1, 1);
        } else {
            source.getLevel().levelEvent(1001, source.getPos(), 0);
        }
    }
}
