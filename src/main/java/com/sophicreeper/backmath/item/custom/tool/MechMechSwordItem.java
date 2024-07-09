package com.sophicreeper.backmath.item.custom.tool;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.sophicreeper.backmath.config.BMConfigs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraftforge.common.ForgeMod;

import java.util.UUID;

public class MechMechSwordItem extends SwordItem {
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;

    public MechMechSwordItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Mech-Mech Damage Modifier", attackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Mech-Mech Swing Speed Modifier", swingSpeed, AttributeModifier.Operation.ADDITION));
        while (ForgeMod.REACH_DISTANCE.isPresent()) {
            builder.put(ForgeMod.REACH_DISTANCE.get(), new AttributeModifier(UUID.fromString("4925a97b-4689-4deb-9f89-8d046f480d0a"), "Mech-Mech Reach Modifier", BMConfigs.COMMON_CONFIGS.mechMechReachDecrease.get(),
                    AttributeModifier.Operation.ADDITION));
        }
        this.attributeModifiers = builder.build();
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livEntity = (LivingEntity) entity;
            livEntity.setSecondsOnFire(5);
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlotType slot) {
        return slot == EquipmentSlotType.MAINHAND ? this.attributeModifiers : super.getDefaultAttributeModifiers(slot);
    }
}
