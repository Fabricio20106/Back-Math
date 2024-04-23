package com.sophicreeper.backmath.item.custom;

import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.DispenserTileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class AljamicGlassBottleItem extends Item {
    public AljamicGlassBottleItem(Properties properties) {
        super(properties);
        DispenserBlock.registerBehavior(this, new OptionalDispenseBehavior() {
            private final DefaultDispenseItemBehavior defaultBehaviour = new DefaultDispenseItemBehavior();

            private ItemStack takeLiquid(IBlockSource source, ItemStack empty, ItemStack filled) {
                empty.shrink(1);
                if (empty.isEmpty()) {
                    return filled.copy();
                } else {
                    if (source.<DispenserTileEntity>getEntity().addItem(filled.copy()) < 0) {
                        this.defaultBehaviour.dispense(source, filled.copy());
                    }

                    return empty;
                }
            }

            public ItemStack execute(IBlockSource source, ItemStack stack) {
                this.setSuccess(false);
                ServerWorld world = source.getLevel();
                BlockPos pos = source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING));
                if (world.getFluidState(pos).is(BMTags.Fluids.SLEEPISHWATER)) {
                    this.setSuccess(true);
                    return this.takeLiquid(source, stack, new ItemStack(AxolotlTest.SLEEPISHWATER_BOTTLE.get()));
                } else {
                    return super.execute(source, stack);
                }
            }
        });
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

                if (world.getFluidState(hitResultPos).is(BMTags.Fluids.SLEEPISHWATER)) {
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
