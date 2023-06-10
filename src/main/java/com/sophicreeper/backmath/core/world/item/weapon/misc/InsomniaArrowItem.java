package com.sophicreeper.backmath.core.world.item.weapon.misc;

import com.sophicreeper.backmath.core.world.entity.misc.InsomniaArrow;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class InsomniaArrowItem extends ArrowItem {
    public InsomniaArrowItem(Properties properties) {
        super(properties);
    }

    public AbstractArrowEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        return new InsomniaArrow(world, shooter);
    }
}
