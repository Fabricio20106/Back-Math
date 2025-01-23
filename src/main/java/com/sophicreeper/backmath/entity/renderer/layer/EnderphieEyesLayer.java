package com.sophicreeper.backmath.entity.renderer.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sophicreeper.backmath.entity.custom.WandererSophieEntity;
import com.sophicreeper.backmath.entity.model.BMPlayerModel;
import com.sophicreeper.backmath.util.BMResourceLocations;
import com.sophicreeper.backmath.variant.wansophie.BMWandererSophieVariants;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EnderphieEyesLayer extends LayerRenderer<WandererSophieEntity, BMPlayerModel<WandererSophieEntity>> {
    public EnderphieEyesLayer(IEntityRenderer<WandererSophieEntity, BMPlayerModel<WandererSophieEntity>> renderer) {
        super(renderer);
    }

    @Override
    public void render(MatrixStack stack, IRenderTypeBuffer buffer, int packedLight, WandererSophieEntity wandererSophie, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch) {
        // this will render on top of outfits for now (don't know if/how ordering is possible) ~isa 22-1-25
        if (wandererSophie.getVariant().equals(BMWandererSophieVariants.ENDER.get().getAssetID().toString())) {
            IVertexBuilder eyesBuilder = buffer.getBuffer(RenderType.eyes(BMResourceLocations.ENDERPHIE_EYES));
            this.getParentModel().renderToBuffer(stack, eyesBuilder, 0xF00000, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        }
    }
}
