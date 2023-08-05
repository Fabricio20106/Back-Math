package com.sophicreeper.backmath.core.world.entity.misc;

import com.sophicreeper.backmath.core.world.entity.BMEntities;
import com.sophicreeper.backmath.core.world.item.AxolotlTest;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ChocoGlueProjEntity extends ThrowableItemProjectile {
    public ChocoGlueProjEntity(EntityType<? extends ThrowableItemProjectile> type, Level world) {
        super(type, world);
    }

    public ChocoGlueProjEntity(Level world, LivingEntity shooter) {
        super(BMEntities.CHOCOGLUE_PROJ.get(), shooter, world);
    }

    @Override
    protected Item getDefaultItem() {
        return AxolotlTest.CHOCOLATE.get();
    }

    @OnlyIn(Dist.CLIENT)
    private ParticleOptions getParticle() {
        ItemStack stack = this.getItemRaw();
        return stack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemParticleOption(ParticleTypes.ITEM, stack);
    }

    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte bite) {
        if (bite == 3) {
            ParticleOptions particleData = this.getParticle();

            for (int i = 0; i < 8; ++i) {
                this.level().addParticle(particleData, this.getX(), this.getY(), this.getZ(), 0, 0, 0);
            }
        }
    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        int random = RandomSource.create().nextInt(5);
        //entity.attackEntityFrom(BMDamageSources.CHOCOGLUED, random);
    }

    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }
}
