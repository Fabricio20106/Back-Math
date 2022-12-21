package com.sophicreeper.backmath.core.world.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class QueenSophieBattlePackItem extends Item {
    public QueenSophieBattlePackItem() {
        super(new Properties().isImmuneToFire().group(SophiesCursedFoods.COMIDA));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        playerIn.addItemStackToInventory(new ItemStack(AxolotlTest.QUEEN_SOPHIE_SPAWN_EGG.get()));
        playerIn.addItemStackToInventory(new ItemStack(AxolotlTest.QUEEN_SOPHIE_BATTLE_INFO.get()));
        stack.shrink(1);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
