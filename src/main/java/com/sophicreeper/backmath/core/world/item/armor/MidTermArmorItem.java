package com.sophicreeper.backmath.core.world.item.armor;

import com.sophicreeper.backmath.core.world.entity.BMDamageSources;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class MidTermArmorItem extends ArmorItem {
    public MidTermArmorItem(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
        super(material, slot, properties);
    }

    // Needs more testing/changing to work.
    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (stack.getMaxDamage() <= stack.getDamage()) {
            stack.shrink(1);
            world.createExplosion(player, BMDamageSources.MID_TERM_ARMOR_INSTABILITY, null, player.getPosX(), player.getPosY(), player.getPosZ(), 8, false, Explosion.Mode.DESTROY);
        }
        super.onArmorTick(stack, world, player);
    }

    // For testing purposes, I don't know if the method above works or not yet.
    /*@Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
        LivingEntity livingEntity = (LivingEntity) entity;
        stack.damageItem(1, livingEntity, (entity1) -> entity1.sendBreakAnimation(EquipmentSlotType.MAINHAND));
        super.inventoryTick(stack, world, entity, itemSlot, isSelected);
    }*/

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return 0x1dc2d1;
    }
}
