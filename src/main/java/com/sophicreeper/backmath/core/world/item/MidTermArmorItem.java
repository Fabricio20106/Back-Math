package com.sophicreeper.backmath.core.world.item;

import com.sophicreeper.backmath.core.world.entity.BMDamageSources;
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

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (stack.getMaxDamage() <= stack.getDamage()) {
            stack.shrink(1);
            world.createExplosion(player, BMDamageSources.MID_TERM_ARMOR_INSTABILITY, null, player.getPosX(), player.getPosY(), player.getPosZ(), 8, false, Explosion.Mode.DESTROY);
        }
        super.onArmorTick(stack, world, player);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return 0x1dc2d1;
    }
}
