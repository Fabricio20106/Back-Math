package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.KarateLucia;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KarateLuciaRenderer extends TermianBipedRenderer<KarateLucia> {
    public KarateLuciaRenderer(EntityRendererManager manager) {
        super(manager, 0.5F, false);
    }

    public ResourceLocation getTextureLocation(KarateLucia lucia) {
        return BackMath.resourceLoc("textures/entity/karate_lucia.png");
    }
}
