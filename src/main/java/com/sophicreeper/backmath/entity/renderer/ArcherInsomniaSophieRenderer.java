package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.ArcherInsomniaSophieEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ArcherInsomniaSophieRenderer extends TermianPlayerRenderer<ArcherInsomniaSophieEntity> {
    public ArcherInsomniaSophieRenderer(EntityRendererManager manager) {
        super(manager, 0.5F, false);
    }

    public ResourceLocation getTextureLocation(ArcherInsomniaSophieEntity sophie) {
        return BackMath.backMath("textures/entity/insomnia_sophie.png");
    }
}
