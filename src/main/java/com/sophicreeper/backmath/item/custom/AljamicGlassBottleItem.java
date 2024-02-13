package com.sophicreeper.backmath.item.custom;

import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.util.BMTags;
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
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack heldItem = player.getHeldItem(hand);
        BlockRayTraceResult hitResult = rayTrace(world, player, RayTraceContext.FluidMode.SOURCE_ONLY);
        if (hitResult.getType() == RayTraceResult.Type.MISS) {
            return ActionResult.resultPass(heldItem);
        } else {
            if (hitResult.getType() == RayTraceResult.Type.BLOCK) {
                BlockPos hitResultPos = hitResult.getPos();
                if (!world.isBlockModifiable(player, hitResultPos)) {
                    return ActionResult.resultPass(heldItem);
                }

                if (world.getFluidState(hitResultPos).isTagged(BMTags.Fluids.SLEEPISHWATER)) {
                    world.playSound(player, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1, 1);
                    return ActionResult.func_233538_a_(turnBottleIntoItem(heldItem, player, new ItemStack(AxolotlTest.SLEEPISHWATER_BOTTLE.get())), world.isRemote());
                }
            }
            return super.onItemRightClick(world, player, hand);
        }
    }

    protected ItemStack turnBottleIntoItem(ItemStack bottleStack, PlayerEntity player, ItemStack stack) {
        player.addStat(Stats.ITEM_USED.get(this));
        return DrinkHelper.fill(bottleStack, player, stack);
    }
}
