package com.sophicreeper.backmath.item.custom.tool;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;

import javax.annotation.Nonnull;

public class CarewniItem extends SwordItem {
    public static Multimap<Attribute, AttributeModifier> MODIFIERS = HashMultimap.create();

    public CarewniItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
        float trueAttackDamage = (float) attackDamage + tier.getAttackDamageBonus();
        HashMultimap<Attribute, AttributeModifier> builder = HashMultimap.create();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Carewni Damage Modifier", trueAttackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Carewni Swing Speed Modifier", swingSpeed, AttributeModifier.Operation.ADDITION));
        MODIFIERS = builder;
    }

    @Override
    @Nonnull
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlotType slot) {
        return slot == EquipmentSlotType.MAINHAND ? MODIFIERS : super.getDefaultAttributeModifiers(slot);
    }
}
