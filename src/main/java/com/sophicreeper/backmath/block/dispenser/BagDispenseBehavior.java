package com.sophicreeper.backmath.block.dispenser;

import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;

public class BagDispenseBehavior extends DefaultDispenseItemBehavior {
    @Override
    protected ItemStack execute(IBlockSource source, ItemStack stack) {
        Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
        IPosition iPos = DispenserBlock.getDispensePosition(source);
        dispenseBagContents(stack, source, direction, iPos);
        stack.shrink(1);
        return stack;
    }

    private void dispenseBagContents(ItemStack stack, IBlockSource source, Direction direction, IPosition iPos) {
        if (stack.getItem() == AxolotlTest.AMARACAMEL_BATTER_BAG.get()) {
            spawnItem(source.getLevel(), new ItemStack(AxolotlTest.EMPTY_AMARACAMEL_BATTER_BAG.get()), 6, direction, iPos);
            spawnItem(source.getLevel(), new ItemStack(AxolotlTest.AMARACAMEL_BATTER.get()), 6, direction, iPos);
        }
        if (stack.getItem() == AxolotlTest.FRIED_EGG_BAG.get()) {
            spawnItem(source.getLevel(), new ItemStack(AxolotlTest.EMPTY_FRIED_EGG_BAG.get()), 6, direction, iPos);
            spawnItem(source.getLevel(), new ItemStack(AxolotlTest.FRIED_EGG.get()), 6, direction, iPos);
        }
        if (stack.getItem() == AxolotlTest.TURTLE_FRIED_EGG_BAG.get()) {
            spawnItem(source.getLevel(), new ItemStack(AxolotlTest.EMPTY_TURTLE_FRIED_EGG_BAG.get()), 6, direction, iPos);
            spawnItem(source.getLevel(), new ItemStack(AxolotlTest.TURTLE_FRIED_EGG.get()), 6, direction, iPos);
        }
        if (stack.getItem() == AxolotlTest.ENDER_DRAGON_FRIED_EGG_BAG.get()) {
            spawnItem(source.getLevel(), new ItemStack(AxolotlTest.EMPTY_ENDER_DRAGON_FRIED_EGG_BAG.get()), 6, direction, iPos);
            spawnItem(source.getLevel(), new ItemStack(AxolotlTest.ENDER_DRAGON_FRIED_EGG.get()), 6, direction, iPos);
        }
        if (stack.getItem() == AxolotlTest.LAGUSTA_BAG.get()) {
            spawnItem(source.getLevel(), new ItemStack(AxolotlTest.EMPTY_LAGUSTA_BAG.get()), 6, direction, iPos);
            spawnItem(source.getLevel(), new ItemStack(AxolotlTest.LAGUSTA.get()), 6, direction, iPos);
        }
        if (stack.getItem() == AxolotlTest.ALJAME_TEA_BOX.get()) {
            spawnItem(source.getLevel(), new ItemStack(AxolotlTest.ALJAME_TEA.get(), 4), 6, direction, iPos);
        }
        if (stack.getItem() == AxolotlTest.QUEEN_LUCY_BATTLE_PACK.get()) {
            spawnItem(source.getLevel(), new ItemStack(AxolotlTest.QUEEN_LUCY_SPAWN_EGG.get()), 6, direction, iPos);
            spawnItem(source.getLevel(), new ItemStack(AxolotlTest.QUEEN_LUCY_BATTLE_INFO.get()), 6, direction, iPos);
        }
        if (stack.getItem() == AxolotlTest.BOOT_PACK.get()) {
            spawnItem(source.getLevel(), new ItemStack(AxolotlTest.EMPTY_BOOT_PACK.get()), 6, direction, iPos);
            spawnItem(source.getLevel(), new ItemStack(BMTags.Items.ARMORS_BOOTS.getRandomElement(source.getLevel().random)), 6, direction, iPos);
        }
    }
}
