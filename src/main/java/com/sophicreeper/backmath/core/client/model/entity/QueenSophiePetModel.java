// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports
package com.sophicreeper.backmath.core.client.model.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sophicreeper.backmath.core.world.entity.tameable.QueenSophiePet;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class QueenSophiePetModel extends BipedModel<QueenSophiePet> {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer arms;
	private final ModelRenderer arm1;
	private final ModelRenderer arm2;
	private final ModelRenderer legs;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer wings;
	private final ModelRenderer wing1;
	private final ModelRenderer wing1_r1;
	private final ModelRenderer wing2;
	private final ModelRenderer wing2_r1;

	public QueenSophiePetModel() {
		super(0.0f, 0.0f, 32, 32);
		textureWidth = 32;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 12.0F, 0.0F);
		setRotationAngle(head, 0.0F, 0.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		head.setTextureOffset(0, 16).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		head.setTextureOffset(15, 14).addBox(-1.0F, -6.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(8, 16).addBox(-1.0F, -6.0F, 1.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		head.setTextureOffset(3, 14).addBox(1.0F, -6.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(8, 8).addBox(-2.0F, -12.0F, -1.0F, 4.0F, 6.0F, 2.0F, 0.0F, false);

		arms = new ModelRenderer(this);
		arms.setRotationPoint(0.0F, -11.0F, 0.0F);
		body.addChild(arms);
		

		arm1 = new ModelRenderer(this);
		arm1.setRotationPoint(-2.5F, 0.0F, 0.0F);
		arms.addChild(arm1);
		arm1.setTextureOffset(20, 8).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);

		arm2 = new ModelRenderer(this);
		arm2.setRotationPoint(2.5F, 0.0F, 0.0F);
		arms.addChild(arm2);
		arm2.setTextureOffset(20, 8).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, true);

		legs = new ModelRenderer(this);
		legs.setRotationPoint(0.0F, -6.0F, 0.0F);
		body.addChild(legs);
		

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(-1.0F, 0.0F, 0.0F);
		legs.addChild(leg1);
		leg1.setTextureOffset(0, 8).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(1.0F, 0.0F, 0.0F);
		legs.addChild(leg2);
		leg2.setTextureOffset(0, 8).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, true);

		wings = new ModelRenderer(this);
		wings.setRotationPoint(0.0F, -9.0F, 0.0F);
		body.addChild(wings);
		

		wing1 = new ModelRenderer(this);
		wing1.setRotationPoint(0.0F, 0.0F, 0.0F);
		wings.addChild(wing1);
		

		wing1_r1 = new ModelRenderer(this);
		wing1_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		wing1.addChild(wing1_r1);
		setRotationAngle(wing1_r1, 0.0F, 0.4363F, 0.0F);
		wing1_r1.setTextureOffset(0, 20).addBox(-7.0F, -3.0F, 1.0F, 7.0F, 6.0F, 0.0F, 0.0F, false);

		wing2 = new ModelRenderer(this);
		wing2.setRotationPoint(0.0F, 0.0F, 0.0F);
		wings.addChild(wing2);
		

		wing2_r1 = new ModelRenderer(this);
		wing2_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		wing2.addChild(wing2_r1);
		setRotationAngle(wing2_r1, 0.0F, -0.4363F, 0.0F);
		wing2_r1.setTextureOffset(0, 26).addBox(0.0F, -3.0F, 1.0F, 7.0F, 6.0F, 0.0F, 0.0F, true);
	}

	/*@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}*/

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