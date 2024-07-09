package com.sophicreeper.backmath.item.custom.tool.midterm;

import com.sophicreeper.backmath.item.custom.tool.BMBowItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;

import static com.sophicreeper.backmath.config.BMConfigs.COMMON_CONFIGS;

public class MidTermBowItem extends BMBowItem {
    public MidTermBowItem(Properties properties) {
        super(COMMON_CONFIGS.midTermBowFCA.get(), COMMON_CONFIGS.midTermBowCBD.get(), COMMON_CONFIGS.midTermBowAAD.get(), COMMON_CONFIGS.midTermBowFIT.get(), COMMON_CONFIGS.midTermBowFRD.get(), properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livEntity = (LivingEntity) entity;
            livEntity.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20, 2));
            if (!livEntity.isInvulnerableTo(DamageSource.IN_FIRE) || !livEntity.isInvulnerableTo(DamageSource.ON_FIRE)) livEntity.setSecondsOnFire(10);
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public void onUsingTick(ItemStack stack, LivingEntity player, int count) {
        if (count == 1) this.onPlayerStoppedUsing(stack, player.level, player, count);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return COMMON_CONFIGS.midTermCustomDurabilityBar.get();
    }
}
