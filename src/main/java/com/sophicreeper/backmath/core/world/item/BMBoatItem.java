package com.sophicreeper.backmath.core.world.item;

import com.sophicreeper.backmath.core.world.entity.misc.BMBoat;
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
    private static final Predicate<Entity> field_219989_a = EntityPredicates.NOT_SPECTATING.and(Entity::canBeCollidedWith);
    private final String woodType;

    public BMBoatItem(Properties properties, String woodType) {
        super(null, properties);
        this.woodType = woodType;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack heldItem = playerIn.getHeldItem(handIn);
        RayTraceResult fluidRayTrace = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.ANY);
        if (fluidRayTrace.getType() == RayTraceResult.Type.MISS) {
            return ActionResult.resultPass(heldItem);
        } else {
            Vector3d vector3d = playerIn.getLook(1.0F);
            List<Entity> list = worldIn.getEntitiesInAABBexcluding(playerIn, playerIn.getBoundingBox().expand(vector3d.scale(5.0D)).grow(1.0D), field_219989_a);
            if (!list.isEmpty()) {
                Vector3d vector3D1 = playerIn.getEyePosition(1.0F);

                for(Entity entity : list) {
                    AxisAlignedBB axisAlignedBB = entity.getBoundingBox().grow(entity.getCollisionBorderSize());
                    if (axisAlignedBB.contains(vector3D1)) {
                        return ActionResult.resultPass(heldItem);
                    }
                }
            }

            if (fluidRayTrace.getType() == RayTraceResult.Type.BLOCK) {
                BMBoat bmBoat = new BMBoat(worldIn, fluidRayTrace.getHitVec().x, fluidRayTrace.getHitVec().y, fluidRayTrace.getHitVec().z);
                bmBoat.setWoodType(woodType);
                bmBoat.rotationYaw = playerIn.rotationYaw;
                if (!worldIn.hasNoCollisions(bmBoat, bmBoat.getBoundingBox().grow(-0.1D))) {
                    return ActionResult.resultFail(heldItem);
                } else {
                    if (!worldIn.isRemote) {
                        worldIn.addEntity(bmBoat);
                        if (!playerIn.abilities.isCreativeMode) {
                            heldItem.shrink(1);
                        }
                    }

                    playerIn.addStat(Stats.ITEM_USED.get(this));
                    return ActionResult.func_233538_a_(heldItem, worldIn.isRemote());
                }
            } else {
                return ActionResult.resultPass(heldItem);
            }
        }
    }
}
