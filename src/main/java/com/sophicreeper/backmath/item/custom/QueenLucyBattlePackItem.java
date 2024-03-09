package com.sophicreeper.backmath.item.custom;

import com.sophicreeper.backmath.block.dispenser.BagDispenseBehavior;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.item.tab.SophiesCursedFoods;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class QueenLucyBattlePackItem extends Item {
    public QueenLucyBattlePackItem() {
        super(new Properties().isImmuneToFire().group(SophiesCursedFoods.TAB));
        DispenserBlock.registerDispenseBehavior(this, new BagDispenseBehavior());
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack heldItem = player.getHeldItem(hand);
        player.addItemStackToInventory(new ItemStack(AxolotlTest.QUEEN_LUCY_SPAWN_EGG.get()));
        player.addItemStackToInventory(new ItemStack(AxolotlTest.QUEEN_LUCY_BATTLE_INFO.get()));
        heldItem.shrink(1);
        return super.onItemRightClick(world, player, hand);
    }
}
