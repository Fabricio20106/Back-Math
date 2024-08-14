package com.sophicreeper.backmath.entity.custom.misc;

import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.util.TagTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;

public class JanticBoltEntity extends AbstractArrowEntity {
    private ItemStack boltStack = new ItemStack(AxolotlTest.JANTICAL.get());

    public JanticBoltEntity(EntityType<? extends JanticBoltEntity> type, World world) {
        super(type, world);
        this.pickup = PickupStatus.CREATIVE_ONLY;
    }

    public JanticBoltEntity(World world, LivingEntity shooter, double x, double y, double z) {
        super(BMEntities.JANTIC_BOLT.get(), x, y, z, world);
        this.pickup = PickupStatus.CREATIVE_ONLY;
        this.setOwner(shooter);
    }

    public void setBoltStack(ItemStack boltStack) {
        this.boltStack = boltStack.copy();
    }

    @Override
    @Nonnull
    protected ItemStack getPickupItem() {
        return this.boltStack.copy();
    }

    @Override
    protected float getWaterInertia() {
        return 0.99F;
    }

    @Override
    public boolean isNoGravity() {
        return true;
    }

    @Override
    protected void onHit(RayTraceResult hitResult) {
        super.onHit(hitResult);
        this.level.explode(this.getOwner() == null ? this : this.getOwner(), this.getX(), this.getY(), this.getZ(), 6, Explosion.Mode.NONE);
        this.remove();
    }

    @Override
    public void tick() {
        super.tick();
        Vector3d vec3D = this.getDeltaMovement();
        double x = vec3D.x;
        double y = vec3D.y;
        double z = vec3D.z;
        for (int i = 0; i < 4; ++i) {
            RedstoneParticleData pinkParticleData = new RedstoneParticleData(249 / 255F, 238 / 255F, 255, 1);
            RedstoneParticleData blueParticleData = new RedstoneParticleData(187 / 255F, 219 / 255F, 219 / 255F, 1);
            this.level.addParticle(pinkParticleData, this.getX() + x * (double) i / 4, this.getY() + y * (double) i / 4, this.getZ() + z * (double) i / 4, -x, -y + 0.2D, -z);
            this.level.addParticle(blueParticleData, this.getX() + x * (double) i / 4, this.getY() + y * (double) i / 4, this.getZ() + z * (double) i / 4, -x, -y + 0.2D, -z);
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT tag) {
        super.addAdditionalSaveData(tag);
        tag.put("item", this.boltStack.save(new CompoundNBT()));
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("item", TagTypes.COMPOUND)) this.boltStack = ItemStack.of(tag.getCompound("item"));
    }

    @Override
    public void checkDespawn() {
        if (this.inGroundTime > 1200 || this.blockPosition().getY() >= 320 || this.blockPosition().getY() <= -64) this.remove();
    }

    @Override
    @Nonnull
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
