package com.sophicreeper.backmath.item.behavior.effecttype.custom;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.item.behavior.effecttype.ItemBehaviorEffectType;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class DamageEntityEffectType extends ItemBehaviorEffectType {
    private final DamageSource source;
    private final float amount;

    public DamageEntityEffectType(DamageSource source, float amount) {
        this.source = source;
        this.amount = amount;
    }

    public DamageEntityEffectType() {
        this(DamageSource.GENERIC, 0);
    }

    @Override
    public void runBehavior(ItemStack stack, PlayerEntity attacker, LivingEntity target, World world) {
        target.hurt(this.source, this.amount);
    }

    @Override
    public List<ITextComponent> addToTooltip(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.addToTooltip(stack, world, tooltip, flag);
        IFormattableTextComponent component = new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".behavior." + this.source.msgId, this.amount).withStyle(TextFormatting.GRAY);
        tooltip.add(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".behavior.harmful_effect", component).withStyle(TextFormatting.DARK_GRAY));
        return tooltip;
    }
}
