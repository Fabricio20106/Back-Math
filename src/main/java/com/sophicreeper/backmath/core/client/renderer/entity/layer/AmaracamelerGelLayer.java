package com.sophicreeper.backmath.core.client.renderer.entity.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sophicreeper.backmath.core.client.model.entity.AmaracamelerModel;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AmaracamelerGelLayer<T extends LivingEntity> extends LayerRenderer<T, AmaracamelerModel<T>> {
    private final EntityModel<T> amaracamelerModel = new AmaracamelerModel<>(0);

    public AmaracamelerGelLayer(IEntityRenderer<T, AmaracamelerModel<T>> entityRenderer) {
        super(entityRenderer);
    }

    @Override
    public void render(MatrixStack matrixStack, IRenderTypeBuffer iRenderTypeBuffer, int i, T t, float v, float v1, float v2, float v3, float v4, float v5) {
        if (!t.isInvisible()) {
            this.getEntityModel().copyModelAttributesTo(this.amaracamelerModel);
            this.amaracamelerModel.setLivingAnimations(t, v, v1, v2);
            this.amaracamelerModel.setRotationAngles(t, v, v1, v3, v4, v5);
            IVertexBuilder vertexBuilder = iRenderTypeBuffer.getBuffer(RenderType.getEntityTranslucent(this.getEntityTexture(t)));
            this.amaracamelerModel.render(matrixStack, vertexBuilder, i, LivingRenderer.getPackedOverlay(t, 0.0f), 1.0f, 1.0f, 1.0f, 1.0f);
        }
    }
}
