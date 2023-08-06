// Made with Blockbench 4.5.2.
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings.
// Paste this class into your mod and generate all required imports.
package com.sophicreeper.backmath.core.client.model.entity;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sophicreeper.backmath.core.world.entity.tameable.QueenLucyPet;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class QueenLucyPetModel extends BipedModel<QueenLucyPet> {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer arms;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftArm;
	private final ModelRenderer legs;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;
	private final ModelRenderer wings;
	private final ModelRenderer rightWing;
	private final ModelRenderer rightWingR1;
	private final ModelRenderer leftWing;
	private final ModelRenderer leftWingR1;

	public QueenLucyPetModel() {
		super(0, 0, 32, 32);
		textureWidth = 32;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(0, 12, 0);
		setRotationAngle(head, 0, 0, 0);
		head.setTextureOffset(0, 0).addBox(-2, -4, -2, 4, 4, 4, 0, false);
		head.setTextureOffset(0, 16).addBox(-1, -6, -1, 2, 2, 0, 0, false);
		head.setTextureOffset(15, 14).addBox(-1, -6, -1, 0, 2, 2, 0, false);
		head.setTextureOffset(8, 16).addBox(-1, -6, 1, 2, 2, 0, 0, false);
		head.setTextureOffset(3, 14).addBox(1, -6, -1, 0, 2, 2, 0, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0, 24, 0);
		body.setTextureOffset(8, 8).addBox(-2, -12, -1, 4, 6, 2, 0, false);

		arms = new ModelRenderer(this);
		arms.setRotationPoint(0, -11, 0);
		body.addChild(arms);


		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(-2.5F, 0, 0);
		arms.addChild(rightArm);
		rightArm.setTextureOffset(20, 8).addBox(-0.5F, -1, -1, 1, 6, 2, 0, false);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(2.5F, 0, 0);
		arms.addChild(leftArm);
		leftArm.setTextureOffset(20, 8).addBox(-0.5F, -1, -1, 1, 6, 2, 0, true);

		legs = new ModelRenderer(this);
		legs.setRotationPoint(0, -6, 0);
		body.addChild(legs);


		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(-1, 0, 0);
		legs.addChild(rightLeg);
		rightLeg.setTextureOffset(0, 8).addBox(-1, 0, -1, 2, 6, 2, 0, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(1, 0, 0);
		legs.addChild(leftLeg);
		leftLeg.setTextureOffset(0, 8).addBox(-1, 0, -1, 2, 6, 2, 0, true);

		wings = new ModelRenderer(this);
		wings.setRotationPoint(0, -9, 0);
		body.addChild(wings);


		rightWing = new ModelRenderer(this);
		rightWing.setRotationPoint(0, 0, 0);
		wings.addChild(rightWing);


		rightWingR1 = new ModelRenderer(this);
		rightWingR1.setRotationPoint(0, 0, 0);
		rightWing.addChild(rightWingR1);
		setRotationAngle(rightWingR1, 0, 0.4363F, 0);
		rightWingR1.setTextureOffset(0, 20).addBox(-7, -3, 1, 7, 6, 0, 0, false);

		leftWing = new ModelRenderer(this);
		leftWing.setRotationPoint(0, 0, 0);
		wings.addChild(leftWing);


		leftWingR1 = new ModelRenderer(this);
		leftWingR1.setRotationPoint(0, 0, 0);
		leftWing.addChild(leftWingR1);
		setRotationAngle(leftWingR1, 0, -0.4363F, 0);
		leftWingR1.setTextureOffset(0, 26).addBox(0, -3, 1, 7, 6, 0, 0, true);
	}

	@Override
	protected Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.head);
	}

	@Override
	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.body, this.rightLeg, this.leftLeg, this.rightArm, this.leftArm, this.rightWing, this.leftWing);
	}

	//@Override
	//public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
	//	previously the render function, render code was moved to a method below
	//}

	// Sets this entity's model rotation angles
	public void setRotationAngles(QueenLucyPet queenLucyPet, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.rotateAngleY = netHeadYaw * 0.017453292f;
		this.head.rotateAngleX = headPitch * 0.017453292f;

		this.body.rotateAngleY = 0;

		this.rightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 2 * limbSwingAmount * 0.5f;
		this.leftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 2 * limbSwingAmount * 0.5f;
		this.rightArm.rotateAngleZ = 0;
		this.leftArm.rotateAngleZ = 0;
		this.rightLeg.rotateAngleY = 0;
		this.leftLeg.rotateAngleY = 0;
		this.rightLeg.rotateAngleZ = 0;
		this.leftLeg.rotateAngleZ = 0;

		ModelRenderer modelRenderer;
		if (this.isSitting) {
			modelRenderer = this.rightArm;
			modelRenderer.rotateAngleX -= 0.62831855F;
			modelRenderer = this.leftArm;
			modelRenderer.rotateAngleX -= 0.62831855F;
			this.rightLeg.rotateAngleX = -1.4137167F;
			this.rightLeg.rotateAngleY = 0.31415927F;
			this.rightLeg.rotateAngleZ = 0.07853982F;
			this.leftLeg.rotateAngleX = -1.4137167F;
			this.leftLeg.rotateAngleY = -0.31415927F;
			this.leftLeg.rotateAngleZ = -0.07853982F;
		}

		this.rightArm.rotateAngleY = 0;
		this.leftArm.rotateAngleY = 0;

		this.rightLeg.rotationPointZ = 0.1F;
		this.leftLeg.rotationPointZ = 0.1F;
		this.rightLeg.rotationPointY = 0;
		this.leftLeg.rotationPointY = 0;
		this.head.rotationPointY = 12;
		this.body.rotationPointY = 24;
		this.rightArm.rotationPointY = 0;
		this.leftArm.rotationPointY = 0;
		super.setRotationAngles(queenLucyPet, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}