package com.sophicreeper.backmath.entity.custom;

import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.entity.ICrossbowUser;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;

import javax.annotation.Nullable;

public interface IBMCrossbowUser extends ICrossbowUser {
    void setCharging(boolean isCharging);

    void func_230284_a_(LivingEntity livEntity, ItemStack stack, ProjectileEntity projectile, float distanceFactor);

    // Gets the active target the Task system uses for tracking.
    @Nullable
    LivingEntity getAttackTarget();

    void func_230283_U__();

    default void func_234281_b_(LivingEntity livEntity, float velocity) {
        Hand hand = ProjectileHelper.getHandWith(livEntity, AxolotlTest.ANGELIC_CROSSBOW.get());
        ItemStack heldStack = livEntity.getHeldItem(hand);
        if (livEntity.canEquip(AxolotlTest.ANGELIC_CROSSBOW.get())) {
            CrossbowItem.fireProjectiles(livEntity.world, livEntity, hand, heldStack, velocity, (float) (14 - livEntity.world.getDifficulty().getId() * 4));
        }

        this.func_230283_U__();
    }

    default void func_234279_a_(LivingEntity shooter, LivingEntity target, ProjectileEntity arrow, float distanceFactor, float velocity) {
        double targetX = target.getPosX() - shooter.getPosX();
        double targetZ = target.getPosZ() - shooter.getPosZ();
        double sqrtTargetLoc = MathHelper.sqrt(targetX * targetX + targetZ * targetZ);
        double d3 = target.getPosYHeight(0.3333333333333333D) - arrow.getPosY() + sqrtTargetLoc * (double) 0.2F;

        Vector3f vec3F = this.func_234280_a_(shooter, new Vector3d(targetX, d3, targetZ), distanceFactor);
        arrow.shoot(vec3F.getX(), vec3F.getY(), vec3F.getZ(), velocity, (float) (14 - shooter.world.getDifficulty().getId() * 4));
        shooter.playSound(SoundEvents.ITEM_CROSSBOW_SHOOT, 1, 1 / (shooter.getRNG().nextFloat() * 0.4F + 0.8F));
    }

    default Vector3f func_234280_a_(LivingEntity livEntity, Vector3d vec3D, float distanceFactor) {
        Vector3d normVec3D = vec3D.normalize();
        Vector3d crossedVec3D = normVec3D.crossProduct(new Vector3d(0, 1, 0));
        if (crossedVec3D.lengthSquared() <= 1.0E-7D) {
            crossedVec3D = normVec3D.crossProduct(livEntity.getUpVector(1));
        }

        Quaternion quaternion = new Quaternion(new Vector3f(crossedVec3D), 90, true);
        Vector3f vec3F = new Vector3f(normVec3D);
        vec3F.transform(quaternion);
        Quaternion quaternion1 = new Quaternion(vec3F, distanceFactor, true);
        Vector3f normVec3F = new Vector3f(normVec3D);
        normVec3F.transform(quaternion1);
        return normVec3F;
    }
}
