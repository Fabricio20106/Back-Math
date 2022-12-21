package com.sophicreeper.backmath.core.client.model.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sophicreeper.backmath.core.world.entity.monster.QueenSophie;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class QueenSophieModel extends BipedModel<QueenSophie> {
    private final ModelRenderer rightLeg;
    private final ModelRenderer leftLeg;
    private final ModelRenderer body;
    private final ModelRenderer rightArm;
    private final ModelRenderer leftArm;
    private final ModelRenderer head;

    public QueenSophieModel() {
        super(0.0f, 0.0f, 64, 64);
        textureWidth = 64;
        textureHeight = 64;

        rightLeg = new ModelRenderer(this);
        rightLeg.setRotationPoint(0.0F, 24.0F, 0.0F);
        rightLeg.setTextureOffset(0, 16).addBox(-4.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        leftLeg = new ModelRenderer(this);
        leftLeg.setRotationPoint(0.0F, 24.0F, 0.0F);
        leftLeg.setTextureOffset(0, 16).addBox(0.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        body.setTextureOffset(16, 16).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

        rightArm = new ModelRenderer(this);
        rightArm.setRotationPoint(0.0F, 24.0F, 0.0F);
        rightArm.setTextureOffset(40, 16).addBox(-7.0F, -24.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.0F, false);

        leftArm = new ModelRenderer(this);
        leftArm.setRotationPoint(0.0F, 24.0F, 0.0F);
        leftArm.setTextureOffset(40, 16).addBox(4.0F, -24.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 24.0F, 0.0F);
        head.setTextureOffset(0, 0).addBox(-4.0F, -32.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        head.setTextureOffset(0, 32).addBox(-3.0F, -37.0F, -3.0F, 0.0F, 5.0F, 6.0F, 0.0F, false);
        head.setTextureOffset(12, 32).addBox(3.0F, -37.0F, -3.0F, 0.0F, 5.0F, 6.0F, 0.0F, false);
        head.setTextureOffset(6, 38).addBox(-3.0F, -37.0F, -3.0F, 6.0F, 5.0F, 0.0F, 0.0F, false);
        head.setTextureOffset(18, 38).addBox(-3.0F, -37.0F, 3.0F, 6.0F, 5.0F, 0.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(QueenSophie queenSophie, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //previously the render function, render code was moved to a method below
        this.head.rotateAngleX = headPitch * 0.017453292F;
        //this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        //this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);

        this.rightArm.rotationPointZ = 0.0F;
        this.rightArm.rotationPointX = -5.0F;
        this.leftArm.rotationPointZ = 0.0F;
        this.leftArm.rotationPointX = 5.0F;

        this.rightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 2.0F * limbSwingAmount * 0.5F;
        this.leftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;

        //this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        //this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwing;
        this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwing;

        this.rightArm.rotateAngleY = 0.0F;
        this.leftArm.rotateAngleY = 0.0F;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        rightLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        leftLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        rightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        leftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
