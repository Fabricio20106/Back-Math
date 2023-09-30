package com.sophicreeper.backmath.core.world.item.tool;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DamageableCraftingToolItem extends Item {
    public DamageableCraftingToolItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack container = itemStack.copy();
        if (container.attemptDamageItem(1, random, null)) {
            return ItemStack.EMPTY;
        } else {
            return container;
        }
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }
}
