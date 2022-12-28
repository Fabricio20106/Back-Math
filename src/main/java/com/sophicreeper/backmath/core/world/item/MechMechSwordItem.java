package com.sophicreeper.backmath.core.world.item;

import com.sophicreeper.backmath.core.util.BMStaticFields;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;

public class MechMechSwordItem extends SwordItem {
    public MechMechSwordItem() {
        super(BMStaticFields.MECH_MECH_SET, 9, 2.0f, new Properties().rarity(Rarity.UNCOMMON).group(BMWeaponryTab.TAB));
    }

    // When hitting an entity:
    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity hitTarget) {
        // Sets the target on fire for 5 secs.
        hitTarget.setFire(5);
        return super.onLeftClickEntity(stack, player, hitTarget);
    }
}
