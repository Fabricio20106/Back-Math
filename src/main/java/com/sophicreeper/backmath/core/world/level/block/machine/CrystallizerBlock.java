package com.sophicreeper.backmath.core.world.level.block.machine;

import com.sophicreeper.backmath.core.world.item.BMStats;
import com.sophicreeper.backmath.core.world.level.block.state.properties.Molds;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import com.sophicreeper.backmath.core.util.BMKeys;
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

    public CrystallizerBlock() {
        super(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(3.0f).setRequiresTool().sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(2));
        this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(MOLD, Molds.EMPTY);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        ItemStack MainHand = player.getHeldItem(Hand.MAIN_HAND);
        ItemStack OffHand = player.getHeldItem(Hand.OFF_HAND);
        Direction direction = hit.getFace();
        Direction direction1 = direction.getAxis() == Direction.Axis.Y ? player.getHorizontalFacing().getOpposite() : direction;

        // Sets the specific molds for the recipes below.
        if (MainHand.getItem() == AxolotlTest.INGOT_MOLD.get()) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.INGOT).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.CRYSTALLIZED_MOLD.get()) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.CRYSTALLIZED).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.SINGULARITY_MOLD.get()) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.SINGULARITY).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.MOLD_MOLD.get()) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.MOLD).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.ROD_MOLD.get()) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.ROD).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (BMKeys.isHoldingShift()) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.EMPTY).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        // You can also use the Book of the Regular Molds to cycle through the mold types.
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(MOLD) == Molds.EMPTY) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.SINGULARITY).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(MOLD) == Molds.SINGULARITY) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.CRYSTALLIZED).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(MOLD) == Molds.CRYSTALLIZED) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.INGOT).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(MOLD) == Molds.INGOT) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.MOLD).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(MOLD) == Molds.MOLD) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.ROD).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(MOLD) == Molds.ROD) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.EMPTY).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }

        // The aforementioned recipes.
        // Mold: Empty.
        if (state.get(MOLD) == Molds.EMPTY) {
            if (MainHand.getItem() == AxolotlTest.ALJAME.get() && MainHand.getCount() == 4 && OffHand.getItem() == Items.BUCKET) {
                world.playSound(null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(AxolotlTest.LIQUID_ALJAME_BUCKET.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(4);
            }
        } else {
            world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        // Mold: Rod.
        if (state.get(MOLD) == Molds.ROD) {
            if (MainHand.getItem() == AxolotlTest.HILLARY_BUCKET.get()) {
                world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.HILLARY_ROD.get(), 4));
                player.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BUCKET));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
            }
        } else {
            world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        // Mold: Singularity.
        if (state.get(MOLD) == Molds.SINGULARITY) {
            if (MainHand.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARITY.get()));
                player.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BUCKET));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
            }
            if (MainHand.getItem() == AxolotlTest.MID_TERM_INGOT.get()) {
                world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MID_TERM.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
            }
            if (MainHand.getItem() == AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_INGOT.get()) {
                world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
            }
            if (MainHand.getItem() == AxolotlTest.MILKLLARY_INGOT.get()) {
                world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARITY.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
            }
        } else {
            world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        // Mold: Ingot.
        if (state.get(MOLD) == Molds.INGOT) {
            if (MainHand.getItem() == AxolotlTest.MID_TERM.get()) {
                world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MID_TERM_INGOT.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
            }
            if (MainHand.getItem() == AxolotlTest.OBSIDIAN_INFUSED_MID_TERM.get()) {
                world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_INGOT.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
            }
            if (MainHand.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARY_INGOT.get(), 2));
                player.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BUCKET));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
            }
            if (MainHand.getItem() == AxolotlTest.MILKLLARITY.get()) {
                world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARY_INGOT.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
            }
            if (MainHand.getItem() == AxolotlTest.MILKLLARY_INGOT.get() && OffHand.getItem() == AxolotlTest.HILLARY_BUCKET.get()) {
                world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MID_HILLARY_INGOT.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
                player.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(Items.BUCKET));
            }
            if (MainHand.getItem() == AxolotlTest.HARDENED_AMARACAMEL_BATTER.get()) {
                world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.HARDENED_AMARACAMEL_INGOT.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
            }
        } else {
            world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        // Mold: Mold.
        if (state.get(MOLD) == Molds.MOLD) {
            if (MainHand.getItem() == AxolotlTest.CRYSTALLINE_ANGELIC.get()) {
                world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.CRYSTALLINE_EMPTY_MOLD.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
            }
        } else {
            world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        return super.onBlockActivated(state, world, pos, player, hand, hit);
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(HORIZONTAL_FACING, rot.rotate(state.get(HORIZONTAL_FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(HORIZONTAL_FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, MOLD);
    }
}
