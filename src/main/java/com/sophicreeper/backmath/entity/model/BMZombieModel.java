package com.sophicreeper.backmath.entity.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelHelper;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BMZombieModel<T extends MonsterEntity> extends BipedModel<T> {
    public BMZombieModel(float modelSize, float yOffset, int textureWidth, int textureHeight) {
        super(modelSize, yOffset, textureWidth, textureHeight);
    }

    @Override
    public void setupAnim(T zombie, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setupAnim(zombie, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        ModelHelper.animateZombieArms(this.leftArm, this.rightArm, this.isAggressive(zombie), this.attackTime, ageInTicks);
    }

    public boolean isAggressive(T zombie) {
        return zombie.isAggressive();
    }
}
