package com.sophicreeper.backmath.item.custom.food.drink;

import com.sophicreeper.backmath.block.dispenser.TeaDispenseBehavior;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class AljameTeacupItem extends Item {
    public AljameTeacupItem(Properties properties) {
        super(properties);
        DispenserBlock.registerDispenseBehavior(this, new TeaDispenseBehavior());
    }

    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        return DrinkHelper.startDrinking(world, player, hand);
    }
}
