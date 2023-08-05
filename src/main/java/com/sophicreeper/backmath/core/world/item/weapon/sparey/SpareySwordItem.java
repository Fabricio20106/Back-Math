package com.sophicreeper.backmath.core.world.item.weapon.sparey;

import com.sophicreeper.backmath.core.util.BMSetFields;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;

public class SpareySwordItem extends SwordItem {
    public SpareySwordItem() {
        super(BMSetFields.SPAREY_SET, 3, -2.4F, new Properties().fireResistant().rarity(Rarity.RARE));
    }

    // When you hit an entity
    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity hitTarget) {
        //if (hitTarget instanceof AngrySophie) {
        //    player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 200, 1));
            // Gives Strength II effect for 10 secs.
        //} else {
            player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 50, 2));
            // Gives Weakness III effect for 2.5 secs, but it rounds it up to 3 secs.
        //}
        //if (hitTarget instanceof QueenSophie) {
        //    player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 600, 64));
            // Gives Weakness LXIII (63) for 30 secs.
        //}
        return super.onLeftClickEntity(stack, player, hitTarget);
    }

    //@Override
    //public int getRGBDurabilityForDisplay(ItemStack stack) {
    //    return 0x85c284;
    //}
}
