package com.sophicreeper.backmath.core.client.renderer.entity;

import com.sophicreeper.backmath.core.client.BackMath;
import com.sophicreeper.backmath.core.world.entity.misc.InsomniaArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class InsomniaArrowRenderer extends ArrowRenderer<InsomniaArrow> {
    public static final ResourceLocation INSOMNIA_ARROW = BackMath.resourceLoc("textures/entity/insomnia_arrow.png");

    public InsomniaArrowRenderer(EntityRendererManager renderManager) {
        super(renderManager);
    }

    public ResourceLocation getEntityTexture(InsomniaArrow arrow) {
        return INSOMNIA_ARROW;
    }
}
