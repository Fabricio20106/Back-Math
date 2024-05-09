package com.sophicreeper.backmath.entity.renderer.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.WandererSophie;
import com.sophicreeper.backmath.entity.model.BMBipedModel;
import com.sophicreeper.backmath.util.BMTags;
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
public class WandererSophieCapeLayer extends LayerRenderer<WandererSophie, BMBipedModel<WandererSophie>> {
    public WandererSophieCapeLayer(IEntityRenderer<WandererSophie, BMBipedModel<WandererSophie>> wandererSophie) {
        super(wandererSophie);
    }

    public void render(MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight, WandererSophie sophie, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!sophie.isInvisible()) {
            ItemStack chestStack = sophie.getItemBySlot(EquipmentSlotType.CHEST);
            if (!chestStack.getItem().is(BMTags.Items.ELYTRA)) {
                matrixStack.pushPose();
                matrixStack.translate(0, 0, 0.125D);
                double d0 = MathHelper.lerp(partialTicks, sophie.prevChasingPosX, sophie.chasingPosX) - MathHelper.lerp(partialTicks, sophie.xo, sophie.getX());
                double d1 = MathHelper.lerp(partialTicks, sophie.prevChasingPosY, sophie.chasingPosY) - MathHelper.lerp(partialTicks, sophie.yo, sophie.getY());
                double d2 = MathHelper.lerp(partialTicks, sophie.prevChasingPosZ, sophie.chasingPosZ) - MathHelper.lerp(partialTicks, sophie.zo, sophie.getZ());
                float f = sophie.yBodyRotO + (sophie.yBodyRot - sophie.yBodyRotO);
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

                float f4 = MathHelper.lerp(partialTicks, sophie.prevCameraYaw, sophie.cameraYaw);
                f1 = f1 + MathHelper.sin(MathHelper.lerp(partialTicks, sophie.walkDistO, sophie.walkDist) * 6) * 32 * f4;
                if (sophie.isCrouching()) f1 += 25;

                matrixStack.mulPose(Vector3f.XP.rotationDegrees(6 + f2 / 2 + f1));
                matrixStack.mulPose(Vector3f.ZP.rotationDegrees(f3 / 2));
                matrixStack.mulPose(Vector3f.YP.rotationDegrees(180 - f3 / 2));
                // TODO: Make the cape texture modifiable through NBT in Wanderer Sophies.
                // Example: (cape_texture: "cherry_blossom") + ".png"
                // Thus making new cape viable just through mob NBT and a resource pack.
                IVertexBuilder vertexBuilder = buffer.getBuffer(RenderType.entitySolid(BackMath.resourceLoc("textures/entity/cape/cherry_blossom.png")));
                this.getParentModel().renderCape(matrixStack, vertexBuilder, packedLight, OverlayTexture.NO_OVERLAY);
                matrixStack.popPose();
            }
        }
    }
}
