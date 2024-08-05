package com.sophicreeper.backmath.item.custom.tool;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.config.BMConfigs;
import com.sophicreeper.backmath.util.TagTypes;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.*;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class MilkedButterSwordItem extends SwordItem {
    public MilkedButterSwordItem(IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(tier, attackDamage, swingSpeed, properties);
    }

    @Override
    @Nonnull
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livEntity) {
        if (livEntity instanceof PlayerEntity) {
            int storedExperience = stack.getOrCreateTag().getInt("stored_experience");
            if (stack.getTag() != null && stack.getTag().contains("stored_experience", TagTypes.INTEGER)) {
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
        super.appendHoverText(stack, world, tooltip, flag);
        if (stack.getTag() != null && stack.getTag().contains("stored_experience", TagTypes.INTEGER)) {
            tooltip.add(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".butter_sword.experience_points", new StringTextComponent("" + stack.getTag().getInt("stored_experience")).withStyle(Style.EMPTY.withColor(
                    Color.fromRgb(8453920)))).withStyle(TextFormatting.GRAY));
        } else {
            tooltip.add(new TranslationTextComponent("tooltip." + BackMath.MOD_ID + ".butter_sword.experience_points", new StringTextComponent("" + 500).withStyle(Style.EMPTY.withColor(Color.fromRgb(8453920)))
                    ).withStyle(TextFormatting.GRAY));
        }
    }

    @Override
    public void fillItemCategory(ItemGroup tab, NonNullList<ItemStack> list) {
        if (this.allowdedIn(tab)) {
            // Default Butter Sword (500 XP)
            list.add(new ItemStack(this));

            // Actual Butter Sword (55 XP)
            ItemStack stack = new ItemStack(this);
            CompoundNBT tag = stack.getOrCreateTag();
            tag.putInt("stored_experience", 55);
            list.add(stack);
        }
    }
}
