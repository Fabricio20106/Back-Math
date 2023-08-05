package com.sophicreeper.backmath.core.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class PoisonRoseBlock extends FlowerBlock {
    public PoisonRoseBlock(MobEffect effect, Properties properties) {
        super(effect, 10, properties);
    }

    public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
        if (!world.isClientSide && world.getDifficulty() != Difficulty.PEACEFUL) {
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) entity;
                if (/*!livingEntity.isInvulnerableTo(BMDamageSources.POISON_ROSE) ||*/ !livingEntity.isInvulnerableTo(world.damageSources().magic())) {
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 100));
                }
            }
        }
    }
}
