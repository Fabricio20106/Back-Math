package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.QueenLucyEntity;
import com.sophicreeper.backmath.entity.renderer.layer.QueenLucyEmissiveLayer;
import com.sophicreeper.backmath.variant.queenlucy.QueenLucyVariant;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class QueenLucyRenderer extends TermianPlayerRenderer<QueenLucyEntity> {
    public QueenLucyRenderer(EntityRendererManager manager) {
        super(manager, 0.5F, true);
        this.addLayer(new QueenLucyEmissiveLayer(this));
    }

    @Nonnull
    public ResourceLocation getTextureLocation(QueenLucyEntity lucy) {
        try {
            QueenLucyVariant variant = lucy.getRegistryVariant();
            return new ResourceLocation(variant.getTextureLocation().getNamespace(), "textures/" + variant.getTextureLocation().getPath() + ".png");
        } catch (NullPointerException exception) {
            return BackMath.entityTexture("queen_lucy/current");
        }
    }
}
