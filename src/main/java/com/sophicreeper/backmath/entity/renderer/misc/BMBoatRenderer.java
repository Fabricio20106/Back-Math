package com.sophicreeper.backmath.entity.renderer.misc;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.misc.BMBoatEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.BoatModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;

import javax.annotation.Nonnull;

public class BMBoatRenderer extends EntityRenderer<BMBoatEntity> {
    private static final ResourceLocation[] BOAT_TEXTURES = new ResourceLocation[] {BackMath.backMath("textures/entity/boat/aljanwood.png"), BackMath.backMath("textures/entity/boat/aljancap.png"), BackMath.backMath(
            "textures/entity/boat/insomnian.png")};
    protected final BoatModel model = new BoatModel();

    public BMBoatRenderer(EntityRendererManager manager) {
        super(manager);
        this.shadowRadius = 0.8F;
    }

    @Override
    public void render(BMBoatEntity boat, float yaw, float partialTicks, MatrixStack stack, IRenderTypeBuffer buffer, int packedLight) {
        stack.pushPose();
        stack.translate(0, 0.375D, 0);
        stack.mulPose(Vector3f.YP.rotationDegrees(180 - yaw));
        float hurtTime = (float) boat.getHurtTime() - partialTicks;
        float damage = boat.getDamage() - partialTicks;
        if (damage < 0) damage = 0;

        if (hurtTime > 0) {
            stack.mulPose(Vector3f.XP.rotationDegrees(MathHelper.sin(hurtTime) * hurtTime * damage / 10 * (float) boat.getHurtDir()));
        }

        float bubbleAngle = boat.getBubbleAngle(partialTicks);
        if (!MathHelper.equal(bubbleAngle, 0)) {
            stack.mulPose(new Quaternion(new Vector3f(1, 0, 1), boat.getBubbleAngle(partialTicks), true));
        }

        stack.scale(-1, -1, 1);
        stack.mulPose(Vector3f.YP.rotationDegrees(90));
        this.model.setupAnim(boat, partialTicks, 0, -0.1F, 0, 0);
        IVertexBuilder vertexBuilder = buffer.getBuffer(this.model.renderType(this.getTextureLocation(boat)));
        this.model.renderToBuffer(stack, vertexBuilder, packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        if (!boat.isUnderWater()) {
            IVertexBuilder waterMaskBuilder = buffer.getBuffer(RenderType.waterMask());
            this.model.waterPatch().render(stack, waterMaskBuilder, packedLight, OverlayTexture.NO_OVERLAY);
        }

        stack.popPose();
        super.render(boat, yaw, partialTicks, stack, buffer, packedLight);
    }

    @Nonnull
    public ResourceLocation getTextureLocation(BMBoatEntity boat) {
        switch (boat.getWoodType()) {
            case "aljancap":
                return BOAT_TEXTURES[1];
            case "insomnian":
                return BOAT_TEXTURES[2];
            case "aljanwood":
            default:
                return BOAT_TEXTURES[0];
        }
    }
}
