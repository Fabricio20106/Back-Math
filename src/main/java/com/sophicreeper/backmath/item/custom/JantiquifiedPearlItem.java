package com.sophicreeper.backmath.item.custom;

import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.*;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.OptionalDispenseBehavior;
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
        DispenserBlock.registerBehavior(this, new OptionalDispenseBehavior() {
            @Override
            protected ItemStack execute(IBlockSource source, ItemStack stack) {
                BlockPos pos = source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING));
                BlockPos strongholdPos = source.getLevel().getChunkSource().getGenerator().findNearestMapFeature(source.getLevel(), Structure.STRONGHOLD, source.getPos(), 100, false);
                if (strongholdPos != null) {
                    EyeOfEnderEntity enderEye = new EyeOfEnderEntity(source.getLevel(), pos.getX(), pos.getY(), pos.getZ());
                    enderEye.setItem(new ItemStack(AxolotlTest.JANTIQUIFIED_PEARL.get()));
                    enderEye.signalTo(strongholdPos);
                    source.getLevel().addFreshEntity(enderEye);
                    source.getLevel().playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENDER_EYE_LAUNCH, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
                    source.getLevel().levelEvent(null, 1003, source.getPos(), 0);
                    stack.shrink(1);
                    setSuccess(true);
                }
                return stack;
            }
        });
    }

    // Called when this item is used when targeting a block.
    public ActionResultType useOn(ItemUseContext context) {
        World world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = world.getBlockState(pos);
        if (state.is(Blocks.END_PORTAL_FRAME) && !state.getValue(EndPortalFrameBlock.HAS_EYE)) {
            if (world.isClientSide) {
                return ActionResultType.SUCCESS;
            } else {
                BlockState filledPortalFrame = state.setValue(EndPortalFrameBlock.HAS_EYE, true);
                Block.pushEntitiesUp(state, filledPortalFrame, world, pos);
                world.setBlock(pos, filledPortalFrame, 2);
                world.updateNeighbourForOutputSignal(pos, Blocks.END_PORTAL_FRAME);
                context.getItemInHand().shrink(1);
                world.levelEvent(1503, pos, 0);
                BlockPattern.PatternHelper endPortalPatternHelper = EndPortalFrameBlock.getOrCreatePortalShape().find(world, pos);
                if (endPortalPatternHelper != null) {
                    BlockPos frontTopLeftPos = endPortalPatternHelper.getFrontTopLeft().offset(-3, 0, -3);

                    for(int i = 0; i < 3; ++i) {
                        for(int j = 0; j < 3; ++j) {
                            world.setBlock(frontTopLeftPos.offset(i, 0, j), Blocks.END_PORTAL.defaultBlockState(), 2);
                        }
                    }

                    world.globalLevelEvent(1038, frontTopLeftPos.offset(1, 0, 1), 0);
                }

                return ActionResultType.CONSUME;
            }
        } else {
            return ActionResultType.PASS;
        }
    }

    // Called to trigger the item's "innate" right-click behavior. To handle when this item is used on a block, see "onItemUse".
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack handStack = player.getItemInHand(hand);
        BlockRayTraceResult hitResult = getPlayerPOVHitResult(world, player, RayTraceContext.FluidMode.NONE);
        if (hitResult.getType() == RayTraceResult.Type.BLOCK && world.getBlockState(hitResult.getBlockPos()).is(Blocks.END_PORTAL_FRAME)) {
            return ActionResult.pass(handStack);
        } else {
            player.startUsingItem(hand);
            if (world instanceof ServerWorld) {
                BlockPos strongholdPos = ((ServerWorld) world).getChunkSource().getGenerator().findNearestMapFeature((ServerWorld) world, Structure.STRONGHOLD, player.blockPosition(), 100, false);
                if (strongholdPos != null) {
                    EyeOfEnderEntity enderEye = new EyeOfEnderEntity(world, player.getX(), player.getY(0.5D), player.getZ());
                    enderEye.setItem(handStack);
                    enderEye.signalTo(strongholdPos);
                    world.addFreshEntity(enderEye);
                    if (player instanceof ServerPlayerEntity) {
                        CriteriaTriggers.USED_ENDER_EYE.trigger((ServerPlayerEntity) player, strongholdPos);
                    }

                    world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDER_EYE_LAUNCH, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
                    world.levelEvent(null, 1003, player.blockPosition(), 0);
                    if (!player.abilities.instabuild) {
                        handStack.shrink(1);
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                    player.swing(hand, true);
                    return ActionResult.success(handStack);
                }
            }

            return ActionResult.consume(handStack);
        }
    }
}
