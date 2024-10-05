package com.sophicreeper.backmath.entity.renderer.misc;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.misc.InsomniaArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class InsomniaArrowRenderer extends ArrowRenderer<InsomniaArrowEntity> {
    public InsomniaArrowRenderer(EntityRendererManager manager) {
        super(manager);
    }

    @Nonnull
    public ResourceLocation getTextureLocation(InsomniaArrowEntity arrow) {
        return BackMath.entityTexture("projectile/insomnia_arrow");
    }
}
