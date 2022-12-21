package com.sophicreeper.backmath.core.client.renderer.entity;

import com.sophicreeper.backmath.core.client.BackMath;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.util.ResourceLocation;

public class BMBoatRenderer extends BoatRenderer {
    private static final ResourceLocation BOAT_TEXTURE = BackMath.resourceLoc("textures/entity/boat/aljanwood.png");

    public BMBoatRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager);
    }

    @Override
    public ResourceLocation getEntityTexture(BoatEntity entity) {
        return BOAT_TEXTURE;
    }
}
