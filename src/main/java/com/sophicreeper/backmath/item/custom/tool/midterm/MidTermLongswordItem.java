package com.sophicreeper.backmath.item.custom.tool.midterm;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;

import javax.annotation.Nonnull;
import java.util.UUID;

public class MidTermLongswordItem extends MidTermSwordItem {
    public static Multimap<Attribute, AttributeModifier> MODIFIERS = HashMultimap.create();

    public MidTermLongswordItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
        float trueAttackDamage = (float) attackDamage + tier.getAttackDamageBonus();
        HashMultimap<Attribute, AttributeModifier> builder = HashMultimap.create();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Mid-Term Longsword Damage Modifier", trueAttackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Mid-Term Longsword Swing Speed Modifier", swingSpeed, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(UUID.fromString("8d8a6a3d-ca54-4fd6-865b-97f253b260ee"), "Mid-Term Longsword Movement Speed Modifier", -0.2, AttributeModifier.Operation.MULTIPLY_TOTAL));
        MODIFIERS = builder;
    }

    @Override
    @Nonnull
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlotType slot) {
        return slot == EquipmentSlotType.MAINHAND ? MODIFIERS : super.getDefaultAttributeModifiers(slot);
    }

    /*@Override
    public void fillItemCategory(ItemGroup tab, NonNullList<ItemStack> list) {
        ItemStack stack = new ItemStack(this);
        CompoundNBT tag = stack.getOrCreateTag();

        ListNBT attributeList = tag.getList("attributes", TagTypes.LIST);
        for (Attribute attribute : this.attributeModifiers.keySet()) {
            Collection<AttributeModifier> modifiers = this.attributeModifiers.get(attribute);
            for (AttributeModifier modifier : modifiers) attributeList.add(modifier.save());
        }
        tag.put("attributes", attributeList);
        list.add(stack);
    }*/
}
