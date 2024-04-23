package com.sophicreeper.backmath.item.custom.weapon.milked;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.config.BMConfigs;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class MilkedButterSwordItem extends SwordItem {
    public MilkedButterSwordItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livEntity) {
        if (livEntity instanceof PlayerEntity) {
            int storedExperience = stack.getOrCreateTag().getInt("stored_experience");
            if (stack.hasTag()) {
                ((PlayerEntity) livEntity).giveExperiencePoints(storedExperience);
            } else {
                ((PlayerEntity) livEntity).giveExperiencePoints(500);
            }
        }
        return super.finishUsingItem(stack, world, livEntity);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (BMConfigs.COMMON_CONFIGS.milkedSwordsEnabled.get()) player.addItem(new ItemStack(Items.MILK_BUCKET));
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        if (stack.hasTag() && stack.getTag().contains("experience_points")) {
            tooltip.add(new TranslationTextComponent("messages." + BackMath.MOD_ID + ".butter_sword.experience_points", stack.getTag().getInt("stored_experience")));
        } else {
            tooltip.add(new TranslationTextComponent("messages." + BackMath.MOD_ID + ".butter_sword.experience_points", 500));
        }
        super.appendHoverText(stack, world, tooltip, flag);
    }

    @Override
    public void fillItemCategory(ItemGroup group, NonNullList<ItemStack> items) {
        if (this.allowdedIn(group)) {
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
