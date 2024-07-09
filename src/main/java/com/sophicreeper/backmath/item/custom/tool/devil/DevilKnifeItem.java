package com.sophicreeper.backmath.item.custom.tool.devil;

import com.sophicreeper.backmath.item.custom.tool.KnifeItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class DevilKnifeItem extends KnifeItem {
    public DevilKnifeItem(float attackDamage, float swingSpeed, IItemTier tier, Properties properties) {
        super(attackDamage, swingSpeed, tier, properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livEntity = (LivingEntity) entity;
            if (!livEntity.isInvulnerableTo(DamageSource.IN_FIRE) || !livEntity.isInvulnerableTo(DamageSource.ON_FIRE)) livEntity.setSecondsOnFire(5);
        }
        return super.onLeftClickEntity(stack, player, entity);
    }
}
