package com.sophicreeper.backmath.core.world.level.block.machine;

import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import com.sophicreeper.backmath.core.world.item.BMStats;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.stream.Stream;

public class MealCookerBlock extends HorizontalBlock {
    public static final VoxelShape SHAPE = Stream.of(
            Block.makeCuboidShape(3, 23, 3, 13, 23, 13),
            Block.makeCuboidShape(3, 17, 13, 13, 24, 14),
            Block.makeCuboidShape(3, 17, 2, 13, 24, 3),
            Block.makeCuboidShape(13, 17, 3, 14, 24, 13),
            Block.makeCuboidShape(2, 17, 3, 3, 24, 13),
            Block.makeCuboidShape(3, 16, 3, 13, 17, 13),
            Block.makeCuboidShape(0, 0, 0, 16, 16, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    public MealCookerBlock() {
        super(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().sound(SoundType.WOOD).hardnessAndResistance(2.0F, 6.0F));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        ItemStack MainHand = player.getHeldItem(Hand.MAIN_HAND);
        ItemStack OffHand = player.getHeldItem(Hand.OFF_HAND);

        if (MainHand.getItem() == AxolotlTest.HOT_SOPHIE.get() && OffHand.getItem() == AxolotlTest.COLD_FABRICIO.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.HOT_SOPHIE_COLD_FABRICIO_MEAL.get()));
            player.addStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            MainHand.shrink(1);
            OffHand.shrink(1);
        }
        if (MainHand.getItem() == AxolotlTest.FRIED_SOPHIE.get() && OffHand.getItem() == AxolotlTest.FRIED_EGG.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.FRIED_SOPHIE_FRIED_EGG_MEAL.get()));
            player.addStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            MainHand.shrink(1);
            OffHand.shrink(1);
        }
        if (MainHand.getItem() == AxolotlTest.COOKED_LUCIA.get() && OffHand.getItem() == AxolotlTest.FRIED_EGG.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.COOKED_LUCIA_FRIED_EGG_MEAL.get()));
            player.addStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            MainHand.shrink(1);
            OffHand.shrink(1);
        }
        if (MainHand.getItem() == AxolotlTest.TOASTED_FABRICIO.get() && OffHand.getItem() == AxolotlTest.FRIED_EGG.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.TOASTED_FABRICIO_FRIED_EGG_MEAL.get()));
            player.addStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            MainHand.shrink(1);
            OffHand.shrink(1);
        }
        if (MainHand.getItem() == AxolotlTest.ALJAME_TEA.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.ALJAME_TEACUP.get()));
            player.addStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            MainHand.shrink(1);
        }
        if (MainHand.getItem() == Items.BREAD && OffHand.getItem() == AxolotlTest.FRIED_EGG.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.FRIED_EGG_BREAD.get()));
            player.addStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            MainHand.shrink(1);
            OffHand.shrink(1);
        }
        if (MainHand.getItem() == AxolotlTest.SPOON.get()) {
            player.addStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            player.addItemStackToInventory(new ItemStack(AxolotlTest.PASTA.get()));
        }
        return super.onBlockActivated(state, world, pos, player, hand, hit);
    }
}
