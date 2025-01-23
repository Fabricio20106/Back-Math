package com.sophicreeper.backmath.mixin.item;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.util.BMKeys;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Item.class) // I can't live without Variants' item tag tooltip
public class BMItemMixin {
    @OnlyIn(Dist.CLIENT)
    @Inject(method = "appendHoverText", at = @At("HEAD"))
    public void appendHoverText(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag, CallbackInfo callback) {
        if (flag.isAdvanced() && stack.getTag() != null && Minecraft.getInstance().getLaunchedVersion().contains("melony-studios-dev")) {
            if (!BMKeys.isShiftDown()) tooltip.add(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".hold_shift", BMKeys.getTranslation(BMKeys.SHOW_TOOLTIPS_KEY).withStyle(TextFormatting.GRAY)).withStyle(TextFormatting.DARK_GRAY));
            if (BMKeys.isShiftDown()) tooltip.add(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".hold_shift", BMKeys.getTranslation(BMKeys.SHOW_TOOLTIPS_KEY).withStyle(TextFormatting.WHITE)).withStyle(TextFormatting.DARK_GRAY));
            if (BMKeys.isShiftDown()) addItemTagsTooltip(stack, tooltip, flag);
        }
    }

    private static void addItemTagsTooltip(ItemStack stack, List<ITextComponent> tooltip, ITooltipFlag flag) {
        if (flag.isAdvanced()) {
            CompoundNBT tagTag = stack.getTag();
            if (tagTag != null) {
                tooltip.add(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".tags", tagTag.getPrettyDisplay(" ", 0)).withStyle(TextFormatting.GRAY));
            }
        }
    }
}
