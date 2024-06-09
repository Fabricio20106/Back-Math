package com.sophicreeper.backmath.entity.renderer.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sophicreeper.backmath.entity.custom.termian.TermianPatrollerEntity;
import com.sophicreeper.backmath.util.BMTags;
import com.sophicreeper.backmath.util.BMUtils;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.ElytraModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TermianPatrollerElytraLayer<T extends TermianPatrollerEntity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
    private final ElytraModel<T> elytraModel = new ElytraModel<>();

    public TermianPatrollerElytraLayer(IEntityRenderer<T, M> renderer) {
        super(renderer);
    }

    @Override
    public void render(MatrixStack stack, IRenderTypeBuffer buffer, int packedLight, T patroller, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack chestStack = patroller.getItemBySlot(EquipmentSlotType.CHEST);
        if (shouldRender(chestStack) && patroller.getType().is(BMTags.EntityTypes.ELIGIBLE_TO_CAPES) && !patroller.getCapeTexture().isEmpty()) {
            ResourceLocation elytraTexture;
            if (patroller.getCapeTexture() != null && patroller.getCapeVisibility()) {
                elytraTexture = BMUtils.getTermianPatrollerCape(patroller);
            } else {
                elytraTexture = getDefaultElytraTexture();
            }

            stack.pushPose();
            stack.translate(0, 0, 0.125);
            this.getParentModel().copyPropertiesTo(this.elytraModel);
            this.elytraModel.setupAnim(patroller, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            IVertexBuilder vertexBuilder = ItemRenderer.getArmorFoilBuffer(buffer, RenderType.armorCutoutNoCull(elytraTexture), false, chestStack.hasFoil());
            this.elytraModel.renderToBuffer(stack, vertexBuilder, packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
            stack.popPose();
        }
    }

    public boolean shouldRender(ItemStack stack) {
        return stack.getItem().is(BMTags.Items.ELYTRA);
    }

    public ResourceLocation getDefaultElytraTexture() {
        return new ResourceLocation("textures/entity/elytra.png");
    }
}
