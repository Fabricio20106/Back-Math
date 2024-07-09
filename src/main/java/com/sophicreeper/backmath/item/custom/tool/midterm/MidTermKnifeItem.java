package com.sophicreeper.backmath.item.custom.tool.midterm;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.item.custom.tool.KnifeItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;

public class MidTermKnifeItem extends KnifeItem {
    public MidTermKnifeItem(float attackDamage, float swingSpeed, IItemTier tier, Properties properties) {
        super(attackDamage, swingSpeed, tier, properties);
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
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return BMConfigs.COMMON_CONFIGS.midTermCustomDurabilityBar.get();
    }
}
