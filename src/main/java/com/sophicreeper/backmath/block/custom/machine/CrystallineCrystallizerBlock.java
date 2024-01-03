package com.sophicreeper.backmath.block.custom.machine;

import com.sophicreeper.backmath.misc.BMSounds;
import com.sophicreeper.backmath.util.BMKeys;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.misc.BMStats;
import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.block.custom.properties.AdvancedMolds;
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

public class CrystallineCrystallizerBlock extends HorizontalBlock {
    public static final DirectionProperty HORIZONTAL_FACING = HorizontalBlock.HORIZONTAL_FACING;
    public static final EnumProperty<AdvancedMolds> ADVANCED_MOLD = EnumProperty.create("advanced_mold", AdvancedMolds.class);

    public CrystallineCrystallizerBlock() {
        super(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(3.5f).setRequiresTool().sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(2));
        this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(ADVANCED_MOLD, AdvancedMolds.EMPTY);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        ItemStack MainHand = player.getHeldItem(Hand.MAIN_HAND);
        ItemStack OffHand = player.getHeldItem(Hand.OFF_HAND);

        // You can set the specific molds for the recipes below using their respective mold items.
        if (MainHand.getItem().isIn(BMTags.Items.MOLDS_INGOT)) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(ADVANCED_MOLD, AdvancedMolds.INGOT));
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem().isIn(BMTags.Items.MOLDS_CRYSTALLIZED)) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(ADVANCED_MOLD, AdvancedMolds.CRYSTALLIZED));
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem().isIn(BMTags.Items.MOLDS_SINGULARITY)) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(ADVANCED_MOLD, AdvancedMolds.SINGULARITY));
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem().isIn(BMTags.Items.MOLDS_MOLD)) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(ADVANCED_MOLD, AdvancedMolds.MOLD));
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem().isIn(BMTags.Items.MOLDS_ROD)) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(ADVANCED_MOLD, AdvancedMolds.ROD));
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
        }
        if (BMKeys.isHoldingShift()) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(ADVANCED_MOLD, AdvancedMolds.EMPTY));
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem().isIn(BMTags.Items.MOLDS_CRYSTALLINE_EMPTY)) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(ADVANCED_MOLD, AdvancedMolds.CRYSTALLINE_EMPTY));
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem().isIn(BMTags.Items.MOLDS_CRYSTALLINE_GEM)) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(ADVANCED_MOLD, AdvancedMolds.CRYSTALLINE_GEM));
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
        }
        // Or you can just cycle through it using the Book of the Advanced Molds.
        if (MainHand.getItem() == AxolotlTest.ADVANCED_MOLDS_BOOK.get() && state.get(ADVANCED_MOLD) == AdvancedMolds.EMPTY) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(ADVANCED_MOLD, AdvancedMolds.SINGULARITY));
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.ADVANCED_MOLDS_BOOK.get() && state.get(ADVANCED_MOLD) == AdvancedMolds.SINGULARITY) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(ADVANCED_MOLD, AdvancedMolds.CRYSTALLIZED));
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.ADVANCED_MOLDS_BOOK.get() && state.get(ADVANCED_MOLD) == AdvancedMolds.CRYSTALLIZED) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(ADVANCED_MOLD, AdvancedMolds.INGOT));
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.ADVANCED_MOLDS_BOOK.get() && state.get(ADVANCED_MOLD) == AdvancedMolds.INGOT) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(ADVANCED_MOLD, AdvancedMolds.MOLD));
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.ADVANCED_MOLDS_BOOK.get() && state.get(ADVANCED_MOLD) == AdvancedMolds.MOLD) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(ADVANCED_MOLD, AdvancedMolds.ROD));
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.ADVANCED_MOLDS_BOOK.get() && state.get(ADVANCED_MOLD) == AdvancedMolds.ROD) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(ADVANCED_MOLD, AdvancedMolds.CRYSTALLINE_EMPTY));
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.ADVANCED_MOLDS_BOOK.get() && state.get(ADVANCED_MOLD) == AdvancedMolds.CRYSTALLINE_EMPTY) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(ADVANCED_MOLD, AdvancedMolds.CRYSTALLINE_GEM));
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.ADVANCED_MOLDS_BOOK.get() && state.get(ADVANCED_MOLD) == AdvancedMolds.CRYSTALLINE_GEM) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(ADVANCED_MOLD, AdvancedMolds.EMPTY));
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
        }
        // But if you use the Book of the Regular Molds, it cannot change it to a higher tier mold.
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(ADVANCED_MOLD) == AdvancedMolds.EMPTY) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(ADVANCED_MOLD, AdvancedMolds.SINGULARITY));
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(ADVANCED_MOLD) == AdvancedMolds.SINGULARITY) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(ADVANCED_MOLD, AdvancedMolds.CRYSTALLIZED));
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(ADVANCED_MOLD) == AdvancedMolds.CRYSTALLIZED) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(ADVANCED_MOLD, AdvancedMolds.INGOT));
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(ADVANCED_MOLD) == AdvancedMolds.INGOT) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(ADVANCED_MOLD, AdvancedMolds.MOLD));
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(ADVANCED_MOLD) == AdvancedMolds.MOLD) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(ADVANCED_MOLD, AdvancedMolds.ROD));
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(ADVANCED_MOLD) == AdvancedMolds.ROD) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(ADVANCED_MOLD, AdvancedMolds.EMPTY));
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
        }

        // The aforementioned recipes.
        // Mold: Empty.
        if (state.get(ADVANCED_MOLD) == AdvancedMolds.EMPTY) {
            if (MainHand.getItem() == AxolotlTest.ALJAME.get() && MainHand.getCount() == 4 && OffHand.getItem() == Items.BUCKET) {
                world.playSound(null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1f, 1f);
                player.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(AxolotlTest.LIQUID_ALJAME_BUCKET.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                MainHand.shrink(4);
            }
        } else {
            world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1f, 1f);
        }
        // Mold: Rod
        if (state.get(ADVANCED_MOLD) == AdvancedMolds.ROD) {
            if (MainHand.getItem() == AxolotlTest.HILLARY_BUCKET.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1f, 1f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.HILLARY_ROD.get()));
                player.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BUCKET));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
            }
        } else {
            world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1f, 1f);
        }
        // Mold: Singularity.
        if (state.get(ADVANCED_MOLD) == AdvancedMolds.SINGULARITY) {
            if (MainHand.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1f, 1f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARITY.get()));
                player.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BUCKET));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
            }
            if (MainHand.getItem() == AxolotlTest.MID_TERM_INGOT.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1f, 1f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MID_TERM.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                MainHand.shrink(1);
            }
            if (MainHand.getItem() == AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_INGOT.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1f, 1f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                MainHand.shrink(1);
            }
            if (MainHand.getItem() == AxolotlTest.MILKLLARY_INGOT.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1f, 1f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARITY.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                MainHand.shrink(1);
            }
            if (MainHand.getItem() == AxolotlTest.MOLTEN_MID_TERM_BUCKET.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1f, 1f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MID_TERM.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                player.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BUCKET));
            }
        } else {
            world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1f, 1f);
        }
        // Mold: Ingot.
        if (state.get(ADVANCED_MOLD) == AdvancedMolds.INGOT) {
            if (MainHand.getItem() == AxolotlTest.MID_TERM.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1f, 1f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MID_TERM_INGOT.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                MainHand.shrink(1);
            }
            if (MainHand.getItem() == AxolotlTest.OBSIDIAN_INFUSED_MID_TERM.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1f, 1f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_INGOT.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                MainHand.shrink(1);
            }
            if (MainHand.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1f, 1f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARY_INGOT.get(), 2));
                player.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BUCKET));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
            }
            if (MainHand.getItem() == AxolotlTest.MILKLLARITY.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1f, 1f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARY_INGOT.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                MainHand.shrink(1);
            }
            if (MainHand.getItem() == AxolotlTest.MILKLLARY_INGOT.get() && OffHand.getItem() == AxolotlTest.HILLARY_BUCKET.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1f, 1f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.TWO_THIRDS_HILLARY_INGOT.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                MainHand.shrink(1);
                player.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(Items.BUCKET));
            }
            if (MainHand.getItem() == AxolotlTest.HARDENED_AMARACAMEL_BATTER.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1f, 1f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.HARDENED_AMARACAMEL_INGOT.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                MainHand.shrink(1);
            }
            if (MainHand.getItem() == AxolotlTest.MOLTEN_MID_TERM_BUCKET.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1f, 1f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MID_TERM_INGOT.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                player.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BUCKET));
            }
        } else {
            world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1f, 1f);
        }
        // Mold: Mold
        if (state.get(ADVANCED_MOLD) == AdvancedMolds.MOLD) {
            if (MainHand.getItem() == AxolotlTest.CRYSTALLINE_ANGELIC.get()) {
                world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT, SoundCategory.BLOCKS, 1f, 1f);
                player.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.CRYSTALLINE_EMPTY_MOLD.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
            }
        } else {
            world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1f, 1f);
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
        builder.add(HORIZONTAL_FACING, ADVANCED_MOLD);
    }
}
