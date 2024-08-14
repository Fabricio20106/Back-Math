package com.sophicreeper.backmath.item.custom.tool.midterm;

import com.sophicreeper.backmath.item.custom.MidTermToolBehaviors;
import com.sophicreeper.backmath.item.custom.tool.BMBowItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

import static com.sophicreeper.backmath.config.BMConfigs.COMMON_CONFIGS;

public class MidTermBowItem extends BMBowItem implements MidTermToolBehaviors {
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
            applyTagEffects(stack, livEntity);
            setOnFire(stack, livEntity, 10);
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
