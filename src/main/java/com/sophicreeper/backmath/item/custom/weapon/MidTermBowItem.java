package com.sophicreeper.backmath.item.custom.weapon;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

import static com.sophicreeper.backmath.config.BMConfigs.COMMON_CONFIGS;

public class MidTermBowItem extends BMBowItem {
    public MidTermBowItem(Properties properties) {
        super(COMMON_CONFIGS.midTermBowFCA.get(), COMMON_CONFIGS.midTermBowCBD.get(), COMMON_CONFIGS.midTermBowAAD.get(), COMMON_CONFIGS.midTermBowFIT.get(), COMMON_CONFIGS.midTermBowFRD.get(), properties);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livEntity = (LivingEntity) entity;
            livEntity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20, 2));
            entity.setFire(10);
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public void onUsingTick(ItemStack stack, LivingEntity player, int count) {
        if (count == 1) {
            this.onPlayerStoppedUsing(stack, player.world, player, count);
        }
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return COMMON_CONFIGS.midTermCustomDurabilityBar.get();
    }
}
