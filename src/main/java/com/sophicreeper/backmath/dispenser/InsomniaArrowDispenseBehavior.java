package com.sophicreeper.backmath.dispenser;

import com.sophicreeper.backmath.entity.custom.misc.InsomniaArrowEntity;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.ProjectileDispenseBehavior;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class InsomniaArrowDispenseBehavior extends ProjectileDispenseBehavior {
    @Override
    @Nonnull
    protected ProjectileEntity getProjectile(World world, IPosition pos, ItemStack stack) {
        InsomniaArrowEntity insomniaArrow = new InsomniaArrowEntity(world, pos.x(), pos.y(), pos.z());
        insomniaArrow.pickup = AbstractArrowEntity.PickupStatus.ALLOWED;
        return insomniaArrow;
    }
}
