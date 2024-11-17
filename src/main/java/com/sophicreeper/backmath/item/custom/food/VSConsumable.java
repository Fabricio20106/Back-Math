package com.sophicreeper.backmath.item.custom.food;

import com.sophicreeper.backmath.util.TagTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

// Last Updated: Variants 1.8.0.6 (on pc)
public interface VSConsumable {
    static int getCooldown(ItemStack stack, int cooldown) {
        CompoundNBT consumableTag = stack.getTagElement("consumable");
        if (consumableTag != null && consumableTag.contains("cooldown", TagTypes.ANY_NUMERIC)) {
            return consumableTag.getInt("cooldown");
        }
        return cooldown;
    }

    static void applyCooldown(ItemStack stack, LivingEntity livEntity, int cooldownTicks) {
        if (livEntity instanceof PlayerEntity) {
            ((PlayerEntity) livEntity).getCooldowns().addCooldown(stack.getItem(), getCooldown(stack, cooldownTicks));
        }
    }
}
