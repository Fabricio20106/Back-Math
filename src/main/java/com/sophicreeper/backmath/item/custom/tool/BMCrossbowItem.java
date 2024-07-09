package com.sophicreeper.backmath.item.custom.tool;

import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class BMCrossbowItem extends CrossbowItem {
    private final boolean isDevilCrossbow;

    public BMCrossbowItem(boolean isDevilCrossbow, Properties properties) {
        super(properties);
        this.isDevilCrossbow = isDevilCrossbow;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof LivingEntity && this.isDevilCrossbow) {
            LivingEntity livEntity = (LivingEntity) entity;
            if (!livEntity.isInvulnerableTo(DamageSource.IN_FIRE) || !livEntity.isInvulnerableTo(DamageSource.ON_FIRE)) livEntity.setSecondsOnFire(5);
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public boolean useOnRelease(ItemStack stack) {
        return stack.getItem().is(BMTags.Items.CROSSBOWS);
    }
}
