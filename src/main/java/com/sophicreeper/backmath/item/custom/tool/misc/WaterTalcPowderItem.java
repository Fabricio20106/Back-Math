package com.sophicreeper.backmath.item.custom.tool.misc;

import com.sophicreeper.backmath.util.BMDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class WaterTalcPowderItem extends SwordItem {
    public WaterTalcPowderItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    @Override
    @Nonnull
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livEntity) {
        livEntity.hurt(BMDamageSources.WATER_TALC_POWDER, Float.MAX_VALUE);
        return super.finishUsingItem(stack, world, livEntity);
    }
}
