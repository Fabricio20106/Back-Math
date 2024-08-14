package com.sophicreeper.backmath.item.custom.tool;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.item.custom.ToolBehaviors;
import com.sophicreeper.backmath.util.BMUtils;
import com.sophicreeper.backmath.util.TagTypes;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.*;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class MilkedButterSwordItem extends SwordItem implements ToolBehaviors {
    public MilkedButterSwordItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    @Override
    @Nonnull
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livEntity) {
        if (livEntity instanceof PlayerEntity) {
            if (stack.getTag() != null && stack.getTag().contains("stored_experience", TagTypes.INTEGER)) {
                int storedExperience = stack.getTag().getInt("stored_experience");
                ((PlayerEntity) livEntity).giveExperiencePoints(storedExperience);
            } else {
                ((PlayerEntity) livEntity).giveExperiencePoints(500);
            }
        }
        return super.finishUsingItem(stack, world, livEntity);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        giveMilkedSwordItem(stack, player);
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        if (stack.getTag() != null && stack.getTag().contains("stored_experience", TagTypes.INTEGER)) {
            tooltip.add(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".butter_sword.experience_points", new StringTextComponent("" + stack.getTag().getInt("stored_experience")).withStyle(BMUtils.EXPERIENCE)).withStyle(
                    TextFormatting.GRAY));
        } else {
            tooltip.add(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".butter_sword.experience_points", new StringTextComponent("" + 500).withStyle(BMUtils.EXPERIENCE)).withStyle(TextFormatting.GRAY));
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
