package com.sophicreeper.backmath.util;

import com.sophicreeper.backmath.item.custom.weapon.BMBowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;

import static net.minecraft.item.ItemModelsProperties.register;

public class BMItemModelProperties {
    public static void makeBow(BMBowItem bow) {
        register(bow, new ResourceLocation("pull"), (stack, world, livEntity) -> {
            if (livEntity == null) {
                return 0;
            } else {
                return livEntity.getUseItem() != stack ? 0 : (float) (bow.getUseDuration(stack) - livEntity.getUseItemRemainingTicks()) / Math.min(bow.getUseDuration(stack), 20);
            }
        });
        register(bow, new ResourceLocation("pulling"), (stack, world, livEntity) -> livEntity != null && livEntity.isUsingItem() && livEntity.getUseItem() == stack ? 1 : 0);
    }

    public static void makeCrossbow(Item crossbow) {
        register(crossbow, new ResourceLocation("pulling"), (stack, world, livEntity) -> livEntity != null && livEntity.isUsingItem() && livEntity.getUseItem() == stack && !CrossbowItem.isCharged(stack) ? 1 : 0);
        register(crossbow, new ResourceLocation("charged"), (stack, world, livEntity) -> livEntity != null && CrossbowItem.isCharged(stack) ? 1 : 0);
        register(crossbow, new ResourceLocation("firework"), (stack, world, livEntity) -> livEntity != null && CrossbowItem.isCharged(stack) && CrossbowItem.containsChargedProjectile(stack, Items.FIREWORK_ROCKET) ? 1 : 0);
    }

    public static void makeShield(Item shield) {
        register(shield, new ResourceLocation("blocking"), (stack, world, livEntity) -> livEntity != null && livEntity.isUsingItem() && livEntity.getUseItem() == stack ? 1 : 0);
    }
}
