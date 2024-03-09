package com.sophicreeper.backmath.entity.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.sophicreeper.backmath.entity.model.BMBipedModel;
import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BMBipedRenderer<T extends CreatureEntity> extends BipedRenderer<T, BMBipedModel<T>> {
    public BMBipedRenderer(EntityRendererManager manager, float shadowSize) {
        this(manager, new BMBipedModel<>(0, 0, 64, 64), shadowSize);
        this.addLayer(new ElytraLayer<>(this));
    }

    public BMBipedRenderer(EntityRendererManager manager, BMBipedModel<T> model, float shadowSize) {
        super(manager, model, shadowSize);
        this.addLayer(new ElytraLayer<>(this));
    }

    @Override
    public void render(T mob, float yaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight) {
        this.setModelVisibilities(mob);
        super.render(mob, yaw, partialTicks, matrixStack, buffer, packedLight);
    }

    @Override
    protected void preRenderCallback(T mob, MatrixStack matrixStack, float partialTickTime) {
        matrixStack.scale(0.9375F, 0.9375F, 0.9375F);
    }

    private BipedModel.ArmPose getArmPose(T mob, Hand hand) {
        ItemStack heldStack = mob.getHeldItem(hand);
        boolean acceptableCrossbows = heldStack.getItem() == Items.CROSSBOW || heldStack.getItem() == AxolotlTest.DEVIL_CROSSBOW.get() || heldStack.getItem() == AxolotlTest.ANGELIC_CROSSBOW.get();

        if (heldStack.isEmpty()) {
            return BipedModel.ArmPose.EMPTY;
        } else {
            if (mob.getActiveHand() == hand && mob.getItemInUseCount() > 0) {
                UseAction useAction = heldStack.getUseAction();
                if (useAction == UseAction.BLOCK) {
                    return BipedModel.ArmPose.BLOCK;
                }

                if (useAction == UseAction.BOW) {
                    return BipedModel.ArmPose.BOW_AND_ARROW;
                }

                if (useAction == UseAction.SPEAR) {
                    return BipedModel.ArmPose.THROW_SPEAR;
                }

                if (useAction == UseAction.CROSSBOW && hand == mob.getActiveHand()) {
                    return BipedModel.ArmPose.CROSSBOW_CHARGE;
                }
            } else if (!mob.isSwingInProgress && acceptableCrossbows && CrossbowItem.isCharged(heldStack)) {
                return BipedModel.ArmPose.CROSSBOW_HOLD;
            }

            return BipedModel.ArmPose.ITEM;
        }
    }

    private void setModelVisibilities(T mob) {
        BMBipedModel<T> mobModel = this.getEntityModel();

        mobModel.setVisible(true);
        BipedModel.ArmPose mainHandPose = getArmPose(mob, Hand.MAIN_HAND);
        BipedModel.ArmPose offHandPose = getArmPose(mob, Hand.OFF_HAND);

        if (mainHandPose.func_241657_a_()) {
            offHandPose = mob.getHeldItemOffhand().isEmpty() ? BipedModel.ArmPose.EMPTY : BipedModel.ArmPose.ITEM;
        }

        if (mob.getPrimaryHand() == HandSide.RIGHT) {
            mobModel.rightArmPose = mainHandPose;
            mobModel.leftArmPose = offHandPose;
        } else {
            mobModel.rightArmPose = offHandPose;
            mobModel.leftArmPose = mainHandPose;
        }
    }
}
