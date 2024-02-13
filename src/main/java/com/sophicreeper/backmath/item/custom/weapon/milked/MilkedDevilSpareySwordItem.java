package com.sophicreeper.backmath.item.custom.weapon.milked;

import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class MilkedDevilSpareySwordItem extends MilkedSwordItem {
    public MilkedDevilSpareySwordItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity.getType().isContained(BMTags.EntityTypes.DEVIL_SPAREY_EFFECTIVES)) {
            player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 50, 2));
        } else {
            player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 200, 1));
        }
        // Queen Lucy
        if (entity.getType().isContained(BMTags.EntityTypes.SPAREYS_PROHIBITED)) {
            player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 600, 64));
        }
        return super.onLeftClickEntity(stack, player, entity);
    }
}
