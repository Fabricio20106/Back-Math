package com.sophicreeper.backmath.item.custom.tool.sparey;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class SpareySwordItem extends SwordItem {
    public SpareySwordItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    // When you hit an entity
    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity hitTarget) {
        if (hitTarget.getType().is(BMTags.EntityTypes.SPAREY_EFFECTIVES)) {
            player.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 200, 1));
            // Gives Strength II effect for 10 secs.
        } else {
            player.addEffect(new EffectInstance(Effects.WEAKNESS, 50, 2));
            // Gives Weakness III effect for 2.5 secs, but it rounds it up to 3 secs.
        }
        if (hitTarget.getType().is(BMTags.EntityTypes.SPAREYS_PROHIBITED)) {
            player.addEffect(new EffectInstance(Effects.WEAKNESS, 600, 64));
            // Gives Weakness LXIII (63) for 30 secs.
        }
        return super.onLeftClickEntity(stack, player, hitTarget);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return BMConfigs.COMMON_CONFIGS.spareyCustomDurabilityBar.get();
    }
}
