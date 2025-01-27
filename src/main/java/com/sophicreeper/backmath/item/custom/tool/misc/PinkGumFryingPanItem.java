package com.sophicreeper.backmath.item.custom.tool.misc;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.item.behavior.ItemBehavior;
import com.sophicreeper.backmath.item.behavior.effecttype.ItemBehaviorEffectType;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class PinkGumFryingPanItem extends Item {
    private final Supplier<ItemBehavior> behavior;

    public PinkGumFryingPanItem(Supplier<ItemBehavior> behavior, Properties properties) {
        super(properties);
        this.behavior = behavior;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity attacker, Entity target) {
        if (target instanceof LivingEntity) this.behavior.get().run(stack, attacker, (LivingEntity) target, target.level);
        return super.onLeftClickEntity(stack, attacker, target);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        tooltip.add(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".pink_gum_frying_pan").withStyle(TextFormatting.GRAY));
        if (!this.behavior.get().effects.isEmpty()) tooltip.add(new TranslationTextComponent("tooltip.backmath.behavior.when_used").withStyle(TextFormatting.GRAY));
        for (Supplier<ItemBehaviorEffectType> type : this.behavior.get().effects) {
            if (type != null) type.get().addToTooltip(stack, world, tooltip, flag);
        }
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return this.behavior.get().hasGlint(stack) || super.isFoil(stack);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return this.behavior.get().getDurabilityBarColor(super.getRGBDurabilityForDisplay(stack));
    }
}
