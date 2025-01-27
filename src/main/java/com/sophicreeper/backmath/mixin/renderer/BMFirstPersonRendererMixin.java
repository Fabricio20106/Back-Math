package com.sophicreeper.backmath.mixin.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.sophicreeper.backmath.item.custom.tool.JanticRailgunItem;
import com.sophicreeper.backmath.util.tag.BMItemTags;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.FirstPersonRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FirstPersonRenderer.class)
public abstract class BMFirstPersonRendererMixin {
    @Shadow
    @Final
    private ItemRenderer itemRenderer;
    @Shadow
    protected abstract void applyItemArmTransform(MatrixStack stack, HandSide side, float equippedProgress);
    @Shadow
    protected abstract void applyItemArmAttackTransform(MatrixStack stack, HandSide side, float swingProgress);
    @Shadow
    public abstract void renderItem(LivingEntity livEntity, ItemStack handStack, ItemCameraTransforms.TransformType transformType, boolean leftHand, MatrixStack stack, IRenderTypeBuffer buffer, int packedLight);

    @Inject(method = "renderItem", at = @At("HEAD"), cancellable = true)
    public void renderItemMixin(LivingEntity livEntity, ItemStack stack, ItemCameraTransforms.TransformType transformType, boolean leftHand, MatrixStack mStack, IRenderTypeBuffer buffer, int packedLight, CallbackInfo callback) {
        if (!stack.isEmpty() && stack.getItem().is(BMItemTags.FULLY_LIT_ITEMS)) {
            callback.cancel();
            this.itemRenderer.renderStatic(livEntity, stack, transformType, leftHand, mStack, buffer, livEntity.level, LightTexture.pack(15, 15), OverlayTexture.NO_OVERLAY);
        }
    }

    @Inject(method = "renderArmWithItem", at = @At("HEAD"), cancellable = true)
    private void renderArmWithItem(AbstractClientPlayerEntity player, float partialTicks, float pitch, Hand hand, float swingProgress, ItemStack handStack, float equippedProgress, MatrixStack stack, IRenderTypeBuffer buffer, int packedLight, CallbackInfo callback) {
        boolean inMainHand = player.getItemBySlot(EquipmentSlotType.MAINHAND).getItem().is(BMItemTags.RAILGUNS) && hand == Hand.OFF_HAND;
        boolean inOffHand = player.getItemBySlot(EquipmentSlotType.OFFHAND).getItem().is(BMItemTags.RAILGUNS) && hand == Hand.MAIN_HAND;
        if (inMainHand || inOffHand) callback.cancel();

        if (handStack.getItem().is(BMItemTags.RAILGUNS)) {
            callback.cancel();
            stack.pushPose();
            HandSide side = hand == Hand.MAIN_HAND ? player.getMainArm() : player.getMainArm().getOpposite();
            boolean charged = JanticRailgunItem.isCharged(handStack);
            boolean rightHand = side == HandSide.RIGHT;
            int offset = rightHand ? 1 : -1;

            if (player.isUsingItem() && player.getUseItemRemainingTicks() > 0 && player.getUsedItemHand() == hand) {
                this.applyItemArmTransform(stack, side, equippedProgress);
                stack.translate(offset * -0.4785682, -0.094387, 0.05731531);
                stack.mulPose(Vector3f.XP.rotationDegrees(-11.935F));
                stack.mulPose(Vector3f.YP.rotationDegrees(offset * 65.3F));
                stack.mulPose(Vector3f.ZP.rotationDegrees(offset * -9.785F));

                float useDuration = handStack.getUseDuration() - (Minecraft.getInstance().player.getUseItemRemainingTicks() - partialTicks + 1);
                float chargeDuration = useDuration / JanticRailgunItem.getChargeDuration(handStack);

                if (chargeDuration > 1) chargeDuration = 1;

                if (chargeDuration > 0.1F) {
                    float f = MathHelper.sin((useDuration - 0.1F) * 1.3F);
                    float f1 = chargeDuration - 0.1F;
                    float f2 = f * f1;
                    stack.translate(f2 * 0, f2 * 0.004, f2 * 0);
                }

                stack.translate(chargeDuration * 0, chargeDuration * 0, chargeDuration * 0.04);
                stack.scale(1, 1, 1 + chargeDuration * 0.2F);
                stack.mulPose(Vector3f.YN.rotationDegrees(offset * 45));
            } else {
                float f = -0.4F * MathHelper.sin(MathHelper.sqrt(swingProgress) * (float) Math.PI);
                float f1 = 0.2F * MathHelper.sin(MathHelper.sqrt(swingProgress) * ((float) Math.PI * 2));
                float f2 = -0.2F * MathHelper.sin(swingProgress * (float) Math.PI);
                stack.translate(offset * f, f1, f2);
                this.applyItemArmTransform(stack, side, equippedProgress);
                this.applyItemArmAttackTransform(stack, side, swingProgress);
                if (charged && swingProgress < 0.001F) {
                    stack.translate(offset * -0.641864F, 0, 0);
                    stack.mulPose(Vector3f.YP.rotationDegrees(offset * 10));
                }
            }

            this.renderItem(player, handStack, rightHand ? ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND : ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND, !rightHand, stack, buffer, packedLight);
            stack.popPose();
        }
    }
}
