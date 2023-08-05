package com.sophicreeper.backmath.core.world.item.weapon.sparey;

import com.sophicreeper.backmath.core.util.BMSetFields;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;

public class DevilSpareySwordItem extends SwordItem {
    public DevilSpareySwordItem() {
        super(BMSetFields.SPAREY_SET, 3, -2.4F, new Properties().rarity(Rarity.UNCOMMON));
    }

    // When hitting an entity:
    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity hitTarget) {
        //if (hitTarget instanceof WandererSophie || hitTarget instanceof InsomniaSophie || hitTarget instanceof KarateLucia || hitTarget instanceof ArcherLucia || hitTarget instanceof ShyFabricio ||
        //        hitTarget instanceof WarriorSophie || hitTarget instanceof ArcherInsomniaSophie) {
        //    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 50, 2));
            // If the sword user hits one of these:
            // - Wanderer Sophie, Insomnia Sophie, Karate Lucia, Archer Lucia, Shy Fabricio or Warrior Sophie
            // Give player Strength III effect for 2.5 secs (or 3 secs rounded)
        //} else {
            player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 1));
            // Give user Weakness II for 10 secs.
        //}
        //if (hitTarget instanceof QueenSophie) {
        //    player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 600, 64));
            // Give sword user hitting Queen Sophie Weakness LXIII (63) for 30 secs.
        //}
        return super.onLeftClickEntity(stack, player, hitTarget);
    }
}
