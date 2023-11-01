package com.sophicreeper.backmath.entity.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.CreatureEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BMBipedModel<T extends CreatureEntity> extends BipedModel<T> {
    public BMBipedModel(float modelSize, float yOffset, int textureWidth, int textureHeight) {
        super(modelSize, yOffset, textureWidth, textureHeight);
    }

    // Sets this entity's model rotation angles.
    public void setRotationAngles(T mob, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setRotationAngles(mob, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
    }
}
