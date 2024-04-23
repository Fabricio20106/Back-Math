package com.sophicreeper.backmath.item.custom.weapon.misc;

import com.sophicreeper.backmath.entity.custom.InsomniaArrow;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.ProjectileDispenseBehavior;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class InsomniaArrowItem extends ArrowItem {
    public InsomniaArrowItem(Properties properties) {
        super(properties);
        DispenserBlock.registerBehavior(this, new ProjectileDispenseBehavior() {
            @Override
            protected ProjectileEntity getProjectile(World world, IPosition pos, ItemStack stack) {
                InsomniaArrow insomniaArrow = new InsomniaArrow(world, pos.x(), pos.y(), pos.z());
                insomniaArrow.pickup = AbstractArrowEntity.PickupStatus.ALLOWED;
                return insomniaArrow;
            }
        });
    }

    public AbstractArrowEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        return new InsomniaArrow(world, shooter);
    }
}
