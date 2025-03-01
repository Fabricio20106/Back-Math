package com.sophicreeper.backmath.entity.renderer.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.QueenLucyPetEntity;
import com.sophicreeper.backmath.entity.model.QueenLucyPetModel;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class QueenLucyPetEmissiveLayer extends LayerRenderer<QueenLucyPetEntity, QueenLucyPetModel> {
    public QueenLucyPetEmissiveLayer(IEntityRenderer<QueenLucyPetEntity, QueenLucyPetModel> renderer) {
        super(renderer);
    }

    @Override
    public void render(MatrixStack stack, IRenderTypeBuffer buffer, int packedLight, QueenLucyPetEntity lucyPet, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch) {
        if (lucyPet.getRegistryVariant() != null && lucyPet.getRegistryVariant().getEmissiveTexture() != null) {
            IVertexBuilder eyesBuilder = buffer.getBuffer(RenderType.eyes(BackMath.textureLocation(lucyPet.getRegistryVariant().getEmissiveTexture())));
            this.getParentModel().renderToBuffer(stack, eyesBuilder, 0xF00000, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        }
    }
}
