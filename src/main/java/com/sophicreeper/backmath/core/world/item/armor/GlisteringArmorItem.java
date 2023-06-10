package com.sophicreeper.backmath.core.world.item.armor;

import com.sophicreeper.backmath.core.world.item.armor.BMArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;

public class GlisteringArmorItem extends BMArmorItem {
    public GlisteringArmorItem(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
