package com.sophicreeper.backmath.core.world.item.armor;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class GlisteringArmorItem extends BMArmorItem {
    public GlisteringArmorItem(ArmorMaterial material, ArmorItem.Type slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
