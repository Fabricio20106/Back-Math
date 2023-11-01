package com.sophicreeper.backmath.entity.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelHelper;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BMZombieBipedModel<T extends MonsterEntity> extends BipedModel<T> {
    public BMZombieBipedModel(float modelSize, float yOffset, int textureWidth, int textureHeight) {
        super(modelSize, yOffset, textureWidth, textureHeight);
    }

    // Sets this entity's model rotation angles.
    public void setRotationAngles(T zombie, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setRotationAngles(zombie, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        ModelHelper.func_239105_a_(this.bipedLeftArm, this.bipedRightArm, this.isAggressive(zombie), this.swingProgress, ageInTicks);
    }

    public boolean isAggressive(T zombie) {
        return zombie.isAggressive();
    }
}
