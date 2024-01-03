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

    public void onFallenUpon(World world, BlockPos pos, Entity entity, float distance) {
        if (entity.isSuppressingBounce()) {
            super.onFallenUpon(world, pos, entity, distance);
        } else {
            entity.onLivingFall(distance, 0);
        }
    }

    public void onLanded(IBlockReader reader, Entity entity) {
        if (entity.isSuppressingBounce()) {
            super.onLanded(reader, entity);
        } else {
            this.bounceEntity(entity);
        }
    }

    private void bounceEntity(Entity entity) {
        Vector3d vector3D = entity.getMotion();
        if (vector3D.y < 0) {
            double d0 = entity instanceof LivingEntity ? 1 : 0.8;
            entity.setMotion(vector3D.x, -vector3D.y * d0, vector3D.z);
        }
    }

    public void onEntityWalk(World world, BlockPos pos, Entity entity) {
        double d0 = Math.abs(entity.getMotion().y);
        if (d0 < 0.1 && !entity.isSteppingCarefully()) {
            double d1 = 0.4 + d0 * 0.2;
            entity.setMotion(entity.getMotion().mul(d1, 1, d1));
        }

        super.onEntityWalk(world, pos, entity);
    }
}
