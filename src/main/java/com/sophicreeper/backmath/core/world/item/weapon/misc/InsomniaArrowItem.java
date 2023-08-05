package com.sophicreeper.backmath.core.world.item.weapon.misc;

import com.sophicreeper.backmath.core.world.entity.misc.InsomniaArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class InsomniaArrowItem extends ArrowItem {
    public InsomniaArrowItem(Properties properties) {
        super(properties);
    }

    public AbstractArrow createArrow(Level world, ItemStack stack, LivingEntity shooter) {
        return new InsomniaArrow(world, shooter);
    }
}
