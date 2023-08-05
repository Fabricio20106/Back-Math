package com.sophicreeper.backmath.core.world.level.block.machine;

import com.sophicreeper.backmath.core.util.BMKeys;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import com.sophicreeper.backmath.core.world.level.block.state.properties.Molds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;

public class CrystallizerBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty HORIZONTAL_FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<Molds> MOLD = EnumProperty.create("mold", Molds.class);

    public CrystallizerBlock() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.CLAY).strength(3.0f).sound(SoundType.METAL));
        this.registerDefaultState(this.stateDefinition.any().setValue(HORIZONTAL_FACING, Direction.NORTH).setValue(MOLD, Molds.EMPTY));
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack MainHand = player.getItemInHand(InteractionHand.MAIN_HAND);
        ItemStack OffHand = player.getItemInHand(InteractionHand.OFF_HAND);
        Direction direction = hit.getDirection();
        Direction direction1 = direction.getAxis() == Direction.Axis.Y ? player.getDirection().getOpposite() : direction;

        // sets the specific molds for the crafting recipes below
        if (MainHand.getItem() == AxolotlTest.INGOT_MOLD.get()) {
            world.setBlockAndUpdate(pos, BMBlocks.CRYSTALLIZER.get().defaultBlockState().setValue(MOLD, Molds.INGOT).setValue(HORIZONTAL_FACING, direction1));
            //player.awardStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.CRYSTALLIZED_MOLD.get()) {
            world.setBlockAndUpdate(pos, BMBlocks.CRYSTALLIZER.get().defaultBlockState().setValue(MOLD, Molds.CRYSTALLIZED).setValue(HORIZONTAL_FACING, direction1));
            //player.awardStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.SINGULARITY_MOLD.get()) {
            world.setBlockAndUpdate(pos, BMBlocks.CRYSTALLIZER.get().defaultBlockState().setValue(MOLD, Molds.SINGULARITY).setValue(HORIZONTAL_FACING, direction1));
            //player.awardStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.MOLD_MOLD.get()) {
            world.setBlockAndUpdate(pos, BMBlocks.CRYSTALLIZER.get().defaultBlockState().setValue(MOLD, Molds.MOLD).setValue(HORIZONTAL_FACING, direction1));
            //player.awardStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.ROD_MOLD.get()) {
            world.setBlockAndUpdate(pos, BMBlocks.CRYSTALLIZER.get().defaultBlockState().setValue(MOLD, Molds.ROD).setValue(HORIZONTAL_FACING, direction1));
            //player.awardStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (player.isShiftKeyDown()) {
            world.setBlockAndUpdate(pos, BMBlocks.CRYSTALLIZER.get().defaultBlockState().setValue(MOLD, Molds.EMPTY).setValue(HORIZONTAL_FACING, direction1));
            //player.awardStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        // you can also use the Book of the Regular Molds to change the cycle through the molds
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.getValue(MOLD) == Molds.EMPTY) {
            world.setBlockAndUpdate(pos, BMBlocks.CRYSTALLIZER.get().defaultBlockState().setValue(MOLD, Molds.SINGULARITY).setValue(HORIZONTAL_FACING, direction1));
            //player.awardStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.getValue(MOLD) == Molds.SINGULARITY) {
            world.setBlockAndUpdate(pos, BMBlocks.CRYSTALLIZER.get().defaultBlockState().setValue(MOLD, Molds.CRYSTALLIZED).setValue(HORIZONTAL_FACING, direction1));
            //player.awardStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.getValue(MOLD) == Molds.CRYSTALLIZED) {
            world.setBlockAndUpdate(pos, BMBlocks.CRYSTALLIZER.get().defaultBlockState().setValue(MOLD, Molds.INGOT).setValue(HORIZONTAL_FACING, direction1));
            //player.awardStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.getValue(MOLD) == Molds.INGOT) {
            world.setBlockAndUpdate(pos, BMBlocks.CRYSTALLIZER.get().defaultBlockState().setValue(MOLD, Molds.MOLD).setValue(HORIZONTAL_FACING, direction1));
            //player.awardStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.getValue(MOLD) == Molds.MOLD) {
            world.setBlockAndUpdate(pos, BMBlocks.CRYSTALLIZER.get().defaultBlockState().setValue(MOLD, Molds.ROD).setValue(HORIZONTAL_FACING, direction1));
            //player.awardStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }
        if (MainHand.getItem() == AxolotlTest.REGULAR_MOLDS_BOOK.get() && state.getValue(MOLD) == Molds.ROD) {
            world.setBlockAndUpdate(pos, BMBlocks.CRYSTALLIZER.get().defaultBlockState().setValue(MOLD, Molds.EMPTY).setValue(HORIZONTAL_FACING, direction1));
            //player.awardStat(BMStats.CHANGE_CRYSTALLIZER_MOLD);
        }

        // the crafting recipes mentioned above
        // when the mold is empty
        if (state.getValue(MOLD) == Molds.EMPTY) {
            if (MainHand.getItem() == AxolotlTest.ALJAME.get() && MainHand.getCount() == 4 && OffHand.getItem() == Items.BUCKET) {
                world.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0f, 1.0f);
                player.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(AxolotlTest.ALJAME.get(), 4));
                //player.awardStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(4);
            }
        } else {
            world.playSound(null, pos, SoundEvents.ANVIL_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f);
        }
        // when the mold is the rod one
        if (state.getValue(MOLD) == Molds.ROD) {
            if (MainHand.getItem() == AxolotlTest.HILLARY_AGGLOMERATIO.get()) {
                world.playSound(null, pos, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
                player.addItem(new ItemStack(AxolotlTest.HILLARY_ROD.get(), 4));
                player.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BUCKET));
                //player.awardStat(BMStats.CRAFT_IN_CRYSTALLIZER);
            }
        } else {
            world.playSound(null, pos, SoundEvents.ANVIL_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f);
        }
        // when the mold is the singularity one
        if (state.getValue(MOLD) == Molds.SINGULARITY) {
            if (MainHand.getItem() == AxolotlTest.MILKLLARY_AGGLOMERATIO.get()) {
                world.playSound(null, pos, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
                player.addItem(new ItemStack(AxolotlTest.MILKLLARITY.get()));
                player.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BUCKET));
                //player.awardStat(BMStats.CRAFT_IN_CRYSTALLIZER);
            }
            if (MainHand.getItem() == AxolotlTest.MID_TERM_INGOT.get()) {
                world.playSound(null, pos, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
                player.addItem(new ItemStack(AxolotlTest.MID_TERM.get()));
                //player.awardStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
            }
            if (MainHand.getItem() == AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_INGOT.get()) {
                world.playSound(null, pos, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
                player.addItem(new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM.get()));
                //player.awardStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
            }
            if (MainHand.getItem() == AxolotlTest.MILKLLARY_INGOT.get()) {
                world.playSound(null, pos, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
                player.addItem(new ItemStack(AxolotlTest.MILKLLARITY.get()));
                //player.awardStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
            }
        } else {
            world.playSound(null, pos, SoundEvents.ANVIL_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f);
        }
        // when the mold is the ingot one
        if (state.getValue(MOLD) == Molds.INGOT) {
            if (MainHand.getItem() == AxolotlTest.MID_TERM.get()) {
                world.playSound(null, pos, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
                player.addItem(new ItemStack(AxolotlTest.MID_TERM_INGOT.get()));
                //player.awardStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
            }
            if (MainHand.getItem() == AxolotlTest.OBSIDIAN_INFUSED_MID_TERM.get()) {
                world.playSound(null, pos, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
                player.addItem(new ItemStack(AxolotlTest.OBSIDIAN_INFUSED_MID_TERM_INGOT.get()));
                //player.awardStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
            }
            if (MainHand.getItem() == AxolotlTest.MILKLLARY_AGGLOMERATIO.get()) {
                world.playSound(null, pos, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
                player.addItem(new ItemStack(AxolotlTest.MILKLLARY_INGOT.get(), 2));
                player.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BUCKET));
                //player.awardStat(BMStats.CRAFT_IN_CRYSTALLIZER);
            }
            if (MainHand.getItem() == AxolotlTest.MILKLLARITY.get()) {
                world.playSound(null, pos, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
                player.addItem(new ItemStack(AxolotlTest.MILKLLARY_INGOT.get()));
                //player.awardStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
            }
            if (MainHand.getItem() == AxolotlTest.MILKLLARY_INGOT.get() && OffHand.getItem() == AxolotlTest.HILLARY_AGGLOMERATIO.get()) {
                world.playSound(null, pos, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
                player.addItem(new ItemStack(AxolotlTest.MID_HILLARY_INGOT.get()));
                //player.awardStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
                player.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.BUCKET));
            }
            if (MainHand.getItem() == AxolotlTest.HARDENED_AMARACAMEL_BATTER.get()) {
                world.playSound(null, pos, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
                player.addItem(new ItemStack(AxolotlTest.HARDENED_AMARACAMEL_INGOT.get()));
                //player.awardStat(BMStats.CRAFT_IN_CRYSTALLIZER);
                MainHand.shrink(1);
            }
        } else {
            world.playSound(null, pos, SoundEvents.ANVIL_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f);
        }
        // when the mold is the mold one
        if (state.getValue(MOLD) == Molds.MOLD) {
            if (MainHand.getItem() == AxolotlTest.CRYSTALLINE_ANGELIC.get()) {
                world.playSound(null, pos, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
                player.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(AxolotlTest.CRYSTALLINE_EMPTY_MOLD.get()));
                //player.awardStat(BMStats.CRAFT_IN_CRYSTALLIZER);
            }
        } else {
            world.playSound(null, pos, SoundEvents.ANVIL_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f);
        }
        return super.use(state, world, pos, player, hand, hit);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, MOLD);
    }
}
