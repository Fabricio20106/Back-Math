package com.sophicreeper.backmath.core.world.item.weapon.sparey;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class CustomSpareySwordItem extends SwordItem {
    public CustomSpareySwordItem(Tier tier, Rarity rarity) {
        super(tier, 3, -2.4F, new Properties().fireResistant().rarity(rarity));
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    // When hitting an entity:
    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity hitTarget) {
        //if (hitTarget instanceof AngrySophie) {
        //    player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 200, 1));
            // Gives the sword user Strength II effect for 10 secs.
        //} else {
            player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 50, 2));
            // Gives the sword user Weakness III effect for 2.5 secs (or 3 secs rounded).
        //}
        return super.onLeftClickEntity(stack, player, hitTarget);
    }

    //@Override
    //public int getRGBDurabilityForDisplay(ItemStack stack) {
    //    return 0x1dc2d1;
    //}
}
