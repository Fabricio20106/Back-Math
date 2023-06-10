package com.sophicreeper.backmath.core.world.item.weapon.misc;

import com.sophicreeper.backmath.core.world.entity.BMDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;

public class WaterTalcPowderItem extends SwordItem {
    public WaterTalcPowderItem(IItemTier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity livingEntity) {
        livingEntity.attackEntityFrom(BMDamageSources.WATER_TALC_POWDER, Float.MAX_VALUE);
        return super.onItemUseFinish(stack, world, livingEntity);
    }
}
