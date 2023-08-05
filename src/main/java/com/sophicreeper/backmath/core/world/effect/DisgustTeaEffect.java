package com.sophicreeper.backmath.core.world.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class DisgustTeaEffect extends MobEffect {
    public DisgustTeaEffect() {
        super(MobEffectCategory.NEUTRAL, 0xd2002b);
    }

    @Override
    public void applyEffectTick(LivingEntity livEntity, int amplifier) {
        if (livEntity instanceof Player) {
            Player player = (Player) livEntity;
            int hunger = player.getFoodData().getFoodLevel();
            float saturation = player.getFoodData().getSaturationLevel();

            if (player.getFoodData().getFoodLevel() != hunger || player.getFoodData().getSaturationLevel() != saturation) {
                livEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 300));
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
