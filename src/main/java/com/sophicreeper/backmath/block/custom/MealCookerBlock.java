package com.sophicreeper.backmath.block.custom;

import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.misc.BMStats;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.stream.Stream;

public class MealCookerBlock extends HorizontalBlock {
    public static final VoxelShape SHAPE = Stream.of(
            Block.makeCuboidShape(3, 23, 3, 13, 23, 13),
            Block.makeCuboidShape(3, 17, 13, 13, 24, 14),
            Block.makeCuboidShape(3, 17, 2, 13, 24, 3),
            Block.makeCuboidShape(13, 17, 3, 14, 24, 13),
            Block.makeCuboidShape(2, 17, 3, 3, 24, 13),
            Block.makeCuboidShape(3, 16, 3, 13, 17, 13),
            Block.makeCuboidShape(0, 0, 0, 16, 16, 16)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    public MealCookerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, @Nonnull PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        ItemStack mainHand = player.getHeldItem(Hand.MAIN_HAND);
        ItemStack offHand = player.getHeldItem(Hand.OFF_HAND);

        if (mainHand.getItem() == AxolotlTest.HOT_SOPHIE.get() && offHand.getItem() == AxolotlTest.COLD_FABRICIO.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.HOT_SOPHIE_COLD_FABRICIO_MEAL.get()));
            player.addStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            mainHand.shrink(1);
            offHand.shrink(1);
            return ActionResultType.SUCCESS;
        }
        if (mainHand.getItem() == AxolotlTest.FRIED_SOPHIE.get() && offHand.getItem() == AxolotlTest.FRIED_EGG.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.FRIED_SOPHIE_FRIED_EGG_MEAL.get()));
            player.addStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            mainHand.shrink(1);
            offHand.shrink(1);
            return ActionResultType.SUCCESS;
        }
        if (mainHand.getItem() == AxolotlTest.COOKED_LUCIA.get() && offHand.getItem() == AxolotlTest.FRIED_EGG.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.COOKED_LUCIA_FRIED_EGG_MEAL.get()));
            player.addStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            mainHand.shrink(1);
            offHand.shrink(1);
            return ActionResultType.SUCCESS;
        }
        if (mainHand.getItem() == AxolotlTest.TOASTED_FABRICIO.get() && offHand.getItem() == AxolotlTest.FRIED_EGG.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.TOASTED_FABRICIO_FRIED_EGG_MEAL.get()));
            player.addStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            mainHand.shrink(1);
            offHand.shrink(1);
            return ActionResultType.SUCCESS;
        }
        if (mainHand.getItem() == AxolotlTest.ALJAME_TEA.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.ALJAME_TEACUP.get()));
            player.addStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            mainHand.shrink(1);
            return ActionResultType.SUCCESS;
        }
        if (mainHand.getItem() == Items.BREAD && offHand.getItem() == AxolotlTest.FRIED_EGG.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.FRIED_EGG_BREAD.get()));
            player.addStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            mainHand.shrink(1);
            offHand.shrink(1);
            return ActionResultType.SUCCESS;
        }
        if (mainHand.getItem() == Items.BREAD && offHand.getItem() == AxolotlTest.TURTLE_FRIED_EGG.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.TURTLE_FRIED_EGG_BREAD.get()));
            player.addStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            mainHand.shrink(1);
            offHand.shrink(1);
            return ActionResultType.SUCCESS;
        }
        if (mainHand.getItem() == Items.BREAD && offHand.getItem() == AxolotlTest.ENDER_DRAGON_FRIED_EGG.get()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.ENDER_DRAGON_FRIED_EGG_BREAD.get()));
            player.addStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            mainHand.shrink(1);
            offHand.shrink(1);
            return ActionResultType.SUCCESS;
        }
        if (mainHand.getItem() == AxolotlTest.ANGELIC_SPOON.get()) {
            player.addStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            addPasta(mainHand, new ItemStack(AxolotlTest.PASTA.get()), player, true);
            mainHand.damageItem(1, player, (player1) -> player1.sendBreakAnimation(Hand.MAIN_HAND));
            return ActionResultType.SUCCESS;
        }
        return super.onBlockActivated(state, world, pos, player, hand, hit);
    }

    private static void addPasta(ItemStack spoon, ItemStack pasta, @Nonnull PlayerEntity player, boolean preventDuplicates) {
        boolean isInCreative = player.abilities.isCreativeMode;
        if (preventDuplicates && isInCreative) {
            if (!player.inventory.hasItemStack(pasta)) player.inventory.addItemStackToInventory(pasta);
        } else {
            if (!isInCreative) spoon.damageItem(1, player, (player1) -> player.sendBreakAnimation(player.getActiveHand()));
            if (spoon.isEmpty()) {
            } else {
                if (!player.inventory.addItemStackToInventory(pasta)) player.dropItem(pasta, false);
            }
        }
    }
}
