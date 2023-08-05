package com.sophicreeper.backmath.core.world.item.armor;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MidTermArmorItem extends ArmorItem {
    public MidTermArmorItem(ArmorMaterial material, ArmorItem.Type slot, Properties properties) {
        super(material, slot, properties);
    }

    // Needs more testing/changing to work.
    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (stack.getMaxDamage() <= stack.getDamageValue()) {
            stack.shrink(1);
            //world.explode(player, BMDamageSources.MID_TERM_ARMOR_INSTABILITY, null, player.getX(), player.getY(), player.getZ(), 8, false, Level.ExplosionInteraction.BLOCK);
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
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    //@Override
    //public int getRGBDurabilityForDisplay(ItemStack stack) {
    //    return 0x1dc2d1;
    //}
}
