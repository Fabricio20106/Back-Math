package com.sophicreeper.backmath.core.world.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class QueenSophieBattlePackItem extends Item {
    public QueenSophieBattlePackItem() {
        super(new Properties().fireResistant());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack heldItem = player.getItemInHand(hand);
        //player.addItem(new ItemStack(AxolotlTest.QUEEN_SOPHIE_SPAWN_EGG.get()));
        player.addItem(new ItemStack(AxolotlTest.QUEEN_SOPHIE_BATTLE_INFO.get()));
        heldItem.shrink(1);
        return super.use(world, player, hand);
    }
}
