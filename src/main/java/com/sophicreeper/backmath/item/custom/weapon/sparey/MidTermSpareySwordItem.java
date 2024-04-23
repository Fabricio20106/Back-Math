package com.sophicreeper.backmath.item.custom.weapon.sparey;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class MidTermSpareySwordItem extends SwordItem {
    public MidTermSpareySwordItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity target) {
        if (target.getType().is(BMTags.EntityTypes.SPAREY_EFFECTIVES)) {
            player.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 200, 1));
            // Gives the sword user Strength II effect for 10 secs.
        } else {
            player.addEffect(new EffectInstance(Effects.WEAKNESS, 50, 2));
            // Gives the sword user Weakness III effect for 2.5 secs (or 3 secs rounded).
        }
        if (target.getType().is(BMTags.EntityTypes.SPAREYS_PROHIBITED)) {
            player.addEffect(new EffectInstance(Effects.WEAKNESS, 600, 64));
            // Gives Weakness LXIII (63) for 30 secs.
        }
        return super.onLeftClickEntity(stack, player, target);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return BMConfigs.COMMON_CONFIGS.midTermCustomDurabilityBar.get();
    }
}
