package com.sophicreeper.backmath.entity.renderer.aljan;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.aljan.JanticleEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class JanticleRenderer extends EntityRenderer<JanticleEntity> {
    public JanticleRenderer(EntityRendererManager manager) {
        super(manager);
    }

    @Nonnull
    public ResourceLocation getTextureLocation(JanticleEntity janticle) {
        return BackMath.entityTexture("janticle");
    }
}
