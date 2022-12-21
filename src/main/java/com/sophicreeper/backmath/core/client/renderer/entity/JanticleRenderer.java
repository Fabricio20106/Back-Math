package com.sophicreeper.backmath.core.client.renderer.entity;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.world.entity.monster.aljan.Janticle;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class JanticleRenderer extends EntityRenderer<Janticle> {
    public static final ResourceLocation JANTICLE_LOCATION = BackMath.resourceLoc("textures/entity/janticle.png");

    public JanticleRenderer(EntityRendererManager rendererManager) {
        super(rendererManager);
    }

    @Override
    public ResourceLocation getEntityTexture(Janticle janticle) {
        return JANTICLE_LOCATION;
    }
}
