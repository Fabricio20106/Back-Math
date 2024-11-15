package com.sophicreeper.backmath.mixin.renderer;

import com.sophicreeper.backmath.item.AxolotlTest;
import com.sophicreeper.backmath.item.custom.tool.JanticRailgunItem;
import com.sophicreeper.backmath.util.tag.BMItemTags;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerRenderer.class)
public class BMPlayerRendererMixin {
    @Inject(method = "getArmPose", at = @At("HEAD"), cancellable = true)
    private static void getArmPose(AbstractClientPlayerEntity player, Hand hand, CallbackInfoReturnable<BipedModel.ArmPose> cir) {
        ItemStack handStack = player.getItemInHand(hand);
        if (!handStack.isEmpty() && !player.swinging) {
            if (handStack.getItem() == AxolotlTest.JANTIC_RAILGUN.get() && JanticRailgunItem.isCharged(handStack)) {
                cir.setReturnValue(BipedModel.ArmPose.CROSSBOW_HOLD);
            }
            if (handStack.getItem().is(BMItemTags.DUAL_WIELDED)) {
                cir.setReturnValue(BipedModel.ArmPose.CROSSBOW_CHARGE);
            }
        }
    }
}
