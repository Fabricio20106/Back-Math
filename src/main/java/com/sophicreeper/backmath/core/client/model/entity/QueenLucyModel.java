package com.sophicreeper.backmath.core.client.model.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sophicreeper.backmath.core.world.entity.monster.QueenLucy;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class QueenLucyModel extends BipedModel<QueenLucy> {
    public ModelRenderer bipedRightLeg;
    public ModelRenderer bipedLeftLeg;
    public ModelRenderer bipedBody;
    public ModelRenderer bipedRightArm;
    public ModelRenderer bipedLeftArm;
    public ModelRenderer bipedHead;

    public QueenLucyModel() {
        super(0, 0, 64, 64);
        textureWidth = 64;
        textureHeight = 64;

        this.bipedRightLeg = new ModelRenderer(this, 0, 0);
        this.bipedRightLeg.setRotationPoint(0, 24, 0);
        this.bipedRightLeg.setTextureOffset(0, 16).addBox(-4, -12, -2, 4, 12, 4, 0, false);

        this.bipedLeftLeg = new ModelRenderer(this, 0, 0);
        this.bipedLeftLeg.setRotationPoint(0, 24, 0);
        this.bipedLeftLeg.setTextureOffset(0, 16).addBox(0, -12, -2, 4, 12, 4, 0, false);

        this.bipedBody = new ModelRenderer(this, 0, 0);
        this.bipedBody.setRotationPoint(0, 24, 0);
        this.bipedBody.setTextureOffset(16, 16).addBox(-4, -24, -2, 8, 12, 4, 0, false);

        this.bipedRightArm = new ModelRenderer(this, 0, 0);
        this.bipedRightArm.setRotationPoint(0, 24, 0);
        this.bipedRightArm.setTextureOffset(40, 16).addBox(-7, -24, -2, 3, 12, 4, 0, false);

        this.bipedLeftArm = new ModelRenderer(this, 0, 0);
        this.bipedLeftArm.setRotationPoint(.00F, 24, 0);
        this.bipedLeftArm.setTextureOffset(40, 16).addBox(4, -24, -2, 3, 12, 4, 0, false);

        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.setRotationPoint(0, 24, 0);
        this.bipedHead.setTextureOffset(0, 0).addBox(-4, -32, -4, 8, 8, 8, 0, false);
        this.bipedHead.setTextureOffset(0, 32).addBox(-3, -37, -3, 0, 5, 6, 0, false);
        this.bipedHead.setTextureOffset(12, 32).addBox(3, -37, -3, 0, 5, 6, 0, false);
        this.bipedHead.setTextureOffset(6, 38).addBox(-3, -37, -3, 6, 5, 0, 0, false);
        this.bipedHead.setTextureOffset(18, 38).addBox(-3, -37, 3, 6, 5, 0, 0, false);
    }

    /*@Override
    // queenSophie limbSwing limbSwingAmount ageInTicks netHeadYaw headPitch
    public void setRotationAngles(QueenLucy queenLucy, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //previously the render function, render code was moved to a method below
        this.head.rotateAngleX = headPitch * 0.017453292F;
        //this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        //this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);

        this.rightArm.rotationPointZ = 0;
        this.rightArm.rotationPointX = -5;
        this.leftArm.rotationPointZ = 0;
        this.leftArm.rotationPointX = 5;

        this.rightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 2 * limbSwingAmount * 0.5F;
        this.leftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2 * limbSwingAmount * 0.5F;

        //this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        //this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwing;
        this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwing;

        this.rightArm.rotateAngleY = 0;
        this.leftArm.rotateAngleY = 0;
    }*/

    /**
     * Sets this entity's model rotation angles
     */
    /*public void setRotationAngles(QueenLucy queenLucy, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setRotationAngles(queenLucy, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
    }*/
    /**
     * Sets this entity's model rotation angles
     */
    /*public void setRotationAngles(QueenLucy queenLucy, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.bipedHead.rotateAngleY = netHeadYaw * 0.017453292f;
        this.bipedHead.rotateAngleX = headPitch * 0.017453292f;

        this.bipedBody.rotateAngleY = 0;

        this.bipedRightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 2 * limbSwingAmount * 0.5f;
        this.bipedLeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 2 * limbSwingAmount * 0.5f;
        this.bipedRightArm.rotateAngleZ = 0;
        this.bipedLeftArm.rotateAngleZ = 0;
        this.bipedRightLeg.rotateAngleY = 0;
        this.bipedLeftLeg.rotateAngleY = 0;
        this.bipedRightLeg.rotateAngleZ = 0;
        this.bipedLeftLeg.rotateAngleZ = 0;

        ModelRenderer modelRenderer;
        if (this.isSitting) {
            modelRenderer = this.bipedRightArm;
            modelRenderer.rotateAngleX -= 0.62831855F;
            modelRenderer = this.bipedLeftArm;
            modelRenderer.rotateAngleX -= 0.62831855F;
            this.bipedRightLeg.rotateAngleX = -1.4137167F;
            this.bipedRightLeg.rotateAngleY = 0.31415927F;
            this.bipedRightLeg.rotateAngleZ = 0.07853982F;
            this.bipedLeftLeg.rotateAngleX = -1.4137167F;
            this.bipedLeftLeg.rotateAngleY = -0.31415927F;
            this.bipedLeftLeg.rotateAngleZ = -0.07853982F;
        }

        this.bipedRightArm.rotateAngleY = 0;
        this.bipedLeftArm.rotateAngleY = 0;

        this.bipedBody.rotateAngleX = 0;
        this.bipedRightLeg.rotationPointZ = 0.1F;
        this.bipedLeftLeg.rotationPointZ = 0.1F;
        this.bipedRightLeg.rotationPointY = 24;
        this.bipedLeftLeg.rotationPointY = 24;
        this.bipedHead.rotationPointY = 24;
        this.bipedBody.rotationPointY = 24;
        this.bipedRightArm.rotationPointY = 24;
        this.bipedLeftArm.rotationPointY = 24;
        super.setRotationAngles(queenLucy, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
    }*/

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bipedRightLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        bipedLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        bipedBody.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        bipedRightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        bipedLeftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        bipedHead.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
