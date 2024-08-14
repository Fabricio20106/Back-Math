package com.sophicreeper.backmath.item.custom.tool.misc;

import com.google.common.collect.Lists;
import com.sophicreeper.backmath.item.custom.ToolBehaviors;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class PinkGumFryingPanItem extends Item implements ToolBehaviors {
    public PinkGumFryingPanItem(Properties properties) {
        super(properties);
    }

    @Override
    @Nonnull
    public List<EffectInstance> getAppliedEffects() {
        return Lists.newArrayList(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 200, 3), new EffectInstance(Effects.HARM, 200, 0));
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof LivingEntity) applyTagEffects(stack, (LivingEntity) entity);
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        tooltip.add(new TranslationTextComponent(this.getDescriptionId() + ".desc"));
    }
}
