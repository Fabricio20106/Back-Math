package com.sophicreeper.backmath.crystallizer;

import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.misc.BMSounds;
import com.sophicreeper.backmath.misc.BMStats;
import com.sophicreeper.backmath.util.BMKeys;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

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

        // Sets the specific molds for the recipes below.
        if (mainHand.getItem().isIn(BMTags.Items.MOLDS_EMPTY) && state.get(MOLD) != Molds.EMPTY) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.EMPTY).with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)));
            playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CHANGE_MOLD);
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            return ActionResultType.SUCCESS;
        }
        if (BMKeys.isHoldingShift() && state.get(MOLD) != Molds.EMPTY) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.EMPTY).with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)));
            playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CHANGE_MOLD);
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
            return ActionResultType.SUCCESS;
        }
        if (mainHand.getItem().isIn(BMTags.Items.MOLDS_INGOT) && state.get(MOLD) != Molds.INGOT) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.INGOT).with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)));
            playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CHANGE_MOLD);
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            return ActionResultType.SUCCESS;
        }
        if (mainHand.getItem().isIn(BMTags.Items.MOLDS_CRYSTALLIZED) && state.get(MOLD) != Molds.CRYSTALLIZED) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.CRYSTALLIZED).with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)));
            playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CHANGE_MOLD);
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            return ActionResultType.SUCCESS;
        }
        if (mainHand.getItem().isIn(BMTags.Items.MOLDS_SINGULARITY) && state.get(MOLD) != Molds.SINGULARITY) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.SINGULARITY).with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)));
            playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CHANGE_MOLD);
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            return ActionResultType.SUCCESS;
        }
        if (mainHand.getItem().isIn(BMTags.Items.MOLDS_MOLD) && state.get(MOLD) != Molds.MOLD) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.MOLD).with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)));
            playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CHANGE_MOLD);
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            return ActionResultType.SUCCESS;
        }
        if (mainHand.getItem().isIn(BMTags.Items.MOLDS_ROD) && state.get(MOLD) != Molds.ROD) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, Molds.ROD).with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)));
            playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CHANGE_MOLD);
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            return ActionResultType.SUCCESS;
        }

        // You can also use the Book of the Regular Molds to cycle through the mold types.
        if (mainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get()) {
            world.setBlockState(pos, BMBlocks.CRYSTALLIZER.get().getDefaultState().with(MOLD, MoldUtils.getNextMold(state.get(MOLD))).with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)));
            playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CHANGE_MOLD);
            player.addStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            return ActionResultType.SUCCESS;
        }

        if (!mainHand.getItem().isIn(BMTags.Items.CANNOT_USE_AT_CRYSTALLIZER)) {
            // MOLD: Empty
            if (state.get(MOLD) == Molds.EMPTY) {
                // 4 Aljames + Bucket = Liquid Aljame Bucket
                if (mainHand.getItem() == AxolotlTest.ALJAME.get() && mainHand.getCount() >= 4 && offHand.getItem() == Items.BUCKET) {
                    playSound(world, pos, SoundEvents.ITEM_BUCKET_FILL);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.LIQUID_ALJAME_BUCKET.get()));
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    player.addStat(Stats.ITEM_USED.get(offHand.getItem()));
                    offHand.shrink(1);
                    mainHand.shrink(4);
                    return ActionResultType.SUCCESS;
                }
            } else {
                playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT);
                return ActionResultType.FAIL;
            }
            // MOLD: Rod
            if (state.get(MOLD) == Molds.ROD) {
                // Hillary Bucket = 4 Hillary Rods + Bucket
                if (mainHand.getItem() == AxolotlTest.HILLARY_BUCKET.get()) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.HILLARY_ROD.get(), 4));
                    player.setItemStackToSlot(EquipmentSlotType.MAINHAND, mainHand.getContainerItem());
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    return ActionResultType.SUCCESS;
                }
            } else {
                playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT);
                return ActionResultType.FAIL;
            }
            // MOLD: Singularity
            if (state.get(MOLD) == Molds.SINGULARITY) {
                // Milkllary Bucket = Milkllarity + Bucket
                if (mainHand.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARITY.get(), 2));
                    player.setItemStackToSlot(EquipmentSlotType.MAINHAND, mainHand.getContainerItem());
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    return ActionResultType.SUCCESS;
                }
                if (mainHand.getItem().isIn(BMTags.Items.INGOTS_MID_TERM)) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.MID_TERM.get()));
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    mainHand.shrink(1);
                    return ActionResultType.SUCCESS;
                }
                if (mainHand.getItem().isIn(BMTags.Items.INGOTS_OBSIDIAN_INFUSED_MID_TERM)) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM.get()));
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    mainHand.shrink(1);
                    return ActionResultType.SUCCESS;
                }
                if (mainHand.getItem().isIn(BMTags.Items.INGOTS_MILKLLARY)) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARITY.get()));
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    mainHand.shrink(1);
                    return ActionResultType.SUCCESS;
                }
            } else {
                playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT);
                return ActionResultType.FAIL;
            }
            // Mold: Ingot.
            if (state.get(MOLD) == Molds.INGOT) {
                if (mainHand.getItem().isIn(BMTags.Items.SINGULARITIES_MID_TERM)) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.MID_TERM_INGOT.get()));
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    mainHand.shrink(1);
                    return ActionResultType.SUCCESS;
                }
                if (mainHand.getItem().isIn(BMTags.Items.SINGULARITIES_OBSIDIAN_INFUSED_MID_TERM)) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_INGOT.get()));
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    mainHand.shrink(1);
                    return ActionResultType.SUCCESS;
                }
                if (mainHand.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARY_INGOT.get(), 2));
                    player.setItemStackToSlot(EquipmentSlotType.MAINHAND, mainHand.getContainerItem());
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    return ActionResultType.SUCCESS;
                }
                if (mainHand.getItem().isIn(BMTags.Items.SINGULARITIES_MILKLLARY)) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARY_INGOT.get()));
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    mainHand.shrink(1);
                    return ActionResultType.SUCCESS;
                }
                if (mainHand.getItem().isIn(BMTags.Items.INGOTS_MILKLLARY) && offHand.getItem() == AxolotlTest.HILLARY_BUCKET.get()) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.TWO_THIRDS_HILLARY_INGOT.get()));
                    player.setItemStackToSlot(EquipmentSlotType.OFFHAND, offHand.getContainerItem());
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    player.addStat(Stats.ITEM_USED.get(offHand.getItem()));
                    mainHand.shrink(1);
                    return ActionResultType.SUCCESS;
                }
                if (mainHand.getItem() == AxolotlTest.HARDENED_AMARACAMEL_BATTER.get()) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.HARDENED_AMARACAMEL_INGOT.get()));
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    mainHand.shrink(1);
                    return ActionResultType.SUCCESS;
                }
            } else {
                playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT);
                return ActionResultType.FAIL;
            }
            // Mold: Mold.
            if (state.get(MOLD) == Molds.MOLD) {
                if (mainHand.getItem().isIn(BMTags.Items.GEMS_CRYSTALLINE_ANGELIC) && mainHand.getCount() >= 2) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(AxolotlTest.CRYSTALLINE_EMPTY_MOLD.get()));
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    mainHand.shrink(2);
                    return ActionResultType.SUCCESS;
                }
            } else {
                playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT);
                return ActionResultType.FAIL;
            }
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

    private void playSound(World world, BlockPos pos, SoundEvent craftingSound) {
         world.playSound(null, pos, craftingSound, SoundCategory.BLOCKS, 1, 1);
    }
}
