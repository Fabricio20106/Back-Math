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
public class AljamicBonesRenderer extends BipedRenderer<AbstractSkeletonEntity, SkeletonModel<AbstractSkeletonEntity>> {
    public AljamicBonesRenderer(EntityRendererManager manager) {
        super(manager, new SkeletonModel<>(), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new SkeletonModel<>(0.5F, true), new SkeletonModel<>(1, true)));
        this.addLayer(new ElytraLayer<>(this));
    }

    public ResourceLocation getTextureLocation(AbstractSkeletonEntity skeleton) {
        return BackMath.resourceLoc("textures/entity/skeleton/aljamic_bones.png");
    }
}
