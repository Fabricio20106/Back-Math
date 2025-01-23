package com.sophicreeper.backmath.mixin.renderer;

import com.sophicreeper.backmath.util.tag.BMItemTags;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerModel.class)
public class BMPlayerModelMixin<T extends LivingEntity> {
    @Shadow
    @Final
    private ModelRenderer cloak;

    @Inject(method = "setupAnim(Lnet/minecraft/entity/LivingEntity;FFFFF)V", at = @At("TAIL"))
    public void setupAnim(T player, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, CallbackInfo callback) {
        if (player.getItemBySlot(EquipmentSlotType.CHEST).getItem().is(BMItemTags.OUTFITS)) {
            if (player.isCrouching()) {
                this.cloak.z = 1.4F;
                this.cloak.y = 1.85F;
            } else {
                this.cloak.z = 0;
                this.cloak.y = 0;
            }
        }
    }
}
