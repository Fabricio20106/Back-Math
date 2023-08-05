package com.sophicreeper.backmath.core.world.item.food;

import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TurtleFriedEggBagItem extends Item {
    public TurtleFriedEggBagItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack heldItem = player.getItemInHand(hand);
        player.addItem(new ItemStack(AxolotlTest.EMPTY_TURTLE_FRIED_EGG_BAG.get()));
        player.addItem(new ItemStack(AxolotlTest.TURTLE_FRIED_EGG.get()));
        heldItem.shrink(1);
        return super.use(world, player, hand);
    }
}
