package com.sophicreeper.backmath.util;

import com.sophicreeper.backmath.loot.BMLootTableUtils;
import com.sophicreeper.backmath.util.tag.BMItemTags;
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
            if (!stack.isEmpty()) {
                for (EquipmentSlotType slot : EquipmentSlotType.values()) {
                    if (livEntity.getItemBySlot(slot).isEmpty() && stack.getItem().canEquip(stack, slot, livEntity)) {
                        livEntity.setItemSlot(slot, stack);
                    }
                }
                if (livEntity.getItemBySlot(EquipmentSlotType.MAINHAND).isEmpty() && stack.getItem().is(BMItemTags.ALLOWED_IN_MAINHAND)) {
                    livEntity.setItemSlot(EquipmentSlotType.MAINHAND, stack);
                }
                if (livEntity.getItemBySlot(EquipmentSlotType.OFFHAND).isEmpty() && stack.getItem().is(BMItemTags.ALLOWED_IN_OFFHAND)) {
                    livEntity.setItemSlot(EquipmentSlotType.OFFHAND, stack);
                }
            }
        });
    }

    protected static Collection<ItemStack> getLootTableDrops(ResourceLocation equipmentTable, LivingEntity livEntity) {
        return BMLootTableUtils.equipGear(equipmentTable, livEntity);
    }
}
