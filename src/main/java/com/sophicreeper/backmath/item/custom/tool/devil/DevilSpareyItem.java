package com.sophicreeper.backmath.item.custom.tool.devil;

import com.sophicreeper.backmath.item.custom.ToolBehaviors;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class DevilSpareyItem extends SwordItem implements ToolBehaviors {
    public DevilSpareyItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity target) {
        if (target.getType().is(inSpareyProhibitedTag(stack))) {
            player.addEffect(getSpareyEffect(new EffectInstance(Effects.WEAKNESS, 600, 64), stack, player.level, "sparey_prohibition_weakness_effect"));
            // Give sword user hitting Queen Lucy Weakness LXIII (63) for 30 secs.
        }
        if (target.getType().is(inDevilSpareyEffectivesTag(stack))) {
            player.addEffect(getSpareyEffect(new EffectInstance(Effects.DAMAGE_BOOST, 50, 2), stack, player.level, "sparey_strength_effect"));
            // If the sword user hits one of these:
            // - Wanderer Sophie, Insomnia Sophie, Karate Lucia, Archer Lucia, Shy Fabricio or Warrior Sophie
            // Give player Strength III effect for 2.5 secs (or 3 secs rounded)
        } else {
            player.addEffect(getSpareyEffect(new EffectInstance(Effects.WEAKNESS, 200, 1), stack, player.level, "sparey_weakness_effect"));
            // Give user Weakness II for 10 secs.
        }
        if (target instanceof LivingEntity) setOnFire(stack, (LivingEntity) target);
        return super.onLeftClickEntity(stack, player, target);
    }
}
