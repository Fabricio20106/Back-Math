package com.sophicreeper.backmath.item.custom;

import com.sophicreeper.backmath.block.dispenser.vanilla.DispenseBMBoatBehavior;
import com.sophicreeper.backmath.entity.custom.BMBoat;
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
    private static final Predicate<Entity> CAN_COLLIDE_WITH_ENTITY = EntityPredicates.NOT_SPECTATING.and(Entity::canBeCollidedWith);
    private final String woodType;

    public BMBoatItem(Properties properties, String woodType) {
        super(null, properties);
        this.woodType = woodType;
        DispenserBlock.registerDispenseBehavior(this, new DispenseBMBoatBehavior(woodType));
    }

    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack heldItem = player.getHeldItem(hand);
        RayTraceResult fluidRayTrace = rayTrace(world, player, RayTraceContext.FluidMode.ANY);
        if (fluidRayTrace.getType() == RayTraceResult.Type.MISS) {
            return ActionResult.resultPass(heldItem);
        } else {
            Vector3d vec3D = player.getLook(1);
            List<Entity> list = world.getEntitiesInAABBexcluding(player, player.getBoundingBox().expand(vec3D.scale(5)).grow(1), CAN_COLLIDE_WITH_ENTITY);
            if (!list.isEmpty()) {
                Vector3d vector3D1 = player.getEyePosition(1);

                for(Entity entity : list) {
                    AxisAlignedBB axisAlignedBB = entity.getBoundingBox().grow(entity.getCollisionBorderSize());
                    if (axisAlignedBB.contains(vector3D1)) {
                        return ActionResult.resultPass(heldItem);
                    }
                }
            }

            if (fluidRayTrace.getType() == RayTraceResult.Type.BLOCK) {
                BMBoat backMathBoat = new BMBoat(world, fluidRayTrace.getHitVec().x, fluidRayTrace.getHitVec().y, fluidRayTrace.getHitVec().z);
                backMathBoat.setWoodType(woodType);
                backMathBoat.rotationYaw = player.rotationYaw;
                if (!world.hasNoCollisions(backMathBoat, backMathBoat.getBoundingBox().grow(-0.1D))) {
                    return ActionResult.resultFail(heldItem);
                } else {
                    if (!world.isRemote) {
                        world.addEntity(backMathBoat);
                        if (!player.abilities.isCreativeMode) {
                            heldItem.shrink(1);
                        }
                    }

                    player.addStat(Stats.ITEM_USED.get(this));
                    return ActionResult.func_233538_a_(heldItem, world.isRemote());
                }
            } else {
                return ActionResult.resultPass(heldItem);
            }
        }
    }
}
