package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.KarateLuciaEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class KarateLuciaRenderer extends TermianPlayerRenderer<KarateLuciaEntity> {
    public KarateLuciaRenderer(EntityRendererManager manager) {
        super(manager, 0.5F, false);
    }

    @Nonnull
    public ResourceLocation getTextureLocation(KarateLuciaEntity lucia) {
        return BackMath.entityTexture("lucia/karate_lucia");
    }
}
