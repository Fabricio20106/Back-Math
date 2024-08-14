package com.sophicreeper.backmath.entity.model;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.CreatureEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BMArmorModel<T extends CreatureEntity> extends BipedModel<T> {
    public BMArmorModel(float modelSize, float yOffset, int textureWidth, int textureHeight) {
        super(RenderType::entityTranslucent, modelSize, yOffset, textureWidth, textureHeight);
    }
}
