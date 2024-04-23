package com.sophicreeper.backmath.item.custom.weapon;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.sophicreeper.backmath.config.BMConfigs;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraftforge.common.ForgeMod;

import java.util.UUID;

public class MidTermGreatswordItem extends MidTermSwordItem {
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;

    public MidTermGreatswordItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Mid-Term Greatsword Damage Modifier", attackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Mid-Term Greatsword Swing Speed Modifier", swingSpeed, AttributeModifier.Operation.ADDITION));
        if (ForgeMod.REACH_DISTANCE.isPresent()) {
            builder.put(ForgeMod.REACH_DISTANCE.get(), new AttributeModifier(UUID.fromString("4925a97b-4689-4deb-9f89-8d046f480d0a"), "Mid-Term Greatsword Reach Modifier", BMConfigs.COMMON_CONFIGS.midTermGreatswordReachIncrease.get(),
                    AttributeModifier.Operation.ADDITION));
        }
        this.attributeModifiers = builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlotType slot) {
        return slot == EquipmentSlotType.MAINHAND ? this.attributeModifiers : super.getDefaultAttributeModifiers(slot);
    }
}
