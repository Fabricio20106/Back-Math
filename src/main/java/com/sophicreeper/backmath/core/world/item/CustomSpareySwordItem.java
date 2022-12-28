package com.sophicreeper.backmath.core.world.item;

import com.sophicreeper.backmath.core.world.entity.monster.AngrySophie;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class CustomSpareySwordItem extends SwordItem {
    public CustomSpareySwordItem(IItemTier tier, Rarity rarity) {
        super(tier, 3, -2.4F, new Properties().isImmuneToFire().rarity(rarity).group(BMWeaponryTab.TAB));
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    // When hitting an entity:
    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity hitTarget) {
        if (hitTarget instanceof AngrySophie) {
            player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 200, 1));
            // Gives the sword user Strength II effect for 10 secs.
        } else {
            player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 50, 2));
            // Gives the sword user Weakness III effect for 2.5 secs (or 3 secs rounded).
        }
        return super.onLeftClickEntity(stack, player, hitTarget);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return 0x1dc2d1;
    }
}
