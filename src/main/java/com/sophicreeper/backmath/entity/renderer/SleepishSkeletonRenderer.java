package com.sophicreeper.backmath.entity.renderer;

import com.sophicreeper.backmath.BackMath;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.model.SkeletonModel;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SleepishSkeletonRenderer extends BipedRenderer<AbstractSkeletonEntity, SkeletonModel<AbstractSkeletonEntity>> {
    private static final ResourceLocation SLEEPISH_SKELETON_LOCATION = BackMath.resourceLoc("textures/entity/skeleton/sleepish_skeleton.png");

    public SleepishSkeletonRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new SkeletonModel<>(), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new SkeletonModel<>(0.5F, true), new SkeletonModel<>(1.0F, true)));
        this.addLayer(new ElytraLayer<>(this));
    }

    public ResourceLocation getEntityTexture(AbstractSkeletonEntity aljamicBones) {
        return SLEEPISH_SKELETON_LOCATION;
    }
}
