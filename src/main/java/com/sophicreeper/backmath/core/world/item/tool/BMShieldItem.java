package com.sophicreeper.backmath.core.world.item.tool;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class BMShieldItem extends ShieldItem {
    public BMShieldItem(Properties properties) {
        super(properties);
    }

    //@Override
    //public boolean isShield(ItemStack stack, @Nullable LivingEntity entity) {
    //    return true;
    //}

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag tooltipFlag) {}

    @Override
    public String getDescriptionId(ItemStack stack) {
        return this.getDescriptionId();
    }
}
