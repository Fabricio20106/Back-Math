package com.sophicreeper.backmath.item.custom.tool.midterm;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.item.custom.MidTermToolBehaviors;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class MidTermSpareyItem extends SwordItem implements MidTermToolBehaviors {
    public MidTermSpareyItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity target) {
        if (target.getType().is(inSpareyEffectivesTag(stack))) {
            player.addEffect(getSpareyEffect(new EffectInstance(Effects.DAMAGE_BOOST, 200, 1), stack, player.level, "sparey_strength_effect"));
            // Gives the sword user Strength II effect for 10 secs.
        } else {
            player.addEffect(getSpareyEffect(new EffectInstance(Effects.WEAKNESS, 50, 2), stack, player.level, "sparey_weakness_effect"));
            // Gives the sword user Weakness III effect for 2.5 secs (or 3 secs rounded).
        }
        if (target.getType().is(inSpareyProhibitedTag(stack))) {
            player.addEffect(getSpareyEffect(new EffectInstance(Effects.WEAKNESS, 600, 64), stack, player.level, "sparey_prohibition_weakness_effect"));
            // Gives Weakness LXIII (63) for 30 secs.
        }
        if (target instanceof LivingEntity) {
            LivingEntity livEntity = (LivingEntity) target;
            applyTagEffects(stack, livEntity);
            setOnFire(stack, livEntity, 10);
        }
        return super.onLeftClickEntity(stack, player, target);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return BMConfigs.COMMON_CONFIGS.midTermCustomDurabilityBar.get();
    }
}
