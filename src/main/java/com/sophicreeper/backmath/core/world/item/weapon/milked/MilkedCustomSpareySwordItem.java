package com.sophicreeper.backmath.core.world.item.weapon.milked;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;

public class MilkedCustomSpareySwordItem extends MilkedSwordItem {
    public MilkedCustomSpareySwordItem(Tier tier, Rarity rarity) {
        super(tier, 3, -2.4F, new Properties().fireResistant().rarity(rarity));
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        //if (entity instanceof AngrySophie) {
        //    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1));
        //} else {
        player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 50, 2));
        //}
        return super.onLeftClickEntity(stack, player, entity);
    }

    //@Override
    //public int getRGBDurabilityForDisplay(ItemStack stack) {
    //    return 0x1dc2d1;
    //}
}
