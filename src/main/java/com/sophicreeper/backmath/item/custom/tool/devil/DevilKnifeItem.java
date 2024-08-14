package com.sophicreeper.backmath.item.custom.tool.devil;

import com.sophicreeper.backmath.item.custom.ToolBehaviors;
import com.sophicreeper.backmath.item.custom.tool.KnifeItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class DevilKnifeItem extends KnifeItem implements ToolBehaviors {
    public DevilKnifeItem(float attackDamage, float swingSpeed, IItemTier tier, Properties properties) {
        super(attackDamage, swingSpeed, tier, properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof LivingEntity) setOnFire(stack, (LivingEntity) entity);
        return super.onLeftClickEntity(stack, player, entity);
    }
}
