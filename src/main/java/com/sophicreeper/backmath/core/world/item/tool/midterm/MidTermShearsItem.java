package com.sophicreeper.backmath.core.world.item.tool.midterm;

import com.sophicreeper.backmath.core.world.item.tool.GlisteringShearsItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class MidTermShearsItem extends GlisteringShearsItem {
    public MidTermShearsItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            livingEntity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20, 2));
        }
        entity.setFire(10);
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return 0x1dc2d1;
    }
}
