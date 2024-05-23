package com.sophicreeper.backmath.entity.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.custom.Amaracameler;
import com.sophicreeper.backmath.entity.model.AmaracamelerModel;
import com.sophicreeper.backmath.entity.renderer.layer.AmaracamelerGelLayer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AmaracamelerRenderer extends MobRenderer<Amaracameler, AmaracamelerModel<Amaracameler>> {
    public AmaracamelerRenderer(EntityRendererManager manager) {
        super(manager, new AmaracamelerModel<>(16), 0.25F);
        this.addLayer(new AmaracamelerGelLayer<>(this));
    }

    @Override
    public void render(Amaracameler amaracameler, float yaw, float partialTicks, MatrixStack stack, IRenderTypeBuffer buffer, int packedLight) {
        this.shadowRadius = 0.25F * (float) amaracameler.getSize();
        super.render(amaracameler, yaw, partialTicks, stack, buffer, packedLight);
    }

    @Override
    protected void scale(Amaracameler amaracameler, MatrixStack matrixStack, float partialTicks) {
        matrixStack.scale(0.999F, 0.999F, 0.999F);
        matrixStack.translate(0, 0.0010000000474974513, 0);
        float amaracamelerSize = (float) amaracameler.getSize();
        float squishFactor = MathHelper.lerp(partialTicks, amaracameler.previousSquishFactor, amaracameler.squishFactor) / (amaracamelerSize * 0.5F + 1);
        float f3 = 1 / (squishFactor + 1);
        matrixStack.scale(f3 * amaracamelerSize, 1 / f3 * amaracamelerSize, f3 * amaracamelerSize);
    }

    @Override
    public ResourceLocation getTextureLocation(Amaracameler amaracameler) {
        return BackMath.resourceLoc("textures/entity/amaracameler.png");
    }
}
