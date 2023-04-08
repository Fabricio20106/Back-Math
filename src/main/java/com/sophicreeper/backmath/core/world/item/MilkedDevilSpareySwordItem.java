package com.sophicreeper.backmath.core.world.item;

import com.sophicreeper.backmath.core.util.BMSetFields;
import com.sophicreeper.backmath.core.world.entity.creature.KarateLucia;
import com.sophicreeper.backmath.core.world.entity.creature.ShyFabricio;
import com.sophicreeper.backmath.core.world.entity.creature.WandererSophie;
import com.sophicreeper.backmath.core.world.entity.monster.ArcherLucia;
import com.sophicreeper.backmath.core.world.entity.monster.InsomniaSophie;
import com.sophicreeper.backmath.core.world.entity.monster.QueenSophie;
import com.sophicreeper.backmath.core.world.entity.monster.WarriorSophie;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class MilkedDevilSpareySwordItem extends MilkedSwordItem {
    public MilkedDevilSpareySwordItem() {
        super(BMSetFields.SPAREY_SET, 3, -2.4F, new Properties().rarity(Rarity.UNCOMMON).group(BMWeaponryTab.TAB));
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof WandererSophie || entity instanceof InsomniaSophie || entity instanceof KarateLucia || entity instanceof ArcherLucia || entity instanceof ShyFabricio || entity instanceof WarriorSophie) {
            player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 50, 2));
        } else {
            player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 200, 1));
        }
        if (entity instanceof QueenSophie) {
            player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 600, 64));
        }
        return super.onLeftClickEntity(stack, player, entity);
    }
}
