package com.sophicreeper.backmath.entity.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;

public interface SophieFriendlies {
    // Just a helper interface to check for teams.
    default void updateEffectHelmet(LivingEntity livEntity, ITag.INamedTag<Item> providesEffect, Effect effect) {
        ItemStack headStack = livEntity.getItemBySlot(EquipmentSlotType.HEAD);
        boolean acceptableHelmets = headStack.getItem().is(providesEffect);
        if (acceptableHelmets && !livEntity.isEyeInFluid(FluidTags.WATER)) {
            livEntity.addEffect(new EffectInstance(effect, 200, 0, false, false, true));
        }
    }
}
