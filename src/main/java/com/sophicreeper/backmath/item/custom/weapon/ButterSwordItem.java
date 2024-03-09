package com.sophicreeper.backmath.item.custom.weapon;

import com.sophicreeper.backmath.BackMath;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ButterSwordItem extends SwordItem {
    public ButterSwordItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    // When player stops using item (i.e. stops using a bow (shooting), finished eating/drinking):
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity livEntity) {
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
        return super.onItemUseFinish(stack, world, livEntity);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        if (stack.hasTag() && stack.getTag().contains("stored_experience")) {
            tooltip.add(new TranslationTextComponent("messages." + BackMath.MOD_ID + ".butter_sword.experience_points", stack.getTag().getInt("stored_experience")));
        } else {
            tooltip.add(new TranslationTextComponent("messages." + BackMath.MOD_ID + ".butter_sword.experience_points", 500));
        }
        super.addInformation(stack, world, tooltip, flag);
    }
}
