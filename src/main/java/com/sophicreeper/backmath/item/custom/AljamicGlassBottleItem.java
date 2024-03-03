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
        DispenserBlock.registerDispenseBehavior(this, new OptionalDispenseBehavior() {
            private final DefaultDispenseItemBehavior defaultBehaviour = new DefaultDispenseItemBehavior();

            private ItemStack glassBottleFill(IBlockSource source, ItemStack empty, ItemStack filled) {
                empty.shrink(1);
                if (empty.isEmpty()) {
                    return filled.copy();
                } else {
                    if (source.<DispenserTileEntity>getBlockTileEntity().addItemStack(filled.copy()) < 0) {
                        this.defaultBehaviour.dispense(source, filled.copy());
                    }

                    return empty;
                }
            }

            public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
                this.setSuccessful(false);
                ServerWorld world = source.getWorld();
                BlockPos pos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
                if (world.getFluidState(pos).isTagged(BMTags.Fluids.SLEEPISHWATER)) {
                    this.setSuccessful(true);
                    return this.glassBottleFill(source, stack, new ItemStack(AxolotlTest.SLEEPISHWATER_BOTTLE.get()));
                } else {
                    return super.dispenseStack(source, stack);
                }
            }
        });
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
