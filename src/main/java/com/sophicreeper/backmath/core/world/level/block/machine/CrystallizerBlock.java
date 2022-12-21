package com.sophicreeper.backmath.core.world.level.block.machine;

import com.sophicreeper.backmath.core.world.item.BMStats;
import com.sophicreeper.backmath.core.world.level.block.state.properties.Molds;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import com.sophicreeper.backmath.core.util.Keys;
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
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack MainHand = player.getHeldItem(Hand.MAIN_HAND);
        ItemStack OffHand = player.getHeldItem(Hand.OFF_HAND);
        Direction direction = hit.getFace();
        Direction direction1 = direction.getAxis() == Direction.Axis.Y ? player.getHorizontalFacing().getOpposite() : direction;

        // sets the specific molds for the crafting recipes below
        if (MainHand.getItem() == AxolotlTest.INGOT_MOLD.get()) {
            worldIn.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.INGOT).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.CRYSTALLIZED_MOLD.get()) {
            worldIn.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.CRYSTALLIZED).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.SINGULARITY_MOLD.get()) {
            worldIn.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.SINGULARITY).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.MOLD_MOLD.get()) {
            worldIn.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.MOLD).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.ROD_MOLD.get()) {
            worldIn.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.ROD).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (Keys.isHoldingShift()) {
            worldIn.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.EMPTY).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        // you can also use the Book of the Regular Molds to change the cycle through the molds
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(MOLD) == Molds.EMPTY) {
            worldIn.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.SINGULARITY).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(MOLD) == Molds.SINGULARITY) {
            worldIn.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.CRYSTALLIZED).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(MOLD) == Molds.CRYSTALLIZED) {
            worldIn.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.INGOT).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(MOLD) == Molds.INGOT) {
            worldIn.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.MOLD).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(MOLD) == Molds.MOLD) {
            worldIn.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.ROD).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.get(MOLD) == Molds.ROD) {
            worldIn.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.EMPTY).with(HORIZONTAL_FACING, direction1));
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }

        // the crafting recipes mentioned above
        // when the mold is empty
        if (state.get(MOLD) == Molds.EMPTY) {
            if (MainHand.getItem() == AxolotlTest.ALJAME.get() && MainHand.getCount() == 4 && OffHand.getItem() == Items.BUCKET) {
                worldIn.playSound(null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(AxolotlTest.LIQUID_ALJAME_BUCKET.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(4);
            }
        } else {
            worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        // when the mold is the rod one
        if (state.get(MOLD) == Molds.ROD) {
            if (MainHand.getItem() == AxolotlTest.HILLARY_BUCKET.get()) {
                worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.HILLARY_ROD.get(), 4));
                player.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BUCKET));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
            }
        } else {
            worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        // when the mold is the singularity one
        if (state.get(MOLD) == Molds.SINGULARITY) {
            if (MainHand.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARITY.get()));
                player.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BUCKET));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
            }
            if (MainHand.getItem() == AxolotlTest.MID_TERM_INGOT.get()) {
                worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MID_TERM.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
            }
            if (MainHand.getItem() == AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_INGOT.get()) {
                worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
            }
            if (MainHand.getItem() == AxolotlTest.MILKLLARY_INGOT.get()) {
                worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARITY.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
            }
        } else {
            worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        // when the mold is the ingot one
        if (state.get(MOLD) == Molds.INGOT) {
            if (MainHand.getItem() == AxolotlTest.MID_TERM.get()) {
                worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MID_TERM_INGOT.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
            }
            if (MainHand.getItem() == AxolotlTest.OBSIDIAN_INFUSED_MID_TERM.get()) {
                worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_INGOT.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
            }
            if (MainHand.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARY_INGOT.get(), 2));
                player.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BUCKET));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
            }
            if (MainHand.getItem() == AxolotlTest.MILKLLARITY.get()) {
                worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARY_INGOT.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
            }
            if (MainHand.getItem() == AxolotlTest.MILKLLARY_INGOT.get() && OffHand.getItem() == AxolotlTest.HILLARY_BUCKET.get()) {
                worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.MID_HILLARY_INGOT.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
                player.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(Items.BUCKET));
            }
            if (MainHand.getItem() == AxolotlTest.HARDENED_AMARACAMEL_BATTER.get()) {
                worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.addItemStackToInventory(new ItemStack(AxolotlTest.HARDENED_AMARACAMEL_INGOT.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
            }
        } else {
            worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        // when the mold is the mold one
        if (state.get(MOLD) == Molds.MOLD) {
            if (MainHand.getItem() == AxolotlTest.CRYSTALLINE_ANGELIC.get()) {
                worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                player.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.CRYSTALLINE_EMPTY_MOLD.get()));
                player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
            }
        } else {
            worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
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
