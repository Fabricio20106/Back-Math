package com.sophicreeper.backmath.item.custom.tool;

import com.sophicreeper.backmath.item.BMSetFields;
import com.sophicreeper.backmath.entity.custom.AngrySophie;
import com.sophicreeper.backmath.entity.custom.QueenLucy;
import com.sophicreeper.backmath.item.tab.BMWeaponryTab;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShovelItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class SpavelShovelItem extends ShovelItem {
    public SpavelShovelItem() {
        super(BMSetFields.SPAREY_SET, 1.5f, -3.0F, new Properties().isImmuneToFire().rarity(Rarity.RARE).group(BMWeaponryTab.TAB));
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof AngrySophie) {
            player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 200, 1));
        } else {
            player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 50, 2));
        }
        if (entity instanceof QueenLucy) {
            player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 600, 64));
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return 0x85c284;
    }
}
