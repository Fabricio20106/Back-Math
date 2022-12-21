package com.sophicreeper.backmath.core.client.model.entity;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelHelper;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BMZombieBipedModel<T extends MonsterEntity> extends BipedModel<T> {
    public BMZombieBipedModel(float modelSize, float yOffsetIn, int textureWidthIn, int textureHeightIn) {
        super(modelSize, yOffsetIn, textureWidthIn, textureHeightIn);
    }

    /**
     * Sets this entity's model rotation angles
     */
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        ModelHelper.func_239105_a_(this.bipedLeftArm, this.bipedRightArm, this.isAggressive(entityIn), this.swingProgress, ageInTicks);
    }

    public boolean isAggressive(T zombie) {
        return zombie.isAggressive();
    }
}
