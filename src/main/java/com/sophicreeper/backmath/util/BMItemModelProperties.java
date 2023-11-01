package com.sophicreeper.backmath.util;

import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;

import static net.minecraft.item.ItemModelsProperties.registerProperty;

public class BMItemModelProperties {
    public static void makeBow(Item bow) {
        registerProperty(bow, new ResourceLocation("pull"), (stack, world, livingEntity) -> {
            if (livingEntity == null) {
                return 0;
            } else {
                return livingEntity.getActiveItemStack() != stack ? 0 : (float) (stack.getUseDuration() - livingEntity.getItemInUseCount()) / 20;
            }
        });
        registerProperty(bow, new ResourceLocation("pulling"), (stack, world, livingEntity) -> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == stack ? 1 : 0);
    }

    public static void makeCrossbow(Item crossbow) {
        registerProperty(crossbow, new ResourceLocation("pulling"), (stack, world, livingEntity) -> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == stack && !CrossbowItem.isCharged(stack) ? 1 : 0);
        registerProperty(crossbow, new ResourceLocation("charged"), (stack, world, livingEntity) -> livingEntity != null && CrossbowItem.isCharged(stack) ? 1 : 0);
        registerProperty(crossbow, new ResourceLocation("firework"), (stack, world, livingEntity) -> livingEntity != null && CrossbowItem.isCharged(stack) && CrossbowItem.hasChargedProjectile(stack, Items.FIREWORK_ROCKET) ? 1 : 0);

    }

    public static void makeShield(Item shield) {
        registerProperty(shield, new ResourceLocation("blocking"), (stack, world, livingEntity) -> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == stack ? 1 : 0);
    }
}
