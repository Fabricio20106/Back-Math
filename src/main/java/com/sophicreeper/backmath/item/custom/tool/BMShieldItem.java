package com.sophicreeper.backmath.item.custom.tool;

import com.sophicreeper.backmath.util.tag.BMItemTags;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BMShieldItem extends ShieldItem {
    public BMShieldItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isShield(ItemStack stack, @Nullable LivingEntity livEntity) {
        return stack.getItem().is(BMItemTags.SHIELDS);
    }

    @Override
    @Nonnull
    public String getDescriptionId(ItemStack stack) {
        return this.getDescriptionId();
    }
}
