package com.sophicreeper.backmath.core.world.item;

import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class AljamicGlassBottleItem extends Item {
    public AljamicGlassBottleItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack heldItem = player.getItemInHand(hand);
        HitResult rayTraceResult = getPlayerPOVHitResult(world, player, ClipContext.Fluid.SOURCE_ONLY);
        if (rayTraceResult.getType() == HitResult.Type.BLOCK) {
            BlockPos rayTraceBlockPos = ((BlockHitResult) rayTraceResult).getBlockPos();
            if (!world.mayInteract(player, rayTraceBlockPos)) {
                return InteractionResultHolder.pass(heldItem);
            }

            /*if (world.getFluidState(rayTraceBlockPos) == BMFluids.SLEEPISHWATER.get().getDefaultState()) {
                world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
                return InteractionResultHolder.sidedSuccess(getBottleStack(heldItem, player), world.isClientSide());
            }*/
        }
        return super.use(world, player, hand);
    }

    protected ItemStack turnBottleIntoItem(ItemStack bottleStack, Player player, ItemStack stack) {
        player.awardStat(Stats.ITEM_USED.get(this));
        return ItemUtils.createFilledResult(bottleStack, player, stack);
    }

    protected ItemStack getBottleStack(ItemStack bottleStack, Player player) {
        ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);
        if (stack.getItem() == AxolotlTest.ALJAMIC_GLASS_BOTTLE.get()) {
            return new ItemStack(AxolotlTest.SLEEPISHWATER_BOTTLE.get());
        }
        return  new ItemStack(Items.AIR);
    }
}
