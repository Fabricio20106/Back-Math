package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.InsomniaArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class InsomniaArrowRenderer extends ArrowRenderer<InsomniaArrow> {
    public InsomniaArrowRenderer(EntityRendererManager manager) {
        super(manager);
    }

    public ResourceLocation getTextureLocation(InsomniaArrow arrow) {
        return BackMath.resourceLoc("textures/entity/insomnia_arrow.png");
    }
}
