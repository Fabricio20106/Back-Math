package com.sophicreeper.backmath.core.world.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class LagustaBagItem extends Item {
    public LagustaBagItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        playerIn.addItemStackToInventory(new ItemStack(AxolotlTest.EMPTY_LAGUSTA_BAG.get()));
        playerIn.addItemStackToInventory(new ItemStack(AxolotlTest.LAGUSTA.get()));
        stack.shrink(1);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
