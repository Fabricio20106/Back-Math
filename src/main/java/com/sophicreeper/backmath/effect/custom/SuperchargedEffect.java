package com.sophicreeper.backmath.effect.custom;

import com.sophicreeper.backmath.particle.BMParticleTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

import java.util.Random;

public class SuperchargedEffect extends Effect {
    public SuperchargedEffect() {
        super(EffectType.BENEFICIAL, 0x00C3D3);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "9ae68496-1d78-4b7c-ae91-c174e0557614", 0.5F, AttributeModifier.Operation.MULTIPLY_TOTAL);
        this.addAttributeModifier(Attributes.ATTACK_DAMAGE, "812bd1a3-ee83-4455-b54d-46296b8a28b5", 4, AttributeModifier.Operation.ADDITION);
        this.addAttributeModifier(Attributes.ATTACK_KNOCKBACK, "3a4afdae-1367-4a61-93e6-d8286577e4fe", 1.5, AttributeModifier.Operation.ADDITION);
        this.addAttributeModifier(Attributes.MAX_HEALTH, "33100b11-c8d6-4af6-a8ad-b0fc7d46c1c4", 10, AttributeModifier.Operation.ADDITION);
    }

    // Mid-Term particles aren't being displayed for some reason.
    @Override
    public void applyEffectTick(LivingEntity livEntity, int amplifier) {
        Random random = livEntity.level.random;
        double x = livEntity.getX() + 0.55D - (double) (random.nextFloat() * 0.1F);
        double y = livEntity.getY() + 0.55D - (double) (random.nextFloat() * 0.1F);
        double z = livEntity.getZ() + 0.55D - (double) (random.nextFloat() * 0.1F);
        double offset = 0.4F - (random.nextFloat() + random.nextFloat()) * 0.4F;
        if (random.nextInt(5) == 0) {
            livEntity.level.addParticle(BMParticleTypes.WARMTERM.get(), x * offset, y * offset, z * offset, random.nextGaussian() * 0.05D, random.nextGaussian() * 0.05D, random.nextGaussian() * 0.05D);
            livEntity.level.addParticle(BMParticleTypes.COLDTERM.get(), x * offset, y * offset, z * offset, random.nextGaussian() * 0.05D, random.nextGaussian() * 0.05D, random.nextGaussian() * 0.05D);
        }
        super.applyEffectTick(livEntity, amplifier);
    }

    @Override
    public void addAttributeModifiers(LivingEntity livEntity, AttributeModifierManager manager, int amplifier) {
        livEntity.maxUpStep += 1;
        super.addAttributeModifiers(livEntity, manager, amplifier);
    }

    @Override
    public void removeAttributeModifiers(LivingEntity livEntity, AttributeModifierManager manager, int amplifier) {
        livEntity.maxUpStep -= 1;
        super.removeAttributeModifiers(livEntity, manager, amplifier);
    }
}
