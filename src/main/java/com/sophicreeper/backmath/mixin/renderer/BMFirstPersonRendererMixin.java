package com.sophicreeper.backmath.mixin.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.sophicreeper.backmath.util.tag.BMItemTags;
import net.minecraft.client.renderer.FirstPersonRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FirstPersonRenderer.class)
public class BMFirstPersonRendererMixin {
    @Shadow
    @Final
    private ItemRenderer itemRenderer;

    @Inject(method = "renderItem", at = @At("HEAD"), cancellable = true)
    public void renderItem(LivingEntity livEntity, ItemStack stack, ItemCameraTransforms.TransformType transformType, boolean bool, MatrixStack mStack, IRenderTypeBuffer buffer, int packedLight, CallbackInfo ci) {
        if (!stack.isEmpty() && stack.getItem().is(BMItemTags.FULLY_LIT_ITEMS)) {
            ci.cancel();
            this.itemRenderer.renderStatic(livEntity, stack, transformType, bool, mStack, buffer, livEntity.level, LightTexture.pack(15, 15), OverlayTexture.NO_OVERLAY);
        }
    }
}
