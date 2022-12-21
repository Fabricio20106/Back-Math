package com.sophicreeper.backmath.core.world.item.unused;

import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class AmaracamelBatterBagItem extends Item {
    public AmaracamelBatterBagItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        playerIn.addItemStackToInventory(new ItemStack(AxolotlTest.EMPTY_AMARACAMEL_BATTER_BAG.get()));
        playerIn.addItemStackToInventory(new ItemStack(AxolotlTest.AMARACAMEL_BATTER.get()));
        stack.shrink(1);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
