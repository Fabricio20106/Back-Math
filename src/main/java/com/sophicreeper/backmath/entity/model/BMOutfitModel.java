package com.sophicreeper.backmath.entity.model;

import net.minecraft.entity.CreatureEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BMOutfitModel<T extends CreatureEntity> extends BMPlayerModel<T> {
    public BMOutfitModel(float modelSize, float yOffset, int textureWidth, int textureHeight, boolean slimArms) {
        super(modelSize, yOffset, textureWidth, textureHeight, slimArms);
    }
}
