package com.sophicreeper.backmath.core.world.level.block.machine;

import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class MealCookerBlock extends HorizontalDirectionalBlock {
    public static final VoxelShape SHAPE = Stream.of(
            Block.box(3, 23, 3, 13, 23, 13),
            Block.box(3, 17, 13, 13, 24, 14),
            Block.box(3, 17, 2, 13, 24, 3),
            Block.box(13, 17, 3, 14, 24, 13),
            Block.box(2, 17, 3, 3, 24, 13),
            Block.box(3, 16, 3, 13, 17, 13),
            Block.box(0, 0, 0, 16, 16, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public MealCookerBlock() {
        super(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0F, 6.0F));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack MainHand = player.getItemInHand(InteractionHand.MAIN_HAND);
        ItemStack OffHand = player.getItemInHand(InteractionHand.OFF_HAND);

        if (MainHand.getItem() == AxolotlTest.HOT_SOPHIE.get() && OffHand.getItem() == AxolotlTest.COLD_FABRICIO.get()) {
            player.addItem(new ItemStack(AxolotlTest.HOT_SOPHIE_COLD_FABRICIO_MEAL.get()));
            //player.awardStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            MainHand.shrink(1);
            OffHand.shrink(1);
        }
        if (MainHand.getItem() == AxolotlTest.FRIED_SOPHIE.get() && OffHand.getItem() == AxolotlTest.FRIED_EGG.get()) {
            player.addItem(new ItemStack(AxolotlTest.FRIED_SOPHIE_FRIED_EGG_MEAL.get()));
            //player.awardStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            MainHand.shrink(1);
            OffHand.shrink(1);
        }
        if (MainHand.getItem() == AxolotlTest.COOKED_LUCIA.get() && OffHand.getItem() == AxolotlTest.FRIED_EGG.get()) {
            player.addItem(new ItemStack(AxolotlTest.COOKED_LUCIA_FRIED_EGG_MEAL.get()));
            //player.awardStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            MainHand.shrink(1);
            OffHand.shrink(1);
        }
        if (MainHand.getItem() == AxolotlTest.TOASTED_FABRICIO.get() && OffHand.getItem() == AxolotlTest.FRIED_EGG.get()) {
            player.addItem(new ItemStack(AxolotlTest.TOASTED_FABRICIO_FRIED_EGG_MEAL.get()));
            //player.awardStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            MainHand.shrink(1);
            OffHand.shrink(1);
        }
        if (MainHand.getItem() == AxolotlTest.ALJAME_TEA.get()) {
            player.addItem(new ItemStack(AxolotlTest.ALJAME_TEACUP.get()));
            //player.awardStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            MainHand.shrink(1);
        }
        if (MainHand.getItem() == Items.BREAD && OffHand.getItem() == AxolotlTest.FRIED_EGG.get()) {
            player.addItem(new ItemStack(AxolotlTest.FRIED_EGG_BREAD.get()));
            //player.awardStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            MainHand.shrink(1);
            OffHand.shrink(1);
        }
        if (MainHand.getItem() == AxolotlTest.SPOON.get()) {
            //player.awardStat(BMStats.INTERACT_WITH_MEAL_COOKER);
            player.addItem(new ItemStack(AxolotlTest.PASTA.get()));
        }
        return super.use(state, world, pos, player, hand, hit);
    }
}
