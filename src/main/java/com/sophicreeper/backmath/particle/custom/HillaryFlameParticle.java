package com.sophicreeper.backmath.particle.custom;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class HillaryFlameParticle extends DeceleratingParticle {
    private HillaryFlameParticle(ClientWorld world, double x, double y, double z, double speedX, double speedY, double speedZ) {
        super(world, x, y, z, speedX, speedY, speedZ);
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
    public float getQuadSize(float scaleFactor) {
        float f = ((float) this.age + scaleFactor) / (float) this.lifetime;
        return this.quadSize * (1 - f * f * 0.5F);
    }

    @Override
    public int getLightColor(float partialTicks) {
        float f = ((float) this.age + partialTicks) / (float) this.lifetime;
        f = MathHelper.clamp(f, 0, 1);
        int lightColor = super.getLightColor(partialTicks);
        int j = lightColor & 255;
        int k = lightColor >> 16 & 255;
        j = j + (int) (f * 15 * 16);
        if (j > 240) j = 240;

        return j | k << 16;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite sprite;

        public Factory(IAnimatedSprite sprite) {
            this.sprite = sprite;
        }

        @Override
        public Particle createParticle(BasicParticleType particleType, ClientWorld world, double x, double y, double z, double speedX, double speedY, double speedZ) {
            HillaryFlameParticle particle = new HillaryFlameParticle(world, x, y, z, speedX, speedY, speedZ);
            particle.pickSprite(this.sprite);
            return particle;
        }
    }
}
