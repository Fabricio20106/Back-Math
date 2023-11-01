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
            double lvt_3_1_ = entity instanceof LivingEntity ? 1 : 0.8;
            entity.setMotion(vector3D.x, -vector3D.y * lvt_3_1_, vector3D.z);
        }
    }

    public void onEntityWalk(World world, BlockPos pos, Entity entity) {
        double lvt_4_1_ = Math.abs(entity.getMotion().y);
        if (lvt_4_1_ < 0.1 && !entity.isSteppingCarefully()) {
            double lvt_6_1_ = 0.4 + lvt_4_1_ * 0.2;
            entity.setMotion(entity.getMotion().mul(lvt_6_1_, 1, lvt_6_1_));
        }

        super.onEntityWalk(world, pos, entity);
    }
}
