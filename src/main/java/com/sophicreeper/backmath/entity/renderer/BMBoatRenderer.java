package com.sophicreeper.backmath.entity.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.BMBoat;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.BoatModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;

public class BMBoatRenderer extends EntityRenderer<BMBoat> {
    private static final ResourceLocation[] BOAT_TEXTURES = new ResourceLocation[] {BackMath.resourceLoc("textures/entity/boat/aljanwood.png"), BackMath.resourceLoc("textures/entity/boat/aljancap.png"), BackMath.resourceLoc(
            "textures/entity/boat/insomnian.png")};
    protected final BoatModel model = new BoatModel();

    public BMBoatRenderer(EntityRendererManager renderManager) {
        super(renderManager);
        this.shadowSize = 0.8F;
    }

    @Override
    public void render(BMBoat boat, float entityYaw, float partialTicks, MatrixStack stack, IRenderTypeBuffer buffer, int packedLight) {
        stack.push();
        stack.translate(0, 0.375D, 0);
        stack.rotate(Vector3f.YP.rotationDegrees(180 - entityYaw));
        float hurtTime = (float) boat.getTimeSinceHit() - partialTicks;
        float damage = boat.getDamageTaken() - partialTicks;
        if (damage < 0) damage = 0;

        if (hurtTime > 0) {
            stack.rotate(Vector3f.XP.rotationDegrees(MathHelper.sin(hurtTime) * hurtTime * damage / 10 * (float) boat.getForwardDirection()));
        }

        float rockingAngle = boat.getRockingAngle(partialTicks);
        if (!MathHelper.epsilonEquals(rockingAngle, 0)) {
            stack.rotate(new Quaternion(new Vector3f(1, 0, 1), boat.getRockingAngle(partialTicks), true));
        }

        stack.scale(-1, -1, 1);
        stack.rotate(Vector3f.YP.rotationDegrees(90));
        this.model.setRotationAngles(boat, partialTicks, 0, -0.1F, 0, 0);
        IVertexBuilder vertexBuilder = buffer.getBuffer(this.model.getRenderType(this.getEntityTexture(boat)));
        this.model.render(stack, vertexBuilder, packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        if (!boat.canSwim()) {
            IVertexBuilder vertexBuilder1 = buffer.getBuffer(RenderType.getWaterMask());
            this.model.func_228245_c_().render(stack, vertexBuilder1, packedLight, OverlayTexture.NO_OVERLAY);
        }

        stack.pop();
        super.render(boat, entityYaw, partialTicks, stack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getEntityTexture(BMBoat boat) {
        switch (boat.getWoodType()) {
            case "aljanwood":
            default:
                return BOAT_TEXTURES[0];
            case "aljancap":
                return BOAT_TEXTURES[1];
            case "insomnian":
                return BOAT_TEXTURES[2];
        }
    }
}
