package com.sophicreeper.backmath.item.custom.armor;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;

public class GlisteringOutfitItem extends OutfitItem {
    public GlisteringOutfitItem(IArmorMaterial material, EquipmentSlotType slotType, Properties properties) {
        super(material, slotType, properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
