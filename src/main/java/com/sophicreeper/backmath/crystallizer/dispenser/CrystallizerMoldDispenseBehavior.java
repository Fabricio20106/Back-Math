package com.sophicreeper.backmath.crystallizer.dispenser;

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
    protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
        BlockPos pos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
        BlockState state = source.getWorld().getBlockState(pos);
        setSuccessful(true);
        if (state.isIn(BMBlocks.CRYSTALLIZER.get())) {
            if (stack.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get()) {
                source.getWorld().setBlockState(pos, state.with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)).with(CrystallizerBlock.MOLD, MoldUtils.getNext(state.get(CrystallizerBlock.MOLD))));
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_SINGULARITY) && state.get(CrystallizerBlock.MOLD) != Molds.SINGULARITY) {
                setMold(MoldUtils.getMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_CRYSTALLIZED) && state.get(CrystallizerBlock.MOLD) != Molds.CRYSTALLIZED) {
                setMold(MoldUtils.getMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_INGOT) && state.get(CrystallizerBlock.MOLD) != Molds.INGOT) {
                setMold(MoldUtils.getMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_MOLD) && state.get(CrystallizerBlock.MOLD) != Molds.MOLD) {
                setMold(MoldUtils.getMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_ROD) && state.get(CrystallizerBlock.MOLD) != Molds.ROD) {
                setMold(MoldUtils.getMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_EMPTY) && state.get(CrystallizerBlock.MOLD) != Molds.EMPTY) {
                setMold(MoldUtils.getMoldFromString(this.moldType), pos, source);
            }
        } else if (state.isIn(BMBlocks.CRYSTALLINE_CRYSTALLIZER.get())) {
            if (stack.getItem() == AxolotlTest.ADVANCED_MOLDS_BOOK.get()) {
                source.getWorld().setBlockState(pos, state.with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)).with(CrystallineCrystallizerBlock.MOLD, MoldUtils.getNextAdvanced(state.get(CrystallineCrystallizerBlock.MOLD))));
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_SINGULARITY) && state.get(CrystallineCrystallizerBlock.MOLD) != AdvancedMolds.SINGULARITY) {
                setAdvancedMold(MoldUtils.getAdvancedMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_CRYSTALLIZED) && state.get(CrystallineCrystallizerBlock.MOLD) != AdvancedMolds.CRYSTALLIZED) {
                setAdvancedMold(MoldUtils.getAdvancedMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_INGOT) && state.get(CrystallineCrystallizerBlock.MOLD) != AdvancedMolds.INGOT) {
                setAdvancedMold(MoldUtils.getAdvancedMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_MOLD) && state.get(CrystallineCrystallizerBlock.MOLD) != AdvancedMolds.MOLD) {
                setAdvancedMold(MoldUtils.getAdvancedMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_ROD) && state.get(CrystallineCrystallizerBlock.MOLD) != AdvancedMolds.ROD) {
                setAdvancedMold(MoldUtils.getAdvancedMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_EMPTY) && state.get(CrystallineCrystallizerBlock.MOLD) != AdvancedMolds.EMPTY) {
                setAdvancedMold(MoldUtils.getAdvancedMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_CRYSTALLINE_EMPTY) && state.get(CrystallineCrystallizerBlock.MOLD) != AdvancedMolds.CRYSTALLINE_EMPTY) {
                setAdvancedMold(MoldUtils.getAdvancedMoldFromString(this.moldType), pos, source);
            }
            if (stack.getItem().isIn(BMTags.Items.MOLDS_CRYSTALLINE_GEM) && state.get(CrystallineCrystallizerBlock.MOLD) != AdvancedMolds.CRYSTALLINE_GEM) {
                setAdvancedMold(MoldUtils.getAdvancedMoldFromString(this.moldType), pos, source);
            }
        } else {
            return super.dispenseStack(source, stack);
        }
        return stack;
    }

    private static void setMold(Molds mold, BlockPos pos, IBlockSource source) {
        BlockState state = source.getWorld().getBlockState(pos);
        source.getWorld().setBlockState(pos, state.with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)).with(CrystallizerBlock.MOLD, mold));
    }

    private static void setAdvancedMold(AdvancedMolds mold, BlockPos pos, IBlockSource source) {
        BlockState state = source.getWorld().getBlockState(pos);
        source.getWorld().setBlockState(pos, state.with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)).with(CrystallineCrystallizerBlock.MOLD, mold));
    }

    @Override
    protected void playDispenseSound(IBlockSource source) {
        if (this.isSuccessful()) {
            source.getWorld().playSound(null, source.getBlockPos(), BMSounds.BLOCK_CRYSTALLIZER_CHANGE_MOLD, SoundCategory.BLOCKS, 1, 1);
        } else {
            source.getWorld().playEvent(1001, source.getBlockPos(), 0);
        }
    }
}
