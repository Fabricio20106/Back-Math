package com.sophicreeper.backmath.entity.renderer.layer;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.aljan.SleepishSkeletonEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.AbstractEyesLayer;
import net.minecraft.client.renderer.entity.model.SkeletonModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class SleepishSkeletonEyesLayer<T extends SleepishSkeletonEntity> extends AbstractEyesLayer<T, SkeletonModel<T>> {
    public SleepishSkeletonEyesLayer(IEntityRenderer<T, SkeletonModel<T>> renderer) {
        super(renderer);
    }

    @Nonnull
    public RenderType renderType() {
        return RenderType.eyes(BackMath.entityTexture("skeleton/sleepish_skeleton_eyes"));
    }
}
