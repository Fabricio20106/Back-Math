package com.sophicreeper.backmath.item.custom.tool;

import com.sophicreeper.backmath.item.custom.ToolBehaviors;
import com.sophicreeper.backmath.util.tag.BMItemTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;

public class BMCrossbowItem extends CrossbowItem implements ToolBehaviors {
    private final boolean isDevilCrossbow;

    public BMCrossbowItem(boolean isDevilCrossbow, Properties properties) {
        super(properties);
        this.isDevilCrossbow = isDevilCrossbow;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof LivingEntity && this.isDevilCrossbow) setOnFire(stack, (LivingEntity) entity);
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public boolean useOnRelease(ItemStack stack) {
        return stack.getItem().is(BMItemTags.CROSSBOWS);
    }
}
