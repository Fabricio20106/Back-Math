package com.sophicreeper.backmath.item.custom.tool;

import com.sophicreeper.backmath.item.behavior.ItemBehavior;
import com.sophicreeper.backmath.item.custom.behavior.BMSwordItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class ButterSwordItem extends BMSwordItem {
    public ButterSwordItem(Supplier<ItemBehavior> behavior, IItemTier tier, int attackDamage, float swingSpeed, Properties properties) {
        super(behavior, tier, attackDamage, swingSpeed, properties);
        this.cancelAttackBehavior = true;
    }

    @Override
    @Nonnull
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livEntity) {
        if (livEntity instanceof PlayerEntity) this.getBehavior().get().run(stack, (PlayerEntity) livEntity, livEntity, world);
        return super.finishUsingItem(stack, world, livEntity);
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
