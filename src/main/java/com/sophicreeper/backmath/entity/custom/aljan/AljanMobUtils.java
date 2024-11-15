package com.sophicreeper.backmath.entity.custom.aljan;

import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.Difficulty;

import javax.annotation.Nullable;
import java.util.Random;

public interface AljanMobUtils {
    default void populateAljanEquipmentSlots(LivingEntity livEntity, Random random) {
        if (random.nextFloat() < 0.15) {
            int rand = random.nextInt(2);
            float chancePerDifficulty = livEntity.level.getDifficulty() == Difficulty.HARD ? 0.1F : 0.25F;
            if (random.nextFloat() < 0.095F) ++rand;
            if (random.nextFloat() < 0.095F) ++rand;
            if (random.nextFloat() < 0.095F) ++rand;
            boolean populateArmor = true;

            EquipmentSlotType[] armorSlots = new EquipmentSlotType[] {EquipmentSlotType.HEAD, EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET};
            for (EquipmentSlotType slotType : armorSlots) {
                if (slotType.getType() == EquipmentSlotType.Group.ARMOR) {
                    ItemStack stack = livEntity.getItemBySlot(slotType);
                    if (!populateArmor && random.nextFloat() < chancePerDifficulty) break;

                    populateArmor = false;
                    if (stack.isEmpty()) {
                        Item armorItem = getAljanArmorByChance(slotType, rand);
                        if (armorItem != null) livEntity.setItemSlot(slotType, new ItemStack(armorItem));
                    }
                }
            }
        }
    }

    @Nullable
    default Item getAljanArmorByChance(EquipmentSlotType slot, int chance) {
        switch (slot) {
            case HEAD:
                if (chance == 0) {
                    return AxolotlTest.JANTSKIN_HELMET.get();
                } else if (chance == 1) {
                    return AxolotlTest.ARCHER_FABRICIO_HOOD.get();
                } else if (chance == 2) {
                    return AxolotlTest.ALJAMEED_HELMET.get();
                } else if (chance == 3) {
                    return AxolotlTest.MOONERING_HELMET.get();
                } else if (chance == 4) {
                    return AxolotlTest.JANTIQUIFIED_MOONERING_HELMET.get();
                }
            case CHEST:
                if (chance == 0) {
                    return AxolotlTest.JANTSKIN_CHESTPLATE.get();
                } else if (chance == 1) {
                    return AxolotlTest.ARCHER_FABRICIO_VEST.get();
                } else if (chance == 2) {
                    return AxolotlTest.ALJAMEED_CHESTPLATE.get();
                } else if (chance == 3) {
                    return AxolotlTest.MOONERING_CHESTPLATE.get();
                } else if (chance == 4) {
                    return AxolotlTest.JANTIQUIFIED_MOONERING_CHESTPLATE.get();
                }
            case LEGS:
                if (chance == 0) {
                    return AxolotlTest.JANTSKIN_LEGGINGS.get();
                } else if (chance == 1) {
                    return Items.AIR;
                } else if (chance == 2) {
                    return AxolotlTest.ALJAMEED_LEGGINGS.get();
                } else if (chance == 3) {
                    return AxolotlTest.MOONERING_LEGGINGS.get();
                } else if (chance == 4) {
                    return AxolotlTest.JANTIQUIFIED_MOONERING_LEGGINGS.get();
                }
            case FEET:
                if (chance == 0) {
                    return AxolotlTest.JANTSKIN_BOOTS.get();
                } else if (chance == 1) {
                    return Items.AIR;
                } else if (chance == 2) {
                    return AxolotlTest.ALJAMEED_BOOTS.get();
                } else if (chance == 3) {
                    return AxolotlTest.MOONERING_BOOTS.get();
                } else if (chance == 4) {
                    return AxolotlTest.JANTIQUIFIED_MOONERING_BOOTS.get();
                }
            default: return null;
        }
    }
}
