package com.sophicreeper.backmath.util;

import com.sophicreeper.backmath.loot.BMLootTableUtils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.Collection;

public class EquipmentTableUtils {
    // Equips any living entity with a loot table from the "equipmentTable" parameter.
    public static void equipWithGear(ResourceLocation equipmentTable, LivingEntity livEntity) {
        Collection<ItemStack> lootTableDrops = getLootTableDrops(equipmentTable, livEntity);

        lootTableDrops.forEach(stack -> {
            for (EquipmentSlotType slot : EquipmentSlotType.values()) {
                if (stack.getItem().canEquip(stack, slot, livEntity) && livEntity.getItemBySlot(slot).isEmpty()) {
                    livEntity.setItemSlot(slot, stack);
                }
            }
            if (stack.getItem().is(BMTags.Items.ALLOWED_IN_MAINHAND) && livEntity.getItemBySlot(EquipmentSlotType.MAINHAND).isEmpty()) {
                livEntity.setItemSlot(EquipmentSlotType.MAINHAND, stack);
            }
            if (stack.getItem().is(BMTags.Items.ALLOWED_IN_OFFHAND) && livEntity.getItemBySlot(EquipmentSlotType.OFFHAND).isEmpty()) {
                livEntity.setItemSlot(EquipmentSlotType.OFFHAND, stack);
            }
        });
    }

    protected static Collection<ItemStack> getLootTableDrops(ResourceLocation equipmentTable, LivingEntity livEntity) {
        return BMLootTableUtils.equipGear(equipmentTable, livEntity);
    }
}
