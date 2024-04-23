package com.sophicreeper.backmath.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;

public class DisgustTeaEffect extends Effect {
    public DisgustTeaEffect() {
        super(EffectType.NEUTRAL, 0xD2002B);
    }

    @Override
    public void applyEffectTick(LivingEntity livEntity, int amplifier) {
        if (livEntity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) livEntity;
            int hunger = player.getFoodData().getFoodLevel();
            float saturation = player.getFoodData().getSaturationLevel();

            if (player.getFoodData().getFoodLevel() != hunger || player.getFoodData().getSaturationLevel() != saturation) {
                livEntity.addEffect(new EffectInstance(Effects.CONFUSION, 300));
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
