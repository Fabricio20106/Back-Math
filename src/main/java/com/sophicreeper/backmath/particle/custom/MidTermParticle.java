package com.sophicreeper.backmath.particle.custom;

import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MidTermParticle extends SimpleAnimatedParticle {
    private MidTermParticle(ClientWorld world, int fadeColor, double speedX, double speedY, double speedZ, double x, double y, double z, IAnimatedSprite sprite) {
        super(world, speedX, speedY, speedZ, sprite, -5.0E-4F);
        this.xd = x;
        this.yd = y;
        this.zd = z;
        this.quadSize *= 0.75F;
        this.lifetime = 60 + this.random.nextInt(12);
        this.setFadeColor(fadeColor);
        this.setSpriteFromAge(sprite);
    }

    @Override
    public int getLightColor(float partialTicks) {
        return LightTexture.pack(15, 15);
    }

    @Override
    public void move(double x, double y, double z) {
        this.setBoundingBox(this.getBoundingBox().move(x, y, z));
        this.setLocationFromBoundingbox();
    }

    @OnlyIn(Dist.CLIENT)
    public static class WarmtermFactory implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite sprites;

        public WarmtermFactory(IAnimatedSprite sprite) {
            this.sprites = sprite;
        }

        public Particle createParticle(BasicParticleType particleType, ClientWorld world, double speedX, double speedY, double speedZ, double x, double y, double z) {
            return new MidTermParticle(world, 0xFFAE00, speedX, speedY, speedZ, x, y, z, this.sprites);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class ColdtermFactory implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite sprites;

        public ColdtermFactory(IAnimatedSprite sprite) {
            this.sprites = sprite;
        }

        public Particle createParticle(BasicParticleType particleType, ClientWorld world, double speedX, double speedY, double speedZ, double x, double y, double z) {
            return new MidTermParticle(world, 0x0097B4, speedX, speedY, speedZ, x, y, z, this.sprites);
        }
    }
}
