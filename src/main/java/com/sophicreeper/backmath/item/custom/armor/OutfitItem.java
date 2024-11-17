package com.sophicreeper.backmath.item.custom.armor;

import com.sophicreeper.backmath.entity.model.BMOutfitModel;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class OutfitItem extends BMArmorItem {
    public OutfitItem(IArmorMaterial material, EquipmentSlotType slotType, Properties properties) {
        super(material, slotType, properties);
    }

    @Override
    @Nullable
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity livEntity, ItemStack stack, EquipmentSlotType slotType, A defaultModel) {
        return (A) new BMOutfitModel<>(0, 0, 64, 32, true);
    }
}
