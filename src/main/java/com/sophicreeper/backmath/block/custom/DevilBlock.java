package com.sophicreeper.backmath.block.custom;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DevilBlock extends Block {
    public DevilBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livEntity = (LivingEntity) entity;
            livEntity.setSecondsOnFire(5);
        }
        super.stepOn(world, pos, entity);
    }
}
