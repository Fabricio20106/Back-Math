package com.sophicreeper.backmath.core.world.item.weapon.sparey;

import com.sophicreeper.backmath.core.util.BMSetFields;
import com.sophicreeper.backmath.core.world.entity.monster.AngrySophie;
import com.sophicreeper.backmath.core.world.entity.monster.QueenLucy;
import com.sophicreeper.backmath.core.world.item.BMWeaponryTab;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class SpareySwordItem extends SwordItem {
    public SpareySwordItem() {
        super(BMSetFields.SPAREY_SET, 3, -2.4F, new Properties().isImmuneToFire().rarity(Rarity.RARE).group(BMWeaponryTab.TAB));
    }

    // When you hit an entity
    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity hitTarget) {
        if (hitTarget instanceof AngrySophie) {
            player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 200, 1));
            // Gives Strength II effect for 10 secs.
        } else {
            player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 50, 2));
            // Gives Weakness III effect for 2.5 secs, but it rounds it up to 3 secs.
        }
        if (hitTarget instanceof QueenLucy) {
            player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 600, 64));
            // Gives Weakness LXIII (63) for 30 secs.
        }
        return super.onLeftClickEntity(stack, player, hitTarget);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return 0x85c284;
    }
}
