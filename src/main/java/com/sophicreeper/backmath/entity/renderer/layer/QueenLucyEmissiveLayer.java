package com.sophicreeper.backmath.entity.renderer.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.QueenLucyEntity;
import com.sophicreeper.backmath.entity.model.BMPlayerModel;
import com.sophicreeper.backmath.util.BMUtils;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class QueenLucyEmissiveLayer extends LayerRenderer<QueenLucyEntity, BMPlayerModel<QueenLucyEntity>> {
    public QueenLucyEmissiveLayer(IEntityRenderer<QueenLucyEntity, BMPlayerModel<QueenLucyEntity>> renderer) {
        super(renderer);
    }

    @Override
    public void render(MatrixStack stack, IRenderTypeBuffer buffer, int packedLight, QueenLucyEntity lucy, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch) {
        if (lucy.getRegistryVariant() != null && lucy.getRegistryVariant().getEmissiveTexture() != null) {
            IVertexBuilder eyesBuilder = buffer.getBuffer(RenderType.eyes(BackMath.textureLocation(lucy.getRegistryVariant().getEmissiveTexture())));
            this.getParentModel().renderToBuffer(stack, eyesBuilder, BMUtils.EMISSIVE_LIGHT_VALUE, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        }
    }
}
