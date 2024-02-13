package com.sophicreeper.backmath.item.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.EndPortalFrameBlock;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.EyeOfEnderEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.server.ServerWorld;

public class JantiquifiedPearlItem extends Item {
    public JantiquifiedPearlItem(Properties properties) {
        super(properties);
    }

    // Called when this item is used when targeting a block.
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getPos();
        BlockState state = world.getBlockState(pos);
        if (state.isIn(Blocks.END_PORTAL_FRAME) && !state.get(EndPortalFrameBlock.EYE)) {
            if (world.isRemote) {
                return ActionResultType.SUCCESS;
            } else {
                BlockState filledPortalFrame = state.with(EndPortalFrameBlock.EYE, Boolean.TRUE);
                Block.nudgeEntitiesWithNewState(state, filledPortalFrame, world, pos);
                world.setBlockState(pos, filledPortalFrame, 2);
                world.updateComparatorOutputLevel(pos, Blocks.END_PORTAL_FRAME);
                context.getItem().shrink(1);
                world.playEvent(1503, pos, 0);
                BlockPattern.PatternHelper endPortalPatternHelper = EndPortalFrameBlock.getOrCreatePortalShape().match(world, pos);
                if (endPortalPatternHelper != null) {
                    BlockPos frontTopLeftPos = endPortalPatternHelper.getFrontTopLeft().add(-3, 0, -3);

                    for(int i = 0; i < 3; ++i) {
                        for(int j = 0; j < 3; ++j) {
                            world.setBlockState(frontTopLeftPos.add(i, 0, j), Blocks.END_PORTAL.getDefaultState(), 2);
                        }
                    }

                    world.playBroadcastSound(1038, frontTopLeftPos.add(1, 0, 1), 0);
                }

                return ActionResultType.CONSUME;
            }
        } else {
            return ActionResultType.PASS;
        }
    }

    // Called to trigger the item's "innate" right click behavior. To handle when this item is used on a block, see "onItemUse".
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack handStack = player.getHeldItem(hand);
        BlockRayTraceResult hitResult = rayTrace(world, player, RayTraceContext.FluidMode.NONE);
        if (hitResult.getType() == RayTraceResult.Type.BLOCK && world.getBlockState(hitResult.getPos()).isIn(Blocks.END_PORTAL_FRAME)) {
            return ActionResult.resultPass(handStack);
        } else {
            player.setActiveHand(hand);
            if (world instanceof ServerWorld) {
                BlockPos strongholdPos = ((ServerWorld) world).getChunkProvider().getChunkGenerator().func_235956_a_((ServerWorld) world, Structure.STRONGHOLD, player.getPosition(), 100, false);
                if (strongholdPos != null) {
                    EyeOfEnderEntity enderEye = new EyeOfEnderEntity(world, player.getPosX(), player.getPosYHeight(0.5D), player.getPosZ());
                    enderEye.func_213863_b(handStack);
                    enderEye.moveTowards(strongholdPos);
                    world.addEntity(enderEye);
                    if (player instanceof ServerPlayerEntity) {
                        CriteriaTriggers.USED_ENDER_EYE.trigger((ServerPlayerEntity) player, strongholdPos);
                    }

                    world.playSound(null, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.ENTITY_ENDER_EYE_LAUNCH, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
                    world.playEvent(null, 1003, player.getPosition(), 0);
                    if (!player.abilities.isCreativeMode) {
                        handStack.shrink(1);
                    }

                    player.addStat(Stats.ITEM_USED.get(this));
                    player.swing(hand, true);
                    return ActionResult.resultSuccess(handStack);
                }
            }

            return ActionResult.resultConsume(handStack);
        }
    }
}
