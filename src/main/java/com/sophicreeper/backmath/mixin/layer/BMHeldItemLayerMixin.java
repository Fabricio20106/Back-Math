package com.sophicreeper.backmath.mixin.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.sophicreeper.backmath.util.tag.BMItemTags;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.IHasArm;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.vector.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeldItemLayer.class)
public abstract class BMHeldItemLayerMixin<T extends LivingEntity, M extends EntityModel<T> & IHasArm> extends LayerRenderer<T, M> {
    public BMHeldItemLayerMixin(IEntityRenderer<T, M> renderer) {
        super(renderer);
    }

    @Inject(method = "renderArmWithItem", at = @At("HEAD"), cancellable = true)
    private void renderArmWithItem(LivingEntity livEntity, ItemStack stack, ItemCameraTransforms.TransformType transformType, HandSide side, MatrixStack mStack, IRenderTypeBuffer buffer, int packedLight, CallbackInfo ci) {
        if (!stack.isEmpty() && stack.getItem().is(BMItemTags.FULLY_LIT_ITEMS)) {
            ci.cancel();
            mStack.pushPose();
            this.getParentModel().translateToHand(side, mStack);
            mStack.mulPose(Vector3f.XP.rotationDegrees(-90));
            mStack.mulPose(Vector3f.YP.rotationDegrees(180));
            boolean leftSide = side == HandSide.LEFT;
            mStack.translate((float) (leftSide ? -1 : 1) / 16, 0.125D, -0.625D);
            Minecraft.getInstance().getItemInHandRenderer().renderItem(livEntity, stack, transformType, leftSide, mStack, buffer, LightTexture.pack(15, 15));
            mStack.popPose();
        }
    }
}
