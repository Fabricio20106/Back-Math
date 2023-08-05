package com.sophicreeper.backmath.core.world.item;

public class BMBoatItem /*extends BoatItem*/ {
    /*private static final Predicate<Entity> field_219989_a = EntityPredicates.NOT_SPECTATING.and(Entity::canBeCollidedWith);
    private final String woodType;

    public BMBoatItem(Properties properties, String woodType) {
        super(null, properties);
        this.woodType = woodType;
    }

    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack heldItem = player.getItemInHand(hand);
        HitResult fluidRayTrace = rayTrace(world, player, RayTraceContext.FluidMode.ANY);
        if (fluidRayTrace.getType() == RayTraceResult.Type.MISS) {
            return ActionResult.resultPass(heldItem);
        } else {
            Vector3d vector3D = player.getLook(1.0F);
            List<Entity> list = world.getEntitiesInAABBexcluding(player, player.getBoundingBox().expand(vector3D.scale(5.0D)).grow(1.0D), field_219989_a);
            if (!list.isEmpty()) {
                Vector3d vector3D1 = player.getEyePosition(1.0F);

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
    }*/
}
