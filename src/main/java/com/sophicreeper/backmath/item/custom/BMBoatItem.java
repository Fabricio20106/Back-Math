package com.sophicreeper.backmath.item.custom;

import com.sophicreeper.backmath.dispenser.vanilla.DispenseBMBoatBehavior;
import com.sophicreeper.backmath.entity.custom.misc.BMBoatEntity;
import com.sophicreeper.backmath.util.BMUtils;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BoatItem;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Predicate;

public class BMBoatItem extends BoatItem {
    private static final Predicate<Entity> SPECTATORS_PREDICATE = EntityPredicates.NO_SPECTATORS.and(Entity::canBeCollidedWith);
    private final String woodType;

    public BMBoatItem(Properties properties, String woodType) {
        super(null, properties);
        this.woodType = woodType;
        DispenserBlock.registerBehavior(this, new DispenseBMBoatBehavior(woodType));
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack handStack = player.getItemInHand(hand);
        RayTraceResult hitResult = getPlayerPOVHitResult(world, player, RayTraceContext.FluidMode.ANY);
        if (hitResult.getType() == RayTraceResult.Type.MISS) {
            return ActionResult.pass(handStack);
        } else {
            Vector3d viewVector = player.getViewVector(1);
            List<Entity> entitiesList = world.getEntities(player, player.getBoundingBox().expandTowards(viewVector.scale(5)).inflate(1), SPECTATORS_PREDICATE);
            if (!entitiesList.isEmpty()) {
                Vector3d eyePosition = player.getEyePosition(1);

                for (Entity entity : entitiesList) {
                    AxisAlignedBB axisAlignedBB = entity.getBoundingBox().inflate(entity.getPickRadius());
                    if (axisAlignedBB.contains(eyePosition)) return ActionResult.pass(handStack);
                }
            }

            if (hitResult.getType() == RayTraceResult.Type.BLOCK) {
                BMBoatEntity boatEntity = new BMBoatEntity(world, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z);
                boatEntity.setWoodType(BMUtils.getBoatType(handStack, this.woodType));
                boatEntity.yRot = player.yRot;
                if (!world.noCollision(boatEntity, boatEntity.getBoundingBox().inflate(-0.1D))) {
                    return ActionResult.fail(handStack);
                } else {
                    if (!world.isClientSide) {
                        world.addFreshEntity(boatEntity);
                        if (!player.abilities.instabuild) handStack.shrink(1);
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                    return ActionResult.sidedSuccess(handStack, world.isClientSide);
                }
            } else {
                return ActionResult.pass(handStack);
            }
        }
    }
}
