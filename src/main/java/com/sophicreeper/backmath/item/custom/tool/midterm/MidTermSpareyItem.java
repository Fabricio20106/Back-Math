package com.sophicreeper.backmath.item.custom.tool.midterm;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class MidTermSpareyItem extends MidTermSwordItem {
    public MidTermSpareyItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity target) {
        if (target.getType().is(inSpareyProhibitedTag(stack))) {
            player.addEffect(getSpareyEffect(new EffectInstance(Effects.WEAKNESS, 600, 64), stack, player.level, "prohibition_weakness_effect"));
            // Gives Weakness LXIII (63) for 30 secs.
        } else if (target.getType().is(inSpareyEffectivesTag(stack))) {
            player.addEffect(getSpareyEffect(new EffectInstance(Effects.DAMAGE_BOOST, 200, 1), stack, player.level, "strength_effect"));
            // Gives the sword user Strength II effect for 10 secs.
        } else {
            player.addEffect(getSpareyEffect(new EffectInstance(Effects.WEAKNESS, 50, 2), stack, player.level, "weakness_effect"));
            // Gives the sword user Weakness III effect for 2.5 secs (or 3 secs rounded).
        }
        return super.onLeftClickEntity(stack, player, target);
    }
}
