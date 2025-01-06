package com.sophicreeper.backmath.particle.custom;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class JanticalParticle extends SpriteTexturedParticle {
    private final double startX;
    private final double startY;
    private final double startZ;

    private JanticalParticle(ClientWorld world, double x, double y, double z, double speedX, double speedY, double speedZ) {
        super(world, x, y, z, speedX, speedY, speedZ);
        this.xd = x;
        this.yd = speedY;
        this.zd = speedZ;
        this.startX = x;
        this.startY = y;
        this.startZ = z;
        this.xo = x + speedX;
        this.yo = y + speedY;
        this.zo = z + speedZ;
        this.x = this.xo;
        this.y = this.yo;
        this.z = this.zo;
        this.quadSize = 0.1F * (this.random.nextFloat() * 0.5F + 0.2F);
        boolean bool = this.random.nextBoolean();
        this.rCol = bool ? 249 / 255F : 187 / 255F;
        this.gCol = bool ? 238 / 255F : 219 / 255F;
        this.bCol = bool ? 255 : 219 / 255F;
        this.hasPhysics = false;
        this.lifetime = (int) (Math.random() * 10) + 30;
    }

    @Override
    @Nonnull
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void move(double x, double y, double z) {
        this.setBoundingBox(this.getBoundingBox().move(x, y, z));
        this.setLocationFromBoundingbox();
    }

    @Override
    protected int getLightColor(float partialTicks) {
        return 16777215;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            float f = (float) this.age / (float) this.lifetime;
            f = 1 - f;
            float f1 = 1 - f;
            f1 = f1 * f1;
            f1 = f1 * f1;
            this.x = this.startX + this.xd * (double) f;
            this.y = this.startY + this.yd * (double) f - (double) (f1 * 1.2F);
            this.z = this.startZ + this.zd * (double) f;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite sprite;

        public Factory(IAnimatedSprite sprite) {
            this.sprite = sprite;
        }

        @Override
        public Particle createParticle(BasicParticleType particleType, ClientWorld world, double x, double y, double z, double speedX, double speedY, double speedZ) {
            JanticalParticle particle = new JanticalParticle(world, x, y, z, speedX, speedY, speedZ);
            particle.pickSprite(this.sprite);
            return particle;
        }
    }
}
