package com.sophicreeper.backmath.mixin.container;

import com.sophicreeper.backmath.util.tag.BMItemTags;
import net.minecraft.block.Block;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.inventory.container.ShulkerBoxSlot;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShulkerBoxSlot.class)
public class BMShulkerBoxSlotMixin {
    @Inject(method = "mayPlace", at = @At("HEAD"), cancellable = true)
    public void mayPlace(ItemStack stack, CallbackInfoReturnable<Boolean> callback) {
        callback.setReturnValue(!(Block.byItem(stack.getItem()) instanceof ShulkerBoxBlock) && !stack.getItem().is(BMItemTags.CRATES));
    }
}
