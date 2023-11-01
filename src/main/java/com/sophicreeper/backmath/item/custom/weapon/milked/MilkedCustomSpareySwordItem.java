package com.sophicreeper.backmath.item.custom.weapon.milked;

import com.sophicreeper.backmath.entity.custom.AngrySophie;
import com.sophicreeper.backmath.item.tab.BMWeaponryTab;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class MilkedCustomSpareySwordItem extends MilkedSwordItem {
    public MilkedCustomSpareySwordItem(IItemTier tier, Rarity rarity) {
        super(tier, 3, -2.4F, new Properties().isImmuneToFire().rarity(rarity).group(BMWeaponryTab.TAB));
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof AngrySophie) {
            player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 200, 1));
        } else {
            player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 50, 2));
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return 0x1dc2d1;
    }
}
