package com.sophicreeper.backmath.core.world.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;

public class DisgustTeaEffect extends Effect {
    public DisgustTeaEffect() {
        super(EffectType.NEUTRAL, 0xd2002b);
    }

    @Override
    public void performEffect(LivingEntity livEntity, int amplifier) {
        if (livEntity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) livEntity;
            int hunger = player.getFoodStats().getFoodLevel();
            float saturation = player.getFoodStats().getSaturationLevel();

            if (player.getFoodStats().getFoodLevel() != hunger || player.getFoodStats().getSaturationLevel() != saturation) {
                livEntity.addPotionEffect(new EffectInstance(Effects.NAUSEA, 300));
            }
        }
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }
}
