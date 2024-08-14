package com.sophicreeper.backmath.item.custom;

import com.sophicreeper.backmath.dispenser.FillGlassBottleDispenseBehavior;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.util.tag.BMFluidTags;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class AljamicGlassBottleItem extends Item {
    public AljamicGlassBottleItem(Properties properties) {
        super(properties);
        DispenserBlock.registerBehavior(this, new FillGlassBottleDispenseBehavior());
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack heldItem = player.getItemInHand(hand);
        BlockRayTraceResult hitResult = getPlayerPOVHitResult(world, player, RayTraceContext.FluidMode.SOURCE_ONLY);
        if (hitResult.getType() == RayTraceResult.Type.MISS) {
            return ActionResult.pass(heldItem);
        } else {
            if (hitResult.getType() == RayTraceResult.Type.BLOCK) {
                BlockPos hitResultPos = hitResult.getBlockPos();
                if (!world.mayInteract(player, hitResultPos)) {
                    return ActionResult.pass(heldItem);
                }

                if (world.getFluidState(hitResultPos).is(BMFluidTags.SLEEPISHWATER)) {
                    world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_FILL, SoundCategory.NEUTRAL, 1, 1);
                    return ActionResult.sidedSuccess(turnBottleIntoItem(heldItem, player, new ItemStack(AxolotlTest.SLEEPISHWATER_BOTTLE.get())), world.isClientSide);
                }
            }
            return super.use(world, player, hand);
        }
    }

    protected ItemStack turnBottleIntoItem(ItemStack bottleStack, PlayerEntity player, ItemStack stack) {
        player.awardStat(Stats.ITEM_USED.get(this));
        return DrinkHelper.createFilledResult(bottleStack, player, stack);
    }
}
