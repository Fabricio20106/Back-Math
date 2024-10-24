package com.sophicreeper.backmath.entity.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.sophicreeper.backmath.entity.model.BMArmorModel;
import com.sophicreeper.backmath.entity.model.BMPlayerModel;
import com.sophicreeper.backmath.util.tag.BMItemTags;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.HeadLayer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BMPlayerRenderer<T extends CreatureEntity> extends BipedRenderer<T, BMPlayerModel<T>> {
    public boolean enableDefaultElytra = true;

    public BMPlayerRenderer(EntityRendererManager manager, float shadowSize, boolean slimArms) {
        this(manager, new BMPlayerModel<>(0, 0, 64, 64, slimArms), shadowSize);
    }

    public BMPlayerRenderer(EntityRendererManager manager, BMPlayerModel<T> model, float shadowSize) {
        super(manager, model, shadowSize);
        this.addLayer(new BipedArmorLayer<>(this, new BMArmorModel<>(0.5F, 0, 64, 32), new BMArmorModel<>(1, 0, 64, 32)));
        this.addLayer(new HeldItemLayer<>(this));
        this.addLayer(new HeadLayer<>(this));
        if (this.enableDefaultElytra) this.addLayer(new ElytraLayer<>(this));
    }

    @Override
    public void render(T mob, float yaw, float partialTicks, MatrixStack stack, IRenderTypeBuffer buffer, int packedLight) {
        this.setModelVisibilities(mob);
        super.render(mob, yaw, partialTicks, stack, buffer, packedLight);
    }

    @Override
    protected void scale(T mob, MatrixStack stack, float partialTickTime) {
        stack.scale(0.9375F, 0.9375F, 0.9375F);
    }

    @Override
    protected void setupRotations(T mob, MatrixStack stack, float ageInTicks, float yaw, float partialTicks) {
        float swimAmount = mob.getSwimAmount(partialTicks);
        if (mob.isFallFlying()) {
            super.setupRotations(mob, stack, ageInTicks, yaw, partialTicks);
            float fallFlyingTicks = (float) mob.getFallFlyingTicks() + partialTicks;
            float f = MathHelper.clamp(fallFlyingTicks * fallFlyingTicks / 100, 0, 1);
            if (!mob.isAutoSpinAttack()) stack.mulPose(Vector3f.XP.rotationDegrees(f * (-90 - mob.xRot)));

            Vector3d viewVector = mob.getViewVector(partialTicks);
            Vector3d deltaMovement = mob.getDeltaMovement();
            double deltaMovementSqr = Entity.getHorizontalDistanceSqr(deltaMovement);
            double viewVectorSqr = Entity.getHorizontalDistanceSqr(viewVector);
            if (deltaMovementSqr > 0 && viewVectorSqr > 0) {
                double d1 = (deltaMovement.x * viewVector.x + deltaMovement.z * viewVector.z) / Math.sqrt(deltaMovementSqr * viewVectorSqr);
                double d2 = deltaMovement.x * viewVector.z - deltaMovement.z * viewVector.x;
                stack.mulPose(Vector3f.YP.rotation((float)(Math.signum(d2) * Math.acos(d1))));
            }
        } else if (swimAmount > 0) {
            super.setupRotations(mob, stack, ageInTicks, yaw, partialTicks);
            float f1 = mob.isInWater() ? -90 - mob.xRot : -90;
            float f2 = MathHelper.lerp(swimAmount, 0, f1);
            stack.mulPose(Vector3f.XP.rotationDegrees(f2));
            if (mob.isVisuallySwimming()) {
                stack.translate(0, -1, 0.3F);
            }
        } else {
            super.setupRotations(mob, stack, ageInTicks, yaw, partialTicks);
        }
    }

    private BipedModel.ArmPose getArmPose(T mob, Hand hand) {
        ItemStack heldStack = mob.getItemInHand(hand);
        boolean acceptableCrossbows = heldStack.getItem().is(BMItemTags.CROSSBOWS);

        if (heldStack.isEmpty()) {
            return BipedModel.ArmPose.EMPTY;
        } else {
            if (mob.getUsedItemHand() == hand && mob.getUseItemRemainingTicks() > 0) {
                UseAction useAction = heldStack.getUseAnimation();
                if (useAction == UseAction.BLOCK) {
                    return BipedModel.ArmPose.BLOCK;
                }

                if (useAction == UseAction.BOW) {
                    return BipedModel.ArmPose.BOW_AND_ARROW;
                }

                if (useAction == UseAction.SPEAR) {
                    return BipedModel.ArmPose.THROW_SPEAR;
                }

                if (useAction == UseAction.CROSSBOW && hand == mob.getUsedItemHand()) {
                    return BipedModel.ArmPose.CROSSBOW_CHARGE;
                }
            } else if (!mob.swinging && acceptableCrossbows && CrossbowItem.isCharged(heldStack)) {
                return BipedModel.ArmPose.CROSSBOW_HOLD;
            }

            return BipedModel.ArmPose.ITEM;
        }
    }

    private void setModelVisibilities(T mob) {
        BMPlayerModel<T> mobModel = this.getModel();

        mobModel.setAllVisible(true);
        BipedModel.ArmPose mainHandPose = getArmPose(mob, Hand.MAIN_HAND);
        BipedModel.ArmPose offHandPose = getArmPose(mob, Hand.OFF_HAND);

        if (mainHandPose.isTwoHanded()) {
            offHandPose = mob.getOffhandItem().isEmpty() ? BipedModel.ArmPose.EMPTY : BipedModel.ArmPose.ITEM;
        }

        if (mob.getMainArm() == HandSide.RIGHT) {
            mobModel.rightArmPose = mainHandPose;
            mobModel.leftArmPose = offHandPose;
        } else {
            mobModel.rightArmPose = offHandPose;
            mobModel.leftArmPose = mainHandPose;
        }
    }
}
