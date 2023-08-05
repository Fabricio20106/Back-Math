package com.sophicreeper.backmath.core.world.item.weapon.milked;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class MilkedMidTermSwordItem extends SwordItem {
    public MilkedMidTermSwordItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
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
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity livingEntity) {
        if (livingEntity instanceof Player) {
            ((Player) livingEntity).giveExperiencePoints(500);
        }
        return super.finishUsingItem(stack, world, livingEntity);
    }

    //@Override
    //public int getRGBDurabilityForDisplay(ItemStack stack) {
    //    return 0x1dc2d1;
    //}
}
