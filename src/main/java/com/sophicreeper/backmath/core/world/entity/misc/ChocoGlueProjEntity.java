package com.sophicreeper.backmath.core.world.entity.misc;

import com.sophicreeper.backmath.core.world.entity.BMDamageSources;
import com.sophicreeper.backmath.core.world.entity.BMEntities;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
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
        super(BMEntities.CHOCOGLUE_PROJ.get(), shooter, world);
    }

    @Override
    protected Item getDefaultItem() {
        return AxolotlTest.CHOCOLATE.get();
    }

    @OnlyIn(Dist.CLIENT)
    private IParticleData makeParticle() {
        ItemStack stack = this.func_213882_k();
        return stack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemParticleData(ParticleTypes.ITEM, stack);
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte bite) {
        if (bite == 3) {
            IParticleData particleData = this.makeParticle();

            for (int i = 0; i < 8; ++i) {
                this.world.addParticle(particleData, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0, 0.0, 0.0);
            }
        }
    }

    protected void onEntityHit(EntityRayTraceResult result) {
        super.onEntityHit(result);
        Entity entity = result.getEntity();
        int random = rand.nextInt(5);
        entity.attackEntityFrom(BMDamageSources.CHOCOGLUED, random);
    }

    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte) 3);
            this.remove();
        }
    }
}
