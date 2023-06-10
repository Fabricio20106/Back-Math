package com.sophicreeper.backmath.core.world.item.weapon;

import com.sophicreeper.backmath.core.util.BMSetFields;
import com.sophicreeper.backmath.core.world.item.BMWeaponryTab;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;

public class MechMechSwordItem extends SwordItem {
    public MechMechSwordItem() {
        super(BMSetFields.MECH_MECH_SWORD, 9, 2.0f, new Properties().rarity(Rarity.UNCOMMON).group(BMWeaponryTab.TAB));
    }

    // When hitting an entity:
    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity hitTarget) {
        // Sets the target on fire for 5 secs.
        hitTarget.setFire(5);
        return super.onLeftClickEntity(stack, player, hitTarget);
    }
}
