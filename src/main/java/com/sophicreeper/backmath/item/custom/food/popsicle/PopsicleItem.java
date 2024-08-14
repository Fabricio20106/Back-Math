package com.sophicreeper.backmath.item.custom.food.popsicle;

import com.sophicreeper.backmath.item.custom.ToolBehaviors;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class PopsicleItem extends Item implements ToolBehaviors {
    public PopsicleItem(Properties properties) {
        super(properties);
    }

    @Override
    @Nonnull
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity livEntity) {
        ItemStack superStack = super.finishUsingItem(stack, world, livEntity);
        return livEntity instanceof PlayerEntity && ((PlayerEntity) livEntity).abilities.instabuild ? superStack : getFoodContainerItem(stack, new ItemStack(Items.STICK));
    }
}
