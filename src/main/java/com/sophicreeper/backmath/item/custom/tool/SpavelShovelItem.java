package com.sophicreeper.backmath.item.custom.tool;

import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class SpavelShovelItem extends ShovelItem {
    public SpavelShovelItem(IItemTier tier, float attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity.getType().isContained(BMTags.EntityTypes.SPAREY_EFFECTIVES)) {
            player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 200, 1));
        } else {
            player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 50, 2));
        }
        if (entity.getType().isContained(BMTags.EntityTypes.SPAREYS_PROHIBITED)) {
            player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 600, 64));
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return BMConfigs.COMMON_CONFIGS.spareyCustomDurabilityBar.get();
    }
}
