package com.sophicreeper.backmath.entity.renderer.misc;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.misc.InsomniaArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class InsomniaArrowRenderer extends ArrowRenderer<InsomniaArrowEntity> {
    public InsomniaArrowRenderer(EntityRendererManager manager) {
        super(manager);
    }

    public ResourceLocation getTextureLocation(InsomniaArrowEntity arrow) {
        return BackMath.backMath("textures/entity/insomnia_arrow.png");
    }
}
