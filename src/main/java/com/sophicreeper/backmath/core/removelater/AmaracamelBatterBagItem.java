package com.sophicreeper.backmath.core.removelater;

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
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack heldItem = player.getHeldItem(hand);
        player.addItemStackToInventory(new ItemStack(AxolotlTest.EMPTY_AMARACAMEL_BATTER_BAG.get()));
        player.addItemStackToInventory(new ItemStack(AxolotlTest.AMARACAMEL_BATTER.get()));
        heldItem.shrink(1);
        return super.onItemRightClick(world, player, hand);
    }
}
