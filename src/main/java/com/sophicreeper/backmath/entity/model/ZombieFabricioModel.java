package com.sophicreeper.backmath.entity.model;

import com.sophicreeper.backmath.entity.custom.aljan.ZombieFabricioEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ZombieFabricioModel<T extends ZombieFabricioEntity> extends BMZombieModel<T> {
    public ZombieFabricioModel(float modelSize, float yOffset, int textureWidth, int textureHeight) {
        super(modelSize, yOffset, textureWidth, textureHeight);
        this.rightArm = new ModelRenderer(this, 32, 48);
        this.rightArm.addBox(-3, -2, -2, 4, 12, 4, modelSize);
        this.rightArm.setPos(-5, 2 + yOffset, 0);
        this.rightLeg = new ModelRenderer(this, 0, 16);
        this.rightLeg.addBox(-2, 0, -2, 4, 12, 4, modelSize);
        this.rightLeg.setPos(-1.9F, 12 + yOffset, 0);
        this.leftLeg = new ModelRenderer(this, 16, 48);
        this.leftLeg.addBox(-2, 0, -2, 4, 12, 4, modelSize);
        this.leftLeg.setPos(1.9F, 12, 0);
    }

    public ZombieFabricioModel(float modelSize, boolean usesShortTexture) {
        super(modelSize, 0, 64, usesShortTexture ? 32 : 64);
    }
}
