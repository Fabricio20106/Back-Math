package com.sophicreeper.backmath.core.world.level.block;

import com.sophicreeper.backmath.core.world.entity.BMDamageSources;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class PoisonRoseBlock extends FlowerBlock {
    public PoisonRoseBlock(Effect effect, Properties properties) {
        super(effect, 10, properties);
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (!worldIn.isRemote && worldIn.getDifficulty() != Difficulty.PEACEFUL) {
            if (entityIn instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) entityIn;
                if (!livingEntity.isInvulnerableTo(BMDamageSources.POISON_ROSE)) {
                    livingEntity.addPotionEffect(new EffectInstance(Effects.POISON, 100));
                }
            }
        }
    }
}
