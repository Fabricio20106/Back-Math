package com.sophicreeper.backmath.core.world.item.weapon;

import com.sophicreeper.backmath.core.util.BMSetFields;
import com.sophicreeper.backmath.core.world.item.BMWeaponryTab;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;

public class MechMechSwordItem extends SwordItem {
    public MechMechSwordItem() {
        super(BMSetFields.MECH_MECH_SWORD, 9, 2.0f, new Properties().rarity(Rarity.UNCOMMON));
    }

    // When hitting an entity:
    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity hitTarget) {
        // Sets the target on fire for 5 secs.
        hitTarget.setSecondsOnFire(5);
        return super.onLeftClickEntity(stack, player, hitTarget);
    }
}
