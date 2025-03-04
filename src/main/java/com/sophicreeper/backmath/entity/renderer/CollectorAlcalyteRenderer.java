package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.alcalyte.CollectorAlcalyteEntity;
import com.sophicreeper.backmath.entity.renderer.layer.BreastLayer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class CollectorAlcalyteRenderer extends BMPlayerRenderer<CollectorAlcalyteEntity> {
    public CollectorAlcalyteRenderer(EntityRendererManager manager) {
        super(manager, 0.5F, true);
        this.addLayer(new BreastLayer<>(this));
    }

    @Nonnull
    public ResourceLocation getTextureLocation(CollectorAlcalyteEntity collector) {
        return BackMath.entityTexture("alcalyte/collector_alcalyte");
    }
}
