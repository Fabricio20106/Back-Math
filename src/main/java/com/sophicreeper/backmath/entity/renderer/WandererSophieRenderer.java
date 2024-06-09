package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.entity.custom.WandererSophie;
import com.sophicreeper.backmath.variant.wansophie.WandererSophieVariant;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WandererSophieRenderer extends TermianBipedRenderer<WandererSophie> {
    public WandererSophieRenderer(EntityRendererManager manager) {
        super(manager, 0.5F, true);
    }

    @Override
    public ResourceLocation getTextureLocation(WandererSophie sophie) {
        WandererSophieVariant variant = sophie.getRegistryVariant();
        return new ResourceLocation(variant.getTextureLocation().getNamespace(), "textures/" + variant.getTextureLocation().getPath() + ".png");
    }
}
