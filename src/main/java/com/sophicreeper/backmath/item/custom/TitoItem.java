package com.sophicreeper.backmath.item.custom;

import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.util.BMKeys;
import com.sophicreeper.backmath.item.AxolotlTest;
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

public class TitoItem extends BlockItem {
    public TitoItem(Properties properties) {
        super(BMBlocks.TITO.get(), properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent("messages.backmath.can_be_placed"));
        super.appendHoverText(stack, world, tooltip, flag);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack heldItem = player.getItemInHand(hand);
        if (!world.isClientSide && BMKeys.isHoldingShift()) {
            player.addItem(new ItemStack(AxolotlTest.TOTI.get()));
            heldItem.shrink(1);
        }
        return super.use(world, player, hand);
    }
}
