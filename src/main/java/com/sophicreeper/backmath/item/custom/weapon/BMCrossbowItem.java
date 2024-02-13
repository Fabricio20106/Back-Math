package com.sophicreeper.backmath.item.custom.weapon;

import com.sophicreeper.backmath.util.BMTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;

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
            livEntity.setFire(5);
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    public boolean isCrossbow(ItemStack stack) {
        return stack.getItem().isIn(BMTags.Items.CROSSBOWS);
    }
}
