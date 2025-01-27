package com.sophicreeper.backmath.item.behavior.effecttype;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.List;

// there's a non-zero chance I make this data-driven like consumable behaviors in the future ~isa 24-1-25
public abstract class ItemBehaviorEffectType extends ForgeRegistryEntry<ItemBehaviorEffectType> {
    public abstract void runBehavior(ItemStack stack, PlayerEntity attacker, LivingEntity target, World world);

    public List<ITextComponent> addToTooltip(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        return tooltip;
    }
}
