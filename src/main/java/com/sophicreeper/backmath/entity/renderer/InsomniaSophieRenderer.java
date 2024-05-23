package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.InsomniaSophie;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class InsomniaSophieRenderer extends TermianBipedRenderer<InsomniaSophie> {
    public InsomniaSophieRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, 0.5F, false);
    }

    public ResourceLocation getTextureLocation(InsomniaSophie sophie) {
        return BackMath.resourceLoc("textures/entity/insomnia_sophie.png");
    }
}
