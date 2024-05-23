package com.sophicreeper.backmath.entity.renderer.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sophicreeper.backmath.entity.custom.termian.TermianPatrollerEntity;
import com.sophicreeper.backmath.entity.model.BMBipedModel;
import com.sophicreeper.backmath.util.BMTags;
import com.sophicreeper.backmath.util.BMUtils;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TermianPatrollerCapeLayer<T extends TermianPatrollerEntity> extends LayerRenderer<T, BMBipedModel<T>> {
    public TermianPatrollerCapeLayer(IEntityRenderer<T, BMBipedModel<T>> patroller) {
        super(patroller);
    }

    public void render(MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight, T patroller, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!patroller.isInvisible()) {
            ItemStack chestStack = patroller.getItemBySlot(EquipmentSlotType.CHEST);
            if (!chestStack.getItem().is(BMTags.Items.ELYTRA) && patroller.getCapeVisibility()) {
                matrixStack.pushPose();
                matrixStack.translate(0, 0, 0.125D);
                double d0 = MathHelper.lerp(partialTicks, patroller.prevChasingPosX, patroller.chasingPosX) - MathHelper.lerp(partialTicks, patroller.xo, patroller.getX());
                double d1 = MathHelper.lerp(partialTicks, patroller.prevChasingPosY, patroller.chasingPosY) - MathHelper.lerp(partialTicks, patroller.yo, patroller.getY());
                double d2 = MathHelper.lerp(partialTicks, patroller.prevChasingPosZ, patroller.chasingPosZ) - MathHelper.lerp(partialTicks, patroller.zo, patroller.getZ());
                float f = patroller.yBodyRotO + (patroller.yBodyRot - patroller.yBodyRotO);
                double d3 = MathHelper.sin(f * ((float) Math.PI / 180));
                double d4 = -MathHelper.cos(f * ((float) Math.PI / 180));
                float f1 = (float) d1 * 10;
                f1 = MathHelper.clamp(f1, -6, 32);
                float f2 = (float) (d0 * d3 + d2 * d4) * 100;
                f2 = MathHelper.clamp(f2, 0, 150);
                float f3 = (float) (d0 * d4 - d2 * d3) * 100;
                f3 = MathHelper.clamp(f3, -20, 20);
                if (f2 < 0) {
                    f2 = 0;
                }

                float f4 = MathHelper.lerp(partialTicks, patroller.prevCameraYaw, patroller.cameraYaw);
                f1 = f1 + MathHelper.sin(MathHelper.lerp(partialTicks, patroller.walkDistO, patroller.walkDist) * 6) * 32 * f4;
                if (patroller.isCrouching()) f1 += 25;

                matrixStack.mulPose(Vector3f.XP.rotationDegrees(6 + f2 / 2 + f1));
                matrixStack.mulPose(Vector3f.ZP.rotationDegrees(f3 / 2));
                matrixStack.mulPose(Vector3f.YP.rotationDegrees(180 - f3 / 2));
                IVertexBuilder vertexBuilder = buffer.getBuffer(RenderType.entitySolid(BMUtils.getTermianPatrollerCape(patroller)));
                this.getParentModel().renderCape(matrixStack, vertexBuilder, packedLight, OverlayTexture.NO_OVERLAY);
                matrixStack.popPose();
            }
        }
    }
}
