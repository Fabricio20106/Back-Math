package com.sophicreeper.backmath.core.world.item.weapon.milked;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class MilkedDevilSwordItem extends MilkedSwordItem {
    public MilkedDevilSwordItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        entity.setSecondsOnFire(5);
        return super.onLeftClickEntity(stack, player, entity);
    }
}
