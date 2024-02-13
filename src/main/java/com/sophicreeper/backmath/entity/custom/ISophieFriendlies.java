package com.sophicreeper.backmath.entity.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;

public interface ISophieFriendlies {
    // Just a helper interface to check for teams.
    default void updateEffectHelmet(LivingEntity livEntity, ITag.INamedTag<Item> providesEffect, Effect effect) {
        ItemStack headStack = livEntity.getItemStackFromSlot(EquipmentSlotType.HEAD);
        boolean acceptableHelmets = headStack.getItem().isIn(providesEffect);
        if (acceptableHelmets && !livEntity.areEyesInFluid(FluidTags.WATER)) {
            livEntity.addPotionEffect(new EffectInstance(effect, 200, 0, false, false, true));
        }
    }
}
