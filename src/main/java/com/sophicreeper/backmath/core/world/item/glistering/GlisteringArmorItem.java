package com.sophicreeper.backmath.core.world.item.glistering;

import com.sophicreeper.backmath.core.world.item.BMArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;

public class GlisteringArmorItem extends BMArmorItem {
    public GlisteringArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
        super(materialIn, slot, builderIn);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
