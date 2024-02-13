package com.sophicreeper.backmath.block.custom.machine;

import com.sophicreeper.backmath.misc.BMSounds;
import com.sophicreeper.backmath.misc.BMStats;
import com.sophicreeper.backmath.block.custom.properties.Molds;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.util.BMKeys;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class CrystallizerBlock extends HorizontalBlock {
    public static final DirectionProperty HORIZONTAL_FACING = HorizontalBlock.HORIZONTAL_FACING;
    public static final EnumProperty<Molds> MOLD = EnumProperty.create("mold", Molds.class);

    public CrystallizerBlock(Properties properties) {
        super(properties);
        this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(MOLD, Molds.EMPTY);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        ItemStack mainHand = player.getHeldItem(Hand.MAIN_HAND);
        ItemStack offHand = player.getHeldItem(Hand.OFF_HAND);
        Direction direction = hit.getFace();
        Direction direction1 = direction.getAxis() == Direction.Axis.Y ? player.getHorizontalFacing().getOpposite() : direction;

        // Sets the specific molds for the recipes below.
        if (mainHand.getItem().isIn(BMTags.Items.MOLDS_INGOT)) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.INGOT).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (mainHand.getItem().isIn(BMTags.Items.MOLDS_CRYSTALLIZED)) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.CRYSTALLIZED).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (mainHand.getItem().isIn(BMTags.Items.MOLDS_SINGULARITY)) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.SINGULARITY).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (mainHand.getItem().isIn(BMTags.Items.MOLDS_MOLD)) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.MOLD).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (mainHand.getItem().isIn(BMTags.Items.MOLDS_ROD)) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.ROD).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (BMKeys.isHoldingShift()) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.EMPTY).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }

        // You can also use the Book of the Regular Molds to cycle through the mold types.
        if (mainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(MOLD) == Molds.EMPTY) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.SINGULARITY).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (mainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(MOLD) == Molds.SINGULARITY) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.CRYSTALLIZED).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (mainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(MOLD) == Molds.CRYSTALLIZED) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.INGOT).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (mainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(MOLD) == Molds.INGOT) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.MOLD).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (mainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(MOLD) == Molds.MOLD) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.ROD).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (mainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(MOLD) == Molds.ROD) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.EMPTY).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }

        // The aforementioned recipes.
        // Mold: Empty.
        if (state.get(MOLD) == Molds.EMPTY) {
            if (mainHand.getItem() == AxolotlTest.ALJAME.get() && mainHand.getCount() == 4 && offHand.getItem() == Items.BUCKET) {
                world.playSound(null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1, 1);
                player.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(AxolotlTest.LIQUID_ALJAME_BUCKET.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                mainHand.shrink(4);
            }
        } else {
            world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
        }
        // Mold: Rod.
        if (state.get(MOLD) == Molds.ROD) {
            if (mainHand.getItem() == AxolotlTest.HILLARY_BUCKET.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.HILLARY_ROD.get(), 4));
                player.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BUCKET));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
            }
        } else {
            world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
        }
        // Mold: Singularity.
        if (state.get(MOLD) == Molds.SINGULARITY) {
            if (mainHand.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARITY.get()));
                player.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BUCKET));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                return ActionResultType.SUCCESS;
            }
            if (mainHand.getItem() == AxolotlTest.MID_TERM_INGOT.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MID_TERM.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                mainHand.shrink(1);
            }
            if (mainHand.getItem() == AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_INGOT.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                mainHand.shrink(1);
            }
            if (mainHand.getItem() == AxolotlTest.MILKLLARY_INGOT.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARITY.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                mainHand.shrink(1);
            }
        } else {
            world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
        }
        // Mold: Ingot.
        if (state.get(MOLD) == Molds.INGOT) {
            if (mainHand.getItem() == AxolotlTest.MID_TERM.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MID_TERM_INGOT.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                mainHand.shrink(1);
            }
            if (mainHand.getItem() == AxolotlTest.OBSIDIAN_INFUSED_MID_TERM.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_INGOT.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                mainHand.shrink(1);
            }
            if (mainHand.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARY_INGOT.get(), 2));
                player.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BUCKET));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
            }
            if (mainHand.getItem() == AxolotlTest.MILKLLARITY.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARY_INGOT.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                mainHand.shrink(1);
            }
            if (mainHand.getItem() == AxolotlTest.MILKLLARY_INGOT.get() && offHand.getItem() == AxolotlTest.HILLARY_BUCKET.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.TWO_THIRDS_HILLARY_INGOT.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                mainHand.shrink(1);
                player.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(Items.BUCKET));
            }
            if (mainHand.getItem() == AxolotlTest.HARDENED_AMARACAMEL_BATTER.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.HARDENED_AMARACAMEL_INGOT.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                mainHand.shrink(1);
            }
        } else {
            world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
        }
        // Mold: Mold.
        if (state.get(MOLD) == Molds.MOLD) {
            if (mainHand.getItem() == AxolotlTest.CRYSTALLINE_ANGELIC.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1, 1);
                player.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.CRYSTALLINE_EMPTY_MOLD.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
            }
        } else {
            world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
        }
        return super.onBlockActivated(state, world, pos, player, hand, hit);
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.with(HORIZONTAL_FACING, rotation.rotate(state.get(HORIZONTAL_FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.toRotation(state.get(HORIZONTAL_FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, MOLD);
    }
}
