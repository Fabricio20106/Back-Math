package com.sophicreeper.backmath.item.custom.tool.sparey;

import com.sophicreeper.backmath.item.custom.tool.MilkedSwordItem;
import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class MilkedSpareySwordItem extends MilkedSwordItem {
    public MilkedSpareySwordItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity.getType().is(BMTags.EntityTypes.SPAREY_EFFECTIVES)) {
            player.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 200, 1));
        } else {
            player.addEffect(new EffectInstance(Effects.WEAKNESS, 50, 2));
        }
        if (entity.getType().is(BMTags.EntityTypes.SPAREYS_PROHIBITED)) {
            player.addEffect(new EffectInstance(Effects.WEAKNESS, 600, 64));
        }
        return super.onLeftClickEntity(stack, player, entity);
    }
}
