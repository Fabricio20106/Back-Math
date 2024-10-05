package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.entity.custom.WandererSophieEntity;
import com.sophicreeper.backmath.variant.wansophie.WandererSophieVariant;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class WandererSophieRenderer extends TermianPlayerRenderer<WandererSophieEntity> {
    public WandererSophieRenderer(EntityRendererManager manager) {
        super(manager, 0.5F, true);
    }

    @Nonnull
    public ResourceLocation getTextureLocation(WandererSophieEntity sophie) {
        WandererSophieVariant variant = sophie.getRegistryVariant();
        return new ResourceLocation(variant.getTextureLocation().getNamespace(), "textures/" + variant.getTextureLocation().getPath() + ".png");
    }
}
