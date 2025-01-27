package com.sophicreeper.backmath.item.custom.armor;

import com.sophicreeper.backmath.item.behavior.BMItemBehaviors;
import com.sophicreeper.backmath.item.custom.behavior.BMArmorItem;
import com.sophicreeper.backmath.util.BMDamageSources;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class MidTermArmorItem extends BMArmorItem {
    public MidTermArmorItem(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
        super(material, slot, BMItemBehaviors.MID_TERM, properties);
    }

    // Needs more testing/changing to work.
    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (stack.getMaxDamage() <= stack.getDamageValue()) {
            world.explode(player, BMDamageSources.MID_TERM_ARMOR_INSTABILITY, null, player.getX(), player.getY(), player.getZ(), 8, false, Explosion.Mode.DESTROY);
            stack.shrink(1);
        }
        super.onArmorTick(stack, world, player);
    }
}
