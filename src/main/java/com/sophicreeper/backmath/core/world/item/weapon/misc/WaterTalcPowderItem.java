package com.sophicreeper.backmath.core.world.item.weapon.misc;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class WaterTalcPowderItem extends SwordItem {
    public WaterTalcPowderItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity livingEntity) {
        // livingEntity.hurt(BMDamageSources.WATER_TALC_POWDER, Float.MAX_VALUE);
        return super.finishUsingItem(stack, world, livingEntity);
    }
}
