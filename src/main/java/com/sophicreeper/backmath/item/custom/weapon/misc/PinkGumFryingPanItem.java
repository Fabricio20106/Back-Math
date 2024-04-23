package com.sophicreeper.backmath.item.custom.weapon.misc;

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

import javax.annotation.Nullable;
import java.util.List;

public class PinkGumFryingPanItem extends Item {
    public PinkGumFryingPanItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livEntity = (LivingEntity) entity;
            livEntity.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 10, 3));
            livEntity.addEffect(new EffectInstance(Effects.HARM, 10, 0));
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent(this.getDescriptionId() + ".desc"));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}
