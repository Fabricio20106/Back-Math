package com.sophicreeper.backmath.core.world.item;

import com.sophicreeper.backmath.core.util.BMKeys;
import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class TitoItem extends BlockItem {
    public TitoItem(Properties properties) {
        super(BMBlocks.TITO.get(), properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("messages.backmath.can_be_placed"));
        super.appendHoverText(stack, world, tooltip, flag);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack heldItem = player.getItemInHand(hand);
        if (!world.isClientSide) {
            player.addItem(new ItemStack(AxolotlTest.TOTI.get()));
            heldItem.shrink(1);
        }
        return super.use(world, player, hand);
    }
}
