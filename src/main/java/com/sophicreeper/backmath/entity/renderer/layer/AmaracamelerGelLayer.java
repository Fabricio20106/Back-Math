package com.sophicreeper.backmath.entity.renderer.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sophicreeper.backmath.entity.model.AmaracamelerModel;
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
    private final EntityModel<T> model = new AmaracamelerModel<>();

    public AmaracamelerGelLayer(IEntityRenderer<T, AmaracamelerModel<T>> renderer) {
        super(renderer);
    }

    @Override
    public void render(MatrixStack stack, IRenderTypeBuffer buffer, int packedLight, T mob, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!mob.isInvisible()) {
            this.getParentModel().copyPropertiesTo(this.model);
            this.model.prepareMobModel(mob, limbSwing, limbSwingAmount, partialTicks);
            this.model.setupAnim(mob, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            IVertexBuilder vertexBuilder = buffer.getBuffer(RenderType.entityTranslucent(this.getTextureLocation(mob)));
            this.model.renderToBuffer(stack, vertexBuilder, packedLight, LivingRenderer.getOverlayCoords(mob, 0), 1, 1, 1, 1);
        }
    }
}
