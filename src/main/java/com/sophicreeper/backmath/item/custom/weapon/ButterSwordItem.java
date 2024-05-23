package com.sophicreeper.backmath.item.custom.weapon;

import com.sophicreeper.backmath.BackMath;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.*;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ButterSwordItem extends SwordItem {
    public ButterSwordItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    // When player stops using item (i.e. stops using a bow (shooting), finished eating/drinking):
    @Override
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livEntity) {
        if (livEntity instanceof PlayerEntity) {
            int storedExperience = stack.getOrCreateTag().getInt("stored_experience");
            if (stack.hasTag()) {
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
        if (stack.hasTag() && stack.getTag().contains("stored_experience")) {
            tooltip.add(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".butter_sword.experience_points", new StringTextComponent("" + stack.getTag().getInt("stored_experience")).withStyle(Style.EMPTY.withColor(
                    Color.fromRgb(8453920)))).withStyle(TextFormatting.GRAY));
        } else {
            tooltip.add(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".butter_sword.experience_points", new StringTextComponent("" + 500).withStyle(Style.EMPTY.withColor(Color.fromRgb(8453920)))
                    .withStyle(TextFormatting.GRAY)));
        }
        super.appendHoverText(stack, world, tooltip, flag);
    }

    @Override
    public void fillItemCategory(ItemGroup tab, NonNullList<ItemStack> items) {
        if (this.allowdedIn(tab)) {
            // Default Butter Sword (500 XP)
            items.add(new ItemStack(this));

            // Actual Butter Sword (55 XP)
            ItemStack stack = new ItemStack(this);
            CompoundNBT tag = stack.getOrCreateTag();
            tag.putInt("stored_experience", 55);
            items.add(stack);
        }
    }
}
