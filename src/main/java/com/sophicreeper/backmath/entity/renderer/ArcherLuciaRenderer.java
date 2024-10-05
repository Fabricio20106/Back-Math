package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.ArcherLuciaEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class ArcherLuciaRenderer extends TermianPlayerRenderer<ArcherLuciaEntity> {
    public ArcherLuciaRenderer(EntityRendererManager manager) {
        super(manager, 0.5F, false);
    }

    @Nonnull
    public ResourceLocation getTextureLocation(ArcherLuciaEntity lucia) {
        return BackMath.backMath("textures/entity/archer_lucia");
    }
}
