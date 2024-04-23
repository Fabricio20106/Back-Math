package com.sophicreeper.backmath.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BMBipedModel<T extends CreatureEntity> extends BipedModel<T> {
    private final ModelRenderer bipedCape;

    public BMBipedModel(float modelSize, float yOffset, int textureWidth, int textureHeight) {
        super(RenderType::entityTranslucent, modelSize, yOffset, textureWidth, textureHeight);

        this.bipedCape = new ModelRenderer(this, 0, 0);
        this.bipedCape.setTexSize(64, 32);
        this.bipedCape.addBox(-5, 0, -1, 10, 16, 1, modelSize);
    }

    public void renderCape(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay) {
        this.bipedCape.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    // Sets this entity's model rotation angles.
    public void setupAnim(T mob, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if (mob.getItemBySlot(EquipmentSlotType.CHEST).isEmpty()) {
            if (mob.isCrouching()) {
                this.bipedCape.z = 1.4F;
                this.bipedCape.y = 1.85F;
            } else {
                this.bipedCape.z = 0;
                this.bipedCape.y = 0;
            }
        } else if (mob.isCrouching()) {
            this.bipedCape.z = 0.3F;
            this.bipedCape.y = 0.8F;
        } else {
            this.bipedCape.z = -1.1F;
            this.bipedCape.y = -0.85F;
        }

        super.setupAnim(mob, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
    }

    @Override
    public void setAllVisible(boolean visible) {
        super.setAllVisible(visible);
        this.bipedCape.visible = visible;
    }
}
