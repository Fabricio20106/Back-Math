package com.sophicreeper.backmath.item.custom.tool.devil;

import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;

public class DevilSpareySwordItem extends SwordItem {
    public DevilSpareySwordItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity target) {
        if (target.getType().is(BMTags.EntityTypes.DEVIL_SPAREY_EFFECTIVES)) {
            player.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 50, 2));
            // If the sword user hits one of these:
            // - Wanderer Sophie, Insomnia Sophie, Karate Lucia, Archer Lucia, Shy Fabricio or Warrior Sophie
            // Give player Strength III effect for 2.5 secs (or 3 secs rounded)
        } else {
            player.addEffect(new EffectInstance(Effects.WEAKNESS, 200, 1));
            // Give user Weakness II for 10 secs.
        }
        if (target.getType().is(BMTags.EntityTypes.SPAREYS_PROHIBITED)) {
            player.addEffect(new EffectInstance(Effects.WEAKNESS, 600, 64));
            // Give sword user hitting Queen Lucy Weakness LXIII (63) for 30 secs.
        }
        if (target instanceof LivingEntity) {
            LivingEntity livEntity = (LivingEntity) target;
            if (!livEntity.isInvulnerableTo(DamageSource.IN_FIRE) || !livEntity.isInvulnerableTo(DamageSource.ON_FIRE)) livEntity.setSecondsOnFire(5);
        }
        return super.onLeftClickEntity(stack, player, target);
    }
}
