package com.sophicreeper.backmath.core.world.item.tool;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class DevilKnifeItem extends KnifeItem {
    public DevilKnifeItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        entity.setSecondsOnFire(5);
        return super.onLeftClickEntity(stack, player, entity);
    }
}
