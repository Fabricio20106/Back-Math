package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.aljamic.ShyFabricioEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class ShyFabricioRenderer extends BMPlayerRenderer<ShyFabricioEntity> {
    public ShyFabricioRenderer(EntityRendererManager manager) {
        super(manager, 0.5F, false);
    }

    @Nonnull
    public ResourceLocation getTextureLocation(ShyFabricioEntity fabricio) {
        return BackMath.entityTexture("fabricio/shy_fabricio");
    }
}
