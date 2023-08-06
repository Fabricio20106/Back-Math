package com.sophicreeper.backmath.core.client.renderer.entity;

import com.sophicreeper.backmath.core.client.BackMath;
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
public class AljamicBonesRenderer extends BipedRenderer<AbstractSkeletonEntity, SkeletonModel<AbstractSkeletonEntity>> {
    private static final ResourceLocation ALJAMIC_BONES_LOCATION = BackMath.resourceLoc("textures/entity/skeleton/aljamic_bones.png");

    public AljamicBonesRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new SkeletonModel<>(), 0.5f);
        this.addLayer(new BipedArmorLayer<>(this, new SkeletonModel<>(0.5f, true), new SkeletonModel<>(1, true)));
        this.addLayer(new ElytraLayer<>(this));
    }

    public ResourceLocation getEntityTexture(AbstractSkeletonEntity aljamicBones) {
        return ALJAMIC_BONES_LOCATION;
    }
}
