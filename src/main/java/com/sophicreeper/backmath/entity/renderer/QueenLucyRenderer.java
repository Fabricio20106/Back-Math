package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.QueenLucyEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class QueenLucyRenderer extends TermianPlayerRenderer<QueenLucyEntity> {
    public QueenLucyRenderer(EntityRendererManager manager) {
        super(manager, 0.5F, true);
    }

    @Override
    public ResourceLocation getTextureLocation(QueenLucyEntity lucy) {
        return BackMath.backMath("textures/entity/queen_lucy/current.png");
    }
}
