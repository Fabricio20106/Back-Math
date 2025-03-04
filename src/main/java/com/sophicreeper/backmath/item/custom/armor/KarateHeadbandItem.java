package com.sophicreeper.backmath.item.custom.armor;

import com.sophicreeper.backmath.item.custom.behavior.BMArmorItem;
import com.sophicreeper.backmath.util.TagTypes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public class KarateHeadbandItem extends BMArmorItem implements IDyeableArmorItem {
    public KarateHeadbandItem(IArmorMaterial material, EquipmentSlotType slotType, Properties properties) {
        super(material, slotType, properties);
    }

    @Override
    public int getColor(ItemStack stack) {
        CompoundNBT displayTag = stack.getTagElement("display");
        return displayTag != null && displayTag.contains("color", TagTypes.ANY_NUMERIC) ? displayTag.getInt("color") : 0xFED83D;
    }
}
