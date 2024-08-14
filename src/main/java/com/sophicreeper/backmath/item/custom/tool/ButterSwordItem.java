package com.sophicreeper.backmath.item.custom.tool;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.util.BMUtils;
import com.sophicreeper.backmath.util.TagTypes;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.*;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class ButterSwordItem extends SwordItem {
    public ButterSwordItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    @Override
    @Nonnull
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livEntity) {
        if (livEntity instanceof PlayerEntity) {
            if (stack.getTag() != null && stack.getTag().contains("stored_experience", TagTypes.INTEGER)) {
                int storedExperience = stack.getTag().getInt("stored_experience");
                // Gives the player the amount of points in the "stored_experience" tag.
                ((PlayerEntity) livEntity).giveExperiencePoints(storedExperience);
            } else {
                // Gives the player 500 experience points (XP points).
                ((PlayerEntity) livEntity).giveExperiencePoints(500);
            }
        }
        return super.finishUsingItem(stack, world, livEntity);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        if (stack.getTag() != null && stack.getTag().contains("stored_experience", TagTypes.INTEGER)) {
            tooltip.add(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".butter_sword.experience_points", new StringTextComponent("" + stack.getTag().getInt("stored_experience")).withStyle(BMUtils.EXPERIENCE)).withStyle(
                    TextFormatting.GRAY));
        } else {
            tooltip.add(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".butter_sword.experience_points", new StringTextComponent(Integer.toString(500)).withStyle(BMUtils.EXPERIENCE)).withStyle(TextFormatting.GRAY));
        }
    }

    @Override
    public void fillItemCategory(ItemGroup tab, NonNullList<ItemStack> list) {
        if (this.allowdedIn(tab)) {
            // Default Butter Sword (500 XP)
            list.add(new ItemStack(this));

            // Actual Butter Sword (55 XP)
            ItemStack stack = new ItemStack(this);
            stack.getOrCreateTag().putInt("stored_experience", 55);
            list.add(stack);
        }
    }
}
