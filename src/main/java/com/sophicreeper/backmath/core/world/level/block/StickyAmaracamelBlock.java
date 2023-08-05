package com.sophicreeper.backmath.core.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class StickyAmaracamelBlock extends HalfTransparentBlock {
    public StickyAmaracamelBlock(Properties properties) {
        super(properties);
    }

    public void fallOn(Level world, BlockState state,BlockPos pos, Entity entity, float distance) {
        if (entity.isSuppressingBounce()) {
            super.fallOn(world, state, pos, entity, distance);
        } else {
            entity.causeFallDamage(distance, 0, world.damageSources().fall());
        }
    }

    public void updateEntityAfterFallOn(BlockGetter reader, Entity entity) {
        if (entity.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(reader, entity);
        } else {
            this.bounceEntity(entity);
        }
    }

    private void bounceEntity(Entity entity) {
        Vec3 vector3D = entity.getDeltaMovement();
        if (vector3D.y < 0.0) {
            double yDeltaBonus = entity instanceof LivingEntity ? 1 : 0.8;
            entity.setDeltaMovement(vector3D.x, -vector3D.y * yDeltaBonus, vector3D.z);
        }
    }

    public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        double absOfDeltaYMov = Math.abs(entity.getDeltaMovement().y);
        if (absOfDeltaYMov < 0.1 && !entity.isSteppingCarefully()) {
            double d0 = 0.4 + absOfDeltaYMov * 0.2;
            entity.setDeltaMovement(entity.getDeltaMovement().multiply(d0, 1, d0));
        }

        super.stepOn(world, pos, state, entity);
    }
}
