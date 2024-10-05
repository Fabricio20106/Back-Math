package com.sophicreeper.backmath.entity.renderer.misc;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.misc.JanticBoltEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class JanticBoltRenderer extends ArrowRenderer<JanticBoltEntity> {
    public JanticBoltRenderer(EntityRendererManager manager) {
        super(manager);
    }

    @Nonnull
    public ResourceLocation getTextureLocation(JanticBoltEntity bolt) {
        return BackMath.entityTexture("projectile/jantic_bolt");
    }
}
