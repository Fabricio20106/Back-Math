package com.sophicreeper.backmath.core.client.model.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sophicreeper.backmath.core.world.entity.monster.QueenSophie;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class QueenSophieModel extends BipedModel<QueenSophie> {
    public ModelRenderer bipedRightLeg;
    public ModelRenderer bipedLeftLeg;
    public ModelRenderer bipedBody;
    public ModelRenderer bipedRightArm;
    public ModelRenderer bipedLeftArm;
    public ModelRenderer bipedHead;

    public QueenSophieModel() {
        super(0.0f, 0.0f, 64, 64);
        textureWidth = 64;
        textureHeight = 64;

        this.bipedRightLeg = new ModelRenderer(this, 0, 0);
        this.bipedRightLeg.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bipedRightLeg.setTextureOffset(0, 16).addBox(-4.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        this.bipedLeftLeg = new ModelRenderer(this, 0, 0);
        this.bipedLeftLeg.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bipedLeftLeg.setTextureOffset(0, 16).addBox(0.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        this.bipedBody = new ModelRenderer(this, 0, 0);
        this.bipedBody.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bipedBody.setTextureOffset(16, 16).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

        this.bipedRightArm = new ModelRenderer(this, 0, 0);
        this.bipedRightArm.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bipedRightArm.setTextureOffset(40, 16).addBox(-7.0F, -24.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.0F, false);

        this.bipedLeftArm = new ModelRenderer(this, 0, 0);
        this.bipedLeftArm.setRotationPoint(.00F, 24.0F, 0.0F);
        this.bipedLeftArm.setTextureOffset(40, 16).addBox(4.0F, -24.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.0F, false);

        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bipedHead.setTextureOffset(0, 0).addBox(-4.0F, -32.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        this.bipedHead.setTextureOffset(0, 32).addBox(-3.0F, -37.0F, -3.0F, 0.0F, 5.0F, 6.0F, 0.0F, false);
        this.bipedHead.setTextureOffset(12, 32).addBox(3.0F, -37.0F, -3.0F, 0.0F, 5.0F, 6.0F, 0.0F, false);
        this.bipedHead.setTextureOffset(6, 38).addBox(-3.0F, -37.0F, -3.0F, 6.0F, 5.0F, 0.0F, 0.0F, false);
        this.bipedHead.setTextureOffset(18, 38).addBox(-3.0F, -37.0F, 3.0F, 6.0F, 5.0F, 0.0F, 0.0F, false);
    }

    /*@Override
    // queenSophie limbSwing limbSwingAmount ageInTicks netHeadYaw headPitch
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
    }*/

    /**
     * Sets this entity's model rotation angles
     */
    /*public void setRotationAngles(QueenSophie queenSophie, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setRotationAngles(queenSophie, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
    }*/
    /**
     * Sets this entity's model rotation angles
     */
    /*public void setRotationAngles(QueenSophie queenSophie, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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
        super.setRotationAngles(queenSophie, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
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
