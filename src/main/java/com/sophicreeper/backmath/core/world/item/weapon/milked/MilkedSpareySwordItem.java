package com.sophicreeper.backmath.core.world.item.weapon.milked;

import com.sophicreeper.backmath.core.util.BMSetFields;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class MilkedSpareySwordItem extends MilkedSwordItem {
    public MilkedSpareySwordItem() {
        super(BMSetFields.SPAREY_SET, 3, -2.4F, new Properties().fireResistant().rarity(Rarity.RARE));
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        //if (entity instanceof AngrySophie) {
       //     player.addEffect(new MobEffectInstance(MobEffects.STRENGTH, 200, 1));
        //} else {
        player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 50, 2));
       // }
       // if (entity instanceof QueenSophie) {
        //    player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 600, 64));
        //}
        return super.onLeftClickEntity(stack, player, entity);
    }
}
