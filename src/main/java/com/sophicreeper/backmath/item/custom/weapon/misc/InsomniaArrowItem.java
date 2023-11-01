package com.sophicreeper.backmath.item.custom.weapon.misc;

import com.sophicreeper.backmath.entity.custom.InsomniaArrow;
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
