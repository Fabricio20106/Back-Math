package com.sophicreeper.backmath.item.custom.tool;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.sophicreeper.backmath.item.behavior.BMItemBehaviors;
import com.sophicreeper.backmath.item.custom.behavior.BMSwordItem;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;

import javax.annotation.Nonnull;

public class MechMechSwordItem extends BMSwordItem {
    public static Multimap<Attribute, AttributeModifier> MODIFIERS = HashMultimap.create();

    public MechMechSwordItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(BMItemBehaviors.MECH_MECH, tier, attackDamage, swingSpeed, properties);
        HashMultimap<Attribute, AttributeModifier> builder = HashMultimap.create();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Mech-Mech Damage Modifier", attackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Mech-Mech Swing Speed Modifier", swingSpeed, AttributeModifier.Operation.ADDITION));
        MODIFIERS = builder;
    }

    @Override
    @Nonnull
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlotType slot) {
        return slot == EquipmentSlotType.MAINHAND ? MODIFIERS : super.getDefaultAttributeModifiers(slot);
    }
}
