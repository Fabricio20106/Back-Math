package com.sophicreeper.backmath.item.custom;

import com.google.common.collect.Lists;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

import javax.annotation.Nonnull;
import java.util.List;

public interface MidTermToolBehaviors extends ToolBehaviors {
    @Nonnull
    @Override
    default List<EffectInstance> getAppliedEffects() {
        return Lists.newArrayList(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20, 2));
    }

    default void midTermEffects(ItemStack stack, LivingEntity livEntity) {
        applyTagEffects(stack, livEntity);
        setOnFire(stack, livEntity, 10);
    }
}
