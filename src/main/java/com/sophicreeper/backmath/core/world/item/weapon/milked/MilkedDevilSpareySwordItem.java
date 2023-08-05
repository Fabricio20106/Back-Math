package com.sophicreeper.backmath.core.world.item.weapon.milked;

import com.sophicreeper.backmath.core.util.BMSetFields;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class MilkedDevilSpareySwordItem extends MilkedSwordItem {
    public MilkedDevilSpareySwordItem() {
        super(BMSetFields.SPAREY_SET, 3, -2.4F, new Properties().rarity(Rarity.UNCOMMON));
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
       // if (entity instanceof WandererSophie || entity instanceof InsomniaSophie || entity instanceof KarateLucia || entity instanceof ArcherLucia || entity instanceof ShyFabricio || entity instanceof WarriorSophie) {
       //     player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 50, 2));
        //} else {
        player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 1));
        //}
        //if (entity instanceof QueenSophie) {
        //    player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 600, 64));
        //}
        return super.onLeftClickEntity(stack, player, entity);
    }
}
