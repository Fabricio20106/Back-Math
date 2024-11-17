package com.sophicreeper.backmath.entity.renderer.aljan;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.aljan.SleepishSkeletonEntity;
import com.sophicreeper.backmath.entity.renderer.layer.BMArmorLayer;
import com.sophicreeper.backmath.entity.renderer.layer.SleepishSkeletonEyesLayer;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.model.SkeletonModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class SleepishSkeletonRenderer extends BipedRenderer<SleepishSkeletonEntity, SkeletonModel<SleepishSkeletonEntity>> {
    public SleepishSkeletonRenderer(EntityRendererManager manager) {
        super(manager, new SkeletonModel<>(), 0.5F);
        this.addLayer(new BMArmorLayer<>(this, new SkeletonModel<>(0.5F, true), new SkeletonModel<>(1, true)));
        this.addLayer(new ElytraLayer<>(this));
        this.addLayer(new SleepishSkeletonEyesLayer<>(this));
    }

    @Nonnull
    public ResourceLocation getTextureLocation(SleepishSkeletonEntity skeleton) {
        return BackMath.entityTexture("skeleton/sleepish_skeleton");
    }
}
