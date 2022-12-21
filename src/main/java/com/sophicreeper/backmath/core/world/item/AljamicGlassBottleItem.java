package com.sophicreeper.backmath.core.world.item;

import com.sophicreeper.backmath.core.world.level.material.BMFluids;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack heldItem = playerIn.getHeldItem(handIn);
        RayTraceResult rayTraceResult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.SOURCE_ONLY);
        if (rayTraceResult.getType() == RayTraceResult.Type.BLOCK) {
            BlockPos rayTraceBlockPos = ((BlockRayTraceResult) rayTraceResult).getPos();
            if (!worldIn.isBlockModifiable(playerIn, rayTraceBlockPos)) {
                return ActionResult.resultPass(heldItem);
            }

            if (worldIn.getFluidState(rayTraceBlockPos) == BMFluids.SLEEPISHWATER.get().getDefaultState()) {
                worldIn.playSound(playerIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                return ActionResult.func_233538_a_(getBottleStack(heldItem, playerIn), worldIn.isRemote());
            }
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    protected ItemStack turnBottleIntoItem(ItemStack bottleStack, PlayerEntity player, ItemStack stack) {
        player.addStat(Stats.ITEM_USED.get(this));
        return DrinkHelper.fill(bottleStack, player, stack);
    }

    protected ItemStack getBottleStack(ItemStack bottleStack, PlayerEntity player) {
        ItemStack stack = player.getHeldItem(Hand.MAIN_HAND);
        if (stack.getItem() == AxolotlTest.ALJAMIC_GLASS_BOTTLE.get()) {
            return new ItemStack(AxolotlTest.SLEEPISHWATER_BOTTLE.get());
        }
        return  new ItemStack(Items.AIR);
    }
}
