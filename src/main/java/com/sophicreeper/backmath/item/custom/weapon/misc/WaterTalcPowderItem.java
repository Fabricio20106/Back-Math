package com.sophicreeper.backmath.item.custom.weapon.misc;

import com.sophicreeper.backmath.entity.BMDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;

public class WaterTalcPowderItem extends SwordItem {
    public WaterTalcPowderItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity livEntity) {
        livEntity.attackEntityFrom(BMDamageSources.WATER_TALC_POWDER, Float.MAX_VALUE);
        return super.onItemUseFinish(stack, world, livEntity);
    }
}
