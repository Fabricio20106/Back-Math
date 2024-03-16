package com.sophicreeper.backmath.crystallizer.advanced;

import com.sophicreeper.backmath.crystallizer.MoldUtils;
import com.sophicreeper.backmath.misc.BMSounds;
import com.sophicreeper.backmath.util.BMKeys;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.misc.BMStats;
import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.block.*;
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
import net.minecraftforge.common.Tags;

import static com.sophicreeper.backmath.crystallizer.CrystallizerBlock.playSound;

public class CrystallineCrystallizerBlock extends HorizontalBlock {
    public static final DirectionProperty HORIZONTAL_FACING = HorizontalBlock.HORIZONTAL_FACING;
    public static final EnumProperty<AdvancedMolds> MOLD = EnumProperty.create("mold", AdvancedMolds.class);

    public CrystallineCrystallizerBlock(Properties properties) {
        super(properties);
        this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(MOLD, AdvancedMolds.EMPTY);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hitResult) {
        ItemStack mainHand = player.getHeldItem(Hand.MAIN_HAND);
        ItemStack offHand = player.getHeldItem(Hand.OFF_HAND);

        // Sets the specific molds for the recipes below.
        if (mainHand.getItem().isIn(BMTags.Items.MOLDS_EMPTY) && state.get(MOLD) != AdvancedMolds.EMPTY) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(MOLD, AdvancedMolds.EMPTY).with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)));
            playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CHANGE_MOLD);
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            return ActionResultType.SUCCESS;
        }
        if (BMKeys.isHoldingShift() && state.get(MOLD) != AdvancedMolds.EMPTY) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(MOLD, AdvancedMolds.EMPTY).with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)));
            playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CHANGE_MOLD);
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            return ActionResultType.SUCCESS;
        }
        if (mainHand.getItem().isIn(BMTags.Items.MOLDS_INGOT) && state.get(MOLD) != AdvancedMolds.INGOT) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(MOLD, AdvancedMolds.INGOT).with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)));
            playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CHANGE_MOLD);
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            return ActionResultType.SUCCESS;
        }
        if (mainHand.getItem().isIn(BMTags.Items.MOLDS_CRYSTALLIZED) && state.get(MOLD) != AdvancedMolds.CRYSTALLIZED) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(MOLD, AdvancedMolds.CRYSTALLIZED).with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)));
            playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CHANGE_MOLD);
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            return ActionResultType.SUCCESS;
        }
        if (mainHand.getItem().isIn(BMTags.Items.MOLDS_SINGULARITY) && state.get(MOLD) != AdvancedMolds.SINGULARITY) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(MOLD, AdvancedMolds.SINGULARITY).with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)));
            playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CHANGE_MOLD);
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            return ActionResultType.SUCCESS;
        }
        if (mainHand.getItem().isIn(BMTags.Items.MOLDS_MOLD) && state.get(MOLD) != AdvancedMolds.MOLD) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(MOLD, AdvancedMolds.MOLD).with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)));
            playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CHANGE_MOLD);
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            return ActionResultType.SUCCESS;
        }
        if (mainHand.getItem().isIn(BMTags.Items.MOLDS_ROD) && state.get(MOLD) != AdvancedMolds.ROD) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(MOLD, AdvancedMolds.ROD).with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)));
            playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CHANGE_MOLD);
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            return ActionResultType.SUCCESS;
        }
        if (mainHand.getItem().isIn(BMTags.Items.MOLDS_CRYSTALLINE_EMPTY) && state.get(MOLD) != AdvancedMolds.CRYSTALLINE_EMPTY) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(MOLD, AdvancedMolds.CRYSTALLINE_EMPTY).with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)));
            playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CHANGE_MOLD);
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            return ActionResultType.SUCCESS;
        }
        if (mainHand.getItem().isIn(BMTags.Items.MOLDS_CRYSTALLINE_GEM) && state.get(MOLD) != AdvancedMolds.CRYSTALLINE_GEM) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(MOLD, AdvancedMolds.CRYSTALLINE_GEM).with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)));
            playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CHANGE_MOLD);
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            return ActionResultType.SUCCESS;
        }

        // You can also use the Book of Advanced Molds to cycle through the mold types.
        if (mainHand.getItem() == AxolotlTest.ADVANCED_MOLDS_BOOK.get()) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(MOLD, MoldUtils.getNextAdvanced(state.get(MOLD))).with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)));
            playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CHANGE_MOLD);
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            return ActionResultType.SUCCESS;
        }

        // But if you use the Book of the Regular Molds, it cannot change it to a higher tier mold.
        if (mainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get()) {
            world.setBlockState(pos, BMBlocks.CRYSTALLINE_CRYSTALLIZER.get().getDefaultState().with(MOLD, MoldUtils.getNextAdvWithoutCrystalline(state.get(MOLD))).with(HORIZONTAL_FACING, state.get(HORIZONTAL_FACING)));
            playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CHANGE_MOLD);
            player.addStat(BMStats.CHANGE_CRYSTALLINE_CRYSTALLIZER_MOLD);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            return ActionResultType.SUCCESS;
        }

        if (!mainHand.getItem().isIn(BMTags.Items.CANNOT_USE_AT_CRYSTALLIZER)) {
            // MOLD: Empty
            if (state.get(MOLD) == AdvancedMolds.EMPTY) {
                // 4 Aljames + Bucket = Liquid Aljame Bucket
                if (mainHand.getItem() == AxolotlTest.ALJAME.get() && mainHand.getCount() >= 4 && offHand.getItem() == Items.BUCKET) {
                    playSound(world, pos, SoundEvents.ITEM_BUCKET_FILL);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.LIQUID_ALJAME_BUCKET.get()));
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
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
            if (state.get(MOLD) == AdvancedMolds.ROD) {
                // Hillary Bucket = 4 Hillary Rods + Bucket
                if (mainHand.getItem() == AxolotlTest.HILLARY_BUCKET.get()) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.HILLARY_ROD.get(), 4));
                    player.setItemStackToSlot(EquipmentSlotType.MAINHAND, mainHand.getContainerItem());
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    return ActionResultType.SUCCESS;
                }
            } else {
                playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT);
                return ActionResultType.FAIL;
            }
            // MOLD: Singularity
            if (state.get(MOLD) == AdvancedMolds.SINGULARITY) {
                // Milkllary Bucket = 2 Milkllarities + Bucket
                if (mainHand.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARITY.get(), 2));
                    player.setItemStackToSlot(EquipmentSlotType.MAINHAND, mainHand.getContainerItem());
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    return ActionResultType.SUCCESS;
                }
                // Mid-Term Ingot = Mid-Term (Singularity)
                if (mainHand.getItem().isIn(BMTags.Items.INGOTS_MID_TERM)) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.MID_TERM.get()));
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    mainHand.shrink(1);
                    return ActionResultType.SUCCESS;
                }
                // Obsidian Infused Mid-Term Ingot = Obsidian Infused Mid-Term (Singularity)
                if (mainHand.getItem().isIn(BMTags.Items.INGOTS_OBSIDIAN_INFUSED_MID_TERM)) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM.get()));
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    mainHand.shrink(1);
                    return ActionResultType.SUCCESS;
                }
                // Milkllary Ingot = Milkllarity
                if (mainHand.getItem().isIn(BMTags.Items.INGOTS_MILKLLARY)) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARITY.get()));
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    mainHand.shrink(1);
                    return ActionResultType.SUCCESS;
                }
                // Molten Mid-Term Bucket = Mid-Term + Bucket
                if (mainHand.getItem() == AxolotlTest.MOLTEN_MID_TERM_BUCKET.get()) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.MID_TERM.get()));
                    player.setItemStackToSlot(EquipmentSlotType.MAINHAND, mainHand.getContainerItem());
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    return ActionResultType.SUCCESS;
                }
            } else {
                playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT);
                return ActionResultType.FAIL;
            }
            // MOLD: Ingot
            if (state.get(MOLD) == AdvancedMolds.INGOT) {
                // Mid-Term (Singularity) = Mid-Term Ingot
                if (mainHand.getItem().isIn(BMTags.Items.SINGULARITIES_MID_TERM)) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.MID_TERM_INGOT.get()));
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    mainHand.shrink(1);
                    return ActionResultType.SUCCESS;
                }
                // Obsidian Infused Mid-Term (Singularity) = Obsidian Infused Mid-Term Ingot
                if (mainHand.getItem().isIn(BMTags.Items.SINGULARITIES_OBSIDIAN_INFUSED_MID_TERM)) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_INGOT.get()));
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    mainHand.shrink(1);
                    return ActionResultType.SUCCESS;
                }
                // Milkllary Bucket = 2 Milkllary Ingots = Bucket
                if (mainHand.getItem() == AxolotlTest.MILKLLARY_BUCKET.get()) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARY_INGOT.get(), 2));
                    player.setItemStackToSlot(EquipmentSlotType.MAINHAND, mainHand.getContainerItem());
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    return ActionResultType.SUCCESS;
                }
                // Milkllarity = Milkllary Ingot
                if (mainHand.getItem().isIn(BMTags.Items.SINGULARITIES_MILKLLARY)) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.MILKLLARY_INGOT.get()));
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    mainHand.shrink(1);
                    return ActionResultType.SUCCESS;
                }
                // Milkllary Ingot + Hillary Bucket = Two-Thirds Hillary Ingot + Bucket
                if (mainHand.getItem().isIn(BMTags.Items.INGOTS_MILKLLARY) && offHand.getItem() == AxolotlTest.HILLARY_BUCKET.get()) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.TWO_THIRDS_HILLARY_INGOT.get()));
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    player.addStat(Stats.ITEM_USED.get(offHand.getItem()));
                    player.setItemStackToSlot(EquipmentSlotType.OFFHAND, offHand.getContainerItem());
                    mainHand.shrink(1);
                    return ActionResultType.SUCCESS;
                }
                // Hardened Amaracamel Batter = Hardened Amaracamel Ingot
                if (mainHand.getItem() == AxolotlTest.HARDENED_AMARACAMEL_BATTER.get()) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.HARDENED_AMARACAMEL_INGOT.get()));
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    mainHand.shrink(1);
                    return ActionResultType.SUCCESS;
                }
                // Obsidian = Obsidian Ingot
                if (mainHand.getItem().isIn(Tags.Items.OBSIDIAN)) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.OBSIDIAN_INGOT.get()));
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    mainHand.shrink(1);
                    return ActionResultType.SUCCESS;
                }
                // Molten Mid-Term Bucket = Mid-Term Ingot = Bucket
                if (mainHand.getItem() == AxolotlTest.MOLTEN_MID_TERM_BUCKET.get()) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.MID_TERM_INGOT.get()));
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                    player.setItemStackToSlot(EquipmentSlotType.MAINHAND, mainHand.getContainerItem());
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    return ActionResultType.SUCCESS;
                }
            } else {
                playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT);
                return ActionResultType.FAIL;
            }
            // MOLD: Mold
            if (state.get(MOLD) == AdvancedMolds.MOLD) {
                if (mainHand.getItem().isIn(BMTags.Items.GEMS_CRYSTALLINE_ANGELIC) && mainHand.getCount() >= 2) {
                    playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_CRAFT);
                    player.addItemStackToInventory(new ItemStack(AxolotlTest.CRYSTALLINE_EMPTY_MOLD.get()));
                    player.addStat(BMStats.CRAFT_IN_CRYSTALLINE_CRYSTALLIZER);
                    player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
                    mainHand.shrink(2);
                    return ActionResultType.SUCCESS;
                }
            } else {
                playSound(world, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT);
                return ActionResultType.FAIL;
            }
        }
        return super.onBlockActivated(state, world, pos, player, hand, hitResult);
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
