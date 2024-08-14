package com.sophicreeper.backmath.item.custom.tool.devil;

import com.sophicreeper.backmath.item.custom.tool.MilkedSwordItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
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
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity target) {
        if (target.getType().is(inDevilSpareyEffectivesTag(stack))) {
            player.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 50, 2));
        } else {
            player.addEffect(new EffectInstance(Effects.WEAKNESS, 200, 1));
        }
        // Queen Lucy
        if (target.getType().is(inSpareyProhibitedTag(stack))) {
            player.addEffect(new EffectInstance(Effects.WEAKNESS, 600, 64));
        }
        if (target instanceof LivingEntity) setOnFire(stack, (LivingEntity) target);
        return super.onLeftClickEntity(stack, player, target);
    }
}
