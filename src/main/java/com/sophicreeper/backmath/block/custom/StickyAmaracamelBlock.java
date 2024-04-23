package com.sophicreeper.backmath.block.custom;

import net.minecraft.block.BreakableBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class StickyAmaracamelBlock extends BreakableBlock {
    public StickyAmaracamelBlock(Properties properties) {
        super(properties);
    }

    public void fallOn(World world, BlockPos pos, Entity entity, float distance) {
        if (entity.isSuppressingBounce()) {
            super.fallOn(world, pos, entity, distance);
        } else {
            entity.causeFallDamage(distance, 0);
        }
    }

    public void updateEntityAfterFallOn(IBlockReader reader, Entity entity) {
        if (entity.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(reader, entity);
        } else {
            this.bounceEntity(entity);
        }
    }

    private void bounceEntity(Entity entity) {
        Vector3d vector3D = entity.getDeltaMovement();
        if (vector3D.y < 0) {
            double d0 = entity instanceof LivingEntity ? 1 : 0.8;
            entity.setDeltaMovement(vector3D.x, -vector3D.y * d0, vector3D.z);
        }
    }

    public void stepOn(World world, BlockPos pos, Entity entity) {
        double d0 = Math.abs(entity.getDeltaMovement().y);
        if (d0 < 0.1 && !entity.isSteppingCarefully()) {
            double d1 = 0.4 + d0 * 0.2;
            entity.setDeltaMovement(entity.getDeltaMovement().multiply(d1, 1, d1));
        }

        super.stepOn(world, pos, entity);
    }
}
