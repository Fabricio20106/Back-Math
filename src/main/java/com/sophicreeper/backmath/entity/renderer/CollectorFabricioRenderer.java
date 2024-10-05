package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.aljamic.CollectorFabricioEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class CollectorFabricioRenderer extends BMPlayerRenderer<CollectorFabricioEntity> {
    public CollectorFabricioRenderer(EntityRendererManager manager) {
        super(manager, 0.5F, true);
    }

    @Nonnull
    public ResourceLocation getTextureLocation(CollectorFabricioEntity collector) {
        return BackMath.entityTexture("fabricio/collector_fabricio");
    }
}
