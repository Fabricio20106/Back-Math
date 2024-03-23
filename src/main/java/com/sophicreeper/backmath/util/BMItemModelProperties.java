package com.sophicreeper.backmath.util;

import com.sophicreeper.backmath.item.custom.weapon.BMBowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;

import static net.minecraft.item.ItemModelsProperties.registerProperty;

public class BMItemModelProperties {
    public static void makeBow(BMBowItem bow) {
        registerProperty(bow, new ResourceLocation("pull"), (stack, world, livEntity) -> {
            if (livEntity == null) {
                return 0;
            } else {
                return livEntity.getActiveItemStack() != stack ? 0 : (float) (bow.getUseDuration(stack) - livEntity.getItemInUseCount()) / Math.min(bow.getUseDuration(stack), 20);
            }
        });
        registerProperty(bow, new ResourceLocation("pulling"), (stack, world, livEntity) -> livEntity != null && livEntity.isHandActive() && livEntity.getActiveItemStack() == stack ? 1 : 0);
    }

    public static void makeCrossbow(Item crossbow) {
        registerProperty(crossbow, new ResourceLocation("pulling"), (stack, world, livEntity) -> livEntity != null && livEntity.isHandActive() && livEntity.getActiveItemStack() == stack && !CrossbowItem.isCharged(stack) ? 1 : 0);
        registerProperty(crossbow, new ResourceLocation("charged"), (stack, world, livEntity) -> livEntity != null && CrossbowItem.isCharged(stack) ? 1 : 0);
        registerProperty(crossbow, new ResourceLocation("firework"), (stack, world, livEntity) -> livEntity != null && CrossbowItem.isCharged(stack) && CrossbowItem.hasChargedProjectile(stack, Items.FIREWORK_ROCKET) ? 1 : 0);
    }

    public static void makeShield(Item shield) {
        registerProperty(shield, new ResourceLocation("blocking"), (stack, world, livEntity) -> livEntity != null && livEntity.isHandActive() && livEntity.getActiveItemStack() == stack ? 1 : 0);
    }
}
