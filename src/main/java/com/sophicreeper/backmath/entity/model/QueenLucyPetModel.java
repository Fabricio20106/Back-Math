// Made with Blockbench 4.5.2.
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings.
// Paste this class into your mod and generate all required imports.
package com.sophicreeper.backmath.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sophicreeper.backmath.entity.custom.QueenLucyPet;
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
		super(0.25F, 0, 32, 32);
		texWidth = 32;
		texHeight = 32;

		head = new ModelRenderer(this);
		head.setPos(0, 12, 0);
		setRotationAngle(head, 0, 0, 0);
		head.texOffs(0, 0).addBox(-2, -4, -2, 4, 4, 4, 0, false);
		head.texOffs(0, 16).addBox(-1, -6, -1, 2, 2, 0, 0, false);
		head.texOffs(15, 14).addBox(-1, -6, -1, 0, 2, 2, 0, false);
		head.texOffs(8, 16).addBox(-1, -6, 1, 2, 2, 0, 0, false);
		head.texOffs(3, 14).addBox(1, -6, -1, 0, 2, 2, 0, false);

		body = new ModelRenderer(this);
		body.setPos(0, 24, 0);
		body.texOffs(8, 8).addBox(-2, -12, -1, 4, 6, 2, 0, false);

		arms = new ModelRenderer(this);
		arms.setPos(0, -11, 0);
		body.addChild(arms);


		rightArm = new ModelRenderer(this);
		rightArm.setPos(-2.5F, 0, 0);
		arms.addChild(rightArm);
		rightArm.texOffs(20, 8).addBox(-0.5F, -1, -1, 1, 6, 2, 0, false);

		leftArm = new ModelRenderer(this);
		leftArm.setPos(2.5F, 0, 0);
		arms.addChild(leftArm);
		leftArm.texOffs(20, 8).addBox(-0.5F, -1, -1, 1, 6, 2, 0, true);

		legs = new ModelRenderer(this);
		legs.setPos(0, -6, 0);
		body.addChild(legs);


		rightLeg = new ModelRenderer(this);
		rightLeg.setPos(-1, 0, 0);
		legs.addChild(rightLeg);
		rightLeg.texOffs(0, 8).addBox(-1, 0, -1, 2, 6, 2, 0, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setPos(1, 0, 0);
		legs.addChild(leftLeg);
		leftLeg.texOffs(0, 8).addBox(-1, 0, -1, 2, 6, 2, 0, true);

		wings = new ModelRenderer(this);
		wings.setPos(0, -9, 0);
		body.addChild(wings);


		rightWing = new ModelRenderer(this);
		rightWing.setPos(0, 0, 0);
		wings.addChild(rightWing);


		rightWingR1 = new ModelRenderer(this);
		rightWingR1.setPos(0, 0, 0);
		rightWing.addChild(rightWingR1);
		setRotationAngle(rightWingR1, 0, 0.4363F, 0);
		rightWingR1.texOffs(0, 20).addBox(-7, -3, 1, 7, 6, 0, 0, false);

		leftWing = new ModelRenderer(this);
		leftWing.setPos(0, 0, 0);
		wings.addChild(leftWing);


		leftWingR1 = new ModelRenderer(this);
		leftWingR1.setPos(0, 0, 0);
		leftWing.addChild(leftWingR1);
		setRotationAngle(leftWingR1, 0, -0.4363F, 0);
		leftWingR1.texOffs(0, 26).addBox(0, -3, 1, 7, 6, 0, 0, true);
	}

	@Override
	protected Iterable<ModelRenderer> headParts() {
		return ImmutableList.of(this.head);
	}

	@Override
	protected Iterable<ModelRenderer> bodyParts() {
		return ImmutableList.of(this.body, this.rightLeg, this.leftLeg, this.rightArm, this.leftArm, this.rightWing, this.leftWing);
	}

	// Sets this entity's model rotation angles.
	public void setupAnim(QueenLucyPet lucy, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw * 0.017453292f;
		this.head.xRot = headPitch * 0.017453292f;

		this.body.yRot = 0;

		this.rightArm.xRot = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 2 * limbSwingAmount * 0.5F;
		this.leftArm.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2 * limbSwingAmount * 0.5F;
		this.rightArm.zRot = 0;
		this.leftArm.zRot = 0;
		this.rightLeg.yRot = 0;
		this.leftLeg.yRot = 0;
		this.rightLeg.zRot = 0;
		this.leftLeg.zRot = 0;

		ModelRenderer modelRenderer;
		if (this.riding) {
			modelRenderer = this.rightArm;
			modelRenderer.xRot -= 0.62831855F;
			modelRenderer = this.leftArm;
			modelRenderer.xRot -= 0.62831855F;
			this.rightLeg.xRot = -1.4137167F;
			this.rightLeg.yRot = 0.31415927F;
			this.rightLeg.zRot = 0.07853982F;
			this.leftLeg.xRot = -1.4137167F;
			this.leftLeg.yRot = -0.31415927F;
			this.leftLeg.zRot = -0.07853982F;
		}

		this.rightArm.yRot = 0;
		this.leftArm.yRot = 0;

		this.rightLeg.z = 0.1F;
		this.leftLeg.z = 0.1F;
		this.rightLeg.y = 0;
		this.leftLeg.y = 0;
		this.head.y = 12;
		this.body.y = 24;
		this.rightArm.y = 0;
		this.leftArm.y = 0;
		super.setupAnim(lucy, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
	}

	@Override
	public void renderToBuffer(MatrixStack stack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(stack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(stack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}