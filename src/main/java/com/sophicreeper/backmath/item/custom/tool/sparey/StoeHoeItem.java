package com.sophicreeper.backmath.item.custom.tool.sparey;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.item.custom.ToolBehaviors;
import com.sophicreeper.backmath.util.tag.BMEntityTypeTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class StoeHoeItem extends HoeItem implements ToolBehaviors {
    public StoeHoeItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity target) {
        if (target.getType().is(inSpareyEffectivesTag(stack))) {
            player.addEffect(getSpareyEffect(new EffectInstance(Effects.DAMAGE_BOOST, 200, 1), stack, player.level, "sparey_strength_effect"));
        } else {
            player.addEffect(getSpareyEffect(new EffectInstance(Effects.WEAKNESS, 50, 2), stack, player.level, "sparey_weakness_effect"));
        }
        if (target.getType().is(BMEntityTypeTags.SPAREYS_PROHIBITED)) {
            player.addEffect(getSpareyEffect(new EffectInstance(Effects.WEAKNESS, 600, 64), stack, player.level, "sparey_prohibition_weakness_effect"));
        }
        return super.onLeftClickEntity(stack, player, target);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return BMConfigs.COMMON_CONFIGS.spareyCustomDurabilityBar.get();
    }
}
