package com.sophicreeper.backmath.entity.custom;

import com.sophicreeper.backmath.entity.BMDamageSources;
import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ChocoGlueProjEntity extends ProjectileItemEntity {
    public ChocoGlueProjEntity(EntityType<? extends ProjectileItemEntity> type, World world) {
        super(type, world);
    }

    public ChocoGlueProjEntity(World world, LivingEntity shooter) {
        super(BMEntities.CHOCOGLUE_PROJECTILE.get(), shooter, world);
    }

    @Override
    protected Item getDefaultItem() {
        return AxolotlTest.CHOCOLATE.get();
    }

    @OnlyIn(Dist.CLIENT)
    private IParticleData makeParticle() {
        ItemStack stack = this.getItemRaw();
        return stack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemParticleData(ParticleTypes.ITEM, stack);
    }

    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        if (id == 3) {
            IParticleData particleData = this.makeParticle();

            for (int i = 0; i < 8; ++i) {
                this.level.addParticle(particleData, this.getX(), this.getY(), this.getZ(), 0, 0, 0);
            }
        }
    }

    protected void onHitEntity(EntityRayTraceResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        int rand = random.nextInt(5);
        entity.hurt(BMDamageSources.CHOCOGLUED, rand);
    }

    protected void onHit(RayTraceResult result) {
        super.onHit(result);
        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte) 3);
            this.remove();
        }
    }
}
