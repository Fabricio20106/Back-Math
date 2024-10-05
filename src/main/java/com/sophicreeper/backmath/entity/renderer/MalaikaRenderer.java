package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.aljan.MalaikaEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class MalaikaRenderer extends BMPlayerRenderer<MalaikaEntity> {
    public MalaikaRenderer(EntityRendererManager manager) {
        super(manager, 0.5F, false);
    }

    @Nonnull
    public ResourceLocation getTextureLocation(MalaikaEntity malaika) {
        return BackMath.entityTexture("malaika");
    }
}
