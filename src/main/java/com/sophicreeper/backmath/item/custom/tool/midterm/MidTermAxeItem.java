package com.sophicreeper.backmath.item.custom.tool.midterm;

import com.sophicreeper.backmath.config.BMConfigs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class MidTermAxeItem extends AxeItem {
    public MidTermAxeItem(IItemTier tier, float attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            livingEntity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20, 2));
            entity.setFire(10);
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return BMConfigs.COMMON_CONFIGS.midTermCustomDurabilityBar.get();
    }
}
