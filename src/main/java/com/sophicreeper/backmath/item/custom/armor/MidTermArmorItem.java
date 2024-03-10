package com.sophicreeper.backmath.item.custom.armor;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.entity.BMDamageSources;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
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
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            livingEntity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20, 2));
            entity.setFire(10);
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return BMConfigs.COMMON_CONFIGS.midTermCustomDurabilityBar.get();
    }
}
