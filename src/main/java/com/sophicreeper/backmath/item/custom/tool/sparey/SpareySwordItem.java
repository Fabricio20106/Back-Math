package com.sophicreeper.backmath.item.custom.tool.sparey;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.item.custom.ToolBehaviors;
import com.sophicreeper.backmath.util.tag.BMEntityTypeTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class SpareySwordItem extends SwordItem implements ToolBehaviors {
    public SpareySwordItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    // When you hit an entity
    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity target) {
        if (target.getType().is(inSpareyEffectivesTag(stack))) {
            player.addEffect(getSpareyEffect(new EffectInstance(Effects.DAMAGE_BOOST, 200, 1), stack, player.level, "sparey_strength_effect"));
            // Gives Strength II effect for 10 secs.
        } else {
            player.addEffect(getSpareyEffect(new EffectInstance(Effects.WEAKNESS, 50, 2), stack, player.level, "sparey_weakness_effect"));
            // Gives Weakness III effect for 2.5 secs, but it rounds it up to 3 secs.
        }
        if (target.getType().is(BMEntityTypeTags.SPAREYS_PROHIBITED)) {
            player.addEffect(getSpareyEffect(new EffectInstance(Effects.WEAKNESS, 600, 64), stack, player.level, "sparey_prohibition_weakness_effect"));
            // Gives Weakness LXIII (63) for 30 secs.
        }
        return super.onLeftClickEntity(stack, player, target);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return BMConfigs.COMMON_CONFIGS.spareyCustomDurabilityBar.get();
    }
}
