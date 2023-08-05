package com.sophicreeper.backmath.core.world.item.tool;

import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class KnifeItem extends TieredItem {
    public KnifeItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        ItemStack container = itemStack.copy();
        if (container.hurt(1, RandomSource.create(), null)) {
            return ItemStack.EMPTY;
        } else {
            return container;
        }
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        Level world = context.getLevel();
        BlockState state = world.getBlockState(pos);
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        if (state.getBlock() == Blocks.PUMPKIN) {
            Block.popResource(world, pos, new ItemStack(AxolotlTest.PUMPKIN_SLICE.get(), 9));
            world.destroyBlock(pos, false, player);
            stack.hurtAndBreak(1, player, livEntity -> livEntity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        }
        if (state.getBlock() == Blocks.CARVED_PUMPKIN) {
            Block.popResource(world, pos, new ItemStack(AxolotlTest.PUMPKIN_SLICE.get(), 8));
            world.destroyBlock(pos, false, player);
            stack.hurtAndBreak(1, player, livEntity -> livEntity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        }
        if (state.getBlock() == Blocks.JACK_O_LANTERN) {
            Block.popResource(world, pos, new ItemStack(AxolotlTest.PUMPKIN_SLICE.get(), 8));
            Block.popResource(world, pos, new ItemStack(Items.TORCH));
            world.destroyBlock(pos, false, player);
            stack.hurtAndBreak(1, player, livEntity -> livEntity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        }
        if (state.getBlock() == Blocks.MELON) {
            Block.popResource(world, pos, new ItemStack(Items.MELON_SLICE, 9));
            world.destroyBlock(pos, false, player);
            stack.hurtAndBreak(1, player, livEntity -> livEntity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        }
        if (state.getBlock() == Blocks.HAY_BLOCK) {
            Block.popResource(world, pos, new ItemStack(Items.WHEAT, 9));
            world.destroyBlock(pos, false, player);
            stack.hurtAndBreak(1, player, livEntity -> livEntity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        }
        return super.useOn(context);
    }
}
