package com.sophicreeper.backmath.core.world.item.weapon;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import static com.sophicreeper.backmath.core.config.BMConfigs.SERVER_CONFIGS;

public class MidTermBowItem extends BMBowItem {
    public MidTermBowItem(Properties properties) {
        super(SERVER_CONFIGS.midTermBowFCA.get(), SERVER_CONFIGS.midTermBowCBD.get(), SERVER_CONFIGS.midTermBowAAD.get(), SERVER_CONFIGS.midTermBowFIT.get(),
                SERVER_CONFIGS.midTermBowFRD.get(), properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 2));
        }
        entity.setSecondsOnFire(10);
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public void onStopUsing(ItemStack stack, LivingEntity player, int count) {
        if (count == 1) {
            this.releaseUsing(stack, player.level(), player, count);
        }
    }
}
