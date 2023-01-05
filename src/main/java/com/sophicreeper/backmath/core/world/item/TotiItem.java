package com.sophicreeper.backmath.core.world.item;

import com.sophicreeper.backmath.core.world.level.block.BMBlocks;
import com.sophicreeper.backmath.core.util.BMKeys;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class TotiItem extends BlockItem {
    public TotiItem(Properties properties) {
        super(BMBlocks.TOTI.get(), properties);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent("messages.backmath.can_be_placed"));
        super.addInformation(stack, world, tooltip, flag);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack heldItem = player.getHeldItem(hand);
        if (!world.isRemote && BMKeys.isHoldingShift()) {
            player.addItemStackToInventory(new ItemStack(AxolotlTest.TITO.get()));
            heldItem.shrink(1);
        }
        return super.onItemRightClick(world, player, hand);
    }
}
