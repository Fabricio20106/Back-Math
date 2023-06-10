package com.sophicreeper.backmath.core.world.item.weapon.sparey;

import com.sophicreeper.backmath.core.util.BMSetFields;
import com.sophicreeper.backmath.core.world.entity.creature.KarateLucia;
import com.sophicreeper.backmath.core.world.entity.creature.ShyFabricio;
import com.sophicreeper.backmath.core.world.entity.creature.WandererSophie;
import com.sophicreeper.backmath.core.world.entity.monster.*;
import com.sophicreeper.backmath.core.world.item.BMWeaponryTab;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class DevilSpareySwordItem extends SwordItem {
    public DevilSpareySwordItem() {
        super(BMSetFields.SPAREY_SET, 3, -2.4F, new Properties().rarity(Rarity.UNCOMMON).group(BMWeaponryTab.TAB));
    }

    // When hitting an entity:
    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity hitTarget) {
        if (hitTarget instanceof WandererSophie || hitTarget instanceof InsomniaSophie || hitTarget instanceof KarateLucia || hitTarget instanceof ArcherLucia || hitTarget instanceof ShyFabricio ||
                hitTarget instanceof WarriorSophie || hitTarget instanceof ArcherInsomniaSophie) {
            player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 50, 2));
            // If the sword user hits one of these:
            // - Wanderer Sophie, Insomnia Sophie, Karate Lucia, Archer Lucia, Shy Fabricio or Warrior Sophie
            // Give player Strength III effect for 2.5 secs (or 3 secs rounded)
        } else {
            player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 200, 1));
            // Give user Weakness II for 10 secs.
        }
        if (hitTarget instanceof QueenSophie) {
            player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 600, 64));
            // Give sword user hitting Queen Sophie Weakness LXIII (63) for 30 secs.
        }
        return super.onLeftClickEntity(stack, player, hitTarget);
    }
}
